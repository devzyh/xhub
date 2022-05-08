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
import cn.devzyh.toolbox.domain.ToolFavorite;
import cn.devzyh.toolbox.service.IToolFavoriteService;
import cn.devzyh.common.utils.poi.ExcelUtil;
import cn.devzyh.common.core.page.TableDataInfo;

/**
 * 主页链接Controller
 *
 * @author devzyh
 * @date 2022-05-08
 */
@RestController
@RequestMapping("/rest/toolbox/favorite")
public class ToolFavoriteController extends BaseController {
    @Autowired
    private IToolFavoriteService toolFavoriteService;

    /**
     * 查询主页链接列表
     */
    @PreAuthorize("@ss.hasPermi('toolbox:favorite:list')")
    @GetMapping("/list")
    public TableDataInfo list(ToolFavorite toolFavorite) {
        startPage();
        List<ToolFavorite> list = toolFavoriteService.selectToolFavoriteList(toolFavorite);
        return getDataTable(list);
    }

    /**
     * 导出主页链接列表
     */
    @PreAuthorize("@ss.hasPermi('toolbox:favorite:export')")
    @Log(title = "主页链接", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ToolFavorite toolFavorite) {
        List<ToolFavorite> list = toolFavoriteService.selectToolFavoriteList(toolFavorite);
        ExcelUtil<ToolFavorite> util = new ExcelUtil<ToolFavorite>(ToolFavorite.class);
        util.exportExcel(response, list, "主页链接数据");
    }

    /**
     * 获取主页链接详细信息
     */
    @PreAuthorize("@ss.hasPermi('toolbox:favorite:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(toolFavoriteService.selectToolFavoriteById(id));
    }

    /**
     * 新增主页链接
     */
    @PreAuthorize("@ss.hasPermi('toolbox:favorite:add')")
    @Log(title = "主页链接", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ToolFavorite toolFavorite) {
        return toAjax(toolFavoriteService.insertToolFavorite(toolFavorite));
    }

    /**
     * 修改主页链接
     */
    @PreAuthorize("@ss.hasPermi('toolbox:favorite:edit')")
    @Log(title = "主页链接", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ToolFavorite toolFavorite) {
        return toAjax(toolFavoriteService.updateToolFavorite(toolFavorite));
    }

    /**
     * 删除主页链接
     */
    @PreAuthorize("@ss.hasPermi('toolbox:favorite:remove')")
    @Log(title = "主页链接", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(toolFavoriteService.deleteToolFavoriteByIds(ids));
    }
}
