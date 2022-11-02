package cn.devzyh.xhub.framework.controller.system;

import cn.devzyh.xhub.common.annotation.Log;
import cn.devzyh.xhub.common.core.controller.BaseController;
import cn.devzyh.xhub.common.core.domain.AjaxResult;
import cn.devzyh.xhub.common.core.page.TableDataInfo;
import cn.devzyh.xhub.common.enums.BusinessType;
import cn.devzyh.xhub.common.utils.poi.ExcelUtil;
import cn.devzyh.xhub.framework.domain.SysOptLog;
import cn.devzyh.xhub.framework.service.ISysOptLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 操作日志记录
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/rest/system/log/opt")
public class SysOptLogController extends BaseController {
    @Autowired
    private ISysOptLogService optLogService;

    @PreAuthorize("@ss.hasPermi('system:log:opt:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysOptLog optLog) {
        startPage();
        List<SysOptLog> list = optLogService.selectOptLogList(optLog);
        return getDataTable(list);
    }

    @Log(title = "操作日志", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('system:log:opt:export')")
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysOptLog optLog) {
        List<SysOptLog> list = optLogService.selectOptLogList(optLog);
        ExcelUtil<SysOptLog> util = new ExcelUtil<SysOptLog>(SysOptLog.class);
        util.exportExcel(response, list, "操作日志");
    }

    @Log(title = "操作日志", businessType = BusinessType.DELETE)
    @PreAuthorize("@ss.hasPermi('system:log:opt:remove')")
    @DeleteMapping("/{optIds}")
    public AjaxResult remove(@PathVariable Long[] optIds) {
        return toAjax(optLogService.deleteOptLogByIds(optIds));
    }

    @Log(title = "操作日志", businessType = BusinessType.CLEAN)
    @PreAuthorize("@ss.hasPermi('system:log:opt:remove')")
    @DeleteMapping("/clean")
    public AjaxResult clean() {
        optLogService.cleanOptLog();
        return AjaxResult.success();
    }
}
