package com.ghy.WSClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for registerRes complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;registerRes&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;result&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}int&quot;/&gt;
 *         &lt;element name=&quot;subjectCode&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "registerRes", propOrder = { "result", "subjectCode" })
public class RegisterRes {

	protected int result;
	protected String subjectCode;

	/**
	 * Gets the value of the result property.
	 * 
	 */
	public int getResult() {
		return result;
	}

	/**
	 * Sets the value of the result property.
	 * 
	 */
	public void setResult(int value) {
		this.result = value;
	}

	/**
	 * Gets the value of the subjectCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSubjectCode() {
		return subjectCode;
	}

	/**
	 * Sets the value of the subjectCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSubjectCode(String value) {
		this.subjectCode = value;
	}

}
