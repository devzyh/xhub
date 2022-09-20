package cn.devzyh.xhub.notebook.controller;

import cn.devzyh.xhub.common.annotation.Log;
import cn.devzyh.xhub.common.core.controller.BaseController;
import cn.devzyh.xhub.common.core.domain.AjaxResult;
import cn.devzyh.xhub.common.core.page.TableDataInfo;
import cn.devzyh.xhub.common.enums.BusinessType;
import cn.devzyh.xhub.common.utils.poi.ExcelUtil;
import cn.devzyh.xhub.notebook.domain.NoteShare;
import cn.devzyh.xhub.notebook.service.INoteShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 笔记分享Controller
 *
 * @author devzyh
 * @date 2022-05-18
 */
@RestController
@RequestMapping("/rest/notebook/share")
public class NoteShareController extends BaseController {
    @Autowired
    private INoteShareService noteShareService;

    /**
     * 查询笔记分享列表
     */
    @PreAuthorize("@ss.hasPermi('notebook:share:list')")
    @GetMapping("/list")
    public TableDataInfo list(NoteShare noteShare) {
        startPage();
        List<NoteShare> list = noteShareService.selectNoteShareList(noteShare);
        return getDataTable(list);
    }

    /**
     * 导出笔记分享列表
     */
    @PreAuthorize("@ss.hasPermi('notebook:share:export')")
    @Log(title = "笔记分享", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NoteShare noteShare) {
        List<NoteShare> list = noteShareService.selectNoteShareList(noteShare);
        ExcelUtil<NoteShare> util = new ExcelUtil<NoteShare>(NoteShare.class);
        util.exportExcel(response, list, "笔记分享数据");
    }

    /**
     * 获取笔记分享详细信息
     */
    @PreAuthorize("@ss.hasPermi('notebook:share:query')")
    @GetMapping(value = "/{contentId}")
    public AjaxResult getInfo(@PathVariable("contentId") Long contentId) {
        return AjaxResult.success(noteShareService.selectNoteShareByContentId(contentId));
    }

    /**
     * 新增笔记分享
     */
    @PreAuthorize("@ss.hasPermi('notebook:share:add')")
    @Log(title = "笔记分享", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult save(@RequestBody NoteShare noteShare) {
        return toAjax(noteShareService.saveNoteShare(noteShare));
    }

    /**
     * 修改笔记分享
     */
    @PreAuthorize("@ss.hasPermi('notebook:share:edit')")
    @Log(title = "笔记分享", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NoteShare noteShare) {
        return toAjax(noteShareService.updateNoteShare(noteShare));
    }

    /**
     * 删除笔记分享
     */
    @PreAuthorize("@ss.hasPermi('notebook:share:remove')")
    @Log(title = "笔记分享", businessType = BusinessType.DELETE)
    @DeleteMapping("/{contentIds}")
    public AjaxResult remove(@PathVariable Long[] contentIds) {
        noteShareService.deleteNoteShareByContentIds(contentIds);
        return success();
    }
}
