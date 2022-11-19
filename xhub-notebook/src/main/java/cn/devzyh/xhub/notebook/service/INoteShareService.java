package cn.devzyh.xhub.notebook.service;

import cn.devzyh.xhub.notebook.domain.NoteShare;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * 笔记分享Service接口
 *
 * @author devzyh
 * @date 2022-05-18
 */
public interface INoteShareService {
    
    /**
     * 查询笔记分享列表
     *
     * @param noteShare 笔记分享
     * @return 笔记分享集合
     */
    List<NoteShare> selectNoteShareList(IPage<NoteShare> page, NoteShare noteShare);

    /**
     * 查询笔记分享
     *
     * @param contentId 笔记分享主键
     * @return 笔记分享
     */
    NoteShare selectNoteShareByContentId(Long contentId);

    /**
     * 新增笔记分享
     *
     * @param noteShare 笔记分享
     * @return 结果
     */
    int saveNoteShare(NoteShare noteShare);

    /**
     * 修改笔记分享
     *
     * @param noteShare 笔记分享
     * @return 结果
     */
    int updateNoteShare(NoteShare noteShare);

    /**
     * 批量删除笔记分享
     *
     * @param contentIds 需要删除的笔记分享主键集合
     * @return 结果
     */
    int deleteNoteShareByContentIds(List<Long> contentIds);

    /**
     * 删除笔记分享信息
     *
     * @param contentId 笔记分享主键
     * @return 结果
     */
    int deleteNoteShareByContentId(Long contentId);
}
