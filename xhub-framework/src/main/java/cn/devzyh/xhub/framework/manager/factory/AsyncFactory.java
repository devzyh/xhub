package cn.devzyh.xhub.framework.manager.factory;

import cn.devzyh.xhub.common.constant.Constants;
import cn.devzyh.xhub.common.utils.LogUtils;
import cn.devzyh.xhub.common.utils.ServletUtils;
import cn.devzyh.xhub.common.utils.StringUtils;
import cn.devzyh.xhub.common.utils.ip.AddressUtils;
import cn.devzyh.xhub.common.utils.ip.IpUtils;
import cn.devzyh.xhub.common.utils.spring.SpringUtils;
import cn.devzyh.xhub.framework.domain.SysLoginLog;
import cn.devzyh.xhub.framework.domain.SysOperLog;
import cn.devzyh.xhub.framework.service.ISysLoginLogService;
import cn.devzyh.xhub.framework.service.ISysOperLogService;
import eu.bitwalker.useragentutils.UserAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TimerTask;

/**
 * 异步工厂（产生任务用）
 *
 * @author ruoyi
 */
public class AsyncFactory {
    private static final Logger SysUserLogger = LoggerFactory.getLogger("sys-user");

    /**
     * 记录登录信息
     *
     * @param username 用户名
     * @param status   状态
     * @param message  消息
     * @param args     列表
     * @return 任务task
     */
    public static TimerTask recordLoginLog(final String username, final String status, final String message,
                                           final Object... args) {
        final UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
        final String ip = IpUtils.getIpAddr(ServletUtils.getRequest());
        return new TimerTask() {
            @Override
            public void run() {
                String address = AddressUtils.getRealAddressByIP(ip);
                StringBuilder s = new StringBuilder();
                s.append(LogUtils.getBlock(ip));
                s.append(address);
                s.append(LogUtils.getBlock(username));
                s.append(LogUtils.getBlock(status));
                s.append(LogUtils.getBlock(message));
                // 打印信息到日志
                SysUserLogger.info(s.toString(), args);
                // 获取客户端操作系统
                String os = userAgent.getOperatingSystem().getName();
                // 获取客户端浏览器
                String browser = userAgent.getBrowser().getName();
                // 封装对象
                SysLoginLog loginLog = new SysLoginLog();
                loginLog.setUserName(username);
                loginLog.setIpaddr(ip);
                loginLog.setLoginLocation(address);
                loginLog.setBrowser(browser);
                loginLog.setOs(os);
                loginLog.setMsg(message);
                // 日志状态
                if (StringUtils.equalsAny(status, Constants.LOGIN_SUCCESS, Constants.LOGOUT, Constants.REGISTER)) {
                    loginLog.setStatus(Constants.SUCCESS);
                } else if (Constants.LOGIN_FAIL.equals(status)) {
                    loginLog.setStatus(Constants.FAIL);
                }
                // 插入数据
                SpringUtils.getBean(ISysLoginLogService.class).insertLoginLog(loginLog);
            }
        };
    }

    /**
     * 操作日志记录
     *
     * @param optLog 操作日志信息
     * @return 任务task
     */
    public static TimerTask recordOperLog(final SysOperLog operLog) {
        return new TimerTask() {
            @Override
            public void run() {
                // 远程查询操作地点
                operLog.setOperIp(AddressUtils.getRealAddressByIP(operLog.getOperIp()));
                SpringUtils.getBean(ISysOperLogService.class).insertOperlog(operLog);
            }
        };
    }
}
