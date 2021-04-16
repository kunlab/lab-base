package com.kunlab.base.core.exception;

/**
 * 基础异常类，所有自定义业务异常类都需要继承此类
 * @author likun
 * @date 2021/4/16
 */
public class BaseException extends Exception{

    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }
}
