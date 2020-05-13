/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : PageResult
 * Date Created : 2020-05-12
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-05-12       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testMongoConnection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分页结果.
 *
 * @author Ryan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class PageResult<T> {

    /**
     * 页码，从1开始
     */
    private Integer pageNum;

    /**
     * 页面大小
     */
    private Integer pageSize;


    /**
     * 总数
     */
    private Long total;

    /**
     * 总页数
     */
    private Integer pages;

    /**
     * 数据
     */
    private List<T> list;

}