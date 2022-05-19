package cn.devzyh.notebook.mapper;

import java.util.List;

import cn.devzyh.notebook.domain.NoteHistory;

/**
 * 笔记历史Mapper接口
 *
 * @author devzyh
 * @date 2022-05-18
 */
public interface NoteHistoryMapper {
    /**
     * 查询笔记历史
     *
     * @param id 笔记历史主键
     * @return 笔记历史
     */
    public NoteHistory selectNoteHistoryById(Long id);

    /**
     * 查询笔记历史列表
     *
     * @param noteHistory 笔记历史
     * @return 笔记历史集合
     */
    public List<NoteHistory> selectNoteHistoryList(NoteHistory noteHistory);

    /**
     * 新增笔记历史
     *
     * @param noteHistory 笔记历史
     * @return 结果
     */
    public int insertNoteHistory(NoteHistory noteHistory);

    /**
     * 修改笔记历史
     *
     * @param noteHistory 笔记历史
     * @return 结果
     */
    public int updateNoteHistory(NoteHistory noteHistory);

    /**
     * 删除笔记历史
     *
     * @param id 笔记历史主键
     * @return 结果
     */
    public int deleteNoteHistoryById(Long id);

    /**
     * 批量删除笔记历史
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNoteHistoryByIds(Long[] ids);
}
