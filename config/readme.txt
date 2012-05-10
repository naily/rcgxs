svn:
file://192.168.1.201/e$/svn/cxcjs
Webservices:
杨柳春
http://192.168.1.128:8083/cjj/CJJWS/CJJ?wsdl

lombok主要的特性有：自动生成默认的getter/setter方法、自动化的资源管理（通过@Cleanup注解）及注解驱动的异常处理等。 
首先介绍下其安装方法： 
1、将lombok.jar copy到eclipse的安装目录。 
2、修改eclipse.ini文件，加入如下 代码 

-Xbootclasspath/a:lombok.jar  
-javaagent:lombok.jar  

赋权给网内其他机器访问该数据库
--grant all privileges on *.* to 'root'@'%' identified by '123456'
===================================================================================================
Resin启动Webservice客户端，调用Webservice服务报property "javax.xml.stream.supportDTD" not supported错误 .
首先在resin.conf配置中找到如下代码： 
<!-- Uncomment to use Resin's XML implementations
     -
     - <system-property javax.xml.parsers.DocumentBuilderFactory
     -                 ="com.caucho.xml.parsers.XmlDocumentBuilderFactory"/>
     - <system-property javax.xml.parsers.SAXParserFactory
     -                 ="com.caucho.xml.parsers.XmlSAXParserFactory"/>
    --> 
如果已经使用，就替换下面，如果没有使用，就加上下面的配置 
<system-property javax.xml.stream.XMLInputFactory="com.sun.xml.internal.stream.XMLInputFactoryImpl" />
我发现我的 resin.conf配置中没有 <system-property javax.xml.stream.XMLInputFactory="com.sun.xml.internal.stream.XMLInputFactoryImpl" /> 