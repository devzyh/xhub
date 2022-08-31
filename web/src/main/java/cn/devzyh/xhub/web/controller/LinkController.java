package cn.devzyh.xhub.web.controller;

import cn.devzyh.common.constant.WebConstants;
import cn.devzyh.xhub.web.service.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 收藏链接控制器
 *
 * @author devzyh
 */
@Controller
public class LinkController {

    @Autowired
    private ISearchService searchLinkService;

    @GetMapping("/link")
    public String searchLink(@RequestParam(required = false) String key, Model model) {
        model.addAttribute(WebConstants.Search.DATA, searchLinkService
                .search(WebConstants.SearchParamsType.KEY, key));
        return "search";
    }

    @GetMapping("/link/{item}")
    public String searchLinkByItem(@PathVariable("item") String item, Model model) {
        model.addAttribute(WebConstants.Search.DATA, searchLinkService
                .search(WebConstants.SearchParamsType.ITEM, item));
        return "search";
    }

}
