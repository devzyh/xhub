package cn.devzyh.xhub.notebook.service;

import java.util.List;

import cn.devzyh.xhub.notebook.domain.NoteContent;

/**
 * 笔记内容Service接口
 *
 * @author devzyh
 * @date 2022-05-18
 */
public interface INoteContentService {
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
     * 批量删除笔记内容
     *
     * @param ids 需要删除的笔记内容主键集合
     * @return 结果
     */
    public int deleteNoteContentByIds(Long[] ids);

    /**
     * 删除笔记内容信息
     *
     * @param id 笔记内容主键
     * @return 结果
     */
    public int deleteNoteContentById(Long id);
}
