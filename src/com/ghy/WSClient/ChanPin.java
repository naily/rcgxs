package com.ghy.WSClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for chanPin complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;chanPin&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base=&quot;{http://webservice.ncplt.cci.org/}baseEntity&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;P_CLASS_ID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;P_CLASS_01&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;P_CLASS_02&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;P_CLASS_03&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "chanPin", propOrder = { "pclassid", "pclass01", "pclass02", "pclass03" })
public class ChanPin extends BaseEntity {

	@XmlElement(name = "P_CLASS_ID")
	protected Long pclassid;
	@XmlElement(name = "P_CLASS_01")
	protected Long pclass01;
	@XmlElement(name = "P_CLASS_02")
	protected String pclass02;
	@XmlElement(name = "P_CLASS_03")
	protected String pclass03;

	/**
	 * Gets the value of the pclassid property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getPCLASSID() {
		return pclassid;
	}

	/**
	 * Sets the value of the pclassid property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setPCLASSID(Long value) {
		this.pclassid = value;
	}

	/**
	 * Gets the value of the pclass01 property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getPCLASS01() {
		return pclass01;
	}

	/**
	 * Sets the value of the pclass01 property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setPCLASS01(Long value) {
		this.pclass01 = value;
	}

	/**
	 * Gets the value of the pclass02 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPCLASS02() {
		return pclass02;
	}

	/**
	 * Sets the value of the pclass02 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPCLASS02(String value) {
		this.pclass02 = value;
	}

	/**
	 * Gets the value of the pclass03 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPCLASS03() {
		return pclass03;
	}

	/**
	 * Sets the value of the pclass03 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPCLASS03(String value) {
		this.pclass03 = value;
	}

}
