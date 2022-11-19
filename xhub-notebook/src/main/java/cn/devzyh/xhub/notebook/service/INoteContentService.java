package cn.devzyh.xhub.notebook.service;

import cn.devzyh.xhub.notebook.domain.NoteContent;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * 笔记内容Service接口
 *
 * @author devzyh
 * @date 2022-05-18
 */
public interface INoteContentService {
    
    /**
     * 查询笔记内容列表
     *
     * @param noteContent 笔记内容
     * @return 笔记内容集合
     */
    List<NoteContent> selectNoteContentList(IPage<NoteContent> page, NoteContent noteContent);

    /**
     * 查询笔记内容
     *
     * @param id 笔记内容主键
     * @return 笔记内容
     */
    NoteContent selectNoteContentById(Long id);

    /**
     * 新增笔记内容
     *
     * @param noteContent 笔记内容
     * @return 结果
     */
    int insertNoteContent(NoteContent noteContent);

    /**
     * 修改笔记内容
     *
     * @param noteContent 笔记内容
     * @return 结果
     */
    int updateNoteContent(NoteContent noteContent);

    /**
     * 批量删除笔记内容
     *
     * @param ids 需要删除的笔记内容主键集合
     * @return 结果
     */
    int deleteNoteContentByIds(List<Long> ids);

    /**
     * 删除笔记内容信息
     *
     * @param id 笔记内容主键
     * @return 结果
     */
    int deleteNoteContentById(Long id);
}
