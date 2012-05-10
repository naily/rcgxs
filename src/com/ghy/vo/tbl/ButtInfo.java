package com.ghy.vo.tbl;

import java.util.List;

import lombok.Data;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

/*
 * 对接会/政策信息
 */
@Table("cxcjs_buttInfo")
public @Data class ButtInfo extends BaseTbl{

	@Column
	@Id
	private int id;
	@Column
	private String receiverName;// 收件人姓名
	@Column
	private String title;
	@Column
	private String type;
	@Column
	@ColDefine(type=ColType.TEXT , width = 3000)
	private String text;
	@Column
	private String startDate;
	@Column
	private String endDate;
	@Column
	private String hzsName; //合作社名称
	@Column
	private int userId ;
	@Column
	private String msgStatus ; //紧急，普通
	@Column
	private String createDate ;
	/*
	 * 对接会报名信息
	 */
	@Many(field="buttId", target=ButtJoinInfo.class)
	private List<ButtJoinInfo> joinList;
	
	@One(field="userId", target=User.class)
	private User user;
}
