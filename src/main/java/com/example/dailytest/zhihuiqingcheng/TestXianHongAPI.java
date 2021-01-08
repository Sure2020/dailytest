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
    //public static Object main(String[] args) {
    public static JSONObject main(JSONObject jsonObject) {
        int equipTypeId = -1;
        int pageIndex = -1;
        int pageSize = -1;
        if (jsonObject != null && jsonObject.size() != 0) {
            equipTypeId = jsonObject.getIntValue("equipTypeId");
            pageIndex = jsonObject.getIntValue("pageIndex");
            pageSize = jsonObject.getIntValue("pageSize");
        }

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
        JSONObject getDeviceListRequestBody = new JSONObject();

        if (equipTypeId != -1) {
            JSONObject condition = new JSONObject();
            condition.put("equipTypeId", equipTypeId);
            getDeviceListRequestBody.put("condition", condition);
        }

        if (pageIndex != -1 && pageSize != -1) {
            JSONObject paging = new JSONObject();
            paging.put("pageIndex", pageIndex);
            paging.put("pageSize", pageSize);
            getDeviceListRequestBody.put("paging", paging);
        }

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
            log.error("请求返回为空");
            return null;
        }

        Object getDeviceListHcrEntityObject = getDeviceListHcr.getEntity();
        if (getDeviceListHcrEntityObject == null) {
            log.error("请求返回为空");
            return null;
        }
        JSONObject getDeviceListResultEntityJSONObject = JSONObject.parseObject(getDeviceListHcrEntityObject.toString());
        if (getDeviceListResultEntityJSONObject == null) {
            log.error("请求返回为空");
            return null;
        }

        JSONArray resultJSONArray = getDeviceListResultEntityJSONObject.getJSONArray("result");
        if (resultJSONArray == null) {
            log.error("请求返回值中无result字段");
            return getDeviceListResultEntityJSONObject;
        }
        for (Object resultObject : resultJSONArray) {
            if (resultObject == null) {
                log.error("result字段的值为空");
                return getDeviceListResultEntityJSONObject;
            }
            JSONObject resultJsonObject = (JSONObject) resultObject;
            if (resultJsonObject == null) {
                log.error("result字段的值为空");
                return getDeviceListResultEntityJSONObject;
            }

            Integer alarmFlag = resultJsonObject.getIntValue("alarmFlag");
            if(alarmFlag == null){
                resultJsonObject.put("alarmFlag", 0);
            }
            String statusDetail = resultJsonObject.getString("statusDetail");
            if(statusDetail == null){
                resultJsonObject.put("statusDetail", alarmFlag.equals(0)?"正常":"异常");
            }

            JSONArray fieldsJSONArray = resultJsonObject.getJSONArray("fields");
            if (fieldsJSONArray == null) {
                log.error("请求返回值中无fields字段");
                return getDeviceListResultEntityJSONObject;
            }
            for (Object fieldsObject : fieldsJSONArray) {
                if (fieldsObject == null) {
                    log.error("fileds字段的值为空");
                    return getDeviceListResultEntityJSONObject;
                }
                JSONObject fieldsObjectJsonObject = (JSONObject) fieldsObject;
                if (fieldsObjectJsonObject == null) {
                    log.error("fileds字段的值为空");
                    return getDeviceListResultEntityJSONObject;
                }
                String key = fieldsObjectJsonObject.getString("fieldCode");
                if (key == null) {
                    log.error("当前json中无fieldCode字段");
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

        return getDeviceListResultEntityJSONObject;
    }
}