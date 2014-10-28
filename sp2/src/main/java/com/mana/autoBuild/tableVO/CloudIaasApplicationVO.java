package com.mana.autoBuild.tableVO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;
 public class CloudIaasApplicationVO extends BaseAutoBuildVO{ 
    public String id;
    public String name;
    public String operateType;
    public String param1;
    public String param2;
    public String param3;
    public String param4;
    public String param5;
    public String param6;
    public String param7;
    public String param8;
    public String param9;
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
public String getOperateType(){
  return operateType ;
}
public void setOperateType( String operateType){
  this.operateType=operateType;
  sqlParam.put( "operate_type",operateType);
}
public String getParam1(){
  return param1 ;
}
public void setParam1( String param1){
  this.param1=param1;
  sqlParam.put( "param1",param1);
}
public String getParam2(){
  return param2 ;
}
public void setParam2( String param2){
  this.param2=param2;
  sqlParam.put( "param2",param2);
}
public String getParam3(){
  return param3 ;
}
public void setParam3( String param3){
  this.param3=param3;
  sqlParam.put( "param3",param3);
}
public String getParam4(){
  return param4 ;
}
public void setParam4( String param4){
  this.param4=param4;
  sqlParam.put( "param4",param4);
}
public String getParam5(){
  return param5 ;
}
public void setParam5( String param5){
  this.param5=param5;
  sqlParam.put( "param5",param5);
}
public String getParam6(){
  return param6 ;
}
public void setParam6( String param6){
  this.param6=param6;
  sqlParam.put( "param6",param6);
}
public String getParam7(){
  return param7 ;
}
public void setParam7( String param7){
  this.param7=param7;
  sqlParam.put( "param7",param7);
}
public String getParam8(){
  return param8 ;
}
public void setParam8( String param8){
  this.param8=param8;
  sqlParam.put( "param8",param8);
}
public String getParam9(){
  return param9 ;
}
public void setParam9( String param9){
  this.param9=param9;
  sqlParam.put( "param9",param9);
}
 @Override 
 public BaseAutoBuildVO buildResultSetVO(ResultSet resultSet) { 
 CloudIaasApplicationVO vo = new CloudIaasApplicationVO(); 
 try{
 vo.id = resultSet.getString("id"); 
 vo.name = resultSet.getString("name"); 
 vo.operateType = resultSet.getString("operate_type"); 
 vo.param1 = resultSet.getString("param1"); 
 vo.param2 = resultSet.getString("param2"); 
 vo.param3 = resultSet.getString("param3"); 
 vo.param4 = resultSet.getString("param4"); 
 vo.param5 = resultSet.getString("param5"); 
 vo.param6 = resultSet.getString("param6"); 
 vo.param7 = resultSet.getString("param7"); 
 vo.param8 = resultSet.getString("param8"); 
 vo.param9 = resultSet.getString("param9"); 
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
  return "cloud_iaas_application"; 
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
	if("operateType".equals(filedName)){
 	this.setOperateType("" + value);
 	return true; 
     }
	if("param1".equals(filedName)){
 	this.setParam1("" + value);
 	return true; 
     }
	if("param2".equals(filedName)){
 	this.setParam2("" + value);
 	return true; 
     }
	if("param3".equals(filedName)){
 	this.setParam3("" + value);
 	return true; 
     }
	if("param4".equals(filedName)){
 	this.setParam4("" + value);
 	return true; 
     }
	if("param5".equals(filedName)){
 	this.setParam5("" + value);
 	return true; 
     }
	if("param6".equals(filedName)){
 	this.setParam6("" + value);
 	return true; 
     }
	if("param7".equals(filedName)){
 	this.setParam7("" + value);
 	return true; 
     }
	if("param8".equals(filedName)){
 	this.setParam8("" + value);
 	return true; 
     }
	if("param9".equals(filedName)){
 	this.setParam9("" + value);
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
	if("operateType".equals(filedName)){ 
 		return  this.getOperateType(); 
 	}
	if("param1".equals(filedName)){ 
 		return  this.getParam1(); 
 	}
	if("param2".equals(filedName)){ 
 		return  this.getParam2(); 
 	}
	if("param3".equals(filedName)){ 
 		return  this.getParam3(); 
 	}
	if("param4".equals(filedName)){ 
 		return  this.getParam4(); 
 	}
	if("param5".equals(filedName)){ 
 		return  this.getParam5(); 
 	}
	if("param6".equals(filedName)){ 
 		return  this.getParam6(); 
 	}
	if("param7".equals(filedName)){ 
 		return  this.getParam7(); 
 	}
	if("param8".equals(filedName)){ 
 		return  this.getParam8(); 
 	}
	if("param9".equals(filedName)){ 
 		return  this.getParam9(); 
 	}
 return null;  
  }
}
