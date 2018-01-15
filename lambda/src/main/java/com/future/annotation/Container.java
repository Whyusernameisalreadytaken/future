package com.future.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,
        ElementType.TYPE_PARAMETER,ElementType.TYPE_USE,ElementType.MODULE})
@Documented
public @interface Container {
    Owner[] value();

    String s() default "";
}
