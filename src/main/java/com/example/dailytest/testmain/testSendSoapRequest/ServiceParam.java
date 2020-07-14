package com.example.dailytest.testmain.testSendSoapRequest;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Data
@Document(value = "serviceParam")
public class ServiceParam implements Serializable {
    private String modId;
    private String svcIndex;
    private List<ReqParams> reqParams;
    private List<BodyParams> bodyParams;
    private RespParams respParams;
    private List<DBParams> dbParams;
    private List<BodyStruct> bodyStructs;
    private List<RespAPIParams> respApiParams;
    private List<AttrMapping> attrMapping;
    private CustomizeScript customizeScript;
    private Subscribe subscribe;
    private Push push;
    private Header header;
    private WebService webService;
    private String respBindModId;

}
