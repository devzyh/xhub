package cn.devzyh.xhub.framework.controller.monitor;

import cn.devzyh.xhub.common.annotation.Log;
import cn.devzyh.xhub.common.constant.Constants;
import cn.devzyh.xhub.common.core.controller.BaseController;
import cn.devzyh.xhub.common.core.domain.Result;
import cn.devzyh.xhub.common.core.domain.model.LoginUser;
import cn.devzyh.xhub.common.core.page.PageResult;
import cn.devzyh.xhub.common.core.redis.RedisCache;
import cn.devzyh.xhub.common.enums.BusinessType;
import cn.devzyh.xhub.common.utils.StringUtils;
import cn.devzyh.xhub.framework.domain.SysUserOnline;
import cn.devzyh.xhub.framework.service.ISysUserOnlineService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 在线用户监控
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/rest/monitor/online")
public class SysUserOnlineController extends BaseController {
    @Autowired
    private ISysUserOnlineService userOnlineService;

    @Autowired
    private RedisCache redisCache;

    @PreAuthorize("@ss.hasPermi('monitor:online:list')")
    @GetMapping("/list")
    public PageResult list(String ipaddr, String userName) {
        Collection<String> keys = redisCache.keys(Constants.LOGIN_TOKEN_KEY + "*");
        List<SysUserOnline> userOnlineList = new ArrayList<SysUserOnline>();
        for (String key : keys) {
            LoginUser user = redisCache.getCacheObject(key);
            if (StringUtils.isNotEmpty(ipaddr) && StringUtils.isNotEmpty(userName)) {
                if (StringUtils.equals(ipaddr, user.getIpaddr()) && StringUtils.equals(userName, user.getUsername())) {
                    userOnlineList.add(userOnlineService.selectOnlineByInfo(ipaddr, userName, user));
                }
            } else if (StringUtils.isNotEmpty(ipaddr)) {
                if (StringUtils.equals(ipaddr, user.getIpaddr())) {
                    userOnlineList.add(userOnlineService.selectOnlineByIpaddr(ipaddr, user));
                }
            } else if (StringUtils.isNotEmpty(userName) && StringUtils.isNotNull(user.getUser())) {
                if (StringUtils.equals(userName, user.getUsername())) {
                    userOnlineList.add(userOnlineService.selectOnlineByUserName(userName, user));
                }
            } else {
                userOnlineList.add(userOnlineService.loginUserToUserOnline(user));
            }
        }
        Collections.reverse(userOnlineList);
        userOnlineList.removeAll(Collections.singleton(null));
        IPage<SysUserOnline> page = getPage();
        return getPageResult(page, userOnlineList.stream()
                .skip((page.getCurrent() - 1) * page.getSize())
                .limit(page.getSize())
                .collect(Collectors.toList()));
    }

    /**
     * 强退用户
     */
    @PreAuthorize("@ss.hasPermi('monitor:online:forceLogout')")
    @Log(title = "在线用户", businessType = BusinessType.FORCE)
    @DeleteMapping("/{tokenId}")
    public Result forceLogout(@PathVariable String tokenId) {
        redisCache.deleteObject(Constants.LOGIN_TOKEN_KEY + tokenId);
        return Result.success();
    }
}
