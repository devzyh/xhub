package cn.devzyh.notebook.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.devzyh.common.annotation.Log;
import cn.devzyh.common.core.controller.BaseController;
import cn.devzyh.common.core.domain.AjaxResult;
import cn.devzyh.common.enums.BusinessType;
import cn.devzyh.notebook.domain.NoteShare;
import cn.devzyh.notebook.service.INoteShareService;
import cn.devzyh.common.utils.poi.ExcelUtil;
import cn.devzyh.common.core.page.TableDataInfo;

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
    @Log(title = "笔记分享" , businessType = BusinessType.EXPORT)
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
    @Log(title = "笔记分享" , businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NoteShare noteShare) {
        return toAjax(noteShareService.insertNoteShare(noteShare));
    }

    /**
     * 修改笔记分享
     */
    @PreAuthorize("@ss.hasPermi('notebook:share:edit')")
    @Log(title = "笔记分享" , businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NoteShare noteShare) {
        return toAjax(noteShareService.updateNoteShare(noteShare));
    }

    /**
     * 删除笔记分享
     */
    @PreAuthorize("@ss.hasPermi('notebook:share:remove')")
    @Log(title = "笔记分享" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{contentIds}")
    public AjaxResult remove(@PathVariable Long[] contentIds) {
        return toAjax(noteShareService.deleteNoteShareByContentIds(contentIds));
    }
}
