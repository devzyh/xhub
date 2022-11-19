package cn.devzyh.xhub.scheduler.service;

import cn.devzyh.xhub.scheduler.domain.SysJobLog;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * 定时任务调度日志信息信息 服务层
 */
public interface ISysJobLogService {

    /**
     * 获取quartz调度器日志的计划任务
     *
     * @param jobLog 调度日志信息
     * @return 调度任务日志集合
     */
    List<SysJobLog> selectJobLogList(IPage<SysJobLog> page, SysJobLog jobLog);

    /**
     * 通过调度任务日志ID查询调度信息
     *
     * @param jobLogId 调度任务日志ID
     * @return 调度任务日志对象信息
     */
    SysJobLog selectJobLogById(Long jobLogId);

    /**
     * 新增任务日志
     *
     * @param jobLog 调度日志信息
     */
    void addJobLog(SysJobLog jobLog);

    /**
     * 批量删除调度日志信息
     *
     * @param logIds 需要删除的日志ID
     * @return 结果
     */
    int deleteJobLogByIds(List<Long> logIds);

    /**
     * 删除任务日志
     *
     * @param jobId 调度日志ID
     * @return 结果
     */
    int deleteJobLogById(Long jobId);

    /**
     * 清空任务日志
     */
    void cleanJobLog();
}
