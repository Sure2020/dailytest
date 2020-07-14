package com.example.dailytest.testmain.testSendSoapRequest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.dom4j.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author lys1698
 * @date 2019/10/19 15:25
 */
@Component
public class XmlUtil {
    public static String jsonToXml(JSONObject jsonObject,String operation, String namespace) {
        String xml1 = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <" + operation + " xmlns=\"" + namespace + "\"" + ">\n";
        String xml2 = "    </" + operation + ">\n"+"  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String body = json2xml(jsonObject);
        String xml = xml1 + body + xml2;
        return xml;
    }

    public static String XmlTojson(String xml, String resType) {
        if ("xml".equals(resType)) {
            try{
                Document doc= DocumentHelper.parseText(xml);
                JSONObject json=new JSONObject();
                dom4j2Json(doc.getRootElement(), json);
                return json.toJSONString();
            } catch (DocumentException e) {
                e.printStackTrace();
                return null;
            }
        }
        else if ("json".equals(resType)) {
            return xml;
        }
        return xml;
    }

    /*
    下面这个json2xml是被改造过的，为了适配辽宁高速项目的华维网关soap接口的请求体和响应体风格，
    后来考虑到不污染现有代码，避免引入问题，将对该函数的改动还原，并写一个新的函数实现。
    辽宁高速soap接口特殊之处是参数都是以key=value的形式放在标签中，如下所示：
    <Options
        ReturnItemName=true
        LocalID="en-US"
    />
    而json2xml拼装后的样子是：
    <Options>
        <ReturnItemName>true</ReturnItemName>
        <LocalID>"en-US"<LocalID/>
    </OPtions>
     */

    /*public static String json2xml(JSONObject jsonObj) {
        StringBuffer buff = new StringBuffer();
        JSONObject tempObj = null;
        JSONArray tempArr = null;
        for (String temp : jsonObj.keySet()) {
            jsonObj.get(temp);
            if (jsonObj.get(temp) instanceof JSONObject) {
                buff.append("<" + temp.trim() + ">");
                tempObj = (JSONObject) jsonObj.get(temp);
                buff.append(json2xml(tempObj));
                buff.append("</" + temp.trim() + ">");
            } else if (jsonObj.get(temp) instanceof JSONArray) {
                buff.append("<" + temp.trim() + ">");
                tempArr = (JSONArray) jsonObj.get(temp);
                if (tempArr.size() > 0) {
                    for (int i = 0; i < tempArr.size(); i++) {
                        tempObj = (JSONObject) tempArr.get(i);
                        buff.append(json2xml(tempObj));
                    }
                }
                buff.append("</" + temp.trim() + ">");
            } else {
                buff.append("<" + temp.trim() + " ");
                String tempStr = jsonObj.get(temp).toString();
                buff.append(tempStr.trim());
                buff.append("></" + temp.trim() + ">");
            }
        }
        return buff.toString();
    }*/

    public static String json2xml(JSONObject jsonObj) {
        StringBuffer buff = new StringBuffer();
        JSONObject tempObj = null;
        JSONArray tempArr = null;
        for (String temp : jsonObj.keySet()) {
            buff.append("<" + temp.trim() + ">");
            jsonObj.get(temp);
            if (jsonObj.get(temp) instanceof JSONObject) {
                tempObj = (JSONObject) jsonObj.get(temp);
                buff.append(json2xml(tempObj));
            } else if (jsonObj.get(temp) instanceof JSONArray) {
                tempArr = (JSONArray) jsonObj.get(temp);
                if (tempArr.size() > 0) {
                    for (int i = 0; i < tempArr.size(); i++) {
                        tempObj = (JSONObject) tempArr.get(0);
                        buff.append(json2xml(tempObj));
                    }
                }
            } else {
                String tempStr = jsonObj.get(temp).toString();
                buff.append(tempStr.trim());
            }
            buff.append("</" + temp.trim() + ">");
        }
        return buff.toString();
    }

    public static void dom4j2Json(Element element, JSONObject json){
        //如果是属性
        for(Object o:element.attributes()){
            Attribute attr=(Attribute)o;
            if(!isEmpty(attr.getValue())){
                json.put("@"+attr.getName(), attr.getValue());
            }
        }
        List<Element> chdEl=element.elements();
        if(chdEl.isEmpty()&&!isEmpty(element.getText())){//如果没有子元素,只有一个值
            if(isjson(element.getText())) {
                json.put(element.getName(), JSONObject.parseObject(element.getText()));
            } else if(isjsonArray(element.getText())) {
                json.put(element.getName(), JSONObject.parseArray(element.getText()));
            } else {
                json.put(element.getName(), element.getText());
            }
        }

        for(Element e:chdEl){//有子元素
            if(!e.elements().isEmpty()){//子元素也有子元素
                JSONObject chdjson=new JSONObject();
                dom4j2Json(e,chdjson);
                Object o=json.get(e.getName());
                if(o!=null){
                    JSONArray jsona=null;
                    if(o instanceof JSONObject){//如果此元素已存在,则转为jsonArray
                        JSONObject jsono=(JSONObject)o;
                        json.remove(e.getName());
                        jsona=new JSONArray();
                        jsona.add(jsono);
                        jsona.add(chdjson);
                    }
                    if(o instanceof JSONArray){
                        jsona=(JSONArray)o;
                        jsona.add(chdjson);
                    }
                    json.put(e.getName(), jsona);
                }else{
                    if(!chdjson.isEmpty()){
                        json.put(e.getName(), chdjson);
                    }
                }


            }else{//子元素没有子元素
                for(Object o:element.attributes()){
                    Attribute attr=(Attribute)o;
                    if(!isEmpty(attr.getValue())){
                        json.put("@"+attr.getName(), attr.getValue());
                    }
                }
                if(!e.getText().isEmpty()){
                    if(isjson(e.getText())) {
                        json.put(e.getName(), JSONObject.parseObject(e.getText()));
                    } else if(isjsonArray(e.getText())) {
                        json.put(e.getName(), JSONObject.parseArray(e.getText()));
                    } else {
                        json.put(e.getName(), e.getText());
                    }

                }
            }
        }
    }

    public static boolean isEmpty(String str) {

        if (str == null || str.trim().isEmpty() || "null".equals(str)) {
            return true;
        }
        return false;
    }


    private static boolean isjson(String str){
        try {
            JSONObject jsonStr= JSONObject.parseObject(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isjsonArray(String str){
        try {
            JSONArray jsonStr= JSONObject.parseArray(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}