package com.mana.autoBuild.tableVO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;


//通用的 组件vo 所有自动生成的组件 
public class AutoBuildWidgetVO2 extends BaseAutoBuildVO{

	public String widgetId;
	public String id;
	public String type;
	public String htmlID;
	public String descript;
	public int width;
	public int height;
	public int positionLeft;
	public int positionTop;
	public String selfJson;
	public String validate;
	public String param1;
	public String param2;
	public String param3;
	public String param4;
	public String param5;
	public String param6;
	public String param7;
	public String param8;
	public String param9;
	
	
	
	
	public String getWidgetId() {
		return widgetId;
	}

	public void setWidgetId(String widgetId) {
		this.widgetId = widgetId;
		sqlParam.put("widget_Id", widgetId);
	}
	
	

	public String getValidate() {
		return validate;
	}

	public void setValidate(String validate) {
		this.validate = validate;
		sqlParam.put("validate", validate);
	}

	public int getPositionLeft() {
		return positionLeft;
	}

	public void setPositionLeft(int positionLeft) {
		this.positionLeft = positionLeft;
		sqlParam.put("position_Left", positionLeft);
	}

	public int getPositionTop() {
		return positionTop;
	}

	public void setPositionTop(int positionTop) {
		this.positionTop = positionTop;
		sqlParam.put("position_Top", positionTop);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
		sqlParam.put("id", id);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
		sqlParam.put("type", type);
	}

	public String getHtmlID() {
		return htmlID;
	}

	public void setHtmlID(String htmlID) {
		this.htmlID = htmlID;
		sqlParam.put("html_ID", htmlID);
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
		sqlParam.put("descript", descript);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
		sqlParam.put("width", width);
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
		sqlParam.put("height", height);
	}

	
	public String getSelfJson() {
		return selfJson;
	}

	public void setSelfJson(String selfJson) {
		this.selfJson = selfJson;
		sqlParam.put("selfJson", selfJson);
	}

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
			sqlParam.put("param1", param1);
	}

	public String getParam2() {
		return param2;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
		sqlParam.put("param2", param2);
	}

	public String getParam3() {
		return param3;
	}

	public void setParam3(String param3) {
		this.param3 = param3;
		sqlParam.put("param3", param3);
	}

	public String getParam4() {
		return param4;
	}

	public void setParam4(String param4) {
		this.param4 = param4;
		sqlParam.put("param4", param4);
	}

	public String getParam5() {
		return param5;
	}

	public void setParam5(String param5) {
		this.param5 = param5;
		sqlParam.put("param5", param5);
	}

	public String getParam6() {
		return param6;
	}

	public void setParam6(String param6) {
		this.param6 = param6;
		sqlParam.put("param6", param6);
	}

	public String getParam7() {
		return param7;
	}

	public void setParam7(String param7) {
		this.param7 = param7;
		sqlParam.put("param7", param7);
	}

	public String getParam8() {
		return param8;
	}

	public void setParam8(String param8) {
		this.param8 = param8;
		sqlParam.put("param8", param8);
	}

	public String getParam9() {
		return param9;
	}

	public void setParam9(String param9) {
		this.param9 = param9;
		sqlParam.put("param9", param9);
	}

	
	@Override
	public BaseAutoBuildVO buildResultSetVO(ResultSet resultSet) {		
		AutoBuildWidgetVO2 vo = new AutoBuildWidgetVO2();
		 try {
			vo.id = resultSet.getString("id");
			vo.type= resultSet.getString("type");
			vo.widgetId= resultSet.getString("widget_Id");
			vo.htmlID = resultSet.getString("html_ID");
			vo.descript = resultSet.getString("descript");
			vo.width = resultSet.getInt("width");
			vo.height = resultSet.getInt("height");
			vo.positionLeft = resultSet.getInt("position_Left");
			vo.positionTop = resultSet.getInt("position_Top");
			vo.selfJson = resultSet.getString("selfJson");
			vo.validate = resultSet.getString("validate");
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
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void putKeyValue(Object key) {
		widgetId = key.toString();
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
		return false;
	}

	@Override
	public Object autoGet(String filedName) {
		return null;
	}
	
	
	
}
