package cn.devzyh.xhub.notebook.controller;

import cn.devzyh.xhub.common.core.controller.BaseController;
import cn.devzyh.xhub.common.core.domain.Result;
import cn.devzyh.xhub.common.core.page.PageResult;
import cn.devzyh.xhub.notebook.domain.NoteHistory;
import cn.devzyh.xhub.notebook.service.INoteHistoryService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 笔记历史Controller
 *
 * @author devzyh
 * @date 2022-05-18
 */
@RestController
@RequestMapping("/rest/notebook/history")
public class NoteHistoryController extends BaseController {

    @Autowired
    private INoteHistoryService noteHistoryService;

    /**
     * 查询笔记历史列表
     */
    @GetMapping("/list")
    public PageResult list(NoteHistory noteHistory) {
        IPage<NoteHistory> page = getPage();
        return getPageResult(page, noteHistoryService.selectNoteHistoryList(page, noteHistory));
    }

    /**
     * 获取笔记历史详细信息
     */
    @GetMapping(value = "/{id}")
    public Result getInfo(@PathVariable("id") Long id) {
        return Result.success(noteHistoryService.selectNoteHistoryById(id));
    }

}
