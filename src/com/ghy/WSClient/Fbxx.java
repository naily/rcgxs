package com.ghy.WSClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for fbxx complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;fbxx&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base=&quot;{http://webservice.ncplt.cci.org/}baseEntity&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;id&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;hzsbm&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;hzsmc&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;cpid&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;cpmc&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;jhjyl&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}double&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;fzr&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;tel&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;jy&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;rq&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;tzbt&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;tzid&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fbxx", propOrder = { "id", "hzsbm", "hzsmc", "cpid", "cpmc", "jhjyl", "fzr", "tel", "jy", "rq", "tzbt", "tzid" })
public class Fbxx extends BaseEntity {

	protected Long id;
	protected String hzsbm;
	protected String hzsmc;
	protected String cpid;
	protected String cpmc;
	protected Double jhjyl;
	protected String fzr;
	protected String tel;
	protected String jy;
	protected String rq;
	protected String tzbt;
	protected Long tzid;

	/**
	 * Gets the value of the id property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setId(Long value) {
		this.id = value;
	}

	/**
	 * Gets the value of the hzsbm property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHzsbm() {
		return hzsbm;
	}

	/**
	 * Sets the value of the hzsbm property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHzsbm(String value) {
		this.hzsbm = value;
	}

	/**
	 * Gets the value of the hzsmc property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHzsmc() {
		return hzsmc;
	}

	/**
	 * Sets the value of the hzsmc property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHzsmc(String value) {
		this.hzsmc = value;
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
	 * Gets the value of the cpmc property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCpmc() {
		return cpmc;
	}

	/**
	 * Sets the value of the cpmc property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCpmc(String value) {
		this.cpmc = value;
	}

	/**
	 * Gets the value of the jhjyl property.
	 * 
	 * @return possible object is {@link Double }
	 * 
	 */
	public Double getJhjyl() {
		return jhjyl;
	}

	/**
	 * Sets the value of the jhjyl property.
	 * 
	 * @param value
	 *            allowed object is {@link Double }
	 * 
	 */
	public void setJhjyl(Double value) {
		this.jhjyl = value;
	}

	/**
	 * Gets the value of the fzr property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFzr() {
		return fzr;
	}

	/**
	 * Sets the value of the fzr property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFzr(String value) {
		this.fzr = value;
	}

	/**
	 * Gets the value of the tel property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * Sets the value of the tel property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTel(String value) {
		this.tel = value;
	}

	/**
	 * Gets the value of the jy property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getJy() {
		return jy;
	}

	/**
	 * Sets the value of the jy property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setJy(String value) {
		this.jy = value;
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
	 * Gets the value of the tzbt property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTzbt() {
		return tzbt;
	}

	/**
	 * Sets the value of the tzbt property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTzbt(String value) {
		this.tzbt = value;
	}

	/**
	 * Gets the value of the tzid property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getTzid() {
		return tzid;
	}

	/**
	 * Sets the value of the tzid property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setTzid(Long value) {
		this.tzid = value;
	}

}
