
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
 *         &lt;element name="WriteResult" type="{http://opcfoundation.org/webservices/XMLDA/1.0/}ReplyBase" minOccurs="0"/&gt;
 *         &lt;element name="RItemList" type="{http://opcfoundation.org/webservices/XMLDA/1.0/}ReplyItemList" minOccurs="0"/&gt;
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
    "writeResult",
    "rItemList",
    "errors"
})
@XmlRootElement(name = "WriteResponse")
public class WriteResponse {

    @XmlElement(name = "WriteResult")
    protected ReplyBase writeResult;
    @XmlElement(name = "RItemList")
    protected ReplyItemList rItemList;
    @XmlElement(name = "Errors")
    protected List<OPCError> errors;

    /**
     * ��ȡwriteResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ReplyBase }
     *     
     */
    public ReplyBase getWriteResult() {
        return writeResult;
    }

    /**
     * ����writeResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ReplyBase }
     *     
     */
    public void setWriteResult(ReplyBase value) {
        this.writeResult = value;
    }

    /**
     * ��ȡrItemList���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ReplyItemList }
     *     
     */
    public ReplyItemList getRItemList() {
        return rItemList;
    }

    /**
     * ����rItemList���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ReplyItemList }
     *     
     */
    public void setRItemList(ReplyItemList value) {
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

}
