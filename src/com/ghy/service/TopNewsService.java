package com.ghy.service;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.IocBean;

import com.ghy.vo.tbl.TopNews;


@IocBean(name = "topNewsService")
public class TopNewsService extends BaseService {

	
	/**
	 * 获得最新头条新闻
	 * @author:Derek
	 * @date:Sep 23, 2011
	 * @return
	 */
	public TopNews getTopNews(){
		//return getCommonDao().fetch(TopNews.class,getCommonDao().getMaxId(TopNews.class));
		return getCommonDao().fetch(TopNews.class) ;
	}
	public TopNews getTopNews(int id){
		//return getCommonDao().fetch(TopNews.class,getCommonDao().getMaxId(TopNews.class));
		return getCommonDao().fetch(TopNews.class , id) ;
	}
	
	public List<TopNews> getTopNewsList(){
		return getCommonDao().query(TopNews.class, Cnd.wrap("order by id desc "), getPager(1, 6)) ;
	}
	
	public void insertTopNews(List<TopNews> list){
		getCommonDao().insert(list) ;
	}
	public TopNews insertTopNews(TopNews news){
		return getCommonDao().insert(news) ;
	}
}
