package com.mana.base.web.singleTable.action;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.mana.autoBuild.daoVO.BaseAutoBuildVO;
import com.mana.base.tools.sql.DateBaseOperateUtil;
import com.mana.base.web.BaseActionClass;
import com.mana.base.web.singleTable.page.PageInfo;

/**
 * 单表操作 
 * @author hc360
 *
 */
public class SingleTableAction  extends BaseActionClass{
	
	
	
	
	//添加或更新方法 
	//http://localhost:8080/web/singleTable/action/SingleTableAction_save.do1?singleTableName=UserVoteVO&tableJson={"status":"1"}
	//http://localhost:8080/web/singleTable/action/SingleTableAction_save.do1?singleTableName=AutoOperateSetpVO&tableJson=[{"name":"步骤步骤11111111111","param1":"param111","param3":"param133","param9":"param199"},{"name":"步骤步骤222222","param1":"param22111","param3":"param222133","param9":"param222199"}]
	public ModelAndView save(HttpServletRequest request,HttpServletResponse response ){
		//获取singleClass
		//单表对应的json		
		String tableJson = request.getParameter("tableJson");
		//生成类的名称

		Class tableClass = useTableFindClass(request);
		if(tableJson.startsWith("[")){
			List<BaseAutoBuildVO> list = JSON.parseArray(tableJson,tableClass);
			//判断是插入或者保存方法 根据 主键字段是否有值来判断 
			for(BaseAutoBuildVO autoBuildVO :list){
				DateBaseOperateUtil.inserByAutoBuildVO(autoBuildVO);
			}
			return buildJsonModelAndView(list);
		}else{
			BaseAutoBuildVO autoBuildVO = (BaseAutoBuildVO)JSON.parseObject(tableJson,tableClass);
			DateBaseOperateUtil.inserByAutoBuildVO(autoBuildVO);
			return buildJsonModelAndView(autoBuildVO);
		}
	}
	
	//添加或更新方法 
	//http://localhost:8080/web/singleTable/action/SingleTableAction_saveUpdate.do1?singleTableName=UserVoteVO&tableJson={"status":"1"}
	//http://localhost:8080/web/singleTable/action/SingleTableAction_update.do1?singleTableName=AutoOperateSetpVO&tableJson=[{"name":"步骤步骤11111111111","param1":"param111","param3":"param133","param9":"param199"},{"name":"步骤步骤222222","param1":"param22111","param3":"param222133","param9":"param222199"}]
	public ModelAndView update(HttpServletRequest request,HttpServletResponse response ){
		//获取singleClass
		//单表对应的json		
		String tableJson = request.getParameter("tableJson");
		//生成类的名称
		Class tableClass = useTableFindClass(request);
		if(tableJson.startsWith("[")){
			List<BaseAutoBuildVO> list = JSON.parseArray(tableJson,tableClass);
			//判断是插入或者保存方法 根据 主键字段是否有值来判断 
			for(BaseAutoBuildVO autoBuildVO :list){
				DateBaseOperateUtil.updateByAutoBuildVO(autoBuildVO);
			}
			return buildJsonModelAndView(list);
		}else{
			BaseAutoBuildVO autoBuildVO = (BaseAutoBuildVO)JSON.parseObject(tableJson,tableClass);				
			DateBaseOperateUtil.updateByAutoBuildVO(autoBuildVO);
			return buildJsonModelAndView(autoBuildVO);
		}
	}
	
	
	//添加或更新方法 
	//http://localhost:8080/web/singleTable/action/SingleTableAction_saveUpdate.do1?singleTableName=UserVoteVO&tableJson={"status":"1"}
	//http://localhost:8080/web/singleTable/action/SingleTableAction_saveUpdate.do1?singleTableName=AutoOperateSetpVO&tableJson=[{"name":"步骤步骤11111111111","param1":"param111","param3":"param133","param9":"param199"},{"name":"步骤步骤222222","param1":"param22111","param3":"param222133","param9":"param222199"}]
	public ModelAndView saveUpdate(HttpServletRequest request,HttpServletResponse response ){
		//获取singleClass
		//单表对应的json		
		String tableJson = request.getParameter("tableJson");
		//生成类的名称
		Class tableClass = useTableFindClass(request);
		if(tableJson.startsWith("[")){
			List<BaseAutoBuildVO> list = JSON.parseArray(tableJson,tableClass);
			//判断是插入或者保存方法 根据 主键字段是否有值来判断 
			for(BaseAutoBuildVO autoBuildVO :list){
				System.out.println("width=" + autoBuildVO);
				
				saveorupdateAutoBuildVO(autoBuildVO);
			}
			return buildJsonModelAndView(list);
		}else{
			BaseAutoBuildVO autoBuildVO = (BaseAutoBuildVO)JSON.parseObject(tableJson,tableClass);				
			saveorupdateAutoBuildVO(autoBuildVO);
			return buildJsonModelAndView(autoBuildVO);
		}
	}

	//http://localhost:8080/web/singleTable/action/SingleTableAction_findOneTable.do1?singleTableName=UserVoteVO&tableJson={%22id%22:%22aaa111101%22}
	/**
	 * 返回单表单个对象结果 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView findOneTable(HttpServletRequest request,HttpServletResponse response ){
		Class tableClass = useTableFindClass(request);
		String tableJson = request.getParameter("tableJson");
		BaseAutoBuildVO autoBuildVO = (BaseAutoBuildVO)JSON.parseObject(tableJson,tableClass);
		BaseAutoBuildVO returnVO = DateBaseOperateUtil.jdbcSelectSingleOperate(autoBuildVO);
		return buildJsonModelAndView(returnVO);
	}
	
	
	//http://localhost:8080/web/singleTable/action/SingleTableAction_findComplexTable.do1?compoundSql=sql5&
	/**
	 * 返回复杂sql的查询结果  
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView findComplexTable(HttpServletRequest request,HttpServletResponse response ){
		String compoundSqlId = request.getParameter("compoundSql");
		Map map = new HashMap();
		Enumeration  en =  request.getParameterNames();		
		while(en.hasMoreElements()){
			String key = "" + en.nextElement();
			String value = request.getParameter(key);
			map.put(key, value);
		}		
		List<Map> list = DateBaseOperateUtil.jdbcSelectByComplexSqlOperate(compoundSqlId, map);
		return buildJsonModelAndView(list);
	}
	
	
	//http://localhost:8080/web/singleTable/action/SingleTableAction_deleteTable.do1?singleTableName=UserVoteVO&tableJson={"id":"20131003185350279517bfb9dadf74f5e929f3a8540a1dee9"}
	/**
	 * 删除单张表的记录  
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView deleteTable(HttpServletRequest request,HttpServletResponse response ){
		
		Class tableClass = useTableFindClass(request);
		String tableJson = request.getParameter("tableJson");		
		BaseAutoBuildVO autoBuildVO = (BaseAutoBuildVO)JSON.parseObject(tableJson,tableClass);		
		int re= DateBaseOperateUtil.jdbcDeleteSingleOperate(autoBuildVO);		
		return buildJsonModelAndView(re);
	}

	
	/**
	 * 删除符合条件的记录  
	 * @param request
	 * @param response 
	 * @return
	 */
	public ModelAndView deleteTableByWhere(HttpServletRequest request,HttpServletResponse response ){
		Class tableClass = useTableFindClass(request);		
		String tableJson = request.getParameter("tableJson");		
		BaseAutoBuildVO autoBuildVO = (BaseAutoBuildVO)JSON.parseObject(tableJson,tableClass);		
		int re= DateBaseOperateUtil.jdbcDeleteMultiple(autoBuildVO);		
		return buildJsonModelAndView(re);
		
	}
	 
	
	
//查找数组结果	 返回单表多个对象结果 
//http://localhost:8080/web/singleTable/action/SingleTableAction_findTable.do1?singleTableName=UserVoteVO&tableJson={'status':'1'}
	//select * from  user_vote where feature_Name = 'ggg222'
	public ModelAndView findTable(HttpServletRequest request,HttpServletResponse response ){
		Class tableClass = useTableFindClass(request);
		String tableJson = request.getParameter("tableJson");
		BaseAutoBuildVO autoBuildVO = (BaseAutoBuildVO)JSON.parseObject(tableJson,tableClass);
		//查看是否有分页信息 
		String pageOffset = request.getParameter("pageOffset1316");
		String pageLimit  = request.getParameter("pageLimit1316");		
		PageInfo page = null; 
		if(pageOffset!=null && pageLimit!=null){
			page = new PageInfo();
			page.setPageLimit1316(pageLimit);
			page.setPageOffset1316(pageOffset);
		}
		//select * from  user_vote where status = 1
		List<BaseAutoBuildVO> list =  DateBaseOperateUtil.jdbcSelectMultitermOperate( autoBuildVO,page);
		
		return buildJsonModelAndView(list);
	}
	
	//测试方法
	//http://localhost:8080/web/singleTable/action/SingleTableAction_test.do1
	public ModelAndView test(HttpServletRequest request,HttpServletResponse response ){
		List list = new ArrayList();
		list.add("aaaa");
		list.add("bbbb");
		list.add("cccc");		
		return buildJsonModelAndView(list);
	}
	
	
	//=====================================private 私有化区域=============================
	/**
	 * 根据表名 
	 * @param request
	 * @return
	 */
	private Class useTableFindClass(HttpServletRequest request){
		String tableVo = request.getParameter("singleTableName");
		String className = BaseAutoBuildVO.autoBuildBasePath + tableVo;
		Class tableClass;
		try {
			tableClass = Class.forName(className);
			return tableClass;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 根据主键是否有值，判断是更新还是插入方法
	 * @param autoBuildVO
	 */
	private boolean saveorupdateAutoBuildVO(BaseAutoBuildVO autoBuildVO) {
		if(autoBuildVO.findKeyValue()!=null && autoBuildVO.findKeyValue().length()>0){//主键有值，执行更新操作
			//更新操作 
			return DateBaseOperateUtil.updateByAutoBuildVO(autoBuildVO);
		}else{			
			//插入新的值 
			return   DateBaseOperateUtil.inserByAutoBuildVO(autoBuildVO) != null;
		}
		
	}
	
	
	
	
	
	
}

	//buildId_pageadd_13993871125235,buildId_pageadd_13993871176356,buildId_pageadd_13993871075324
