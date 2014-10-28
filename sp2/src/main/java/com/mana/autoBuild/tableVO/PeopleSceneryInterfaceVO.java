package com.mana.autoBuild.tableVO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;
 public class PeopleSceneryInterfaceVO extends BaseAutoBuildVO{ 
    public String id;
    public String votePeopleId;
    public String sceneryId;
public String getId(){
  return id ;
}
public void setId( String id){
  this.id=id;
  sqlParam.put( "id",id);
}
public String getVotePeopleId(){
  return votePeopleId ;
}
public void setVotePeopleId( String votePeopleId){
  this.votePeopleId=votePeopleId;
  sqlParam.put( "vote_people_id",votePeopleId);
}
public String getSceneryId(){
  return sceneryId ;
}
public void setSceneryId( String sceneryId){
  this.sceneryId=sceneryId;
  sqlParam.put( "scenery_id",sceneryId);
}
 @Override 
 public BaseAutoBuildVO buildResultSetVO(ResultSet resultSet) { 
 PeopleSceneryInterfaceVO vo = new PeopleSceneryInterfaceVO(); 
 try{
 vo.id = resultSet.getString("id"); 
 vo.votePeopleId = resultSet.getString("vote_people_id"); 
 vo.sceneryId = resultSet.getString("scenery_id"); 
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
  return "people_scenery_interface"; 
  }
  @Override 
  public boolean autoSet(String filedName, Object value) {
	if("id".equals(filedName)){
 	this.setId("" + value);
     }
	if("votePeopleId".equals(filedName)){
 	this.setVotePeopleId("" + value);
     }
	if("sceneryId".equals(filedName)){
 	this.setSceneryId("" + value);
     }
  return false; 
  }
  @Override 
  public Object autoGet(String filedName) {
	if("id".equals(filedName)){ 
 		return  this.getId(); 
 	}
	if("votePeopleId".equals(filedName)){ 
 		return  this.getVotePeopleId(); 
 	}
	if("sceneryId".equals(filedName)){ 
 		return  this.getSceneryId(); 
 	}
 return null;  
  }
}