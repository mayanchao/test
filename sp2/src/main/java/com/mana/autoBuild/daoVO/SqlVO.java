package com.mana.autoBuild.daoVO;

import com.mana.base.web.singleTable.page.PageInfo;


/**
 * 用来存放sql信息的语句的vo  
 * @author mayc
 *
 */

public class SqlVO {
	//sql  语句 
	private String sql ;
	//参数 
	private Object[] params ;
	//分页信息 
	private PageInfo pageInfo;
	
	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public SqlVO(String sql){
		this.sql = sql;
		this.params = new Object[0];
	}
	

	public SqlVO(String sql,Object[] params){
		this.sql = sql;
		this.params = params;
	}
	
	public String getSql() {
 		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public Object[] getParams() {
		return params;
	}
	public void setParams(Object[] params) {
		this.params = params;
	}
	
	
}
