package cn.devzyh.toolbox.service.impl;

import cn.devzyh.toolbox.domain.Note;
import cn.devzyh.toolbox.domain.vo.NoteVo;
import cn.devzyh.toolbox.mapper.ToolNoteMapper;
import cn.devzyh.toolbox.service.IToolNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToolNoteServiceImpl implements IToolNoteService {

    @Autowired
    private ToolNoteMapper noteMapper;

    @Override
    public NoteVo html(Long id, String secret, String token) {
        NoteVo vo = new NoteVo();
        Note note = noteMapper.selectNoteById(id);
        if (note == null) {
            vo.setError("您访问的笔记不存在");
            return vo;
        }

        return vo;
    }

    @Override
    public String markdown(Long id, String secret, String token) {
        return null;
    }

}
