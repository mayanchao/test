package com.mana.autoBuild.operate.singleVO.Impl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;
import com.mana.autoBuild.operate.singleVO.DecorationSingleVO;
import com.mana.autoBuild.tableVO.AutoOperateSetpVO;
import com.mana.base.tools.memcached.MemcacheUtil;
import com.mana.base.tools.workflow.WorkFlowUtil;

/**
 * 把数据存入Session的操作
 * @author hc360
 *
 */
public class SessionInputOperate implements  DecorationSingleVO {

	/** 日志对象 */
	static Log logger = LogFactory.getLog(SessionInputOperate.class);
//属性是以 储存的主键 和属性值  例如 AAA.name 
	@Override
	public Object decorateVO(BaseAutoBuildVO vo, Map map) {
		AutoOperateSetpVO setpVO = (AutoOperateSetpVO)vo;		
		String needSaveMapKeyName = setpVO.getParam1(); //需要存储的值，的组件
		//取出值
		Object save = map.get(needSaveMapKeyName);
		String needSaveSessionKeyName = setpVO.getParam2(); //需要存储的值，的组件
		
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		request.getSession().setAttribute(needSaveSessionKeyName, save);
		
		return save;
	}

	/**
	 * 根据参数是否为复合属性 或者普通属性，从map中获取结果 
	   下午03:24:49
	 * @param map
	 * @param param1
	 */
	private String complexParamGetValue(Map map, String param1) {		
 		if(param1.indexOf(".")>0 ){//说明复合属性 
			String[] params = param1.split("\\.");
			BaseAutoBuildVO resultVo = (BaseAutoBuildVO) map.get(params[0]);//取出结果集中的vo
			if(resultVo==null){
				return "false";
			}
			return  (String) resultVo.autoGet(params[1]);
		}else{//直接取出 
			return  (String) map.get(param1);
		}
	}
	
	
	/**
	 * 查找数据 ，根据类型 来决定从哪里获取数据    
	 * @param key
	 * @param type
	 * @param chainMap web属性值列表中获取值 
	 * @return
	 */
	private String findValueFromType(String key,String type, Map chainMap){
		if("MEMCACHED_webMap".equals(type)){//从缓存中获取数据  key的来源是当前的map属性
			BaseAutoBuildVO obj = (BaseAutoBuildVO)MemcacheUtil.findVO(key);
			obj.autoGet("a");
		}
		return "";
	}
	
}


