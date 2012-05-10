package com.ghy.WSClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for tjda complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;tjda&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;ID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;DKBM&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;ZZMJ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}double&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;BZSJ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}dateTime&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;YZSJ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}dateTime&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;YREA&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}int&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;MONTH&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}int&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;DAY&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}int&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Sysj&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}dateTime&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Nymc&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Nymyl&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Xsbs&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Fzdx&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Syr&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Sfsj&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}dateTime&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Flmc&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Hfmyl&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Yt&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Sfr&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
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
@XmlType(name = "tjda", propOrder = { "id", "dkbm", "zzmj", "bzsj", "yzsj", "yrea", "month", "day", "sysj", "nymc", "nymyl", "xsbs",
		"fzdx", "syr", "sfsj", "flmc", "hfmyl", "yt", "sfr", "subjectcodeid", "systemid" })
public class Tjda {

	@XmlElement(name = "ID")
	protected Long id;
	@XmlElement(name = "DKBM")
	protected String dkbm;
	@XmlElement(name = "ZZMJ")
	protected Double zzmj;
	@XmlElement(name = "BZSJ")
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar bzsj;
	@XmlElement(name = "YZSJ")
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar yzsj;
	@XmlElement(name = "YREA")
	protected Integer yrea;
	@XmlElement(name = "MONTH")
	protected Integer month;
	@XmlElement(name = "DAY")
	protected Integer day;
	@XmlElement(name = "Sysj")
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar sysj;
	@XmlElement(name = "Nymc")
	protected String nymc;
	@XmlElement(name = "Nymyl")
	protected String nymyl;
	@XmlElement(name = "Xsbs")
	protected String xsbs;
	@XmlElement(name = "Fzdx")
	protected String fzdx;
	@XmlElement(name = "Syr")
	protected String syr;
	@XmlElement(name = "Sfsj")
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar sfsj;
	@XmlElement(name = "Flmc")
	protected String flmc;
	@XmlElement(name = "Hfmyl")
	protected String hfmyl;
	@XmlElement(name = "Yt")
	protected String yt;
	@XmlElement(name = "Sfr")
	protected String sfr;
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
	 * Gets the value of the zzmj property.
	 * 
	 * @return possible object is {@link Double }
	 * 
	 */
	public Double getZZMJ() {
		return zzmj;
	}

	/**
	 * Sets the value of the zzmj property.
	 * 
	 * @param value
	 *            allowed object is {@link Double }
	 * 
	 */
	public void setZZMJ(Double value) {
		this.zzmj = value;
	}

	/**
	 * Gets the value of the bzsj property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getBZSJ() {
		return bzsj;
	}

	/**
	 * Sets the value of the bzsj property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setBZSJ(XMLGregorianCalendar value) {
		this.bzsj = value;
	}

	/**
	 * Gets the value of the yzsj property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getYZSJ() {
		return yzsj;
	}

	/**
	 * Sets the value of the yzsj property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setYZSJ(XMLGregorianCalendar value) {
		this.yzsj = value;
	}

	/**
	 * Gets the value of the yrea property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getYREA() {
		return yrea;
	}

	/**
	 * Sets the value of the yrea property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setYREA(Integer value) {
		this.yrea = value;
	}

	/**
	 * Gets the value of the month property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getMONTH() {
		return month;
	}

	/**
	 * Sets the value of the month property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setMONTH(Integer value) {
		this.month = value;
	}

	/**
	 * Gets the value of the day property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getDAY() {
		return day;
	}

	/**
	 * Sets the value of the day property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setDAY(Integer value) {
		this.day = value;
	}

	/**
	 * Gets the value of the sysj property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getSysj() {
		return sysj;
	}

	/**
	 * Sets the value of the sysj property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setSysj(XMLGregorianCalendar value) {
		this.sysj = value;
	}

	/**
	 * Gets the value of the nymc property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNymc() {
		return nymc;
	}

	/**
	 * Sets the value of the nymc property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNymc(String value) {
		this.nymc = value;
	}

	/**
	 * Gets the value of the nymyl property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNymyl() {
		return nymyl;
	}

	/**
	 * Sets the value of the nymyl property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNymyl(String value) {
		this.nymyl = value;
	}

	/**
	 * Gets the value of the xsbs property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getXsbs() {
		return xsbs;
	}

	/**
	 * Sets the value of the xsbs property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setXsbs(String value) {
		this.xsbs = value;
	}

	/**
	 * Gets the value of the fzdx property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFzdx() {
		return fzdx;
	}

	/**
	 * Sets the value of the fzdx property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFzdx(String value) {
		this.fzdx = value;
	}

	/**
	 * Gets the value of the syr property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSyr() {
		return syr;
	}

	/**
	 * Sets the value of the syr property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSyr(String value) {
		this.syr = value;
	}

	/**
	 * Gets the value of the sfsj property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getSfsj() {
		return sfsj;
	}

	/**
	 * Sets the value of the sfsj property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setSfsj(XMLGregorianCalendar value) {
		this.sfsj = value;
	}

	/**
	 * Gets the value of the flmc property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFlmc() {
		return flmc;
	}

	/**
	 * Sets the value of the flmc property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFlmc(String value) {
		this.flmc = value;
	}

	/**
	 * Gets the value of the hfmyl property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHfmyl() {
		return hfmyl;
	}

	/**
	 * Sets the value of the hfmyl property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHfmyl(String value) {
		this.hfmyl = value;
	}

	/**
	 * Gets the value of the yt property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getYt() {
		return yt;
	}

	/**
	 * Sets the value of the yt property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setYt(String value) {
		this.yt = value;
	}

	/**
	 * Gets the value of the sfr property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSfr() {
		return sfr;
	}

	/**
	 * Sets the value of the sfr property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSfr(String value) {
		this.sfr = value;
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
