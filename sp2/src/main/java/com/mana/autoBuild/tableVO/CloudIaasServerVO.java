package com.mana.autoBuild.tableVO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;
 public class CloudIaasServerVO extends BaseAutoBuildVO{ 
    public String id;
    public String name;
    public String ip;
    public String password;
    public String username;
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
public String getIp(){
  return ip ;
}
public void setIp( String ip){
  this.ip=ip;
  sqlParam.put( "ip",ip);
}
public String getPassword(){
  return password ;
}
public void setPassword( String password){
  this.password=password;
  sqlParam.put( "password",password);
}
public String getUsername(){
  return username ;
}
public void setUsername( String username){
  this.username=username;
  sqlParam.put( "username",username);
}
 @Override 
 public BaseAutoBuildVO buildResultSetVO(ResultSet resultSet) { 
 CloudIaasServerVO vo = new CloudIaasServerVO(); 
 try{
 vo.id = resultSet.getString("id"); 
 vo.name = resultSet.getString("name"); 
 vo.ip = resultSet.getString("ip"); 
 vo.password = resultSet.getString("password"); 
 vo.username = resultSet.getString("username"); 
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
  return "cloud_iaas_server"; 
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
	if("ip".equals(filedName)){
 	this.setIp("" + value);
 	return true; 
     }
	if("password".equals(filedName)){
 	this.setPassword("" + value);
 	return true; 
     }
	if("username".equals(filedName)){
 	this.setUsername("" + value);
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
	if("ip".equals(filedName)){ 
 		return  this.getIp(); 
 	}
	if("password".equals(filedName)){ 
 		return  this.getPassword(); 
 	}
	if("username".equals(filedName)){ 
 		return  this.getUsername(); 
 	}
 return null;  
  }
}
