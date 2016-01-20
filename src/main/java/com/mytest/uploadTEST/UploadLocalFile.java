package com.mytest.uploadTEST;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 * 上传本地文件
 * @author cyz
 *
 */
public class UploadLocalFile {
	
	private FTPClient ftpClient;
	//FTP服务器基本连接信息
	private	static final String FTP_HOST = "";//服务器地址
	private static final Integer FTP_PORT = 21;//端口号
	private static final String FTP_USERNAME ="";//服务器帐号
	private static final String FTP_PASSWORD = "";//服务器密码
	
	private static final String FTP_UPLOAD_PATH = "http://portal/img";//服务器内文件上传保存路径
	
	public static final String URL_PREFIX_HTTP = "http://";
	
	private UploadLocalFile(){
		if(ftpClient==null){
			ftpClient= new FTPClient();
			try {
				// ftpClient.setControlEncoding("UTF-8");
				//FIXME: 设定为UTF-8以后，Editor中对刚上传的文件依然態预览成功，刷新后可以正常显示，但是通过普通FTP客户端，不能正确显示UTF-8文件名
				ftpClient.setControlEncoding("GBK");
				ftpClient.connect(FTP_HOST, FTP_PORT); // 连接
				ftpClient.login(FTP_USERNAME, FTP_PASSWORD); // 登录
				// 查看连接状态
				int reply = ftpClient.getReplyCode();
				if (!FTPReply.isPositiveCompletion(reply)) {
					ftpClient.disconnect();
				}
				ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			} catch (IOException e) {
				System.err.println("登录ftp服务器【" + FTP_HOST + "】失败");
				e.printStackTrace();
			}
			System.err.println("ftp连接成功");
			}
	}
	
	
	// 从指定目录路径上传到ftp
	public static String uploadToFtp(String uploadPath,String imgUrl, String ftpPath){
		StringBuffer sbf = new StringBuffer();
		String[] imgs =  imgUrl.split("\\|");
		UploadFile ftpUtil=new UploadFile();
		for(int i=1;i<=imgs.length;i++){
			// 如果当前imgurl部位空并且不是HTTP网络图片
			if (!isBlank(imgs[i-1]) && imgs[i-1].indexOf(URL_PREFIX_HTTP) == -1) {
				sbf.append(ftpUtil.uploadLocalFile(uploadPath+File.separator+imgs[i-1], ftpPath));
				if(i != imgs.length){
					sbf.append("|");
				}
			}
		}
		ftpUtil.close();
		return sbf.toString();
	}
	
	//上传本地图片
	public String uploadLocalFile(String imgUrl, String ftpPath) {
		try {
			FileInputStream in = new FileInputStream(new File(imgUrl));  
			String fileName = imgUrl.substring(imgUrl.lastIndexOf(File.separator)+1);
			changePath("/http/portal/img/"+ftpPath+"/");
			ftpClient.storeFile(fileName, in);
			System.err.println("上传成功"); 
			return FTP_UPLOAD_PATH+"/"+ftpPath+"/"+fileName;
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("上传失败");  
		}
		return null;		
	}
	
	//切换目录
	public void changePath(String path){
		String[] arraypath = path.split("/");
		int i=0;
		while(i < arraypath.length){
			try {
				ftpClient.makeDirectory(arraypath[i]);
				ftpClient.changeWorkingDirectory(arraypath[i]);
			} catch (IOException e) {
				e.printStackTrace();
			}
			i++;
		}
	}
	
	//判断字符串是否为空
	public static boolean isBlank(Object str){
          return str==null || "".equals(str.toString().trim())||"null".equals(str.toString().trim());
	}
	
	/**
	 * 关闭ftp连接
	 * @return boolean
	 */
	public boolean close(){
		try{
			ftpClient.logout();
			ftpClient.disconnect();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
}
