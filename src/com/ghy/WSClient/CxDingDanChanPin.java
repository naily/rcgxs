package com.ghy.WSClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for cxDingDanChanPin complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;cxDingDanChanPin&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base=&quot;{http://webservice.ncplt.cci.org/}baseEntity&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;ID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;CP_01&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;CP_02&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;CP_03&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}double&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;CP_04&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}double&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;CP_05&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}double&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;CP_06&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;CP_07&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;CP_08&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;CP_09&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cxDingDanChanPin", propOrder = { "id", "cp01", "cp02", "cp03", "cp04", "cp05", "cp06", "cp07", "cp08", "cp09" })
public class CxDingDanChanPin extends BaseEntity {

	@XmlElement(name = "ID")
	protected String id;
	@XmlElement(name = "CP_01")
	protected Long cp01;
	@XmlElement(name = "CP_02")
	protected String cp02;
	@XmlElement(name = "CP_03")
	protected Double cp03;
	@XmlElement(name = "CP_04")
	protected Double cp04;
	@XmlElement(name = "CP_05")
	protected Double cp05;
	@XmlElement(name = "CP_06")
	protected String cp06;
	@XmlElement(name = "CP_07")
	protected String cp07;
	@XmlElement(name = "CP_08")
	protected String cp08;
	@XmlElement(name = "CP_09")
	protected String cp09;

	/**
	 * Gets the value of the id property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getID() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setID(String value) {
		this.id = value;
	}

	/**
	 * Gets the value of the cp01 property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getCP01() {
		return cp01;
	}

	/**
	 * Sets the value of the cp01 property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setCP01(Long value) {
		this.cp01 = value;
	}

	/**
	 * Gets the value of the cp02 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCP02() {
		return cp02;
	}

	/**
	 * Sets the value of the cp02 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCP02(String value) {
		this.cp02 = value;
	}

	/**
	 * Gets the value of the cp03 property.
	 * 
	 * @return possible object is {@link Double }
	 * 
	 */
	public Double getCP03() {
		return cp03;
	}

	/**
	 * Sets the value of the cp03 property.
	 * 
	 * @param value
	 *            allowed object is {@link Double }
	 * 
	 */
	public void setCP03(Double value) {
		this.cp03 = value;
	}

	/**
	 * Gets the value of the cp04 property.
	 * 
	 * @return possible object is {@link Double }
	 * 
	 */
	public Double getCP04() {
		return cp04;
	}

	/**
	 * Sets the value of the cp04 property.
	 * 
	 * @param value
	 *            allowed object is {@link Double }
	 * 
	 */
	public void setCP04(Double value) {
		this.cp04 = value;
	}

	/**
	 * Gets the value of the cp05 property.
	 * 
	 * @return possible object is {@link Double }
	 * 
	 */
	public Double getCP05() {
		return cp05;
	}

	/**
	 * Sets the value of the cp05 property.
	 * 
	 * @param value
	 *            allowed object is {@link Double }
	 * 
	 */
	public void setCP05(Double value) {
		this.cp05 = value;
	}

	/**
	 * Gets the value of the cp06 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCP06() {
		return cp06;
	}

	/**
	 * Sets the value of the cp06 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCP06(String value) {
		this.cp06 = value;
	}

	/**
	 * Gets the value of the cp07 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCP07() {
		return cp07;
	}

	/**
	 * Sets the value of the cp07 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCP07(String value) {
		this.cp07 = value;
	}

	/**
	 * Gets the value of the cp08 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCP08() {
		return cp08;
	}

	/**
	 * Sets the value of the cp08 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCP08(String value) {
		this.cp08 = value;
	}

	/**
	 * Gets the value of the cp09 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCP09() {
		return cp09;
	}

	/**
	 * Sets the value of the cp09 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCP09(String value) {
		this.cp09 = value;
	}

}
