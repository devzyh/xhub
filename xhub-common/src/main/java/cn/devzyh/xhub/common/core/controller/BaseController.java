package cn.devzyh.xhub.common.core.controller;

import cn.devzyh.xhub.common.constant.HttpStatus;
import cn.devzyh.xhub.common.core.domain.Result;
import cn.devzyh.xhub.common.core.domain.model.LoginUser;
import cn.devzyh.xhub.common.core.page.PageDomain;
import cn.devzyh.xhub.common.core.page.PageResult;
import cn.devzyh.xhub.common.core.page.PageSupport;
import cn.devzyh.xhub.common.utils.DateUtils;
import cn.devzyh.xhub.common.utils.SecurityUtils;
import cn.devzyh.xhub.common.utils.StringUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.List;

/**
 * web层通用数据处理
 *
 * @author ruoyi
 */
public class BaseController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(DateUtils.parseDate(text));
            }
        });
    }

    /**
     * 设置请求分页数据
     *
     * @return
     */
    protected <T> Page<T> getPage() {
        PageDomain pageDomain = PageSupport.buildPageRequest();
        Page<T> page = new Page<>();
        page.setCurrent(pageDomain.getPageNum());
        page.setSize(pageDomain.getPageSize());
        OrderItem item = pageDomain.getOrderItem();
        if (item != null) {
            page.addOrder(item);
        }
        return page;
    }

    /**
     * 响应请求分页数据
     */
    protected PageResult getPageResult(IPage<?> page) {
        return getPageResult(page, null);
    }

    /**
     * 响应请求分页数据
     */
    protected PageResult getPageResult(IPage<?> page, List<?> records) {
        PageResult result = new PageResult();
        result.setCode(HttpStatus.SUCCESS);
        if (records == null) {
            result.setRows(page.getRecords());
        } else {
            result.setRows(records);
        }
        result.setMsg("查询成功");
        result.setTotal(page.getTotal());
        return result;
    }

    /**
     * 返回成功
     */
    public Result success() {
        return Result.success();
    }

    /**
     * 返回失败消息
     */
    public Result error() {
        return Result.error();
    }

    /**
     * 返回成功消息
     */
    public Result success(String message) {
        return Result.success(message);
    }

    /**
     * 返回失败消息
     */
    public Result error(String message) {
        return Result.error(message);
    }

    /**
     * 响应返回结果
     *
     * @param rows 影响行数
     * @return 操作结果
     */
    protected Result toResult(int rows) {
        return rows > 0 ? Result.success() : Result.error();
    }

    /**
     * 响应返回结果
     *
     * @param result 结果
     * @return 操作结果
     */
    protected Result toResult(boolean result) {
        return result ? success() : error();
    }

    /**
     * 页面跳转
     */
    public String redirect(String url) {
        return StringUtils.format("redirect:{}", url);
    }

    /**
     * 获取用户缓存信息
     */
    public LoginUser getLoginUser() {
        return SecurityUtils.getLoginUser();
    }

    /**
     * 获取登录用户id
     */
    public Long getUserId() {
        return getLoginUser().getUserId();
    }

    /**
     * 获取登录部门id
     */
    public Long getDeptId() {
        return getLoginUser().getDeptId();
    }

    /**
     * 获取登录用户名
     */
    public String getUsername() {
        return getLoginUser().getUsername();
    }
}
