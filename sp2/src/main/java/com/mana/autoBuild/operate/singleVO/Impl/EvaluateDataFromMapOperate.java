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
 * 给VO对象赋值操作 
 * @author hc360
 *
 */
public class EvaluateDataFromMapOperate implements  DecorationSingleVO {

	/** 日志对象 */
	static Log logger = LogFactory.getLog(EvaluateDataFromMapOperate.class);
//属性是以 储存的主键 和属性值  例如 AAA.name 
	@Override
	public Object decorateVO(BaseAutoBuildVO vo, Map map) {
		AutoOperateSetpVO setpVO = (AutoOperateSetpVO)vo;
		String FromDataParam = setpVO.getParam1(); //数据源的字段
		String ToDataParam = setpVO.getParam2(); //数据源的字段
		String needSaveClass = setpVO.getParam3(); //是否为空判断 如果有值就代表。如果为空就新建当前的值
		
		//判断的属性值，这个从工作流结果集合中取得
		String fromValue = StringUtil.complexParamGetValue(map, FromDataParam);
		//获取当前要保存的对象，从链值队列中
		BaseAutoBuildVO result = StringUtil.complexParamGetObject(map, ToDataParam); 
		//判断取出的值是否为空 ，如果为空，并且设置了新建对象设置，就new出来一个对象
		if(needSaveClass!=null && needSaveClass.length()>0 && result==null){
				//需要new出来一个对象 
			try {
				result =  (BaseAutoBuildVO)Class.forName(needSaveClass).newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
			//放入当前值队列中
			String key = StringUtil.complexParamGetKeyName(ToDataParam);
			map.put(key, result);
		}		
		//保存这个值
		result = StringUtil.complexParamPutValue(map, ToDataParam, fromValue);
		return result;
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


