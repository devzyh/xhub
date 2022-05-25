package cn.devzyh.notebook.service.impl;

import cn.devzyh.common.utils.DateUtils;
import cn.devzyh.common.utils.bean.BeanUtils;
import cn.devzyh.notebook.domain.NoteContent;
import cn.devzyh.notebook.domain.NoteHistory;
import cn.devzyh.notebook.mapper.NoteContentMapper;
import cn.devzyh.notebook.mapper.NoteHistoryMapper;
import cn.devzyh.notebook.service.INoteContentService;
import cn.devzyh.notebook.service.INoteHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * 查询笔记内容
     *
     * @param id 笔记内容主键
     * @return 笔记内容
     */
    @Override
    public NoteContent selectNoteContentById(Long id) {
        return contentMapper.selectNoteContentById(id);
    }

    /**
     * 查询笔记内容列表
     *
     * @param noteContent 笔记内容
     * @return 笔记内容
     */
    @Override
    public List<NoteContent> selectNoteContentList(NoteContent noteContent) {
        return contentMapper.selectNoteContentList(noteContent);
    }

    /**
     * 新增笔记内容
     *
     * @param noteContent 笔记内容
     * @return 结果
     */
    @Override
    public int insertNoteContent(NoteContent noteContent) {
        noteContent.setCreateTime(DateUtils.getNowDate());
        return contentMapper.insertNoteContent(noteContent);
    }

    /**
     * 修改笔记内容
     *
     * @param content 笔记内容
     * @return 结果
     */
    @Override
    @Transactional
    public int updateNoteContent(NoteContent content) {
        // 备份本地数据到历史表
        NoteContent local = contentMapper.selectNoteContentById(content.getId());
        NoteHistory history = new NoteHistory();
        BeanUtils.copyBeanProp(history, local);
        history.setContentId(local.getId());
        historyService.insertNoteHistory(history);

        // 更新传入数据到内容表
        content.setUpdateTime(DateUtils.getNowDate());
        return contentMapper.updateNoteContent(content);
    }

    /**
     * 批量删除笔记内容
     *
     * @param ids 需要删除的笔记内容主键
     * @return 结果
     */
    @Override
    public int deleteNoteContentByIds(Long[] ids) {
        return contentMapper.deleteNoteContentByIds(ids);
    }

    /**
     * 删除笔记内容信息
     *
     * @param id 笔记内容主键
     * @return 结果
     */
    @Override
    public int deleteNoteContentById(Long id) {
        return contentMapper.deleteNoteContentById(id);
    }
}
