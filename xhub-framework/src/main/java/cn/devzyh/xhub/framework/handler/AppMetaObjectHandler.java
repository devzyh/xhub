package cn.devzyh.xhub.framework.handler;

import cn.devzyh.xhub.common.constant.UserConstants;
import cn.devzyh.xhub.common.exception.ServiceException;
import cn.devzyh.xhub.common.utils.SecurityUtils;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

/**
 * MybatisPlus字段自动填充处理
 **/
public class AppMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        // 创建时自动带入系统信息
        String username;
        try {
            username = SecurityUtils.getUserName();
        } catch (ServiceException e) {
            username = UserConstants.SYSTEM;
        }
        Date now = new Date();
        if (metaObject.hasGetter("createBy")) {
            this.setFieldValByName("createBy", username, metaObject);
        }
        if (metaObject.hasGetter("createTime")) {
            this.setFieldValByName("createTime", now, metaObject);
        }
        if (metaObject.hasGetter("updateBy")) {
            this.setFieldValByName("updateBy", username, metaObject);
        }
        if (metaObject.hasGetter("updateTime")) {
            this.setFieldValByName("updateTime", now, metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        String username;
        try {
            username = SecurityUtils.getUserName();
        } catch (ServiceException e) {
            username = UserConstants.SYSTEM;
        }
        // 更新时自动更新系统信息
        if (metaObject.hasGetter("updateBy")) {
            this.setFieldValByName("updateBy", username, metaObject);
        }
        if (metaObject.hasGetter("updateTime")) {
            this.setFieldValByName("updateTime", new Date(), metaObject);
        }
    }

}
