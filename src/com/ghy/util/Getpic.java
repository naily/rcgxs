package com.ghy.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ghy.action.BaseAction;

public class Getpic extends BaseAction{
	private static Logger log = LoggerFactory.getLogger("Getpic") ;
	private Getpic() {
	}
	
	private static Getpic me ;
	public static Getpic me(){
		if(null == me){
			me= new Getpic();
		}
		return me ;
	}
	/**
	 * @param 参1：fileUrl 网络资源地址
	 * @param 参2：savePath 本地保存路径
	 */
	public static boolean saveUrlAs(String fileUrl, String savePath){
		try {
			URL url = new URL(fileUrl);/* 将网络资源地址传给,即赋值给url */ 
			/* 此为联系获得网络资源的固定格式用法，以便后面的in变量获得url截取网络资源的输入流 */
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			DataInputStream in = new DataInputStream(connection.getInputStream());
			/* 此处也可用BufferedInputStream与BufferedOutputStream */
			DataOutputStream out = new DataOutputStream(new FileOutputStream( savePath));
			/* 将参数savePath，即将截取的图片的存储在本地地址赋值给out输出流所指定的地址 */
			byte[] buffer = new byte[4096];
			int count = 0;
			while ((count = in.read(buffer)) > 0)/* 将输入流以字节的形式读取并写入buffer中 */
			{
				out.write(buffer, 0, count);
			}
			out.close();/* 后面三行为关闭输入输出流以及网络资源的固定格式 */
			in.close();
			connection.disconnect();
			return true;/* 网络资源截取并存储本地成功返回true */

		} catch (Exception e) {
			log.info(e.toString() );
			log.info("httpURL: "+fileUrl);
			log.info("localPaht: "+savePath);
			return false;
		}
	}
	/*
	 * 检查URL是否可用
	 */
	public static boolean checkUrl(String url){
		
		boolean flag = false;
		if(StringUtil.checkNotNull(url)){
			try {
				URL obj = new URL(url);
				HttpURLConnection conn = (HttpURLConnection)obj.openConnection();    
			    /** 
			      * public int getResponseCode()throws IOException 
			      * 从 HTTP 响应消息获取状态码。 
			      * 例如，就以下状态行来说： 
			      * HTTP/1.0 200 OK 
			      * HTTP/1.0 401 Unauthorized 
			      * 将分别返回 200 和 401。 
			      * 如果无法从响应中识别任何代码（即响应不是有效的 HTTP），则返回 -1。 
			      * 
			      * 返回 HTTP 状态码或 -1 
			      */   
			    int state = conn.getResponseCode();    
			    if(state == 200){    
			    	flag = true;
			    	}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				flag = false;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				flag = false;
			}finally{
				return flag;
			}
		}
		return flag;
	}

	public static void main(String[] args) {
		Getpic pic = Getpic.me();/* 创建实例 */
		String photoUrl = "http://drmcmm.baidu.com/media/id=n1n4njcLP10&gp=403&time=nHnkPWm3nW01ns.jpg";
		/*
		 * photoUrl.substring(photoUrl.lastIndexOf("/")的方法将返回最后一个符号为
		 * ‘/’后photoUrl变量中的所有字符，包裹此自身符号
		 */
		String fileName = photoUrl.substring(photoUrl.lastIndexOf("/"));
		String filePath = "E:";
		/* 调用函数，并且进行传参 */
		boolean flag = pic.saveUrlAs(photoUrl, filePath + fileName);
		System.out.println("Run ok!\n Get URL file " + flag);
		System.out.println(filePath);
		System.out.println(fileName);
	}
}