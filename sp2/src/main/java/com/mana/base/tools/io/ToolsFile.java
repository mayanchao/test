package com.mana.base.tools.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.core.io.ClassPathResource;

import com.mana.autoBuild.templet.type.base.baseshow.company.CompanyInfoTempletModule;

public class ToolsFile {
	//本地class路径 
	public static String localClasspath;
	//本地web路径 
	public static String localWebpath;
	
	static{
		ClassPathResource cr = new ClassPathResource("com/mana/base/filter/ApplicationServletInitFilter.class");
		String classpath;
		try {
			classpath = cr.getFile().getAbsolutePath();
			ToolsFile.localClasspath  = classpath.substring(0, classpath.length()-55);//初始化classes的绝对路径
			ToolsFile.localWebpath  = ToolsFile.localClasspath.substring(0, ToolsFile.localClasspath.length()-16);//初始化classes的绝对路径
			
			
			System.out.println(ToolsFile.localWebpath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean createFile(byte[] context,String fileSrc){
		File file = new File(fileSrc);
		OutputStream out  = null;
		try {
			out =   new FileOutputStream(file);
			out.write(context);
			out.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}finally{
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	
	/**
	 * 查找当前类的路径 
	 * @param myClass 当前类名 
	 * @return
	 */
	public static String findModulePath(Class myClass){
		String filepath = myClass.getResource("").getPath();
		return filepath;
	}
	
	public static void main(String[] args) {
		String re = ToolsFile.findModulePath(CompanyInfoTempletModule.class);		
		System.out.println(re);
		
		
	}
}

