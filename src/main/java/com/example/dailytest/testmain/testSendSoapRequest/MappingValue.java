package com.example.dailytest.testmain.testSendSoapRequest;

import lombok.Data;

/**
 * @author lys1698
 * @date 2019/7/23 14:23
 */
@Data
public class MappingValue {
    /**
     * 源属性值
     */
    private String sourceValue;

    private String sourceValueDes;
    /**
     * 目标属性值
     */
    private String targetValue;

    private String targetValueDes;


}