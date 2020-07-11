
package com.example.dailytest.controller.testSoap.dependency;

import javax.xml.bind.annotation.*;


/**
 * <p>SubscribeItemValue complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="SubscribeItemValue"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ItemValue" type="{http://opcfoundation.org/webservices/XMLDA/1.0/}ItemValue" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="RevisedSamplingRate" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubscribeItemValue", propOrder = {
    "itemValue"
})
public class SubscribeItemValue {

    @XmlElement(name = "ItemValue")
    protected ItemValue itemValue;
    @XmlAttribute(name = "RevisedSamplingRate")
    protected Integer revisedSamplingRate;

    /**
     * ��ȡitemValue���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ItemValue }
     *     
     */
    public ItemValue getItemValue() {
        return itemValue;
    }

    /**
     * ����itemValue���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ItemValue }
     *     
     */
    public void setItemValue(ItemValue value) {
        this.itemValue = value;
    }

    /**
     * ��ȡrevisedSamplingRate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRevisedSamplingRate() {
        return revisedSamplingRate;
    }

    /**
     * ����revisedSamplingRate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRevisedSamplingRate(Integer value) {
        this.revisedSamplingRate = value;
    }

}
