package com.mana.autoBuild.tableVO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;


//组件vo 
public class CompoundSqlShowVO extends BaseAutoBuildVO{
	
	public String id;	
	public String compoundSqlId;
	public String tableColumn;
	public String tableNameAils;
	public String description;
	
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

	
	
	public String getTableColumn() {
		return tableColumn;
	}

	public void setTableColumn(String tableColumn) {
		sqlParam.put("table_column", tableColumn);
		this.tableColumn = tableColumn;
	}

	public String getTableNameAils() {
		return tableNameAils;
	}

	public void setTableNameAils(String tableNameAils) {
		sqlParam.put("table_name_ails", tableNameAils);
		this.tableNameAils = tableNameAils;
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
		CompoundSqlShowVO vo = new CompoundSqlShowVO();
		try {
			vo.id = resultSet.getString("id");
			vo.compoundSqlId =  resultSet.getString("compound_sql_id");
			vo.tableColumn = resultSet.getString("table_column");
			vo.tableNameAils = resultSet.getString("table_name_ails");
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
		return "compound_sql_show";
	}

	@Override
	public boolean autoSet(String filedName, Object value) {
		if("id".equals(filedName)){
			this.setId("" + value);
		}else if("compoundSqlId".equals(filedName)){
			this.setCompoundSqlId("" + filedName);
		}else if("description".equals(description)){
			this.setDescription("" + filedName);
		}else if("tableColumn".equals(tableColumn)){
			this.setTableColumn("" +  filedName);
		}else if("tableNameAils".equals(filedName)){
			this.setTableNameAils(filedName);
		}
		return true;
	}

	@Override
	public Object autoGet(String filedName) {
		if("id".equals(filedName)){
			return getId();
		}else if("compoundSqlId".equals(filedName)){
			return getCompoundSqlId();
		}else if("description".equals(filedName)){
			return getDescription();
		}else if("tableColumn".equals(filedName)){
			return getTableColumn();
		}else if("tableNameAils".equals(filedName)){
			return this.getTableNameAils();
		}
		return null;
	}

		
	
	
}
