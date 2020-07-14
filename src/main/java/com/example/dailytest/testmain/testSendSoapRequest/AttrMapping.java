package com.example.dailytest.testmain.testSendSoapRequest;

import lombok.Data;

import java.util.List;

/**
 * @author lys1698
 * @date 2019/7/23 14:11
 */
@Data
public class AttrMapping {
    /**
     * 源属性标识
     */
    private String sourceAttrIndex;

    private String sourceAttrName;
    /**
     * 目标属性标识
     */
    private String targetAttrIndex;
    private String targetAttrName;

    /**
     * 映射值
     */
    private List<MappingValue> mappingValue;
}