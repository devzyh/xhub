package cn.devzyh.toolbox.controller;

import cn.devzyh.toolbox.utils.ViewModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 视图控制器
 *
 * @author devzyh
 */
@Controller
public class ToolViewController {

    @GetMapping("/json")
    public String tool(Model model) {
        ViewModelUtils.loadGlobal(model);
        return "tool/json";
    }

    @GetMapping("/xml")
    public String xml(Model model) {
        ViewModelUtils.loadGlobal(model);
        return "tool/xml";
    }

    @GetMapping("/diff")
    public String diff(Model model) {
        ViewModelUtils.loadGlobal(model);
        return "tool/diff";
    }

    @GetMapping("/xslt")
    public String xslt(Model model) {
        ViewModelUtils.loadGlobal(model);
        return "tool/xslt";
    }

    @GetMapping("/code")
    public String code(Model model) {
        ViewModelUtils.loadGlobal(model);
        return "tool/code";
    }

    @GetMapping("/cron")
    public String cron(Model model) {
        ViewModelUtils.loadGlobal(model);
        return "tool/cron";
    }
}
