package cn.devzyh.xhub.favorite.controller;

import cn.devzyh.xhub.common.annotation.Log;
import cn.devzyh.xhub.common.core.controller.BaseController;
import cn.devzyh.xhub.common.core.domain.Result;
import cn.devzyh.xhub.common.core.page.TableDataInfo;
import cn.devzyh.xhub.common.enums.BusinessType;
import cn.devzyh.xhub.common.utils.poi.ExcelUtil;
import cn.devzyh.xhub.favorite.domain.FavLink;
import cn.devzyh.xhub.favorite.service.IFavLinkService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 收藏链接Controller
 *
 * @author devzyh
 * @date 2022-05-08
 */
@RestController
@RequestMapping("/rest/fav/link")
public class FavLinkController extends BaseController {
    
    @Autowired
    private IFavLinkService favLinkService;

    /**
     * 查询主页链接列表
     */
    @PreAuthorize("@ss.hasPermi('fav:link:list')")
    @GetMapping("/list")
    public TableDataInfo list(FavLink favLink) {
        IPage<FavLink> page = getPage();
        return getDataTable(page, favLinkService.selectFavLinkList(page, favLink));
    }

    /**
     * 导出主页链接列表
     */
    @PreAuthorize("@ss.hasPermi('fav:link:export')")
    @Log(title = "主页链接", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FavLink favLink) {
        List<FavLink> list = favLinkService.selectFavLinkList(null, favLink);
        ExcelUtil<FavLink> util = new ExcelUtil<FavLink>(FavLink.class);
        util.exportExcel(response, list, "主页链接数据");
    }

    /**
     * 获取主页链接详细信息
     */
    @PreAuthorize("@ss.hasPermi('fav:link:query')")
    @GetMapping(value = "/{id}")
    public Result getInfo(@PathVariable("id") Long id) {
        return Result.success(favLinkService.selectFavLinkById(id));
    }

    /**
     * 新增主页链接
     */
    @PreAuthorize("@ss.hasPermi('fav:link:add')")
    @Log(title = "主页链接", businessType = BusinessType.INSERT)
    @PostMapping
    public Result add(@RequestBody FavLink favLink) {
        return toResult(favLinkService.insertFavLink(favLink));
    }

    /**
     * 修改主页链接
     */
    @PreAuthorize("@ss.hasPermi('fav:link:edit')")
    @Log(title = "主页链接", businessType = BusinessType.UPDATE)
    @PutMapping
    public Result edit(@RequestBody FavLink favLink) {
        return toResult(favLinkService.updateFavLink(favLink));
    }

    /**
     * 删除主页链接
     */
    @PreAuthorize("@ss.hasPermi('fav:link:remove')")
    @Log(title = "主页链接", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public Result remove(@PathVariable List<Long> ids) {
        return toResult(favLinkService.deleteFavLinkByIds(ids));
    }
}
