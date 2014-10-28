package com.mana.autoBuild.tableVO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;


//组件vo 
public class CompoundSqlWhereVO extends BaseAutoBuildVO{
	
	public String id;	
	public String compoundSqlId;
	public String whereType;
	public String param1;
	public String param1Type;
	public String param2;
	public String param2Type;
	public String description;
	
	
	
	public String getParam1Type() {
		return param1Type;
	}

	public void setParam1Type(String param1Type) {
		sqlParam.put("Param1_Type", param1Type);
		this.param1Type = param1Type;
	}

	public String getParam2Type() {
		return param2Type;
	}

	public void setParam2Type(String param2Type) {
		sqlParam.put("Param2_Type", param2Type);
		this.param2Type = param2Type;
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		sqlParam.put("id", id);
		this.id = id;
	}

	public String getCompoundSqlId() {
		return compoundSqlId;
	}

	public void setCompoundSqlId(String compoundSqlId) {
		sqlParam.put("compound_Sql_Id", compoundSqlId);
		this.compoundSqlId = compoundSqlId;
	}

	public String getWhereType() {
		return whereType;
	}

	public void setWhereType(String whereType) {
		sqlParam.put("where_type", whereType);
		this.whereType = whereType;
	}

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		sqlParam.put("param1", param1);
		this.param1 = param1;
	}

	public String getParam2() {
		return param2;
	}

	public void setParam2(String param2) {
		sqlParam.put("param2", param2);
		this.param2 = param2;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		sqlParam.put("description", description);
		this.description = description;
	}

	@Override
	public BaseAutoBuildVO buildResultSetVO(ResultSet resultSet) {
		CompoundSqlWhereVO vo = new CompoundSqlWhereVO();
		try {
			vo.id = resultSet.getString("id");
			vo.compoundSqlId =  resultSet.getString("compound_sql_id");
			vo.whereType = resultSet.getString("where_type");
			vo.param1 = resultSet.getString("param1");
			vo.param2 = resultSet.getString("param2");
			vo.param1Type = resultSet.getString("param1_type");
			vo.param2Type = resultSet.getString("param2_type");			
			vo.description =  resultSet.getString("description");
			return vo;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void putKeyValue(Object key) {
		id = key.toString();
		
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
		return "compound_sql_where";
	}

	@Override
	public boolean autoSet(String filedName, Object value) {
		if("id".equals(filedName)){
			this.setId("" + value);
		}else if("compoundSqlId".equals(filedName)){
			this.setCompoundSqlId("" + filedName);
		}else if("description".equals(description)){
			this.setDescription("" + filedName);
		}else if("whereType".equals(filedName)){
			this.setWhereType("" +  filedName);
		}else if("param1".equals(filedName)){
			this.setParam1(filedName);
		}else if("param2".equals(filedName)){
			this.setParam2(filedName);
		}else if("param1Type".equals(filedName)){
			this.setParam1(filedName);
		}else if("param2Type".equals(filedName)){
			this.setParam2(filedName);
		}
		return false;
	}

	@Override
	public Object autoGet(String filedName) {
		if("id".equals(filedName)){
			return getId();
		}else if("compoundSqlId".equals(filedName)){
			return getCompoundSqlId();
		}else if("description".equals(filedName)){
			return getDescription();
		}else if("whereType".equals(filedName)){
			return getWhereType();
		}else if("param1".equals(filedName)){
			return getParam1();
		}else if("param2".equals(filedName)){
			return getParam2();
		}else if("param1Type".equals(filedName)){
			return getParam1Type();
		}else if("param2Type".equals(filedName)){
			return getParam1Type();
		}
		return null;
	}

		
	
	
}
