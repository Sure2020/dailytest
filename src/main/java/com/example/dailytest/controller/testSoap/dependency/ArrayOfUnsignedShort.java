
package com.example.dailytest.controller.testSoap.dependency;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>ArrayOfUnsignedShort complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ArrayOfUnsignedShort"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="unsignedShort" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfUnsignedShort", propOrder = {
    "unsignedShort"
})
public class ArrayOfUnsignedShort {

    @XmlElement(type = Integer.class)
    @XmlSchemaType(name = "unsignedShort")
    protected List<Integer> unsignedShort;

    /**
     * Gets the value of the unsignedShort property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the unsignedShort property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUnsignedShort().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getUnsignedShort() {
        if (unsignedShort == null) {
            unsignedShort = new ArrayList<Integer>();
        }
        return this.unsignedShort;
    }

}
