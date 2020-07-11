
package com.example.dailytest.controller.testSoap.dependency;

import com.example.dailytest.controller.testSoap.dependency.OPCError;
import com.example.dailytest.controller.testSoap.dependency.PropertyReplyList;
import com.example.dailytest.controller.testSoap.dependency.ReplyBase;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GetPropertiesResult" type="{http://opcfoundation.org/webservices/XMLDA/1.0/}ReplyBase" minOccurs="0"/&gt;
 *         &lt;element name="PropertyLists" type="{http://opcfoundation.org/webservices/XMLDA/1.0/}PropertyReplyList" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Errors" type="{http://opcfoundation.org/webservices/XMLDA/1.0/}OPCError" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getPropertiesResult",
        "propertyLists",
        "errors"
})
@XmlRootElement(name = "GetPropertiesResponse")
public class GetPropertiesResponse {

    @XmlElement(name = "GetPropertiesResult")
    protected ReplyBase getPropertiesResult;
    @XmlElement(name = "PropertyLists")
    protected List<PropertyReplyList> propertyLists;
    @XmlElement(name = "Errors")
    protected List<OPCError> errors;

    /**
     * 获取getPropertiesResult属性的值。
     *
     * @return
     *     possible object is
     *     {@link ReplyBase }
     *
     */
    public ReplyBase getGetPropertiesResult() {
        return getPropertiesResult;
    }

    /**
     * 设置getPropertiesResult属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link ReplyBase }
     *
     */
    public void setGetPropertiesResult(ReplyBase value) {
        this.getPropertiesResult = value;
    }

    /**
     * Gets the value of the propertyLists property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the propertyLists property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPropertyLists().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PropertyReplyList }
     *
     *
     */
    public List<PropertyReplyList> getPropertyLists() {
        if (propertyLists == null) {
            propertyLists = new ArrayList<PropertyReplyList>();
        }
        return this.propertyLists;
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

}
