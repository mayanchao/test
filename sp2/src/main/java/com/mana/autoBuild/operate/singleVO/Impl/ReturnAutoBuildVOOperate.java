package com.mana.autoBuild.operate.singleVO.Impl;

import java.util.Map;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;
import com.mana.autoBuild.operate.singleVO.DecorationSingleVO;
import com.mana.autoBuild.tableVO.AutoOperateSetpVO;
import com.mana.base.tools.sql.DateBaseOperateUtil;


/**
      保存单一数据，到数据库中 
 * @author Administrator
 *
 */
public class ReturnAutoBuildVOOperate   implements  DecorationSingleVO {
	@Override
	public Object decorateVO(BaseAutoBuildVO vo, Map param) {
		AutoOperateSetpVO autoOperateSetpVo = (AutoOperateSetpVO)vo;
		String saveResultKeyName = autoOperateSetpVo.getParam1();
		//从值队列中取出数据 
		BaseAutoBuildVO  autoBuildVO = (BaseAutoBuildVO)param.get(saveResultKeyName);
		//直接保存数据库
		DateBaseOperateUtil.updateByAutoBuildVO(autoBuildVO);
		return autoBuildVO;
	}
	
}
