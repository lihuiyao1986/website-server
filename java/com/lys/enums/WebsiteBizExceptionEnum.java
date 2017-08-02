package com.lys.enums;


import com.lys.entity.base.BizExceptionMessage;

/**
 * Created by jk on 17/8/1.
 */
public enum WebsiteBizExceptionEnum  implements BizExceptionMessage {

    PARAMERROR("10001","参数异常"),
    NOASSOCIATEDARTICLE("10002","此菜单暂无关联文章"),
    PARSEERROR("10003","json解析异常")
    ;
    // ===============================================
    private String code;

    private String message;

    private WebsiteBizExceptionEnum(String code, String message){
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
