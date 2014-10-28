package com.mana.autoBuild.operate.singleVO;

import java.util.Map;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;



/**
 * 对单个vo进行装饰 ，进行工作流节点操作  然后再传给下一个点
 * @author Administrator
 *
 */
public interface  DecorationSingleVO {

	/**
	 * 装修单个vo 
	 * @param vo  要操作的vo 
	 * @return
	 */
	public Object decorateVO(BaseAutoBuildVO vo,Map param );
	
	
	
	
}


