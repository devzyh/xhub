package cn.devzyh.web.controller;

import cn.devzyh.common.constant.WebConstants;
import cn.devzyh.web.domain.dto.SearchDto;
import cn.devzyh.web.service.ISearchService;
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
    public String article(@RequestParam(required = false) String key,
                          @RequestParam(required = false, defaultValue = "1") Integer page,
                          Model model) {
        SearchDto dto = searchArticleService.search(page, key);
        model.addAttribute(WebConstants.Search.DATA, dto);
        model.addAttribute(WebConstants.Search.PAGE, dto.getPage());
        return "search";
    }
}
