
package com.example.dailytest.controller.testSoap.dependency;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SubscribeResult" type="{http://opcfoundation.org/webservices/XMLDA/1.0/}ReplyBase" minOccurs="0"/&gt;
 *         &lt;element name="RItemList" type="{http://opcfoundation.org/webservices/XMLDA/1.0/}SubscribeReplyItemList" minOccurs="0"/&gt;
 *         &lt;element name="Errors" type="{http://opcfoundation.org/webservices/XMLDA/1.0/}OPCError" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="ServerSubHandle" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "subscribeResult",
    "rItemList",
    "errors"
})
@XmlRootElement(name = "SubscribeResponse")
public class SubscribeResponse {

    @XmlElement(name = "SubscribeResult")
    protected ReplyBase subscribeResult;
    @XmlElement(name = "RItemList")
    protected SubscribeReplyItemList rItemList;
    @XmlElement(name = "Errors")
    protected List<OPCError> errors;
    @XmlAttribute(name = "ServerSubHandle")
    protected String serverSubHandle;

    /**
     * ��ȡsubscribeResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ReplyBase }
     *     
     */
    public ReplyBase getSubscribeResult() {
        return subscribeResult;
    }

    /**
     * ����subscribeResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ReplyBase }
     *     
     */
    public void setSubscribeResult(ReplyBase value) {
        this.subscribeResult = value;
    }

    /**
     * ��ȡrItemList���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link SubscribeReplyItemList }
     *     
     */
    public SubscribeReplyItemList getRItemList() {
        return rItemList;
    }

    /**
     * ����rItemList���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link SubscribeReplyItemList }
     *     
     */
    public void setRItemList(SubscribeReplyItemList value) {
        this.rItemList = value;
    }

    /**
     * Gets the value of the errors property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the errors property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getErrors().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OPCError }
     * 
     * 
     */
    public List<OPCError> getErrors() {
        if (errors == null) {
            errors = new ArrayList<OPCError>();
        }
        return this.errors;
    }

    /**
     * ��ȡserverSubHandle���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServerSubHandle() {
        return serverSubHandle;
    }

    /**
     * ����serverSubHandle���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServerSubHandle(String value) {
        this.serverSubHandle = value;
    }

}
