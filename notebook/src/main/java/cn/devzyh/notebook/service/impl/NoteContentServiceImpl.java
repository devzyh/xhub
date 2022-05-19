package cn.devzyh.notebook.service.impl;

import java.util.List;

import cn.devzyh.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.devzyh.notebook.mapper.NoteContentMapper;
import cn.devzyh.notebook.domain.NoteContent;
import cn.devzyh.notebook.service.INoteContentService;

/**
 * 笔记内容Service业务层处理
 *
 * @author devzyh
 * @date 2022-05-18
 */
@Service
public class NoteContentServiceImpl implements INoteContentService {
    @Autowired
    private NoteContentMapper noteContentMapper;

    /**
     * 查询笔记内容
     *
     * @param id 笔记内容主键
     * @return 笔记内容
     */
    @Override
    public NoteContent selectNoteContentById(Long id) {
        return noteContentMapper.selectNoteContentById(id);
    }

    /**
     * 查询笔记内容列表
     *
     * @param noteContent 笔记内容
     * @return 笔记内容
     */
    @Override
    public List<NoteContent> selectNoteContentList(NoteContent noteContent) {
        return noteContentMapper.selectNoteContentList(noteContent);
    }

    /**
     * 新增笔记内容
     *
     * @param noteContent 笔记内容
     * @return 结果
     */
    @Override
    public int insertNoteContent(NoteContent noteContent) {
        noteContent.setCreateTime(DateUtils.getNowDate());
        return noteContentMapper.insertNoteContent(noteContent);
    }

    /**
     * 修改笔记内容
     *
     * @param noteContent 笔记内容
     * @return 结果
     */
    @Override
    public int updateNoteContent(NoteContent noteContent) {
        noteContent.setUpdateTime(DateUtils.getNowDate());
        return noteContentMapper.updateNoteContent(noteContent);
    }

    /**
     * 批量删除笔记内容
     *
     * @param ids 需要删除的笔记内容主键
     * @return 结果
     */
    @Override
    public int deleteNoteContentByIds(Long[] ids) {
        return noteContentMapper.deleteNoteContentByIds(ids);
    }

    /**
     * 删除笔记内容信息
     *
     * @param id 笔记内容主键
     * @return 结果
     */
    @Override
    public int deleteNoteContentById(Long id) {
        return noteContentMapper.deleteNoteContentById(id);
    }
}
