package com.jools.annotation_;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 让注解处理器处理创建一个数据库表
 * @author Jools He
 */
@Target(ElementType.TYPE)   // 只适用于类
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {

    String name() default "";
}
