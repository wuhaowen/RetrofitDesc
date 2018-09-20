package com.wuhaowen.desc;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 添加接口描述
 */
@Documented
@Target(METHOD)
@Retention(RUNTIME)
public @interface DESC {
    String value() default "";
}
