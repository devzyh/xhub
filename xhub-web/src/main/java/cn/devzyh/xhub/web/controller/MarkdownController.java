package cn.devzyh.xhub.web.controller;

import cn.devzyh.xhub.common.constant.WebConstants;
import cn.devzyh.xhub.web.domain.dto.ShareDto;
import cn.devzyh.xhub.web.service.IShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Markdown控制器
 *
 * @author devzyh
 */
@Controller
public class MarkdownController {

    @Autowired
    private IShareService shareService;

    @GetMapping("share/{id}.html")
    public String html(Model model, @PathVariable Long id,
                       @RequestParam(required = false, defaultValue = "") String secret) {
        ShareDto dto = shareService.html(id, secret);
        model.addAttribute(WebConstants.Note.DATA, dto);
        if (dto.isSuccess()) {
            model.addAttribute(WebConstants.Note.NOTE, dto.getNote());
            return "markdown/share";
        } else {
            return "markdown/verify";
        }
    }

    @ResponseBody()
    @GetMapping(value = "share/{id}.md", produces = MediaType.TEXT_MARKDOWN_VALUE)
    public String markdown(@PathVariable Long id,
                           @RequestParam(required = false, defaultValue = "") String secret) {
        return shareService.markdown(id, secret);
    }
}
