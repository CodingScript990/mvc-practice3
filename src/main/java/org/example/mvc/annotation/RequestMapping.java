package org.example.mvc.annotation;

import org.example.mvc.controller.RequestMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
    // value
    String value() default "";

    // requestMethod[GET, POST]
    RequestMethod[] method() default {};
}
