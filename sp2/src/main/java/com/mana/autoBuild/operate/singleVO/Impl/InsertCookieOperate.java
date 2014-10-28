package com.mana.autoBuild.operate.singleVO.Impl;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;
import com.mana.autoBuild.operate.singleVO.DecorationSingleVO;
import com.mana.autoBuild.tableVO.AutoOperateSetpVO;
import com.mana.base.tools.string.StringUtil;

/**
 * 把当前值写入cookie 
 * @author hc360
 *
 */
public class InsertCookieOperate implements  DecorationSingleVO {

	/** 日志对象 */
	static Log logger = LogFactory.getLog(InsertCookieOperate.class);
//属性是以 储存的主键 和属性值  例如 AAA.name 
	@Override
	public Object decorateVO(BaseAutoBuildVO vo, Map map) {
		AutoOperateSetpVO setpVO = (AutoOperateSetpVO)vo;
		String FromDataParam = setpVO.getParam1(); //数据源的字段
		String cookieName = setpVO.getParam2(); //cookie的名字		
				
		//保存这个值
		String result = StringUtil.complexParamGetValue(map, FromDataParam);
		//保存到cookie中
		HttpServletResponse response = (HttpServletResponse) map.get("response");
		Cookie cookie = new Cookie(cookieName,result);		
		response.addCookie(cookie);
		
		return result;
	}

	
	
	
	
}


