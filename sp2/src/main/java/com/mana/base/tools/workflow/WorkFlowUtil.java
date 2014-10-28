package com.mana.base.tools.workflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;
import com.mana.autoBuild.operate.singleVO.DecorationSingleVO;
import com.mana.autoBuild.operate.singleVO.Impl.EqualStringOperate;
import com.mana.autoBuild.operate.singleVO.Impl.EvaluateDataFromMapOperate;
import com.mana.autoBuild.operate.singleVO.Impl.ExamComplexSqlOperate;
import com.mana.autoBuild.operate.singleVO.Impl.FindIpOperate;
import com.mana.autoBuild.operate.singleVO.Impl.FindSingleDateFromRequestOperate;
import com.mana.autoBuild.operate.singleVO.Impl.FindSingleDateOperate;
import com.mana.autoBuild.operate.singleVO.Impl.IfCondition;
import com.mana.autoBuild.operate.singleVO.Impl.InsertCookieOperate;
import com.mana.autoBuild.operate.singleVO.Impl.InsertSingleDateOperate;
import com.mana.autoBuild.operate.singleVO.Impl.NumberOperate;
import com.mana.autoBuild.operate.singleVO.Impl.PageMove;
import com.mana.autoBuild.operate.singleVO.Impl.SessionInputOperate;
import com.mana.autoBuild.operate.singleVO.Impl.SessionOutputOperate;
import com.mana.autoBuild.operate.singleVO.Impl.UpdateSingleDateOperate;
import com.mana.autoBuild.tableVO.AutoOperateSetpVO;
import com.mana.base.tools.sql.DateBaseOperateUtil;
import com.mana.base.tools.tree.TreeUtil;
import com.mana.base.tools.tree.vo.TreeVO;

public class WorkFlowUtil {

	/** 日志对象 */
	static Log logger = LogFactory.getLog(WorkFlowUtil.class);
	
	public static final String WORK_FLOW_GOTO = "WORK_FLOW_GOTO"; 
	
	//把可以操作的步骤对象，放入步骤map中
	public static  Map<String,DecorationSingleVO> autoSetpMap =  new  HashMap<String,DecorationSingleVO>() {{
		           put( "FindSingleDateOperate" , new FindSingleDateOperate()  );
//		           put( "FindSingleDateFromMemcacheOperate" , new FindSingleDateFromMemcacheOperate()  );
		           put( "FindSingleDateFromRequestOperate" , new FindSingleDateFromRequestOperate()  );
		           put( "IfCondition" , new IfCondition()  );
		           put( "NumberOperate" , new NumberOperate());
		           put( "EqualOperate" , new EqualStringOperate());
		           put( "PageMove" , new PageMove());
		           put( "UpdateSingleDateOperate" , new UpdateSingleDateOperate());
		           put( "ExamComplexSqlOperate" , new ExamComplexSqlOperate());
		           put( "SessionOutputOperate" , new SessionOutputOperate());
		           put( "SessionInputOperate" ,  new SessionInputOperate());
		           put( "EvaluateDataFromMapOperate" ,  new EvaluateDataFromMapOperate());
		           put( "InsertSingleDateOperate" ,  new InsertSingleDateOperate());
		           put( "InsertCookieOperate" ,  new InsertCookieOperate());
		           put( "FindIpOperate" ,  new FindIpOperate());
		           
		           
	 }};
	
	//执行工作流节点的 
	 public static Map executeWorkflowByTreeVO(TreeVO vo,HttpServletRequest request,HttpServletResponse response ){
		 Map resultMap = new HashMap();
		 resultMap.put("request", request);
		 resultMap.put("response", response);
		//根节点执行 初始化参数 直接执行页节点
		for(TreeVO treeVo: vo.leafs){
			loopWorkflowByTreeVO(treeVo,resultMap);
		}
		return  resultMap;
	}
	public static void loopWorkflowByTreeVO(TreeVO vo,Map resultMap ){
		AutoOperateSetpVO autoOperateSetp = (AutoOperateSetpVO)vo.getData();
		if(resultMap.get(WorkFlowUtil.WORK_FLOW_GOTO)!=null){
			//工作流 有直接跳转 查看是否是当前工作流名称  
			String gotoSetp = (String) resultMap.get(WorkFlowUtil.WORK_FLOW_GOTO);
			if(gotoSetp!=null){
				if(!gotoSetp.equals(autoOperateSetp.getName())){
					return ;
				}else{
					//清除goto语句 
					resultMap.put(WorkFlowUtil.WORK_FLOW_GOTO,null);
				}
			}
		}	
		//取出步骤类型
		String type = autoOperateSetp.getType();
		DecorationSingleVO operate = autoSetpMap.get(type);
		System.out.println("name=" + autoOperateSetp.getName());
		operate.decorateVO(autoOperateSetp,resultMap);
		//执行完成主节点，然后执行叶节点 
		if(vo.leafs!=null){
			for(TreeVO treeVo: vo.leafs){
				loopWorkflowByTreeVO(treeVo,resultMap);
			}
		}
	}
	
	/**
	 * 根据工作流 id。执行工作流 
	 * @param request
	 * @param response
	 * @param autoSetpId
	 * @return
	 */
	public static Map executeWorkflowById(HttpServletRequest request,HttpServletResponse response,String autoSetpId) {		
		AutoOperateSetpVO autoOperateSetp = new AutoOperateSetpVO();
		autoOperateSetp.setAutoSetpId(autoSetpId);
		List<BaseAutoBuildVO>  list = DateBaseOperateUtil.jdbcSelectMultitermOperate(autoOperateSetp);
		//先把节点id的全部放入map中  
		TreeVO root = TreeUtil.buildTreeFromList(list);
		//开始执行工作流
		Map map = WorkFlowUtil.executeWorkflowByTreeVO(root, request, response);
		return map;
	}
	
	public static void main(String[] args){
		List<BaseAutoBuildVO> list = new ArrayList<BaseAutoBuildVO>();
		//取值 
		AutoOperateSetpVO a1 = new AutoOperateSetpVO();		
		a1.setType("FindSingleDateOperate");
		a1.setParam1("UserInfoTableVO");
		a1.setParam2("UserInfoTableVOResult");
		a1.setParam3("loginName");
		a1.setId("1");
		list.add(a1);
		
		AutoOperateSetpVO a2 = new AutoOperateSetpVO();
		a2.setType("EqualOperate");
		a2.setParam1("EqualOperateResult");
		a2.setParam2("UserInfoTableVOResult.password");
		a2.setParam3("password");
		a1.setId("2");
		list.add(a2);
		TreeVO vo =TreeUtil.buildTreeFromList(list);
	}
	
	
}


