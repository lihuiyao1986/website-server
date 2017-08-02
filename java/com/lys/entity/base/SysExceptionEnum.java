package com.lys.entity.base;

/**
 * Created by jk on 17/8/2.
 */
public enum SysExceptionEnum implements SysExceptionMessage {


    /** 系统繁忙，请稍后再试! */
    SYSTEM_ERROR("900000", "系统繁忙，请稍后再试!"),
    /** 系统升级中，请稍后再试! */
    SYSTEM_UPDATE("900001", "系统升级中，请稍后再试!"),
    /** 系统业务暂停，请稍后再试! */
    SYSTEM_OFF("900002", "系统业务暂停，请稍后再试!")

    ;

    private String code;

    private String message;

    private SysExceptionEnum(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
