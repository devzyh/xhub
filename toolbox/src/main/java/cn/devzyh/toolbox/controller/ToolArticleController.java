package cn.devzyh.toolbox.controller;

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
import cn.devzyh.toolbox.domain.ToolArticle;
import cn.devzyh.toolbox.service.IToolArticleService;
import cn.devzyh.common.utils.poi.ExcelUtil;
import cn.devzyh.common.core.page.TableDataInfo;

/**
 * 文章Controller
 *
 * @author devzyh
 * @date 2022-05-08
 */
@RestController
@RequestMapping("/rest/toolbox/article")
public class ToolArticleController extends BaseController {
    @Autowired
    private IToolArticleService toolArticleService;

    /**
     * 查询文章列表
     */
    @PreAuthorize("@ss.hasPermi('toolbox:article:list')")
    @GetMapping("/list")
    public TableDataInfo list(ToolArticle toolArticle) {
        startPage();
        List<ToolArticle> list = toolArticleService.selectToolArticleList(toolArticle);
        return getDataTable(list);
    }

    /**
     * 导出文章列表
     */
    @PreAuthorize("@ss.hasPermi('toolbox:article:export')")
    @Log(title = "文章", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ToolArticle toolArticle) {
        List<ToolArticle> list = toolArticleService.selectToolArticleList(toolArticle);
        ExcelUtil<ToolArticle> util = new ExcelUtil<ToolArticle>(ToolArticle.class);
        util.exportExcel(response, list, "文章数据");
    }

    /**
     * 获取文章详细信息
     */
    @PreAuthorize("@ss.hasPermi('toolbox:article:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(toolArticleService.selectToolArticleById(id));
    }

    /**
     * 新增文章
     */
    @PreAuthorize("@ss.hasPermi('toolbox:article:add')")
    @Log(title = "文章", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ToolArticle toolArticle) {
        return toAjax(toolArticleService.insertToolArticle(toolArticle));
    }

    /**
     * 修改文章
     */
    @PreAuthorize("@ss.hasPermi('toolbox:article:edit')")
    @Log(title = "文章", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ToolArticle toolArticle) {
        return toAjax(toolArticleService.updateToolArticle(toolArticle));
    }

    /**
     * 删除文章
     */
    @PreAuthorize("@ss.hasPermi('toolbox:article:remove')")
    @Log(title = "文章", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(toolArticleService.deleteToolArticleByIds(ids));
    }
}
