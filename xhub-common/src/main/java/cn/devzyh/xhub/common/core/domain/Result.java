package cn.devzyh.xhub.common.core.domain;

import cn.devzyh.xhub.common.constant.HttpStatus;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;


/**
 * 通用结果类
 */
@Data
@Accessors(chain = true)
public class Result<T> {

    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     */
    private int code;

    /**
     * 返回内容
     */
    private String msg;

    /**
     * 数据对象
     */
    private T data;

    /**
     * 初始化一个新创建的 Result 对象，使其表示一个空消息。
     */
    public Result() {
        this(0, null);
    }

    /**
     * 初始化一个新创建的 Result 对象
     *
     * @param code 状态码
     * @param msg  返回内容
     */
    public Result(int code, String msg) {
        this(code, msg, null);
    }

    /**
     * 初始化一个新创建的 Result 对象
     *
     * @param code 状态码
     * @param msg  返回内容
     * @param data 数据对象
     */
    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static <T> Result<T> success() {
        return Result.success("执行成功");
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static <T> Result<T> success(T data) {
        return Result.success("执行成功", data);
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
        return Result.error("执行失败");
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
     * 非法访问数据
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static <T> Result<T> forbidden() {
        return new Result<>(HttpStatus.FORBIDDEN, "权限错误");
    }


    /**
     * 是否为成功消息
     *
     * @return 结果
     */
    public boolean ok() {
        return Objects.equals(HttpStatus.SUCCESS, this.code);
    }

    /**
     * 是否为错误消息
     *
     * @return 结果
     */
    public boolean no() {
        return Objects.equals(HttpStatus.ERROR, this.code);
    }

    /**
     * 是Map类型的data添加数据
     * 非Map类型的data返回自身
     *
     * @param key
     * @param value
     * @return
     */
    public Result<T> put(String key, Object value) {
        if (!(this.data == null || this.data instanceof Map)) {
            return this;
        }

        Map<String, Object> map = null;
        if (this.data == null) {
            map = new LinkedHashMap<String, Object>();
        } else {
            map = (Map<String, Object>) this.data;
        }

        map.put(key, value);
        this.data = (T) map;
        return this;
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

}
