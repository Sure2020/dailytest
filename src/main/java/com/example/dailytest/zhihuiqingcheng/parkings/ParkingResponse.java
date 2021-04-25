package com.example.dailytest.zhihuiqingcheng.parkings;

import lombok.Data;

@Data
public class ParkingResponse {
    /**
     * 操作返回码
     */
    private Integer result_code;

    /**
     *  参⻅返回码说明
     */
    private String result_msg;

    /**
     * 返回信息
     */
    private ParkingResponseContent data;
}
