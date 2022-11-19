package cn.devzyh.xhub.notebook.service.impl;

import cn.devzyh.xhub.notebook.domain.NoteHistory;
import cn.devzyh.xhub.notebook.mapper.NoteHistoryMapper;
import cn.devzyh.xhub.notebook.service.INoteHistoryService;
import com.baomidou.mybatisplus.core.metadata.IPage;
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
     * 查询笔记历史列表
     *
     * @param noteHistory 笔记历史
     * @return 笔记历史
     */
    @Override
    public List<NoteHistory> selectNoteHistoryList(IPage<NoteHistory> page, NoteHistory noteHistory) {
        return historyMapper.selectNoteHistoryList(page, noteHistory);
    }

    /**
     * 查询笔记历史
     *
     * @param id 笔记历史主键
     * @return 笔记历史
     */
    @Override
    public NoteHistory selectNoteHistoryById(Long id) {
        return historyMapper.selectById(id);
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
        noteHistory.setUpdateTime(null);
        noteHistory.setUpdateBy(null);
        return historyMapper.insert(noteHistory);
    }

    /**
     * 修改笔记历史
     *
     * @param noteHistory 笔记历史
     * @return 结果
     */
    @Override
    public int updateNoteHistory(NoteHistory noteHistory) {
        return historyMapper.updateById(noteHistory);
    }

    /**
     * 批量删除笔记历史
     *
     * @param ids 需要删除的笔记历史主键
     * @return 结果
     */
    @Override
    public int deleteNoteHistoryByIds(List<Long> ids) {
        return historyMapper.deleteBatchIds(ids);
    }

    /**
     * 删除笔记历史信息
     *
     * @param id 笔记历史主键
     * @return 结果
     */
    @Override
    public int deleteNoteHistoryById(Long id) {
        return historyMapper.deleteById(id);
    }
}
