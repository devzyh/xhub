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
import cn.devzyh.notebook.domain.NoteContent;
import cn.devzyh.notebook.service.INoteContentService;
import cn.devzyh.common.utils.poi.ExcelUtil;
import cn.devzyh.common.core.page.TableDataInfo;

/**
 * 笔记内容Controller
 *
 * @author devzyh
 * @date 2022-05-18
 */
@RestController
@RequestMapping("/rest/notebook/content")
public class NoteContentController extends BaseController {
    @Autowired
    private INoteContentService noteContentService;

    /**
     * 查询笔记内容列表
     */
    @PreAuthorize("@ss.hasPermi('notebook:content:list')")
    @GetMapping("/list")
    public TableDataInfo list(NoteContent noteContent) {
        startPage();
        List<NoteContent> list = noteContentService.selectNoteContentList(noteContent);
        return getDataTable(list);
    }

    /**
     * 导出笔记内容列表
     */
    @PreAuthorize("@ss.hasPermi('notebook:content:export')")
    @Log(title = "笔记内容" , businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NoteContent noteContent) {
        List<NoteContent> list = noteContentService.selectNoteContentList(noteContent);
        ExcelUtil<NoteContent> util = new ExcelUtil<NoteContent>(NoteContent.class);
        util.exportExcel(response, list, "笔记内容数据");
    }

    /**
     * 获取笔记内容详细信息
     */
    @PreAuthorize("@ss.hasPermi('notebook:content:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(noteContentService.selectNoteContentById(id));
    }

    /**
     * 新增笔记内容
     */
    @PreAuthorize("@ss.hasPermi('notebook:content:add')")
    @Log(title = "笔记内容" , businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NoteContent noteContent) {
        return toAjax(noteContentService.insertNoteContent(noteContent));
    }

    /**
     * 修改笔记内容
     */
    @PreAuthorize("@ss.hasPermi('notebook:content:edit')")
    @Log(title = "笔记内容" , businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NoteContent noteContent) {
        return toAjax(noteContentService.updateNoteContent(noteContent));
    }

    /**
     * 删除笔记内容
     */
    @PreAuthorize("@ss.hasPermi('notebook:content:remove')")
    @Log(title = "笔记内容" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(noteContentService.deleteNoteContentByIds(ids));
    }
}
