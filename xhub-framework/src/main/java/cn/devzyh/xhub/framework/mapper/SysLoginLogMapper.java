package cn.devzyh.xhub.framework.mapper;

import cn.devzyh.xhub.framework.domain.SysLoginLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统访问日志情况信息 数据层
 */
@Mapper
public interface SysLoginLogMapper extends BaseMapper<SysLoginLog> {

    /**
     * 查询系统登录日志集合
     *
     * @param loginLog 访问日志对象
     * @return 登录记录集合
     */
    List<SysLoginLog> selectLoginLogList(IPage<SysLoginLog> page, @Param("log") SysLoginLog loginLog);

    /**
     * 清空系统登录日志
     *
     * @return 结果
     */
    int cleanLoginLog();
}
