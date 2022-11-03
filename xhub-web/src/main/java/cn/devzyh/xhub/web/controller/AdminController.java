package cn.devzyh.xhub.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 系统后台控制器
 *
 * @author devzyh
 */
@Controller
public class AdminController {
    
    @GetMapping("/admin")
    public String index() {
        return "forward:/admin/index.html";
    }
}
