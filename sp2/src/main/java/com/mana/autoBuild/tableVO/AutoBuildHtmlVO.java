package com.mana.autoBuild.tableVO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;
 public class AutoBuildHtmlVO extends BaseAutoBuildVO{ 
    public String id;
    public String topMenuId;
    public String name;
    public String leftMenuId;
    public String htmlId;
    public String onload1;
    public String onload2;
    public String onlyDiv;
    public String description;
    public String projectId;
public String getId(){
  return id ;
}
public void setId( String id){
  this.id=id;
  sqlParam.put( "id",id);
}
public String getTopMenuId(){
  return topMenuId ;
}
public void setTopMenuId( String topMenuId){
  this.topMenuId=topMenuId;
  sqlParam.put( "top_menu_id",topMenuId);
}
public String getName(){
  return name ;
}
public void setName( String name){
  this.name=name;
  sqlParam.put( "name",name);
}
public String getLeftMenuId(){
  return leftMenuId ;
}
public void setLeftMenuId( String leftMenuId){
  this.leftMenuId=leftMenuId;
  sqlParam.put( "left_menu_id",leftMenuId);
}
public String getHtmlId(){
  return htmlId ;
}
public void setHtmlId( String htmlId){
  this.htmlId=htmlId;
  sqlParam.put( "html_ID",htmlId);
}
public String getOnload1(){
  return onload1 ;
}
public void setOnload1( String onload1){
  this.onload1=onload1;
  sqlParam.put( "onload1",onload1);
}
public String getOnload2(){
  return onload2 ;
}
public void setOnload2( String onload2){
  this.onload2=onload2;
  sqlParam.put( "onload2",onload2);
}
public String getOnlyDiv(){
  return onlyDiv ;
}
public void setOnlyDiv( String onlyDiv){
  this.onlyDiv=onlyDiv;
  sqlParam.put( "only_Div",onlyDiv);
}
public String getDescription(){
  return description ;
}
public void setDescription( String description){
  this.description=description;
  sqlParam.put( "description",description);
}
public String getProjectId(){
  return projectId ;
}
public void setProjectId( String projectId){
  this.projectId=projectId;
  sqlParam.put( "project_id",projectId);
}
 @Override 
 public BaseAutoBuildVO buildResultSetVO(ResultSet resultSet) { 
 AutoBuildHtmlVO vo = new AutoBuildHtmlVO(); 
 try{
 vo.id = resultSet.getString("id"); 
 vo.topMenuId = resultSet.getString("top_menu_id"); 
 vo.name = resultSet.getString("name"); 
 vo.leftMenuId = resultSet.getString("left_menu_id"); 
 vo.htmlId = resultSet.getString("html_ID"); 
 vo.onload1 = resultSet.getString("onload1"); 
 vo.onload2 = resultSet.getString("onload2"); 
 vo.onlyDiv = resultSet.getString("only_Div"); 
 vo.description = resultSet.getString("description"); 
 vo.projectId = resultSet.getString("project_id"); 
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
  return "auto_build_html"; 
  }
  @Override 
  public boolean autoSet(String filedName, Object value) {
	if("id".equals(filedName)){
 	this.setId("" + value);
 	return true; 
     }
	if("topMenuId".equals(filedName)){
 	this.setTopMenuId("" + value);
 	return true; 
     }
	if("name".equals(filedName)){
 	this.setName("" + value);
 	return true; 
     }
	if("leftMenuId".equals(filedName)){
 	this.setLeftMenuId("" + value);
 	return true; 
     }
	if("htmlId".equals(filedName)){
 	this.setHtmlId("" + value);
 	return true; 
     }
	if("onload1".equals(filedName)){
 	this.setOnload1("" + value);
 	return true; 
     }
	if("onload2".equals(filedName)){
 	this.setOnload2("" + value);
 	return true; 
     }
	if("onlyDiv".equals(filedName)){
 	this.setOnlyDiv("" + value);
 	return true; 
     }
	if("description".equals(filedName)){
 	this.setDescription("" + value);
 	return true; 
     }
	if("projectId".equals(filedName)){
 	this.setProjectId("" + value);
 	return true; 
     }
  return false; 
  }
  @Override 
  public Object autoGet(String filedName) {
	if("id".equals(filedName)){ 
 		return  this.getId(); 
 	}
	if("topMenuId".equals(filedName)){ 
 		return  this.getTopMenuId(); 
 	}
	if("name".equals(filedName)){ 
 		return  this.getName(); 
 	}
	if("leftMenuId".equals(filedName)){ 
 		return  this.getLeftMenuId(); 
 	}
	if("htmlId".equals(filedName)){ 
 		return  this.getHtmlId(); 
 	}
	if("onload1".equals(filedName)){ 
 		return  this.getOnload1(); 
 	}
	if("onload2".equals(filedName)){ 
 		return  this.getOnload2(); 
 	}
	if("onlyDiv".equals(filedName)){ 
 		return  this.getOnlyDiv(); 
 	}
	if("description".equals(filedName)){ 
 		return  this.getDescription(); 
 	}
	if("projectId".equals(filedName)){ 
 		return  this.getProjectId(); 
 	}
 return null;  
  }
}