package com.ghy.WSClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for nongHuBaoXinxiSend complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;nongHuBaoXinxiSend&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base=&quot;{http://webservice.ncplt.cci.org/}baseEntity&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;ID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;XXLX&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;XXNR&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;NHBBH&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;XXMC&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;INFOID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;HZSBM&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nongHuBaoXinxiSend", propOrder = { "id", "xxlx", "xxnr", "nhbbh", "xxmc", "infoid", "hzsbm" })
public class NongHuBaoXinxiSend extends BaseEntity {

	@XmlElement(name = "ID")
	protected Long id;
	@XmlElement(name = "XXLX")
	protected String xxlx;
	@XmlElement(name = "XXNR")
	protected String xxnr;
	@XmlElement(name = "NHBBH")
	protected String nhbbh;
	@XmlElement(name = "XXMC")
	protected String xxmc;
	@XmlElement(name = "INFOID")
	protected String infoid;
	@XmlElement(name = "HZSBM")
	protected String hzsbm;

	/**
	 * Gets the value of the id property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getID() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setID(Long value) {
		this.id = value;
	}

	/**
	 * Gets the value of the xxlx property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getXXLX() {
		return xxlx;
	}

	/**
	 * Sets the value of the xxlx property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setXXLX(String value) {
		this.xxlx = value;
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
	 * Gets the value of the nhbbh property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNHBBH() {
		return nhbbh;
	}

	/**
	 * Sets the value of the nhbbh property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNHBBH(String value) {
		this.nhbbh = value;
	}

	/**
	 * Gets the value of the xxmc property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getXXMC() {
		return xxmc;
	}

	/**
	 * Sets the value of the xxmc property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setXXMC(String value) {
		this.xxmc = value;
	}

	/**
	 * Gets the value of the infoid property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getINFOID() {
		return infoid;
	}

	/**
	 * Sets the value of the infoid property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setINFOID(String value) {
		this.infoid = value;
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

}
