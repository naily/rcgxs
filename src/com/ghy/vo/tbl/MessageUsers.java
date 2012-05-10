package com.ghy.vo.tbl;

import lombok.Data;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;
/**
 * Class MessageUsers ,消息与收件人关联表
 *
 * @author <a href="mailto:zhagndingding@cyanway.com">Derek</a>
 * @version $Revision:1.0.0, $Date:Sep 15, 2011 5:59:21 PM $
 */
@Data
@Table("cxcjs_msgUsers" )
public class MessageUsers extends BaseTbl{

	@Column
	@Id
	private int id ;
	@Column
	private int msgId ;
	@Column
	private int uId ;

	
	@One(field="msgId", target=MessageGovernment.class)
	private MessageGovernment msg ;
	
	@One(field="uId", target=User.class)
	private User user ;

	public MessageUsers() {
		super();
	}
	public MessageUsers(int msgId, int id , int status1) {
		super();
		this.msgId = msgId;
		this.uId = id;
		this.status = status1 ;
	}
	
	
}
