package cn.devzyh.xhub.notebook.service;

import cn.devzyh.xhub.notebook.domain.NoteHistory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * 笔记历史Service接口
 *
 * @author devzyh
 * @date 2022-05-18
 */
public interface INoteHistoryService {
    
    /**
     * 查询笔记历史列表
     *
     * @param noteHistory 笔记历史
     * @return 笔记历史集合
     */
    List<NoteHistory> selectNoteHistoryList(IPage<NoteHistory> page, NoteHistory noteHistory);
    
    /**
     * 查询笔记历史
     *
     * @param id 笔记历史主键
     * @return 笔记历史
     */
    NoteHistory selectNoteHistoryById(Long id);

    /**
     * 新增笔记历史
     *
     * @param noteHistory 笔记历史
     * @return 结果
     */
    int insertNoteHistory(NoteHistory noteHistory);

    /**
     * 修改笔记历史
     *
     * @param noteHistory 笔记历史
     * @return 结果
     */
    int updateNoteHistory(NoteHistory noteHistory);

    /**
     * 批量删除笔记历史
     *
     * @param ids 需要删除的笔记历史主键集合
     * @return 结果
     */
    int deleteNoteHistoryByIds(List<Long> ids);

    /**
     * 删除笔记历史信息
     *
     * @param id 笔记历史主键
     * @return 结果
     */
    int deleteNoteHistoryById(Long id);
}
