
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
 *         &lt;element name="BrowseResult" type="{http://opcfoundation.org/webservices/XMLDA/1.0/}ReplyBase" minOccurs="0"/&gt;
 *         &lt;element name="Elements" type="{http://opcfoundation.org/webservices/XMLDA/1.0/}BrowseElement" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Errors" type="{http://opcfoundation.org/webservices/XMLDA/1.0/}OPCError" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="ContinuationPoint" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="MoreElements" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "browseResult",
    "elements",
    "errors"
})
@XmlRootElement(name = "BrowseResponse")
public class BrowseResponse {

    @XmlElement(name = "BrowseResult")
    protected ReplyBase browseResult;
    @XmlElement(name = "Elements")
    protected List<BrowseElement> elements;
    @XmlElement(name = "Errors")
    protected List<OPCError> errors;
    @XmlAttribute(name = "ContinuationPoint")
    protected String continuationPoint;
    @XmlAttribute(name = "MoreElements")
    protected Boolean moreElements;

    /**
     * ��ȡbrowseResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ReplyBase }
     *     
     */
    public ReplyBase getBrowseResult() {
        return browseResult;
    }

    /**
     * ����browseResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ReplyBase }
     *     
     */
    public void setBrowseResult(ReplyBase value) {
        this.browseResult = value;
    }

    /**
     * Gets the value of the elements property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the elements property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElements().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BrowseElement }
     * 
     * 
     */
    public List<BrowseElement> getElements() {
        if (elements == null) {
            elements = new ArrayList<BrowseElement>();
        }
        return this.elements;
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
     * ��ȡcontinuationPoint���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContinuationPoint() {
        return continuationPoint;
    }

    /**
     * ����continuationPoint���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContinuationPoint(String value) {
        this.continuationPoint = value;
    }

    /**
     * ��ȡmoreElements���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isMoreElements() {
        if (moreElements == null) {
            return false;
        } else {
            return moreElements;
        }
    }

    /**
     * ����moreElements���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMoreElements(Boolean value) {
        this.moreElements = value;
    }

}
