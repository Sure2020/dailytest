
package com.example.dailytest.controller.testSoap.dependency;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>ReadRequestItemList complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ReadRequestItemList"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Items" type="{http://opcfoundation.org/webservices/XMLDA/1.0/}ReadRequestItem" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="ItemPath" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ReqType" type="{http://www.w3.org/2001/XMLSchema}QName" /&gt;
 *       &lt;attribute name="MaxAge" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReadRequestItemList", propOrder = {
    "items"
})
public class ReadRequestItemList {

    @XmlElement(name = "Items")
    protected List<ReadRequestItem> items;
    @XmlAttribute(name = "ItemPath")
    protected String itemPath;
    @XmlAttribute(name = "ReqType")
    protected QName reqType;
    @XmlAttribute(name = "MaxAge")
    protected Integer maxAge;

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
     * {@link ReadRequestItem }
     * 
     * 
     */
    public List<ReadRequestItem> getItems() {
        if (items == null) {
            items = new ArrayList<ReadRequestItem>();
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
     * ��ȡmaxAge���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxAge() {
        return maxAge;
    }

    /**
     * ����maxAge���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxAge(Integer value) {
        this.maxAge = value;
    }

}
