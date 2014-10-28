package com.mana.autoBuild.operate.singleVO.Impl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.mana.autoBuild.daoVO.BaseAutoBuildVO;
import com.mana.autoBuild.operate.singleVO.DecorationSingleVO;
import com.mana.autoBuild.tableVO.AutoOperateSetpVO;
import com.mana.base.tools.sql.DateBaseOperateUtil;


/**
      查找单一数据 
 * @author Administrator
 *
 */
public class FindSingleDateOperate   implements  DecorationSingleVO {
	@Override
	public Object decorateVO(BaseAutoBuildVO vo, Map param) {
		AutoOperateSetpVO autoOperateSetpVo = (AutoOperateSetpVO)vo;
		//保存结果中的key名字 
		String needFindKeyName = autoOperateSetpVo.getParam1();//要去数据库查找的节点
		String saveResultKeyName = autoOperateSetpVo.getParam2();
		//根据表名对象 生成vo		
		try{
			BaseAutoBuildVO autoBuildVO = (BaseAutoBuildVO)param.get(needFindKeyName);
			//去数据库中获取结果 			
			BaseAutoBuildVO valueVO = DateBaseOperateUtil.jdbcSelectSingleOperate(autoBuildVO);			
			//把查询到的单条结果vo 放入值队列中  
			param.put(saveResultKeyName, valueVO);
			return valueVO;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * 根据要查询的条件，从request中取出值，然后set到这个表的字段中，为生成select 中where后面的条件所用 
	 * @param request  请求的request
	 * @param tableVo  要查询的表vo
	 * @param fileparamName 字段属性名 
	 */
	private void tableParamVO(HttpServletRequest request,BaseAutoBuildVO tableVo, String fileparamName) {
		if(fileparamName!=null){//给字段复制
			Object value = request.getParameter(fileparamName);
			tableVo.autoSet(fileparamName, value);
		}
	}
	
}
