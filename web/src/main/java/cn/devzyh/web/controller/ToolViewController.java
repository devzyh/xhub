package cn.devzyh.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 工具视图控制器
 *
 * @author devzyh
 */
@Controller
public class ToolViewController {

    @GetMapping("/json")
    public String tool(Model model) {
        return "tool/json";
    }

    @GetMapping("/xml")
    public String xml(Model model) {
        return "tool/xml";
    }

    @GetMapping("/diff")
    public String diff(Model model) {
        return "tool/diff";
    }

    @GetMapping("/xslt")
    public String xslt(Model model) {
        return "tool/xslt";
    }

    @GetMapping("/code")
    public String code(Model model) {
        return "tool/code";
    }

    @GetMapping("/cron")
    public String cron(Model model) {
        return "tool/cron";
    }

    @GetMapping("/unix")
    public String unix(Model model) {
        return "tool/unix";
    }

}
