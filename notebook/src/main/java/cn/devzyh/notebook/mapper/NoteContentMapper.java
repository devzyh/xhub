package cn.devzyh.notebook.mapper;

import cn.devzyh.notebook.domain.NoteContent;

import java.util.List;

/**
 * 笔记内容Mapper接口
 *
 * @author devzyh
 * @date 2022-05-18
 */
public interface NoteContentMapper {
    /**
     * 查询笔记内容
     *
     * @param id 笔记内容主键
     * @return 笔记内容
     */
    public NoteContent selectNoteContentById(Long id);

    /**
     * 查询笔记内容列表
     *
     * @param noteContent 笔记内容
     * @return 笔记内容集合
     */
    public List<NoteContent> selectNoteContentList(NoteContent noteContent);

    /**
     * 新增笔记内容
     *
     * @param noteContent 笔记内容
     * @return 结果
     */
    public int insertNoteContent(NoteContent noteContent);

    /**
     * 修改笔记内容
     *
     * @param noteContent 笔记内容
     * @return 结果
     */
    public int updateNoteContent(NoteContent noteContent);

    /**
     * 删除笔记内容
     *
     * @param id 笔记内容主键
     * @return 结果
     */
    public int deleteNoteContentById(Long id);

    /**
     * 批量删除笔记内容
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNoteContentByIds(Long[] ids);
}
