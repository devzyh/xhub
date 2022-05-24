package cn.devzyh.toolbox.service;

import cn.devzyh.toolbox.domain.vo.NoteVo;

/**
 * 笔记Service接口
 *
 * @author devzyh
 * @date 2022-05-08
 */
public interface IToolNoteService {

    /**
     * 查询笔记HTML
     *
     * @param id 文章主键
     * @return 文章
     */
    public NoteVo html(Long id, String secret, String token);

    /**
     * 查询笔记Markdown
     *
     * @param id 文章主键
     * @return 文章
     */
    public String markdown(Long id, String secret, String token);

}
