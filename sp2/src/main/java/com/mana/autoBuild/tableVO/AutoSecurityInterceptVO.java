package com.mana.autoBuild.tableVO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;
 public class AutoSecurityInterceptVO extends BaseAutoBuildVO{ 
    public String id;
    public String name;
    public String projectId;
    public String htmlId;
    public String ajaxId;
    public String roleId;
    public String url;
    public String description;
public String getId(){
  return id ;
}
public void setId( String id){
  this.id=id;
  sqlParam.put( "id",id);
}
public String getName(){
  return name ;
}
public void setName( String name){
  this.name=name;
  sqlParam.put( "name",name);
}
public String getProjectId(){
  return projectId ;
}
public void setProjectId( String projectId){
  this.projectId=projectId;
  sqlParam.put( "project_id",projectId);
}
public String getHtmlId(){
  return htmlId ;
}
public void setHtmlId( String htmlId){
  this.htmlId=htmlId;
  sqlParam.put( "html_id",htmlId);
}
public String getAjaxId(){
  return ajaxId ;
}
public void setAjaxId( String ajaxId){
  this.ajaxId=ajaxId;
  sqlParam.put( "ajax_id",ajaxId);
}
public String getRoleId(){
  return roleId ;
}
public void setRoleId( String roleId){
  this.roleId=roleId;
  sqlParam.put( "role_id",roleId);
}
public String getUrl(){
  return url ;
}
public void setUrl( String url){
  this.url=url;
  sqlParam.put( "url",url);
}
public String getDescription(){
  return description ;
}
public void setDescription( String description){
  this.description=description;
  sqlParam.put( "description",description);
}
 @Override 
 public BaseAutoBuildVO buildResultSetVO(ResultSet resultSet) { 
 AutoSecurityInterceptVO vo = new AutoSecurityInterceptVO(); 
 try{
 vo.id = resultSet.getString("id"); 
 vo.name = resultSet.getString("name"); 
 vo.projectId = resultSet.getString("project_id"); 
 vo.htmlId = resultSet.getString("html_id"); 
 vo.ajaxId = resultSet.getString("ajax_id"); 
 vo.roleId = resultSet.getString("role_id"); 
 vo.url = resultSet.getString("url"); 
 vo.description = resultSet.getString("description"); 
		 return vo;
 } catch (SQLException e) { 
 	return null; 
 }
}
  @Override 
  public void putKeyValue(Object key) {
  id=key.toString();

  }
  @Override 
  public String findKeyValue() {
  return id; 
  }
  @Override 
  public String currentKeyName() {
  return "id"; 
  }
  @Override 
  public String currentTable() {
  return "auto_security_intercept"; 
  }
  @Override 
  public boolean autoSet(String filedName, Object value) {
	if("id".equals(filedName)){
 	this.setId("" + value);
 	return true; 
     }
	if("name".equals(filedName)){
 	this.setName("" + value);
 	return true; 
     }
	if("projectId".equals(filedName)){
 	this.setProjectId("" + value);
 	return true; 
     }
	if("htmlId".equals(filedName)){
 	this.setHtmlId("" + value);
 	return true; 
     }
	if("ajaxId".equals(filedName)){
 	this.setAjaxId("" + value);
 	return true; 
     }
	if("roleId".equals(filedName)){
 	this.setRoleId("" + value);
 	return true; 
     }
	if("url".equals(filedName)){
 	this.setUrl("" + value);
 	return true; 
     }
	if("description".equals(filedName)){
 	this.setDescription("" + value);
 	return true; 
     }
  return false; 
  }
  @Override 
  public Object autoGet(String filedName) {
	if("id".equals(filedName)){ 
 		return  this.getId(); 
 	}
	if("name".equals(filedName)){ 
 		return  this.getName(); 
 	}
	if("projectId".equals(filedName)){ 
 		return  this.getProjectId(); 
 	}
	if("htmlId".equals(filedName)){ 
 		return  this.getHtmlId(); 
 	}
	if("ajaxId".equals(filedName)){ 
 		return  this.getAjaxId(); 
 	}
	if("roleId".equals(filedName)){ 
 		return  this.getRoleId(); 
 	}
	if("url".equals(filedName)){ 
 		return  this.getUrl(); 
 	}
	if("description".equals(filedName)){ 
 		return  this.getDescription(); 
 	}
 return null;  
  }
}