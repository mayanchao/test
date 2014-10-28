package com.mana.autoBuild.operate.singleVO.Impl;

import java.util.List;
import java.util.Map;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;
import com.mana.autoBuild.operate.singleVO.DecorationSingleVO;
import com.mana.autoBuild.tableVO.AutoOperateSetpVO;
import com.mana.autoBuild.tableVO.CompoundSqlVO;
import com.mana.base.tools.sql.DateBaseOperateUtil;
import com.mana.base.tools.string.StringUtil;


/**
      执行复杂Sql语句  的工作流节点 
 * @author Administrator
 *
 */
public class ExamComplexSqlOperate   implements  DecorationSingleVO {
	@Override
	public Object decorateVO(BaseAutoBuildVO vo, Map param) {
		AutoOperateSetpVO autoOperateSetpVo = (AutoOperateSetpVO)vo;
		//复杂sql语句
		String compoundSqlId = autoOperateSetpVo.getParam1();
//		CompoundSqlVO compundVO = new CompoundSqlVO();
//		compundVO.setCompoundSqlId(compoundSqlId);
//		//取出复合的SQl语句
//		compundVO = (CompoundSqlVO) DateBaseOperateUtil.jdbcSelectSingleOperate(compundVO);
				
		List<Map> list = DateBaseOperateUtil.jdbcSelectByComplexSqlOperate(compoundSqlId, param);
		String resultKey = autoOperateSetpVo.getParam2();
		param.put(resultKey, list);
		
		return list;
	}
	
}
