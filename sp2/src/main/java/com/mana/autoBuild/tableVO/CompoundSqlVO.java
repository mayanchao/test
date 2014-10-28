package com.mana.autoBuild.tableVO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;


//组件vo 
public class CompoundSqlVO extends BaseAutoBuildVO{
	
	public String id;	
	public String compoundSqlId;
	public String description;
	public String buildSql;
	
	
	
	
	public String getBuildSql() {		
		return buildSql;
	}

	public void setBuildSql(String buildSql) {
		sqlParam.put("build_Sql", buildSql);
		this.buildSql = buildSql;
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
		CompoundSqlVO vo = new CompoundSqlVO();
		try {
			vo.id = resultSet.getString("id");
			vo.compoundSqlId =  resultSet.getString("compound_sql_id");
			vo.description =  resultSet.getString("description");
			vo.buildSql = resultSet.getString("build_sql");
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
		return "COMPOUND_SQL";
	}

	@Override
	public boolean autoSet(String filedName, Object value) {
		if("id".equals(filedName)){
			this.setId("" + value);
			
			
		}else if("compoundSqlId".equals(filedName)){
			this.setCompoundSqlId("" + value);
			
			
		}else if("description".equals(filedName)){
			this.setDescription("" + filedName);
			
			
		}else if("buildSql".equals(filedName)){
			this.setBuildSql("" + filedName);
			
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
			
		}else if("buildSql".equals(filedName)){
			return getBuildSql();
			
		}
		
		return null;
	}

		
	
	
}
