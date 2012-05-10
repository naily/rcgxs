package com.ghy.WSClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for baoMingHuiZong complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;baoMingHuiZong&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base=&quot;{http://webservice.ncplt.cci.org/}baseEntity&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;ID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;FSC_NAME&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;QYLX&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;DQID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Main_product&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;JHLYL&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}double&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Lxr&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Tel&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;JYH_Name&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "baoMingHuiZong", propOrder = { "id", "fscname", "qylx", "dqid", "mainProduct", "jhlyl", "lxr", "tel", "jyhName" })
public class BaoMingHuiZong extends BaseEntity {

	@XmlElement(name = "ID")
	protected Long id;
	@XmlElement(name = "FSC_NAME")
	protected String fscname;
	@XmlElement(name = "QYLX")
	protected String qylx;
	@XmlElement(name = "DQID")
	protected Long dqid;
	@XmlElement(name = "Main_product")
	protected String mainProduct;
	@XmlElement(name = "JHLYL")
	protected Double jhlyl;
	@XmlElement(name = "Lxr")
	protected String lxr;
	@XmlElement(name = "Tel")
	protected String tel;
	@XmlElement(name = "JYH_Name")
	protected String jyhName;

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
	 * Gets the value of the fscname property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFSCNAME() {
		return fscname;
	}

	/**
	 * Sets the value of the fscname property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFSCNAME(String value) {
		this.fscname = value;
	}

	/**
	 * Gets the value of the qylx property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getQYLX() {
		return qylx;
	}

	/**
	 * Sets the value of the qylx property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setQYLX(String value) {
		this.qylx = value;
	}

	/**
	 * Gets the value of the dqid property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getDQID() {
		return dqid;
	}

	/**
	 * Sets the value of the dqid property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setDQID(Long value) {
		this.dqid = value;
	}

	/**
	 * Gets the value of the mainProduct property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMainProduct() {
		return mainProduct;
	}

	/**
	 * Sets the value of the mainProduct property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMainProduct(String value) {
		this.mainProduct = value;
	}

	/**
	 * Gets the value of the jhlyl property.
	 * 
	 * @return possible object is {@link Double }
	 * 
	 */
	public Double getJHLYL() {
		return jhlyl;
	}

	/**
	 * Sets the value of the jhlyl property.
	 * 
	 * @param value
	 *            allowed object is {@link Double }
	 * 
	 */
	public void setJHLYL(Double value) {
		this.jhlyl = value;
	}

	/**
	 * Gets the value of the lxr property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLxr() {
		return lxr;
	}

	/**
	 * Sets the value of the lxr property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLxr(String value) {
		this.lxr = value;
	}

	/**
	 * Gets the value of the tel property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * Sets the value of the tel property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTel(String value) {
		this.tel = value;
	}

	/**
	 * Gets the value of the jyhName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getJYHName() {
		return jyhName;
	}

	/**
	 * Sets the value of the jyhName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setJYHName(String value) {
		this.jyhName = value;
	}

}
