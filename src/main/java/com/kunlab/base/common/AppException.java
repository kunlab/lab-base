package com.kunlab.base.common;

import com.kunlab.base.core.constant.IResultCodeEnum;
import com.kunlab.base.core.exception.BaseException;

/**
 * 自定义业务异常类
 * @author likun
 * @date 2021/4/16
 */
public class AppException extends BaseException {

    //错误码
    private String code;

    //错误描述
    private String msg;

    public AppException(String code) {
        super(code);
        this.code = code;
    }

    public AppException(String code, String msg) {
        super(String.format("%s : %s", code, msg));
        this.code = code;
        this.msg = msg;
    }

    public AppException(Throwable cause, String code, String msg) {
        super(String.format("%s : %s", code, msg), cause);
        this.code = code;
        this.msg = msg;
    }

    public AppException(IResultCodeEnum errorEnum) {
        super(String.format("%s : %s", errorEnum.getCode(), errorEnum.getDesc()));
        this.code = errorEnum.getCode();
        this.msg = errorEnum.getDesc();
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
