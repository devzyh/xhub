package cn.devzyh.xhub.web.controller;

import cn.devzyh.common.constant.WebConstants;
import cn.devzyh.xhub.web.service.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 收藏文章控制器
 *
 * @author devzyh
 */
@Controller
public class ArticleController {

    @Autowired
    private ISearchService searchArticleService;

    @GetMapping("/article")
    public String article(@RequestParam(required = false) String key, Model model) {
        model.addAttribute(WebConstants.Search.DATA, searchArticleService.search(key));
        return "search";
    }
}
