/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : OPCData
 * Date Created : 2020-07-11
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-07-11       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.controller.testSoap;

/**
 * 用于视图的数据结构
 *
 * @author panda fang
 * @since 2015-03-15
 */
public class OPCData {

    /** OPC名称 */
    private String OPCName = "";

    /** OPC值 */
    private String OPCValue = "";

    /** OPC 值更新时间 */
    private String OPCTime = "";

    /**
     * @return OPC名称
     */
    public String getOPCName() {
        return OPCName;
    }

    /**
     * @param oPCName the oPCName to set
     */
    public void setOPCName(String oPCName) {
        OPCName = oPCName;
    }

    /**
     * @return OPC值
     */
    public String getOPCValue() {
        return OPCValue;
    }

    /**
     * @param oPCValue the oPCValue to set
     */
    public void setOPCValue(String oPCValue) {
        OPCValue = oPCValue;
    }

    /**
     * @return OPC 值更新时间
     */
    public String getOPCTime() {
        return OPCTime;
    }

    /**
     * @param oPCTime the oPCTime to set
     */
    public void setOPCTime(String oPCTime) {
        OPCTime = oPCTime;
    }




}