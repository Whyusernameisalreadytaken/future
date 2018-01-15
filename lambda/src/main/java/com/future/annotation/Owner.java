package com.future.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,
ElementType.TYPE_PARAMETER,ElementType.TYPE_USE,ElementType.MODULE})

@Repeatable(Container.class)
public @interface Owner {

    String value() default "";

}
