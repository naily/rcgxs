package com.ghy.WSClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for registerBean complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;registerBean&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;address&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;countyId&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;countyName&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;dikuaibianm&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;email&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;fanrendb&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;fax&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;hzsPkId&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;hzslx&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}int&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;latitude&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}double&quot;/&gt;
 *         &lt;element name=&quot;loginName&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;longitude&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}double&quot;/&gt;
 *         &lt;element name=&quot;lxr&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;mobile&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;name&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;password&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;postalcode&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;remark&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;roleid&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}int&quot;/&gt;
 *         &lt;element name=&quot;serialNo&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;ssdiqu&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;syrs&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}int&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;telephone&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;tudimianj&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}double&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "registerBean", propOrder = { "address", "countyId", "countyName", "dikuaibianm", "email", "fanrendb", "fax", "hzsPkId",
		"hzslx", "latitude", "loginName", "longitude", "lxr", "mobile", "name", "password", "postalcode", "remark", "roleid", "serialNo",
		"ssdiqu", "syrs", "telephone", "tudimianj" })
public class RegisterBean {

	protected String address;
	protected Long countyId;
	protected String countyName;
	protected String dikuaibianm;
	protected String email;
	protected String fanrendb;
	protected String fax;
	protected Long hzsPkId;
	protected Integer hzslx;
	protected double latitude;
	protected String loginName;
	protected double longitude;
	protected String lxr;
	protected String mobile;
	protected String name;
	protected String password;
	protected String postalcode;
	protected String remark;
	protected int roleid;
	protected String serialNo;
	protected String ssdiqu;
	protected Integer syrs;
	protected String telephone;
	protected Double tudimianj;

	/**
	 * Gets the value of the address property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the value of the address property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAddress(String value) {
		this.address = value;
	}

	/**
	 * Gets the value of the countyId property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getCountyId() {
		return countyId;
	}

	/**
	 * Sets the value of the countyId property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setCountyId(Long value) {
		this.countyId = value;
	}

	/**
	 * Gets the value of the countyName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCountyName() {
		return countyName;
	}

	/**
	 * Sets the value of the countyName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCountyName(String value) {
		this.countyName = value;
	}

	/**
	 * Gets the value of the dikuaibianm property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDikuaibianm() {
		return dikuaibianm;
	}

	/**
	 * Sets the value of the dikuaibianm property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDikuaibianm(String value) {
		this.dikuaibianm = value;
	}

	/**
	 * Gets the value of the email property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the value of the email property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEmail(String value) {
		this.email = value;
	}

	/**
	 * Gets the value of the fanrendb property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFanrendb() {
		return fanrendb;
	}

	/**
	 * Sets the value of the fanrendb property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFanrendb(String value) {
		this.fanrendb = value;
	}

	/**
	 * Gets the value of the fax property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * Sets the value of the fax property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFax(String value) {
		this.fax = value;
	}

	/**
	 * Gets the value of the hzsPkId property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getHzsPkId() {
		return hzsPkId;
	}

	/**
	 * Sets the value of the hzsPkId property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setHzsPkId(Long value) {
		this.hzsPkId = value;
	}

	/**
	 * Gets the value of the hzslx property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getHzslx() {
		return hzslx;
	}

	/**
	 * Sets the value of the hzslx property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setHzslx(Integer value) {
		this.hzslx = value;
	}

	/**
	 * Gets the value of the latitude property.
	 * 
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Sets the value of the latitude property.
	 * 
	 */
	public void setLatitude(double value) {
		this.latitude = value;
	}

	/**
	 * Gets the value of the loginName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * Sets the value of the loginName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLoginName(String value) {
		this.loginName = value;
	}

	/**
	 * Gets the value of the longitude property.
	 * 
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * Sets the value of the longitude property.
	 * 
	 */
	public void setLongitude(double value) {
		this.longitude = value;
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
	 * Gets the value of the mobile property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * Sets the value of the mobile property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMobile(String value) {
		this.mobile = value;
	}

	/**
	 * Gets the value of the name property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the name property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setName(String value) {
		this.name = value;
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
	 * Gets the value of the postalcode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPostalcode() {
		return postalcode;
	}

	/**
	 * Sets the value of the postalcode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPostalcode(String value) {
		this.postalcode = value;
	}

	/**
	 * Gets the value of the remark property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * Sets the value of the remark property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRemark(String value) {
		this.remark = value;
	}

	/**
	 * Gets the value of the roleid property.
	 * 
	 */
	public int getRoleid() {
		return roleid;
	}

	/**
	 * Sets the value of the roleid property.
	 * 
	 */
	public void setRoleid(int value) {
		this.roleid = value;
	}

	/**
	 * Gets the value of the serialNo property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSerialNo() {
		return serialNo;
	}

	/**
	 * Sets the value of the serialNo property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSerialNo(String value) {
		this.serialNo = value;
	}

	/**
	 * Gets the value of the ssdiqu property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSsdiqu() {
		return ssdiqu;
	}

	/**
	 * Sets the value of the ssdiqu property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSsdiqu(String value) {
		this.ssdiqu = value;
	}

	/**
	 * Gets the value of the syrs property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getSyrs() {
		return syrs;
	}

	/**
	 * Sets the value of the syrs property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setSyrs(Integer value) {
		this.syrs = value;
	}

	/**
	 * Gets the value of the telephone property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * Sets the value of the telephone property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTelephone(String value) {
		this.telephone = value;
	}

	/**
	 * Gets the value of the tudimianj property.
	 * 
	 * @return possible object is {@link Double }
	 * 
	 */
	public Double getTudimianj() {
		return tudimianj;
	}

	/**
	 * Sets the value of the tudimianj property.
	 * 
	 * @param value
	 *            allowed object is {@link Double }
	 * 
	 */
	public void setTudimianj(Double value) {
		this.tudimianj = value;
	}

}
