package com.ghy.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.filter.CheckSession;
import org.nutz.mvc.upload.TempFile;
import org.nutz.mvc.upload.UploadAdaptor;
import org.nutz.mvc.upload.UploadInfo;
import org.nutz.mvc.upload.Uploads;

import com.ghy.bean.Pager_vo;
import com.ghy.bean.User_vo;
import com.ghy.filters.MenuFilter;
import com.ghy.service.UserService;
import com.ghy.util.FileUtil;
import com.ghy.util.StringUtil;
import com.ghy.vo.tbl.MenuInfo;
import com.ghy.vo.tbl.User;
@IocBean
@Filters(@By(type=CheckSession.class, args={"user", "/plslogin.html"}))
public class UserManagerAction extends BaseAction{
	
	@Inject("refer:userService")
	UserService us  ;
	
	@At("/userList")
	@Ok("json")
	public JSONObject userList(@Param("..") Pager_vo pv){
		JSONObject json = new JSONObject();
		Pager pager = us.getPager(1, 10) ;
		if(pv.getStart() > 0){
			pager = us.getPager(pv.getStart()+1, pv.getLimit()) ;
		}
		json.put("totalProperty", us.getUserTotal()) ;
		json.put("root", JSONArray.fromObject(us.getUserList(pager))) ;
		return json ;
	}
	@At("/addUser")
	@Ok("json")
	public JSONObject addUser(@Param("..") User_vo user , ServletContext context){
		JSONObject json = new JSONObject();
		//log.info("=== addUser ==") ;
		json.put("success", false) ;
		
		//处理用户头像
		//StringBuilder contPath = new StringBuilder("uploadfile/tmp/"); //参照上下文得路径
		String basepath = context.getRealPath("/") ;
		if(StringUtil.checkNotNull(user.getPic())  ){ // 把临时目录中的头像转存
			String tmpPath = basepath + user.getPic() ;
			File tmpFile = new File(tmpPath); 
			if(null != tmpFile && tmpFile.exists()){
				String photoPath = user.getPic().replace("tmp/", "") ;
				File userPhoto = new File(basepath + photoPath);
				if(null != userPhoto && tmpFile.renameTo(userPhoto)){
					//log.info("OK");
					user.setPic(photoPath) ;
				}
			}
			
			//删除临时目录文件
			FileUtil.clearDirectory(basepath + "uploadfile/tmp/") ;
		}
		
		if(user.getId() > 0){ //ID存在的，是修改信息
			if( 0 < us.saveOrUpdate(user)){
				json.put("success", true) ;
				json.put("info", "修改用户成功") ;
			}else{
				json.put("info", "数据库失败") ;
			}
			
		}else{
			if(StringUtil.checkNotNull(user.getUserId())){
				if(us.checkUserNameExist(user.getUserId()) < 1){
					if( 0 < us.saveOrUpdate(user)){
						json.put("success", true) ;
						json.put("info", "创建用户成功") ;
					}else{
						json.put("info", "数据库失败") ;
					}
				}else{
					json.put("info", "用户名已存在") ;
				}
			}else{
				json.put("info", "用户名为空") ;
			}
			
		}
		return json ;
	}
	
	/**
	 * 初始化系统管理页面
	 * @author:Derek
	 * @date:Sep 14, 2011
	 */
	@At("/system")
	@Ok("jsp:/systemManage/index.jsp")
	@Filters(@By(type=MenuFilter.class, args={"/plslogin.html","/warning.html"}))
	public void systemMang(){
		
	}
	
	@At("/deleteUser")
	@Ok("json")
	public JSONObject deleteUser(@Param(value="id") int uid){
		JSONObject json = new JSONObject();
		json.put("success", false) ;
		
		User user  = us.getUserById(uid) ;
		if(null != user ){
			if( user.getIsDel()== 1){
				json.put("info", "该账户不允许删除") ;
			}else{
				if(1 == us.delUser(user.getId())){
					json.put("success", true) ;
					json.put("info", "删除成功") ;
				}else{
					json.put("info", "删除失败,发生未知错误") ;
				}
				
			}
		}else{
			json.put("info", "删除失败,无效的用户ID") ;
		}
		return json;
	}
	
	@At("/findByIdUserInfo")
	@Ok("json")
	public JSONObject findByIdUserInfo(@Param(value="id") int uid , HttpSession session){
		JSONObject json = new JSONObject();
		User user = us.getUserById(uid) ;
		if(null != user){
			User_vo uv = this.getSessionUser(session) ;
			user.setSYMC(uv.getCountyName()) ;//
			json.put("success", true) ;
			JsonConfig cfg = new JsonConfig();  
			cfg.setExcludes(new String[] { "role", "HZSBM" }); 
			json.put("data", JSONObject.fromObject(user, cfg)) ;
		}else{
			json.put("success", false) ;
		}
		return json ;
	}
	
	@At("/userAllList")
	@Ok("json")
	public JSONObject userAllList(){
		JSONObject json = new JSONObject();
		JsonConfig cfg = new JsonConfig();  
		cfg.setExcludes(new String[] { "role", "HZSBM" }); 
		//cfg.setExcludes(new String[] { "id", "userId" }); 
		//cfg.setIgnoreDefaultExcludes(false) ;
		json.put("root", JSONArray.fromObject(us.getUserAllList(),cfg)) ;
		return json ;
	}
	@At("/userPhotoUpload")
	@AdaptBy(type = UploadAdaptor.class, args = {"${app.root}/WEB-INF/uploadfile/tmp" ,"8192", "UTF-8", "10"  })
	public void uploadPhoto(@Param("photo")TempFile  tmpf, HttpServletResponse resp ,ServletContext context) throws IOException{
		JSONObject json = new JSONObject();
		//Map json = new HashMap(); 
		json.put("success", true) ;
		if(null != tmpf){
			//String fileName =  tmpf.getMeta().getFileLocalName() ;
			String ext = tmpf.getMeta().getFileExtension() ;
			UUID uuid = UUID.randomUUID();
			StringBuilder contPath = new StringBuilder("uploadfile/tmp/");
			contPath.append(uuid.toString()).append(ext) ;
			
			String basepath = context.getRealPath("/") ;
			File newfile = new File(basepath + contPath.toString()) ;
			
			if(tmpf.getFile().renameTo(newfile)){
				json.put("info", contPath.toString());
			}
		}else{
			json.put("success", false) ;
			json.put("info", "FILE NO FOUND") ;
		}
		//log.info(json.toString()) ;
		//return json;
		resp.setContentType("text/html");
		resp.getWriter().print(json.toString());
		
		//return json ;
	}
}
