package com.mana.web.project.login.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import com.mana.base.web.BaseDaoClass;
import com.mana.web.project.login.dao.LoginDao;
import com.mana.web.project.login.vo.MyLoginForm;

@Service
public class LoginDaoImpl extends BaseDaoClass implements LoginDao{

	@Override
	public List<MyLoginForm> login(MyLoginForm myLoginForm) {
		List<MyLoginForm> list = new ArrayList<MyLoginForm>();
		SqlSessionFactory sessionFactory = this.getSqlSessionFactory();
//		sessionFactory.openSession().
		System.out.println("sssssssssssss" + sessionFactory);
		return list;
	}

}
