package com.ghy.WSClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for userInfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;userInfo&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;Username&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;Password&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;SubjectCode&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;UserDetail&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Field1&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Field2&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Field3&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userInfo", propOrder = { "username", "password", "subjectCode", "userDetail", "field1", "field2", "field3" })
public class UserInfo {

	@XmlElement(name = "Username", required = true)
	protected String username;
	@XmlElement(name = "Password", required = true)
	protected String password;
	@XmlElement(name = "SubjectCode", required = true)
	protected String subjectCode;
	@XmlElement(name = "UserDetail")
	protected String userDetail;
	@XmlElement(name = "Field1")
	protected String field1;
	@XmlElement(name = "Field2")
	protected String field2;
	@XmlElement(name = "Field3")
	protected String field3;

	/**
	 * Gets the value of the username property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the value of the username property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUsername(String value) {
		this.username = value;
	}

	/**
	 * Gets the value of the password property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the value of the password property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPassword(String value) {
		this.password = value;
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

	/**
	 * Gets the value of the userDetail property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUserDetail() {
		return userDetail;
	}

	/**
	 * Sets the value of the userDetail property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUserDetail(String value) {
		this.userDetail = value;
	}

	/**
	 * Gets the value of the field1 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getField1() {
		return field1;
	}

	/**
	 * Sets the value of the field1 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setField1(String value) {
		this.field1 = value;
	}

	/**
	 * Gets the value of the field2 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getField2() {
		return field2;
	}

	/**
	 * Sets the value of the field2 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setField2(String value) {
		this.field2 = value;
	}

	/**
	 * Gets the value of the field3 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getField3() {
		return field3;
	}

	/**
	 * Sets the value of the field3 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setField3(String value) {
		this.field3 = value;
	}

}
