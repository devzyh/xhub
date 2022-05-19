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
import cn.devzyh.notebook.domain.NoteHistory;
import cn.devzyh.notebook.service.INoteHistoryService;
import cn.devzyh.common.utils.poi.ExcelUtil;
import cn.devzyh.common.core.page.TableDataInfo;

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
    @PreAuthorize("@ss.hasPermi('notebook:history:list')")
    @GetMapping("/list")
    public TableDataInfo list(NoteHistory noteHistory) {
        startPage();
        List<NoteHistory> list = noteHistoryService.selectNoteHistoryList(noteHistory);
        return getDataTable(list);
    }

    /**
     * 导出笔记历史列表
     */
    @PreAuthorize("@ss.hasPermi('notebook:history:export')")
    @Log(title = "笔记历史" , businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NoteHistory noteHistory) {
        List<NoteHistory> list = noteHistoryService.selectNoteHistoryList(noteHistory);
        ExcelUtil<NoteHistory> util = new ExcelUtil<NoteHistory>(NoteHistory.class);
        util.exportExcel(response, list, "笔记历史数据");
    }

    /**
     * 获取笔记历史详细信息
     */
    @PreAuthorize("@ss.hasPermi('notebook:history:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(noteHistoryService.selectNoteHistoryById(id));
    }

    /**
     * 新增笔记历史
     */
    @PreAuthorize("@ss.hasPermi('notebook:history:add')")
    @Log(title = "笔记历史" , businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NoteHistory noteHistory) {
        return toAjax(noteHistoryService.insertNoteHistory(noteHistory));
    }

    /**
     * 修改笔记历史
     */
    @PreAuthorize("@ss.hasPermi('notebook:history:edit')")
    @Log(title = "笔记历史" , businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NoteHistory noteHistory) {
        return toAjax(noteHistoryService.updateNoteHistory(noteHistory));
    }

    /**
     * 删除笔记历史
     */
    @PreAuthorize("@ss.hasPermi('notebook:history:remove')")
    @Log(title = "笔记历史" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(noteHistoryService.deleteNoteHistoryByIds(ids));
    }
}
