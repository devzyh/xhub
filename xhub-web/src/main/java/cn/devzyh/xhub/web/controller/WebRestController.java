package cn.devzyh.xhub.web.controller;

import cn.devzyh.xhub.web.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
