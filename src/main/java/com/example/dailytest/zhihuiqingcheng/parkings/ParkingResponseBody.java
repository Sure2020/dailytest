package com.example.dailytest.zhihuiqingcheng.parkings;

import lombok.Data;

@Data
public class ParkingResponseBody {
    /**
     * 区域编码
     */
    private String regionCode;

    /**
     * 区域名称
     */
    private String regionName;

    /**
     * 停车场名称
     */
    private String parkingName;

    /**
     * 停车场编码
     */
    private String parkingCode;

    /**
     * 停车场编码
     */
    private String berthTotal;

    /**
     * 占用泊位数
     */
    private String occupyBerthTotal;

    /**
     * 空闲泊位数
     */
    private String freeBerthTotal;

    /**
     * Cgcs 经度
     */
    private String cgcs2000Long;

    /**
     * Cgcs 纬度
     */
    private String cgcs2000Lat;

    /**
     * 高德经度
     */
    private String amapLong;

    /**
     * 高德纬度
     */
    private String amapLat;
}
