package cn.devzyh.xhub.scheduler.mapper;

import cn.devzyh.xhub.scheduler.domain.SysJob;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 调度任务信息 数据层
 */
@Mapper
public interface SysJobMapper extends BaseMapper<SysJob> {

    /**
     * 查询调度任务日志集合
     *
     * @param job 调度信息
     * @return 操作日志集合
     */
    List<SysJob> selectJobList(IPage<SysJob> page, @Param("job") SysJob job);

}
