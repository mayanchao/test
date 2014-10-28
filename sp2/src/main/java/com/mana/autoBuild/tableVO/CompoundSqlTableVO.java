package com.mana.autoBuild.tableVO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;


//组件vo 
public class CompoundSqlTableVO extends BaseAutoBuildVO{
	
	public String id;	
	public String compoundSqlId;
	public String tableName;
	public String description;
	
	
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		sqlParam.put("table_name", tableName);
		this.tableName = tableName;
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
		System.out.println("set .................");
		sqlParam.put("compound_sql_id", compoundSqlId);
		this.compoundSqlId = compoundSqlId;
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
		CompoundSqlTableVO vo = new CompoundSqlTableVO();
		try {
			vo.id = resultSet.getString("id");
			vo.compoundSqlId =  resultSet.getString("compound_sql_id");
			vo.tableName = resultSet.getString("table_name");
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
		return "compound_sql_table";
	}

	@Override
	public boolean autoSet(String filedName, Object value) {
		if("id".equals(filedName)){
			this.setId("" + value);
		}else if("compoundSqlId".equals(filedName)){
			this.setCompoundSqlId("" + filedName);
		}else if("description".equals(description)){
			this.setDescription("" + filedName);
		}else if("tableName".equals(tableName)){
			this.setTableName("" +  filedName);
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
		}else if("tableName".equals(filedName)){
			return getTableName();
		}
		return null;
	}

		
	
	
}
