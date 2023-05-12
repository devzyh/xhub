package cn.devzyh.xhub.notebook.service.impl;

import cn.devzyh.xhub.common.annotation.DataScope;
import cn.devzyh.xhub.common.constant.NoteConstants;
import cn.devzyh.xhub.common.core.domain.Result;
import cn.devzyh.xhub.common.core.redis.RedisCache;
import cn.devzyh.xhub.common.utils.DateUtils;
import cn.devzyh.xhub.common.utils.SecurityUtils;
import cn.devzyh.xhub.common.utils.StringUtils;
import cn.devzyh.xhub.common.utils.bean.BeanUtils;
import cn.devzyh.xhub.common.utils.sign.Md5Utils;
import cn.devzyh.xhub.notebook.domain.NoteContent;
import cn.devzyh.xhub.notebook.domain.NoteHistory;
import cn.devzyh.xhub.notebook.mapper.NoteContentMapper;
import cn.devzyh.xhub.notebook.service.INoteContentService;
import cn.devzyh.xhub.notebook.service.INoteHistoryService;
import cn.devzyh.xhub.notebook.service.INoteShareService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * 笔记内容Service业务层处理
 *
 * @author devzyh
 * @date 2022-05-18
 */
@Service
public class NoteContentServiceImpl implements INoteContentService {

    @Autowired
    private NoteContentMapper contentMapper;
    @Autowired
    private INoteHistoryService historyService;
    @Autowired
    private INoteShareService shareService;
    @Autowired
    RedisCache redisCache;

    /**
     * 查询笔记内容列表
     *
     * @param noteContent 笔记内容
     * @return 笔记内容
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<NoteContent> selectNoteContentList(IPage<NoteContent> page, NoteContent noteContent) {
        if (page.orders().isEmpty()) {
            page.orders().add(new OrderItem("update_time", false));
        }
        return contentMapper.selectNoteContentList(page, noteContent);
    }

    /**
     * 查询笔记内容
     *
     * @param id 笔记内容主键
     * @return 笔记内容
     */
    @Override
    public NoteContent selectNoteContentById(Long id) {
        String key = NoteConstants.CONTEN_KEY + id;
        NoteContent content = redisCache.getCacheObject(key);
        if (content != null) {
            return content;
        }

        synchronized (key) {
            content = redisCache.getCacheObject(key);
            if (content != null) {
                return content;
            }

            synchronized (key) {
                content = contentMapper.selectById(id);
                redisCache.setCacheObject(key, content);
            }
        }

        return content;
    }

    /**
     * 新增笔记内容
     *
     * @param noteContent 笔记内容
     * @return 结果
     */
    @Override
    public int insertNoteContent(NoteContent noteContent) {
        return contentMapper.insert(noteContent);
    }

    /**
     * 修改笔记内容
     *
     * @param content 笔记内容
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result updateNoteContent(NoteContent content, boolean allowBlankContent) {
        NoteContent local = contentMapper.selectById(content.getId());

        if (!SecurityUtils.isOwner(local)) {
            return Result.forbidden();
        }

        boolean saveDb = false;
        // 更改了标题
        if (saveDb == false && StringUtils.isNotBlank(content.getTitle()) &&
                !StringUtils.equalsIgnoreCase(content.getTitle(), local.getTitle())) {
            saveDb = true;
        }
        // 更改了目录
        if (saveDb == false && content.getCatalogId() != null && content.getCatalogId() != local.getCatalogId()) {
            saveDb = true;
        }
        // 更改了正文
        if (saveDb == false && (allowBlankContent || StringUtils.isNotBlank(content.getContent())) &&
                !StringUtils.equals(Md5Utils.hash(content.getContent()), Md5Utils.hash(local.getContent()))) {
            saveDb = true;
        }

        if (!saveDb) {
            return Result.success();
        }

        // 保存笔记历史
        if (StringUtils.isNotBlank(local.getContent())) {
            NoteHistory history = new NoteHistory();
            BeanUtils.copyBeanProp(history, local);
            history.setContentId(local.getId());
            historyService.insertNoteHistory(history);
        }

        // 更新缓存
        redisCache.deleteObject(NoteConstants.CONTEN_KEY + content.getId());

        // 允许笔记内容为空值
        if (allowBlankContent && StringUtils.isBlank(content.getContent())) {
            UpdateWrapper<NoteContent> uw = new UpdateWrapper<>();
            uw.set("content", content.getContent());
            uw.eq("id", content.getId());
            contentMapper.update(null, uw);
        }

        // 更新笔记数据
        return Result.of(contentMapper.updateById(content));
    }

    /**
     * 修改笔记缓存
     *
     * @param content 笔记内容
     * @return 结果
     */
    @Override
    public Result updateNoteCache(NoteContent content) {
        NoteContent local = selectNoteContentById(content.getId());
        if (!SecurityUtils.isOwner(local)) {
            return Result.forbidden();
        }

        local.setContent(content.getContent());
        redisCache.setCacheObject(NoteConstants.CONTEN_KEY + content.getId(), local);
        return Result.success();
    }

    /**
     * 批量删除笔记内容
     *
     * @param ids 需要删除的笔记内容主键
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteNoteContentByIds(List<Long> ids) {
        int i = 0;
        for (Long id : ids) {
            i += deleteNoteContentById(id);
        }

        return i;
    }

    /**
     * 删除笔记内容信息
     *
     * @param id 笔记内容主键
     * @return 结果
     */
    @Override
    public int deleteNoteContentById(Long id) {
        if (!SecurityUtils.isOwner(selectNoteContentById(id))) {
            return 0;
        }
        redisCache.deleteObject(NoteConstants.CONTEN_KEY + id);
        shareService.deleteNoteShareByContentIds(Arrays.asList(id));
        return contentMapper.deleteById(id);
    }

    @Override
    public long selectCountByCatalogIds(List<Long> ids) {
        QueryWrapper<NoteContent> qw = new QueryWrapper<>();
        qw.in("catalog_id", ids);
        return contentMapper.selectCount(qw);
    }

    @Override
    public List<NoteContent> selectYesterdayContents() {
        QueryWrapper<NoteContent> qw = new QueryWrapper<>();
        LocalDate yesterday = LocalDate.now().plusDays(-1);
        String date = yesterday.format(DateUtils.DTF_DATE);
        qw.between("update_time", date + " 00:00:00", date + " 23:59:59");
        return contentMapper.selectList(qw);
    }
}
