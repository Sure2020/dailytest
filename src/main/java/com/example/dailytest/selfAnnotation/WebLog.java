/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : WebLog
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

package com.example.dailytest.selfAnnotation;

/**
 * @program: com.example.dailytest.selfAnnotation
 * @description: xxx
 * @author: w15021
 * @create: 2020-04-13
 **/
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface WebLog {
    /**
     * 日志描述信息
     *
     * @return
     */
    String description() default "";

}