package com.ghy.WSClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for hzsLdxx complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;hzsLdxx&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;LDID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot;/&gt;
 *         &lt;element name=&quot;HZSBM&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;XXFL&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;LDCDPJ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;YXJGPJ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;SJCP&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;SJFSDQ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;SJYXFWGJ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;XXBT&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;XXNR&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;FSZ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;FSSJ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}dateTime&quot;/&gt;
 *         &lt;element name=&quot;JSSJ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}dateTime&quot;/&gt;
 *         &lt;element name=&quot;DKSJ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}dateTime&quot;/&gt;
 *         &lt;element name=&quot;JSZ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
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
@XmlType(name = "hzsLdxx", propOrder = { "ldid", "hzsbm", "xxfl", "ldcdpj",
		"yxjgpj", "sjcp", "sjfsdq", "sjyxfwgj", "xxbt", "xxnr", "fsz", "fssj",
		"jssj", "dksj", "jsz", "subjectcodeid", "systemid" })
public class HzsLdxx {

	@XmlElement(name = "LDID")
	protected long ldid;
	@XmlElement(name = "HZSBM", required = true)
	protected String hzsbm;
	@XmlElement(name = "XXFL", required = true)
	protected String xxfl;
	@XmlElement(name = "LDCDPJ", required = true)
	protected String ldcdpj;
	@XmlElement(name = "YXJGPJ", required = true)
	protected String yxjgpj;
	@XmlElement(name = "SJCP", required = true)
	protected String sjcp;
	@XmlElement(name = "SJFSDQ", required = true)
	protected String sjfsdq;
	@XmlElement(name = "SJYXFWGJ", required = true)
	protected String sjyxfwgj;
	@XmlElement(name = "XXBT", required = true)
	protected String xxbt;
	@XmlElement(name = "XXNR", required = true)
	protected String xxnr;
	@XmlElement(name = "FSZ", required = true)
	protected String fsz;
	@XmlElement(name = "FSSJ", required = true)
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar fssj;
	@XmlElement(name = "JSSJ", required = true)
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar jssj;
	@XmlElement(name = "DKSJ", required = true)
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar dksj;
	@XmlElement(name = "JSZ", required = true)
	protected String jsz;
	@XmlElement(name = "SUBJECTCODEID")
	protected String subjectcodeid;
	@XmlElement(name = "SYSTEMID")
	protected Long systemid;

	/**
	 * Gets the value of the ldid property.
	 * 
	 */
	public long getLDID() {
		return ldid;
	}

	/**
	 * Sets the value of the ldid property.
	 * 
	 */
	public void setLDID(long value) {
		this.ldid = value;
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
	 * Gets the value of the xxfl property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getXXFL() {
		return xxfl;
	}

	/**
	 * Sets the value of the xxfl property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setXXFL(String value) {
		this.xxfl = value;
	}

	/**
	 * Gets the value of the ldcdpj property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLDCDPJ() {
		return ldcdpj;
	}

	/**
	 * Sets the value of the ldcdpj property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLDCDPJ(String value) {
		this.ldcdpj = value;
	}

	/**
	 * Gets the value of the yxjgpj property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getYXJGPJ() {
		return yxjgpj;
	}

	/**
	 * Sets the value of the yxjgpj property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setYXJGPJ(String value) {
		this.yxjgpj = value;
	}

	/**
	 * Gets the value of the sjcp property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSJCP() {
		return sjcp;
	}

	/**
	 * Sets the value of the sjcp property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSJCP(String value) {
		this.sjcp = value;
	}

	/**
	 * Gets the value of the sjfsdq property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSJFSDQ() {
		return sjfsdq;
	}

	/**
	 * Sets the value of the sjfsdq property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSJFSDQ(String value) {
		this.sjfsdq = value;
	}

	/**
	 * Gets the value of the sjyxfwgj property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSJYXFWGJ() {
		return sjyxfwgj;
	}

	/**
	 * Sets the value of the sjyxfwgj property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSJYXFWGJ(String value) {
		this.sjyxfwgj = value;
	}

	/**
	 * Gets the value of the xxbt property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getXXBT() {
		return xxbt;
	}

	/**
	 * Sets the value of the xxbt property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setXXBT(String value) {
		this.xxbt = value;
	}

	/**
	 * Gets the value of the xxnr property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getXXNR() {
		return xxnr;
	}

	/**
	 * Sets the value of the xxnr property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setXXNR(String value) {
		this.xxnr = value;
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
	 * Gets the value of the dksj property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getDKSJ() {
		return dksj;
	}

	/**
	 * Sets the value of the dksj property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setDKSJ(XMLGregorianCalendar value) {
		this.dksj = value;
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
