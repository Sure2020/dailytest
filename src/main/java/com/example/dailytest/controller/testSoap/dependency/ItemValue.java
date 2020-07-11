
package com.example.dailytest.controller.testSoap.dependency;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * <p>ItemValue complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ItemValue"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DiagnosticInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *         &lt;element name="Quality" type="{http://opcfoundation.org/webservices/XMLDA/1.0/}OPCQuality" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="ItemPath" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ItemName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ClientItemHandle" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="Timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" /&gt;
 *       &lt;attribute name="ResultID" type="{http://www.w3.org/2001/XMLSchema}QName" /&gt;
 *       &lt;attribute name="ValueTypeQualifier" type="{http://www.w3.org/2001/XMLSchema}QName" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemValue", propOrder = {
    "diagnosticInfo",
    "value",
    "quality"
})
public class ItemValue {

    @XmlElement(name = "DiagnosticInfo")
    protected String diagnosticInfo;
    @XmlElement(name = "Value")
    protected Object value;
    @XmlElement(name = "Quality")
    protected OPCQuality quality;
    @XmlAttribute(name = "ItemPath")
    protected String itemPath;
    @XmlAttribute(name = "ItemName")
    protected String itemName;
    @XmlAttribute(name = "ClientItemHandle")
    protected String clientItemHandle;
    @XmlAttribute(name = "Timestamp")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timestamp;
    @XmlAttribute(name = "ResultID")
    protected QName resultID;
    @XmlAttribute(name = "ValueTypeQualifier")
    protected QName valueTypeQualifier;

    /**
     * ��ȡdiagnosticInfo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiagnosticInfo() {
        return diagnosticInfo;
    }

    /**
     * ����diagnosticInfo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiagnosticInfo(String value) {
        this.diagnosticInfo = value;
    }

    /**
     * ��ȡvalue���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getValue() {
        return value;
    }

    /**
     * ����value���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * ��ȡquality���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link OPCQuality }
     *     
     */
    public OPCQuality getQuality() {
        return quality;
    }

    /**
     * ����quality���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link OPCQuality }
     *     
     */
    public void setQuality(OPCQuality value) {
        this.quality = value;
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
     * ��ȡtimestamp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimestamp() {
        return timestamp;
    }

    /**
     * ����timestamp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimestamp(XMLGregorianCalendar value) {
        this.timestamp = value;
    }

    /**
     * ��ȡresultID���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getResultID() {
        return resultID;
    }

    /**
     * ����resultID���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setResultID(QName value) {
        this.resultID = value;
    }

    /**
     * ��ȡvalueTypeQualifier���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getValueTypeQualifier() {
        return valueTypeQualifier;
    }

    /**
     * ����valueTypeQualifier���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setValueTypeQualifier(QName value) {
        this.valueTypeQualifier = value;
    }

}
