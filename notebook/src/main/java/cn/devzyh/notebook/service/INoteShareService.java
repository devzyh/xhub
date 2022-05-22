package cn.devzyh.notebook.service;

import java.util.List;

import cn.devzyh.notebook.domain.NoteShare;

/**
 * 笔记分享Service接口
 *
 * @author devzyh
 * @date 2022-05-18
 */
public interface INoteShareService {
    /**
     * 查询笔记分享
     *
     * @param contentId 笔记分享主键
     * @return 笔记分享
     */
    public NoteShare selectNoteShareByContentId(Long contentId);

    /**
     * 查询笔记分享列表
     *
     * @param noteShare 笔记分享
     * @return 笔记分享集合
     */
    public List<NoteShare> selectNoteShareList(NoteShare noteShare);

    /**
     * 新增笔记分享
     *
     * @param noteShare 笔记分享
     * @return 结果
     */
    public int saveNoteShare(NoteShare noteShare);

    /**
     * 修改笔记分享
     *
     * @param noteShare 笔记分享
     * @return 结果
     */
    public int updateNoteShare(NoteShare noteShare);

    /**
     * 批量删除笔记分享
     *
     * @param contentIds 需要删除的笔记分享主键集合
     * @return 结果
     */
    public int deleteNoteShareByContentIds(Long[] contentIds);

    /**
     * 删除笔记分享信息
     *
     * @param contentId 笔记分享主键
     * @return 结果
     */
    public int deleteNoteShareByContentId(Long contentId);
}
