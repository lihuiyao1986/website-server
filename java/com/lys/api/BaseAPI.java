package com.lys.api;

import com.alibaba.druid.util.StringUtils;
import com.lys.entity.base.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by jk on 17/8/2.
 */
public class BaseAPI {

    private static final Logger logger_exp = LoggerFactory.getLogger("logger_exp");

    private static final DateFormat DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private static final DateFormat TIMEFORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    /**
     *
     * @Description: 获取32位随机码
     * @author 王海彤 （1929）
     * @date 2017年3月13日 上午9:58:59
     * @return String
     */
    protected String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     *
     * @Description:请求时，日期格式转换处理
     * @Author:王海彤
     * @Since:2015年9月28日下午1:49:52
     * @param binder
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new SpringBindDateEditor(true));
    }

    /**
     *
     * @Description:异常处理
     * @Author:王海彤
     * @Since:2015年10月8日上午8:49:54
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResp<?> handleException(Exception ex, HttpServletRequest request) {
        logger_exp.error("接口（" + request.getRequestURI() + "）发生异常：", ex);
        BaseException exception = null;
        BaseResp<?> response = new ExceptionResponse<>();
        if (ex instanceof SysException) {
            exception = (SysException) ex;
        } else if (ex instanceof BizException) {
            exception = (BizException) ex;
        } else if (ex instanceof NullPointerException || ex instanceof ArrayIndexOutOfBoundsException || ex instanceof IOException) {
            exception = new SysException(SysExceptionEnum.SYSTEM_ERROR); // 系统异常
        } else {
            exception = new SysException(SysExceptionEnum.SYSTEM_ERROR); // 未知错误
        }
        response.setResponseCode(exception.getErrorCode());
        response.setMessage(exception.getMessage());
        return response;
    }

    /**
     * 自定义日期参数绑定
     */
    class SpringBindDateEditor extends PropertyEditorSupport {

        private boolean allowEmpty = true;

        public SpringBindDateEditor(boolean allowEmpty) {
            this.allowEmpty = allowEmpty;
        }

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            if (this.allowEmpty && !StringUtils.isEmpty(text)) {
                // Treat empty String as null value.
                setValue(null);
            } else {
                try {
                    if (text.contains(":")) {
                        Date date = TIMEFORMAT.parse(text);
                        setValue(date);
                    } else {
                        setValue(DATEFORMAT.parse(text));
                    }
                } catch (Exception ex) {
                    throw new IllegalArgumentException("Could not parse date: " + ex.getMessage(), ex);
                }
            }
        }

        @Override
        public String getAsText() {
            Date value = (Date) getValue();
            return (value != null ? TIMEFORMAT.format(value) : "");
        }
    }
}
