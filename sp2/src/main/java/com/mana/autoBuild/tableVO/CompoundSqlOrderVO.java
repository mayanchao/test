package com.mana.autoBuild.tableVO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;


//组件vo 
public class CompoundSqlOrderVO extends BaseAutoBuildVO{
	
	public String id;	
	public String compoundSqlId;
	public String tableNameAlis;
	public String tableColumn;
	public String orderType;
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
		sqlParam.put("compound_sql_id", compoundSqlId);
		this.compoundSqlId = compoundSqlId;
	}

	public String getTableNameAlis() {
		return tableNameAlis;
	}

	public void setTableNameAlis(String tableNameAlis) {
		sqlParam.put("table_name_ails", tableNameAlis);
		this.tableNameAlis = tableNameAlis;
	}

	public String getTableColumn() {
		return tableColumn;
	}

	public void setTableColumn(String tableColumn) {
		sqlParam.put("table_column", tableColumn);
		this.tableColumn = tableColumn;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		sqlParam.put("order_type", orderType);
		this.orderType = orderType;
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
		CompoundSqlOrderVO vo = new CompoundSqlOrderVO();
		try {
			vo.id = resultSet.getString("id");
			vo.compoundSqlId =  resultSet.getString("compound_sql_id");
			vo.tableNameAlis = resultSet.getString("table_name_ails");
			vo.tableColumn =  resultSet.getString("table_column");
			vo.orderType =  resultSet.getString("order_type");
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
		return "compound_sql_order";
	}

	@Override
	public boolean autoSet(String filedName, Object value) {
//		if("featureName".equals(filedName)){
//			this.setFeatureName("" + value);
//		}else if("count".equals(filedName)){
//			this.setCount("" + filedName);
//		}else if("status".equals(filedName)){
//			this.setStatus("" + status);
//		}
		return false;
	}

	@Override
	public Object autoGet(String filedName) {
//		if("featureName".equals(filedName)){
//			return getFeatureName();
//		}else if("count".equals(filedName)){
//			return getCount();
//		}else if("status".equals(filedName)){
//			return getStatus();
//		}
		return null;
	}

		
	
	
}
