package com.mana.base.web;

import org.apache.ibatis.session.SqlSessionFactory;

public abstract class BaseDaoClass {
	
	SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	
	
}
