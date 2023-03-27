package org.example.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationHandler {
    // Field add => clazz, targetMethod
    private final Class<?> clazz;
    private final Method targetMethod;
    // AnnotationHandler => class[clazz], Method[targetMethod]
    public AnnotationHandler(Class<?> clazz, Method targetMethod) {
        this.clazz = clazz;
        this.targetMethod = targetMethod;
    }

    // handle method => req, res
    public String handle(HttpServletRequest req, HttpServletResponse res) throws Exception {
        // Constructor => clazz
        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
        // Object => handler
        Object handler = declaredConstructor.newInstance();

        // return String targetMethod => handler, req, res
        return (String) targetMethod.invoke(handler, req, res);
    }
}
