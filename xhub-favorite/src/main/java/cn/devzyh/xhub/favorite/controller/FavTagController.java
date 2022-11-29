package cn.devzyh.xhub.favorite.controller;

import cn.devzyh.xhub.common.annotation.Log;
import cn.devzyh.xhub.common.core.controller.BaseController;
import cn.devzyh.xhub.common.core.domain.Result;
import cn.devzyh.xhub.common.core.page.TableDataInfo;
import cn.devzyh.xhub.common.enums.BusinessType;
import cn.devzyh.xhub.common.utils.poi.ExcelUtil;
import cn.devzyh.xhub.favorite.domain.FavTag;
import cn.devzyh.xhub.favorite.service.IFavTagService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
        IPage<FavTag> page = getPage();
        return getDataTable(page, favTagService.selectFavTagList(page, favTag));
    }

    /**
     * 查询所有文章标签
     */
    @PreAuthorize("@ss.hasPermi('favorite:tag:list')")
    @GetMapping("/all")
    public List<FavTag> all() {
        return favTagService.selectAllFavTag();
    }

    /**
     * 导出文章标签列表
     */
    @PreAuthorize("@ss.hasPermi('favorite:tag:export')")
    @Log(title = "文章标签", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FavTag favTag) {
        List<FavTag> list = favTagService.selectFavTagList(null, favTag);
        ExcelUtil<FavTag> util = new ExcelUtil<FavTag>(FavTag.class);
        util.exportExcel(response, list, "文章标签数据");
    }

    /**
     * 获取文章标签详细信息
     */
    @PreAuthorize("@ss.hasPermi('favorite:tag:query')")
    @GetMapping(value = "/{id}")
    public Result getInfo(@PathVariable("id") Long id) {
        return Result.success(favTagService.selectFavTagById(id));
    }

    /**
     * 新增文章标签
     */
    @PreAuthorize("@ss.hasPermi('favorite:tag:add')")
    @Log(title = "文章标签", businessType = BusinessType.INSERT)
    @PostMapping
    public Result add(@RequestBody FavTag favTag) {
        return toResult(favTagService.insertFavTag(favTag));
    }

    /**
     * 修改文章标签
     */
    @PreAuthorize("@ss.hasPermi('favorite:tag:edit')")
    @Log(title = "文章标签", businessType = BusinessType.UPDATE)
    @PutMapping
    public Result edit(@RequestBody FavTag favTag) {
        return toResult(favTagService.updateFavTag(favTag));
    }

    /**
     * 删除文章标签
     */
    @PreAuthorize("@ss.hasPermi('favorite:tag:remove')")
    @Log(title = "文章标签", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public Result remove(@PathVariable List<Long> ids) {
        return toResult(favTagService.deleteFavTagByIds(ids));
    }
}
