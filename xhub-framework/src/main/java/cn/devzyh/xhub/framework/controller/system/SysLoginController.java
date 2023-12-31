package cn.devzyh.xhub.framework.controller.system;

import cn.devzyh.xhub.common.constant.Constants;
import cn.devzyh.xhub.common.core.domain.Result;
import cn.devzyh.xhub.common.core.domain.entity.SysMenu;
import cn.devzyh.xhub.common.core.domain.entity.SysUser;
import cn.devzyh.xhub.common.core.domain.model.LoginBody;
import cn.devzyh.xhub.common.utils.SecurityUtils;
import cn.devzyh.xhub.framework.service.ISysMenuService;
import cn.devzyh.xhub.framework.web.service.SysLoginService;
import cn.devzyh.xhub.framework.web.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * 登录验证
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/rest")
public class SysLoginController {
    @Autowired
    private SysLoginService loginService;

    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private SysPermissionService permissionService;

    /**
     * 登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/api/login")
    public Result login(@RequestBody LoginBody loginBody) {
        Result ajax = Result.success();
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(),
                loginBody.getUuid());
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @GetMapping("/getInfo")
    public Result getInfo() {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);
        Result ajax = Result.success();
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("permissions", permissions);
        return ajax;
    }

    /**
     * 获取路由信息
     *
     * @return 路由信息
     */
    @GetMapping("/getRouters")
    public Result getRouters() {
        Long userId = SecurityUtils.getUserId();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(userId);
        return Result.success(menuService.buildMenus(menus));
    }
}
