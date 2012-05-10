package com.ghy.WSClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for qgxx complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;qgxx&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;INFO_ID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;INFO_03&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;INFO_04&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}double&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;INFO_05&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}double&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;INFO_06&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;INFO_07&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;INFO_08&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;INFO_09&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;INFO_10&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;INFO_11&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;INFO_12&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;INFO_13&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;INFO_14&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;INFO_15&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;INFO_18&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;INFO_19&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;INFO_20&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;INFO_21&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;INFO_22&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
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
@XmlType(name = "qgxx", propOrder = { "infoid", "info03", "info04", "info05", "info06", "info07", "info08", "info09", "info10", "info11",
		"info12", "info13", "info14", "info15", "info18", "info19", "info20", "info21", "info22", "subjectcodeid", "systemid" })
public class Qgxx {

	@XmlElement(name = "INFO_ID")
	protected Long infoid;
	@XmlElement(name = "INFO_03")
	protected String info03;
	@XmlElement(name = "INFO_04")
	protected Double info04;
	@XmlElement(name = "INFO_05")
	protected Double info05;
	@XmlElement(name = "INFO_06")
	protected String info06;
	@XmlElement(name = "INFO_07")
	protected String info07;
	@XmlElement(name = "INFO_08")
	protected String info08;
	@XmlElement(name = "INFO_09")
	protected String info09;
	@XmlElement(name = "INFO_10")
	protected String info10;
	@XmlElement(name = "INFO_11")
	protected String info11;
	@XmlElement(name = "INFO_12")
	protected String info12;
	@XmlElement(name = "INFO_13")
	protected String info13;
	@XmlElement(name = "INFO_14")
	protected String info14;
	@XmlElement(name = "INFO_15")
	protected String info15;
	@XmlElement(name = "INFO_18")
	protected String info18;
	@XmlElement(name = "INFO_19")
	protected String info19;
	@XmlElement(name = "INFO_20")
	protected String info20;
	@XmlElement(name = "INFO_21")
	protected String info21;
	@XmlElement(name = "INFO_22")
	protected String info22;
	@XmlElement(name = "SUBJECTCODEID")
	protected String subjectcodeid;
	@XmlElement(name = "SYSTEMID")
	protected Long systemid;

	/**
	 * Gets the value of the infoid property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getINFOID() {
		return infoid;
	}

	/**
	 * Sets the value of the infoid property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setINFOID(Long value) {
		this.infoid = value;
	}

	/**
	 * Gets the value of the info03 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getINFO03() {
		return info03;
	}

	/**
	 * Sets the value of the info03 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setINFO03(String value) {
		this.info03 = value;
	}

	/**
	 * Gets the value of the info04 property.
	 * 
	 * @return possible object is {@link Double }
	 * 
	 */
	public Double getINFO04() {
		return info04;
	}

	/**
	 * Sets the value of the info04 property.
	 * 
	 * @param value
	 *            allowed object is {@link Double }
	 * 
	 */
	public void setINFO04(Double value) {
		this.info04 = value;
	}

	/**
	 * Gets the value of the info05 property.
	 * 
	 * @return possible object is {@link Double }
	 * 
	 */
	public Double getINFO05() {
		return info05;
	}

	/**
	 * Sets the value of the info05 property.
	 * 
	 * @param value
	 *            allowed object is {@link Double }
	 * 
	 */
	public void setINFO05(Double value) {
		this.info05 = value;
	}

	/**
	 * Gets the value of the info06 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getINFO06() {
		return info06;
	}

	/**
	 * Sets the value of the info06 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setINFO06(String value) {
		this.info06 = value;
	}

	/**
	 * Gets the value of the info07 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getINFO07() {
		return info07;
	}

	/**
	 * Sets the value of the info07 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setINFO07(String value) {
		this.info07 = value;
	}

	/**
	 * Gets the value of the info08 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getINFO08() {
		return info08;
	}

	/**
	 * Sets the value of the info08 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setINFO08(String value) {
		this.info08 = value;
	}

	/**
	 * Gets the value of the info09 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getINFO09() {
		return info09;
	}

	/**
	 * Sets the value of the info09 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setINFO09(String value) {
		this.info09 = value;
	}

	/**
	 * Gets the value of the info10 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getINFO10() {
		return info10;
	}

	/**
	 * Sets the value of the info10 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setINFO10(String value) {
		this.info10 = value;
	}

	/**
	 * Gets the value of the info11 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getINFO11() {
		return info11;
	}

	/**
	 * Sets the value of the info11 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setINFO11(String value) {
		this.info11 = value;
	}

	/**
	 * Gets the value of the info12 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getINFO12() {
		return info12;
	}

	/**
	 * Sets the value of the info12 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setINFO12(String value) {
		this.info12 = value;
	}

	/**
	 * Gets the value of the info13 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getINFO13() {
		return info13;
	}

	/**
	 * Sets the value of the info13 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setINFO13(String value) {
		this.info13 = value;
	}

	/**
	 * Gets the value of the info14 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getINFO14() {
		return info14;
	}

	/**
	 * Sets the value of the info14 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setINFO14(String value) {
		this.info14 = value;
	}

	/**
	 * Gets the value of the info15 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getINFO15() {
		return info15;
	}

	/**
	 * Sets the value of the info15 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setINFO15(String value) {
		this.info15 = value;
	}

	/**
	 * Gets the value of the info18 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getINFO18() {
		return info18;
	}

	/**
	 * Sets the value of the info18 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setINFO18(String value) {
		this.info18 = value;
	}

	/**
	 * Gets the value of the info19 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getINFO19() {
		return info19;
	}

	/**
	 * Sets the value of the info19 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setINFO19(String value) {
		this.info19 = value;
	}

	/**
	 * Gets the value of the info20 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getINFO20() {
		return info20;
	}

	/**
	 * Sets the value of the info20 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setINFO20(String value) {
		this.info20 = value;
	}

	/**
	 * Gets the value of the info21 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getINFO21() {
		return info21;
	}

	/**
	 * Sets the value of the info21 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setINFO21(String value) {
		this.info21 = value;
	}

	/**
	 * Gets the value of the info22 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getINFO22() {
		return info22;
	}

	/**
	 * Sets the value of the info22 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setINFO22(String value) {
		this.info22 = value;
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
