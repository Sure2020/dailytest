
package com.example.dailytest.controller.testSoap.dependency;

import javax.xml.bind.annotation.*;


/**
 * <p>OPCQuality complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="OPCQuality"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="QualityField" type="{http://opcfoundation.org/webservices/XMLDA/1.0/}qualityBits" default="good" /&gt;
 *       &lt;attribute name="LimitField" type="{http://opcfoundation.org/webservices/XMLDA/1.0/}limitBits" default="none" /&gt;
 *       &lt;attribute name="VendorField" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" default="0" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OPCQuality")
public class OPCQuality {

    @XmlAttribute(name = "QualityField")
    protected QualityBits qualityField;
    @XmlAttribute(name = "LimitField")
    protected LimitBits limitField;
    @XmlAttribute(name = "VendorField")
    @XmlSchemaType(name = "unsignedByte")
    protected Short vendorField;

    /**
     * ��ȡqualityField���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link QualityBits }
     *     
     */
    public QualityBits getQualityField() {
        if (qualityField == null) {
            return QualityBits.GOOD;
        } else {
            return qualityField;
        }
    }

    /**
     * ����qualityField���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link QualityBits }
     *     
     */
    public void setQualityField(QualityBits value) {
        this.qualityField = value;
    }

    /**
     * ��ȡlimitField���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link LimitBits }
     *     
     */
    public LimitBits getLimitField() {
        if (limitField == null) {
            return LimitBits.NONE;
        } else {
            return limitField;
        }
    }

    /**
     * ����limitField���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link LimitBits }
     *     
     */
    public void setLimitField(LimitBits value) {
        this.limitField = value;
    }

    /**
     * ��ȡvendorField���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public short getVendorField() {
        if (vendorField == null) {
            return ((short) 0);
        } else {
            return vendorField;
        }
    }

    /**
     * ����vendorField���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setVendorField(Short value) {
        this.vendorField = value;
    }

}
