package com.ghy.WSClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ggxx complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;ggxx&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;FBID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;HZSBM&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;ZZPZBM&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}int&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;ZZPZMC&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Imgurl&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;GGMS&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;DJ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;JG&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}double&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;SL&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}double&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;PP&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;YJSCSJ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;SFRZ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}int&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Rzmc&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Rztp&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;LXR&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;LXDH&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;FAX&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;YFB&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}int&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;type&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}int&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;FBRQ&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
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
@XmlType(name = "ggxx", propOrder = { "fbid", "hzsbm", "zzpzbm", "zzpzmc", "imgurl", "ggms", "dj", "jg", "sl", "pp", "yjscsj", "sfrz",
		"rzmc", "rztp", "lxr", "lxdh", "fax", "yfb", "type", "fbrq", "subjectcodeid", "systemid" })
public class Ggxx {

	@XmlElement(name = "FBID")
	protected Long fbid;
	@XmlElement(name = "HZSBM")
	protected String hzsbm;
	@XmlElement(name = "ZZPZBM")
	protected Integer zzpzbm;
	@XmlElement(name = "ZZPZMC")
	protected String zzpzmc;
	@XmlElement(name = "Imgurl")
	protected String imgurl;
	@XmlElement(name = "GGMS")
	protected String ggms;
	@XmlElement(name = "DJ")
	protected String dj;
	@XmlElement(name = "JG")
	protected Double jg;
	@XmlElement(name = "SL")
	protected Double sl;
	@XmlElement(name = "PP")
	protected String pp;
	@XmlElement(name = "YJSCSJ")
	protected String yjscsj;
	@XmlElement(name = "SFRZ")
	protected Integer sfrz;
	@XmlElement(name = "Rzmc")
	protected String rzmc;
	@XmlElement(name = "Rztp")
	protected String rztp;
	@XmlElement(name = "LXR")
	protected String lxr;
	@XmlElement(name = "LXDH")
	protected String lxdh;
	@XmlElement(name = "FAX")
	protected String fax;
	@XmlElement(name = "YFB")
	protected Integer yfb;
	protected Integer type;
	@XmlElement(name = "FBRQ")
	protected String fbrq;
	@XmlElement(name = "SUBJECTCODEID")
	protected String subjectcodeid;
	@XmlElement(name = "SYSTEMID")
	protected Long systemid;

	/**
	 * Gets the value of the fbid property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getFBID() {
		return fbid;
	}

	/**
	 * Sets the value of the fbid property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setFBID(Long value) {
		this.fbid = value;
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
	 * Gets the value of the zzpzbm property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getZZPZBM() {
		return zzpzbm;
	}

	/**
	 * Sets the value of the zzpzbm property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setZZPZBM(Integer value) {
		this.zzpzbm = value;
	}

	/**
	 * Gets the value of the zzpzmc property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getZZPZMC() {
		return zzpzmc;
	}

	/**
	 * Sets the value of the zzpzmc property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setZZPZMC(String value) {
		this.zzpzmc = value;
	}

	/**
	 * Gets the value of the imgurl property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getImgurl() {
		return imgurl;
	}

	/**
	 * Sets the value of the imgurl property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setImgurl(String value) {
		this.imgurl = value;
	}

	/**
	 * Gets the value of the ggms property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getGGMS() {
		return ggms;
	}

	/**
	 * Sets the value of the ggms property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setGGMS(String value) {
		this.ggms = value;
	}

	/**
	 * Gets the value of the dj property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDJ() {
		return dj;
	}

	/**
	 * Sets the value of the dj property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDJ(String value) {
		this.dj = value;
	}

	/**
	 * Gets the value of the jg property.
	 * 
	 * @return possible object is {@link Double }
	 * 
	 */
	public Double getJG() {
		return jg;
	}

	/**
	 * Sets the value of the jg property.
	 * 
	 * @param value
	 *            allowed object is {@link Double }
	 * 
	 */
	public void setJG(Double value) {
		this.jg = value;
	}

	/**
	 * Gets the value of the sl property.
	 * 
	 * @return possible object is {@link Double }
	 * 
	 */
	public Double getSL() {
		return sl;
	}

	/**
	 * Sets the value of the sl property.
	 * 
	 * @param value
	 *            allowed object is {@link Double }
	 * 
	 */
	public void setSL(Double value) {
		this.sl = value;
	}

	/**
	 * Gets the value of the pp property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPP() {
		return pp;
	}

	/**
	 * Sets the value of the pp property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPP(String value) {
		this.pp = value;
	}

	/**
	 * Gets the value of the yjscsj property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getYJSCSJ() {
		return yjscsj;
	}

	/**
	 * Sets the value of the yjscsj property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setYJSCSJ(String value) {
		this.yjscsj = value;
	}

	/**
	 * Gets the value of the sfrz property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getSFRZ() {
		return sfrz;
	}

	/**
	 * Sets the value of the sfrz property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setSFRZ(Integer value) {
		this.sfrz = value;
	}

	/**
	 * Gets the value of the rzmc property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRzmc() {
		return rzmc;
	}

	/**
	 * Sets the value of the rzmc property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRzmc(String value) {
		this.rzmc = value;
	}

	/**
	 * Gets the value of the rztp property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRztp() {
		return rztp;
	}

	/**
	 * Sets the value of the rztp property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRztp(String value) {
		this.rztp = value;
	}

	/**
	 * Gets the value of the lxr property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLXR() {
		return lxr;
	}

	/**
	 * Sets the value of the lxr property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLXR(String value) {
		this.lxr = value;
	}

	/**
	 * Gets the value of the lxdh property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLXDH() {
		return lxdh;
	}

	/**
	 * Sets the value of the lxdh property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLXDH(String value) {
		this.lxdh = value;
	}

	/**
	 * Gets the value of the fax property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFAX() {
		return fax;
	}

	/**
	 * Sets the value of the fax property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFAX(String value) {
		this.fax = value;
	}

	/**
	 * Gets the value of the yfb property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getYFB() {
		return yfb;
	}

	/**
	 * Sets the value of the yfb property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setYFB(Integer value) {
		this.yfb = value;
	}

	/**
	 * Gets the value of the type property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * Sets the value of the type property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setType(Integer value) {
		this.type = value;
	}

	/**
	 * Gets the value of the fbrq property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFBRQ() {
		return fbrq;
	}

	/**
	 * Sets the value of the fbrq property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFBRQ(String value) {
		this.fbrq = value;
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
