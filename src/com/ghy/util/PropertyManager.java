package com.ghy.util;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.nutz.lang.Streams;

/**
 * 属性配置文件 工具类
 * Class PropertyManager
 *
 */
public class PropertyManager {
	/**
	 * Log4J Logger for this class
	 */
	private static transient final Logger log  =  Logger.getLogger(PropertyManager.class);
	private static String FSPROPERTY = null;
    private static Properties paraProps = new Properties();
    
	private static PropertyManager instance = null;

	public static synchronized PropertyManager getInstance() {
		if (instance == null) {
			instance = new PropertyManager();
		}
		return instance;
	}
	
	public PropertyManager(){
		
	}
	public PropertyManager(String configFileName)
	{
		try
		{
			FSPROPERTY = configFileName;
			InputStream is = getClass().getResourceAsStream("/" + FSPROPERTY);
			paraProps.load(is);

		}
		catch (Exception e)
		{
			System.err.println("不能读取配置文件" + FSPROPERTY 
					+ "请确保" + FSPROPERTY + "在CLASSPATH指定的路径中");
			log.error("不能读取配置文件" + FSPROPERTY 
					+ "请确保" + FSPROPERTY + "在CLASSPATH指定的路径中");

		}

	}
	public PropertyManager(File file)
	{
		try
		{
			FSPROPERTY = file.getName();
			InputStream is = Streams.fileIn(file);
			paraProps.load(is);

		}
		catch (Exception e)
		{
			System.err.println("不能读取配置文件" + FSPROPERTY 
					+ "请确保" + FSPROPERTY + "在CLASSPATH指定的路径中");
			log.error("不能读取配置文件" + FSPROPERTY 
					+ "请确保" + FSPROPERTY + "在CLASSPATH指定的路径中");

		}

	}
	
    public String getProperty(String proName){
    	//System.out.println("**********config.properties 's propertyName:" + proName + "----propertyValue:" + paraProps.getProperty(proName) + "***************");
		if(log.isEnabledFor(Level.INFO)){
			log.info("**********" + FSPROPERTY + " 's propertyName:" + proName + "----propertyValue:" + paraProps.getProperty(proName) + "***************");
		}
    	return paraProps.getProperty(proName);
    }
    
    public String getProValue(String configFileName,String proName){
    	String result = null;
		try
		{
			FSPROPERTY = configFileName;
			InputStream is = getClass().getResourceAsStream("/" + FSPROPERTY);
			paraProps.load(is);
			
			if(log.isEnabledFor(Level.INFO)){
				log.info("**********" + FSPROPERTY + " 's propertyName:" + proName + "----propertyValue:" + paraProps.getProperty(proName) + "***************");
			}
			result =  paraProps.getProperty(proName);
		}
		catch (Exception e)
		{
			System.err.println("不能读取配置文件" + FSPROPERTY 
					+ "请确保" + FSPROPERTY + "在CLASSPATH指定的路径中");
			log.error("不能读取配置文件" + FSPROPERTY 
					+ "请确保" + FSPROPERTY + "在CLASSPATH指定的路径中");
		}
		
		return result;
    }
}