/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestXianHongAPI
 * Date Created : 2020-12-24
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-12-24       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.zhihuiqingcheng;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.dailytest.testmain.testSendSoapRequest.HeaderMap;
import com.example.dailytest.testmain.testSendSoapRequest.HttpClientPoolUtils;
import com.example.dailytest.testmain.testSendSoapRequest.HttpClientResult;
import com.example.dailytest.utils.Constant;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: com.example.dailytest.zhihuiqingcheng
 * @description: xxx
 * @author: w15021
 * @create: 2020-12-24
 **/
@Slf4j
public class TestXianHongAPI {
    public static Object main(String[] args) {

        // 获取认证token
        JSONObject getTokenRequestBody = new JSONObject();
        getTokenRequestBody.put("grant_type", Constant.GRANTTYPE);
        getTokenRequestBody.put("client_id", Constant.CLIENTID);
        getTokenRequestBody.put("client_secret", Constant.CLIENTSECRET);

        HttpClientResult getTokenHcr = HttpClientPoolUtils.getHcr(
                Constant.GETTOKENMETHOD,
                Constant.BASEURL + Constant.GETTOKENPATH,
                "application/json", getTokenRequestBody);
        log.info("getTokenResult: {}", getTokenHcr);

        Object getTokenHcrEntityObject = getTokenHcr.getEntity();
        JSONObject resultEntityJSONObject = JSONObject.parseObject(getTokenHcrEntityObject.toString());
        String token = resultEntityJSONObject.getString("access_token");
        if (token == null || token == "") {
            //return "token获取异常，结果为空";
            log.info("token获取异常，结果为空");
        }


        // 获取设备列表
        JSONObject condition = new JSONObject();
        condition.put("equipTypeId", 5);

        JSONObject paging = new JSONObject();
        paging.put("pageIndex", 1);
        paging.put("pageSize", 1000);

        JSONObject getDeviceListRequestBody = new JSONObject();
        getDeviceListRequestBody.put("condition", condition);
        getDeviceListRequestBody.put("paging", paging);

        HeaderMap getDeviceListHeaderMap = new HeaderMap();
        getDeviceListHeaderMap.setKey(Constant.HEADERSAUTHORIZATION);

        getDeviceListHeaderMap.setValue("bearer " + token);

        List<HeaderMap> getDeviceListHeaderMapList = new ArrayList<HeaderMap>();
        getDeviceListHeaderMapList.add(getDeviceListHeaderMap);

        HttpClientResult getDeviceListHcr = HttpClientPoolUtils.getHcr(
                Constant.GETDEVICELISTMETHOD,
                Constant.BASEURL + Constant.GETDEVICELISTPATH,
                "application/json", getDeviceListRequestBody, getDeviceListHeaderMapList);

        log.info("getDeviceListResult: {}", getDeviceListHcr);
        if (getDeviceListHcr == null) {
            log.info("请求返回为空");
            return null;
        }

        Object getDeviceListHcrEntityObject = getDeviceListHcr.getEntity();
        if (getDeviceListHcrEntityObject == null) {
            log.info("请求返回为空");
            return null;
        }
        JSONObject getDeviceListResultEntityJSONObject = JSONObject.parseObject(getDeviceListHcrEntityObject.toString());
        if (getDeviceListResultEntityJSONObject == null) {
            log.info("请求返回为空");
            return null;
        }

        JSONArray resultJSONArray = getDeviceListResultEntityJSONObject.getJSONArray("result");
        if (resultJSONArray == null) {
            log.info("请求返回值中无result字段");
            return "";
        }
        for (Object resultObject : resultJSONArray) {
            if (resultObject == null) {
                log.info("result字段的值为空");
                return null;
            }
            JSONObject resultJsonObject = (JSONObject) resultObject;
            if (resultJsonObject == null) {
                log.info("result字段的值为空");
                return null;
            }

            JSONArray fieldsJSONArray = resultJsonObject.getJSONArray("fields");
            if (fieldsJSONArray == null) {
                log.info("请求返回值中无fields字段");
                return "";
            }
            for (Object fieldsObject : fieldsJSONArray) {
                if (fieldsObject == null) {
                    log.info("fileds字段的值为空");
                    return null;
                }
                JSONObject fieldsObjectJsonObject = (JSONObject) fieldsObject;
                if (fieldsObjectJsonObject == null) {
                    log.info("fileds字段的值为空");
                    return null;
                }
                String key = fieldsObjectJsonObject.getString("fieldCode");
                if (key == null) {
                    log.info("当前json中无fieldCode字段");
                    continue;
                }
                String value = fieldsObjectJsonObject.getString("value");
                if (value == null) {
                    log.debug("当前json中value值为空，将赋为默认值‘空值’");
                    value = "空值";
                }
                resultJsonObject.put(key, value);
            }
        }

        //System.out.println(getDeviceListResultEntityJSONObject.toString());
        return getDeviceListResultEntityJSONObject;
    }
}