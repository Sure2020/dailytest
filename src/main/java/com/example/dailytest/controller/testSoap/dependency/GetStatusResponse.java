
package com.example.dailytest.controller.testSoap.dependency;

import javax.xml.bind.annotation.*;


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
 *         &lt;element name="GetStatusResult" type="{http://opcfoundation.org/webservices/XMLDA/1.0/}ReplyBase" minOccurs="0"/&gt;
 *         &lt;element name="Status" type="{http://opcfoundation.org/webservices/XMLDA/1.0/}ServerStatus" minOccurs="0"/&gt;
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
    "getStatusResult",
    "status"
})
@XmlRootElement(name = "GetStatusResponse")
public class GetStatusResponse {

    @XmlElement(name = "GetStatusResult")
    protected ReplyBase getStatusResult;
    @XmlElement(name = "Status")
    protected ServerStatus status;

    /**
     * 获取getStatusResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ReplyBase }
     *     
     */
    public ReplyBase getGetStatusResult() {
        return getStatusResult;
    }

    /**
     * 设置getStatusResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ReplyBase }
     *     
     */
    public void setGetStatusResult(ReplyBase value) {
        this.getStatusResult = value;
    }

    /**
     * 获取status属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ServerStatus }
     *     
     */
    public ServerStatus getStatus() {
        return status;
    }

    /**
     * 设置status属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ServerStatus }
     *     
     */
    public void setStatus(ServerStatus value) {
        this.status = value;
    }

}
