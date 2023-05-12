package cn.devzyh.xhub.notebook.service.impl;

import cn.devzyh.xhub.common.annotation.DataScope;
import cn.devzyh.xhub.common.utils.SecurityUtils;
import cn.devzyh.xhub.notebook.domain.NoteShare;
import cn.devzyh.xhub.notebook.mapper.NoteShareMapper;
import cn.devzyh.xhub.notebook.service.INoteShareService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 笔记分享Service业务层处理
 *
 * @author devzyh
 * @date 2022-05-18
 */
@Service
public class NoteShareServiceImpl implements INoteShareService {

    @Autowired
    private NoteShareMapper noteShareMapper;

    /**
     * 查询笔记分享列表
     *
     * @param noteShare 笔记分享
     * @return 笔记分享
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<NoteShare> selectNoteShareList(IPage<NoteShare> page, NoteShare noteShare) {
        if (page.orders().isEmpty()) {
            page.orders().add(new OrderItem("s.update_time", false));
        }
        return noteShareMapper.selectNoteShareList(page, noteShare);
    }

    /**
     * 查询笔记分享
     *
     * @param contentId 笔记分享主键
     * @return 笔记分享
     */
    @Override
    public NoteShare selectNoteShareByContentId(Long contentId) {
        return noteShareMapper.selectNoteShareByContentId(contentId);
    }

    /**
     * 新增笔记分享
     *
     * @param noteShare 笔记分享
     * @return 结果
     */
    @Override
    public int saveNoteShare(NoteShare noteShare) {
        NoteShare localShare = noteShareMapper.selectNoteShareByContentId(noteShare.getContentId());
        if (localShare == null) {
            return noteShareMapper.insert(noteShare);
        } else {
            if (!SecurityUtils.isOwner(noteShare)) {
                return 0;
            }
            return noteShareMapper.updateById(noteShare);
        }
    }

    /**
     * 修改笔记分享
     *
     * @param noteShare 笔记分享
     * @return 结果
     */
    @Override
    public int updateNoteShare(NoteShare noteShare) {
        if (!SecurityUtils.isOwner(selectNoteShareByContentId(noteShare.getContentId()))) {
            return 0;
        }
        return noteShareMapper.updateById(noteShare);
    }

    /**
     * 批量删除笔记分享
     *
     * @param contentIds 需要删除的笔记分享主键
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteNoteShareByContentIds(List<Long> contentIds) {
        int i = 0;
        for (Long contentId : contentIds) {
            if (!SecurityUtils.isOwner(selectNoteShareByContentId(contentId))) {
                continue;
            }

            i += noteShareMapper.deleteById(contentId);
        }
        return i;
    }

    /**
     * 删除笔记分享信息
     *
     * @param contentId 笔记分享主键
     * @return 结果
     */
    @Override
    public int deleteNoteShareByContentId(Long contentId) {
        return noteShareMapper.deleteById(contentId);
    }
}
