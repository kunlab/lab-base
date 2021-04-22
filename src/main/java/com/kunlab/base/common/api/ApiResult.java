package com.kunlab.base.common.api;

import java.io.Serializable;

/**
 * API 请求响应类
 *
 * @author likun
 * @date 2021-04-16
 */
public class ApiResult<T> implements Serializable {
    //模块名称
    private String apiName;


    //请求平台标示
    private String platform;
    //请求应用名称
    private String appName;
    //请求序列码
    private String serialNum;
    //请求处理开始时间
    private long reqHandleStartTime = System.currentTimeMillis();


    //响应时间
    private long time;
    //响应码
    private String status = "00000000";
    //响应描述
    private String message = "success";
    //保留字段
    private String info;
    //扩展字段
    private T result;


    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

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

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public long getReqHandleStartTime() {
        return reqHandleStartTime;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
