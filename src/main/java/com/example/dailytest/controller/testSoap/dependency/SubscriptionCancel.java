
package com.example.dailytest.controller.testSoap.dependency;

import javax.xml.bind.annotation.*;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="ServerSubHandle" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ClientRequestHandle" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "SubscriptionCancel")
public class SubscriptionCancel {

    @XmlAttribute(name = "ServerSubHandle")
    protected String serverSubHandle;
    @XmlAttribute(name = "ClientRequestHandle")
    protected String clientRequestHandle;

    /**
     * ��ȡserverSubHandle���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServerSubHandle() {
        return serverSubHandle;
    }

    /**
     * ����serverSubHandle���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServerSubHandle(String value) {
        this.serverSubHandle = value;
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

}
