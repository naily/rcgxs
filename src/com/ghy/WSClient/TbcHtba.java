package com.ghy.WSClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for tbcHtba complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;tbcHtba&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;bz&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;id&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}int&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;jid&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;jname&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;qdsj&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;subjectcodeId&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;xybh&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;xymc&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;xyqx&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;xyurl&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;yid&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;yname&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;zrr&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tbcHtba", propOrder = { "bz", "id", "jid", "jname", "qdsj", "subjectcodeId", "xybh", "xymc", "xyqx", "xyurl", "yid",
		"yname", "zrr" })
public class TbcHtba {

	protected String bz;
	protected Integer id;
	protected String jid;
	protected String jname;
	protected String qdsj;
	protected String subjectcodeId;
	protected String xybh;
	protected String xymc;
	protected String xyqx;
	protected String xyurl;
	protected String yid;
	protected String yname;
	protected String zrr;

	/**
	 * Gets the value of the bz property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBz() {
		return bz;
	}

	/**
	 * Sets the value of the bz property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBz(String value) {
		this.bz = value;
	}

	/**
	 * Gets the value of the id property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setId(Integer value) {
		this.id = value;
	}

	/**
	 * Gets the value of the jid property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getJid() {
		return jid;
	}

	/**
	 * Sets the value of the jid property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setJid(String value) {
		this.jid = value;
	}

	/**
	 * Gets the value of the jname property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getJname() {
		return jname;
	}

	/**
	 * Sets the value of the jname property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setJname(String value) {
		this.jname = value;
	}

	/**
	 * Gets the value of the qdsj property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getQdsj() {
		return qdsj;
	}

	/**
	 * Sets the value of the qdsj property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setQdsj(String value) {
		this.qdsj = value;
	}

	/**
	 * Gets the value of the subjectcodeId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSubjectcodeId() {
		return subjectcodeId;
	}

	/**
	 * Sets the value of the subjectcodeId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSubjectcodeId(String value) {
		this.subjectcodeId = value;
	}

	/**
	 * Gets the value of the xybh property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getXybh() {
		return xybh;
	}

	/**
	 * Sets the value of the xybh property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setXybh(String value) {
		this.xybh = value;
	}

	/**
	 * Gets the value of the xymc property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getXymc() {
		return xymc;
	}

	/**
	 * Sets the value of the xymc property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setXymc(String value) {
		this.xymc = value;
	}

	/**
	 * Gets the value of the xyqx property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getXyqx() {
		return xyqx;
	}

	/**
	 * Sets the value of the xyqx property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setXyqx(String value) {
		this.xyqx = value;
	}

	/**
	 * Gets the value of the xyurl property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getXyurl() {
		return xyurl;
	}

	/**
	 * Sets the value of the xyurl property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setXyurl(String value) {
		this.xyurl = value;
	}

	/**
	 * Gets the value of the yid property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getYid() {
		return yid;
	}

	/**
	 * Sets the value of the yid property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setYid(String value) {
		this.yid = value;
	}

	/**
	 * Gets the value of the yname property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getYname() {
		return yname;
	}

	/**
	 * Sets the value of the yname property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setYname(String value) {
		this.yname = value;
	}

	/**
	 * Gets the value of the zrr property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getZrr() {
		return zrr;
	}

	/**
	 * Sets the value of the zrr property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setZrr(String value) {
		this.zrr = value;
	}

}
