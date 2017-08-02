package com.lys.annotation;

import java.lang.annotation.*;

/**
 * Created by jk on 17/8/2.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {
    String value() default "";
}
