
package com.example.dailytest.controller.testSoap.dependency;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>ReplyBase complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ReplyBase"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="RcvTime" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" /&gt;
 *       &lt;attribute name="ReplyTime" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" /&gt;
 *       &lt;attribute name="ClientRequestHandle" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="RevisedLocaleID" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ServerState" use="required" type="{http://opcfoundation.org/webservices/XMLDA/1.0/}serverState" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReplyBase")
public class ReplyBase {

    @XmlAttribute(name = "RcvTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar rcvTime;
    @XmlAttribute(name = "ReplyTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar replyTime;
    @XmlAttribute(name = "ClientRequestHandle")
    protected String clientRequestHandle;
    @XmlAttribute(name = "RevisedLocaleID")
    protected String revisedLocaleID;
    @XmlAttribute(name = "ServerState", required = true)
    protected ServerState serverState;

    /**
     * ��ȡrcvTime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRcvTime() {
        return rcvTime;
    }

    /**
     * ����rcvTime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRcvTime(XMLGregorianCalendar value) {
        this.rcvTime = value;
    }

    /**
     * ��ȡreplyTime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReplyTime() {
        return replyTime;
    }

    /**
     * ����replyTime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReplyTime(XMLGregorianCalendar value) {
        this.replyTime = value;
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
     * ��ȡrevisedLocaleID���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRevisedLocaleID() {
        return revisedLocaleID;
    }

    /**
     * ����revisedLocaleID���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRevisedLocaleID(String value) {
        this.revisedLocaleID = value;
    }

    /**
     * ��ȡserverState���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ServerState }
     *     
     */
    public ServerState getServerState() {
        return serverState;
    }

    /**
     * ����serverState���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ServerState }
     *     
     */
    public void setServerState(ServerState value) {
        this.serverState = value;
    }

}
