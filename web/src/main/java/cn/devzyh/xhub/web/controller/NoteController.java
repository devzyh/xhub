package cn.devzyh.xhub.web.controller;

import cn.devzyh.common.constant.WebConstants;
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
 * 笔记控制器
 *
 * @author devzyh
 */
@Controller
public class NoteController {

    @Autowired
    private IShareService shareService;

    @GetMapping("note/{id}.html")
    public String html(Model model, @PathVariable Long id,
                       @RequestParam(required = false, defaultValue = "") String secret,
                       @RequestParam(required = false, defaultValue = "") String token) {
        ShareDto vo = shareService.html(id, secret, token);
        model.addAttribute(WebConstants.Note.DATA, vo);
        model.addAttribute(WebConstants.Note.NOTE, vo.getNote());
        return "note";
    }

    @ResponseBody()
    @GetMapping(value = "note/{id}.md", produces = MediaType.TEXT_MARKDOWN_VALUE)
    public String markdown(@PathVariable Long id,
                           @RequestParam(required = false, defaultValue = "") String secret,
                           @RequestParam(required = false, defaultValue = "") String token) {
        return shareService.markdown(id, secret, token);
    }

}