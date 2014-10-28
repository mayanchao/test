package com.mana.base.web.urlMapping.intercept.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectVO {
	
//	public ProjectVO(){
//		List<String> list = new ArrayList<String>();
//		
//	}
	
	//错误信息类  key是编号  value是内容
	public Map<String,String>   errorMsg = new HashMap<String,String>();
	//工程ID
	public String projectId ;
	//角色映射 key=url地址   value= 角色列表
	public Map<String,List>   roleMap = new HashMap<String,List>();
	
	
	public Map<String, String> getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(Map<String, String> errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public Map<String, List> getRoleMap() {
		return roleMap;
	}
	public void setRoleMap(Map<String, List> roleMap) {
		this.roleMap = roleMap;
	}
	
	
	
	
}
 