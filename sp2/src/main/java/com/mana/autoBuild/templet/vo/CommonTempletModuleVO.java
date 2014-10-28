package com.mana.autoBuild.templet.vo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 模板信息传参数专用vo 
 * @author Administrator
 *
 */
public class CommonTempletModuleVO {
	
	
	public String moduleContainId ;//
	public String moduleContainLocation ;//控件对应的模板
	
	
	//设置界面的html
	public String configHtml;
	//显示的html
	public String showHtml;
	
	//主键
	public String id;
	//当前工程ID
	public String projectId;
	//当前控件类型 
	public String moduleType;
	//对应模板的名字 
	public String selfhelpTempletId; 
	
	public HttpServletRequest request;
	
	public HttpServletResponse response;
	
	public boolean re;
	
	
	
	public String getModuleContainId() {
		return moduleContainId;
	}
	public void setModuleContainId(String moduleContainId) {
		this.moduleContainId = moduleContainId;
	}
	public String getModuleContainLocation() {
		return moduleContainLocation;
	}
	public void setModuleContainLocation(String moduleContainLocation) {
		this.moduleContainLocation = moduleContainLocation;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	public boolean isRe() {
		return re;
	}
	public void setRe(boolean re) {
		this.re = re;
	}
	public String getSelfhelpTempletId() {
		return selfhelpTempletId;
	}
	public void setSelfhelpTempletId(String selfhelpTempletId) {
		this.selfhelpTempletId = selfhelpTempletId;
	}
	public String getModuleType() {
		return moduleType;
	}
	public void setModuleType(String moduleType) {
		this.moduleType = moduleType;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getConfigHtml() {
		return configHtml;
	}
	public void setConfigHtml(String configHtml) {
		this.configHtml = configHtml;
	}
	public String getShowHtml() {
		return showHtml;
	}
	public void setShowHtml(String showHtml) {
		this.showHtml = showHtml;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
}
