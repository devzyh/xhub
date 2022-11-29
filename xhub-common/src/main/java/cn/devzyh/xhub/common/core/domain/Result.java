package cn.devzyh.xhub.common.core.domain;

import cn.devzyh.xhub.common.constant.HttpStatus;
import cn.devzyh.xhub.common.utils.StringUtils;

import java.util.HashMap;
import java.util.Objects;

/**
 * 通用结果类
 */
public class Result<T> extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     */
    public static final String CODE_TAG = "code";

    /**
     * 返回内容
     */
    public static final String MSG_TAG = "msg";

    /**
     * 数据对象
     */
    public static final String DATA_TAG = "data";

    /**
     * 初始化一个新创建的 Result 对象，使其表示一个空消息。
     */
    public Result() {
    }

    /**
     * 初始化一个新创建的 Result 对象
     *
     * @param code 状态码
     * @param msg  返回内容
     */
    public Result(int code, String msg) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
    }

    /**
     * 初始化一个新创建的 Result 对象
     *
     * @param code 状态码
     * @param msg  返回内容
     * @param data 数据对象
     */
    public Result(int code, String msg, Object data) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        if (StringUtils.isNotNull(data)) {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * 设置消息
     *
     * @param msg
     * @return
     */
    public Result<T> setMsg(String msg) {
        this.put(MSG_TAG, msg);
        return this;
    }

    /**
     * 获取消息
     *
     * @return
     */
    public String getMsg() {
        Object obj = this.get(DATA_TAG);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    /**
     * 设置数据
     *
     * @param data
     */
    public Result<T> setData(T data) {
        this.put(DATA_TAG, data);
        return this;
    }

    /**
     * 获取数据
     *
     * @param
     * @return
     */
    public T getData() {
        Object obj = this.get(DATA_TAG);
        if (obj == null) {
            return null;
        }
        return (T) obj;
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static <T> Result<T> success() {
        return Result.success("操作成功");
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static <T> Result<T> success(T data) {
        return Result.success("操作成功", data);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static <T> Result<T> success(String msg) {
        return Result.success(msg, null);
    }

    /**
     * 返回成功消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static <T> Result<T> success(String msg, T data) {
        return new Result<>(HttpStatus.SUCCESS, msg, data);
    }

    /**
     * 返回警告消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static <T> Result<T> warn(String msg) {
        return Result.warn(msg, null);
    }

    /**
     * 返回警告消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static <T> Result<T> warn(String msg, T data) {
        return new Result<>(HttpStatus.WARN, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @return
     */
    public static <T> Result<T> error() {
        return Result.error("操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static <T> Result<T> error(String msg) {
        return Result.error(msg, null);
    }

    /**
     * 返回错误消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static <T> Result<T> error(String msg, T data) {
        return new Result<>(HttpStatus.ERROR, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @param code 状态码
     * @param msg  返回内容
     * @return 警告消息
     */
    public static <T> Result<T> error(int code, String msg) {
        return new Result<>(code, msg, null);
    }

    /**
     * 是否为成功消息
     *
     * @return 结果
     */
    public boolean isSuccess() {
        return Objects.equals(HttpStatus.SUCCESS, this.get(CODE_TAG));
    }

    /**
     * 是否为错误消息
     *
     * @return 结果
     */
    public boolean isError() {
        return !isSuccess();
    }

    /**
     * 根据受影响行数返回消息
     *
     * @param rows
     * @param <T>
     * @return
     */
    public static <T> Result<T> of(int rows) {
        if (rows > 0) {
            return success();
        } else {
            return error();
        }
    }

    /**
     * 方便链式调用
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public Result<T> put(String key, Object value) {
        super.put(key, value);
        return this;
    }

}
