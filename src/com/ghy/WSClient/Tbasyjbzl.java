package com.ghy.WSClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for tbasyjbzl complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;tbasyjbzl&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base=&quot;{http://webservice.ncplt.cci.org/}baseEntity&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;ID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;HZSBM&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;SYBM&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;XM&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;XB&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;Tpurl&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;CYLY&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;RSSJ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;RSZJSJ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;SNZW&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;DZ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;SFRB&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;SFJRHZ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;LXDH&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;NHBBH&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tbasyjbzl", propOrder = { "id", "hzsbm", "sybm", "xm", "xb", "tpurl", "cyly", "rssj", "rszjsj", "snzw", "dz", "sfrb",
		"sfjrhz", "lxdh", "nhbbh" })
public class Tbasyjbzl extends BaseEntity {

	@XmlElement(name = "ID")
	protected Long id;
	@XmlElement(name = "HZSBM", required = true)
	protected String hzsbm;
	@XmlElement(name = "SYBM", required = true)
	protected String sybm;
	@XmlElement(name = "XM", required = true)
	protected String xm;
	@XmlElement(name = "XB", required = true)
	protected String xb;
	@XmlElement(name = "Tpurl")
	protected String tpurl;
	@XmlElement(name = "CYLY")
	protected String cyly;
	@XmlElement(name = "RSSJ")
	protected String rssj;
	@XmlElement(name = "RSZJSJ")
	protected String rszjsj;
	@XmlElement(name = "SNZW")
	protected String snzw;
	@XmlElement(name = "DZ")
	protected String dz;
	@XmlElement(name = "SFRB")
	protected String sfrb;
	@XmlElement(name = "SFJRHZ")
	protected String sfjrhz;
	@XmlElement(name = "LXDH")
	protected String lxdh;
	@XmlElement(name = "NHBBH")
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
	 * Gets the value of the xm property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getXM() {
		return xm;
	}

	/**
	 * Sets the value of the xm property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setXM(String value) {
		this.xm = value;
	}

	/**
	 * Gets the value of the xb property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getXB() {
		return xb;
	}

	/**
	 * Sets the value of the xb property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setXB(String value) {
		this.xb = value;
	}

	/**
	 * Gets the value of the tpurl property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTpurl() {
		return tpurl;
	}

	/**
	 * Sets the value of the tpurl property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTpurl(String value) {
		this.tpurl = value;
	}

	/**
	 * Gets the value of the cyly property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCYLY() {
		return cyly;
	}

	/**
	 * Sets the value of the cyly property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCYLY(String value) {
		this.cyly = value;
	}

	/**
	 * Gets the value of the rssj property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRSSJ() {
		return rssj;
	}

	/**
	 * Sets the value of the rssj property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRSSJ(String value) {
		this.rssj = value;
	}

	/**
	 * Gets the value of the rszjsj property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRSZJSJ() {
		return rszjsj;
	}

	/**
	 * Sets the value of the rszjsj property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRSZJSJ(String value) {
		this.rszjsj = value;
	}

	/**
	 * Gets the value of the snzw property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSNZW() {
		return snzw;
	}

	/**
	 * Sets the value of the snzw property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSNZW(String value) {
		this.snzw = value;
	}

	/**
	 * Gets the value of the dz property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDZ() {
		return dz;
	}

	/**
	 * Sets the value of the dz property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDZ(String value) {
		this.dz = value;
	}

	/**
	 * Gets the value of the sfrb property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSFRB() {
		return sfrb;
	}

	/**
	 * Sets the value of the sfrb property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSFRB(String value) {
		this.sfrb = value;
	}

	/**
	 * Gets the value of the sfjrhz property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSFJRHZ() {
		return sfjrhz;
	}

	/**
	 * Sets the value of the sfjrhz property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSFJRHZ(String value) {
		this.sfjrhz = value;
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
	 * Gets the value of the nhbbh property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNHBBH() {
		return nhbbh;
	}

	/**
	 * Sets the value of the nhbbh property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNHBBH(String value) {
		this.nhbbh = value;
	}

}
