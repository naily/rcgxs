package com.ghy.WSClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for maiNanBoBao complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;maiNanBoBao&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base=&quot;{http://webservice.ncplt.cci.org/}baseEntity&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;MNBB_ID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;MNBB_TITLE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;MNBB_TYPE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}int&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;MNBB_CONTENT&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;MNBB_USERID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;MNBB_DATE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}dateTime&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "maiNanBoBao", propOrder = { "mnbbid", "mnbbtitle", "mnbbtype", "mnbbcontent", "mnbbuserid", "mnbbdate" })
public class MaiNanBoBao extends BaseEntity {

	@XmlElement(name = "MNBB_ID")
	protected Long mnbbid;
	@XmlElement(name = "MNBB_TITLE")
	protected String mnbbtitle;
	@XmlElement(name = "MNBB_TYPE")
	protected Integer mnbbtype;
	@XmlElement(name = "MNBB_CONTENT")
	protected String mnbbcontent;
	@XmlElement(name = "MNBB_USERID")
	protected String mnbbuserid;
	@XmlElement(name = "MNBB_DATE")
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar mnbbdate;

	/**
	 * Gets the value of the mnbbid property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getMNBBID() {
		return mnbbid;
	}

	/**
	 * Sets the value of the mnbbid property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setMNBBID(Long value) {
		this.mnbbid = value;
	}

	/**
	 * Gets the value of the mnbbtitle property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMNBBTITLE() {
		return mnbbtitle;
	}

	/**
	 * Sets the value of the mnbbtitle property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMNBBTITLE(String value) {
		this.mnbbtitle = value;
	}

	/**
	 * Gets the value of the mnbbtype property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getMNBBTYPE() {
		return mnbbtype;
	}

	/**
	 * Sets the value of the mnbbtype property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setMNBBTYPE(Integer value) {
		this.mnbbtype = value;
	}

	/**
	 * Gets the value of the mnbbcontent property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMNBBCONTENT() {
		return mnbbcontent;
	}

	/**
	 * Sets the value of the mnbbcontent property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMNBBCONTENT(String value) {
		this.mnbbcontent = value;
	}

	/**
	 * Gets the value of the mnbbuserid property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMNBBUSERID() {
		return mnbbuserid;
	}

	/**
	 * Sets the value of the mnbbuserid property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMNBBUSERID(String value) {
		this.mnbbuserid = value;
	}

	/**
	 * Gets the value of the mnbbdate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getMNBBDATE() {
		return mnbbdate;
	}

	/**
	 * Sets the value of the mnbbdate property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setMNBBDATE(XMLGregorianCalendar value) {
		this.mnbbdate = value;
	}

}
