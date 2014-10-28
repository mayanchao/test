package com.mana.web.project.login.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mana.base.filter.ApplicationServletInitFilter;
import com.mana.base.web.BaseServiceClass;
import com.mana.web.project.login.dao.LoginDao;
import com.mana.web.project.login.service.LoginService;
import com.mana.web.project.login.vo.MyLoginForm;


public class LoginServiceImpl extends BaseServiceClass implements LoginService {
	
	@Override
	public List<MyLoginForm> login(MyLoginForm myLoginForm) {
//		return findDao(LoginDao.class).login(null);
		return ApplicationServletInitFilter.genericWebApplicationContext.getBean("userDao",LoginDao.class).login(null);
	}
	
}
