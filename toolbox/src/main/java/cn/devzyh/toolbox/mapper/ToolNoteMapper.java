package cn.devzyh.toolbox.mapper;

import cn.devzyh.toolbox.domain.Note;

/**
 * 文章数据层
 */
public interface ToolNoteMapper {

    /**
     * 查询笔记分享
     *
     * @param id 笔记主键
     * @return 笔记详情
     */
    public Note selectNoteById(Long id);

}
