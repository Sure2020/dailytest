/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestSimplifyJSONObject
 * Date Created : 2020-07-16
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-07-16       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2020-07-16
 **/
@Slf4j
public class TestSimplifyJSONObject {

    public static void main(String[] args) {
        System.out.println("TestSimplifyJSONObject");
        StringBuilder sb = new StringBuilder();
        //sb.append("{\"ReadResponse\":{\"xmlns\":\"http:\\/\\/opcfoundation.org\\/webservices\\/XMLDA\\/1.0\\/\",\"RItemList\":{\"Items\":[{\"ClientItemHandle\":1,\"ValueTypeQualifier\":\"VT_BOOL\",\"Quality\":{\"QualityField\":\"uncertain\"},\"Value\":{\"xsi:type\":\"xsd:boolean\",\"xmlns:xsi\":\"http:\\/\\/www.w3.org\\/2001\\/XMLSchema-instance\",\"content\":0},\"ItemName\":\"Demo_W7.1001.D3.风机启动\"},{\"ClientItemHandle\":2,\"ValueTypeQualifier\":\"VT_R4\",\"Quality\":{\"QualityField\":\"good\"},\"Value\":{\"xsi:type\":\"xsd:float\",\"xmlns:xsi\":\"http:\\/\\/www.w3.org\\/2001\\/XMLSchema-instance\",\"content\":5.2},\"ItemName\":\"Demo_W7.1001.D3.送风温度\"}]},\"ReadResult\":{\"RevisedLocaleID\":\"en-us\",\"RcvTime\":\"2020-07-16T11:52:52\",\"ServerState\":\"running\",\"ClientRequestHandle\":\"\",\"ReplyTime\":\"2020-07-16T11:52:52\"}}}");
        sb.append("{\"ReadResponse\":{\"xmlns\":\"http:\\/\\/opcfoundation.org\\/webservices\\/XMLDA\\/1.0\\/\",\"RItemList\":{\"Items\":{\"ClientItemHandle\":1,\"ValueTypeQualifier\":\"VT_BOOL\",\"Quality\":{\"QualityField\":\"uncertain\"},\"Value\":{\"xsi:type\":\"xsd:boolean\",\"xmlns:xsi\":\"http:\\/\\/www.w3.org\\/2001\\/XMLSchema-instance\",\"content\":0},\"ItemName\":\"Demo_W7.1001.D3.风机启动\"}},\"ReadResult\":{\"RevisedLocaleID\":\"en-us\",\"RcvTime\":\"2020-07-16T11:52:52\",\"ServerState\":\"running\",\"ClientRequestHandle\":\"\",\"ReplyTime\":\"2020-07-16T11:52:52\"}}}");
        JSONObject jsonObject = JSONObject.parseObject(sb.toString());
        System.out.println(jsonObject);
        simplifyJSONObject(jsonObject, "content", null, null);
        System.out.println("##############################");
        System.out.println(jsonObject);
    }
    /**
     * @description: 精简json对象。就是把指定的key向外挪一层。
     * @param: 
     * @return: 
     * @author: w15021
     * @date: 2020/7/16
     */

    /*
    递归终结条件：keyset中包含targetKey
    递归终结动作：保存当前targetKey的targetValue，保存父key，remove父key，新增父key:targetValue
     */
    public static void simplifyJSONObject (JSONObject sourceJSONObject, String targetKey, JSONObject parentJSONObject, String parentKey){
        if(sourceJSONObject.keySet().contains(targetKey) && parentKey != null) {
            Object targetValue = sourceJSONObject.get(targetKey);
            parentJSONObject.remove(targetKey);
            parentJSONObject.put(parentKey, targetValue.toString());
        } else {
            for (String currentKey : sourceJSONObject.keySet()){
                Object currentObject = sourceJSONObject.get(currentKey);
                if(currentObject instanceof JSONObject){
                    simplifyJSONObject((JSONObject)currentObject, targetKey, sourceJSONObject, currentKey);
                } else {
                    continue;
                }

            }
        }
    }
}