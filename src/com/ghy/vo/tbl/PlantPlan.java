/** 
 * @author:Dingding Zhang
 * @(#)cxcjs com.ghy.vo.tbl.PlantPlan.java 2011-8-22 上午11:47:15
 * 
 * Copyright 2011  All rights reserved.
 * UFSTONE PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ghy.vo.tbl;

import lombok.Data;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * Class PlantPlan z种植计划
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:2011-8-22 上午11:47:15 $
 */
@Data
@Table("cxcjs_plantplan")
public class PlantPlan extends BaseTbl{
	
	@Column
	@Id
	private int id;
	@Column
	private String hzsbm;
	@Column
	private String dkbm;
	@Column
	private String zwmc;  //作物名称
	@Column
	private String zzmj;
	@Column
	private String bzsj;
	@Column
	private String shsj; //收获时间
	@Column
	private String yjcl; //预计产量
	@Column
	private String zlms;
	@Column
	private String ccsj;
	@Column
	private String cctj ;
	@Column
	private String tj;
	@Column
	private String sfdd; // 是否有订单
	@Column
	private String dd;  //订单号
	@Column
	private String plantDate ; //种植时间
	@Column
	private String areaId ;
 
}
