package com.lys.aop;

import com.lys.annotation.Login;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * 登录拦截的aop
 */
@Aspect
@Component
public class LoginAspect {

    private  static  final Logger logger = LoggerFactory.getLogger(LoginAspect.class);


    @Pointcut("execution( * com.lys.api..*.*(..))")
    public void loginAspect(){

    }


    @Before("loginAspect()")
    public void validateLogin(JoinPoint joinpoint){
        if(logger.isInfoEnabled()){
            logger.info("开始校验登录");
        }
        MethodSignature joinPointObject = (MethodSignature) joinpoint.getSignature();
        joinPointObject.getMethod().isAnnotationPresent(Login.class);
    }
}
