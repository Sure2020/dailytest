package com.example.dailytest.zhihuiqingcheng.parkings;

import cn.hutool.http.HttpStatus;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.example.dailytest.testmain.testSendSoapRequest.HttpClientPoolUtils;
import com.example.dailytest.testmain.testSendSoapRequest.HttpClientResult;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

/**
 * 获取停车场信息
 */
@Slf4j
public class ParkingUtil {

    public static ParkingResponse getParkingList(String url, String privateKey,ParkingRequestContent parkingRequestContent) {

        try {
            String  jsonString  = JSON.toJSONString(parkingRequestContent);

            JSONObject jsonObject =JSON.parseObject(jsonString, Feature.OrderedField);

            String encryption = jsonObject.toJSONString();

            log.info("需要加密的json体------->>>>>>>>>>" + encryption);
            String sign = CciSignature.sign(jsonObject, privateKey);

            jsonObject =JSON.parseObject(jsonString, Feature.OrderedField);

            jsonObject.put("sign",sign);

            //改造
            HttpClientResult getParkingListHttpClientResult = HttpClientPoolUtils.getPostResult(url, "application/json", jsonObject);
            Object getParkingListHcrEntityObject = getParkingListHttpClientResult.getEntity();
            if (getParkingListHcrEntityObject == null) {
                log.error("请求返回为空");
                return null;
            }

            ParkingResponse parkingResponse = JSON.parseObject(getParkingListHcrEntityObject.toString(),ParkingResponse.class);

            //return sendRequest(url,jsonObject.toJSONString());
            return parkingResponse;
        }
        catch (Exception e) {
            log.error(e.getMessage(),e);
        }
        return new ParkingResponse();
    }


    private static ParkingResponse sendRequest(String url , String paramStr){
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            log.info("获取停车场信息url为---->>>>>" + url);
            log.info("获取停车场信息param为---->>>>>" + paramStr);
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, paramStr);
            Request request = new Request.Builder()
                    .url(url)
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .build();
            Response response = client.newCall(request).execute();

            String responseBody = response.body().string();

            ParkingResponse parkingResponse = JSON.parseObject(responseBody,ParkingResponse.class);

            if (HttpStatus.HTTP_OK==parkingResponse.getResult_code()) {
                //return parkingResponse.getData();
                return parkingResponse;
            }else {
                log.error("请求失败:" +parkingResponse.getResult_code() + "，异常信息为--->" + parkingResponse.getResult_msg());
            }
        }catch (Exception e) {
            log.error("请求失败" +e.getMessage(),e);
        }
        return new ParkingResponse();
    }
}
