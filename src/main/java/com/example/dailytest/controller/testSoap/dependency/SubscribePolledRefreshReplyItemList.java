
package com.example.dailytest.controller.testSoap.dependency;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>SubscribePolledRefreshReplyItemList complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="SubscribePolledRefreshReplyItemList"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Items" type="{http://opcfoundation.org/webservices/XMLDA/1.0/}ItemValue" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="SubscriptionHandle" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubscribePolledRefreshReplyItemList", propOrder = {
    "items"
})
public class SubscribePolledRefreshReplyItemList {

    @XmlElement(name = "Items")
    protected List<ItemValue> items;
    @XmlAttribute(name = "SubscriptionHandle")
    protected String subscriptionHandle;

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
     * {@link ItemValue }
     * 
     * 
     */
    public List<ItemValue> getItems() {
        if (items == null) {
            items = new ArrayList<ItemValue>();
        }
        return this.items;
    }

    /**
     * ��ȡsubscriptionHandle���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriptionHandle() {
        return subscriptionHandle;
    }

    /**
     * ����subscriptionHandle���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriptionHandle(String value) {
        this.subscriptionHandle = value;
    }

}
