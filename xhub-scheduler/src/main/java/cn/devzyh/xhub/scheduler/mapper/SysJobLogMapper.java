package cn.devzyh.xhub.scheduler.mapper;

import cn.devzyh.xhub.scheduler.domain.SysJobLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 调度任务日志信息 数据层
 */
@Mapper
public interface SysJobLogMapper extends BaseMapper<SysJobLog> {

    /**
     * 获取quartz调度器日志的计划任务
     *
     * @param jobLog 调度日志信息
     * @return 调度任务日志集合
     */
    List<SysJobLog> selectJobLogList(IPage<SysJobLog> page, @Param("log") SysJobLog jobLog);

    /**
     * 清空任务日志
     */
    void cleanJobLog();
}
