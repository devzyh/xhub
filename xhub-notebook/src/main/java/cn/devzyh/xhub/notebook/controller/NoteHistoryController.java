package cn.devzyh.xhub.notebook.controller;

import cn.devzyh.xhub.common.annotation.Log;
import cn.devzyh.xhub.common.core.controller.BaseController;
import cn.devzyh.xhub.common.core.domain.AjaxResult;
import cn.devzyh.xhub.common.core.page.TableDataInfo;
import cn.devzyh.xhub.common.enums.BusinessType;
import cn.devzyh.xhub.common.utils.poi.ExcelUtil;
import cn.devzyh.xhub.notebook.domain.NoteHistory;
import cn.devzyh.xhub.notebook.service.INoteHistoryService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
        IPage<NoteHistory> page = getPage();
        return getDataTable(page, noteHistoryService.selectNoteHistoryList(page, noteHistory));
    }

    /**
     * 导出笔记历史列表
     */
    @PreAuthorize("@ss.hasPermi('notebook:history:export')")
    @Log(title = "笔记历史", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NoteHistory noteHistory) {
        List<NoteHistory> list = noteHistoryService.selectNoteHistoryList(null, noteHistory);
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
    @Log(title = "笔记历史", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NoteHistory noteHistory) {
        return toAjax(noteHistoryService.insertNoteHistory(noteHistory));
    }

    /**
     * 修改笔记历史
     */
    @PreAuthorize("@ss.hasPermi('notebook:history:edit')")
    @Log(title = "笔记历史", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NoteHistory noteHistory) {
        return toAjax(noteHistoryService.updateNoteHistory(noteHistory));
    }

    /**
     * 删除笔记历史
     */
    @PreAuthorize("@ss.hasPermi('notebook:history:remove')")
    @Log(title = "笔记历史", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable List<Long> ids) {
        return toAjax(noteHistoryService.deleteNoteHistoryByIds(ids));
    }
}
