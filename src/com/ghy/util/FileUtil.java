package com.ghy.util;

import java.io.File;

public class FileUtil {

	/**
	 * @author:Derek
	 * @date:Oct 18, 2011
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 清空一个文件目录
	 * @author:Derek
	 * @date:Oct 18, 2011
	 */
	public static void clearDirectory(String dir){
		//System.out.println("dir: "+dir);
		if(StringUtil.checkNotNull(dir)){
			File d = new File(dir);
			if(d.exists() &&  d.isDirectory()){
				 File[] fs = d.listFiles();
				 if(null != fs && fs.length > 0){
					 for (File file : fs) {
						file.delete() ;
					}
				 }
			}
		}
	}
}
