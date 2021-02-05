/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : InfoEntity
 * Date Created : 2021-02-02
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2021-02-02       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

import static org.springframework.data.mongodb.core.index.IndexDirection.DESCENDING;

/**
 * @program: com.example.dailytest.entity
 * @description: xxx
 * @author: w15021
 * @create: 2021-02-02
 **/
@Data
@Document(collection = "entityCollection")
@CompoundIndex(name = "mod_entity", def = "{modId:1,entityId:1}", unique = true)
/**
 * 该实体类包含普通实体和终端实体
 * availability  [int,int]标识该实体是否已失效，内部的属性是否已更改，0-未失效、未更改，1-已失效、已更改
 */
@AllArgsConstructor
@NoArgsConstructor
public class InfoEntity implements Serializable {
    private static final long serialVersionUID = -811355532076187067L;
    private String shopId;
    @Indexed
    private String modId;
    private String entityId;
    private int isUpdate;
    private int entityType;
    private String terminalOid;
    private JSONObject attributes;
    @Indexed(direction = DESCENDING)
    private Date updateTime;
}