package com.ghy.WSClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for nongHuBaoFknr complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;nongHuBaoFknr&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base=&quot;{http://webservice.ncplt.cci.org/}baseEntity&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;ID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;FKNR&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;NHBXXR&quot; type=&quot;{http://webservice.ncplt.cci.org/}nongHuBaoXinXiReceive&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nongHuBaoFknr", propOrder = { "id", "fknr", "nhbxxr" })
public class NongHuBaoFknr extends BaseEntity {

	@XmlElement(name = "ID")
	protected Long id;
	@XmlElement(name = "FKNR")
	protected String fknr;
	@XmlElement(name = "NHBXXR")
	protected NongHuBaoXinXiReceive nhbxxr;

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
	 * Gets the value of the fknr property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFKNR() {
		return fknr;
	}

	/**
	 * Sets the value of the fknr property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFKNR(String value) {
		this.fknr = value;
	}

	/**
	 * Gets the value of the nhbxxr property.
	 * 
	 * @return possible object is {@link NongHuBaoXinXiReceive }
	 * 
	 */
	public NongHuBaoXinXiReceive getNHBXXR() {
		return nhbxxr;
	}

	/**
	 * Sets the value of the nhbxxr property.
	 * 
	 * @param value
	 *            allowed object is {@link NongHuBaoXinXiReceive }
	 * 
	 */
	public void setNHBXXR(NongHuBaoXinXiReceive value) {
		this.nhbxxr = value;
	}

}
