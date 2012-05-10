package com.ghy.WSClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for djhb complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;djhb&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;HBID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;HZSBM&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;PZ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;HBMC&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;HBLX&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;SZD&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;LXDH&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;LXDZ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;EMAIL&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;SFHB&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}int&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;IMAGEDIR&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;LXR&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;HBBM&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;SUBJECTCODEID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;SYSTEMID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "djhb", propOrder = { "hbid", "hzsbm", "pz", "hbmc", "hblx", "szd", "lxdh", "lxdz", "email", "sfhb", "imagedir", "lxr",
		"hbbm", "subjectcodeid", "systemid" })
public class Djhb {

	@XmlElement(name = "HBID")
	protected Long hbid;
	@XmlElement(name = "HZSBM")
	protected String hzsbm;
	@XmlElement(name = "PZ")
	protected String pz;
	@XmlElement(name = "HBMC")
	protected String hbmc;
	@XmlElement(name = "HBLX")
	protected String hblx;
	@XmlElement(name = "SZD")
	protected String szd;
	@XmlElement(name = "LXDH")
	protected String lxdh;
	@XmlElement(name = "LXDZ")
	protected String lxdz;
	@XmlElement(name = "EMAIL")
	protected String email;
	@XmlElement(name = "SFHB")
	protected Integer sfhb;
	@XmlElement(name = "IMAGEDIR")
	protected String imagedir;
	@XmlElement(name = "LXR")
	protected String lxr;
	@XmlElement(name = "HBBM")
	protected String hbbm;
	@XmlElement(name = "SUBJECTCODEID")
	protected String subjectcodeid;
	@XmlElement(name = "SYSTEMID")
	protected String systemid;

	/**
	 * Gets the value of the hbid property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getHBID() {
		return hbid;
	}

	/**
	 * Sets the value of the hbid property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setHBID(Long value) {
		this.hbid = value;
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
	 * Gets the value of the pz property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPZ() {
		return pz;
	}

	/**
	 * Sets the value of the pz property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPZ(String value) {
		this.pz = value;
	}

	/**
	 * Gets the value of the hbmc property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHBMC() {
		return hbmc;
	}

	/**
	 * Sets the value of the hbmc property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHBMC(String value) {
		this.hbmc = value;
	}

	/**
	 * Gets the value of the hblx property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHBLX() {
		return hblx;
	}

	/**
	 * Sets the value of the hblx property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHBLX(String value) {
		this.hblx = value;
	}

	/**
	 * Gets the value of the szd property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSZD() {
		return szd;
	}

	/**
	 * Sets the value of the szd property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSZD(String value) {
		this.szd = value;
	}

	/**
	 * Gets the value of the lxdh property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLXDH() {
		return lxdh;
	}

	/**
	 * Sets the value of the lxdh property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLXDH(String value) {
		this.lxdh = value;
	}

	/**
	 * Gets the value of the lxdz property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLXDZ() {
		return lxdz;
	}

	/**
	 * Sets the value of the lxdz property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLXDZ(String value) {
		this.lxdz = value;
	}

	/**
	 * Gets the value of the email property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEMAIL() {
		return email;
	}

	/**
	 * Sets the value of the email property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEMAIL(String value) {
		this.email = value;
	}

	/**
	 * Gets the value of the sfhb property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getSFHB() {
		return sfhb;
	}

	/**
	 * Sets the value of the sfhb property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setSFHB(Integer value) {
		this.sfhb = value;
	}

	/**
	 * Gets the value of the imagedir property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getIMAGEDIR() {
		return imagedir;
	}

	/**
	 * Sets the value of the imagedir property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setIMAGEDIR(String value) {
		this.imagedir = value;
	}

	/**
	 * Gets the value of the lxr property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLXR() {
		return lxr;
	}

	/**
	 * Sets the value of the lxr property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLXR(String value) {
		this.lxr = value;
	}

	/**
	 * Gets the value of the hbbm property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHBBM() {
		return hbbm;
	}

	/**
	 * Sets the value of the hbbm property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHBBM(String value) {
		this.hbbm = value;
	}

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
	 * Gets the value of the systemid property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSYSTEMID() {
		return systemid;
	}

	/**
	 * Sets the value of the systemid property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSYSTEMID(String value) {
		this.systemid = value;
	}

}
