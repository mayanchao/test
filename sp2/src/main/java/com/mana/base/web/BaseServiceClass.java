package com.mana.base.web;

import com.mana.base.filter.ApplicationServletInitFilter;

public abstract class BaseServiceClass {
	
	
	/**
	 * 获取dao类信息 
	 * @param <T>
	 * @param requiredType
	 * @return
	 */
	public  <T> T findDao(Class<T> requiredType){
		return ApplicationServletInitFilter.genericWebApplicationContext.getBean(requiredType);
	}
	
}
