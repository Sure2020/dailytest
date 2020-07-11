
package com.example.dailytest.controller.testSoap.dependency;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>interfaceVersion�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="interfaceVersion"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="XML_DA_Version_1_0"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "interfaceVersion")
@XmlEnum
public enum InterfaceVersion {

    @XmlEnumValue("XML_DA_Version_1_0")
    XML_DA_VERSION_1_0("XML_DA_Version_1_0");
    private final String value;

    InterfaceVersion(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static InterfaceVersion fromValue(String v) {
        for (InterfaceVersion c: InterfaceVersion.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
