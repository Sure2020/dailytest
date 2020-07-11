
package com.example.dailytest.controller.testSoap.dependency;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
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
 *         &lt;element name="ItemIDs" type="{http://opcfoundation.org/webservices/XMLDA/1.0/}ItemIdentifier" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="PropertyNames" type="{http://www.w3.org/2001/XMLSchema}QName" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="LocaleID" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ClientRequestHandle" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ItemPath" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ReturnAllProperties" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *       &lt;attribute name="ReturnPropertyValues" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *       &lt;attribute name="ReturnErrorText" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "itemIDs",
    "propertyNames"
})
@XmlRootElement(name = "GetProperties")
public class GetProperties {

    @XmlElement(name = "ItemIDs")
    protected List<ItemIdentifier> itemIDs;
    @XmlElement(name = "PropertyNames")
    protected List<QName> propertyNames;
    @XmlAttribute(name = "LocaleID")
    protected String localeID;
    @XmlAttribute(name = "ClientRequestHandle")
    protected String clientRequestHandle;
    @XmlAttribute(name = "ItemPath")
    protected String itemPath;
    @XmlAttribute(name = "ReturnAllProperties")
    protected Boolean returnAllProperties;
    @XmlAttribute(name = "ReturnPropertyValues")
    protected Boolean returnPropertyValues;
    @XmlAttribute(name = "ReturnErrorText")
    protected Boolean returnErrorText;

    /**
     * Gets the value of the itemIDs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemIDs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemIDs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemIdentifier }
     * 
     * 
     */
    public List<ItemIdentifier> getItemIDs() {
        if (itemIDs == null) {
            itemIDs = new ArrayList<ItemIdentifier>();
        }
        return this.itemIDs;
    }

    /**
     * Gets the value of the propertyNames property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the propertyNames property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPropertyNames().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QName }
     * 
     * 
     */
    public List<QName> getPropertyNames() {
        if (propertyNames == null) {
            propertyNames = new ArrayList<QName>();
        }
        return this.propertyNames;
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
     * ��ȡreturnAllProperties���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isReturnAllProperties() {
        if (returnAllProperties == null) {
            return false;
        } else {
            return returnAllProperties;
        }
    }

    /**
     * ����returnAllProperties���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReturnAllProperties(Boolean value) {
        this.returnAllProperties = value;
    }

    /**
     * ��ȡreturnPropertyValues���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isReturnPropertyValues() {
        if (returnPropertyValues == null) {
            return false;
        } else {
            return returnPropertyValues;
        }
    }

    /**
     * ����returnPropertyValues���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReturnPropertyValues(Boolean value) {
        this.returnPropertyValues = value;
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
            return false;
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

}
