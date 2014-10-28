package com.mana.autoBuild.operate.singleVO.Impl;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;
import com.mana.autoBuild.operate.singleVO.DecorationSingleVO;
import com.mana.autoBuild.tableVO.AutoOperateSetpVO;
import com.mana.base.tools.memcached.MemcacheUtil;
import com.mana.base.tools.string.StringUtil;
import com.mana.base.tools.workflow.WorkFlowUtil;

/**
 * 等式判断 根据操作符类型 判断是等于 大于还是小于   
 * @author hc360
 *
 */
public class EqualStringOperate implements  DecorationSingleVO {

	/** 日志对象 */
	static Log logger = LogFactory.getLog(EqualStringOperate.class);
//属性是以 储存的主键 和属性值  例如 AAA.name 
	@Override
	public Object decorateVO(BaseAutoBuildVO vo, Map map) {
		AutoOperateSetpVO setpVO = (AutoOperateSetpVO)vo;
		String saveResultKeyName = setpVO.getParam1(); //返回结果的主键
		//判断的属性值，这个从工作流结果集合中取得
		String param1 = setpVO.getParam1();
		String value1 = StringUtil.complexParamGetValue(map, param1);
		//判断的属性值，这个从工作流结果集合中取得
		String param2 = setpVO.getParam2();
		String value2 = StringUtil.complexParamGetValue(map, param2);
		//比较结果
		boolean re = value2.equals(value1);
		
		//根据结果 真假来决定下一步要执行的步骤 
		if(re){
			String param3 = setpVO.getParam3();//判断跳转的步骤名称  值对比上
			map.put(WorkFlowUtil.WORK_FLOW_GOTO, param3);
		}else{
			String param4 = setpVO.getParam4();//判断跳转的步骤名称  值没有对比上 
			map.put(WorkFlowUtil.WORK_FLOW_GOTO, param4);
		}
		map.put(saveResultKeyName, re);
		return re;
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


