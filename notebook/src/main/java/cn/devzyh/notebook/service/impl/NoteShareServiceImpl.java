package cn.devzyh.notebook.service.impl;

import cn.devzyh.common.utils.DateUtils;
import cn.devzyh.common.utils.SecurityUtils;
import cn.devzyh.notebook.domain.NoteShare;
import cn.devzyh.notebook.mapper.NoteShareMapper;
import cn.devzyh.notebook.service.INoteShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 笔记分享Service业务层处理
 *
 * @author devzyh
 * @date 2022-05-18
 */
@Service
public class NoteShareServiceImpl implements INoteShareService {
    @Autowired
    private NoteShareMapper noteShareMapper;

    /**
     * 查询笔记分享
     *
     * @param contentId 笔记分享主键
     * @return 笔记分享
     */
    @Override
    public NoteShare selectNoteShareByContentId(Long contentId) {
        return noteShareMapper.selectNoteShareByContentId(contentId);
    }

    /**
     * 查询笔记分享列表
     *
     * @param noteShare 笔记分享
     * @return 笔记分享
     */
    @Override
    public List<NoteShare> selectNoteShareList(NoteShare noteShare) {
        return noteShareMapper.selectNoteShareList(noteShare);
    }

    /**
     * 新增笔记分享
     *
     * @param noteShare 笔记分享
     * @return 结果
     */
    @Override
    public int saveNoteShare(NoteShare noteShare) {
        NoteShare localShare = noteShareMapper.selectNoteShareByContentId(noteShare.getContentId());
        if (localShare == null) {
            noteShare.setCreateTime(DateUtils.getNowDate());
            noteShare.setUpdateTime(DateUtils.getNowDate());
            noteShare.setCreateBy(SecurityUtils.getUsername());
            return noteShareMapper.insertNoteShare(noteShare);
        } else {
            noteShare.setUpdateTime(DateUtils.getNowDate());
            noteShare.setUpdateBy(SecurityUtils.getUsername());
            return noteShareMapper.updateNoteShare(noteShare);
        }
    }

    /**
     * 修改笔记分享
     *
     * @param noteShare 笔记分享
     * @return 结果
     */
    @Override
    public int updateNoteShare(NoteShare noteShare) {
        noteShare.setUpdateTime(DateUtils.getNowDate());
        noteShare.setUpdateBy(SecurityUtils.getUsername());
        return noteShareMapper.updateNoteShare(noteShare);
    }

    /**
     * 批量删除笔记分享
     *
     * @param contentIds 需要删除的笔记分享主键
     * @return 结果
     */
    @Override
    public int deleteNoteShareByContentIds(Long[] contentIds) {
        return noteShareMapper.deleteNoteShareByContentIds(contentIds);
    }

    /**
     * 删除笔记分享信息
     *
     * @param contentId 笔记分享主键
     * @return 结果
     */
    @Override
    public int deleteNoteShareByContentId(Long contentId) {
        return noteShareMapper.deleteNoteShareByContentId(contentId);
    }
}
