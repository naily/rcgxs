package com.ghy.util;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 模拟html表单提交数据
 */
public class HttpMultipartRequest {
	//每个post参数之间的分隔
	static final String BOUNDARY = "----------V2ymHFg03ehbqgZCaKO6jy";

	public static void main(String[] args) {
		
		List<String[]> stringParams = new ArrayList<String[]>();
		stringParams.add(new String[]{"do", "justDoIt"});
		stringParams.add(new String[]{"myname", "aa我是一个测试cc123"});
		stringParams.add(new String[]{"description", "bb我是码农我是一个测试我是一个测试cc567"});
		
		String url = "http://192.168.1.143:8087/cjj/servlet/NhbUploadImg?id=1&subjectCode=11010406000&wh=ggxx" ;
		String file = "D:/Java/Resin/Stable/resin-pro-3.1.5/webapps/cxcjs/uploadfile/11ee8a27-4020-4cf4-ac05-4a1f3b66bd14.jpg" ;
		List<String[]> fileParams = new ArrayList<String[]>();
		fileParams.add(new String[]{"pic", "11ee8a27-4020-4cf4-ac05-4a1f3b66bd14.jpg", "application/jpg", file});
		
		
		HttpMultipartRequest req = new HttpMultipartRequest(url, stringParams, fileParams);
		try {
			byte[] response = req.sendPost();
			System.out.println(new String(response));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 连接的地址
	private String urlStr;
	// 文字post项集 strParams 1:key 2:value
	private List<String[]> strParams;
	// 文件的post项集 fileParams 1:fileField, 2.fileName, 3.fileType, 4.filePath
	private List<String[]> fileParams;

	/**
	 * 建立一个request连接
	 * @param urlStr
	 * @param strParams 1:key 2:value
	 * @param fileParams 1:fileField, 2.fileName, 3.fileType, 4.filePath
	 */
	public HttpMultipartRequest(String urlStr, List<String[]> strParams, List<String[]> fileParams) {
		this.urlStr = urlStr;
		this.strParams = strParams;
		this.fileParams = fileParams;

	}

	/**
	 * 向服务器发送post请求
	 * @return byte[]
	 * @throws Exception
	 */
	public byte[] sendPost() throws Exception {
		//http连接器
		HttpURLConnection hc = null;
		//byte输出流，用来读取服务器返回的信息
		ByteArrayOutputStream bos = null;
		//输入流，用来读取服务器返回的信息
		InputStream is = null;
		//保存服务器返回的信息的byte数组
		byte[] res = null;

		try {
			URL url = new URL(urlStr);
			hc = (HttpURLConnection) url.openConnection();

			hc.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
			hc.setRequestProperty("Charsert", "UTF-8");
			// 发送POST请求必须设置如下两行
			hc.setDoOutput(true);
			hc.setDoInput(true);
			hc.setUseCaches(false);
			hc.setRequestMethod("POST");

			OutputStream dout = hc.getOutputStream();
			////1.先写文字形式的post流
			//头
			String boundary = BOUNDARY;
			//中
			StringBuffer resSB = new StringBuffer("/r/n");
			//尾
			String endBoundary = "/r/n--" + boundary + "--/r/n";
			//strParams 1:key 2:value
			if(strParams != null){
				for(String[] parsm : strParams){
					String key = parsm[0];
					String value = parsm[1];
					resSB.append("Content-Disposition: form-data; name=\"")
					.append(key).append("\"/r/n").append("/r/n")
					.append(value).append("/r/n").append("--").append(boundary).append("/r/n");
				}
			}
			String boundaryMessage = resSB.toString();
			System.out.println(boundaryMessage);
			
			//写出流
			dout.write( ("--"+boundary+boundaryMessage).getBytes("utf-8") );
			
			//2.再写文件开式的post流
			//fileParams 1:fileField, 2.fileName, 3.fileType, 4.filePath
			resSB = new StringBuffer();
			if(fileParams != null){
				for(int i=0, num=fileParams.size(); i<num; i++){
					String[] parsm = fileParams.get(i);
					String fileField = parsm[0];
					String fileName = parsm[1];
					String fileType = parsm[2];
					String filePath = parsm[3];
					
					resSB.append("Content-Disposition: form-data; name=\"")
					.append(fileField).append("\"; filename=\"")
					.append(fileName).append("\"/r/n").append("Content-Type: ").append(fileType).append("/r/n/r/n");
					
					System.out.println(resSB.toString());
					dout.write( resSB.toString().getBytes("utf-8") );
					
					//开始写文件
					File file = new File(filePath);
					DataInputStream in = new DataInputStream(new FileInputStream(file));
					int bytes = 0;
					byte[] bufferOut = new byte[1024 * 5];
					while ((bytes = in.read(bufferOut)) != -1) {
						dout.write(bufferOut, 0, bytes);
					}
					
					if(i<num-1){
						dout.write( endBoundary.getBytes("utf-8") );
					}
					
					in.close();
				}
				
			}
			
			//3.最后写结尾
			dout.write( endBoundary.getBytes("utf-8") );
			
			dout.close();
			
			int ch;

			is = hc.getInputStream();
			
			bos = new ByteArrayOutputStream();
			while ((ch = is.read()) != -1) {
				bos.write(ch);
			}
			res = bos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bos != null)
					bos.close();

				if (is != null)
					is.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return res;
	}


}
