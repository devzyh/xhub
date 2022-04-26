package cn.devzyh.toolbox.controller;

import cn.devzyh.toolbox.service.IToolDictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 视图控制器
 *
 * @author devzyh
 */
@Controller
@RequestMapping("/tool")
public class ViewController {

    @Autowired
    private IToolDictDataService dictDataService;

    @GetMapping("/json")
    public String tool(Model m) {
        m.addAllAttributes(dictDataService.getSiteInfo());
        return "tool/json";
    }

    @GetMapping("/xml")
    public String xml(Model m) {
        m.addAllAttributes(dictDataService.getSiteInfo());
        return "tool/xml";
    }

    @GetMapping("/diff")
    public String diff(Model m) {
        m.addAllAttributes(dictDataService.getSiteInfo());
        return "tool/diff";
    }

    @GetMapping("/xslt")
    public String xslt(Model m) {
        m.addAllAttributes(dictDataService.getSiteInfo());
        return "tool/xslt";
    }

    @GetMapping("/code")
    public String code(Model m) {
        m.addAllAttributes(dictDataService.getSiteInfo());
        return "tool/code";
    }

    @GetMapping("/cron")
    public String cron(Model m) {
        m.addAllAttributes(dictDataService.getSiteInfo());
        return "tool/cron";
    }
}
