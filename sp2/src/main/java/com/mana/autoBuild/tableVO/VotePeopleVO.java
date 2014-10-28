package com.mana.autoBuild.tableVO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;
 public class VotePeopleVO extends BaseAutoBuildVO{ 
    public String id;
    public String number;
    public String name;
    public String password;
public String getId(){
  return id ;
}
public void setId( String id){
  this.id=id;
  sqlParam.put( "id",id);
}
public String getNumber(){
  return number ;
}
public void setNumber( String number){
  this.number=number;
  sqlParam.put( "number",number);
}
public String getName(){
  return name ;
}
public void setName( String name){
  this.name=name;
  sqlParam.put( "name",name);
}
public String getPassword(){
  return password ;
}
public void setPassword( String password){
  this.password=password;
  sqlParam.put( "password",password);
}
 @Override 
 public BaseAutoBuildVO buildResultSetVO(ResultSet resultSet) { 
 VotePeopleVO vo = new VotePeopleVO(); 
 try{
 vo.id = resultSet.getString("id"); 
 vo.number = resultSet.getString("number"); 
 vo.name = resultSet.getString("name"); 
 vo.password = resultSet.getString("password"); 
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
  return "vote_people"; 
  }
  @Override 
  public boolean autoSet(String filedName, Object value) {
	if("id".equals(filedName)){
 	this.setId("" + value);
     }
	if("number".equals(filedName)){
 	this.setNumber("" + value);
     }
	if("name".equals(filedName)){
 	this.setName("" + value);
     }
	if("password".equals(filedName)){
 	this.setPassword("" + value);
     }
  return false; 
  }
  @Override 
  public Object autoGet(String filedName) {
	if("id".equals(filedName)){ 
 		return  this.getId(); 
 	}
	if("number".equals(filedName)){ 
 		return  this.getNumber(); 
 	}
	if("name".equals(filedName)){ 
 		return  this.getName(); 
 	}
	if("password".equals(filedName)){ 
 		return  this.getPassword(); 
 	}
 return null;  
  }
}