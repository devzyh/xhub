package cn.devzyh.toolbox.service.impl;

import cn.devzyh.common.utils.StringUtils;
import cn.devzyh.toolbox.domain.Note;
import cn.devzyh.toolbox.domain.vo.NoteVo;
import cn.devzyh.toolbox.mapper.ToolNoteMapper;
import cn.devzyh.toolbox.service.IToolNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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

        // 授权码随意访问
        if (StringUtils.isNotBlank(token)) {
            // TODO 授权码验证
            if (true) {
                vo.setSuccess(note);
                return vo;
            } else {
                vo.setError("授权码已过期");
                return vo;
            }
        }

        // 分享到期验证
        if (note.getShareDays() > 0 && LocalDateTime.now().isAfter(LocalDateTime.now().plusDays(note.getShareDays()))) {
            vo.setError("您访问的笔记不存在");
            return vo;
        }

        // 访问密码验证
        if (StringUtils.isNotBlank(note.getShareSecret())) {
            if (StringUtils.isBlank(secret)) {
                vo.setSuccessWithDialog("请输入访问密码");
                return vo;
            }
            if (!StringUtils.equalsIgnoreCase(note.getShareSecret(), secret)) {
                vo.setInputSecret(secret);
                vo.setErrorWithDialog("访问密码错误");
                return vo;
            }
        }

        // 直接返回数据
        vo.setSuccess(note);
        return vo;
    }

    @Override
    public String markdown(Long id, String secret, String token) {
        NoteVo vo = html(id, secret, token);
        if (!vo.getSuccess()) {
            return vo.getMessage();
        }
        return vo.getNote().getContent();
    }

}
