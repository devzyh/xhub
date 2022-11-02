package cn.devzyh.xhub.web.controller;

import cn.devzyh.xhub.web.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 前台接口控制器
 *
 * @author devzyh
 */
@RestController
@RequestMapping("web")
public class WebRestController {

    @Autowired
    ILinkService linkService;

    @GetMapping("link/visit/{id}")
    public void visitLink(@PathVariable Long id) {
        linkService.visitLink(id);
    }

}
