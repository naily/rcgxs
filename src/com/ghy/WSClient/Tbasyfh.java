package com.ghy.WSClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for tbasyfh complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;tbasyfh&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base=&quot;{http://webservice.ncplt.cci.org/}baseEntity&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;ID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;SYBM&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;SYXM&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;RGFS&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;ZHGF&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}int&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;FHZQKSSJ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;FHZQZZSJ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;FHJE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}double&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Nhbbh&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
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
@XmlType(name = "tbasyfh", propOrder = { "id", "sybm", "syxm", "rgfs", "zhgf", "fhzqkssj", "fhzqzzsj", "fhje", "nhbbh", "hzsbm" })
public class Tbasyfh extends BaseEntity {

	@XmlElement(name = "ID")
	protected Long id;
	@XmlElement(name = "SYBM")
	protected String sybm;
	@XmlElement(name = "SYXM")
	protected String syxm;
	@XmlElement(name = "RGFS")
	protected String rgfs;
	@XmlElement(name = "ZHGF")
	protected Integer zhgf;
	@XmlElement(name = "FHZQKSSJ")
	protected String fhzqkssj;
	@XmlElement(name = "FHZQZZSJ")
	protected String fhzqzzsj;
	@XmlElement(name = "FHJE")
	protected Double fhje;
	@XmlElement(name = "Nhbbh")
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
	 * Gets the value of the sybm property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSYBM() {
		return sybm;
	}

	/**
	 * Sets the value of the sybm property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSYBM(String value) {
		this.sybm = value;
	}

	/**
	 * Gets the value of the syxm property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSYXM() {
		return syxm;
	}

	/**
	 * Sets the value of the syxm property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSYXM(String value) {
		this.syxm = value;
	}

	/**
	 * Gets the value of the rgfs property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRGFS() {
		return rgfs;
	}

	/**
	 * Sets the value of the rgfs property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRGFS(String value) {
		this.rgfs = value;
	}

	/**
	 * Gets the value of the zhgf property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getZHGF() {
		return zhgf;
	}

	/**
	 * Sets the value of the zhgf property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setZHGF(Integer value) {
		this.zhgf = value;
	}

	/**
	 * Gets the value of the fhzqkssj property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFHZQKSSJ() {
		return fhzqkssj;
	}

	/**
	 * Sets the value of the fhzqkssj property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFHZQKSSJ(String value) {
		this.fhzqkssj = value;
	}

	/**
	 * Gets the value of the fhzqzzsj property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFHZQZZSJ() {
		return fhzqzzsj;
	}

	/**
	 * Sets the value of the fhzqzzsj property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFHZQZZSJ(String value) {
		this.fhzqzzsj = value;
	}

	/**
	 * Gets the value of the fhje property.
	 * 
	 * @return possible object is {@link Double }
	 * 
	 */
	public Double getFHJE() {
		return fhje;
	}

	/**
	 * Sets the value of the fhje property.
	 * 
	 * @param value
	 *            allowed object is {@link Double }
	 * 
	 */
	public void setFHJE(Double value) {
		this.fhje = value;
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
