package com.example.dailytest.testmain.testSendSoapRequest;

import lombok.Data;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
public class ReqParams implements Serializable {
    //参数名称
    @Pattern(regexp = "^[\\u4e00-\\u9fa5a-zA-Z0-9][\\u4e00-\\u9fa5a-zA-Z0-9_]{0,}$", message = "reqParams中的服务参数名由中文、数字、字母或下划线组成，下划线不能开头，长度不超过30，中文算2位")
    private String reqParamName;
    //参数字段
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_]{0,49}$", message = "reqParams中的字段参数不能为空且不超过50个字符，支持英文大小写、数字、下划线，必须以英文开头")
    private String reqParamField;
    //是否关联属性
    private Boolean isRelationField;
    //关联的属性标识
    private String reqParamBindIndex;
    //关联的属性名
    private String reqParamBindAttr;
    //默认值
    private String reqDefault;
    //数据类型
    @Pattern(regexp = "^(int32|float|double|boolean|enum|string)$", message = "reqParams中数据类型参数错误")
    private String reqDataType;

    public ReqParams() {
    }

    public ReqParams(String reqParamName, String reqParamField, Boolean isRelationField, String reqParamBindIndex, String reqDefault, String reqDataType) {
        this.reqParamName = reqParamName;
        this.reqParamField = reqParamField;
        this.isRelationField = isRelationField;
        this.reqParamBindIndex = reqParamBindIndex;
        this.reqDefault = reqDefault;
        this.reqDataType = reqDataType;
    }

    /*
        public ReqParams(String reqParamName, String reqParamField, Boolean isRelationField, String reqParamBindIndex, String reqDefault, String reqDataType) {
            this.reqParamName = reqParamName;
            this.reqParamField = reqParamField;
            this.isRelationField = isRelationField;
            this.reqParamBindIndex = reqParamBindIndex;
            this.reqDefault = reqDefault;
            this.reqDataType = reqDataType;
        }

        public String getReqParamName() {
            return reqParamName;
        }

        public void setReqParamName(String reqParamName) {
            this.reqParamName = reqParamName;
        }

        public String getReqParamField() {
            return reqParamField;
        }

        public void setReqParamField(String reqParamField) {
            this.reqParamField = reqParamField;
        }

        public Boolean getRelationField() {
            return this.isRelationField;
        }

        public void setRelationField(Boolean relationField) {
            isRelationField = relationField;
        }

        public String getReqParamBindIndex() {
            return reqParamBindIndex;
        }

        public void setReqParamBindIndex(String reqParamBindIndex) {
            this.reqParamBindIndex = reqParamBindIndex;
        }

        public String getReqDefault() {
            return reqDefault;
        }

        public void setReqDefault(String reqDefault) {
            this.reqDefault = reqDefault;
        }

        public String getReqDataType() {
            return reqDataType;
        }

        public void setReqDataType(String reqDataType) {
            this.reqDataType = reqDataType;
        }
    public void setRelationField(Boolean relationField) {
        isRelationField = relationField;
    }

    public Boolean getRelationField() {
        return this.isRelationField;
    }*/

    @Override
    public String toString() {
        return "ReqParams{" +
                "reqParamName='" + reqParamName + '\'' +
                ", reqParamField='" + reqParamField + '\'' +
                ", isRelationField=" + isRelationField +
                ", reqParamBindIndex='" + reqParamBindIndex + '\'' +
                ", reqDefault='" + reqDefault + '\'' +
                ", reqDataType='" + reqDataType + '\'' +
                '}';
    }
}
