package cn.devzyh.toolbox.controller;

import cn.devzyh.toolbox.service.IToolNoteService;
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

    private IToolNoteService noteService;

    @GetMapping("note/{id}.html")
    public String html(Model model, @PathVariable Long id,
                       @RequestParam(required = false) String secret,
                       @RequestParam(required = false) String token) {
        model.addAttribute("data", noteService.html(id, secret, token));
        return "note";
    }

    @ResponseBody
    @GetMapping("note/{id}.md")
    public String markdown() {
        return "";
    }
}
