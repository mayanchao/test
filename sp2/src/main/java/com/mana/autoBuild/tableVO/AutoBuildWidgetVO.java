package com.mana.autoBuild.tableVO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;
 public class AutoBuildWidgetVO extends BaseAutoBuildVO{ 
    public String widgetId;
    public String id;
    public String type;
    public String htmlId;
    public String descript;
    public String width;
    public String height;
    public String validate;
    public String css;
    public String positionLeft;
    public String positionTop;
    public String selfjson;
    public String param1;
    public String param2;
    public String param3;
    public String param4;
    public String param5;
    public String param6;
    public String param7;
    public String param8;
    public String param9;
    public String paramBig1;
public String getWidgetId(){
  return widgetId ;
}
public void setWidgetId( String widgetId){
  this.widgetId=widgetId;
  sqlParam.put( "widget_Id",widgetId);
}
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
public String getHtmlId(){
  return htmlId ;
}
public void setHtmlId( String htmlId){
  this.htmlId=htmlId;
  sqlParam.put( "html_ID",htmlId);
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
public String getValidate(){
  return validate ;
}
public void setValidate( String validate){
  this.validate=validate;
  sqlParam.put( "validate",validate);
}
public String getCss(){
  return css ;
}
public void setCss( String css){
  this.css=css;
  sqlParam.put( "css",css);
}
public String getPositionLeft(){
  return positionLeft ;
}
public void setPositionLeft( String positionLeft){
  this.positionLeft=positionLeft;
  sqlParam.put( "position_Left",positionLeft);
}
public String getPositionTop(){
  return positionTop ;
}
public void setPositionTop( String positionTop){
  this.positionTop=positionTop;
  sqlParam.put( "position_Top",positionTop);
}
public String getSelfjson(){
  return selfjson ;
}
public void setSelfjson( String selfjson){
  this.selfjson=selfjson;
  sqlParam.put( "selfJson",selfjson);
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
public String getParamBig1(){
  return paramBig1 ;
}
public void setParamBig1( String paramBig1){
  this.paramBig1=paramBig1;
  sqlParam.put( "param_big1",paramBig1);
}
 @Override 
 public BaseAutoBuildVO buildResultSetVO(ResultSet resultSet) { 
 AutoBuildWidgetVO vo = new AutoBuildWidgetVO(); 
 try{
 vo.widgetId = resultSet.getString("widget_Id"); 
 vo.id = resultSet.getString("id"); 
 vo.type = resultSet.getString("type"); 
 vo.htmlId = resultSet.getString("html_ID"); 
 vo.descript = resultSet.getString("descript"); 
 vo.width = resultSet.getString("width"); 
 vo.height = resultSet.getString("height"); 
 vo.validate = resultSet.getString("validate"); 
 vo.css = resultSet.getString("css"); 
 vo.positionLeft = resultSet.getString("position_Left"); 
 vo.positionTop = resultSet.getString("position_Top"); 
 vo.selfjson = resultSet.getString("selfJson"); 
 vo.param1 = resultSet.getString("param1"); 
 vo.param2 = resultSet.getString("param2"); 
 vo.param3 = resultSet.getString("param3"); 
 vo.param4 = resultSet.getString("param4"); 
 vo.param5 = resultSet.getString("param5"); 
 vo.param6 = resultSet.getString("param6"); 
 vo.param7 = resultSet.getString("param7"); 
 vo.param8 = resultSet.getString("param8"); 
 vo.param9 = resultSet.getString("param9"); 
 vo.paramBig1 = resultSet.getString("param_big1"); 
		 return vo;
 } catch (SQLException e) { 
 	return null; 
 }
}
  @Override 
  public void putKeyValue(Object key) {
  widgetId=key.toString();

  }
  @Override 
  public String findKeyValue() {
  return widgetId; 
  }
  @Override 
  public String currentKeyName() {
  return "widget_Id"; 
  }
  @Override 
  public String currentTable() {
  return "AUTO_BUILD_WIDGET"; 
  }
  @Override 
  public boolean autoSet(String filedName, Object value) {
	if("widgetId".equals(filedName)){
 	this.setWidgetId("" + value);
 	return true; 
     }
	if("id".equals(filedName)){
 	this.setId("" + value);
 	return true; 
     }
	if("type".equals(filedName)){
 	this.setType("" + value);
 	return true; 
     }
	if("htmlId".equals(filedName)){
 	this.setHtmlId("" + value);
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
	if("validate".equals(filedName)){
 	this.setValidate("" + value);
 	return true; 
     }
	if("css".equals(filedName)){
 	this.setCss("" + value);
 	return true; 
     }
	if("positionLeft".equals(filedName)){
 	this.setPositionLeft("" + value);
 	return true; 
     }
	if("positionTop".equals(filedName)){
 	this.setPositionTop("" + value);
 	return true; 
     }
	if("selfjson".equals(filedName)){
 	this.setSelfjson("" + value);
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
	if("paramBig1".equals(filedName)){
 	this.setParamBig1("" + value);
 	return true; 
     }
  return false; 
  }
  @Override 
  public Object autoGet(String filedName) {
	if("widgetId".equals(filedName)){ 
 		return  this.getWidgetId(); 
 	}
	if("id".equals(filedName)){ 
 		return  this.getId(); 
 	}
	if("type".equals(filedName)){ 
 		return  this.getType(); 
 	}
	if("htmlId".equals(filedName)){ 
 		return  this.getHtmlId(); 
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
	if("validate".equals(filedName)){ 
 		return  this.getValidate(); 
 	}
	if("css".equals(filedName)){ 
 		return  this.getCss(); 
 	}
	if("positionLeft".equals(filedName)){ 
 		return  this.getPositionLeft(); 
 	}
	if("positionTop".equals(filedName)){ 
 		return  this.getPositionTop(); 
 	}
	if("selfjson".equals(filedName)){ 
 		return  this.getSelfjson(); 
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
	if("paramBig1".equals(filedName)){ 
 		return  this.getParamBig1(); 
 	}
 return null;  
  }
}