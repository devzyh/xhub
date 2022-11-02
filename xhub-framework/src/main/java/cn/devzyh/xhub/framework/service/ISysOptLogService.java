package cn.devzyh.xhub.framework.service;

import cn.devzyh.xhub.framework.domain.SysOptLog;

import java.util.List;

/**
 * 操作日志 服务层
 *
 * @author ruoyi
 */
public interface ISysOptLogService {
    /**
     * 新增操作日志
     *
     * @param optLog 操作日志对象
     */
    public void insertOptlog(SysOptLog optLog);

    /**
     * 查询系统操作日志集合
     *
     * @param optLog 操作日志对象
     * @return 操作日志集合
     */
    public List<SysOptLog> selectOptLogList(SysOptLog optLog);

    /**
     * 批量删除系统操作日志
     *
     * @param optIds 需要删除的操作日志ID
     * @return 结果
     */
    public int deleteOptLogByIds(Long[] optIds);

    /**
     * 查询操作日志详细
     *
     * @param optId 操作ID
     * @return 操作日志对象
     */
    public SysOptLog selectOptLogById(Long optId);

    /**
     * 清空操作日志
     */
    public void cleanOptLog();
}
