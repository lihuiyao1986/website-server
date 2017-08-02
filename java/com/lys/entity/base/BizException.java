package com.lys.entity.base;


/**
 * 业务异常类
 */
public class BizException extends BaseException {

    private static final long serialVersionUID = 5171771394185469307L;

    public BizException() {
        super ();
    }

    public BizException(BizExceptionMessage em) {
        super (em.getCode(), em.getMessage());
    }

    public BizException(BizExceptionMessage em, String extMessage) {
        super (em.getCode(), em.getMessage(), extMessage);
    }

    public BizException(BizExceptionMessage em,  String[] args) {
        super (em.getCode(), em.getMessage(), args);
    }

    public BizException(BizExceptionMessage em,  String[] args, String extMessage) {
        super (em.getCode(), em.getMessage(), args, extMessage);
    }
}
