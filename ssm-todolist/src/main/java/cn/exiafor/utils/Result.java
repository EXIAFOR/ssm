package cn.exiafor.utils;

import lombok.Data;

/**
 * 返回结果类
 */
@Data
public class Result {
    // 200成功状态码
    private int code;
    // 返回状态
    private boolean flag;
    // 返回具体数据
    private Object data;

    public static Result ok(Object data) {
        Result r = new Result();
        r.code = 200;
        r.flag = true;
        r.data = data;
        return r;
    }

    public static Result fail(Object data) {
        Result r = new Result();
        r.code = 500; //错误码
        r.flag = false; //错误状态
        r.data = data;
        return r;
    }
}
