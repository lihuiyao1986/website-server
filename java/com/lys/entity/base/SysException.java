package com.lys.entity.base;

/**
 * Created by jk on 17/8/2.
 */
public class SysException extends BaseException{

    private static final long serialVersionUID = 2212457821752924707L;

    public SysException() {
        super ();
    }

    public SysException(SysExceptionMessage em) {
        super (em.getCode(), em.getMessage());
    }

    public SysException(SysExceptionMessage em, String extMessage) {
        super (em.getCode(), em.getMessage(), extMessage);
    }

    public SysException(SysExceptionMessage em, String[] args) {
        super (em.getCode(), em.getMessage(), args);
    }

    public SysException(SysExceptionMessage em, String[] args, String extMessage) {
        super (em.getCode(), em.getMessage(), args, extMessage);
    }
}
