package com.ghy.WSClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for jytzgl complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;jytzgl&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base=&quot;{http://webservice.ncplt.cci.org/}baseEntity&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;ID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Nhbh&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Jyid&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Cpname&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Cpid&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Cpzl&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Cpdj&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Dkbh&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Zrr&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Qx&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Rq&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Bz&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Dj&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Jye&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;HZSBM&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Nhbbh&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jytzgl", propOrder = { "id", "nhbh", "jyid", "cpname", "cpid", "cpzl", "cpdj", "dkbh", "zrr", "qx", "rq", "bz", "dj",
		"jye", "hzsbm", "nhbbh" })
public class Jytzgl extends BaseEntity {

	@XmlElement(name = "ID")
	protected Long id;
	@XmlElement(name = "Nhbh")
	protected String nhbh;
	@XmlElement(name = "Jyid")
	protected String jyid;
	@XmlElement(name = "Cpname")
	protected String cpname;
	@XmlElement(name = "Cpid")
	protected String cpid;
	@XmlElement(name = "Cpzl")
	protected String cpzl;
	@XmlElement(name = "Cpdj")
	protected String cpdj;
	@XmlElement(name = "Dkbh")
	protected String dkbh;
	@XmlElement(name = "Zrr")
	protected String zrr;
	@XmlElement(name = "Qx")
	protected String qx;
	@XmlElement(name = "Rq")
	protected String rq;
	@XmlElement(name = "Bz")
	protected String bz;
	@XmlElement(name = "Dj")
	protected String dj;
	@XmlElement(name = "Jye")
	protected String jye;
	@XmlElement(name = "HZSBM")
	protected String hzsbm;
	@XmlElement(name = "Nhbbh")
	protected String nhbbh;

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
	 * Gets the value of the jyid property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getJyid() {
		return jyid;
	}

	/**
	 * Sets the value of the jyid property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setJyid(String value) {
		this.jyid = value;
	}

	/**
	 * Gets the value of the cpname property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCpname() {
		return cpname;
	}

	/**
	 * Sets the value of the cpname property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCpname(String value) {
		this.cpname = value;
	}

	/**
	 * Gets the value of the cpid property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCpid() {
		return cpid;
	}

	/**
	 * Sets the value of the cpid property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCpid(String value) {
		this.cpid = value;
	}

	/**
	 * Gets the value of the cpzl property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCpzl() {
		return cpzl;
	}

	/**
	 * Sets the value of the cpzl property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCpzl(String value) {
		this.cpzl = value;
	}

	/**
	 * Gets the value of the cpdj property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCpdj() {
		return cpdj;
	}

	/**
	 * Sets the value of the cpdj property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCpdj(String value) {
		this.cpdj = value;
	}

	/**
	 * Gets the value of the dkbh property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDkbh() {
		return dkbh;
	}

	/**
	 * Sets the value of the dkbh property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDkbh(String value) {
		this.dkbh = value;
	}

	/**
	 * Gets the value of the zrr property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getZrr() {
		return zrr;
	}

	/**
	 * Sets the value of the zrr property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setZrr(String value) {
		this.zrr = value;
	}

	/**
	 * Gets the value of the qx property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getQx() {
		return qx;
	}

	/**
	 * Sets the value of the qx property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setQx(String value) {
		this.qx = value;
	}

	/**
	 * Gets the value of the rq property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRq() {
		return rq;
	}

	/**
	 * Sets the value of the rq property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRq(String value) {
		this.rq = value;
	}

	/**
	 * Gets the value of the bz property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBz() {
		return bz;
	}

	/**
	 * Sets the value of the bz property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBz(String value) {
		this.bz = value;
	}

	/**
	 * Gets the value of the dj property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDj() {
		return dj;
	}

	/**
	 * Sets the value of the dj property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDj(String value) {
		this.dj = value;
	}

	/**
	 * Gets the value of the jye property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getJye() {
		return jye;
	}

	/**
	 * Sets the value of the jye property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setJye(String value) {
		this.jye = value;
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

}
