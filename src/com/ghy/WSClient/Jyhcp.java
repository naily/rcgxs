package com.ghy.WSClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for jyhcp complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;jyhcp&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;jyMoney&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}double&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;jyzl&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}double&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;mainProduct&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jyhcp", propOrder = { "jyMoney", "jyzl", "mainProduct" })
public class Jyhcp {

	protected Double jyMoney;
	protected Double jyzl;
	protected String mainProduct;

	/**
	 * Gets the value of the jyMoney property.
	 * 
	 * @return possible object is {@link Double }
	 * 
	 */
	public Double getJyMoney() {
		return jyMoney;
	}

	/**
	 * Sets the value of the jyMoney property.
	 * 
	 * @param value
	 *            allowed object is {@link Double }
	 * 
	 */
	public void setJyMoney(Double value) {
		this.jyMoney = value;
	}

	/**
	 * Gets the value of the jyzl property.
	 * 
	 * @return possible object is {@link Double }
	 * 
	 */
	public Double getJyzl() {
		return jyzl;
	}

	/**
	 * Sets the value of the jyzl property.
	 * 
	 * @param value
	 *            allowed object is {@link Double }
	 * 
	 */
	public void setJyzl(Double value) {
		this.jyzl = value;
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

}
