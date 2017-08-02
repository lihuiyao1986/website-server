package com.lys.entity.base;

import java.io.Serializable;

/**
 * 基础响应类
 */
public class BaseResp<T> implements Serializable{

    private static final long serialVersionUID = -5447860235020009457L;

    /** 返回码 */
    private String responseCode = "100000";

    /** 返回描述 */
    private String message = "运行正确";

    /** 返回结果对象 */
    private T result;

    public BaseResp() {
    }

    public BaseResp(T result) {
        this.result = result;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "BaseResp [responseCode=" + responseCode + ", message=" + message + ", result=" + result + "]";
    }

}
