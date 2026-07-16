package com.dongdan.annotation;

import java.lang.annotation.*;

/**
 * 标记需要记录操作日志的方法
 * 放在 Controller 的 POST/PUT/DELETE 方法上
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogOperation {

    /** 操作描述，如 "新增产品" */
    String value();

    /** 目标类型，如 "产品" "分类" "Banner" */
    String type() default "";
}
