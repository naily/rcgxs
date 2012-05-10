package com.ghy.WSClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for fxMessage complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;fxMessage&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base=&quot;{http://webservice.ncplt.cci.org/}baseEntity&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;ID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Create_date&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;MType&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Mdeep&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;MYX&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;MProduct&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Macer&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;MESSFW&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Title&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Description&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fxMessage", propOrder = { "id", "createDate", "mType", "mdeep", "myx", "mProduct", "macer", "messfw", "title",
		"description" })
public class FxMessage extends BaseEntity {

	@XmlElement(name = "ID")
	protected Long id;
	@XmlElement(name = "Create_date")
	protected String createDate;
	@XmlElement(name = "MType")
	protected String mType;
	@XmlElement(name = "Mdeep")
	protected String mdeep;
	@XmlElement(name = "MYX")
	protected String myx;
	@XmlElement(name = "MProduct")
	protected String mProduct;
	@XmlElement(name = "Macer")
	protected String macer;
	@XmlElement(name = "MESSFW")
	protected String messfw;
	@XmlElement(name = "Title")
	protected String title;
	@XmlElement(name = "Description")
	protected String description;

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
	 * Gets the value of the createDate property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * Sets the value of the createDate property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCreateDate(String value) {
		this.createDate = value;
	}

	/**
	 * Gets the value of the mType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMType() {
		return mType;
	}

	/**
	 * Sets the value of the mType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMType(String value) {
		this.mType = value;
	}

	/**
	 * Gets the value of the mdeep property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMdeep() {
		return mdeep;
	}

	/**
	 * Sets the value of the mdeep property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMdeep(String value) {
		this.mdeep = value;
	}

	/**
	 * Gets the value of the myx property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMYX() {
		return myx;
	}

	/**
	 * Sets the value of the myx property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMYX(String value) {
		this.myx = value;
	}

	/**
	 * Gets the value of the mProduct property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMProduct() {
		return mProduct;
	}

	/**
	 * Sets the value of the mProduct property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMProduct(String value) {
		this.mProduct = value;
	}

	/**
	 * Gets the value of the macer property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMacer() {
		return macer;
	}

	/**
	 * Sets the value of the macer property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMacer(String value) {
		this.macer = value;
	}

	/**
	 * Gets the value of the messfw property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMESSFW() {
		return messfw;
	}

	/**
	 * Sets the value of the messfw property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMESSFW(String value) {
		this.messfw = value;
	}

	/**
	 * Gets the value of the title property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the value of the title property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTitle(String value) {
		this.title = value;
	}

	/**
	 * Gets the value of the description property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the value of the description property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDescription(String value) {
		this.description = value;
	}

}
