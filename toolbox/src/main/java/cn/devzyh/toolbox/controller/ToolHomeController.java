package cn.devzyh.toolbox.controller;

import cn.devzyh.common.constant.ToolConstants;
import cn.devzyh.toolbox.service.IToolFavoriteService;
import cn.devzyh.toolbox.service.IToolSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 首页控制器
 *
 * @author devzyh
 */
@Controller
public class ToolHomeController {

    @Autowired
    private IToolFavoriteService favoriteService;
    @Autowired
    private IToolSearchService searchArticleService;
    @Autowired
    private IToolSearchService searchFavoriteService;
    @Autowired
    private IToolSearchService searchFavoriteByItemService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute(ToolConstants.Home.FAVORITES, favoriteService.selectFavorites());
        return "index";
    }

    @GetMapping("/article")
    public String article(@RequestParam(required = false) String key, Model model) {
        model.addAttribute(ToolConstants.Search.DATA, searchArticleService.search(key));
        return "search";
    }

    @GetMapping("/favorite")
    public String favorite(@RequestParam(required = false) String key, Model model) {
        model.addAttribute(ToolConstants.Search.DATA, searchFavoriteService.search(key));
        return "search";
    }

    @GetMapping("/favorite/{item}")
    public String favoriteByItem(@PathVariable("item") String key, Model model) {
        model.addAttribute(ToolConstants.Search.DATA, searchFavoriteByItemService.search(key));
        return "search";
    }

    @GetMapping("/cm")
    public String caom(Model model) {
        return "caom";
    }

}
