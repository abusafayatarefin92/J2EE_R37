package com.springaopfour;

import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;

public class DoAfterReturningMethod implements AfterReturningAdvice{
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("****SPRING AOP**** DoAfterReturningMethod : Executing after method return!");
    }
}
