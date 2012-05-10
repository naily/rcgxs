package com.ghy.vo.tbl;

import java.util.List;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

import com.ghy.util.DateUtil;

import lombok.Data;

/*
 * 合作社信息 (@文档 该字段名完全参考 设计文档)
 */
@Data
@Table("cxcjs_hzs")
public class FSC extends BaseTbl{
	@Column
	@Name
	private String hzsbm; //合作社编码
	@Column
	private String hzsmc; //名称
	@Column
	private String frdb;// 法人
	@Column
	private String ssdq ;//所属地区
	@Column
	private String dqdm;//地区编码
	@Column
	private String syrs;//社员人数
	@Column
	private String tdzmj;//土地总面积
	@Column
	private String hzslx;//合作社类型：流通型 生产型 综合型
	@Column
	private String createDate = DateUtil.getCurrentDateTimeStr();
	@Column
    private String link_tel;  
	@Column
    private String link_man;
    @Column
    private String link_address;
	
	/*
	 * 一对多的
	 */
	@Many(field="hzsbm", target=PlantPlan.class)
	private List<PlantPlan> pps ;  //种植计划取种植品种
	
	
	private String crops;
	public String getCrops(){ //种植品种
		return this.crops ;
	}
	public void setCorps(){
		if(null != pps && pps.size() > 0){
			StringBuilder cs  = new StringBuilder();
			for (PlantPlan pp : pps) {
				cs.append(pp.getZwmc()).append(",") ;
			}
			this.crops = cs.toString();
		}else{
			this.crops = "" ;
		}
	}
	
	public List<PlantPlan> getPps() {
		return pps;
	}
	public void setPps(List<PlantPlan> pps) {
		this.pps = pps;
	}
	public String getHzsbm() {
		return hzsbm;
	}
	public void setHzsbm(String hzsbm) {
		this.hzsbm = hzsbm;
	}
	public String getHzsmc() {
		return hzsmc;
	}
	public void setHzsmc(String hzsmc) {
		this.hzsmc = hzsmc;
	}
	public String getFrdb() {
		return frdb;
	}
	public void setFrdb(String frdb) {
		this.frdb = frdb;
	}
	public String getSsdq() {
		return ssdq;
	}
	public void setSsdq(String ssdq) {
		this.ssdq = ssdq;
	}
	public String getDqdm() {
		return dqdm;
	}
	public void setDqdm(String dqdm) {
		this.dqdm = dqdm;
	}
	public String getSyrs() {
		return syrs;
	}
	public void setSyrs(String syrs) {
		this.syrs = syrs;
	}
	public String getTdzmj() {
		return tdzmj;
	}
	public void setTdzmj(String tdzmj) {
		this.tdzmj = tdzmj;
	}
	public String getHzslx() {
		return hzslx;
	}
	public void setHzslx(String hzslx) {
		this.hzslx = hzslx;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

}
