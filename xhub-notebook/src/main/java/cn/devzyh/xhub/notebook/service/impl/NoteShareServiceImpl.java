package cn.devzyh.xhub.notebook.service.impl;

import cn.devzyh.xhub.common.annotation.DataScope;
import cn.devzyh.xhub.notebook.domain.NoteShare;
import cn.devzyh.xhub.notebook.mapper.NoteShareMapper;
import cn.devzyh.xhub.notebook.service.INoteShareService;
import com.baomidou.mybatisplus.core.metadata.IPage;
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
     * 查询笔记分享列表
     *
     * @param noteShare 笔记分享
     * @return 笔记分享
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<NoteShare> selectNoteShareList(IPage<NoteShare> page, NoteShare noteShare) {
        return noteShareMapper.selectNoteShareList(page, noteShare);
    }

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
     * 新增笔记分享
     *
     * @param noteShare 笔记分享
     * @return 结果
     */
    @Override
    public int saveNoteShare(NoteShare noteShare) {
        NoteShare localShare = noteShareMapper.selectNoteShareByContentId(noteShare.getContentId());
        if (localShare == null) {
            return noteShareMapper.insert(noteShare);
        } else {
            return noteShareMapper.updateById(noteShare);
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
        return noteShareMapper.updateById(noteShare);
    }

    /**
     * 批量删除笔记分享
     *
     * @param contentIds 需要删除的笔记分享主键
     * @return 结果
     */
    @Override
    public int deleteNoteShareByContentIds(List<Long> contentIds) {
        return noteShareMapper.deleteBatchIds(contentIds);
    }

    /**
     * 删除笔记分享信息
     *
     * @param contentId 笔记分享主键
     * @return 结果
     */
    @Override
    public int deleteNoteShareByContentId(Long contentId) {
        return noteShareMapper.deleteById(contentId);
    }
}
