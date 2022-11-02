package cn.devzyh.xhub.favorite.controller;

import cn.devzyh.xhub.common.annotation.Log;
import cn.devzyh.xhub.common.core.controller.BaseController;
import cn.devzyh.xhub.common.core.domain.AjaxResult;
import cn.devzyh.xhub.common.core.page.TableDataInfo;
import cn.devzyh.xhub.common.enums.BusinessType;
import cn.devzyh.xhub.common.utils.poi.ExcelUtil;
import cn.devzyh.xhub.favorite.domain.FavArticle;
import cn.devzyh.xhub.favorite.service.IFavArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 收藏文章Controller
 *
 * @author devzyh
 * @date 2022-05-08
 */
@RestController
@RequestMapping("/rest/fav/article")
public class FavArticleController extends BaseController {
    @Autowired
    private IFavArticleService favArticleService;

    /**
     * 查询文章列表
     */
    @PreAuthorize("@ss.hasPermi('fav:article:list')")
    @GetMapping("/list")
    public TableDataInfo list(FavArticle favArticle) {
        startPage();
        List<FavArticle> list = favArticleService.selectFavArticleList(favArticle);
        return getDataTable(list);
    }

    /**
     * 导出文章列表
     */
    @PreAuthorize("@ss.hasPermi('fav:article:export')")
    @Log(title = "文章", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FavArticle favArticle) {
        List<FavArticle> list = favArticleService.selectFavArticleList(favArticle);
        ExcelUtil<FavArticle> util = new ExcelUtil<FavArticle>(FavArticle.class);
        util.exportExcel(response, list, "文章数据");
    }

    /**
     * 获取文章详细信息
     */
    @PreAuthorize("@ss.hasPermi('fav:article:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(favArticleService.selectFavArticleById(id));
    }

    /**
     * 新增文章
     */
    @PreAuthorize("@ss.hasPermi('fav:article:add')")
    @Log(title = "文章", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FavArticle favArticle) {
        return toAjax(favArticleService.insertFavArticle(favArticle));
    }

    /**
     * 修改文章
     */
    @PreAuthorize("@ss.hasPermi('fav:article:edit')")
    @Log(title = "文章", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FavArticle favArticle) {
        return toAjax(favArticleService.updateFavArticle(favArticle));
    }

    /**
     * 删除文章
     */
    @PreAuthorize("@ss.hasPermi('fav:article:remove')")
    @Log(title = "文章", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(favArticleService.deleteFavArticleByIds(ids));
    }
}
