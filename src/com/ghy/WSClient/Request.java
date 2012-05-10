package com.ghy.WSClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Request complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;Request&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;UserInfo&quot; type=&quot;{http://webservice.ncplt.cci.org/}userInfo&quot;/&gt;
 *         &lt;element name=&quot;FunctionName&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;ModelName&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;Save&quot; type=&quot;{http://webservice.ncplt.cci.org/}save&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Update&quot; type=&quot;{http://webservice.ncplt.cci.org/}update&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Remove&quot; type=&quot;{http://webservice.ncplt.cci.org/}remove&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Search&quot; type=&quot;{http://webservice.ncplt.cci.org/}search&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Request", propOrder = { "userInfo", "functionName", "modelName", "save", "update", "remove", "search" })
public class Request {

	@XmlElement(name = "UserInfo", required = true)
	protected UserInfo userInfo;
	@XmlElement(name = "FunctionName", required = true)
	protected String functionName;
	@XmlElement(name = "ModelName", required = true)
	protected String modelName;
	@XmlElement(name = "Save")
	protected Save save;
	@XmlElement(name = "Update")
	protected Update update;
	@XmlElement(name = "Remove")
	protected Remove remove;
	@XmlElement(name = "Search")
	protected Search search;

	/**
	 * Gets the value of the userInfo property.
	 * 
	 * @return possible object is {@link UserInfo }
	 * 
	 */
	public UserInfo getUserInfo() {
		return userInfo;
	}

	/**
	 * Sets the value of the userInfo property.
	 * 
	 * @param value
	 *            allowed object is {@link UserInfo }
	 * 
	 */
	public void setUserInfo(UserInfo value) {
		this.userInfo = value;
	}

	/**
	 * Gets the value of the functionName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFunctionName() {
		return functionName;
	}

	/**
	 * Sets the value of the functionName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFunctionName(String value) {
		this.functionName = value;
	}

	/**
	 * Gets the value of the modelName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * Sets the value of the modelName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setModelName(String value) {
		this.modelName = value;
	}

	/**
	 * Gets the value of the save property.
	 * 
	 * @return possible object is {@link Save }
	 * 
	 */
	public Save getSave() {
		return save;
	}

	/**
	 * Sets the value of the save property.
	 * 
	 * @param value
	 *            allowed object is {@link Save }
	 * 
	 */
	public void setSave(Save value) {
		this.save = value;
	}

	/**
	 * Gets the value of the update property.
	 * 
	 * @return possible object is {@link Update }
	 * 
	 */
	public Update getUpdate() {
		return update;
	}

	/**
	 * Sets the value of the update property.
	 * 
	 * @param value
	 *            allowed object is {@link Update }
	 * 
	 */
	public void setUpdate(Update value) {
		this.update = value;
	}

	/**
	 * Gets the value of the remove property.
	 * 
	 * @return possible object is {@link Remove }
	 * 
	 */
	public Remove getRemove() {
		return remove;
	}

	/**
	 * Sets the value of the remove property.
	 * 
	 * @param value
	 *            allowed object is {@link Remove }
	 * 
	 */
	public void setRemove(Remove value) {
		this.remove = value;
	}

	/**
	 * Gets the value of the search property.
	 * 
	 * @return possible object is {@link Search }
	 * 
	 */
	public Search getSearch() {
		return search;
	}

	/**
	 * Sets the value of the search property.
	 * 
	 * @param value
	 *            allowed object is {@link Search }
	 * 
	 */
	public void setSearch(Search value) {
		this.search = value;
	}

}
