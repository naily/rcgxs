package com.ghy.WSClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for dkxx complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;dkxx&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;ID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;HZSBM&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;DKBM&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;DKMC&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;DKjd&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}double&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;DKwd&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}double&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;DKMJ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}double&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;DKCD&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}double&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;DKKD&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}double&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;JSYXM&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;JSYLXFS&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;BZYXM&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;BZYLXFS&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;SUBJECTCODEID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;SYSTEMID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dkxx", propOrder = { "id", "hzsbm", "dkbm", "dkmc", "dKjd", "dKwd", "dkmj", "dkcd", "dkkd", "jsyxm", "jsylxfs", "bzyxm",
		"bzylxfs", "subjectcodeid", "systemid" })
public class Dkxx {

	@XmlElement(name = "ID")
	protected Long id;
	@XmlElement(name = "HZSBM")
	protected String hzsbm;
	@XmlElement(name = "DKBM")
	protected String dkbm;
	@XmlElement(name = "DKMC")
	protected String dkmc;
	@XmlElement(name = "DKjd")
	protected Double dKjd;
	@XmlElement(name = "DKwd")
	protected Double dKwd;
	@XmlElement(name = "DKMJ")
	protected Double dkmj;
	@XmlElement(name = "DKCD")
	protected Double dkcd;
	@XmlElement(name = "DKKD")
	protected Double dkkd;
	@XmlElement(name = "JSYXM")
	protected String jsyxm;
	@XmlElement(name = "JSYLXFS")
	protected String jsylxfs;
	@XmlElement(name = "BZYXM")
	protected String bzyxm;
	@XmlElement(name = "BZYLXFS")
	protected String bzylxfs;
	@XmlElement(name = "SUBJECTCODEID")
	protected String subjectcodeid;
	@XmlElement(name = "SYSTEMID")
	protected Long systemid;

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
	 * Gets the value of the dkbm property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDKBM() {
		return dkbm;
	}

	/**
	 * Sets the value of the dkbm property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDKBM(String value) {
		this.dkbm = value;
	}

	/**
	 * Gets the value of the dkmc property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDKMC() {
		return dkmc;
	}

	/**
	 * Sets the value of the dkmc property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDKMC(String value) {
		this.dkmc = value;
	}

	/**
	 * Gets the value of the dKjd property.
	 * 
	 * @return possible object is {@link Double }
	 * 
	 */
	public Double getDKjd() {
		return dKjd;
	}

	/**
	 * Sets the value of the dKjd property.
	 * 
	 * @param value
	 *            allowed object is {@link Double }
	 * 
	 */
	public void setDKjd(Double value) {
		this.dKjd = value;
	}

	/**
	 * Gets the value of the dKwd property.
	 * 
	 * @return possible object is {@link Double }
	 * 
	 */
	public Double getDKwd() {
		return dKwd;
	}

	/**
	 * Sets the value of the dKwd property.
	 * 
	 * @param value
	 *            allowed object is {@link Double }
	 * 
	 */
	public void setDKwd(Double value) {
		this.dKwd = value;
	}

	/**
	 * Gets the value of the dkmj property.
	 * 
	 * @return possible object is {@link Double }
	 * 
	 */
	public Double getDKMJ() {
		return dkmj;
	}

	/**
	 * Sets the value of the dkmj property.
	 * 
	 * @param value
	 *            allowed object is {@link Double }
	 * 
	 */
	public void setDKMJ(Double value) {
		this.dkmj = value;
	}

	/**
	 * Gets the value of the dkcd property.
	 * 
	 * @return possible object is {@link Double }
	 * 
	 */
	public Double getDKCD() {
		return dkcd;
	}

	/**
	 * Sets the value of the dkcd property.
	 * 
	 * @param value
	 *            allowed object is {@link Double }
	 * 
	 */
	public void setDKCD(Double value) {
		this.dkcd = value;
	}

	/**
	 * Gets the value of the dkkd property.
	 * 
	 * @return possible object is {@link Double }
	 * 
	 */
	public Double getDKKD() {
		return dkkd;
	}

	/**
	 * Sets the value of the dkkd property.
	 * 
	 * @param value
	 *            allowed object is {@link Double }
	 * 
	 */
	public void setDKKD(Double value) {
		this.dkkd = value;
	}

	/**
	 * Gets the value of the jsyxm property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getJSYXM() {
		return jsyxm;
	}

	/**
	 * Sets the value of the jsyxm property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setJSYXM(String value) {
		this.jsyxm = value;
	}

	/**
	 * Gets the value of the jsylxfs property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getJSYLXFS() {
		return jsylxfs;
	}

	/**
	 * Sets the value of the jsylxfs property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setJSYLXFS(String value) {
		this.jsylxfs = value;
	}

	/**
	 * Gets the value of the bzyxm property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBZYXM() {
		return bzyxm;
	}

	/**
	 * Sets the value of the bzyxm property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBZYXM(String value) {
		this.bzyxm = value;
	}

	/**
	 * Gets the value of the bzylxfs property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBZYLXFS() {
		return bzylxfs;
	}

	/**
	 * Sets the value of the bzylxfs property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBZYLXFS(String value) {
		this.bzylxfs = value;
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
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getSYSTEMID() {
		return systemid;
	}

	/**
	 * Sets the value of the systemid property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setSYSTEMID(Long value) {
		this.systemid = value;
	}

}
