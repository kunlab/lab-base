package com.kunlab.core.constant;

/**
 * 结果码枚举接口，所有自定义结果码枚举需要实现接口
 * @author likun
 * @date 2021/4/16
 */
public interface IResultCodeEnum {

    /**
     * 是否成功
     * @return true：成功； false:未成功
     */
    boolean isSuccess();

    /**
     * 结果码
     * @return 结果代码
     */
    String getCode();

    /**
     * 结果码描述
     * @return 结果码含义
     */
    String getDesc();

}
