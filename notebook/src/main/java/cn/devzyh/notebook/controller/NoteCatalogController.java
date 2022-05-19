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
import cn.devzyh.notebook.domain.NoteCatalog;
import cn.devzyh.notebook.service.INoteCatalogService;
import cn.devzyh.common.utils.poi.ExcelUtil;

/**
 * 笔记目录Controller
 *
 * @author devzyh
 * @date 2022-05-18
 */
@RestController
@RequestMapping("/rest/notebook/catalog")
public class NoteCatalogController extends BaseController {
    @Autowired
    private INoteCatalogService noteCatalogService;

    /**
     * 查询笔记目录列表
     */
    @PreAuthorize("@ss.hasPermi('notebook:catalog:list')")
    @GetMapping("/list")
    public AjaxResult list(NoteCatalog noteCatalog) {
        List<NoteCatalog> list = noteCatalogService.selectNoteCatalogList(noteCatalog);
        return AjaxResult.success(list);
    }

    /**
     * 导出笔记目录列表
     */
    @PreAuthorize("@ss.hasPermi('notebook:catalog:export')")
    @Log(title = "笔记目录" , businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NoteCatalog noteCatalog) {
        List<NoteCatalog> list = noteCatalogService.selectNoteCatalogList(noteCatalog);
        ExcelUtil<NoteCatalog> util = new ExcelUtil<NoteCatalog>(NoteCatalog.class);
        util.exportExcel(response, list, "笔记目录数据");
    }

    /**
     * 获取笔记目录详细信息
     */
    @PreAuthorize("@ss.hasPermi('notebook:catalog:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(noteCatalogService.selectNoteCatalogById(id));
    }

    /**
     * 新增笔记目录
     */
    @PreAuthorize("@ss.hasPermi('notebook:catalog:add')")
    @Log(title = "笔记目录" , businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NoteCatalog noteCatalog) {
        return toAjax(noteCatalogService.insertNoteCatalog(noteCatalog));
    }

    /**
     * 修改笔记目录
     */
    @PreAuthorize("@ss.hasPermi('notebook:catalog:edit')")
    @Log(title = "笔记目录" , businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NoteCatalog noteCatalog) {
        return toAjax(noteCatalogService.updateNoteCatalog(noteCatalog));
    }

    /**
     * 删除笔记目录
     */
    @PreAuthorize("@ss.hasPermi('notebook:catalog:remove')")
    @Log(title = "笔记目录" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(noteCatalogService.deleteNoteCatalogByIds(ids));
    }
}
