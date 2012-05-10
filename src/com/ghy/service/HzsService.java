package com.ghy.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Sql;
import org.nutz.dao.sql.SqlCallback;
import org.nutz.ioc.loader.annotation.IocBean;

import com.ghy.bean.Hzs_vo;
import com.ghy.bean.Pager_vo;
import com.ghy.util.StringUtil;
import com.ghy.vo.tbl.Area;
import com.ghy.vo.tbl.FSC;

@IocBean(name = "hzsService")
public class HzsService extends BaseService{
	
	private final Map<String, String> m = new HashMap<String, String>();
	public HzsService(){
		m.put("1", "生产型") ;
		m.put("2", "流通型") ;
		m.put("3", "综合型") ;
		
	}
	
	public FSC save(FSC mh){
		return getCommonDao().insert(mh) ;
	}
	public Area getArea(String id){
		return getCommonDao().fetch(Area.class, id) ;
	}
	/**
	 * 按合作社类型查
	 * @author:Derek
	 * @date:2011-8-30
	 * @param type
	 * @param pv
	 * @return
	 */
	public List getHzsList(String type ,Pager_vo pv){
		List<FSC> list0 = new ArrayList() ;
		Dao dao = getCommonDao();
		Condition c = null ;
		if(StringUtil.checkNotNull(type)){
			c = Cnd.where("hzslx", "=", type) ;
		}
		Pager pager = dao.createPager(pv.getPageNumber(), pv.getPageSize());
		List<FSC> list = dao.query(FSC.class, c, pager) ;
		for (FSC fsc : list) {
			dao.fetchLinks(fsc, null);
			fsc.setCorps() ;
			
			list0.add(fsc) ;
		}
		return list0;
	}
	public int getHzsListTotal(String type){
		Condition c = null ;
		if(StringUtil.checkNotNull(type)){
			c = Cnd.where("hzslx", "=", type) ;
		}
		List<FSC> list = getCommonDao().query(FSC.class, c, null) ;
		
		return list.size() ;
	}
	
	
	/**
	 * 种植面积统计
	 */
	public List<Hzs_vo> getPlantAreaList(String areaId ,Pager_vo pv){
		//getCommonDao().query(FSC.class, Cnd.where("dqdm", "=", areaId), null) ;
		Sql sql = Sqls.create("SELECT sum(zzmj) mj,zwmc,plantDate FROM cxcjs_plantplan WHERE hzsbm like @areaId group by zwmc,plantDate");
        sql.params().set("areaId", areaId+"%");
        log.info(sql.toString()) ;
        sql.setCallback(new SqlCallback() {
				public Object invoke(java.sql.Connection conn, ResultSet rs, Sql sql) throws SQLException {
					List<Hzs_vo> list = new ArrayList<Hzs_vo>();
                    while (rs.next())
                            list.add(new Hzs_vo(rs.getString("zwmc"),rs.getString("plantDate").substring(0, 4),rs.getString("mj")));
                    return list;
				}
        });
        getCommonDao().execute(sql);
        return sql.getList(Hzs_vo.class);
	}
	/**
	 * 分品种产量统计
	 */
	public List<Hzs_vo> getPlantPlanList(String areaId ,Pager_vo pv){
		Sql sql = Sqls.create("SELECT sum(yjcl) cl,zwmc,plantDate,shsj FROM cxcjs_plantplan WHERE hzsbm like @areaId group by zwmc,plantDate,shsj");
        sql.params().set("areaId", areaId + "%");
        log.info(sql.toString()) ;
        sql.setCallback(new SqlCallback() {
				public Object invoke(java.sql.Connection conn, ResultSet rs, Sql sql) throws SQLException {
					List<Hzs_vo> list = new ArrayList<Hzs_vo>();
                    while (rs.next())
                            list.add(new Hzs_vo(rs.getString("zwmc"),rs.getString("plantDate").substring(0, 4),rs.getString("cl"),rs.getString("shsj")));
                    return list;
				}
        });
        getCommonDao().execute(sql);
        return sql.getList(Hzs_vo.class);
	}
	/**
	 * 合作社类型分析
	 * 合作社类型，1 是流通型2 是生产型 3 是综合型 
	 */
	public List<Hzs_vo> getHzsTypePercent(String areaId){
		Sql sql = Sqls.create("SELECT hzslx, count(hzsbm) size FROM cxcjs_hzs WHERE  hzslx is not null group by hzslx ");
        //sql.params().set("areaId", areaId); //dqdm = @areaId and
		
        log.info(sql.toString()) ;
        sql.setCallback(new SqlCallback() {
				public Object invoke(java.sql.Connection conn, ResultSet rs, Sql sql) throws SQLException {
					List<Hzs_vo> list = new ArrayList<Hzs_vo>();
                    while (rs.next())
                            list.add(new Hzs_vo(m.get(rs.getString("hzslx")),rs.getString("size") ));
                    return list;
				}
        });
        getCommonDao().execute(sql);
        return sql.getList(Hzs_vo.class);
	}
	/**
	 * 上市情况分析
	 */
	public List<Hzs_vo> getLaunchTotal(String areaId){
		Sql sql = Sqls.create("SELECT count(yjcl) cl,zwmc,shsj FROM cxcjs_plantplan WHERE areaid = @areaId group by zwmc,shsj");
        sql.params().set("areaId", areaId);
        sql.setCallback(new SqlCallback() {
				public Object invoke(java.sql.Connection conn, ResultSet rs, Sql sql) throws SQLException {
					List<Hzs_vo> list = new ArrayList<Hzs_vo>();
                    while (rs.next())
                            list.add(new Hzs_vo(rs.getString("zwmc"),rs.getString("shsj"),rs.getInt("cl") ));
                    return list;
				}
        });
        getCommonDao().execute(sql);
        return sql.getList(Hzs_vo.class);
	}
	
	public int getTotal(Condition c){
		return getCommonDao().count(FSC.class, c) ;
	}
}
