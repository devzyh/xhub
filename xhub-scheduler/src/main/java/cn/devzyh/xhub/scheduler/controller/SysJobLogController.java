package cn.devzyh.xhub.scheduler.controller;

import cn.devzyh.xhub.common.annotation.Log;
import cn.devzyh.xhub.common.core.controller.BaseController;
import cn.devzyh.xhub.common.core.domain.Result;
import cn.devzyh.xhub.common.core.page.PageResult;
import cn.devzyh.xhub.common.enums.BusinessType;
import cn.devzyh.xhub.common.utils.poi.ExcelUtil;
import cn.devzyh.xhub.scheduler.domain.SysJobLog;
import cn.devzyh.xhub.scheduler.service.ISysJobLogService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 调度日志操作处理
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/rest/monitor/job/log")
public class SysJobLogController extends BaseController {
    @Autowired
    private ISysJobLogService jobLogService;

    /**
     * 查询定时任务调度日志列表
     */
    @PreAuthorize("@ss.hasPermi('monitor:job:list')")
    @GetMapping("/list")
    public PageResult list(SysJobLog sysJobLog) {
        IPage<SysJobLog> page = getPage();
        return getPageResult(page, jobLogService.selectJobLogList(page, sysJobLog));
    }

    /**
     * 导出定时任务调度日志列表
     */
    @PreAuthorize("@ss.hasPermi('monitor:job:export')")
    @Log(title = "任务调度日志", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysJobLog sysJobLog) {
        List<SysJobLog> list = jobLogService.selectJobLogList(null, sysJobLog);
        ExcelUtil<SysJobLog> util = new ExcelUtil<SysJobLog>(SysJobLog.class);
        util.exportExcel(response, list, "调度日志");
    }

    /**
     * 根据调度编号获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('monitor:job:query')")
    @GetMapping(value = "/{configId}")
    public Result getInfo(@PathVariable Long jobLogId) {
        return Result.success(jobLogService.selectJobLogById(jobLogId));
    }


    /**
     * 删除定时任务调度日志
     */
    @PreAuthorize("@ss.hasPermi('monitor:job:remove')")
    @Log(title = "定时任务调度日志", businessType = BusinessType.DELETE)
    @DeleteMapping("/{jobLogIds}")
    public Result remove(@PathVariable List<Long> jobLogIds) {
        return toResult(jobLogService.deleteJobLogByIds(jobLogIds));
    }

    /**
     * 清空定时任务调度日志
     */
    @PreAuthorize("@ss.hasPermi('monitor:job:remove')")
    @Log(title = "调度日志", businessType = BusinessType.CLEAN)
    @DeleteMapping("/clean")
    public Result clean() {
        jobLogService.cleanJobLog();
        return Result.success();
    }
}
