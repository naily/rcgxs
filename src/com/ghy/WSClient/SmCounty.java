package com.ghy.WSClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for smCounty complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;smCounty&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base=&quot;{http://webservice.ncplt.cci.org/}baseEntity&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;id&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;NAME&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;TYPE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;PARENTID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;CITYTYPE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;AREATYPE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;JSCTYPE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "smCounty", propOrder = { "id", "name", "type", "parentid", "citytype", "areatype", "jsctype" })
public class SmCounty extends BaseEntity {

	protected Long id;
	@XmlElement(name = "NAME")
	protected String name;
	@XmlElement(name = "TYPE")
	protected Long type;
	@XmlElement(name = "PARENTID")
	protected Long parentid;
	@XmlElement(name = "CITYTYPE")
	protected Long citytype;
	@XmlElement(name = "AREATYPE")
	protected Long areatype;
	@XmlElement(name = "JSCTYPE")
	protected Long jsctype;

	/**
	 * Gets the value of the id property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setId(Long value) {
		this.id = value;
	}

	/**
	 * Gets the value of the name property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNAME() {
		return name;
	}

	/**
	 * Sets the value of the name property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNAME(String value) {
		this.name = value;
	}

	/**
	 * Gets the value of the type property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getTYPE() {
		return type;
	}

	/**
	 * Sets the value of the type property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setTYPE(Long value) {
		this.type = value;
	}

	/**
	 * Gets the value of the parentid property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getPARENTID() {
		return parentid;
	}

	/**
	 * Sets the value of the parentid property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setPARENTID(Long value) {
		this.parentid = value;
	}

	/**
	 * Gets the value of the citytype property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getCITYTYPE() {
		return citytype;
	}

	/**
	 * Sets the value of the citytype property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setCITYTYPE(Long value) {
		this.citytype = value;
	}

	/**
	 * Gets the value of the areatype property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getAREATYPE() {
		return areatype;
	}

	/**
	 * Sets the value of the areatype property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setAREATYPE(Long value) {
		this.areatype = value;
	}

	/**
	 * Gets the value of the jsctype property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getJSCTYPE() {
		return jsctype;
	}

	/**
	 * Sets the value of the jsctype property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setJSCTYPE(Long value) {
		this.jsctype = value;
	}

}
