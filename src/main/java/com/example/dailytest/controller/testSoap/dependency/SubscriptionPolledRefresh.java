
package com.example.dailytest.controller.testSoap.dependency;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
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
 *         &lt;element name="Options" type="{http://opcfoundation.org/webservices/XMLDA/1.0/}RequestOptions" minOccurs="0"/&gt;
 *         &lt;element name="ServerSubHandles" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="HoldTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" /&gt;
 *       &lt;attribute name="WaitTime" type="{http://www.w3.org/2001/XMLSchema}int" default="0" /&gt;
 *       &lt;attribute name="ReturnAllItems" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "options",
    "serverSubHandles"
})
@XmlRootElement(name = "SubscriptionPolledRefresh")
public class SubscriptionPolledRefresh {

    @XmlElement(name = "Options")
    protected RequestOptions options;
    @XmlElement(name = "ServerSubHandles")
    protected List<String> serverSubHandles;
    @XmlAttribute(name = "HoldTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar holdTime;
    @XmlAttribute(name = "WaitTime")
    protected Integer waitTime;
    @XmlAttribute(name = "ReturnAllItems")
    protected Boolean returnAllItems;

    /**
     * ��ȡoptions���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link RequestOptions }
     *     
     */
    public RequestOptions getOptions() {
        return options;
    }

    /**
     * ����options���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link RequestOptions }
     *     
     */
    public void setOptions(RequestOptions value) {
        this.options = value;
    }

    /**
     * Gets the value of the serverSubHandles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serverSubHandles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServerSubHandles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getServerSubHandles() {
        if (serverSubHandles == null) {
            serverSubHandles = new ArrayList<String>();
        }
        return this.serverSubHandles;
    }

    /**
     * ��ȡholdTime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getHoldTime() {
        return holdTime;
    }

    /**
     * ����holdTime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setHoldTime(XMLGregorianCalendar value) {
        this.holdTime = value;
    }

    /**
     * ��ȡwaitTime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getWaitTime() {
        if (waitTime == null) {
            return  0;
        } else {
            return waitTime;
        }
    }

    /**
     * ����waitTime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWaitTime(Integer value) {
        this.waitTime = value;
    }

    /**
     * ��ȡreturnAllItems���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isReturnAllItems() {
        if (returnAllItems == null) {
            return false;
        } else {
            return returnAllItems;
        }
    }

    /**
     * ����returnAllItems���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReturnAllItems(Boolean value) {
        this.returnAllItems = value;
    }

}
