package cn.devzyh.web.controller;

import cn.devzyh.common.constant.WebConstants;
import cn.devzyh.web.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 首页控制器
 *
 * @author devzyh
 */
@Controller
public class HomeController {

    @Autowired
    private ILinkService linkService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute(WebConstants.Home.LINKS, linkService.selectLinks());
        return "index";
    }

    @GetMapping("/cm")
    public String caom(Model model) {
        return "caom";
    }

}
