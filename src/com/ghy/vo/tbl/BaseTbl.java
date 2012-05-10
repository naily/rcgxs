package com.ghy.vo.tbl;

import lombok.Data;

import org.nutz.dao.entity.annotation.Column;
@Data
public class BaseTbl {
	
	//0 数据来源于平台，提交是忽略 ，如果本地数据更新了，可以变状态为2，从而可以参与提交
	//1本地数据，需提交同步到平台 ，包括本地更新时 状态需修改为2 ;提交成功改成0，表示与平台一致的数据
	//2更新数据 和平台更新操作对应
	@Column
	protected Integer status;
	@Column
	protected long systemId ; //平台唯一ID
	@Column
	protected String subjectCodeId ; //subcode+id
	
	

}
