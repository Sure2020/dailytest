package com.example.dailytest.testmain.testSendSoapRequest;

import lombok.Data;

/**
 * @author lys1698
 * @date 2019/7/23 14:12
 */
@Data
public class CustomizeScript {
    /**
     * 源属性
     */
    private String[] sourceAttrIndex;
    /**
     * 目标属性
     */
    private String[] targetAttrIndex;
    /**
     * 脚本在hdfs上路径
     */
    private String filePath;
    /**
     * 用户脚本文件名
     */
    private String scriptName;
}