package com.kunlab.base.common.api;

import java.io.Serializable;

/**
 * API 请求封装类
 * @author likun
 * @date 2021-04-16
 */
public class ApiReq<T> implements Serializable {

    //请求平台标示
    private String platform;
    //请求应用名称
    private String appName;
    //请求时间
    private long time = System.currentTimeMillis();
    //请求流水号
    private String serialNum;
    //业务请求参数
    private T appVo;

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public long getTime() {
        return time;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public T getAppVo() {
        return appVo;
    }

    public void setAppVo(T appVo) {
        this.appVo = appVo;
    }
}
