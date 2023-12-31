package cn.devzyh.xhub.scheduler.util;

import cn.devzyh.xhub.common.utils.SecurityUtils;
import cn.devzyh.xhub.scheduler.domain.SysJob;
import org.quartz.JobExecutionContext;

/**
 * 定时任务处理（允许并发执行）
 *
 * @author ruoyi
 */
public class QuartzJobExecution extends AbstractQuartzJob {
    @Override
    protected void doExecute(JobExecutionContext context, SysJob sysJob) throws Exception {
        SecurityUtils.schedulerUser();
        JobInvokeUtil.invokeMethod(sysJob);
    }
}
