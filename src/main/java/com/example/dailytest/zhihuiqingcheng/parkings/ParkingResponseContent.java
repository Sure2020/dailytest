package com.example.dailytest.zhihuiqingcheng.parkings;

import lombok.Data;

import java.util.List;

@Data
public class ParkingResponseContent {

    /**
     * 停车场总数
     */
    private Long total;

    /**
     * 停车场总泊位数
     */
    private Long totalBerth;

    /**
     * 停车场总占用泊位数
     */
    private Long totalOccupyBerth;

    /**
     * 停车场总空闲泊位数
     */
    private Long freeOccupyBerth;

    /**
     * 停车场信息列表
     */
    private List<ParkingResponseBody> parkings;

}
