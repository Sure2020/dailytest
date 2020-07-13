/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : SOAPClient
 * Date Created : 2020-07-11
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-07-11       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.controller.testSoap;

//import com.example.dailytest.controller.testSoap.dependency.*;
import org.opcfoundation.webservices.xmlda._1.*;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.soap.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;

/**
 * @program: com.example.dailytest.controller.testSoap
 * @description: xxx
 * @author: w15021
 * @create: 2020-07-11
 **/
public class SOAPClient {

    // 其实就 webservice 的 url
//	private static final String endpoint = "http://webservice.webxml.com.cn/WebServices/WeatherWebService.asmx";
    public static String endpoint = "http://127.0.0.1:8086/soap";
    //public static String endpoint = "http://192.168.147.45:80/soap";
    private static final String namespace = "http://opcfoundation.org/webservices/XMLDA/1.0/";


    private List<String> serverSubHandleList = new ArrayList<String>();

    public static void main(String[] args) throws SOAPException, JAXBException {
        try {
            List<OPCData> list = new ArrayList<OPCData>();
//			new SOAPClient().browse("", list);
            SOAPClient client = new SOAPClient();
            client.getStatus();
            client.browse("", list);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            client.read(list);
            //System.out.println(list.toString());
            for(int i = 0; i < list.size(); i++){
                System.out.println("name: " + list.get(i).getOPCName());
                System.out.println("value: " + list.get(i).getOPCValue());
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


//    private static String getXmlFromSOAPMessage(SOAPMessage msg) throws SOAPException, IOException {
//        ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
//        msg.writeTo(byteArrayOS);
//        return new String(byteArrayOS.toByteArray());
//    }

    public GetStatusResponse getStatus() throws SOAPException, IOException, JAXBException
    {
        //  创建消息对象
        // ===========================================
        SOAPMessage message = MessageFactory.newInstance().createMessage();
        SOAPHeader header = message.getSOAPHeader();
        header.detachNode();

        MimeHeaders mh = message.getMimeHeaders();
        mh.addHeader("SOAPAction", "http://opcfoundation.org/webservices/XMLDA/1.0/GetStatus");

        // 获取soap的信封
        SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
        envelope.setPrefix("soap");

        // 获取消息的body
        SOAPBody body = message.getSOAPBody();
        body.setPrefix("soap");
//        QName bodyName =  new QName(namespace, "GetStatus LocaleID=\"en-US\" ClientRequestHandle=\"\"");
        QName bodyName =  new QName(namespace, "GetStatus");
        SOAPBodyElement bodyElement = body.addBodyElement(bodyName);
        bodyElement.setAttribute("LocaleID", "en-US");
        bodyElement.setAttribute("ClientRequestHandle", "");

        SOAPConnection connection = SOAPConnectionFactory.newInstance().createConnection();
        SOAPMessage response = connection.call(message, endpoint);
        connection.close();

        SOAPBody responseBody = response.getSOAPBody();
        NodeList list =  responseBody.getChildNodes();
        JAXBContext jaxbContext = JAXBContext.newInstance(GetStatusResponse.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        GetStatusResponse statusResponse = (GetStatusResponse) jaxbUnmarshaller.unmarshal(list.item(1));
        System.out.println(statusResponse.getStatus().getStatusInfo());

        return statusResponse;
    }

    public List<OPCData> browse(String itemName, List<OPCData> opcDataList) throws SOAPException, IOException, JAXBException
    {
        if (opcDataList == null) {
            throw new NullPointerException("opcDataList can not be null");
        }
        //  创建消息对象
        // ===========================================
        SOAPMessage message = MessageFactory.newInstance().createMessage();
        SOAPHeader header = message.getSOAPHeader();
        header.detachNode();

        MimeHeaders mh = message.getMimeHeaders();
        mh.addHeader("SOAPAction", "http://opcfoundation.org/webservices/XMLDA/1.0/Browse");

        // 获取soap的信封
        SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
        envelope.setPrefix("soap");
        // 获取消息的body
        SOAPBody body = message.getSOAPBody();
        body.setPrefix("soap");

        QName bodyName =  new QName(namespace, "Browse");
        SOAPBodyElement bodyElement = body.addBodyElement(bodyName);

        bodyElement.setAttribute("LocaleID", "en-US");
        bodyElement.setAttribute("ClientRequestHandle", "");
        bodyElement.setAttribute("ItemName", itemName);
        bodyElement.setAttribute("MaxElementsReturned", "500");
        bodyElement.setAttribute("ElementNameFilter", "");
        bodyElement.setAttribute("VendorFilter", "");
        bodyElement.setAttribute("ReturnErrorText", "true");



        SOAPConnection connection = SOAPConnectionFactory.newInstance().createConnection();
        SOAPMessage response = connection.call(message, endpoint);
        connection.close();

        SOAPBody responseBody = response.getSOAPBody();
        NodeList list = responseBody.getChildNodes();
        JAXBContext jaxbContext = JAXBContext.newInstance(BrowseResponse.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        BrowseResponse browseResponse = (BrowseResponse) jaxbUnmarshaller.unmarshal(list.item(1));
        List<BrowseElement> elmList = browseResponse.getElements();
        int len = elmList.size();
        BrowseElement tmpbe = null;
        for (int i = 0; i < len; i++) {
            tmpbe = elmList.get(i);
            if (tmpbe != null)
            {
                if (tmpbe.isIsItem() == true)		// Item
                {
                    String szTemp = tmpbe.getItemName();
                    if (szTemp.indexOf("$") == -1)
                    {
                        OPCData data = new OPCData();
                        data.setOPCName( tmpbe.getItemName() );
                        opcDataList.add(data);

                    }
                }
                else		// Branch
                {
                    if ( !"".equals(tmpbe.getItemName()))
                    {
                        browse(tmpbe.getItemName(), opcDataList);
                        try {
                            Thread.sleep(5);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }


        }

        try {

//          System.out.println(getXmlFromSOAPMessage(message));
//          System.out.println(getXmlFromSOAPMessage(response));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return opcDataList;
    }

    public String read(List<OPCData> opcDataList) throws SOAPException, IOException, JAXBException
    {
        if (opcDataList == null) {
            throw new NullPointerException("opcDataList can not be null");
        }

        //  创建消息对象
        // ===========================================
        SOAPMessage message = MessageFactory.newInstance().createMessage();
        SOAPHeader header = message.getSOAPHeader();
        header.detachNode();

        MimeHeaders mh = message.getMimeHeaders();
        mh.addHeader("SOAPAction", "http://opcfoundation.org/webservices/XMLDA/1.0/Read");

        // 获取soap的信封
        SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
        envelope.setPrefix("soap");

        // 获取消息的body
        SOAPBody body = message.getSOAPBody();
        body.setPrefix("soap");
        QName bodyName =  new QName(namespace, "Read");
        SOAPBodyElement bodyElement = body.addBodyElement(bodyName);

        SOAPElement se = bodyElement.addChildElement("Options");
        se.setAttribute("LocaleID", "en-US");
        se.setAttribute("ClientRequestHandle", "");
        se.setAttribute("ReturnItemTime", "true");
        se.setAttribute("ReturnItemName", "true");

        se = bodyElement.addChildElement("ItemList");

        ReadRequestItemList reqItemList = new ReadRequestItemList();
        int len = opcDataList.size();
        List<ReadRequestItem> items = reqItemList.getItems();
        List<ReadRequestItem> items2 = new ArrayList<ReadRequestItem>(len);
        items.addAll(items2);

        SOAPElement itemsElem = null;
        ReadRequestItem item = null;
        for (int i = 0; i < len; i++) {
            item = new ReadRequestItem();
            items.add(i, item);
            item.setClientItemHandle(String.valueOf(i));
            item.setItemName(opcDataList.get(i).getOPCName());

            itemsElem = se.addChildElement("Items");
            itemsElem.setAttribute("ItemName", item.getItemName());
            itemsElem.setAttribute("ClientItemHandle", item.getClientItemHandle());
        }

        SOAPConnection connection = SOAPConnectionFactory.newInstance().createConnection();
        SOAPMessage response = connection.call(message, endpoint);
        connection.close();
        System.out.println("response: " + response);

        SOAPBody responseBody = response.getSOAPBody();
        System.out.println("responseBody: " + responseBody);
        NodeList list = responseBody.getChildNodes();
        System.out.println("responseBody.getChildNodes: " + list);
        JAXBContext jaxbContext = JAXBContext.newInstance(ReadResponse.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        ReadResponse readResponse = (ReadResponse) jaxbUnmarshaller.unmarshal(list.item(1));
        System.out.println("readResponse: " + readResponse);
        List<ItemValue> replyItems = readResponse.getRItemList().getItems();
        System.out.println("replyItems: " + replyItems);

        if (replyItems.size() > 0)
        {
            int n = 0;
            OPCData opcdata = null;
            for (ItemValue v : replyItems) {
                n = Integer.parseInt(v.getClientItemHandle());
                opcdata = opcDataList.get(n);
                opcdata.setOPCValue(v.getValue().toString());
                opcdata.setOPCTime(v.getTimestamp().toString().replace('T', ' '));
            }
        }

        try {

//          System.out.println(getXmlFromSOAPMessage(message));
//          System.out.println(getXmlFromSOAPMessage(response));

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return "";
    }


    public void write(List<OPCData> opcDataList) throws SOAPException, IOException, JAXBException
    {
        if (opcDataList == null) {
            throw new NullPointerException("opcDataList can not be null");
        }

        //  创建消息对象
        // ===========================================
        SOAPMessage message = MessageFactory.newInstance().createMessage();
        SOAPHeader header = message.getSOAPHeader();
        header.detachNode();

        MimeHeaders mh = message.getMimeHeaders();
        mh.addHeader("SOAPAction", "http://opcfoundation.org/webservices/XMLDA/1.0/Write");

        // 获取soap的信封
        SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
        envelope.setPrefix("soap");

        // 获取消息的body
        SOAPBody body = message.getSOAPBody();
        body.setPrefix("soap");
        QName bodyName =  new QName(namespace, "Write");
        SOAPBodyElement bodyElement = body.addBodyElement(bodyName);

        SOAPElement se = bodyElement.addChildElement("Options");
        se.setAttribute("LocaleID", "en-US");
        se.setAttribute("ClientRequestHandle", "");
        se.setAttribute("ReturnItemTime", "true");
        se.setAttribute("ReturnItemName", "true");

        se = bodyElement.addChildElement("ItemList");

        se = se.addChildElement("Items");
        se.setAttribute("ItemName", "");
        se.setAttribute("ClientItemHandle", "");

//        WriteRequestItemList reqItemList = new WriteRequestItemList();
//        int len = opcDataList.size();
//        List<ItemValue> items = reqItemList.getItems();
//        List<ReadRequestItem> items2 = new ArrayList<ReadRequestItem>(len);
//        items.addAll(items2);
//
//        SOAPElement itemsElem = null;
//        ReadRequestItem item = null;
//        for (int i = 0; i < len; i++) {
//        	item = new ReadRequestItem();
//        	items.add(i, item);
//        	item.setClientItemHandle(String.valueOf(i));
//        	item.setItemName(opcDataList.get(i).getOPCName());
//
//        	itemsElem = se.addChildElement("Items");
//        	itemsElem.setAttribute("ItemName", item.getItemName());
//        	itemsElem.setAttribute("ClientItemHandle", item.getClientItemHandle());
//        }

        SOAPConnection connection = SOAPConnectionFactory.newInstance().createConnection();
        connection.call(message, endpoint);
        connection.close();

//        SOAPBody responseBody = response.getSOAPBody();
//        NodeList list = responseBody.getChildNodes();
//        JAXBContext jaxbContext = JAXBContext.newInstance(ReadResponse.class);
//        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//        ReadResponse readResponse = (ReadResponse) jaxbUnmarshaller.unmarshal(list.item(1));
//        List<ItemValue> replyItems = readResponse.getRItemList().getItems();
//
//        if (replyItems.size() > 0)
//        {
//        	int n = 0;
//        	OPCData opcdata = null;
//        	for (ItemValue v : replyItems) {
//        		n = Integer.parseInt(v.getClientItemHandle());
//        		opcdata = opcDataList.get(n);
//        		opcdata.setOPCValue(v.getValue().toString());
//        		opcdata.setOPCTime(v.getTimestamp().toString().replace('T', ' '));
//        	}
//        }
//
//        try {
//
////          System.out.println(getXmlFromSOAPMessage(message));
////          System.out.println(getXmlFromSOAPMessage(response));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//		return "";
    }
    public void writeItem(String itemName, String szValue) throws Exception {

        //  创建消息对象
        // ===========================================
        SOAPMessage message = MessageFactory.newInstance().createMessage();
        SOAPHeader header = message.getSOAPHeader();
        header.detachNode();

        MimeHeaders mh = message.getMimeHeaders();
        mh.addHeader("SOAPAction", "http://opcfoundation.org/webservices/XMLDA/1.0/Write");

        // 获取soap的信封
        SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
        envelope.setPrefix("soap");

        // 获取消息的body
        SOAPBody body = message.getSOAPBody();
        body.setPrefix("soap");
        QName bodyName = new QName(namespace, "Write");
        SOAPBodyElement bodyElement = body.addBodyElement(bodyName);

        SOAPElement se = bodyElement.addChildElement("Options");
        se.setAttribute("LocaleID", "en-US");
        se.setAttribute("ClientRequestHandle", "");
        se.setAttribute("ReturnItemTime", "false");
        se.setAttribute("ReturnItemName", "false");

        se = bodyElement.addChildElement("ItemList");
        se = se.addChildElement("Items");
        se.setAttribute("ItemName", itemName);
        se.setAttribute("ClientItemHandle", "");

        se = se.addChildElement("Value");
        se.addTextNode(szValue);

        try {

            SOAPConnection connection = SOAPConnectionFactory.newInstance().createConnection();
            connection.call(message, endpoint);
            connection.close();

//			System.out.println(itemName + ":" + szValue);


        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    public void addSubcription(List<OPCData> opcDataList) throws SOAPException, JAXBException
    {
        if (opcDataList == null) {
            throw new NullPointerException("opcDataList can not be null");
        }

        //  创建消息对象
        // ===========================================
        SOAPMessage message = MessageFactory.newInstance().createMessage();
        SOAPHeader header = message.getSOAPHeader();
        header.detachNode();

        MimeHeaders mh = message.getMimeHeaders();
        mh.addHeader("SOAPAction", "http://opcfoundation.org/webservices/XMLDA/1.0/Subscribe");

        // 获取soap的信封
        SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
        envelope.setPrefix("soap");

        // 获取消息的body
        SOAPBody body = message.getSOAPBody();
        body.setPrefix("soap");
        QName bodyName =  new QName(namespace, "Subscribe");
        SOAPBodyElement bodyElement = body.addBodyElement(bodyName);

        bodyElement.setAttribute("ReturnValuesOnReply", "false");
        bodyElement.setAttribute("SubscriptionPingRate", "300");

        SOAPElement se = bodyElement.addChildElement("Options");
        se.setAttribute("LocaleID", "en-US");
        se.setAttribute("ClientRequestHandle", "");
        se.setAttribute("ReturnItemTime", "true");
        se.setAttribute("ReturnItemName", "true");

        se = bodyElement.addChildElement("ItemList");

        ReadRequestItemList reqItemList = new ReadRequestItemList();
        int len = opcDataList.size();
        List<ReadRequestItem> items = reqItemList.getItems();
        List<ReadRequestItem> items2 = new ArrayList<ReadRequestItem>(len);
        items.addAll(items2);

        SOAPElement itemsElem = null;
        for (int i = 0; i < len; i++) {
            itemsElem = se.addChildElement("Items");
            itemsElem.setAttribute("ItemName", opcDataList.get(i).getOPCName());
            itemsElem.setAttribute("ClientItemHandle", String.valueOf(i));
            itemsElem.setAttribute("EnableBuffering", "false");
        }

        SOAPConnection connection = SOAPConnectionFactory.newInstance().createConnection();
        SOAPMessage response = connection.call(message, endpoint);
        connection.close();

        SOAPBody responseBody = response.getSOAPBody();
        NodeList list = responseBody.getChildNodes();

        Node subscribeResponseNode = list.item(1);
        String serverSubHandle = subscribeResponseNode.getAttributes().getNamedItem("ServerSubHandle").getNodeValue();

        // 无法自动解析
//        JAXBContext jaxbContext = JAXBContext.newInstance(SubscribeResponse.class);
//        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//        SubscribeResponse subscribeResponse = (SubscribeResponse) jaxbUnmarshaller.unmarshal(subscribeResponseNode);
        /////////////////



        this.serverSubHandleList.add(serverSubHandle);

//        try {
//
//          System.out.println(getXmlFromSOAPMessage(message));
//          System.out.println(getXmlFromSOAPMessage(response));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return ;

    }


    public void refreshSubcription(List<OPCData> opcDataList) throws SOAPException, JAXBException
    {

        if (opcDataList == null) {
            throw new NullPointerException("opcDataList can not be null");
        }

        if ( opcDataList.size() == 0) {
            return ;
        }

        //  创建消息对象
        // ===========================================
        SOAPMessage message = MessageFactory.newInstance().createMessage();
        SOAPHeader header = message.getSOAPHeader();
        header.detachNode();

        MimeHeaders mh = message.getMimeHeaders();
        mh.addHeader("SOAPAction", "http://opcfoundation.org/webservices/XMLDA/1.0/SubscriptionPolledRefresh");

        // 获取soap的信封
        SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
        envelope.setPrefix("soap");

        // 获取消息的body
        SOAPBody body = message.getSOAPBody();
        body.setPrefix("soap");
        QName bodyName =  new QName(namespace, "SubscriptionPolledRefresh");
        SOAPBodyElement bodyElement = body.addBodyElement(bodyName);

        DateTime dateTime = new DateTime();
        bodyElement.setAttribute("HoldTime", dateTime.toString());
        bodyElement.setAttribute("WaitTime", "5000");

        SOAPElement se = bodyElement.addChildElement("Options");
        se.setAttribute("LocaleID", "en-US");
        se.setAttribute("ClientRequestHandle", "");
        se.setAttribute("ReturnItemTime", "true");
        se.setAttribute("ReturnItemName", "true");

        int len = this.serverSubHandleList.size();

        SOAPElement serverSubHandlesElem = null;
        for (int i = 0; i < len; i++) {
            serverSubHandlesElem = bodyElement.addChildElement("ServerSubHandles");
            serverSubHandlesElem.addTextNode(this.serverSubHandleList.get(i));
        }

        SOAPConnection connection = SOAPConnectionFactory.newInstance().createConnection();
        SOAPMessage response = connection.call(message, endpoint);
        connection.close();

        SOAPBody responseBody = response.getSOAPBody();
        NodeList list = responseBody.getChildNodes();
        JAXBContext jaxbContext = JAXBContext.newInstance(SubscriptionPolledRefreshResponse.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        SubscriptionPolledRefreshResponse subscribeRefreshResponse = (SubscriptionPolledRefreshResponse) jaxbUnmarshaller.unmarshal(list.item(1));

        List<SubscribePolledRefreshReplyItemList> replyItemList =  subscribeRefreshResponse.getRItemList();

        SubscribePolledRefreshReplyItemList listItem  = null;
        List<ItemValue> items = null;
        ItemValue item = null;
        OPCData opcdata = null;
        int replyItemListLen = replyItemList.size();
        for (int i = 0 ; i < replyItemListLen; i++) {
            listItem = replyItemList.get(i);
            items = listItem.getItems();
            int itemsLen = items.size();
            for (int j = 0; j < itemsLen; j++) {
                item = items.get(j);
                if (item.getValue() != null)
                {
                    int n = Integer.parseInt(item.getClientItemHandle());
                    opcdata = opcDataList.get(n);
                    opcdata.setOPCValue(item.getValue().toString());
                    opcdata.setOPCTime(item.getTimestamp().toString().replace('T', ' '));
                }
            }

        }

    }

    public void cancelSubcription() throws SOAPException
    {
        int len  = this.serverSubHandleList.size();
        String serverSubHandle = null;
        for (int i = 0; i < len; i++) {
            serverSubHandle = this.serverSubHandleList.get(i);
            unsubscribe(serverSubHandle);
        }

        this.serverSubHandleList.clear();

    }

    private void unsubscribe(String serverSubHandle) throws SOAPException
    {
        //  创建消息对象
        // ===========================================
        SOAPMessage message = MessageFactory.newInstance().createMessage();
        SOAPHeader header = message.getSOAPHeader();
        header.detachNode();

        MimeHeaders mh = message.getMimeHeaders();
        mh.addHeader("SOAPAction", "http://opcfoundation.org/webservices/XMLDA/1.0/SubscriptionCancel");

        // 获取soap的信封
        SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
        envelope.setPrefix("soap");

        // 获取消息的body
        SOAPBody body = message.getSOAPBody();
        body.setPrefix("soap");
        QName bodyName =  new QName(namespace, "SubscriptionCancel");
        SOAPBodyElement bodyElement = body.addBodyElement(bodyName);

        bodyElement.setAttribute("ServerSubHandle", serverSubHandle);
        bodyElement.setAttribute("ClientRequestHandle", "");


        SOAPConnection connection = SOAPConnectionFactory.newInstance().createConnection();
        connection.call(message, endpoint);
        connection.close();

//        try {
//
//          System.out.println(getXmlFromSOAPMessage(message));
//          System.out.println(getXmlFromSOAPMessage(response));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

}
