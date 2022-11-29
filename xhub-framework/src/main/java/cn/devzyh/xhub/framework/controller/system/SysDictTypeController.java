package cn.devzyh.xhub.framework.controller.system;

import cn.devzyh.xhub.common.annotation.Log;
import cn.devzyh.xhub.common.constant.UserConstants;
import cn.devzyh.xhub.common.core.controller.BaseController;
import cn.devzyh.xhub.common.core.domain.Result;
import cn.devzyh.xhub.common.core.domain.entity.SysDictType;
import cn.devzyh.xhub.common.core.page.TableDataInfo;
import cn.devzyh.xhub.common.enums.BusinessType;
import cn.devzyh.xhub.common.utils.poi.ExcelUtil;
import cn.devzyh.xhub.framework.service.ISysDictTypeService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 数据字典信息
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/rest/system/dict/type")
public class SysDictTypeController extends BaseController {
    @Autowired
    private ISysDictTypeService dictTypeService;

    @PreAuthorize("@ss.hasPermi('system:dict:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysDictType dictType) {
        IPage<SysDictType> page = getPage();
        return getDataTable(page, dictTypeService.selectDictTypeList(page, dictType));
    }

    @Log(title = "字典类型", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('system:dict:export')")
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysDictType dictType) {
        List<SysDictType> list = dictTypeService.selectDictTypeList(null, dictType);
        ExcelUtil<SysDictType> util = new ExcelUtil<SysDictType>(SysDictType.class);
        util.exportExcel(response, list, "字典类型");
    }

    /**
     * 查询字典类型详细
     */
    @PreAuthorize("@ss.hasPermi('system:dict:query')")
    @GetMapping(value = "/{dictId}")
    public Result getInfo(@PathVariable Long dictId) {
        return Result.success(dictTypeService.selectDictTypeById(dictId));
    }

    /**
     * 新增字典类型
     */
    @PreAuthorize("@ss.hasPermi('system:dict:add')")
    @Log(title = "字典类型", businessType = BusinessType.INSERT)
    @PostMapping
    public Result add(@Validated @RequestBody SysDictType dict) {
        if (UserConstants.NOT_UNIQUE.equals(dictTypeService.checkDictTypeUnique(dict))) {
            return Result.error("新增字典'" + dict.getDictName() + "'失败，字典类型已存在");
        }
        dict.setCreateBy(getUsername());
        return toResult(dictTypeService.insertDictType(dict));
    }

    /**
     * 修改字典类型
     */
    @PreAuthorize("@ss.hasPermi('system:dict:edit')")
    @Log(title = "字典类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public Result edit(@Validated @RequestBody SysDictType dict) {
        if (UserConstants.NOT_UNIQUE.equals(dictTypeService.checkDictTypeUnique(dict))) {
            return Result.error("修改字典'" + dict.getDictName() + "'失败，字典类型已存在");
        }
        dict.setUpdateBy(getUsername());
        return toResult(dictTypeService.updateDictType(dict));
    }

    /**
     * 删除字典类型
     */
    @PreAuthorize("@ss.hasPermi('system:dict:remove')")
    @Log(title = "字典类型", businessType = BusinessType.DELETE)
    @DeleteMapping("/{dictIds}")
    public Result remove(@PathVariable Long[] dictIds) {
        dictTypeService.deleteDictTypeByIds(dictIds);
        return success();
    }

    /**
     * 刷新字典缓存
     */
    @PreAuthorize("@ss.hasPermi('system:dict:remove')")
    @Log(title = "字典类型", businessType = BusinessType.CLEAN)
    @DeleteMapping("/refreshCache")
    public Result refreshCache() {
        dictTypeService.resetDictCache();
        return Result.success();
    }

    /**
     * 获取字典选择框列表
     */
    @GetMapping("/optionselect")
    public Result optionselect() {
        List<SysDictType> dictTypes = dictTypeService.selectDictTypeAll();
        return Result.success(dictTypes);
    }
}
