package com.ghy.WSClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for hzsjbxx complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;hzsjbxx&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;ID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;HZSBM&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;HZSMC&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;FRDB&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;SSDQ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;DQDM&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;SYRS&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}int&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;LXR&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;LXDH&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;LXDZ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;TDZMJ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}double&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;HZSLX&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}int&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;LONGITUDE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}double&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;LATITUDE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}double&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;IMAGEDIR&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hzsjbxx", propOrder = { "id", "hzsbm", "hzsmc", "frdb", "ssdq", "dqdm", "syrs", "lxr", "lxdh", "lxdz", "tdzmj", "hzslx",
		"longitude", "latitude", "imagedir" })
public class Hzsjbxx {

	@XmlElement(name = "ID")
	protected Long id;
	@XmlElement(name = "HZSBM")
	protected String hzsbm;
	@XmlElement(name = "HZSMC")
	protected String hzsmc;
	@XmlElement(name = "FRDB")
	protected String frdb;
	@XmlElement(name = "SSDQ")
	protected String ssdq;
	@XmlElement(name = "DQDM")
	protected String dqdm;
	@XmlElement(name = "SYRS")
	protected Integer syrs;
	@XmlElement(name = "LXR")
	protected String lxr;
	@XmlElement(name = "LXDH")
	protected String lxdh;
	@XmlElement(name = "LXDZ")
	protected String lxdz;
	@XmlElement(name = "TDZMJ")
	protected Double tdzmj;
	@XmlElement(name = "HZSLX")
	protected Integer hzslx;
	@XmlElement(name = "LONGITUDE")
	protected Double longitude;
	@XmlElement(name = "LATITUDE")
	protected Double latitude;
	@XmlElement(name = "IMAGEDIR")
	protected String imagedir;

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
	 * Gets the value of the hzsmc property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHZSMC() {
		return hzsmc;
	}

	/**
	 * Sets the value of the hzsmc property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHZSMC(String value) {
		this.hzsmc = value;
	}

	/**
	 * Gets the value of the frdb property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFRDB() {
		return frdb;
	}

	/**
	 * Sets the value of the frdb property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFRDB(String value) {
		this.frdb = value;
	}

	/**
	 * Gets the value of the ssdq property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSSDQ() {
		return ssdq;
	}

	/**
	 * Sets the value of the ssdq property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSSDQ(String value) {
		this.ssdq = value;
	}

	/**
	 * Gets the value of the dqdm property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDQDM() {
		return dqdm;
	}

	/**
	 * Sets the value of the dqdm property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDQDM(String value) {
		this.dqdm = value;
	}

	/**
	 * Gets the value of the syrs property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getSYRS() {
		return syrs;
	}

	/**
	 * Sets the value of the syrs property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setSYRS(Integer value) {
		this.syrs = value;
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
	 * Gets the value of the tdzmj property.
	 * 
	 * @return possible object is {@link Double }
	 * 
	 */
	public Double getTDZMJ() {
		return tdzmj;
	}

	/**
	 * Sets the value of the tdzmj property.
	 * 
	 * @param value
	 *            allowed object is {@link Double }
	 * 
	 */
	public void setTDZMJ(Double value) {
		this.tdzmj = value;
	}

	/**
	 * Gets the value of the hzslx property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getHZSLX() {
		return hzslx;
	}

	/**
	 * Sets the value of the hzslx property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setHZSLX(Integer value) {
		this.hzslx = value;
	}

	/**
	 * Gets the value of the longitude property.
	 * 
	 * @return possible object is {@link Double }
	 * 
	 */
	public Double getLONGITUDE() {
		return longitude;
	}

	/**
	 * Sets the value of the longitude property.
	 * 
	 * @param value
	 *            allowed object is {@link Double }
	 * 
	 */
	public void setLONGITUDE(Double value) {
		this.longitude = value;
	}

	/**
	 * Gets the value of the latitude property.
	 * 
	 * @return possible object is {@link Double }
	 * 
	 */
	public Double getLATITUDE() {
		return latitude;
	}

	/**
	 * Sets the value of the latitude property.
	 * 
	 * @param value
	 *            allowed object is {@link Double }
	 * 
	 */
	public void setLATITUDE(Double value) {
		this.latitude = value;
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

}
