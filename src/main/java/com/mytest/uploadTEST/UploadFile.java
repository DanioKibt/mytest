package com.mytest.uploadTEST;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;






public class UploadFile {
	
	private FTPClient ftpClient;
	
	public static final String URL_PREFIX_HTTP = "http://";
	
	public static final String UPLOAD_FILE_TEMP_DIR = "/upload";
	public static final String UPLOAD_FILE_TEMP_IMG_DIR = "/images";
	public static final String UPLOAD_FILE_TEMP_DOC_DIR = "/doc";
	public static final String UPLOAD_FILE_TEMP_XLS_DIR = "/xls";
	public static final String UPLOAD_FILE_TEMP_TXT_DIR = "/txt";
	public static final String UPLOAD_FILE_TEMP_OTHER_DIR = "/other";
	
	public static final String FILE_TYPE_IMG = "image";
	public static final String FILE_TYPE_DOC = "doc";
	public static final String FILE_TYPE_XLS = "xls";
	public static final String FILE_TYPE_TXT = "txt";
	
	public static final String FTP_NEWS_IMG = "newsimg";
	
	private static final String FTP_UPLOAD_PATH = "http://portal/img";//服务器内文件上传保存路径
	
	
	//FTP服务器基本连接信息
	private	static final String FTP_HOST = "";//服务器地址
	private static final Integer FTP_PORT = 21;//端口号
	private static final String FTP_USERNAME ="";//服务器帐号
	private static final String FTP_PASSWORD = "";//服务器密码
	
	//对象初始化启动ftp连接
	public UploadFile(){
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
	
	public void uploadFile(HttpServletRequest request,HttpServletResponse response){
		ArrayList<MultipartFile> files = this.getMultipartFiles(request);//解析客户端取出的文件
		List<String> imgurllist=new ArrayList<String>();
		for (MultipartFile file : files) {
			//获得文件名称
			String fileName = System.currentTimeMillis() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			uploadToTemp(getUploadFileTempDir(getDirByFileType(FILE_TYPE_IMG)), file, fileName);
			String uploadPath = getUploadFileTempDir(getDirByFileType(FILE_TYPE_IMG));//本地路径
			String imgurl=uploadToFtp(uploadPath, fileName,FTP_NEWS_IMG);//上传到ftp返回ftp访问路径
//			imgurllist.add(imgurl);
		}
	}
	
	/**
	 * 取出request中的所有上传文件
	 */
	public ArrayList<MultipartFile> getMultipartFiles(HttpServletRequest request){
		ArrayList<MultipartFile> files = new ArrayList<MultipartFile>();
		// 设置上下方文  
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        // 检查form是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
        	MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
        	Iterator<String> iter = multiRequest.getFileNames();
        	while (iter.hasNext()) {
        		MultipartFile file = multiRequest.getFile(iter.next());
        		if (file != null) {  
                    files.add(file); 
                }
        	}
        }
        return files;
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
	
	
	
	public static String getDirByFileType (String type) {
		StringBuffer buff = new StringBuffer(UPLOAD_FILE_TEMP_DIR);
		if (!isBlank(type)) {
			if (FILE_TYPE_IMG.equals(type)) {
				buff.append(UPLOAD_FILE_TEMP_IMG_DIR);
			} else if (FILE_TYPE_DOC.equals(type)) {
				buff.append(UPLOAD_FILE_TEMP_DOC_DIR);
			} else if (FILE_TYPE_XLS.equals(type)) {
				buff.append(UPLOAD_FILE_TEMP_XLS_DIR);
			} else if (FILE_TYPE_TXT.equals(type)) {
				buff.append(UPLOAD_FILE_TEMP_TXT_DIR);
			} else {
				buff.append(UPLOAD_FILE_TEMP_OTHER_DIR);
			}
		} else {
			buff.append(UPLOAD_FILE_TEMP_OTHER_DIR);
		}
		return buff.toString();
	}
	
	//判断字符串是否为空
	public static boolean isBlank(Object str){
          return str==null || "".equals(str.toString().trim())||"null".equals(str.toString().trim());
	}
	
	public String getUploadFileTempDir (String dir) {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession http= attr.getRequest().getSession(true); // true == allow create
		return http.getServletContext().getRealPath(dir);
	}
	
	
	
	// 复制文件项目路径下
	public static void uploadToTemp(String uploadPath,MultipartFile file, String fileName) {
		// 目录分割符File.separator
		File dest = new File(uploadPath+File.separator+fileName);
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}
		if (dest.exists()) {
			dest.delete();
		}
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
