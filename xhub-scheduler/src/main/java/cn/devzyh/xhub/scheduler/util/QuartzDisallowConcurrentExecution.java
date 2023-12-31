package cn.devzyh.xhub.scheduler.util;

import cn.devzyh.xhub.common.utils.SecurityUtils;
import cn.devzyh.xhub.scheduler.domain.SysJob;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;

/**
 * 定时任务处理（禁止并发执行）
 *
 * @author ruoyi
 */
@DisallowConcurrentExecution
public class QuartzDisallowConcurrentExecution extends AbstractQuartzJob {
    @Override
    protected void doExecute(JobExecutionContext context, SysJob sysJob) throws Exception {
        SecurityUtils.schedulerUser();
        JobInvokeUtil.invokeMethod(sysJob);
    }
}
