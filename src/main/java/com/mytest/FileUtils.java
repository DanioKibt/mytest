package com.mytest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.sun.istack.internal.logging.Logger;

/**
 * 文件操作工具类
 * @author 罗恒
 *
 */
public class FileUtils {
	private static final Logger logger = Logger.getLogger(FileUtils.class);

	/**
	 * 获取文件扩展名
	 * 
	 * @param filename
	 * @return
	 */
	public static String getExtend(String filename) {
		return getExtend(filename, "");
	}

	/**
	 * 获取文件扩展名
	 * 
	 * @param filename
	 * @return
	 */
	public static String getExtend(String filename, String defExt) {
		//一、通过“.”进行字符串分割，通过“.”与分割后的数组数量来确定后缀是否存在
		String s[]=StringUtils.split(filename==null?"":filename, ".");
		int k=s.length;
		String ss=s[k-1];
		int u=filename.indexOf(".");
		if(k>=(u+1)&&u>0){
			System.err.println("s1:"+ss);
			return ss.toLowerCase();
		}
		return "";
		//二、通过获得最后一个“.”的位置来确定后缀
//		if ((filename != null) && (filename.length() > 0)) {
//			int i = filename.lastIndexOf('.');
//
//			if ((i > 0) && (i < (filename.length() - 1))) {
//				return (filename.substring(i + 1)).toLowerCase();
//			}
//		}
//		return defExt.toLowerCase();
	}

	public static void main(String[] args) {
		String s=getExtend("1.jsp");
		System.err.println("s2:"+s);
		System.err.println(isPicture("bmp"));
		System.err.println(getAttachTypeByExt(".txt"));
	}
	
	
	/**
	 * 获取文件扩展名(带逗号,即.jpg)
	 * 
	 * @param filename
	 * @return
	 */
	public static String getExtendWithDot(String filename, String defExt) {
		if ((filename != null) && (filename.length() > 0)) {
			int i = filename.lastIndexOf('.');

			if ((i > 0) && (i < (filename.length() - 1))) {
				return (filename.substring(i)).toLowerCase();
			}
		}
		return defExt.toLowerCase();
	}

	/**
	 * 获取文件扩展名(带逗号,即.jpg)
	 * 
	 * @param filename
	 * @return
	 */
	public static String getExtendWithDot(String filename) {
		return getExtendWithDot(filename, "");
	}

	/**
	 * 获取文件名称[不含后缀名]
	 * 
	 * @param
	 * @return String
	 */
	public static String getFilePrefix(String fileName) {
		int splitIndex = fileName.lastIndexOf(".");
		return fileName.substring(0, splitIndex).replaceAll("\\s*", "");
	}

	/**
	 * 获取文件名称[不含后缀名]
	 * 不去掉文件目录的空格
	 * @param
	 * @return String
	 */
	public static String getFilePrefix2(String fileName) {
		int splitIndex = fileName.lastIndexOf(".");
		return fileName.substring(0, splitIndex);
	}

	/**
	 * 判断文件是否为图片<br>
	 * <br>
	 * 
	 * @param filename
	 *            文件名<br>
	 *            判断具体文件类型<br>
	 * @return 检查后的结果<br>
	 * @throws Exception
	 */
	public static boolean isPicture(String filename) {
		// 文件名称为空的场合
		if (StringUtils.isEmpty(filename)) {
			// 返回不和合法
			return false;
		}
		//优化代码如下
		Map<String,String> strMap=new HashMap<String,String>();
		strMap.put("bmp", "0");
		strMap.put( "dib", "1");
		strMap.put("gif", "2" );
		strMap.put("jfif", "3" );
		strMap.put("jpe", "4");
		strMap.put("jpeg", "5");
		strMap.put("jpg", "6");
		strMap.put("png", "7");
		strMap.put("tif", "8");
		strMap.put("tiff", "9");
		strMap.put("ico", "10");
		return strMap.containsKey(filename);
		
		// 获得文件后缀名
		//String tmpName = getExtend(filename);
//		String tmpName = filename;
		// 声明图片后缀名数组
//		String imgeArray[][] = { { "bmp", "0" }, { "dib", "1" }, { "gif", "2" }, { "jfif", "3" }, { "jpe", "4" },
//				{ "jpeg", "5" }, { "jpg", "6" }, { "png", "7" }, { "tif", "8" }, { "tiff", "9" }, { "ico", "10" } };
		// 遍历名称数组
//		for (int i = 0; i < imgeArray.length; i++) {
//			// 判断单个类型文件的场合
//			if (imgeArray[i][0].equals(tmpName.toLowerCase())) {
//				return true;
//			}
//		}
//		return false;
	}

	/**
	 * 判断文件是否为DWG<br>
	 * <br>
	 * 
	 * @param filename
	 *            文件名<br>
	 *            判断具体文件类型<br>
	 * @return 检查后的结果<br>
	 * @throws Exception
	 */
	public static boolean isDwg(String filename) {
		// 文件名称为空的场合
		if (StringUtils.isEmpty(filename)) {
			// 返回不和合法
			return false;
		}
		// 获得文件后缀名
		String tmpName = getExtend(filename);
		// 声明图片后缀名数组
		if (tmpName.equals("dwg")) {
			return true;
		}
		return false;
	}

	/**
	 * 删除指定的文件
	 * 
	 * @param strFileName
	 *            指定绝对路径的文件名
	 * @return 如果删除成功true否则false
	 */
	public static boolean delete(String strFileName) {
		File fileDelete = new File(strFileName);

		if (!fileDelete.exists() || !fileDelete.isFile()) {
			return false;
		}
		return fileDelete.delete();
	}

	/**
	 * @author luoheng
	 * @createtime 2014年7月11日 下午9:34:09
	 * @Decription 通过后缀名(带点的),返回人为分类类型
	 *
	 * @param ext
	 * @return
	 * @throws BusinessException
	 */
	public static String getAttachTypeByExt(String ext) {
		String doc[]={".txt", ".doc", ".docx", ".xls",".xlsx", ".ppt", ".pptx", ".vsd",".wps",".dps", ".et"};
		List<String> docList = Arrays.asList(doc);
		String img[]={".bmp", ".gif", ".icon", ".png",".jpg",".jpeg", ".tif"};
		List<String> imgList = Arrays.asList(img);
		String video[]={".avi",".mpg",".mov", ".swf",".flv", ".mkv",".mp4", ".mp3", ".wav"};
		List<String> videoList = Arrays.asList(video);
		if(docList.contains(ext)){
			return "doc";
		}else if(imgList.contains(ext)){
			return "img";
		}else if(videoList.contains(ext)){
			return "video";
		}
		return "other";
		
//		String attachType = "other";
//		if (".txt".equals(ext) || ".doc".equals(ext) || ".docx".equals(ext) || ".xls".equals(ext)
//				|| ".xlsx".equals(ext) || ".ppt".equals(ext) || ".pptx".equals(ext) || ".vsd".equals(ext)
//				|| ".wps".equals(ext) || ".dps".equals(ext) || ".et".equals(ext)) {
//			attachType = "doc";
//		} else if (".bmp".equals(ext) || ".gif".equals(ext) || ".icon".equals(ext) || ".png".equals(ext)
//				|| ".jpg".equals(ext) || ".jpeg".equals(ext) || ".tif".equals(ext)) {
//			attachType = "img";
//		} else if (".avi".equals(ext) || ".mpg".equals(ext) || ".mov".equals(ext) || ".swf".equals(ext)
//				|| ".flv".equals(ext) || ".mkv".equals(ext) || ".mp4".equals(ext) || ".mp3".equals(ext)
//				|| ".wav".equals(ext)) {
//			attachType = "video";
//		}
//		return attachType;
	}

	/**
	 * 写文件
	 * @param fileName
	 * @param content
	 */
	public static void writeFile(String fileName, String content) {
		writeFile(fileName, content, "utf-8");
	}

	/**
	 * 写文件
	 * @param fileName
	 * @param content
	 * @param charset
	 */
	public static void writeFile(String fileName, String content, String charset) {
		try {
			createFolder(fileName, true);
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), charset));
			out.write(content);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 写文件
	 * @param fileName
	 * @param is
	 * @throws IOException
	 */
	public static void writeFile(String fileName, InputStream is) throws IOException {
		FileOutputStream fos = new FileOutputStream(fileName);
		byte[] bs = new byte[512];
		int n = 0;
		while ((n = is.read(bs)) != -1) {
			fos.write(bs, 0, n);
		}
		is.close();
		fos.close();
	}

	/**
	 * 读取文件
	 * @param fileName
	 * @return
	 */
	public static String readFile(String fileName) {
		try {
			File file = new File(fileName);
			String charset = getCharset(file);
			StringBuffer sb = new StringBuffer();
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), charset));
			String str;
			while ((str = in.readLine()) != null) {
				sb.append(str + "\r\n");
			}
			in.close();
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 判断路径是否存在
	 * @param dir
	 * @return
	 */
	public static boolean isDirExistFile(String dir) {
		boolean isExist = false;
		File fileDir = new File(dir);
		if (fileDir.isDirectory()) {
			File[] files = fileDir.listFiles();
			if ((files != null) && (files.length != 0)) {
				isExist = true;
			}
		}
		return isExist;
	}

	/**
	 * 判断文件是否存在
	 * @param fileName
	 * @return
	 */
	public static boolean isFileExist(String fileName) {
		File file = new File(fileName);
		return file.exists();
	}

	public static String getCharset(File file) {
		String charset = "GBK";
		byte[] first3Bytes = new byte[3];
		try {
			boolean checked = false;
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			bis.mark(0);
			int read = bis.read(first3Bytes, 0, 3);
			if (read == -1)
				return charset;
			if ((first3Bytes[0] == -1) && (first3Bytes[1] == -2)) {
				charset = "UTF-16LE";
				checked = true;
			} else if ((first3Bytes[0] == -2) && (first3Bytes[1] == -1)) {
				charset = "UTF-16BE";
				checked = true;
			} else if ((first3Bytes[0] == -17) && (first3Bytes[1] == -69) && (first3Bytes[2] == -65)) {
				charset = "UTF-8";
				checked = true;
			}
			bis.reset();

			if (!checked) {
				int loc = 0;
				while ((read = bis.read()) != -1) {
					loc++;
					if (read >= 240) {
						break;
					}
					if ((128 <= read) && (read <= 191))
						break;
					if ((192 <= read) && (read <= 223)) {
						read = bis.read();
						if ((128 > read) || (read > 191)) {
							break;
						}

					} else if ((224 <= read) && (read <= 239)) {
						read = bis.read();
						if ((128 > read) || (read > 191))
							break;
						read = bis.read();
						if ((128 > read) || (read > 191))
							break;
						charset = "UTF-8";
						break;
					}

				}

			}

			bis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return charset;
	}

	public static byte[] readByte(InputStream is) {
		try {
			byte[] r = new byte[is.available()];
			is.read(r);
			return r;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static byte[] readByte(String fileName) {
		try {
			FileInputStream fis = new FileInputStream(fileName);
			byte[] r = new byte[fis.available()];
			fis.read(r);
			fis.close();
			return r;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean writeByte(String fileName, byte[] b) {
		try {
			BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(fileName));
			fos.write(b);
			fos.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}
		return dir.delete();
	}

	public static void serializeToFile(Object obj, String fileName) {
		try {
			ObjectOutput out = new ObjectOutputStream(new FileOutputStream(fileName));
			out.writeObject(obj);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Object deserializeFromFile(String fileName) {
		try {
			File file = new File(fileName);
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
			Object obj = in.readObject();
			in.close();
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String inputStream2String(InputStream input, String charset) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(input, charset));
		StringBuffer buffer = new StringBuffer();
		String line = "";
		while ((line = in.readLine()) != null) {
			buffer.append(line + "\n");
		}
		return buffer.toString();
	}

	public static String inputStream2String(InputStream input) throws IOException {
		return inputStream2String(input, "utf-8");
	}

	public static File[] getFiles(String path) {
		File file = new File(path);
		return file.listFiles();
	}

	public static void createFolderFile(String path) {
		createFolder(path, true);
	}

	public static boolean createFolder(String path, boolean isFile) {
		if (isFile) {
			path = path.substring(0, path.lastIndexOf(File.separator));
		}
		File file = new File(path);
		boolean flag=false;
		if (!file.exists())
			flag= file.mkdirs();
		return flag;
	}

	public static void renameFolder(String path, String newName) {
		File file = new File(path);
		if (file.exists())
			file.renameTo(new File(newName));
	}

	public static ArrayList<File> getDiretoryOnly(File dir) {
		ArrayList dirs = new ArrayList();
		if ((dir != null) && (dir.exists()) && (dir.isDirectory())) {
			File[] files = dir.listFiles(new FileFilter() {
				public boolean accept(File file) {
					return file.isDirectory();
				}
			});
			for (int i = 0; i < files.length; i++) {
				dirs.add(files[i]);
			}
		}
		return dirs;
	}

	public ArrayList<File> getFileOnly(File dir) {
		ArrayList dirs = new ArrayList();
		File[] files = dir.listFiles(new FileFilter() {
			public boolean accept(File file) {
				return file.isFile();
			}
		});
		for (int i = 0; i < files.length; i++) {
			dirs.add(files[i]);
		}
		return dirs;
	}

	public static boolean copyFile(String from, String to) {
		File fromFile = new File(from);
		File toFile = new File(to);
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(fromFile);
			fos = new FileOutputStream(toFile);

			byte[] buf = new byte[4096];
			int bytesRead;
			while ((bytesRead = fis.read(buf)) != -1) {
				fos.write(buf, 0, bytesRead);
			}

			fos.flush();
			fos.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static void backupFile(String filePath) {
		String backupName = filePath + ".bak";
		File file = new File(backupName);
		if (file.exists()) {
			file.delete();
		}
		copyFile(filePath, backupName);
	}

	public static String getFileExt(File file) {
		if (file.isFile()) {
			return getFileExt(file.getName());
		}
		return "";
	}

	public static String getFileExt(String fileName) {
		int pos = fileName.lastIndexOf(".");
		if (pos > -1) {
			return fileName.substring(pos + 1).toLowerCase();
		}
		return "";
	}

	public static void copyDir(String fromDir, String toDir) throws IOException {
		new File(toDir).mkdirs();
		File[] file = new File(fromDir).listFiles();
		for (int i = 0; i < file.length; i++) {
			if (file[i].isFile()) {
				String fromFile = file[i].getAbsolutePath();
				String toFile = toDir + "/" + file[i].getName();

				copyFile(fromFile, toFile);
			}
			if (file[i].isDirectory())
				copyDirectiory(fromDir + "/" + file[i].getName(), toDir + "/" + file[i].getName());
		}
	}

	private static void copyDirectiory(String fromDir, String toDir) throws IOException {
		new File(toDir).mkdirs();
		File[] file = new File(fromDir).listFiles();
		for (int i = 0; i < file.length; i++) {
			if (file[i].isFile()) {
				String fromName = file[i].getAbsolutePath();
				String toFile = toDir + "/" + file[i].getName();
				copyFile(fromName, toFile);
			}
			if (file[i].isDirectory())
				copyDirectiory(fromDir + "/" + file[i].getName(), toDir + "/" + file[i].getName());
		}
	}

	public static String getFileSize(File file) throws IOException {
		if (file.isFile()) {
			FileInputStream fis = new FileInputStream(file);
			int size = fis.available();
			fis.close();
			return convertFileSize(size);
		}
		return "";
	}

	public static String convertFileSize(double size) {
		DecimalFormat df = new DecimalFormat("0.0");
		if (size > 1073741824.0D) {
			double ss = size / 1073741824.0D;
			return df.format(ss) + "MB";
		}
		if (size > 1048576.0D) {
			double ss = size / 1048576.0D;
			return df.format(ss) + "MB";
		}
		if (size > 1024.0D) {
			double ss = size / 1024.0D;
			return df.format(ss) + "KB";
		}
		return size + "B";
	}

	public static String convertFileSize(long size) {
		double lsize = (long) size;
		return convertFileSize(lsize);
	}

	public static String getParentDir(String baseDir, String currentFile) {
		File f = new File(currentFile);
		String parentPath = f.getParent();
		String path = parentPath.replace(baseDir, "");
		return path.replace(File.separator, "/");
	}

	public static String readFromProperties(String fileName, String key) {
		String value = "";
		InputStream stream = null;
		try {
			stream = new BufferedInputStream(new FileInputStream(fileName));
			Properties prop = new Properties();
			prop.load(stream);
			value = prop.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();

			if (stream != null)
				try {
					stream.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return value;
	}

	public static boolean saveProperties(String fileName, String key, String value) {
		StringBuffer sb = new StringBuffer();
		boolean isFound = false;
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "utf-8"));
			String str;
			while ((str = in.readLine()) != null) {
				if (str.startsWith(key)) {
					sb.append(key + "=" + value + "\r\n");
					isFound = true;
				} else {
					sb.append(str + "\r\n");
				}
			}

			if (!isFound) {
				sb.append(key + "=" + value + "\r\n");
			}
			writeFile(fileName, sb.toString(), "utf-8");
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	public static boolean delProperties(String fileName, String key) {
		StringBuffer sb = new StringBuffer();

		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "utf-8"));
			String str;
			while ((str = in.readLine()) != null) {
				if (!str.startsWith(key)) {
					sb.append(str + "\r\n");
				}
			}
			writeFile(fileName, sb.toString(), "utf-8");
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	public static List<Class<?>> getAllClassesByInterface(Class<?> interfaceClass, boolean samePackage)
			throws IOException, ClassNotFoundException, IllegalStateException {
		if (!interfaceClass.isInterface()) {
			throw new IllegalStateException("Class not a interface.");
		}

		ClassLoader $loader = interfaceClass.getClassLoader();

		String packageName = samePackage ? interfaceClass.getPackage().getName() : "/";
		return findClasses(interfaceClass, $loader, packageName);
	}

	private static List<Class<?>> findClasses(Class<?> interfaceClass, ClassLoader loader, String packageName)
			throws IOException, ClassNotFoundException {
		List allClasses = new ArrayList();

		String packagePath = packageName.replace(".", "/");
		if (!packagePath.equals("/")) {
			Enumeration resources = loader.getResources(packagePath);
			while (resources.hasMoreElements()) {
				URL $url = (URL) resources.nextElement();
				allClasses.addAll(findResources(interfaceClass, new File($url.getFile()), packageName));
			}
		} else {
			String path = loader.getResource("").getPath();
			allClasses.addAll(findResources(interfaceClass, new File(path), packageName));
		}
		return allClasses;
	}

	private static List<Class<?>> findResources(Class<?> interfaceClass, File directory, String packageName)
			throws ClassNotFoundException {
		List $results = new ArrayList();
		if (!directory.exists())
			return Collections.EMPTY_LIST;
		File[] files = directory.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				if (!file.getName().contains(".")) {
					if (!packageName.equals("/"))
						$results.addAll(findResources(interfaceClass, file, packageName + "." + file.getName()));
					else
						$results.addAll(findResources(interfaceClass, file, file.getName()));
				}
			} else if (file.getName().endsWith(".class")) {
				Class clazz = null;
				if (!packageName.equals("/"))
					clazz = Class.forName(packageName + "." + file.getName().substring(0, file.getName().length() - 6));
				else {
					clazz = Class.forName(file.getName().substring(0, file.getName().length() - 6));
				}
				if ((interfaceClass.isAssignableFrom(clazz)) && (!interfaceClass.equals(clazz))) {
					$results.add(clazz);
				}
			}
		}
		return $results;
	}

	public static Object cloneObject(Object obj) throws Exception {
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(byteOut);
		out.writeObject(obj);

		ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
		ObjectInputStream in = new ObjectInputStream(byteIn);

		return in.readObject();
	}

	/**
	 * @author xiaqiang
	 * @createtime 2014年9月1日 下午3:30:44
	 * @Decription BufferedImage转InputStream
	 *
	 * @param bi BufferedImage对象
	 * @param imageType 图片类型,例如"png"、"jpg"
	 * @return
	 */
	public static InputStream getImageStream(BufferedImage bi, String imageType) {
		InputStream is = null;
		ByteArrayOutputStream bs = new ByteArrayOutputStream();
		ImageOutputStream imOut;
		try {
			imOut = ImageIO.createImageOutputStream(bs);
			ImageIO.write(bi, imageType, imOut);
			is = new ByteArrayInputStream(bs.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return is;
	}

	/**
	 * 功能描述：缩放图像（按高度和宽度缩放）
	 * 
	 * @param srcImageFile
	 *            源图像文件地址
	 * @param result
	 *            缩放后的图像地址
	 * @param height
	 *            缩放后的高度(若为0,则以宽度计算比例)
	 * @param width
	 *            缩放后的宽度(若为0,则以高度计算比例)
	 * @param flag
	 *            比例不对时是否需要补白：true为补白; false为不补白;
	 * 
	 */
	public static void scale(String srcImageFile, String result, int height, int width, boolean flag) throws Exception {
		String imageType = srcImageFile.substring(srcImageFile.lastIndexOf(".") + 1);
		if (imageType.equalsIgnoreCase("png")) {
			flag = true;
		}
		try {
			double widthRatio = 0.0; // 缩放比例
			double heightRatio = 0.0; // 缩放比例
			File f = new File(srcImageFile);
			BufferedImage bi = ImageIO.read(f);

			// 计算比例

			heightRatio = (new Integer(height)).doubleValue() / bi.getHeight();
			widthRatio = (new Integer(width)).doubleValue() / bi.getWidth();

			if (height != 0 && width != 0) {

			} else {
				double ratio = heightRatio > widthRatio ? heightRatio : widthRatio;
				heightRatio = ratio;
				widthRatio = ratio;
				width = (int) (bi.getWidth() * ratio); //改变后的宽度
				height = (int) (bi.getHeight() * ratio);//改变后的高度
			}

			Image itemp = bi.getScaledInstance(width, height, bi.SCALE_SMOOTH);
			AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(heightRatio, widthRatio),
					null);
			itemp = op.filter(bi, null);
			if (flag) {// 补白
				BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				Graphics2D g = image.createGraphics();
				g.setColor(Color.white);
				g.fillRect(0, 0, width, height);
				if (width == itemp.getWidth(null))
					g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2, itemp.getWidth(null),
							itemp.getHeight(null), Color.white, null);
				else
					g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0, itemp.getWidth(null),
							itemp.getHeight(null), Color.white, null);
				g.dispose();
				itemp = image;
			}
			BufferedImage bufImg = new BufferedImage(itemp.getWidth(null), itemp.getHeight(null),
					BufferedImage.TYPE_INT_RGB);
			Graphics g = bufImg.createGraphics();
			g.drawImage(itemp, 0, 0, null);
			g.dispose();

			File resultFile = new File(result);
			if (!isFileExist(result)) {
				resultFile.mkdirs();
			}
			ImageIO.write(bufImg, imageType, resultFile);
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * 功能描述：缩放图像（按高度和宽度缩放）传入输入流,返回的也是输入流
	 * 
	 * @param is
	 *            源图像文件地址
	 * @param height
	 *            缩放后的高度(若为0,则以宽度计算比例)
	 * @param width
	 *            缩放后的宽度(若为0,则以高度计算比例)
	 * @param flag
	 *            比例不对时是否需要补白：true为补白; false为不补白;
	 * 
	 */
	public static InputStream scale(InputStream is, int height, int width, boolean flag) throws Exception {
		flag = true;
		try {
			double widthRatio = 0.0; // 缩放比例
			double heightRatio = 0.0; // 缩放比例
			BufferedImage bi = ImageIO.read(is);

			// 计算比例

			heightRatio = (new Integer(height)).doubleValue() / bi.getHeight();
			widthRatio = (new Integer(width)).doubleValue() / bi.getWidth();

			if (height != 0 && width != 0) {

			} else {
				double ratio = heightRatio > widthRatio ? heightRatio : widthRatio;
				heightRatio = ratio;
				widthRatio = ratio;
				width = (int) (bi.getWidth() * ratio); //改变后的宽度
				height = (int) (bi.getHeight() * ratio);//改变后的高度
			}

			Image itemp = bi.getScaledInstance(width, height, bi.SCALE_SMOOTH);
			AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(heightRatio, widthRatio),
					null);
			itemp = op.filter(bi, null);
			if (flag) {// 补白
				BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				Graphics2D g = image.createGraphics();
				g.setColor(Color.white);
				g.fillRect(0, 0, width, height);
				if (width == itemp.getWidth(null))
					g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2, itemp.getWidth(null),
							itemp.getHeight(null), Color.white, null);
				else
					g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0, itemp.getWidth(null),
							itemp.getHeight(null), Color.white, null);
				g.dispose();
				itemp = image;
			}
			BufferedImage bufImg = new BufferedImage(itemp.getWidth(null), itemp.getHeight(null),
					BufferedImage.TYPE_INT_RGB);
			Graphics g = bufImg.createGraphics();
			g.drawImage(itemp, 0, 0, null);
			g.dispose();

			return getImageStream(bufImg, "png");
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * @author xiaqiang
	 * @createtime 2014年9月2日 下午2:26:01
	 * @Decription 将输入流,用response输出为图片类型
	 *
	 * @param request
	 * @param response
	 * @param is 输入流
	 * @throws IOException
	 */
	public static void viewImg(HttpServletRequest request, HttpServletResponse response, InputStream is)
			throws IOException {
		OutputStream outp = null;
		response.setContentType("multipart/form-data");
		try {
			outp = response.getOutputStream();
			byte[] b = new byte[1024];
			int i = 0;
			while ((i = is.read(b)) > 0) {
				outp.write(b, 0, i);
			}
			outp.flush();
		} catch (Exception e) {
			e.printStackTrace();
			outp.write("下载发生错误!".getBytes("utf-8"));
		} finally {
			if (is != null) {
				is.close();
				is = null;
			}
			if (outp != null) {
				outp.close();
				outp = null;
				response.flushBuffer();
			}
		}
	}
}
