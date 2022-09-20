package cn.devzyh.xhub.notebook.service.impl;

import cn.devzyh.xhub.common.utils.DateUtils;
import cn.devzyh.xhub.common.utils.SecurityUtils;
import cn.devzyh.xhub.notebook.domain.NoteHistory;
import cn.devzyh.xhub.notebook.mapper.NoteHistoryMapper;
import cn.devzyh.xhub.notebook.service.INoteHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 笔记历史Service业务层处理
 *
 * @author devzyh
 * @date 2022-05-18
 */
@Service
public class NoteHistoryServiceImpl implements INoteHistoryService {
    @Autowired
    private NoteHistoryMapper historyMapper;

    /**
     * 查询笔记历史
     *
     * @param id 笔记历史主键
     * @return 笔记历史
     */
    @Override
    public NoteHistory selectNoteHistoryById(Long id) {
        return historyMapper.selectNoteHistoryById(id);
    }

    /**
     * 查询笔记历史列表
     *
     * @param noteHistory 笔记历史
     * @return 笔记历史
     */
    @Override
    public List<NoteHistory> selectNoteHistoryList(NoteHistory noteHistory) {
        return historyMapper.selectNoteHistoryList(noteHistory);
    }

    /**
     * 新增笔记历史
     *
     * @param noteHistory 笔记历史
     * @return 结果
     */
    @Override
    public int insertNoteHistory(NoteHistory noteHistory) {
        noteHistory.setId(null);
        noteHistory.setCreateTime(DateUtils.getNowDate());
        noteHistory.setCreateBy(SecurityUtils.getUsername());
        noteHistory.setUpdateTime(null);
        noteHistory.setUpdateBy(null);
        return historyMapper.insertNoteHistory(noteHistory);
    }

    /**
     * 修改笔记历史
     *
     * @param noteHistory 笔记历史
     * @return 结果
     */
    @Override
    public int updateNoteHistory(NoteHistory noteHistory) {
        noteHistory.setUpdateTime(DateUtils.getNowDate());
        noteHistory.setUpdateBy(SecurityUtils.getUsername());
        return historyMapper.updateNoteHistory(noteHistory);
    }

    /**
     * 批量删除笔记历史
     *
     * @param ids 需要删除的笔记历史主键
     * @return 结果
     */
    @Override
    public int deleteNoteHistoryByIds(Long[] ids) {
        return historyMapper.deleteNoteHistoryByIds(ids);
    }

    /**
     * 删除笔记历史信息
     *
     * @param id 笔记历史主键
     * @return 结果
     */
    @Override
    public int deleteNoteHistoryById(Long id) {
        return historyMapper.deleteNoteHistoryById(id);
    }
}
