package cn.devzyh.toolbox.controller;

import cn.devzyh.common.constant.ToolConstants;
import cn.devzyh.toolbox.factory.SearchServiceFactory;
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
public class HomeController {

    @Autowired
    private IToolDictDataService dictDataService;
    @Autowired
    private IToolFavoriteService favoriteService;
    @Autowired
    private SearchServiceFactory searchServiceFactory;

    @GetMapping("/")
    public String index(Model m) {
        m.addAllAttributes(dictDataService.getSiteInfo());
        m.addAttribute(ToolConstants.Home.FAVORITES, favoriteService.getFavorites());
        return "index";
    }

    @GetMapping("/tool/article")
    public String article(@RequestParam(required = false) String key, Model model) {
        if (key == null) {
            key = "";
        }
        IToolSearchService service = searchServiceFactory.getService(ToolConstants.SearchType.ARTICLE.getValue());
        if (service == null) {
            return "redirect:/";
        }
        model.addAllAttributes(dictDataService.getSiteInfo());
        model.addAttribute(ToolConstants.Search.DATA, service.search(key));
        return "search";
    }

    @GetMapping("/tool/favorite")
    public String favorite(@RequestParam(required = false) String key, Model model) {
        if (key == null) {
            key = "";
        }
        IToolSearchService service = searchServiceFactory.getService(ToolConstants.SearchType.FAVORITE.getValue());
        if (service == null) {
            return "redirect:/";
        }
        model.addAllAttributes(dictDataService.getSiteInfo());
        model.addAttribute(ToolConstants.Search.DATA, service.search(key));
        return "search";
    }

    @GetMapping("/tool/cm")
    public String caom(Model m) {
        m.addAllAttributes(dictDataService.getSiteInfo());
        return "caom";
    }

}
