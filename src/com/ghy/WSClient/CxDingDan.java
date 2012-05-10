package com.ghy.WSClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for cxDingDan complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;cxDingDan&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base=&quot;{http://webservice.ncplt.cci.org/}baseEntity&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;ORDER_01&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;ORDER_02&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;ORDER_03&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;ORDER_04&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;ORDER_05&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;ORDER_06&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;ORDER_07&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;ORDER_08&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;ORDER_09&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;ORDER_10&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;ORDER_11&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;ORDER_12&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;ORDER_13&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;ORDER_14&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;ORDER_15&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;ORDER_16&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;ORDER_17&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;ORDER_18&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;ORDER_19&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;ORDER_20&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;ORDER_21&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;ORDER_22&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;ORDER_23&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}int&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;DUIJIEHUI&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cxDingDan", propOrder = { "order01", "order02", "order03", "order04", "order05", "order06", "order07", "order08",
		"order09", "order10", "order11", "order12", "order13", "order14", "order15", "order16", "order17", "order18", "order19", "order20",
		"order21", "order22", "order23", "duijiehui" })
public class CxDingDan extends BaseEntity {

	@XmlElement(name = "ORDER_01")
	protected String order01;
	@XmlElement(name = "ORDER_02")
	protected String order02;
	@XmlElement(name = "ORDER_03")
	protected String order03;
	@XmlElement(name = "ORDER_04")
	protected String order04;
	@XmlElement(name = "ORDER_05")
	protected String order05;
	@XmlElement(name = "ORDER_06")
	protected String order06;
	@XmlElement(name = "ORDER_07")
	protected String order07;
	@XmlElement(name = "ORDER_08")
	protected String order08;
	@XmlElement(name = "ORDER_09")
	protected String order09;
	@XmlElement(name = "ORDER_10")
	protected String order10;
	@XmlElement(name = "ORDER_11")
	protected String order11;
	@XmlElement(name = "ORDER_12")
	protected String order12;
	@XmlElement(name = "ORDER_13")
	protected String order13;
	@XmlElement(name = "ORDER_14")
	protected String order14;
	@XmlElement(name = "ORDER_15")
	protected String order15;
	@XmlElement(name = "ORDER_16")
	protected String order16;
	@XmlElement(name = "ORDER_17")
	protected String order17;
	@XmlElement(name = "ORDER_18")
	protected String order18;
	@XmlElement(name = "ORDER_19")
	protected String order19;
	@XmlElement(name = "ORDER_20")
	protected String order20;
	@XmlElement(name = "ORDER_21")
	protected String order21;
	@XmlElement(name = "ORDER_22")
	protected String order22;
	@XmlElement(name = "ORDER_23")
	protected Integer order23;
	@XmlElement(name = "DUIJIEHUI")
	protected Long duijiehui;

	/**
	 * Gets the value of the order01 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getORDER01() {
		return order01;
	}

	/**
	 * Sets the value of the order01 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setORDER01(String value) {
		this.order01 = value;
	}

	/**
	 * Gets the value of the order02 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getORDER02() {
		return order02;
	}

	/**
	 * Sets the value of the order02 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setORDER02(String value) {
		this.order02 = value;
	}

	/**
	 * Gets the value of the order03 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getORDER03() {
		return order03;
	}

	/**
	 * Sets the value of the order03 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setORDER03(String value) {
		this.order03 = value;
	}

	/**
	 * Gets the value of the order04 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getORDER04() {
		return order04;
	}

	/**
	 * Sets the value of the order04 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setORDER04(String value) {
		this.order04 = value;
	}

	/**
	 * Gets the value of the order05 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getORDER05() {
		return order05;
	}

	/**
	 * Sets the value of the order05 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setORDER05(String value) {
		this.order05 = value;
	}

	/**
	 * Gets the value of the order06 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getORDER06() {
		return order06;
	}

	/**
	 * Sets the value of the order06 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setORDER06(String value) {
		this.order06 = value;
	}

	/**
	 * Gets the value of the order07 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getORDER07() {
		return order07;
	}

	/**
	 * Sets the value of the order07 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setORDER07(String value) {
		this.order07 = value;
	}

	/**
	 * Gets the value of the order08 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getORDER08() {
		return order08;
	}

	/**
	 * Sets the value of the order08 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setORDER08(String value) {
		this.order08 = value;
	}

	/**
	 * Gets the value of the order09 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getORDER09() {
		return order09;
	}

	/**
	 * Sets the value of the order09 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setORDER09(String value) {
		this.order09 = value;
	}

	/**
	 * Gets the value of the order10 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getORDER10() {
		return order10;
	}

	/**
	 * Sets the value of the order10 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setORDER10(String value) {
		this.order10 = value;
	}

	/**
	 * Gets the value of the order11 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getORDER11() {
		return order11;
	}

	/**
	 * Sets the value of the order11 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setORDER11(String value) {
		this.order11 = value;
	}

	/**
	 * Gets the value of the order12 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getORDER12() {
		return order12;
	}

	/**
	 * Sets the value of the order12 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setORDER12(String value) {
		this.order12 = value;
	}

	/**
	 * Gets the value of the order13 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getORDER13() {
		return order13;
	}

	/**
	 * Sets the value of the order13 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setORDER13(String value) {
		this.order13 = value;
	}

	/**
	 * Gets the value of the order14 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getORDER14() {
		return order14;
	}

	/**
	 * Sets the value of the order14 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setORDER14(String value) {
		this.order14 = value;
	}

	/**
	 * Gets the value of the order15 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getORDER15() {
		return order15;
	}

	/**
	 * Sets the value of the order15 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setORDER15(String value) {
		this.order15 = value;
	}

	/**
	 * Gets the value of the order16 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getORDER16() {
		return order16;
	}

	/**
	 * Sets the value of the order16 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setORDER16(String value) {
		this.order16 = value;
	}

	/**
	 * Gets the value of the order17 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getORDER17() {
		return order17;
	}

	/**
	 * Sets the value of the order17 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setORDER17(String value) {
		this.order17 = value;
	}

	/**
	 * Gets the value of the order18 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getORDER18() {
		return order18;
	}

	/**
	 * Sets the value of the order18 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setORDER18(String value) {
		this.order18 = value;
	}

	/**
	 * Gets the value of the order19 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getORDER19() {
		return order19;
	}

	/**
	 * Sets the value of the order19 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setORDER19(String value) {
		this.order19 = value;
	}

	/**
	 * Gets the value of the order20 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getORDER20() {
		return order20;
	}

	/**
	 * Sets the value of the order20 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setORDER20(String value) {
		this.order20 = value;
	}

	/**
	 * Gets the value of the order21 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getORDER21() {
		return order21;
	}

	/**
	 * Sets the value of the order21 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setORDER21(String value) {
		this.order21 = value;
	}

	/**
	 * Gets the value of the order22 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getORDER22() {
		return order22;
	}

	/**
	 * Sets the value of the order22 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setORDER22(String value) {
		this.order22 = value;
	}

	/**
	 * Gets the value of the order23 property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getORDER23() {
		return order23;
	}

	/**
	 * Sets the value of the order23 property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setORDER23(Integer value) {
		this.order23 = value;
	}

	/**
	 * Gets the value of the duijiehui property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getDUIJIEHUI() {
		return duijiehui;
	}

	/**
	 * Sets the value of the duijiehui property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setDUIJIEHUI(Long value) {
		this.duijiehui = value;
	}

}
