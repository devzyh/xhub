package cn.devzyh.toolbox.controller;

import cn.devzyh.common.constant.ToolConstants;
import cn.devzyh.toolbox.service.IToolDictDataService;
import cn.devzyh.toolbox.service.IToolFavoriteService;
import cn.devzyh.toolbox.service.IToolSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 首页控制器
 *
 * @author devzyh
 */
@Controller
public class ToolHomeController {

    @Autowired
    private IToolDictDataService dictDataService;
    @Autowired
    private IToolFavoriteService favoriteService;
    @Autowired
    private IToolSearchService searchArticleService;
    @Autowired
    private IToolSearchService searchFavoriteService;

    @GetMapping("/")
    public String index(Model m) {
        m.addAllAttributes(dictDataService.getSiteInfo());
        m.addAttribute(ToolConstants.Home.FAVORITES, favoriteService.getFavorites());
        return "index";
    }

    @GetMapping("/article")
    public String article(@RequestParam(required = false) String key, Model model) {
        model.addAllAttributes(dictDataService.getSiteInfo());
        model.addAttribute(ToolConstants.Search.DATA, searchArticleService.search(key));
        return "search";
    }

    @GetMapping("/favorite")
    public String favorite(@RequestParam(required = false) String key, Model model) {
        model.addAllAttributes(dictDataService.getSiteInfo());
        model.addAttribute(ToolConstants.Search.DATA, searchFavoriteService.search(key));
        return "search";
    }

    @GetMapping("/cm")
    public String caom(Model m) {
        m.addAllAttributes(dictDataService.getSiteInfo());
        return "caom";
    }

}
