package com.example.dailytest.testmain.testSendSoapRequest;

import lombok.Data;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
public class DBParams implements Serializable {
    //数据库字段
    @Pattern(regexp = "^[a-zA-Z_][a-zA-Z0-9_.]{0,49}$",message = "dbParams中的数据库字段不能为空且不超过50个字符，支持英文大小写、数字、下划线和英文.符号，必须以英文或下划线开头")
    private String dbField;
    //关联的属性标识
    private String dbIndex;
    //关联的属性名
    private String dbRelation;

    private Boolean markIndex;

    public DBParams() {
    }

    public DBParams(String dbField, String dbIndex) {
        this.dbField = dbField;
        this.dbIndex = dbIndex;
    }

    public String getDbField() {
        return dbField;
    }

    public void setDbField(String dbField) {
        this.dbField = dbField;
    }

    public String getDbIndex() {
        return dbIndex;
    }

    public void setDbIndex(String dbIndex) {
        this.dbIndex = dbIndex;
    }

    @Override
    public String toString() {
        return "DBParams{" +
                "dbField='" + dbField + '\'' +
                ", dbIndex='" + dbIndex + '\'' +
                '}';
    }
}
