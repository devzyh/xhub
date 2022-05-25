package cn.devzyh.notebook.service.impl;

import java.util.List;

import cn.devzyh.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.devzyh.notebook.mapper.NoteHistoryMapper;
import cn.devzyh.notebook.domain.NoteHistory;
import cn.devzyh.notebook.service.INoteHistoryService;

/**
 * 笔记历史Service业务层处理
 *
 * @author devzyh
 * @date 2022-05-18
 */
@Service
public class NoteHistoryServiceImpl implements INoteHistoryService {
    @Autowired
    private NoteHistoryMapper noteHistoryMapper;

    /**
     * 查询笔记历史
     *
     * @param id 笔记历史主键
     * @return 笔记历史
     */
    @Override
    public NoteHistory selectNoteHistoryById(Long id) {
        return noteHistoryMapper.selectNoteHistoryById(id);
    }

    /**
     * 查询笔记历史列表
     *
     * @param noteHistory 笔记历史
     * @return 笔记历史
     */
    @Override
    public List<NoteHistory> selectNoteHistoryList(NoteHistory noteHistory) {
        return noteHistoryMapper.selectNoteHistoryList(noteHistory);
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
        noteHistory.setUpdateTime(DateUtils.getNowDate());
        return noteHistoryMapper.insertNoteHistory(noteHistory);
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
        return noteHistoryMapper.updateNoteHistory(noteHistory);
    }

    /**
     * 批量删除笔记历史
     *
     * @param ids 需要删除的笔记历史主键
     * @return 结果
     */
    @Override
    public int deleteNoteHistoryByIds(Long[] ids) {
        return noteHistoryMapper.deleteNoteHistoryByIds(ids);
    }

    /**
     * 删除笔记历史信息
     *
     * @param id 笔记历史主键
     * @return 结果
     */
    @Override
    public int deleteNoteHistoryById(Long id) {
        return noteHistoryMapper.deleteNoteHistoryById(id);
    }
}
