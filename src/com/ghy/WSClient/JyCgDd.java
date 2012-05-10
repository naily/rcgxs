package com.ghy.WSClient;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for jyCgDd complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;jyCgDd&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;dqid&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;hzsbm&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;hzsmc&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;jyhId&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;list&quot; type=&quot;{http://webservice.ncplt.cci.org/}jyhcp&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;subjectCodeId&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jyCgDd", propOrder = { "dqid", "hzsbm", "hzsmc", "jyhId", "list", "subjectCodeId" })
public class JyCgDd {

	protected String dqid;
	protected String hzsbm;
	protected String hzsmc;
	protected String jyhId;
	@XmlElement(nillable = true)
	protected List<Jyhcp> list;
	protected String subjectCodeId;

	/**
	 * Gets the value of the dqid property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDqid() {
		return dqid;
	}

	/**
	 * Sets the value of the dqid property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDqid(String value) {
		this.dqid = value;
	}

	/**
	 * Gets the value of the hzsbm property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHzsbm() {
		return hzsbm;
	}

	/**
	 * Sets the value of the hzsbm property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHzsbm(String value) {
		this.hzsbm = value;
	}

	/**
	 * Gets the value of the hzsmc property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHzsmc() {
		return hzsmc;
	}

	/**
	 * Sets the value of the hzsmc property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHzsmc(String value) {
		this.hzsmc = value;
	}

	/**
	 * Gets the value of the jyhId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getJyhId() {
		return jyhId;
	}

	/**
	 * Sets the value of the jyhId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setJyhId(String value) {
		this.jyhId = value;
	}

	/**
	 * Gets the value of the list property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the list property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getList().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Jyhcp }
	 * 
	 * 
	 */
	public List<Jyhcp> getList() {
		if (list == null) {
			list = new ArrayList<Jyhcp>();
		}
		return this.list;
	}

	/**
	 * Gets the value of the subjectCodeId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSubjectCodeId() {
		return subjectCodeId;
	}

	/**
	 * Sets the value of the subjectCodeId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSubjectCodeId(String value) {
		this.subjectCodeId = value;
	}

}
