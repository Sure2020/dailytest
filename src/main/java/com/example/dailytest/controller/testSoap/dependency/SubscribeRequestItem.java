
package com.example.dailytest.controller.testSoap.dependency;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>SubscribeRequestItem complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="SubscribeRequestItem"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="ItemPath" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ReqType" type="{http://www.w3.org/2001/XMLSchema}QName" /&gt;
 *       &lt;attribute name="ItemName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ClientItemHandle" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="Deadband" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="RequestedSamplingRate" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="EnableBuffering" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubscribeRequestItem")
public class SubscribeRequestItem {

    @XmlAttribute(name = "ItemPath")
    protected String itemPath;
    @XmlAttribute(name = "ReqType")
    protected QName reqType;
    @XmlAttribute(name = "ItemName")
    protected String itemName;
    @XmlAttribute(name = "ClientItemHandle")
    protected String clientItemHandle;
    @XmlAttribute(name = "Deadband")
    protected Float deadband;
    @XmlAttribute(name = "RequestedSamplingRate")
    protected Integer requestedSamplingRate;
    @XmlAttribute(name = "EnableBuffering")
    protected Boolean enableBuffering;

    /**
     * ��ȡitemPath���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemPath() {
        return itemPath;
    }

    /**
     * ����itemPath���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemPath(String value) {
        this.itemPath = value;
    }

    /**
     * ��ȡreqType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getReqType() {
        return reqType;
    }

    /**
     * ����reqType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setReqType(QName value) {
        this.reqType = value;
    }

    /**
     * ��ȡitemName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * ����itemName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemName(String value) {
        this.itemName = value;
    }

    /**
     * ��ȡclientItemHandle���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientItemHandle() {
        return clientItemHandle;
    }

    /**
     * ����clientItemHandle���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientItemHandle(String value) {
        this.clientItemHandle = value;
    }

    /**
     * ��ȡdeadband���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getDeadband() {
        return deadband;
    }

    /**
     * ����deadband���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setDeadband(Float value) {
        this.deadband = value;
    }

    /**
     * ��ȡrequestedSamplingRate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRequestedSamplingRate() {
        return requestedSamplingRate;
    }

    /**
     * ����requestedSamplingRate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRequestedSamplingRate(Integer value) {
        this.requestedSamplingRate = value;
    }

    /**
     * ��ȡenableBuffering���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEnableBuffering() {
        return enableBuffering;
    }

    /**
     * ����enableBuffering���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEnableBuffering(Boolean value) {
        this.enableBuffering = value;
    }

}
