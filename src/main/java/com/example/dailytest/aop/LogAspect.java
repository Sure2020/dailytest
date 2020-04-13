/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : LogAspect
 * Date Created : 2020-04-13
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-04-13       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @program: com.example.dailytest.aop
 * @description: xxx
 * @author: w15021
 * @create: 2020-04-13
 **/
@Aspect
@Component
public class LogAspect {
    // 定义一个切入点
    //@Pointcut("execution(* com.example.dailytest.aop.*.*(..))")
    @Pointcut("execution(* com.example.dailytest.aop.UserService.getUserById(..))")
    public void pc1(){

    }

    // 前置通知
    @Before(value = "pc1()")
    public void before(JoinPoint jp) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法开始执行...");
    }

    // 后置通知
    @After(value = "pc1()")
    public void after(JoinPoint jp) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法执行结束...");
    }

    // 返回通知
    @AfterReturning(value = "pc1()", returning = "testResult")
    public void afterReturning(JoinPoint jp, Object testResult) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法返回值为：" + testResult);
    }

    // 异常通知
    @AfterThrowing(value = "pc1()", throwing = "e")
    public void afterThrowing(JoinPoint jp, Exception e) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法抛异常了，异常是：" + e.getMessage());
    }

    // 环绕通知
    @Around("pc1()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        String name = pjp.getSignature().getName();
        // 统计方法执行时间
        long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        long end = System.currentTimeMillis();
        System.out.println(name + "方法执行时间为：" + (end - start) + " ms");
        return result;
    }
}