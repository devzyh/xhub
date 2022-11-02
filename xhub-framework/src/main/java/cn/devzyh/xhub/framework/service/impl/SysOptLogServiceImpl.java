package cn.devzyh.xhub.framework.service.impl;

import cn.devzyh.xhub.framework.domain.SysOptLog;
import cn.devzyh.xhub.framework.mapper.SysOptLogMapper;
import cn.devzyh.xhub.framework.service.ISysOptLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 操作日志 服务层处理
 *
 * @author ruoyi
 */
@Service
public class SysOptLogServiceImpl implements ISysOptLogService {
    @Autowired
    private SysOptLogMapper optLogMapper;

    /**
     * 新增操作日志
     *
     * @param optLog 操作日志对象
     */
    @Override
    public void insertOptlog(SysOptLog optLog) {
        optLogMapper.insertOptlog(optLog);
    }

    /**
     * 查询系统操作日志集合
     *
     * @param optLog 操作日志对象
     * @return 操作日志集合
     */
    @Override
    public List<SysOptLog> selectOptLogList(SysOptLog optLog) {
        return optLogMapper.selectOptLogList(optLog);
    }

    /**
     * 批量删除系统操作日志
     *
     * @param optIds 需要删除的操作日志ID
     * @return 结果
     */
    @Override
    public int deleteOptLogByIds(Long[] optIds) {
        return optLogMapper.deleteOptLogByIds(optIds);
    }

    /**
     * 查询操作日志详细
     *
     * @param optId 操作ID
     * @return 操作日志对象
     */
    @Override
    public SysOptLog selectOptLogById(Long optId) {
        return optLogMapper.selectOptLogById(optId);
    }

    /**
     * 清空操作日志
     */
    @Override
    public void cleanOptLog() {
        optLogMapper.cleanOptLog();
    }
}
