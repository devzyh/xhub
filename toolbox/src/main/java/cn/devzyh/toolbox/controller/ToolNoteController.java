package cn.devzyh.toolbox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 笔记控制器
 *
 * @author devzyh
 */
@Controller
public class ToolNoteController {

    @GetMapping("note/{id}.html")
    public String html(Model model, @RequestParam(required = false) String secret) {
        Map data = new HashMap<>();
        data.put("title", "笔记系统");
        model.addAttribute("data", data);
        return "note";
    }

    @ResponseBody
    @GetMapping("note/{id}.md")
    public String markdown() {
        return "";
    }
}
