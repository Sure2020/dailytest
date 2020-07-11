
package com.example.dailytest.controller.testSoap.dependency;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>SubscribeRequestItemList complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="SubscribeRequestItemList"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Items" type="{http://opcfoundation.org/webservices/XMLDA/1.0/}SubscribeRequestItem" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="ItemPath" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ReqType" type="{http://www.w3.org/2001/XMLSchema}QName" /&gt;
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
@XmlType(name = "SubscribeRequestItemList", propOrder = {
    "items"
})
public class SubscribeRequestItemList {

    @XmlElement(name = "Items")
    protected List<SubscribeRequestItem> items;
    @XmlAttribute(name = "ItemPath")
    protected String itemPath;
    @XmlAttribute(name = "ReqType")
    protected QName reqType;
    @XmlAttribute(name = "Deadband")
    protected Float deadband;
    @XmlAttribute(name = "RequestedSamplingRate")
    protected Integer requestedSamplingRate;
    @XmlAttribute(name = "EnableBuffering")
    protected Boolean enableBuffering;

    /**
     * Gets the value of the items property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the items property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubscribeRequestItem }
     * 
     * 
     */
    public List<SubscribeRequestItem> getItems() {
        if (items == null) {
            items = new ArrayList<SubscribeRequestItem>();
        }
        return this.items;
    }

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
