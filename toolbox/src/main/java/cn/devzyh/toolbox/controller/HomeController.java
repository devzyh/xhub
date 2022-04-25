package cn.devzyh.toolbox.controller;

import cn.devzyh.common.constant.ToolConstants;
import cn.devzyh.toolbox.factory.SearchServiceFactory;
import cn.devzyh.toolbox.service.IConfigService;
import cn.devzyh.toolbox.service.IFavoriteService;
import cn.devzyh.toolbox.service.ISearchService;
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
public class HomeController {

    @Autowired
    private IConfigService configService;
    @Autowired
    private IFavoriteService favoriteService;
    @Autowired
    private SearchServiceFactory searchServiceFactory;

    @GetMapping("/")
    public String index(Model m) {
        m.addAllAttributes(configService.getSiteInfo());
        m.addAttribute(ToolConstants.Index.FAVORITES, favoriteService.getFavorites());
        return "index";
    }

    @GetMapping("/tool/article")
    public String article(@RequestParam(required = false) String key, Model model) {
        if (key == null) {
            key = "";
        }
        ISearchService service = searchServiceFactory.getService(ToolConstants.SearchType.ARTICLE.getValue());
        if (service == null) {
            return "redirect:/";
        }
        model.addAllAttributes(configService.getSiteInfo());
        model.addAttribute(ToolConstants.Search.DATA, service.search(key));
        return "search";
    }

    @GetMapping("/tool/favorite")
    public String favorite(@RequestParam(required = false) String key, Model model) {
        if (key == null) {
            key = "";
        }
        ISearchService service = searchServiceFactory.getService(ToolConstants.SearchType.FAVORITE.getValue());
        if (service == null) {
            return "redirect:/";
        }
        model.addAllAttributes(configService.getSiteInfo());
        model.addAttribute(ToolConstants.Search.DATA, service.search(key));
        return "search";
    }

    @GetMapping("/tool/cm")
    public String caom(Model m) {
        m.addAllAttributes(configService.getSiteInfo());
        return "caom";
    }

}
