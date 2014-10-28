package com.mana.base.web.urlMapping.intercept;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mana.autoBuild.daoVO.SqlVO;
import com.mana.base.tools.sql.DateBaseOperateUtil;
import com.mana.base.tools.workflow.WorkFlowUtil;
import com.mana.base.web.urlMapping.intercept.vo.ProjectVO;

public class InterceptUtil {
	
	public static Map<String,ProjectVO> interceptMap = new HashMap<String,ProjectVO>(); 
	
	//读取所有工程角色
	public static ProjectVO  buildProjectVO(String projectId){
		String sql = " SELECT b.operate_setp_id as operate_setp_id,a.url,b.name FROM auto_security_role b,auto_security_intercept a " +
					 " WHERE a.project_id = '" + projectId + "' AND b.project_id = '" + projectId + "' AND a.role_id = b.id  ";
		
		String[] parma = {"operate_setp_id","url","name"};
		SqlVO sqlVO  = new SqlVO(sql );
		//图片地址 ，步骤ID 
		List<Map<String,String>> list =  DateBaseOperateUtil.jdbcSelectMultitermOperateBySqlVO(sqlVO,parma);
		
		ProjectVO vo = new ProjectVO();
		vo.setProjectId(projectId);
		Map<String,String> map = new HashMap<String,String>();
		
//		String  roleName = "";
		ProjectVO projectvo = new ProjectVO();
		for(int i=0;i< list.size();i++){
			Map<String,String> valueMap = list.get(i);
//			String name = valueMap.get("name");
//			if(name.equals(roleName)){//是同一种类型
				String url = valueMap.get("url");
				Map<String,List> roleMap =projectvo.getRoleMap();//获得当前工程的角色ID
				//获得当前url 
				if(roleMap.get(url)==null){
					roleMap.put(url, new ArrayList());
				}
				//把当前url对应的步骤ID，放入map的list中
				roleMap.get(url).add(valueMap.get("operate_setp_id"));
//			}
		}
		return vo;
	} 
	//
	
	//初始化当前工程的拦截地址
//	public static void initIntercept(String projectId){
//		ProjectVO projectVO = findProjectVO(projectId);
//		interceptMap.put(projectId, projectVO);
//	}

	
	public static ProjectVO findProjectVO(String projectId){
		if(interceptMap.get(projectId)==null){
			ProjectVO projectVO = findProjectVO(projectId);
			interceptMap.put(projectId, projectVO);
			return projectVO;
		}
		return interceptMap.get(projectId);
	}
	
	/**
	 * 判断 当前用户是否有权限操作 根据url判断 
	 * @param url 当前的url 
	 * @param projectId 当前工程ID
	 * @return
	 */
	public static boolean examUrl(String url,String projectId,HttpServletRequest request,HttpServletResponse response){
		ProjectVO vo = findProjectVO(projectId);
		Map<String, List> map = vo.getRoleMap();
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()){
			String interceptUrl =   it.next();
			if( url.startsWith(interceptUrl)){ //判断是否符合权限拦截规则
				List<String> list = map.get(interceptUrl);
				for(int i=0;i<list.size();i++){ //循环判断是否权限认证通过
					String autoSetpId = list.get(i);
					Map returnMap = WorkFlowUtil.executeWorkflowById(request,response,autoSetpId);
					String re = "" + returnMap.get("returnIntercept");
					if("false".equals(re)){ //一票否决制 ，只要有一个不对，就不运行下面方法
						return false;
					}
				}
			}
		}
		return true;
	}
	
	
	
}
