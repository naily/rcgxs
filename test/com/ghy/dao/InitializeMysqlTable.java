package com.ghy.dao;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.ioc.Ioc;
import org.nutz.resource.Scans;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ghy.ContextLoader;
import com.ghy.WSClient.impl.CommonClientImpl;
import com.ghy.util.DateUtil;
import com.ghy.vo.tbl.*;


public class InitializeMysqlTable<T> {

	Logger log = LoggerFactory.getLogger(getClass()) ;
	public void createAllTable(Dao dao){
		Scans scans = Scans.me();
		List<Class<?>> list = scans.scanPackage("com.ghy.vo.tbl") ;
		log.info("scanPackage size: "+list.size() + "  <") ;
  		Class [] remove = null;// {MenuInfo.class,Area.class , Chanpin.class};  //排除不创建的实体
		if(null != dao && list.size() > 0){
			for (Class cla : list) {
				if(this.checknam(remove, cla.getSimpleName())){
					Annotation [] a = cla.getAnnotations() ;
					if(a.length > 0 && "Table".equals(a[0].annotationType().getSimpleName())){
						dao.create(cla, true) ;  //删除旧表创建;
					}
				}else{
					log.info("no create: "+cla.getSimpleName()) ;
					
				}
			}
		}
	}
	private boolean checknam(Class [] remove , String name){
		if(null == remove){
			return true ;
		}
		for (Class c1 : remove) {
			if(c1.getSimpleName().equals(name))
				return false ;
		}
		return true ;
	}
	/**
	 * @author:Derek
	 * @date:2011-8-24
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InitializeMysqlTable m = new InitializeMysqlTable();
		Dao dao = m.getNutzDao();
		//m.onlyCreate(dao, User.class) ;
		//m.test(dao) ;
		m.createAllTable(dao) ;
		
		
		/*User u = new User() ;
		UserInfo f = new UserInfo();
		
		u.setId(15);
		f.setId(1) ;
		f =  dao.fetch(f);
		if(null != f){
			System.out.println("aaa");
			
		}else{
			System.out.println("IS NULL");
		}*/
	}

	public NutDao getNutzDao(){
		/*String dbURL = "jdbc:mysql://127.0.0.1:3306/cxcjs?useUnicode=true&characterEncoding=utf8";
	
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl(dbURL);
		ds.setUsername("root");
		ds.setPassword("123456");
		ds.setDefaultCatalog("cxcjs") ;*/
		
		/*
		Properties dbProps = new Properties();
		dbProps.put("user", "root");
		dbProps.put("password","");
		 */	 
		Ioc ioc = ContextLoader.contextIoc() ;
		
		NutDao down = ioc.get(NutDao.class, "commonDao"); 
		return down ;
	}
	
	public void test(Dao dao){
		if(null != dao){
			dao.create(FSC.class, false) ;
			dao.create(PlantPlan.class, false) ;  //建表 ,若存在则忽略
			dao.create(User.class, false) ;
			
			dao.create(Area.class, true) ;
			dao.create(AreaMien.class, true) ;
			dao.create(ButtInfo.class, true) ;
			dao.create(ButtJoinInfo.class, true) ;
			dao.create(MessageHazard.class, true) ;
			dao.create(SNInfo.class, true) ;
			
			if(true){
				FSC f = new FSC();
				f.setHzsbm(String.valueOf(System.currentTimeMillis())) ;
				f.setHzsmc("Cyanway") ;
				f.setHzslx("综合型") ;
				f.setFrdb("mm") ;
				f.setCreateDate(DateUtil.getCurrentDateStr()) ;
				PlantPlan pp = new PlantPlan();
				pp.setHzsbm(f.getHzsbm()) ;
				pp.setZwmc("西兰花");
				pp.setPlantDate(DateUtil.getCurrentDateStr()) ;
				pp.setAreaId("10000") ;
				
				User u = new User();
				u.setHZSBM(f.getHzsbm()) ;
				u.setTel("51099321");
				u.setUserId("cyanway") ;
				u.setPassWord("111111") ;

				List<PlantPlan> pps = new ArrayList<PlantPlan>();
				pps.add(pp) ;
				f.setPps(pps) ;
				
				dao.insertWith(f, null) ;
			}
			
			if(false){
				FSC f = new FSC();
				f.setHzsbm("1314341590959") ;
				dao.deleteWith(f, "pps") ;
			}
		}
	}
	
	
	public void  onlyCreate(Dao dao,Class<T> classOfT){
		if(null != dao){
			dao.create(classOfT, true) ;
		}
	}
	
	
}
