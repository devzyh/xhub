package cn.devzyh.xhub.favorite.controller;

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
import cn.devzyh.xhub.common.annotation.Log;
import cn.devzyh.xhub.common.core.controller.BaseController;
import cn.devzyh.xhub.common.core.domain.AjaxResult;
import cn.devzyh.xhub.common.enums.BusinessType;
import cn.devzyh.xhub.favorite.domain.FavTag;
import cn.devzyh.xhub.favorite.service.IFavTagService;
import cn.devzyh.xhub.common.utils.poi.ExcelUtil;
import cn.devzyh.xhub.common.core.page.TableDataInfo;

/**
 * 文章标签Controller
 *
 * @author devzyh
 * @date 2022-10-09
 */
@RestController
@RequestMapping("/rest/fav/tag")
public class FavTagController extends BaseController {
    @Autowired
    private IFavTagService favTagService;

    /**
     * 查询文章标签列表
     */
    @PreAuthorize("@ss.hasPermi('favorite:tag:list')")
    @GetMapping("/list")
    public TableDataInfo list(FavTag favTag) {
        startPage();
        List<FavTag> list = favTagService.selectFavTagList(favTag);
        return getDataTable(list);
    }

    /**
     * 导出文章标签列表
     */
    @PreAuthorize("@ss.hasPermi('favorite:tag:export')")
    @Log(title = "文章标签", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FavTag favTag) {
        List<FavTag> list = favTagService.selectFavTagList(favTag);
        ExcelUtil<FavTag> util = new ExcelUtil<FavTag>(FavTag.class);
        util.exportExcel(response, list, "文章标签数据");
    }

    /**
     * 获取文章标签详细信息
     */
    @PreAuthorize("@ss.hasPermi('favorite:tag:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(favTagService.selectFavTagById(id));
    }

    /**
     * 新增文章标签
     */
    @PreAuthorize("@ss.hasPermi('favorite:tag:add')")
    @Log(title = "文章标签", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FavTag favTag) {
        return favTagService.insertFavTag(favTag);
    }

    /**
     * 修改文章标签
     */
    @PreAuthorize("@ss.hasPermi('favorite:tag:edit')")
    @Log(title = "文章标签", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FavTag favTag) {
        return toAjax(favTagService.updateFavTag(favTag));
    }

    /**
     * 删除文章标签
     */
    @PreAuthorize("@ss.hasPermi('favorite:tag:remove')")
    @Log(title = "文章标签", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(favTagService.deleteFavTagByIds(ids));
    }
}
