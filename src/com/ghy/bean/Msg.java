package com.ghy.bean;

import java.util.List;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;

import com.ghy.vo.tbl.AreaMien;
import com.ghy.vo.tbl.MessageGovernment;
import com.ghy.vo.tbl.MessageUsers;

import lombok.Data;

@Data
public class Msg extends Pager_vo{
	
	private int id ;

	private String title ;

	private String content;

	private String createDate;

	private int authorId;

	private String outboxStatus ;
	
	private int msgId ;
	private int uId ; //收件人Id
	
	private String usersIdStr ; //收件人Id 字符串
	
	
	private List<MessageGovernment> list ;
	private List<MessageUsers> list2 ;
	
	private String type ; //outbox inbox
	
	private boolean isPage ; //是否分页
	private boolean isPrevious ; //上一页
	private boolean isNext ;
	private int ppn ;//上一页页码
	private int pnn ;
}
