package com.example.dailytest.zhihuiqingcheng.parkings;

import lombok.Data;

@Data
public class ParkingRequestBody {

    /**
     *  场库编号
     */
    private String parkingCode;

    /**
     * 区域编码
     */
    private String regionCode;
}
