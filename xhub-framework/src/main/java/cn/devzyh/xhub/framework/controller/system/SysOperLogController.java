package cn.devzyh.xhub.framework.controller.system;

import cn.devzyh.xhub.common.annotation.Log;
import cn.devzyh.xhub.common.core.controller.BaseController;
import cn.devzyh.xhub.common.core.domain.Result;
import cn.devzyh.xhub.common.core.page.TableDataInfo;
import cn.devzyh.xhub.common.enums.BusinessType;
import cn.devzyh.xhub.common.utils.poi.ExcelUtil;
import cn.devzyh.xhub.framework.domain.SysOperLog;
import cn.devzyh.xhub.framework.service.ISysOperLogService;
import com.baomidou.mybatisplus.core.metadata.IPage;
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
@RequestMapping("/rest/system/log/oper")
public class SysOperLogController extends BaseController {
    
    @Autowired
    private ISysOperLogService operLogService;

    @PreAuthorize("@ss.hasPermi('system:log:oper:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysOperLog operLog) {
        IPage<SysOperLog> page = getPage();
        return getDataTable(page, operLogService.selectOperLogList(page, operLog));
    }

    @Log(title = "操作日志", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('system:log:oper:export')")
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysOperLog operLog) {
        List<SysOperLog> list = operLogService.selectOperLogList(null, operLog);
        ExcelUtil<SysOperLog> util = new ExcelUtil<SysOperLog>(SysOperLog.class);
        util.exportExcel(response, list, "操作日志");
    }

    @Log(title = "操作日志", businessType = BusinessType.DELETE)
    @PreAuthorize("@ss.hasPermi('system:log:oper:remove')")
    @DeleteMapping("/{operIds}")
    public Result remove(@PathVariable List<Long> operIds) {
        return toResult(operLogService.deleteOperLogByIds(operIds));
    }

    @Log(title = "操作日志", businessType = BusinessType.CLEAN)
    @PreAuthorize("@ss.hasPermi('system:log:oper:remove')")
    @DeleteMapping("/clean")
    public Result clean() {
        operLogService.cleanOperLog();
        return Result.success();
    }
}
