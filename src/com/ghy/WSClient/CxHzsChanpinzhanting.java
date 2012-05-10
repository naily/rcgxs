package com.ghy.WSClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for cxHzsChanpinzhanting complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;cxHzsChanpinzhanting&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base=&quot;{http://webservice.ncplt.cci.org/}baseEntity&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;hzsPId&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;hzsP01&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;hzsP02&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;hzsP03&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot;/&gt;
 *         &lt;element name=&quot;hzsP04&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;hzsP05&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;hzsP06&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;hzsP07&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;hzsP08&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;hzsP09&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;hzsP10&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;hzsP11&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;hzsP12&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;hzsP13&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cxHzsChanpinzhanting", propOrder = { "hzsPId", "hzsP01", "hzsP02", "hzsP03", "hzsP04", "hzsP05", "hzsP06", "hzsP07",
		"hzsP08", "hzsP09", "hzsP10", "hzsP11", "hzsP12", "hzsP13" })
public class CxHzsChanpinzhanting extends BaseEntity {

	protected Long hzsPId;
	protected String hzsP01;
	protected String hzsP02;
	protected long hzsP03;
	protected String hzsP04;
	protected Long hzsP05;
	protected String hzsP06;
	protected String hzsP07;
	protected String hzsP08;
	protected String hzsP09;
	protected Long hzsP10;
	protected Long hzsP11;
	protected String hzsP12;
	protected String hzsP13;

	/**
	 * Gets the value of the hzsPId property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getHzsPId() {
		return hzsPId;
	}

	/**
	 * Sets the value of the hzsPId property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setHzsPId(Long value) {
		this.hzsPId = value;
	}

	/**
	 * Gets the value of the hzsP01 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHzsP01() {
		return hzsP01;
	}

	/**
	 * Sets the value of the hzsP01 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHzsP01(String value) {
		this.hzsP01 = value;
	}

	/**
	 * Gets the value of the hzsP02 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHzsP02() {
		return hzsP02;
	}

	/**
	 * Sets the value of the hzsP02 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHzsP02(String value) {
		this.hzsP02 = value;
	}

	/**
	 * Gets the value of the hzsP03 property.
	 * 
	 */
	public long getHzsP03() {
		return hzsP03;
	}

	/**
	 * Sets the value of the hzsP03 property.
	 * 
	 */
	public void setHzsP03(long value) {
		this.hzsP03 = value;
	}

	/**
	 * Gets the value of the hzsP04 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHzsP04() {
		return hzsP04;
	}

	/**
	 * Sets the value of the hzsP04 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHzsP04(String value) {
		this.hzsP04 = value;
	}

	/**
	 * Gets the value of the hzsP05 property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getHzsP05() {
		return hzsP05;
	}

	/**
	 * Sets the value of the hzsP05 property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setHzsP05(Long value) {
		this.hzsP05 = value;
	}

	/**
	 * Gets the value of the hzsP06 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHzsP06() {
		return hzsP06;
	}

	/**
	 * Sets the value of the hzsP06 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHzsP06(String value) {
		this.hzsP06 = value;
	}

	/**
	 * Gets the value of the hzsP07 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHzsP07() {
		return hzsP07;
	}

	/**
	 * Sets the value of the hzsP07 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHzsP07(String value) {
		this.hzsP07 = value;
	}

	/**
	 * Gets the value of the hzsP08 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHzsP08() {
		return hzsP08;
	}

	/**
	 * Sets the value of the hzsP08 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHzsP08(String value) {
		this.hzsP08 = value;
	}

	/**
	 * Gets the value of the hzsP09 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHzsP09() {
		return hzsP09;
	}

	/**
	 * Sets the value of the hzsP09 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHzsP09(String value) {
		this.hzsP09 = value;
	}

	/**
	 * Gets the value of the hzsP10 property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getHzsP10() {
		return hzsP10;
	}

	/**
	 * Sets the value of the hzsP10 property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setHzsP10(Long value) {
		this.hzsP10 = value;
	}

	/**
	 * Gets the value of the hzsP11 property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getHzsP11() {
		return hzsP11;
	}

	/**
	 * Sets the value of the hzsP11 property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setHzsP11(Long value) {
		this.hzsP11 = value;
	}

	/**
	 * Gets the value of the hzsP12 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHzsP12() {
		return hzsP12;
	}

	/**
	 * Sets the value of the hzsP12 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHzsP12(String value) {
		this.hzsP12 = value;
	}

	/**
	 * Gets the value of the hzsP13 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHzsP13() {
		return hzsP13;
	}

	/**
	 * Sets the value of the hzsP13 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHzsP13(String value) {
		this.hzsP13 = value;
	}

}
