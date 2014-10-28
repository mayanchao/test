package com.mana.autoBuild.operate.singleVO.Impl;

import java.util.Iterator;
import java.util.Map;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;
import com.mana.autoBuild.operate.singleVO.DecorationSingleVO;
import com.mana.autoBuild.tableVO.AutoOperateSetpVO;


/**
 * 数据操作工具流节点类 第数字加减乘除操作 
 * @author Administrator
 *
 */
public class NumberOperate   implements  DecorationSingleVO {
	
	public final static String ADD_OPERATE = "";
	
	@Override
	public Object decorateVO(BaseAutoBuildVO vo, Map map) {
		
		AutoOperateSetpVO autoOperateSetpVo = (AutoOperateSetpVO)vo;
		String inputVO = autoOperateSetpVo.getParam1();//获取值传入的VO
		BaseAutoBuildVO valueVO =  (BaseAutoBuildVO)map.get(inputVO);//获取到上面节点传入过来的数据
		String  filedName = autoOperateSetpVo.getParam2(); //获得字段名字
		
		//把取到的值转换成数字
		Integer value = Integer.parseInt( "" + valueVO.autoGet(filedName) );
		//获取要数据操作另外的值 
		Integer otherValue = Integer.parseInt(autoOperateSetpVo.getParam3());
		
		String filedOperate = autoOperateSetpVo.getParam4(); //获得字段操作类型
		if( "add".equals(filedOperate ) ){
			value = value + otherValue;
		}else if( "subtract".equals(filedOperate ) ){
			value = value - otherValue;
		}else if( "multiply".equals(filedOperate ) ){
			value = value * otherValue;
		}else if( "divide".equals(filedOperate ) ){
			value = value / otherValue;
		}
		valueVO.autoSet(filedName, value);
		
//		//进行数值操作 
//		//获取字段名 
//		Iterator<String> it = map.keySet().iterator();
//		while(it.hasNext()){
//			String filedName = it.next();
//			//获取字段的set方法 
//			Integer value = (Integer)vo.autoGet(filedName);
//			String[] opers =  ("" + map.get(filedName)).split(" ");
//			if( opers[0].equals("add") ){
//				value = value + Integer.parseInt(opers[1]);
//			}else if(opers[0].equals("subtract") ){
//				value = value - Integer.parseInt(opers[1]);				
//			}else if(opers[0].equals("multiply") ){
//				value = value * Integer.parseInt(opers[1]);
//			}else if(opers[0].equals("divide") ){
//				value = value / Integer.parseInt(opers[1]);
//			}
//			//把值付会给vo对象 
//			vo.autoSet(filedName, value);
//		}
		return true;
	}
	
}
