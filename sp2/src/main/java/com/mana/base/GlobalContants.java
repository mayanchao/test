package com.mana.base;

import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

//全局静态变量命名规则  用下划线分隔 ，模块名_功能_方法名
//相关的模块要在同一个区域内  
//常量全部大写
public class GlobalContants {
	/** 日志对象 */
	static Log logger = LogFactory.getLog(GlobalContants.class);
	
	//底层base 扫描类模块   要扫描的文件后缀 ，在容器启动的时候会扫描所有的类后缀，如果符合就自动注入成bean
	public final static  Pattern BASE_SCAN_BEAN_CLASS_PATTEN = Pattern.compile("(\\w+((Action)|(ServiceImpl)|(DaoImpl))\\.class$)");

	//底层base 扫描类模块   要扫描目录的后缀 ，
	public final static String[] BASE_SCAN_BEAN_DIR_PATH_HEAD_PIEX  =new String[]{"org.mana"};
	
}


