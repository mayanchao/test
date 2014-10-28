package com.mana.autoBuild.tableVO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;



/**
 * 自动步骤操作vo 
 * @author hc360
 *
 */
public class AutoOperateSetpVO extends BaseAutoBuildVO{
		     
	private String id;
	private String type;
	//页面编号 
	private String autoSetpId;
	private String name;
	//父节点id
	private String parentId;
	private String width;
	private String height;
	private String param1;
	private String param2;
	private String param3;
	private String param4;
	private String param5;
	private String param6;
	private String param7;
	private String param8;
	private String param9;
	private String descript ;
	
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
		
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
		sqlParam.put("parent_Id", parentId);
	}
	
	
	
	public String getAutoSetpId() {
		return autoSetpId;
	}
	public void setAutoSetpId(String autoSetpId) {
		sqlParam.put("auto_setp_id", autoSetpId);
		this.autoSetpId = autoSetpId;
	}
	
	
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
		sqlParam.put("descript", descript);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {		
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
		sqlParam.put("type", type);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		sqlParam.put("name", name);
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
	public boolean autoSet(String filedName, Object value) {
		return false;
	}
	@Override
	public Object autoGet(String filedName) {
		if("parentId".equals(filedName)){
			return this.parentId;
		}else if("name".equals(name)){
			return this.name;
		}
		
		return null;
	}
	
	
	@Override
	public BaseAutoBuildVO buildResultSetVO(ResultSet resultSet) {
		AutoOperateSetpVO vo = new AutoOperateSetpVO();
		 try {
			 vo.id = resultSet.getString("id"); 
			 vo.type =  resultSet.getString("type");
			 vo.name =  resultSet.getString("name");
			 vo.autoSetpId =  resultSet.getString("auto_Setp_Id");
			 vo.parentId =  resultSet.getString("parent_Id");
			 vo.param1 =  resultSet.getString("param1");
			 vo.param2 =  resultSet.getString("param2");
			 vo.param3 =  resultSet.getString("param3");
			 vo.param4 =  resultSet.getString("param4");
			 vo.param5 =  resultSet.getString("param5");
			 vo.param6 =  resultSet.getString("param6");
			 vo.param7 =  resultSet.getString("param7");
			 vo.param8 =  resultSet.getString("param8");
			 vo.param9 =  resultSet.getString("param9");
			return vo;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public void putKeyValue(Object key) {		
		this.setId(key.toString());
	}
	@Override
	public String findKeyValue() {
		return this.id;
	}
	@Override
	public String currentKeyName() {		
		return "id";
	}
	@Override
	public String currentTable() {
		return "Auto_Operate_Setp";
	}
	
}
