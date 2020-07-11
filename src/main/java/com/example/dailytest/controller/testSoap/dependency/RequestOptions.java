
package com.example.dailytest.controller.testSoap.dependency;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>RequestOptions complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="RequestOptions"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="RequestDeadline" type="{http://www.w3.org/2001/XMLSchema}dateTime" /&gt;
 *       &lt;attribute name="ReturnErrorText" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
 *       &lt;attribute name="ReturnDiagnosticInfo" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *       &lt;attribute name="ReturnItemTime" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *       &lt;attribute name="ReturnItemPath" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *       &lt;attribute name="ReturnItemName" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *       &lt;attribute name="ClientRequestHandle" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="LocaleID" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestOptions")
public class RequestOptions {

    @XmlAttribute(name = "RequestDeadline")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar requestDeadline;
    @XmlAttribute(name = "ReturnErrorText")
    protected Boolean returnErrorText;
    @XmlAttribute(name = "ReturnDiagnosticInfo")
    protected Boolean returnDiagnosticInfo;
    @XmlAttribute(name = "ReturnItemTime")
    protected Boolean returnItemTime;
    @XmlAttribute(name = "ReturnItemPath")
    protected Boolean returnItemPath;
    @XmlAttribute(name = "ReturnItemName")
    protected Boolean returnItemName;
    @XmlAttribute(name = "ClientRequestHandle")
    protected String clientRequestHandle;
    @XmlAttribute(name = "LocaleID")
    protected String localeID;

    /**
     * ��ȡrequestDeadline���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRequestDeadline() {
        return requestDeadline;
    }

    /**
     * ����requestDeadline���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRequestDeadline(XMLGregorianCalendar value) {
        this.requestDeadline = value;
    }

    /**
     * ��ȡreturnErrorText���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isReturnErrorText() {
        if (returnErrorText == null) {
            return true;
        } else {
            return returnErrorText;
        }
    }

    /**
     * ����returnErrorText���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReturnErrorText(Boolean value) {
        this.returnErrorText = value;
    }

    /**
     * ��ȡreturnDiagnosticInfo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isReturnDiagnosticInfo() {
        if (returnDiagnosticInfo == null) {
            return false;
        } else {
            return returnDiagnosticInfo;
        }
    }

    /**
     * ����returnDiagnosticInfo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReturnDiagnosticInfo(Boolean value) {
        this.returnDiagnosticInfo = value;
    }

    /**
     * ��ȡreturnItemTime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isReturnItemTime() {
        if (returnItemTime == null) {
            return false;
        } else {
            return returnItemTime;
        }
    }

    /**
     * ����returnItemTime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReturnItemTime(Boolean value) {
        this.returnItemTime = value;
    }

    /**
     * ��ȡreturnItemPath���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isReturnItemPath() {
        if (returnItemPath == null) {
            return false;
        } else {
            return returnItemPath;
        }
    }

    /**
     * ����returnItemPath���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReturnItemPath(Boolean value) {
        this.returnItemPath = value;
    }

    /**
     * ��ȡreturnItemName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isReturnItemName() {
        if (returnItemName == null) {
            return false;
        } else {
            return returnItemName;
        }
    }

    /**
     * ����returnItemName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReturnItemName(Boolean value) {
        this.returnItemName = value;
    }

    /**
     * ��ȡclientRequestHandle���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientRequestHandle() {
        return clientRequestHandle;
    }

    /**
     * ����clientRequestHandle���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientRequestHandle(String value) {
        this.clientRequestHandle = value;
    }

    /**
     * ��ȡlocaleID���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocaleID() {
        return localeID;
    }

    /**
     * ����localeID���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocaleID(String value) {
        this.localeID = value;
    }

}
