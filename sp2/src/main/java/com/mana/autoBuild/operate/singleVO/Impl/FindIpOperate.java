package com.mana.autoBuild.operate.singleVO.Impl;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;
import com.mana.autoBuild.operate.singleVO.DecorationSingleVO;
import com.mana.autoBuild.tableVO.AutoOperateSetpVO;
import com.mana.base.tools.string.StringUtil;

/**
 * 获取当前请求的IP，
 * @author hc360
 *
 */
public class FindIpOperate implements  DecorationSingleVO {

	/** 日志对象 */
	static Log logger = LogFactory.getLog(FindIpOperate.class);
//属性是以 储存的主键 和属性值  例如 AAA.name 
	@Override
	public Object decorateVO(BaseAutoBuildVO vo, Map map) {
		AutoOperateSetpVO setpVO = (AutoOperateSetpVO)vo;
		String FromDataParam = setpVO.getParam1(); //要存入数据源的字段
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String ip = getRemoteAddress(request);  
		//保存这个值
		StringUtil.complexParamPutValue(map, FromDataParam, ip);// .complexParamGetValue(map, FromDataParam);
		
		return ip;
	}

	//从request中获取IP地址
	 public String getRemoteAddress(HttpServletRequest request) {  
	        String ip = request.getHeader("x-forwarded-for");  
	        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
	            ip = request.getHeader("Proxy-Client-IP");  
	        }  
	        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
	            ip = request.getHeader("WL-Proxy-Client-IP");  
	        }  
	        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
	            ip = request.getRemoteAddr();  
	        }  
	        return ip;  
	    }  
	
	
}


