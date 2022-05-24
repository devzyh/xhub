package cn.devzyh.toolbox.controller;

import cn.devzyh.toolbox.domain.vo.NoteVo;
import cn.devzyh.toolbox.service.IToolNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 笔记控制器
 *
 * @author devzyh
 */
@Controller
public class ToolNoteController {

    @Autowired
    private IToolNoteService noteService;

    @GetMapping("note/{id}.html")
    public String html(Model model, @PathVariable Long id,
                       @RequestParam(required = false, defaultValue = "") String secret,
                       @RequestParam(required = false, defaultValue = "") String token) {
        NoteVo vo = noteService.html(id, secret, token);
        model.addAttribute("data", vo);
        model.addAttribute("note", vo.getNote());
        return "note";
    }

    @ResponseBody()
    @GetMapping(value = "note/{id}.md", produces = "text/text;charset=UTF-8")
    public String markdown(@PathVariable Long id,
                           @RequestParam(required = false, defaultValue = "") String secret,
                           @RequestParam(required = false, defaultValue = "") String token) {
        return noteService.markdown(id, secret, token);
    }
}
