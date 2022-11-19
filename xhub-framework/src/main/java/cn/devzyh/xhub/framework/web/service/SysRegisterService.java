package cn.devzyh.xhub.framework.web.service;

import cn.devzyh.xhub.common.constant.Constants;
import cn.devzyh.xhub.common.constant.UserConstants;
import cn.devzyh.xhub.common.core.domain.entity.SysUser;
import cn.devzyh.xhub.common.core.domain.model.RegisterBody;
import cn.devzyh.xhub.common.core.redis.RedisCache;
import cn.devzyh.xhub.common.exception.user.CaptchaException;
import cn.devzyh.xhub.common.exception.user.CaptchaExpireException;
import cn.devzyh.xhub.common.utils.MessageUtils;
import cn.devzyh.xhub.common.utils.SecurityUtils;
import cn.devzyh.xhub.common.utils.StringUtils;
import cn.devzyh.xhub.framework.manager.AsyncManager;
import cn.devzyh.xhub.framework.manager.factory.AsyncFactory;
import cn.devzyh.xhub.framework.service.ISysConfigService;
import cn.devzyh.xhub.framework.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 注册校验方法
 *
 * @author ruoyi
 */
@Component
public class SysRegisterService {
    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysConfigService configService;

    @Autowired
    private RedisCache redisCache;

    /**
     * 注册
     */
    public String register(RegisterBody registerBody) {
        SysUser user = new SysUser();
        user.setUserName(registerBody.getUsername());
        user.setNickName(registerBody.getUsername());
        user.setPassword(SecurityUtils.encryptPassword(registerBody.getPassword()));
        String msg = "";

        boolean captchaOnOff = configService.selectCaptchaOnOff();
        // 验证码开关
        if (captchaOnOff) {
            validateCaptcha(user.getUserName(), registerBody.getCode(), registerBody.getUuid());
        }

        if (StringUtils.isEmpty(user.getUserName())) {
            msg = "用户名不能为空";
        } else if (StringUtils.isEmpty(registerBody.getPassword())) {
            msg = "用户密码不能为空";
        } else if (user.getUserName().length() < UserConstants.USERNAME_MIN_LENGTH
                || user.getUserName().length() > UserConstants.USERNAME_MAX_LENGTH) {
            msg = "账户长度必须在2到20个字符之间";
        } else if (user.getUserName().length() < UserConstants.PASSWORD_MIN_LENGTH
                || user.getUserName().length() > UserConstants.PASSWORD_MAX_LENGTH) {
            msg = "密码长度必须在5到20个字符之间";
        } else if (UserConstants.NOT_UNIQUE.equals(userService.checkUserNameUnique(user))) {
            msg = "保存用户'" + user.getUserName() + "'失败，注册账号已存在";
        } else {
            boolean regFlag = userService.registerUser(user);
            if (!regFlag) {
                msg = "注册失败,请联系系统管理人员";
            } else {
                AsyncManager.me().execute(AsyncFactory.recordLoginLog(user.getUserName(), Constants.REGISTER,
                        MessageUtils.message("user.register.success")));
            }
        }
        return msg;
    }

    /**
     * 校验验证码
     *
     * @param username 用户名
     * @param code     验证码
     * @param uuid     唯一标识
     * @return 结果
     */
    public void validateCaptcha(String username, String code, String uuid) {
        String verifyKey = Constants.CAPTCHA_CODE_KEY + StringUtils.nvl(uuid, "");
        String captcha = redisCache.getCacheObject(verifyKey);
        redisCache.deleteObject(verifyKey);
        if (captcha == null) {
            throw new CaptchaExpireException();
        }
        if (!code.equalsIgnoreCase(captcha)) {
            throw new CaptchaException();
        }
    }
}
