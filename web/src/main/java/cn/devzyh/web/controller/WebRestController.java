package cn.devzyh.web.controller;

import cn.devzyh.web.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.CronExpression;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
