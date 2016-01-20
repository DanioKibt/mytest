package com.mytest.test;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import sun.misc.BASE64Encoder;
  
public class FileTest  
{  
      
    public static void main(String[] args)  
    {  
        byte[] b=file2BetyArray();
        System.err.println(b);
        String fileString =new BASE64Encoder().encode(b);
        System.err.println(fileString);
        byte[] bytes = null;
        try {
        	bytes = new sun.misc.BASE64Decoder().decodeBuffer(fileString);
        	System.err.println(bytes);
		} catch (Exception e) {
			// TODO: handle exception
		}
//        fileToBetyArray();  
//        BetyToFile("D:"+File.separator+File.separator+"test.txt");  
    }  
  
    public static byte[] file2BetyArray()  
    {  
        File file = new File("D:"+File.separator+"test.txt");  
        if (!file.exists()) {  
            return null;  
        }  
        FileInputStream stream = null;  
        ByteArrayOutputStream out = null;  
        try {  
            stream = new FileInputStream(file);  
            out = new ByteArrayOutputStream(1000);  
            byte[] b = new byte[1000];  
            int n;  
            while ((n = stream.read(b)) != -1) {  
                out.write(b, 0, n);  
            }  
            return out.toByteArray();// 此方法大文件OutOfMemory  
        } catch (Exception e) {  
            System.out.println(e.toString());  
        } finally {  
            try {  
                stream.close();  
                out.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
  
        }  
        return null;  
    }  
  
    public static byte[] fileToBetyArray()  
    {  
        FileInputStream fileInputStream = null;  
        File file = new File("D:\\Study\\Java\\First.class");  
        byte[] bFile = null;  
        try {  
            bFile = new byte[(int) file.length()];  
            fileInputStream = new FileInputStream(file);  
            fileInputStream.read(bFile);  
            fileInputStream.close();  
            for (int i = 0; i < bFile.length; i++) {  
                System.out.print((char) bFile[i]);  
            }  
            System.out.println("Done");  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                fileInputStream.close();  
                bFile.clone();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return bFile;  
    }  
  
    public  static File BetyToFile( String filePath)  
    {  
        File file = new File(filePath);  
        BufferedOutputStream stream = null;  
        FileOutputStream fstream = null;  
        byte[] data=new byte[(int)file.length()];  
        try {  
            fstream = new FileOutputStream(file);  
            stream = new BufferedOutputStream(fstream);  
            stream.write(data);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (stream != null) {  
                    stream.close();  
                }  
                if (null != fstream) {  
                    fstream.close();  
                }  
            } catch (IOException e1) {  
                e1.printStackTrace();  
            }  
        }  
        return file;  
    }  
  
}  