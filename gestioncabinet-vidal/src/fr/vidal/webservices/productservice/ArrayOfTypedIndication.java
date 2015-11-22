
package fr.vidal.webservices.productservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfTypedIndication complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfTypedIndication">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="typedIndication" type="{urn:Vidal}typedIndication" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfTypedIndication", propOrder = {
    "typedIndication"
})
public class ArrayOfTypedIndication {

    @XmlElement(nillable = true)
    protected List<TypedIndication> typedIndication;

    /**
     * Gets the value of the typedIndication property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the typedIndication property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTypedIndication().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TypedIndication }
     * 
     * 
     */
    public List<TypedIndication> getTypedIndication() {
        if (typedIndication == null) {
            typedIndication = new ArrayList<TypedIndication>();
        }
        return this.typedIndication;
    }

}
