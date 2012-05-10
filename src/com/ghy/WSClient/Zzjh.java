package com.ghy.WSClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for zzjh complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;zzjh&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;ZZJHID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;HZSBM&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;DKBM&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;ZWMC&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;ZZMJ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;BZSJ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;SHSJ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;YJCL&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;ZLMS&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;CCSJ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;CCTJ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;TJ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;SFDD&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;DD&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
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
@XmlType(name = "zzjh", propOrder = { "zzjhid", "hzsbm", "dkbm", "zwmc", "zzmj", "bzsj", "shsj", "yjcl", "zlms", "ccsj", "cctj", "tj",
		"sfdd", "dd", "subjectcodeid", "systemid" })
public class Zzjh {

	@XmlElement(name = "ZZJHID")
	protected Long zzjhid;
	@XmlElement(name = "HZSBM")
	protected String hzsbm;
	@XmlElement(name = "DKBM")
	protected String dkbm;
	@XmlElement(name = "ZWMC")
	protected String zwmc;
	@XmlElement(name = "ZZMJ")
	protected String zzmj;
	@XmlElement(name = "BZSJ")
	protected String bzsj;
	@XmlElement(name = "SHSJ")
	protected String shsj;
	@XmlElement(name = "YJCL")
	protected String yjcl;
	@XmlElement(name = "ZLMS")
	protected String zlms;
	@XmlElement(name = "CCSJ")
	protected String ccsj;
	@XmlElement(name = "CCTJ")
	protected String cctj;
	@XmlElement(name = "TJ")
	protected String tj;
	@XmlElement(name = "SFDD")
	protected String sfdd;
	@XmlElement(name = "DD")
	protected String dd;
	@XmlElement(name = "SUBJECTCODEID")
	protected String subjectcodeid;
	@XmlElement(name = "SYSTEMID")
	protected Long systemid;

	/**
	 * Gets the value of the zzjhid property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getZZJHID() {
		return zzjhid;
	}

	/**
	 * Sets the value of the zzjhid property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setZZJHID(Long value) {
		this.zzjhid = value;
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
	 * Gets the value of the dkbm property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDKBM() {
		return dkbm;
	}

	/**
	 * Sets the value of the dkbm property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDKBM(String value) {
		this.dkbm = value;
	}

	/**
	 * Gets the value of the zwmc property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getZWMC() {
		return zwmc;
	}

	/**
	 * Sets the value of the zwmc property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setZWMC(String value) {
		this.zwmc = value;
	}

	/**
	 * Gets the value of the zzmj property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getZZMJ() {
		return zzmj;
	}

	/**
	 * Sets the value of the zzmj property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setZZMJ(String value) {
		this.zzmj = value;
	}

	/**
	 * Gets the value of the bzsj property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBZSJ() {
		return bzsj;
	}

	/**
	 * Sets the value of the bzsj property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBZSJ(String value) {
		this.bzsj = value;
	}

	/**
	 * Gets the value of the shsj property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSHSJ() {
		return shsj;
	}

	/**
	 * Sets the value of the shsj property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSHSJ(String value) {
		this.shsj = value;
	}

	/**
	 * Gets the value of the yjcl property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getYJCL() {
		return yjcl;
	}

	/**
	 * Sets the value of the yjcl property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setYJCL(String value) {
		this.yjcl = value;
	}

	/**
	 * Gets the value of the zlms property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getZLMS() {
		return zlms;
	}

	/**
	 * Sets the value of the zlms property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setZLMS(String value) {
		this.zlms = value;
	}

	/**
	 * Gets the value of the ccsj property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCCSJ() {
		return ccsj;
	}

	/**
	 * Sets the value of the ccsj property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCCSJ(String value) {
		this.ccsj = value;
	}

	/**
	 * Gets the value of the cctj property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCCTJ() {
		return cctj;
	}

	/**
	 * Sets the value of the cctj property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCCTJ(String value) {
		this.cctj = value;
	}

	/**
	 * Gets the value of the tj property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTJ() {
		return tj;
	}

	/**
	 * Sets the value of the tj property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTJ(String value) {
		this.tj = value;
	}

	/**
	 * Gets the value of the sfdd property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSFDD() {
		return sfdd;
	}

	/**
	 * Sets the value of the sfdd property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSFDD(String value) {
		this.sfdd = value;
	}

	/**
	 * Gets the value of the dd property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDD() {
		return dd;
	}

	/**
	 * Sets the value of the dd property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDD(String value) {
		this.dd = value;
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
