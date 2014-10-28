package com.mana.base.web.busin.action;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.mana.autoBuild.daoVO.SqlVO;
import com.mana.base.tools.sql.DateBaseOperateUtil;
import com.mana.base.web.BaseActionClass;

/**
 * 业务类
 * @author hc360
 *
 */
public class BusinTableAction  extends BaseActionClass{
	
	/**
	 * 查找用户页面配置了那些角色
	 * @param request
	 * @param response
	 * @return
	 */
	//http://localhost:8080/web/busin/action/BusinTableAction_findProjectInterceptAndRole.do1?projectId=ccc
	public ModelAndView findProjectInterceptAndRole(HttpServletRequest request,HttpServletResponse response){
		String projectId = request.getParameter("projectId");
		String name = request.getParameter("name");
		
		String sql = "SELECT b.name,b.id  FROM auto_security_role b,auto_security_intercept a " + 
			" where a.project_id = '" + projectId + "' and " +
			" b.project_id = '" + projectId + "' and  " +
			" a.role_id = b.id " +  
			" and a.name='" + name + "' "
			;
		
		String[] parma = {"name","id"};
		SqlVO sqlVO  = new SqlVO(sql );
		List<Map<String,String>> list =  DateBaseOperateUtil.jdbcSelectMultitermOperateBySqlVO(sqlVO,parma);
		return buildJsonModelAndView(list);
	}
	
	
}

