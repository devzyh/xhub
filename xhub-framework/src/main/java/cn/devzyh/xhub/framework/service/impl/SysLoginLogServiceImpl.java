package cn.devzyh.xhub.framework.service.impl;

import cn.devzyh.xhub.framework.domain.SysLoginLog;
import cn.devzyh.xhub.framework.mapper.SysLoginLogMapper;
import cn.devzyh.xhub.framework.service.ISysLoginLogService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统访问日志情况信息 服务层处理
 */
@Service
public class SysLoginLogServiceImpl implements ISysLoginLogService {

    @Autowired
    private SysLoginLogMapper loginLogMapper;

    /**
     * 新增系统登录日志
     *
     * @param loginLog 访问日志对象
     */
    @Override
    public int insertLoginLog(SysLoginLog loginLog) {
        return loginLogMapper.insert(loginLog);
    }

    /**
     * 查询系统登录日志集合
     *
     * @param loginLog 访问日志对象
     * @return 登录记录集合
     */
    @Override
    public List<SysLoginLog> selectLoginLogList(IPage<SysLoginLog> page, SysLoginLog loginLog) {
        if (page.orders().isEmpty()) {
            page.orders().add(new OrderItem("info_id", true));
        }
        return loginLogMapper.selectLoginLogList(page, loginLog);
    }

    /**
     * 批量删除系统登录日志
     *
     * @param infoIds 需要删除的登录日志ID
     * @return 结果
     */
    @Override
    public int deleteLoginLogByIds(List<Long> infoIds) {
        return loginLogMapper.deleteBatchIds(infoIds);
    }

    /**
     * 清空系统登录日志
     */
    @Override
    public void cleanLoginLog() {
        loginLogMapper.cleanLoginLog();
    }
}
