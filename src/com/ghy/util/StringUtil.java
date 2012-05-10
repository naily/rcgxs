package com.ghy.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import sun.io.ByteToCharConverter;
import sun.io.CharToByteConverter;



public class StringUtil
{
	public static final String UTF_8 = "UTF-8" ;
	public static final String UTF8 = "UTF8" ;
	public static final String GBK = "GBK" ;
	public static final String GB2312 = "GB2312" ;
	public StringUtil() { }
	public static final String escapeForIntro(String string)
	{
		//			 String str = escapeHTMLTags(string);
		String str = string;
		str = replace(str, "\r\n", "<br>");
		str = replace(str, "\n", "<br>");
		str = replace(str, "'", "\\'");
		return replace(str, "\r", "");

	}
	/**
	 * 得到非空的字符串，若字符串对象为null，则返回""。
	 * @param objValue Object待转换的原字符串对象
	 * @return String 转换后的字符串
	 * */
	public static String getNotNullStr(Object objValue)
	{
		return (objValue == null ? "" : objValue.toString());
	}
	/**
	 * 得到非空的字符串，若字符串为null，则返回""。
	 * @param strValue String待转换的原字符串
	 * @return String 转换后的字符串
	 * */
	public static String getNotNullStr(String strValue)
	{
		return (strValue == null ? "" : strValue.trim());
	}
	/**
	 * 将中文转化成AscII码以便存入数据库
	 * @param s  中文字符串
	 * @return 16进制字符串
	 */
	public static String ChineseStringToAscii(String s)
	{
		try
		{
			CharToByteConverter toByte = CharToByteConverter.getConverter("GBK");
			byte[] orig = toByte.convertAll(s.toCharArray());
			char[] dest = new char[orig.length];
			for (int i = 0; i < orig.length; i++)
				dest[i] = (char) (orig[i] & 0xFF);
			return new String(dest);
		}
		catch (Exception e)
		{
			System.out.println(e);
			return s;
		}
	}
	/**
	 * 将UTF-8转化成AscII码以便存入数据库
	 * @param s 中文字符串
	 * @return 16进制字符串
	 */
	public static String ChineseStringToUTF(String s)
	{
		try
		{
			CharToByteConverter toByte = CharToByteConverter.getConverter("UTF-8");
			byte[] orig = toByte.convertAll(s.toCharArray());
			char[] dest = new char[orig.length];
			for (int i = 0; i < orig.length; i++)
				dest[i] = (char) (orig[i] & 0xFF);
			return new String(dest);
		}
		catch (Exception e)
		{
			System.out.println(e);
			return s;
		}
	}

	/**
	 * 将AscII字符转换成汉字
	 * @param s -  ASCII字符串
	 * @return 汉字
	 */
	public static String AsciiToChineseString(String s)
	{
		char[] orig = s.toCharArray();
		byte[] dest = new byte[orig.length];
		for (int i = 0; i < orig.length; i++)
			dest[i] = (byte) (orig[i] & 0xFF);
		try
		{
			ByteToCharConverter toChar = ByteToCharConverter.getConverter("GBK");
			return new String(toChar.convertAll(dest));
		}
		catch (Exception e)
		{
			System.out.println(e);
			return s;
		}
	}

	/**
	 * 使用正则表达式进行字符串内容替换
	 * @param regularExpression 正则表达式
	 * @param sub 替换的字符串
	 * @param input 要替换的字符串
	 * @return String 替换后的字符串
	 */
	public static synchronized String regexReplace(String regularExpression, String sub, String input)
	{
		Pattern pattern = PatternFactory.getPattern(regularExpression);
		Matcher matcher = pattern.matcher(input);
		StringBuffer sb = new StringBuffer();
		while (matcher.find())
		{
			matcher.appendReplacement(sb, sub);
		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	/**
	 * 判断一个字符串中是否包含符合正则表达式定义的匹配条件的子串
	 * @param regularExpression - 正则表达式
	 * @param input - 待检查字符串
	 * @return - 若输入字符串中包含符合正则表达式定义的匹配条件的子串，则返回true，否则返回false
	 */
	//正则表达式匹配判断
	public static synchronized boolean exist(String regularExpression, String input)
	{
		Pattern pattern = PatternFactory.getPattern(regularExpression);
		Matcher matcher = pattern.matcher(input);
		return matcher.find();
	}

	/**
	 * 用"0"补足一个字符串到指定长度
	 * @param str -  源字符串
	 * @param size - 补足后应达到的长度
	 * @return - 补零后的结果
	 */
	public static String fillZero(String str, int size)
	{
		String result;
		if (str.length() < size)
		{
			char[] s = new char[size - str.length()];
			for (int i = 0; i < (size - str.length()); i++)
			{
				s[i] = '0';
			}
			result = new String(s) + str;
		}
		else
		{
			result = str;
		}

		return result;
	}

	/**
	 * 根据字符串（文件类型或者多行输入类型）获取字符串数组
	 * @param str1 String 输入字符串
	 * @return String[] 返回结果
	 */
	public static String[] getStrArryByString(String str1)
	{
		if (str1.indexOf("\t") > 0)
		{
			for (int i = 0; i < str1.length(); i++)
			{
				if (str1.substring(i, i + 1).equals("\t"))
				{
					str1 = str1.substring(0, i) + " " + str1.substring(i + 1, str1.length());
				}
			}
		}
		StringTokenizer stringTokenizer = new StringTokenizer(str1, "\r\n");
		String[] strId = new String[stringTokenizer.countTokens()];
		int i = 0;
		while (stringTokenizer.hasMoreTokens())
		{
			strId[i] = stringTokenizer.nextToken();
			i++;
		}
		return strId;
	}
	/**
	 * 判断一个字符串是否为 NUll 或为空
	 * @param inStr inStr
	 * @return boolean
	 */
	public static boolean isValid(String inStr)
	{
		if (inStr == null)
		{
			return false;
		}
		else if (inStr.trim().equals(""))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	/**
	 * 判断一个字符串是否为 NUll 或为空字符,不为空返回 TRUE
	 * @param inStr inStr
	 * @return boolean
	 */	
	public static boolean checkNotNull(String str){
		boolean flag = false;
		if(str != null && str.trim().length() != 0)	
			flag = true;
		return flag;
	}
	
	/**
	 * 判断一个字符串是 NUll 或为空
	 * @param inStr inStr
	 * @return boolean
	 */	
	public static boolean checkNull(String str){
		boolean flag = true;
		
		if(str != null && str.trim().length() != 0)	
			flag = false;
		return flag;
	}
	/**
	 * 如果字符串为空，返回true
	 * @author:Derek
	 * @date:2010-9-29
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str){
		boolean flag = false;
		
		if(str == null && str.trim().length() == 0)	
			flag = true;
		return flag;
	}
	/**
	 * 获得指定长度的空格
	 * @param spaceNum spaceNum
	 * @return String
	 */
	public static String getStrSpace(int spaceNum)
	{
		return getStrWithSameElement(spaceNum, " ");
	}
	/**
	 * 获得指定长度的字符串
	 * @param num int
	 * @param element String
	 * @return String
	 */
	public static String getStrWithSameElement(int num, String element)
	{
		if (num <= 0)
		{
			return "";
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < num; i++)
		{
			sb.append(element);
		}
		return sb.toString();
	}
	/**
	 * 从右或左加空格
	 * @param strIn String
	 * @param totalLength int
	 * @param isRightAlign boolean
	 * @return String
	 */
	public static String getFillString(String strIn, int totalLength, boolean isRightAlign)
	{
		int spaceLength = 0;
		String spaces = null;
		String strOut = null;

		if (strIn == null)
		{
			strIn = "";
		}

		spaceLength = totalLength - strIn.length();

		if (spaceLength < 0)
		{
			spaceLength = 0;
		}
		spaces = StringUtil.getStrSpace(spaceLength);

		if (isRightAlign)
		{
			strOut = spaces + strIn;
		}
		else
		{
			strOut = strIn + spaces;

		}
		return strOut;
	}
	/**
	 * 以String类型返回错误抛出的堆栈信息
	 * @param t Throwable
	 * @return String
	 */
	public static String getStackTrace(Throwable t)
	{
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		t.printStackTrace(pw);
		return sw.toString();
	}
	/**
	 * 转换字符串第一个字符为大写
	 * @param str String
	 * @return String
	 */
	public static String getStrByUpperFirstChar(String str)
	{
		try
		{
			return str.substring(0, 1).toUpperCase() + str.substring(1);
		}
		catch (Exception e)
		{
			return "";
		}

	}
	/**
	 * 转换字符串第一个字符为小写
	 * @param str String
	 * @return String
	 */
	public static String getStrByLowerFirstChar(String str)
	{
		try
		{
			return str.substring(0, 1).toLowerCase() + str.substring(1);
		}
		catch (Exception e)
		{
			return "";
		}

	}
	/**
	 * 通过字符串转换成相应的整型，并返回。
	 * @param strValue String 待转换的字符串
	 * @return int 转换完成的整型
	 * */
	public static int getStrToInt(String strValue)
	{
		if (null == strValue)
		{
			return 0;
		}
		int iValue = 0;
		try
		{
			iValue = new java.lang.Integer(strValue.trim()).intValue();
		}
		catch (Exception ex)
		{
			iValue = 0;
		}
		return iValue;
	}

	/**
	 * 通过字符串转换成相应的DOUBLE，并返回。
	 * @param strValue String 待转换的字符串
	 * @return double 转换完成的DOUBLE
	 * */
	public static double getStrToDouble(String strValue)
	{
		if (null == strValue)
		{
			return 0;
		}
		double dValue = 0;
		try
		{
			dValue = Double.parseDouble(strValue.trim());
		}
		catch (Exception ex)
		{
			dValue = 0;
		}
		return dValue;
	}

	/**
	 * 通过字符串转换成相应的短整型，并返回。
	 * @param strValue String 待转换的字符串
	 * @return short 转换完成的短整型
	 * */
	public static short getStrToShort(String strValue)
	{
		if (null == strValue)
		{
			return 0;
		}
		short iValue = 0;
		try
		{
			iValue = new java.lang.Short(strValue.trim()).shortValue();
		}
		catch (Exception ex)
		{
			iValue = 0;
		}
		return iValue;
	}

	/**
	 * 通过字符串转换成相应的长整型，并返回。
	 * @param strValue String 待转换的字符串
	 * @return long 转换完成的长整型
	 * */
	public static long getStrToLong(String strValue)
	{
		if (null == strValue)
		{
			return 0;
		}
		long lValue = 0;
		try
		{
			lValue = new java.lang.Long(strValue.trim()).longValue();
		}
		catch (Exception ex)
		{
			lValue = 0;
		}
		return lValue;
	}

	public static String toLengthForEn(String str, int length)
	{
		if (null != str)
		{
			if (str.length() <= length)
			{
				return str;
			}
			else
			{
				str = str.substring(0, length - 2);
				str = str + "..";
				return str;
			}
		}
		else
		{
			return "";
		}
	}

	/**
	  * 降字符串转换成给定长度的字符串，如超出的话截断，并在最后以两个点结尾
	  * @param str String
	  * @param length int
	  * @return String
	  */
	public static String toLengthForIntroduce(String str, int length)
	{
		str = delTag(str);

		byte[] strByte = str.getBytes();
		int byteLength = strByte.length;
		char[] charArray;
		StringBuffer buff = new StringBuffer();
		if (byteLength > (length * 2))
		{
			charArray = str.toCharArray();
			int resultLength = 0;
			for (int i = 0; i < charArray.length; i++)
			{
				resultLength += String.valueOf(charArray[i]).getBytes().length;
				if (resultLength > (length * 2))
				{
					break;
				}
				buff.append(charArray[i]);

			}
			buff.append("..");
			str = buff.toString();
		}

		//		str = replace(str, "'", "\\'");
		str = replace(str, "\"", "\\\"");
		str = replace(str, "，", ",");
		return str;

	}

	public static String delTag(String str)
	{
		str = str + "<>";
		StringBuffer buff = new StringBuffer();
		int start = 0;
		int end = 0;

		while (str.length() > 0)
		{
			start = str.indexOf("<");
			end = str.indexOf(">");
			if (start > 0)
			{
				buff.append(str.substring(0, start));
			}
			if (end > 0 && end <= str.length())
			{
				str = str.substring(end + 1, str.length());
			}
			else
			{
				str = "";
			}

		}
		String result = buff.toString();

		while (result.startsWith(" "))
		{

			result = result.substring(result.indexOf(" ") + 1, result.length());

		}
		return result;

	}

	public static final String replace(String line, String oldString, String newString)
	{
		if (line == null)
		{
			return null;
		}
		int i = 0;
		if ((i = line.indexOf(oldString, i)) >= 0)
		{
			char[] line2 = line.toCharArray();
			char[] newString2 = newString.toCharArray();
			int oLength = oldString.length();
			StringBuffer buf = new StringBuffer(line2.length);
			buf.append(line2, 0, i).append(newString2);
			i += oLength;
			int j = i;
			while ((i = line.indexOf(oldString, i)) > 0)
			{
				buf.append(line2, j, i - j).append(newString2);
				i += oLength;
				j = i;
			}
			buf.append(line2, j, line2.length - j);
			return buf.toString();
		}
		return line;

	}
	//	Replace
	public static String Replace(String source, String oldString, String newString)
	{
		if (source == null)
		{
			return null;
		}
		StringBuffer output = new StringBuffer();
		int lengOfsource = source.length();
		int lengOfold = oldString.length();
		int posStart = 0;
		int pos;
		while ((pos = source.indexOf(oldString, posStart)) >= 0)
		{
			output.append(source.substring(posStart, pos));
			output.append(newString);
			posStart = pos + lengOfold;
		}
		if (posStart < lengOfsource)
		{
			output.append(source.substring(posStart));
		}
		return output.toString();
	}

	//此函数前台使用中，请勿随便修改，不然会造成显示混乱(以前修改版本在下方注释中)
	public static String toHtml(String s)
	{
		s = Replace(s, "<", "&lt;");
		s = Replace(s, ">", "&gt;");
		s = Replace(s, "\t", "    ");
		s = Replace(s, "\r\n", "\n");
		s = Replace(s, "\n", "<br>");
		//s = Replace(s, " ", "&nbsp;");
		s = Replace(s, "'", "&#39;");
		s = Replace(s, "\"", "&quot;");
		s = Replace(s, "\\", "&#92;");
		s = Replace(s, "%", "％");
		//	s = Replace(s, "&", "&amp;");
		return s;
	}
	//	逆
	public static String unHtml(String s)
	{

		//s = Replace(s, "&lt;", "<");
		//s = Replace(s, "&gt;", ">");
		//		s = Replace(s, "    ", "\t");
		//		s = Replace(s, "\n", "\r\n");
		s = Replace(s, "<br>", "\n");
		//		s = Replace(s, "&nbsp;", " ");
		//		s = Replace(s, "&amp;", "&");
		//		s = Replace(s, "&#39;", "'");
		//		s = Replace(s, "&#92;", "\\");
		//		s = Replace(s, "％", "%");
		return s;
	}

	//	此函数后台使用中，请勿随便修改，不然会造成显示混乱(以前修改版本在下方注释中)
	public static String toHtmlBack(String s)
	{
		//显示
		s = Replace(s, "&", "&amp;");
		s = Replace(s, "\\", "&#92;");
		s = Replace(s, "\"", "&quot;");
		s = Replace(s, "<", "&lt;");
		s = Replace(s, ">", "&gt;");
		s = Replace(s, "\t", "    ");
		s = Replace(s, "\r\n", "\n");
		//		s = Replace(s, "\n", "<br>");
//		s = Replace(s, " ", "&nbsp;");
		//		s = Replace(s, "'", "&#39;");
		//		s = Replace(s, "%", "%");

		return s;
	}
	//	逆
	public static String unHtmlBack(String s)
	{
		s = Replace(s, "&lt;", "<");
		s = Replace(s, "&gt;", ">");
		s = Replace(s, "    ", "\t");
		s = Replace(s, "\n", "\r\n");
		s = Replace(s, "<br>", "\n");
		s = Replace(s, "&nbsp;", " ");
		s = Replace(s, "&amp;", "&");
		s = Replace(s, "&#39;", "'");
		s = Replace(s, "&#92;", "\\");
		s = Replace(s, "％", "%");
		return s;
	}
	/*
	public static String toHtml(String s)
	{
		//显示
		s = Replace(s, "&", "&amp;");
		s = Replace(s, "\\", "&#92;");
		s = Replace(s, "\"", "&quot;");
		s = Replace(s, "<", "&lt;");
		s = Replace(s, ">", "&gt;");
		s = Replace(s, "\t", "    ");
		s = Replace(s, "\r\n", "\n");
	//		s = Replace(s, "\n", "<br>");
		s = Replace(s, " ", "&nbsp;");
	//		s = Replace(s, "'", "&#39;");
	//		s = Replace(s, "%", "%");
		
		return s;
	}
	
	public static String unHtml(String s)
	{
		s = Replace(s, "&lt;", "<");
		s = Replace(s, "&gt;", ">");
		s = Replace(s, "    ", "\t");
		s = Replace(s, "\n", "\r\n");
		s = Replace(s, "<br>", "\n");
		s = Replace(s, "&nbsp;", " ");
		s = Replace(s, "&amp;", "&");
		s = Replace(s, "&#39;", "'");
		s = Replace(s, "&#92;", "\\");
		s = Replace(s, "％", "%");
		return s;
	}
	*/
	//判断是否含有中文，如果含有中文返回ture
	public static boolean containsChinese(String str) throws UnsupportedEncodingException
	{

		if (str.length() < (str.getBytes()).length)
			return true;

		return false;

		//	  for (int i = 0; i < username.length(); i++) {
		//		String unit=Character.toString(username.charAt(i));
		//		byte[] unitByte=unit.getBytes("GBK");
		////  		((unitByte[0]+256)*256 + (unitByte[1]+256)) <= 0xFEFE)
		//	   if (unitByte.length == 2)
		//		{
		//		  return true;
		//		}
		//	  }
		//	  return false;

	}
	//判断是否含有中文，如果含有中文返回ture
	public static boolean isContainChinese(String str) throws UnsupportedEncodingException
	{
		Pattern pattern=Pattern.compile("[\u4e00-\u9fa5]");   
		Matcher matcher=pattern.matcher(str);   
		return matcher.find();
	}
	public static boolean isEmpty(String str)
	{
		if (str == null)
			return true;
		return "".equals(str.trim());
	}

	public static String[] split(String str1, String str2)
	{
		return org.apache.commons.lang.StringUtils.split(str1, str2);
	}

	public static String left(String str, int length)
	{
		return org.apache.commons.lang.StringUtils.left(str, length);
	}
	
	/** 
	 * 计算字符串长度.   
	 * 一个汉字或日韩文长度为2,英文字符长度为1
	 * 如果给定的字符串为null,返回0.   
	 * @author:Pablo3518
	 * @date:2009-4-29
	 * @param str 待计算长度的字符串
	 * @return    字符串长度
	 */
	public static int strlen(String str) {
		if (str == null || str.trim().length() <= 0) {
			return 0;
		}
		
		int len = 0;

		char c;
		for (int i = str.length() - 1; i >= 0; i--) {
			c = str.charAt(i);
			if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')
					|| (c >= 'A' && c <= 'Z')) {//字母, 数字   
				len++;
			} else {
				if (Character.isLetter(c)) { //中文   
					len += 2;
				} else { //符号或控制字符   
					len++;
				}
			}
		}

		return len;
	}

	/**
	 * 截取一段字符的长度,不区分中英文,如果数字不正好，则少取一个字符位。在尾部拼上省略号等文字。
	 * @author:Pablo3518
	 * @date:2009-4-29
	 * @param origin 原始字符串
	 * @param len 截取长度(一个汉字长度按2算的)
	 * @param more 长度过长的省略字符
	 * @return
	 */
	public static String substrings(String origin, int len, String more) {
		if (null == origin || origin.trim().length() < 1 || len < 1)
			return "";
		byte[] strByte = new byte[len];
		if (len > StringUtil.strlen(origin)) {
			return origin;
		}
		System.arraycopy(origin.getBytes(), 0, strByte, 0, len);
		int count = 0;
		for (int i = 0; i < len; i++) {
			int value = (int) strByte[i];
			if (value < 0) {
				count++;
			}
		}
		if (count % 2 != 0) {
			--len;
		}
		int n = count / 2;
		String retS = "";
		if(null == more && more.trim().length() < 1){
			more = "";
		}
		retS = origin.substring(0, len - n) + more;

		return retS;
	}
	
	/**
	 * 截取一段字符的长度,不区分中英文,如果数字不正好，则少取一个字符位。
	 * @author:Pablo3518
	 * @date:2009-4-29
	 * @param origin 原始字符串
	 * @param len 截取长度(一个汉字长度按2算的)
	 * @return
	 */
	public static String substrings(String origin, int len) {
		if (null == origin || origin.trim().length() < 1 || len < 1)
			return "";
		byte[] strByte = new byte[len];
		if (len > StringUtil.strlen(origin)) {
			return origin;
		}
		System.arraycopy(origin.getBytes(), 0, strByte, 0, len);
		int count = 0;
		for (int i = 0; i < len; i++) {
			int value = (int) strByte[i];
			if (value < 0) {
				count++;
			}
		}
		if (count % 2 != 0) {
			--len;
		}
		int n = count / 2;
		String retS = "";
		retS = origin.substring(0, len - n);

		return retS;
	}
	
	/**
	 * 根据输入的长度截取字符串，单个单词超过输入长度的强制加<BR>换行
	 * @param str 输入的字符串
	 * @param len 输入的长度
	 * @return 处理过后的字符串
	 */
	public static String truncateStr(String str, int len)
	{
		if (str != null && !("").equalsIgnoreCase(str))
		{

			String strs[] = str.split(" ");
			StringBuffer buff = new StringBuffer();
			if (strs.length > 0)
			{
				for (int i = 0; i < strs.length; i++)
				{
					StringBuffer temp = new StringBuffer();
					while (strs[i].length() > len)
					{
						temp.append(strs[i].substring(0, len) + "<BR>");
						strs[i] = strs[i].substring(len);
					}
					temp.append(strs[i]);
					buff.append(temp.toString() + " ");
				}

			}
			return buff.toString();
		}
		else
		{
			return "";
		}
	}
	
	public static String truncateStr2(String str, int len)
	{
		if (str != null && !("").equalsIgnoreCase(str) && len!=0)
		{
			String strs[] = str.split(" ");
			
			StringBuffer buff = new StringBuffer();
			for (int i = 0; i < strs.length; i++)
			{
				StringBuffer temp = new StringBuffer();
				String tempstr = "";
				while (strs[i].length() > len)
				{
					tempstr = strs[i].substring(0, len);
					tempstr = tempstr.replaceAll(" ","&nbsp; ");
					tempstr = tempstr.replaceAll("<","&lt; ");
					tempstr = tempstr.replaceAll("\n","<br> ").replaceAll("\"","&quot; ").replaceAll("'","&#39; ");
					tempstr = tempstr + "<br>";
					temp.append(tempstr);
					
					strs[i] = strs[i].substring(len);
				}
				tempstr = strs[i];
				tempstr = tempstr.replaceAll(" ","&nbsp; ");
				tempstr = tempstr.replaceAll("<","&lt; ");
				tempstr = tempstr.replaceAll("\n","<br> ").replaceAll("\"","&quot; ").replaceAll("'","&#39; ");
								
				temp.append(tempstr);
				buff.append(temp.toString() + " ");
			}
			
			if(buff.length() > 0)
				return buff.toString().substring(0,buff.length()-1);
			else
				return str;
		}
		else
		{
			return "";
		}
	}
	public static String GBKtoUTF8(String l_S_Source) throws UnsupportedEncodingException
	{
		String l_S_Desc = "";
		if (l_S_Source != null && !l_S_Source.trim().equals(""))
		{
			byte l_b_Proc[] = l_S_Source.getBytes("GBK");
			l_S_Desc = new String(l_b_Proc, "UTF-8");
		}
		return l_S_Desc;
	}
	
	/**
	 * 编码转换，从unicode转换为GBK
	 * @param str 输入字符串
	 * @return str编码转换后的字符串
	 * @throws UnsupportedEncodingException
	 */
	public static String unicodeToGB(String l_S_Source) throws UnsupportedEncodingException
	{
		String l_S_Desc = "";
		if (l_S_Source != null && !l_S_Source.trim().equals(""))
		{
			byte l_b_Proc[] = l_S_Source.getBytes("GBK");
			l_S_Desc = new String(l_b_Proc, "ISO8859_1");
		}
		return l_S_Desc;
	}
	/**
	 * 编码转换，从GBK转换为unicode
	 * @param str 输入字符串
	 * @return str 编码转换后的字符串
	 * @throws UnsupportedEncodingException
	 */
	public static String GBToUnicode(String l_S_Source) throws UnsupportedEncodingException
	{
		String l_S_Desc = "";
		if (l_S_Source != null && !l_S_Source.trim().equals(""))
		{
			byte l_b_Proc[] = l_S_Source.getBytes("ISO8859_1");
			l_S_Desc = new String(l_b_Proc, "GBK");
		}
		return l_S_Desc;
	}

	/**
	 * Escapes a <code>String</code> according the JavaScript string literal
	 * escaping rules. The resulting string will not be quoted.
	 * 
	 * <p>It escapes both <tt>'</tt> and <tt>"</tt>.
	 * In additional it escapes <tt>></tt> as <tt>\></tt> (to avoid
	 * <tt>&lt;/script></tt>). Furthermore, all characters under UCS code point
	 * 0x20, that has no dedicated escape sequence in JavaScript language, will
	 * be replaced with hexadecimal escape (<tt>\x<i>XX</i></tt>). 
	 */ 
	public static String javaScriptStringEnc(String s) {
		int ln = s.length();
		for (int i = 0; i < ln; i++) {
			char c = s.charAt(i);
			if (c == '"' || c == '\'' || c == '\\' || c == '>' || c < 0x20) {
				StringBuffer b = new StringBuffer(ln + 4);
				b.append(s.substring(0, i));
				while (true) {
					if (c == '"') {
						b.append("\\\"");
					} else if (c == '\'') {
						b.append("\\'");
					} else if (c == '\\') {
						b.append("\\\\");
					} else if (c == '>') {
						b.append("\\>");
					} else if (c < 0x20) {
						if (c == '\n') {
							b.append("\\n");
						} else if (c == '\r') {
							b.append("\\r");
						} else if (c == '\f') {
							b.append("\\f");
						} else if (c == '\b') {
							b.append("\\b");
						} else if (c == '\t') {
							b.append("\\t");
						} else {
							b.append("\\x");
							int x = c / 0x10;
							b.append((char)
									(x < 0xA ? x + '0' : x - 0xA + 'A'));
							x = c & 0xF;
							b.append((char)
									(x < 0xA ? x + '0' : x - 0xA + 'A'));
						}
					} else {
						b.append(c);
					}
					i++;
					if (i >= ln) {
						return b.toString();
					}
					c = s.charAt(i);
				}
			} // if has to be escaped
		} // for each characters
		return s;
	}
	
	
	private static StringUtil instance = null;
	
	public static synchronized StringUtil getInstance()
	{
		if (instance == null)
		{
			instance = new StringUtil();
		}
		return instance;
	}
	/**
	 * 将多个连续空格替换为一个,"a  b"-->"a b"
	 * @param src
	 * @return
	 * @author WilliamLau
	 * @desc
	 */
	public static String trimContinuousSpace(String src){
		return src.replaceAll("\\s+", " ");
	}
	public static String replace(String src, String target, String rWith, int maxCount)
	{
		return org.apache.commons.lang.StringUtils.replace(src, target, rWith, maxCount);
	}

	public static boolean equals(String str1, String str2)
	{
		return org.apache.commons.lang.StringUtils.equals(str1, str2);
	}

	public static boolean isAlphanumeric(String str)
	{
		return org.apache.commons.lang.StringUtils.isAlphanumeric(str);
	}

	public static boolean isNumeric(String str)
	{
		return org.apache.commons.lang.StringUtils.isNumeric(str);
	}

	public static String[] stripAll(String[] strs)
	{
		return org.apache.commons.lang.StringUtils.stripAll(strs);
	}
	public static void main(String[] args)
	{
		//		String testStr = "<input > &    \\r\\n    \\n", newStr;
		//		newStr = toHtml(testStr);
		//		System.out.println(testStr);
		//		System.out.println(newStr);
		//		System.out.println(unHtml(newStr));
		//		String aaa = "中文中文中文bcdefghijk";

		//        		String bbb = toLengthForIntroduce(aaa,5);
		//		System.out.println(bbb);
		//		Object aa = null;
		//		String bb = "  aaaa  ";
		System.out.println(StringUtil.getWSURL()); ;
		try
		{
			//			System.out.println(getNotNullStr(aa));
			//			System.out.println(getNotNullStr(bb));
			//			System.out.println(containsChinese(aaa));
			//			System.out.println(containsChinese(aaa));
			//			System.out.println(containsChinese(bb));
			//String abc = null;
			//System.out.println(toLengthForEn(abc, 3));
			String num = "05";
			if(num.indexOf(".")==-1){
				num = num + ".00";
			}
			//System.out.println(num);
			//System.out.println(toFloatNumber("5.2"));
		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}

	}
//
	public static String toFloatNumber(String num) {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		return nf.format(Double.parseDouble(num));
	}
	
	/**
	 * 将字符串数组 str[] 转换为以逗号隔开的 字符串 str
	 * @author:Shen yanyan
	 * @date:2009-3-19
	 * @param s
	 * @return
	 */
	public static String getString(String[] s){
		StringBuffer sb = new StringBuffer() ;
		for (int i = 0; i < s.length; i++) {
			sb.append(s[i]) ;
			if(i!=s.length-1){
				sb.append(",") ;
			}
		}
		return sb.toString() ;
	}
	
	/**
	 * 验证显示网址
	 * @author:Shen yanyan
	 * @date:2009-3-23
	 * @param s
	 * @return
	 */
	public static boolean isDisplayUrl(String s){
		boolean flag = false ;
		int index = s.indexOf(".") ;
		int lastIndex = s.lastIndexOf(".") ;
		int len = s.length() ;
		if(index>0 && lastIndex<len-2){
			flag = true ;
		}
		return flag ;
	}
	
	/**
	 * 验证目标网址
	 * @author:Shen yanyan
	 * @date:2009-3-23
	 * @param s
	 * @return
	 */
	public static boolean isDestinationUrl(String s){
		boolean flag = false ;
		int index = s.indexOf(".") ;
		int lastIndex = s.lastIndexOf(".") ;
		int len = s.length() ;
		if(index>7 && lastIndex<len-2 && s.startsWith("http://") && (s.indexOf("http://")==s.lastIndexOf("http://"))){
			flag = true ;
		}
		return flag ;
	}
	
	
	/**
	 * 比较并验证二个日期相差几天
	 * @author:Wangzheng
	 * @date:2009-5-12
	 * @param Long
	 * @return 二个日期相差几天（1天，2天）
	 */
	public static Long GapDate(String beginDate,String endDate){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		if(!isValid(beginDate) && !isValid(endDate)) return new Long("0");
		
		try {
			return (sf.parse(sf.format(sf.parse(beginDate))).getTime()-sf.parse(sf.format(sf.parse(endDate))).getTime())/(24*60*60*1000);
		} catch (ParseException e) {
			e.printStackTrace();
			return new Long("0");
		}
	}
	
	/**
	 * 验证一个数是否是小数并保留二位小数
	 * @author:Wangzheng
	 * @date:2009-5-12
	 * @param str
	 * @return 是小数:true ,不是小数:false
	 */
	public static boolean isZDecimal(String str){
		if(!isValid(str)) return false;
		if(str.trim().matches("^\\d+$")){
			return true;
		}else if(str.trim().matches("^\\d+(\\.\\d{1,2})?$")){
			return true;
		}
		return false;
	}
	
	/**
	 * 验证一个数是否是正浮点数
	 * @author:Wangzheng
	 * @date:2009-5-6
	 * @param str
	 * @return 是浮点数:true ,不是浮点数:false
	 */
	public static boolean isZFloat(String str){
		if(!isValid(str)) return false;
		
		if(str.trim().matches("^(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$")){
			return true;
		}
		return false;
	}
	
	/**
	 * 验证一个网址（带HTTP：//）
	 * @author:Wangzheng
	 * @date:2009-6-30
	 * @param str
	 * @return 有效网址:true ,无效网址:false
	 */
	public static boolean isHttpurl(String str){
		if(!isValid(str)) return false;
		
		if(str.trim().matches("http://(([a-zA-z0-9]|-){1,}\\.){1,}[a-zA-z0-9]{1,}-*")){
			return true;
		}
		return false;
	}
	/**
	 * 验证一个网址（不带HTTP：//）
	 * @author:Wangzheng
	 * @date:2009-6-30
	 * @param str
	 * @return 有效网址:true ,无效网址:false
	 */
	public static boolean isUrl(String str){
		if(!isValid(str)) return false;
		
		if(str.trim().matches("(([a-zA-z0-9]|-){1,}\\.){1,}[a-zA-z0-9]{1,}-*")){
			return true;
		}
		return false;
	}
	
	/**
	 * 将一个字符串中的TABLE替换成逗号
	 * @author:Wangzheng
	 * @date:2009-5-6
	 * @param s 字符串
	 * @return 返回以逗号为分隔符的字符串
	 */
	public static String tabToComma(String s)
	{
		s = Replace(s, "\t", ",");
		return s;
	}
	/**
	 * 去掉首尾空格，多个连续空格只保留一个
	 * @author:Shen yanyan
	 * @date:2009-3-23
	 * @param src
	 * @return
	 */
	public static String optimizeTrimSpace(String src){
		return src.trim().replaceAll("\\s+", " ");
	}
	
	/**
	 * 去掉首尾空格，多个连续空格只保留一个
	 * @author:Shen yanyan
	 * @date:2009-3-23
	 * @param src
	 * @return
	 */
	public static boolean afterOptimizeIsNull(String src){
		String s = optimizeTrimSpace(src) ;
		return isValid(s) ;
	}
	
	/**
	 * 去掉首尾空格，多个连续空格只保留一个后再截取
	 * @author:Shen yanyan
	 * @date:2009-3-23
	 * @param src
	 * @param index
	 * @return
	 */
	public static String afterOptimizeSub(String src, int index){
		return optimizeTrimSpace(src).substring(0,index) ;
	}
	
	/**
	 * 判断是否是字母数字下划线组成，并以字母数字开头
	 * @author:Shen yanyan
	 * @date:2009-7-24
	 * @param src
	 * @return
	 */
	public static boolean isCharAndNum(String src){
		if(!isValid(src)){
			return false ;
		}else{
			String rex = "^[0-9a-zA-Z]{1}[0-9a-zA-Z\\_]+$" ;
			Pattern p = Pattern.compile(rex) ;
			Matcher m = p.matcher(src) ;
			return m.find() ;
		}
	}
	
	/**
	 * 判断是否邮箱
	 * @author:Shen yanyan
	 * @date:2009-7-24
	 * @param src
	 * @return
	 */
	public static boolean isEmail(String src){
		String rex = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$" ;
		Pattern p = Pattern.compile(rex) ;
		Matcher m = p.matcher(src) ;
		return m.find() ;
	}
	
	/**
	 * 判断是否含有空格
	 * @author:Shen yanyan
	 * @date:2009-7-24
	 * @param src
	 * @return
	 */
	public static boolean isHaveTrim(String src){
		String rex = " " ;
		Pattern p = Pattern.compile(rex) ;
		Matcher m = p.matcher(src) ;
		return m.find() ;
	}
	
	public static boolean isNumber(String number){
		int index = number.indexOf(".");
		if(index<0){
			return StringUtils.isNumeric(number);
		}else{
			String num1 = number.substring(0,index);
			String num2 = number.substring(index+1);			
			return StringUtils.isNumeric(num1) && StringUtils.isNumeric(num2);
		}
	}	

	/*public static void main(String[] args){
		System.out.println("");
	}*/
	public void test(){
		try {
			print(StringUtil.URLEncoder("fasdf全中国"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 中文转成浏览器识别的编码
	 * @author:Derek
	 * @date:2011-2-9
	 * @param src
	 * @return
	 */
	public static String URLEncoder(String src){
		if(StringUtil.checkNotNull(src)){
			//byte[] b =src.getBytes();
			try {
				return  java.net.URLEncoder.encode(src,UTF_8);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return src ;
			}
		}else {
			return src ;
		}
	}
	/**
	 * 反转{@link URLEncoder(String src)} 的编码
	 * @author:Derek
	 * @date:2011-2-9
	 * @param src
	 * @return
	 */
	public static String URLDecoder(String src){
		if(StringUtil.checkNotNull(src)){
			//byte[] b =src.getBytes();
			try {
				return  java.net.URLDecoder.decode(src,UTF_8);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return src ;
			}
		}else {
			return src ;
		}
	}
	public static void print(String msg){
		if(false){
			System.err.println(">>: "+msg);
		}
	}
	public static void print(Object o){
		print(o.toString());
	}
	/**
	 * 获取webservices 地址
	 * @return
	 */
	public static String getWSURL(){
		ResourceBundle conf = ResourceBundle.getBundle("conf");
		return conf.getString("WS.url") ;
	}
	
}
