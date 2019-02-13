package com.arefin.springaoptwo;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class DoAfterReturningMethod implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("****SPRING AOP**** DoAfterReturningMethod : Executing after method return!");
    }
}
