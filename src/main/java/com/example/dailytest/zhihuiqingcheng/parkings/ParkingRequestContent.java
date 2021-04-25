package com.example.dailytest.zhihuiqingcheng.parkings;

import lombok.Data;

@Data
public class ParkingRequestContent {
    /**
     * 接⼊系统编号
     */
    private String access_id;

    /**
     * 发送请求的时间，格式时间戳
     */
    private Long timestamp;

    /**
     * 签名算法类型，
     * 默认使⽤RSA
     */
    private String sign_type = "RSA";

    /**
     * 请求格式,⽬前仅⽀持 JSON
     */
    private String format = "JSON";

    /**
     * 请求参数的签名串
     */
    private String sign;

    /**
     * 业务参数集合
     */
    private ParkingRequestBody biz_context;
}
