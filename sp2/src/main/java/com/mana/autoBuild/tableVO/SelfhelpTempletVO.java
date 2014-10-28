package com.mana.autoBuild.tableVO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;
 public class SelfhelpTempletVO extends BaseAutoBuildVO{ 
    public String id;
    public String projectId;
    public String type;
    public String descript;
    public String locationJson;
public String getId(){
  return id ;
}
public void setId( String id){
  this.id=id;
  sqlParam.put( "id",id);
}
public String getProjectId(){
  return projectId ;
}
public void setProjectId( String projectId){
  this.projectId=projectId;
  sqlParam.put( "project_id",projectId);
}
public String getType(){
  return type ;
}
public void setType( String type){
  this.type=type;
  sqlParam.put( "type",type);
}
public String getDescript(){
  return descript ;
}
public void setDescript( String descript){
  this.descript=descript;
  sqlParam.put( "descript",descript);
}
public String getLocationJson(){
  return locationJson ;
}
public void setLocationJson( String locationJson){
  this.locationJson=locationJson;
  sqlParam.put( "location_Json",locationJson);
}
 @Override 
 public BaseAutoBuildVO buildResultSetVO(ResultSet resultSet) { 
 SelfhelpTempletVO vo = new SelfhelpTempletVO(); 
 try{
 vo.id = resultSet.getString("id"); 
 vo.projectId = resultSet.getString("project_id"); 
 vo.type = resultSet.getString("type"); 
 vo.descript = resultSet.getString("descript"); 
 vo.locationJson = resultSet.getString("location_Json"); 
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
  return "selfhelp_templet"; 
  }
  @Override 
  public boolean autoSet(String filedName, Object value) {
	if("id".equals(filedName)){
 	this.setId("" + value);
 	return true; 
     }
	if("projectId".equals(filedName)){
 	this.setProjectId("" + value);
 	return true; 
     }
	if("type".equals(filedName)){
 	this.setType("" + value);
 	return true; 
     }
	if("descript".equals(filedName)){
 	this.setDescript("" + value);
 	return true; 
     }
	if("locationJson".equals(filedName)){
 	this.setLocationJson("" + value);
 	return true; 
     }
  return false; 
  }
  @Override 
  public Object autoGet(String filedName) {
	if("id".equals(filedName)){ 
 		return  this.getId(); 
 	}
	if("projectId".equals(filedName)){ 
 		return  this.getProjectId(); 
 	}
	if("type".equals(filedName)){ 
 		return  this.getType(); 
 	}
	if("descript".equals(filedName)){ 
 		return  this.getDescript(); 
 	}
	if("locationJson".equals(filedName)){ 
 		return  this.getLocationJson(); 
 	}
 return null;  
  }
}

