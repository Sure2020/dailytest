package com.example.dailytest.testmain.testSendSoapRequest;

import lombok.Data;

import java.util.List;

@Data
public class BodyStruct {
    //参数的UUID;
    private String reqUUID;
    //参数索引
    private String reqParamField;
    //数组下表索引
    private Integer reqParamId;
    //参数数据类型
    private String reqDataType;
    private List<BodyStruct> bodyChildrens;

/*
    public BodyStruct() {
    }

    public BodyStruct(String reqUUID, String reqParamField, Integer reqParamId, String reqDataType, List<BodyStruct> bodyChildrens) {
        this.reqUUID = reqUUID;
        this.reqParamField = reqParamField;
        this.reqParamId = reqParamId;
        this.reqDataType = reqDataType;
        this.bodyChildrens = bodyChildrens;
    }

    public String getReqUUID() {
        return reqUUID;
    }

    public void setReqUUID(String reqUUID) {
        this.reqUUID = reqUUID;
    }

    public String getReqParamField() {
        return reqParamField;
    }

    public void setReqParamField(String reqParamField) {
        this.reqParamField = reqParamField;
    }

    public Integer getReqParamId() {
        return reqParamId;
    }

    public void setReqParamId(Integer reqParamId) {
        this.reqParamId = reqParamId;
    }

    public String getReqDataType() {
        return reqDataType;
    }

    public void setReqDataType(String reqDataType) {
        this.reqDataType = reqDataType;
    }

    public List<BodyChildren1> getBodyChildrens() {
        return bodyChildrens;
    }

    public void setBodyChildrens(List<BodyChildren1> bodyChildrens) {
        this.bodyChildrens = bodyChildrens;
    }
*/

    @Override
    public String toString() {
        return "BodyStruct{" +
                "reqUUID='" + reqUUID + '\'' +
                ", reqParamField='" + reqParamField + '\'' +
                ", reqParamId=" + reqParamId +
                ", reqDataType='" + reqDataType + '\'' +
                ", bodyChildrens=" + bodyChildrens +
                '}';
    }
}
