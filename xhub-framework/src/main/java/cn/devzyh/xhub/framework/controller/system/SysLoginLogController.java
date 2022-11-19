package cn.devzyh.xhub.framework.controller.system;

import cn.devzyh.xhub.common.annotation.Log;
import cn.devzyh.xhub.common.core.controller.BaseController;
import cn.devzyh.xhub.common.core.domain.AjaxResult;
import cn.devzyh.xhub.common.core.page.TableDataInfo;
import cn.devzyh.xhub.common.enums.BusinessType;
import cn.devzyh.xhub.common.utils.poi.ExcelUtil;
import cn.devzyh.xhub.framework.domain.SysLoginLog;
import cn.devzyh.xhub.framework.service.ISysLoginLogService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 系统访问记录
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/rest/system/log/login")
public class SysLoginLogController extends BaseController {

    @Autowired
    private ISysLoginLogService loginLogService;

    @PreAuthorize("@ss.hasPermi('system:log:login:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysLoginLog loginLog) {
        IPage<SysLoginLog> page = getPage();
        return getDataTable(page, loginLogService.selectLoginLogList(page, loginLog));
    }

    @Log(title = "登录日志", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('system:log:login:export')")
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysLoginLog loginLog) {
        List<SysLoginLog> list = loginLogService.selectLoginLogList(null, loginLog);
        ExcelUtil<SysLoginLog> util = new ExcelUtil<SysLoginLog>(SysLoginLog.class);
        util.exportExcel(response, list, "登录日志");
    }

    @PreAuthorize("@ss.hasPermi('system:log:login:remove')")
    @Log(title = "登录日志", businessType = BusinessType.DELETE)
    @DeleteMapping("/{infoIds}")
    public AjaxResult remove(@PathVariable List<Long> infoIds) {
        return toAjax(loginLogService.deleteLoginLogByIds(infoIds));
    }

    @PreAuthorize("@ss.hasPermi('system:log:login:remove')")
    @Log(title = "登录日志", businessType = BusinessType.CLEAN)
    @DeleteMapping("/clean")
    public AjaxResult clean() {
        loginLogService.cleanLoginLog();
        return AjaxResult.success();
    }
}
