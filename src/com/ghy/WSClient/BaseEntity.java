package com.ghy.WSClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for baseEntity complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;baseEntity&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;SUBJECTCODEID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;SUBJECTCODE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;ISUPDATE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}int&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;UPDATECODE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "baseEntity", propOrder = { "subjectcodeid", "subjectcode", "isupdate", "updatecode" })
public class BaseEntity {

	@XmlElement(name = "SUBJECTCODEID")
	protected String subjectcodeid;
	@XmlElement(name = "SUBJECTCODE")
	protected String subjectcode;
	@XmlElement(name = "ISUPDATE")
	protected Integer isupdate;
	@XmlElement(name = "UPDATECODE")
	protected String updatecode;

	/**
	 * Gets the value of the subjectcodeid property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSUBJECTCODEID() {
		return subjectcodeid;
	}

	/**
	 * Sets the value of the subjectcodeid property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSUBJECTCODEID(String value) {
		this.subjectcodeid = value;
	}

	/**
	 * Gets the value of the subjectcode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSUBJECTCODE() {
		return subjectcode;
	}

	/**
	 * Sets the value of the subjectcode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSUBJECTCODE(String value) {
		this.subjectcode = value;
	}

	/**
	 * Gets the value of the isupdate property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getISUPDATE() {
		return isupdate;
	}

	/**
	 * Sets the value of the isupdate property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setISUPDATE(Integer value) {
		this.isupdate = value;
	}

	/**
	 * Gets the value of the updatecode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUPDATECODE() {
		return updatecode;
	}

	/**
	 * Sets the value of the updatecode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUPDATECODE(String value) {
		this.updatecode = value;
	}

}
