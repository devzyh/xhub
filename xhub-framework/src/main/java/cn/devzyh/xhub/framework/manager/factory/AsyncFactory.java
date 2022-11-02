package cn.devzyh.xhub.framework.manager.factory;

import cn.devzyh.xhub.common.constant.Constants;
import cn.devzyh.xhub.common.utils.LogUtils;
import cn.devzyh.xhub.common.utils.ServletUtils;
import cn.devzyh.xhub.common.utils.StringUtils;
import cn.devzyh.xhub.common.utils.ip.AddressUtils;
import cn.devzyh.xhub.common.utils.ip.IpUtils;
import cn.devzyh.xhub.common.utils.spring.SpringUtils;
import cn.devzyh.xhub.framework.domain.SysLoginLog;
import cn.devzyh.xhub.framework.domain.SysOptLog;
import cn.devzyh.xhub.framework.service.ISysLoginLogService;
import cn.devzyh.xhub.framework.service.ISysOptLogService;
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
    private static final Logger sys_user_logger = LoggerFactory.getLogger("sys-user");

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
                sys_user_logger.info(s.toString(), args);
                // 获取客户端操作系统
                String os = userAgent.getOperatingSystem().getName();
                // 获取客户端浏览器
                String browser = userAgent.getBrowser().getName();
                // 封装对象
                SysLoginLog logininfor = new SysLoginLog();
                logininfor.setUserName(username);
                logininfor.setIpaddr(ip);
                logininfor.setLoginLocation(address);
                logininfor.setBrowser(browser);
                logininfor.setOs(os);
                logininfor.setMsg(message);
                // 日志状态
                if (StringUtils.equalsAny(status, Constants.LOGIN_SUCCESS, Constants.LOGOUT, Constants.REGISTER)) {
                    logininfor.setStatus(Constants.SUCCESS);
                } else if (Constants.LOGIN_FAIL.equals(status)) {
                    logininfor.setStatus(Constants.FAIL);
                }
                // 插入数据
                SpringUtils.getBean(ISysLoginLogService.class).insertLoginLog(logininfor);
            }
        };
    }

    /**
     * 操作日志记录
     *
     * @param optLog 操作日志信息
     * @return 任务task
     */
    public static TimerTask recordOptLog(final SysOptLog optLog) {
        return new TimerTask() {
            @Override
            public void run() {
                // 远程查询操作地点
                optLog.setOptLocation(AddressUtils.getRealAddressByIP(optLog.getOptIp()));
                SpringUtils.getBean(ISysOptLogService.class).insertOptlog(optLog);
            }
        };
    }
}
