package com.example.littletreestronger.common;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AopOnclick {

    /**
     * 点击间隔时间
     */
    long value() default 1000;

}
