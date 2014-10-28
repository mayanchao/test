package com.mana.autoBuild.operate.singleVO.Impl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;
import com.mana.autoBuild.operate.singleVO.DecorationSingleVO;
import com.mana.autoBuild.tableVO.AutoOperateSetpVO;
import com.mana.base.tools.memcached.MemcacheUtil;
import com.mana.base.tools.sql.DateBaseOperateUtil;


/**
      查找数据 从存储值链 然后查找数据库  
 * @author Administrator
 *
 */
public class FindSingleDateFromRequestOperate   implements  DecorationSingleVO {
	@Override
	public Object decorateVO(BaseAutoBuildVO vo, Map param) {
		AutoOperateSetpVO autoOperateSetpVo = (AutoOperateSetpVO)vo;
		String myVoClass = autoOperateSetpVo.getParam1();//表名对象
		BaseAutoBuildVO tableVo = null;
		try {
			tableVo = (BaseAutoBuildVO) Class.forName(myVoClass).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpServletRequest request = (HttpServletRequest) param.get("request");
		//保存结果中的key名字 
		String saveResultKeyName = autoOperateSetpVo.getParam2();
		//要取出主键 数组，并且以逗号分割 
		String keyNameArrays = autoOperateSetpVo.getParam3();
		String[] keyArrays = keyNameArrays.split(",") ;
		
		for(int i=0;i<keyArrays.length;i++){
			String filedName = keyArrays[i];
			String value = request.getParameter(filedName);
			tableVo.autoSet(filedName, value);
		}
		param.put(saveResultKeyName, tableVo);
		return tableVo; 
	}


	
}
