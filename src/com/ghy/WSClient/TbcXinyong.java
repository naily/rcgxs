package com.ghy.WSClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for tbcXinyong complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;tbcXinyong&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base=&quot;{http://webservice.ncplt.cci.org/}baseEntity&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;ID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Jybh&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Nhbh&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Xyxx&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;nhbbh&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;HZSBM&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tbcXinyong", propOrder = { "id", "jybh", "nhbh", "xyxx", "nhbbh", "hzsbm" })
public class TbcXinyong extends BaseEntity {

	@XmlElement(name = "ID")
	protected Long id;
	@XmlElement(name = "Jybh")
	protected String jybh;
	@XmlElement(name = "Nhbh")
	protected String nhbh;
	@XmlElement(name = "Xyxx")
	protected String xyxx;
	protected String nhbbh;
	@XmlElement(name = "HZSBM")
	protected String hzsbm;

	/**
	 * Gets the value of the id property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getID() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setID(Long value) {
		this.id = value;
	}

	/**
	 * Gets the value of the jybh property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getJybh() {
		return jybh;
	}

	/**
	 * Sets the value of the jybh property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setJybh(String value) {
		this.jybh = value;
	}

	/**
	 * Gets the value of the nhbh property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNhbh() {
		return nhbh;
	}

	/**
	 * Sets the value of the nhbh property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNhbh(String value) {
		this.nhbh = value;
	}

	/**
	 * Gets the value of the xyxx property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getXyxx() {
		return xyxx;
	}

	/**
	 * Sets the value of the xyxx property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setXyxx(String value) {
		this.xyxx = value;
	}

	/**
	 * Gets the value of the nhbbh property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNhbbh() {
		return nhbbh;
	}

	/**
	 * Sets the value of the nhbbh property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNhbbh(String value) {
		this.nhbbh = value;
	}

	/**
	 * Gets the value of the hzsbm property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHZSBM() {
		return hzsbm;
	}

	/**
	 * Sets the value of the hzsbm property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHZSBM(String value) {
		this.hzsbm = value;
	}

}
