package com.ghy.WSClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for tbctz complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;tbctz&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base=&quot;{http://webservice.ncplt.cci.org/}baseEntity&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;TZID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;HZSBM&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;ZT&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;TZFL&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;LY&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;YDZT&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}int&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;TZZT&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;JSSJ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}dateTime&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;JSZ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;FSZ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;FSSJ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}dateTime&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;SFSC&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}int&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;TZNR&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;AREAID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;djcy&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;endTime&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}dateTime&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tbctz", propOrder = { "tzid", "hzsbm", "zt", "tzfl", "ly", "ydzt", "tzzt", "jssj", "jsz", "fsz", "fssj", "sfsc", "tznr",
		"areaid", "djcy", "endTime" })
public class Tbctz extends BaseEntity {

	@XmlElement(name = "TZID")
	protected Long tzid;
	@XmlElement(name = "HZSBM")
	protected String hzsbm;
	@XmlElement(name = "ZT")
	protected String zt;
	@XmlElement(name = "TZFL")
	protected String tzfl;
	@XmlElement(name = "LY")
	protected String ly;
	@XmlElement(name = "YDZT")
	protected Integer ydzt;
	@XmlElement(name = "TZZT")
	protected String tzzt;
	@XmlElement(name = "JSSJ")
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar jssj;
	@XmlElement(name = "JSZ")
	protected String jsz;
	@XmlElement(name = "FSZ")
	protected String fsz;
	@XmlElement(name = "FSSJ")
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar fssj;
	@XmlElement(name = "SFSC")
	protected Integer sfsc;
	@XmlElement(name = "TZNR")
	protected String tznr;
	@XmlElement(name = "AREAID")
	protected String areaid;
	protected String djcy;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar endTime;

	/**
	 * Gets the value of the tzid property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getTZID() {
		return tzid;
	}

	/**
	 * Sets the value of the tzid property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setTZID(Long value) {
		this.tzid = value;
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
	 * Gets the value of the zt property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getZT() {
		return zt;
	}

	/**
	 * Sets the value of the zt property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setZT(String value) {
		this.zt = value;
	}

	/**
	 * Gets the value of the tzfl property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTZFL() {
		return tzfl;
	}

	/**
	 * Sets the value of the tzfl property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTZFL(String value) {
		this.tzfl = value;
	}

	/**
	 * Gets the value of the ly property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLY() {
		return ly;
	}

	/**
	 * Sets the value of the ly property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLY(String value) {
		this.ly = value;
	}

	/**
	 * Gets the value of the ydzt property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getYDZT() {
		return ydzt;
	}

	/**
	 * Sets the value of the ydzt property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setYDZT(Integer value) {
		this.ydzt = value;
	}

	/**
	 * Gets the value of the tzzt property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTZZT() {
		return tzzt;
	}

	/**
	 * Sets the value of the tzzt property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTZZT(String value) {
		this.tzzt = value;
	}

	/**
	 * Gets the value of the jssj property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getJSSJ() {
		return jssj;
	}

	/**
	 * Sets the value of the jssj property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setJSSJ(XMLGregorianCalendar value) {
		this.jssj = value;
	}

	/**
	 * Gets the value of the jsz property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getJSZ() {
		return jsz;
	}

	/**
	 * Sets the value of the jsz property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setJSZ(String value) {
		this.jsz = value;
	}

	/**
	 * Gets the value of the fsz property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFSZ() {
		return fsz;
	}

	/**
	 * Sets the value of the fsz property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFSZ(String value) {
		this.fsz = value;
	}

	/**
	 * Gets the value of the fssj property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getFSSJ() {
		return fssj;
	}

	/**
	 * Sets the value of the fssj property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setFSSJ(XMLGregorianCalendar value) {
		this.fssj = value;
	}

	/**
	 * Gets the value of the sfsc property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getSFSC() {
		return sfsc;
	}

	/**
	 * Sets the value of the sfsc property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setSFSC(Integer value) {
		this.sfsc = value;
	}

	/**
	 * Gets the value of the tznr property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTZNR() {
		return tznr;
	}

	/**
	 * Sets the value of the tznr property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTZNR(String value) {
		this.tznr = value;
	}

	/**
	 * Gets the value of the areaid property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAREAID() {
		return areaid;
	}

	/**
	 * Sets the value of the areaid property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAREAID(String value) {
		this.areaid = value;
	}

	/**
	 * Gets the value of the djcy property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDjcy() {
		return djcy;
	}

	/**
	 * Sets the value of the djcy property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDjcy(String value) {
		this.djcy = value;
	}

	/**
	 * Gets the value of the endTime property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getEndTime() {
		return endTime;
	}

	/**
	 * Sets the value of the endTime property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setEndTime(XMLGregorianCalendar value) {
		this.endTime = value;
	}

}
