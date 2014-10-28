package com.mana.autoBuild.tableVO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;
 public class SelfhelpTempletModuleVO extends BaseAutoBuildVO{ 
    public String id;
    public String type;
    public String descript;
    public String width;
    public String height;
    public String param1;
    public String param2;
    public String param3;
    public String param4;
    public String param5;
    public String param6;
    public String param7;
    public String param8;
    public String param9;
    public String param10;
    public String extparam1;
    public String extparam2;
    public String extparam3;
    public String extparam4;
    public String extparam5;
    public String extparam6;
    public String extparam7;
    public String extparam8;
    public String extparam9;
    public String extparam10;
    public String projectId;
    public String selfhelpTempletId;
    public String moduleContainId;
    public String moduleContainLocation;
public String getId(){
  return id ;
}
public void setId( String id){
  this.id=id;
  sqlParam.put( "id",id);
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
public String getWidth(){
  return width ;
}
public void setWidth( String width){
  this.width=width;
  sqlParam.put( "width",width);
}
public String getHeight(){
  return height ;
}
public void setHeight( String height){
  this.height=height;
  sqlParam.put( "height",height);
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
public String getParam10(){
  return param10 ;
}
public void setParam10( String param10){
  this.param10=param10;
  sqlParam.put( "param10",param10);
}
public String getExtparam1(){
  return extparam1 ;
}
public void setExtparam1( String extparam1){
  this.extparam1=extparam1;
  sqlParam.put( "extparam1",extparam1);
}
public String getExtparam2(){
  return extparam2 ;
}
public void setExtparam2( String extparam2){
  this.extparam2=extparam2;
  sqlParam.put( "extparam2",extparam2);
}
public String getExtparam3(){
  return extparam3 ;
}
public void setExtparam3( String extparam3){
  this.extparam3=extparam3;
  sqlParam.put( "extparam3",extparam3);
}
public String getExtparam4(){
  return extparam4 ;
}
public void setExtparam4( String extparam4){
  this.extparam4=extparam4;
  sqlParam.put( "extparam4",extparam4);
}
public String getExtparam5(){
  return extparam5 ;
}
public void setExtparam5( String extparam5){
  this.extparam5=extparam5;
  sqlParam.put( "extparam5",extparam5);
}
public String getExtparam6(){
  return extparam6 ;
}
public void setExtparam6( String extparam6){
  this.extparam6=extparam6;
  sqlParam.put( "extparam6",extparam6);
}
public String getExtparam7(){
  return extparam7 ;
}
public void setExtparam7( String extparam7){
  this.extparam7=extparam7;
  sqlParam.put( "extparam7",extparam7);
}
public String getExtparam8(){
  return extparam8 ;
}
public void setExtparam8( String extparam8){
  this.extparam8=extparam8;
  sqlParam.put( "extparam8",extparam8);
}
public String getExtparam9(){
  return extparam9 ;
}
public void setExtparam9( String extparam9){
  this.extparam9=extparam9;
  sqlParam.put( "extparam9",extparam9);
}
public String getExtparam10(){
  return extparam10 ;
}
public void setExtparam10( String extparam10){
  this.extparam10=extparam10;
  sqlParam.put( "extparam10",extparam10);
}
public String getProjectId(){
  return projectId ;
}
public void setProjectId( String projectId){
  this.projectId=projectId;
  sqlParam.put( "project_Id",projectId);
}
public String getSelfhelpTempletId(){
  return selfhelpTempletId ;
}
public void setSelfhelpTempletId( String selfhelpTempletId){
  this.selfhelpTempletId=selfhelpTempletId;
  sqlParam.put( "selfhelp_templet_id",selfhelpTempletId);
}
public String getModuleContainId(){
  return moduleContainId ;
}
public void setModuleContainId( String moduleContainId){
  this.moduleContainId=moduleContainId;
  sqlParam.put( "module_contain_id",moduleContainId);
}
public String getModuleContainLocation(){
  return moduleContainLocation ;
}
public void setModuleContainLocation( String moduleContainLocation){
  this.moduleContainLocation=moduleContainLocation;
  sqlParam.put( "module_contain_location",moduleContainLocation);
}
 @Override 
 public BaseAutoBuildVO buildResultSetVO(ResultSet resultSet) { 
 SelfhelpTempletModuleVO vo = new SelfhelpTempletModuleVO(); 
 try{
 vo.id = resultSet.getString("id"); 
 vo.type = resultSet.getString("type"); 
 vo.descript = resultSet.getString("descript"); 
 vo.width = resultSet.getString("width"); 
 vo.height = resultSet.getString("height"); 
 vo.param1 = resultSet.getString("param1"); 
 vo.param2 = resultSet.getString("param2"); 
 vo.param3 = resultSet.getString("param3"); 
 vo.param4 = resultSet.getString("param4"); 
 vo.param5 = resultSet.getString("param5"); 
 vo.param6 = resultSet.getString("param6"); 
 vo.param7 = resultSet.getString("param7"); 
 vo.param8 = resultSet.getString("param8"); 
 vo.param9 = resultSet.getString("param9"); 
 vo.param10 = resultSet.getString("param10"); 
 vo.extparam1 = resultSet.getString("extparam1"); 
 vo.extparam2 = resultSet.getString("extparam2"); 
 vo.extparam3 = resultSet.getString("extparam3"); 
 vo.extparam4 = resultSet.getString("extparam4"); 
 vo.extparam5 = resultSet.getString("extparam5"); 
 vo.extparam6 = resultSet.getString("extparam6"); 
 vo.extparam7 = resultSet.getString("extparam7"); 
 vo.extparam8 = resultSet.getString("extparam8"); 
 vo.extparam9 = resultSet.getString("extparam9"); 
 vo.extparam10 = resultSet.getString("extparam10"); 
 vo.projectId = resultSet.getString("project_Id"); 
 vo.selfhelpTempletId = resultSet.getString("selfhelp_templet_id"); 
 vo.moduleContainId = resultSet.getString("module_contain_id"); 
 vo.moduleContainLocation = resultSet.getString("module_contain_location"); 
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
  return "Selfhelp_Templet_Module"; 
  }
  @Override 
  public boolean autoSet(String filedName, Object value) {
	if("id".equals(filedName)){
 	this.setId("" + value);
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
	if("width".equals(filedName)){
 	this.setWidth("" + value);
 	return true; 
     }
	if("height".equals(filedName)){
 	this.setHeight("" + value);
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
	if("param10".equals(filedName)){
 	this.setParam10("" + value);
 	return true; 
     }
	if("extparam1".equals(filedName)){
 	this.setExtparam1("" + value);
 	return true; 
     }
	if("extparam2".equals(filedName)){
 	this.setExtparam2("" + value);
 	return true; 
     }
	if("extparam3".equals(filedName)){
 	this.setExtparam3("" + value);
 	return true; 
     }
	if("extparam4".equals(filedName)){
 	this.setExtparam4("" + value);
 	return true; 
     }
	if("extparam5".equals(filedName)){
 	this.setExtparam5("" + value);
 	return true; 
     }
	if("extparam6".equals(filedName)){
 	this.setExtparam6("" + value);
 	return true; 
     }
	if("extparam7".equals(filedName)){
 	this.setExtparam7("" + value);
 	return true; 
     }
	if("extparam8".equals(filedName)){
 	this.setExtparam8("" + value);
 	return true; 
     }
	if("extparam9".equals(filedName)){
 	this.setExtparam9("" + value);
 	return true; 
     }
	if("extparam10".equals(filedName)){
 	this.setExtparam10("" + value);
 	return true; 
     }
	if("projectId".equals(filedName)){
 	this.setProjectId("" + value);
 	return true; 
     }
	if("selfhelpTempletId".equals(filedName)){
 	this.setSelfhelpTempletId("" + value);
 	return true; 
     }
	if("moduleContainId".equals(filedName)){
 	this.setModuleContainId("" + value);
 	return true; 
     }
	if("moduleContainLocation".equals(filedName)){
 	this.setModuleContainLocation("" + value);
 	return true; 
     }
  return false; 
  }
  @Override 
  public Object autoGet(String filedName) {
	if("id".equals(filedName)){ 
 		return  this.getId(); 
 	}
	if("type".equals(filedName)){ 
 		return  this.getType(); 
 	}
	if("descript".equals(filedName)){ 
 		return  this.getDescript(); 
 	}
	if("width".equals(filedName)){ 
 		return  this.getWidth(); 
 	}
	if("height".equals(filedName)){ 
 		return  this.getHeight(); 
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
	if("param10".equals(filedName)){ 
 		return  this.getParam10(); 
 	}
	if("extparam1".equals(filedName)){ 
 		return  this.getExtparam1(); 
 	}
	if("extparam2".equals(filedName)){ 
 		return  this.getExtparam2(); 
 	}
	if("extparam3".equals(filedName)){ 
 		return  this.getExtparam3(); 
 	}
	if("extparam4".equals(filedName)){ 
 		return  this.getExtparam4(); 
 	}
	if("extparam5".equals(filedName)){ 
 		return  this.getExtparam5(); 
 	}
	if("extparam6".equals(filedName)){ 
 		return  this.getExtparam6(); 
 	}
	if("extparam7".equals(filedName)){ 
 		return  this.getExtparam7(); 
 	}
	if("extparam8".equals(filedName)){ 
 		return  this.getExtparam8(); 
 	}
	if("extparam9".equals(filedName)){ 
 		return  this.getExtparam9(); 
 	}
	if("extparam10".equals(filedName)){ 
 		return  this.getExtparam10(); 
 	}
	if("projectId".equals(filedName)){ 
 		return  this.getProjectId(); 
 	}
	if("selfhelpTempletId".equals(filedName)){ 
 		return  this.getSelfhelpTempletId(); 
 	}
	if("moduleContainId".equals(filedName)){ 
 		return  this.getModuleContainId(); 
 	}
	if("moduleContainLocation".equals(filedName)){ 
 		return  this.getModuleContainLocation(); 
 	}
 return null;  
  }
}
