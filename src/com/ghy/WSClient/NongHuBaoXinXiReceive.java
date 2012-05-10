package com.ghy.WSClient;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for nongHuBaoXinXiReceive complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;nongHuBaoXinXiReceive&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base=&quot;{http://webservice.ncplt.cci.org/}baseEntity&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;ID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;XXMC&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;XXNR&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;NHBM&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;NHBBH&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;HZSBM&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;FKNR&quot; type=&quot;{http://webservice.ncplt.cci.org/}nongHuBaoFknr&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;IMAGEDIR&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;INFOID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;FLAG&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nongHuBaoXinXiReceive", propOrder = { "id", "xxmc", "xxnr", "nhbm", "nhbbh", "hzsbm", "fknr", "imagedir", "infoid", "flag" })
public class NongHuBaoXinXiReceive extends BaseEntity {

	@XmlElement(name = "ID")
	protected Long id;
	@XmlElement(name = "XXMC")
	protected String xxmc;
	@XmlElement(name = "XXNR")
	protected String xxnr;
	@XmlElement(name = "NHBM")
	protected String nhbm;
	@XmlElement(name = "NHBBH")
	protected String nhbbh;
	@XmlElement(name = "HZSBM")
	protected String hzsbm;
	@XmlElement(name = "FKNR", nillable = true)
	protected List<NongHuBaoFknr> fknr;
	@XmlElement(name = "IMAGEDIR")
	protected String imagedir;
	@XmlElement(name = "INFOID")
	protected String infoid;
	@XmlElement(name = "FLAG")
	protected String flag;

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
	 * Gets the value of the nhbm property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNHBM() {
		return nhbm;
	}

	/**
	 * Sets the value of the nhbm property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNHBM(String value) {
		this.nhbm = value;
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

	/**
	 * Gets the value of the fknr property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the fknr property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getFKNR().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link NongHuBaoFknr }
	 * 
	 * 
	 */
	public List<NongHuBaoFknr> getFKNR() {
		if (fknr == null) {
			fknr = new ArrayList<NongHuBaoFknr>();
		}
		return this.fknr;
	}

	/**
	 * Gets the value of the imagedir property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getIMAGEDIR() {
		return imagedir;
	}

	/**
	 * Sets the value of the imagedir property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setIMAGEDIR(String value) {
		this.imagedir = value;
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
	 * Gets the value of the flag property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFLAG() {
		return flag;
	}

	/**
	 * Sets the value of the flag property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFLAG(String value) {
		this.flag = value;
	}

}
