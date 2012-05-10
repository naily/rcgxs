package com.ghy.WSClient;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Response complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;Response&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;UserInfo&quot; type=&quot;{http://webservice.ncplt.cci.org/}userInfo&quot;/&gt;
 *         &lt;element name=&quot;FunctionName&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;ModelName&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;ResultInfo&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Items&quot; minOccurs=&quot;0&quot;&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name=&quot;Item&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Response", propOrder = { "userInfo", "functionName", "modelName", "resultInfo", "items" })
public class Response {

	@XmlElement(name = "UserInfo", required = true)
	protected UserInfo userInfo;
	@XmlElement(name = "FunctionName", required = true)
	protected String functionName;
	@XmlElement(name = "ModelName", required = true)
	protected String modelName;
	@XmlElement(name = "ResultInfo")
	protected String resultInfo;
	@XmlElement(name = "Items")
	protected Response.Items items;

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
	 * Gets the value of the resultInfo property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getResultInfo() {
		return resultInfo;
	}

	/**
	 * Sets the value of the resultInfo property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setResultInfo(String value) {
		this.resultInfo = value;
	}

	/**
	 * Gets the value of the items property.
	 * 
	 * @return possible object is {@link Response.Items }
	 * 
	 */
	public Response.Items getItems() {
		return items;
	}

	/**
	 * Sets the value of the items property.
	 * 
	 * @param value
	 *            allowed object is {@link Response.Items }
	 * 
	 */
	public void setItems(Response.Items value) {
		this.items = value;
	}

	/**
	 * <p>
	 * Java class for anonymous complex type.
	 * 
	 * <p>
	 * The following schema fragment specifies the expected content contained
	 * within this class.
	 * 
	 * <pre>
	 * &lt;complexType&gt;
	 *   &lt;complexContent&gt;
	 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
	 *       &lt;sequence&gt;
	 *         &lt;element name=&quot;Item&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
	 *       &lt;/sequence&gt;
	 *     &lt;/restriction&gt;
	 *   &lt;/complexContent&gt;
	 * &lt;/complexType&gt;
	 * </pre>
	 * 
	 * 
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "item" })
	public static class Items {

		@XmlElement(name = "Item")
		protected List<Object> item;

		/**
		 * Gets the value of the item property.
		 * 
		 * <p>
		 * This accessor method returns a reference to the live list, not a
		 * snapshot. Therefore any modification you make to the returned list
		 * will be present inside the JAXB object. This is why there is not a
		 * <CODE>set</CODE> method for the item property.
		 * 
		 * <p>
		 * For example, to add a new item, do as follows:
		 * 
		 * <pre>
		 * getItem().add(newItem);
		 * </pre>
		 * 
		 * 
		 * <p>
		 * Objects of the following type(s) are allowed in the list
		 * {@link Object }
		 * 
		 * 
		 */
		public List<Object> getItem() {
			if (item == null) {
				item = new ArrayList<Object>();
			}
			return this.item;
		}

	}

}
