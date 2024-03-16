package com.supos.app.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.annotation.Annotation;
import java.lang.reflect.Parameter;

@Aspect
@Component
public class RequestBodyAspect {
    @Around("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public Object handleEmptyRequestBody(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Parameter[] parameters = methodSignature.getMethod().getParameters();

        for (int i = 0; i < parameters.length; i++) {
            RequestBody requestBody = AnnotationUtils.findAnnotation(parameters[i], RequestBody.class);
            if (requestBody != null && !requestBody.required() && args[i] == null) {
                // 尝试为该参数类型创建一个新的实例
                args[i] = createInstance(parameters[i].getType());
            }
        }

        return joinPoint.proceed(args);
    }

    private Object createInstance(Class<?> clazz) {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            // 处理异常，可能是无法实例化等问题
            e.printStackTrace();
            return null;
        }
    }
}

