package com.mana.base.tools.database.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据库表信息类
 *
 */
public class TableInfoVO {
	
	private  String tableName;
	private  String keyField;
	private  List<TableInfoFieldVO> fields = new ArrayList<TableInfoFieldVO>();
	
	
	public List<TableInfoFieldVO> getFields() {
		return fields;
	}
	public void setFields(List<TableInfoFieldVO> fields) {
		this.fields = fields;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getKeyField() {
		return keyField;
	}
	public void setKeyField(String keyField) {
		this.keyField = keyField;
	}
	
}
