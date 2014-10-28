package com.mana.autoBuild.operate.singleVO.Impl;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;
import com.mana.autoBuild.operate.singleVO.DecorationSingleVO;

/**
 * 根据上个工作流节点处理结果，判断条件，然后执行下一个工作流节点  
 * @author hc360
 *
 */
public class IfCondition implements  DecorationSingleVO {

	/** 日志对象 */
	static Log logger = LogFactory.getLog(IfCondition.class);

	@Override
	public Object decorateVO(BaseAutoBuildVO vo, Map map) {
		String result =  (String) map.get("workflowResult");
//		String need 
		if(result != null ){//没有返回值，视为false  
			String falseWorkFlowName = (String) map.get("falseResult");
		}else{
			String trueWorkFlowName = (String) map.get("trueResult");	
		}	
		LinkedHashMap link = new LinkedHashMap<String, Object>();
//		String pageUrl = (String) param.getParam().get("page");
//		return pageUrl;
		return null;
	}
}


