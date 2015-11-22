
package fr.vidal.webservices.productservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for composition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="composition">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="excipientType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="molecule" type="{urn:Vidal}molecule"/>
 *         &lt;element name="perVolume" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="perVolumeUnit" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ranking" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="substituentMolecule" type="{urn:Vidal}molecule"/>
 *         &lt;element name="substituentPerVolume" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="substituentPerVolumeUnit" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="type" type="{urn:Vidal}SubstanceType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "composition", propOrder = {
    "excipientType",
    "id",
    "molecule",
    "perVolume",
    "perVolumeUnit",
    "ranking",
    "substituentMolecule",
    "substituentPerVolume",
    "substituentPerVolumeUnit",
    "type"
})
public class Composition {

    @XmlElement(required = true, nillable = true)
    protected String excipientType;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer id;
    @XmlElement(required = true, nillable = true)
    protected Molecule molecule;
    @XmlElement(required = true, type = Float.class, nillable = true)
    protected Float perVolume;
    @XmlElement(required = true, nillable = true)
    protected String perVolumeUnit;
    @XmlElement(required = true, nillable = true)
    protected String ranking;
    @XmlElement(required = true, nillable = true)
    protected Molecule substituentMolecule;
    @XmlElement(required = true, type = Float.class, nillable = true)
    protected Float substituentPerVolume;
    @XmlElement(required = true, nillable = true)
    protected String substituentPerVolumeUnit;
    @XmlElement(required = true, nillable = true)
    protected SubstanceType type;

    /**
     * Gets the value of the excipientType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExcipientType() {
        return excipientType;
    }

    /**
     * Sets the value of the excipientType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExcipientType(String value) {
        this.excipientType = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Gets the value of the molecule property.
     * 
     * @return
     *     possible object is
     *     {@link Molecule }
     *     
     */
    public Molecule getMolecule() {
        return molecule;
    }

    /**
     * Sets the value of the molecule property.
     * 
     * @param value
     *     allowed object is
     *     {@link Molecule }
     *     
     */
    public void setMolecule(Molecule value) {
        this.molecule = value;
    }

    /**
     * Gets the value of the perVolume property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getPerVolume() {
        return perVolume;
    }

    /**
     * Sets the value of the perVolume property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setPerVolume(Float value) {
        this.perVolume = value;
    }

    /**
     * Gets the value of the perVolumeUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPerVolumeUnit() {
        return perVolumeUnit;
    }

    /**
     * Sets the value of the perVolumeUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPerVolumeUnit(String value) {
        this.perVolumeUnit = value;
    }

    /**
     * Gets the value of the ranking property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRanking() {
        return ranking;
    }

    /**
     * Sets the value of the ranking property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRanking(String value) {
        this.ranking = value;
    }

    /**
     * Gets the value of the substituentMolecule property.
     * 
     * @return
     *     possible object is
     *     {@link Molecule }
     *     
     */
    public Molecule getSubstituentMolecule() {
        return substituentMolecule;
    }

    /**
     * Sets the value of the substituentMolecule property.
     * 
     * @param value
     *     allowed object is
     *     {@link Molecule }
     *     
     */
    public void setSubstituentMolecule(Molecule value) {
        this.substituentMolecule = value;
    }

    /**
     * Gets the value of the substituentPerVolume property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getSubstituentPerVolume() {
        return substituentPerVolume;
    }

    /**
     * Sets the value of the substituentPerVolume property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setSubstituentPerVolume(Float value) {
        this.substituentPerVolume = value;
    }

    /**
     * Gets the value of the substituentPerVolumeUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubstituentPerVolumeUnit() {
        return substituentPerVolumeUnit;
    }

    /**
     * Sets the value of the substituentPerVolumeUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubstituentPerVolumeUnit(String value) {
        this.substituentPerVolumeUnit = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link SubstanceType }
     *     
     */
    public SubstanceType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubstanceType }
     *     
     */
    public void setType(SubstanceType value) {
        this.type = value;
    }

}
