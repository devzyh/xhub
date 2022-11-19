package cn.devzyh.xhub.framework.mapper;

import cn.devzyh.xhub.framework.domain.SysOperLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 操作日志 数据层
 */
@Mapper
public interface SysOperLogMapper extends BaseMapper<SysOperLog> {

    /**
     * 查询系统操作日志集合
     *
     * @param operLog 操作日志对象
     * @return 操作日志集合
     */
    List<SysOperLog> selectOperLogList(IPage<SysOperLog> page, @Param("log") SysOperLog operLog);

    /**
     * 清空操作日志
     */
    void cleanOperLog();
}
