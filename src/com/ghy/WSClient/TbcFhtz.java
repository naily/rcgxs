package com.ghy.WSClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for tbcFhtz complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;tbcFhtz&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base=&quot;{http://webservice.ncplt.cci.org/}baseEntity&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;fhtzid&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;sjr&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;tzzt&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;tznr&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tbcFhtz", propOrder = { "fhtzid", "sjr", "tzzt", "tznr" })
public class TbcFhtz extends BaseEntity {

	protected Long fhtzid;
	protected String sjr;
	protected String tzzt;
	protected String tznr;

	/**
	 * Gets the value of the fhtzid property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getFhtzid() {
		return fhtzid;
	}

	/**
	 * Sets the value of the fhtzid property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setFhtzid(Long value) {
		this.fhtzid = value;
	}

	/**
	 * Gets the value of the sjr property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSjr() {
		return sjr;
	}

	/**
	 * Sets the value of the sjr property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSjr(String value) {
		this.sjr = value;
	}

	/**
	 * Gets the value of the tzzt property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTzzt() {
		return tzzt;
	}

	/**
	 * Sets the value of the tzzt property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTzzt(String value) {
		this.tzzt = value;
	}

	/**
	 * Gets the value of the tznr property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTznr() {
		return tznr;
	}

	/**
	 * Sets the value of the tznr property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTznr(String value) {
		this.tznr = value;
	}

}
