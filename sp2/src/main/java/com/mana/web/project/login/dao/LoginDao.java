package com.mana.web.project.login.dao;

import java.util.List;

import com.mana.web.project.login.vo.MyLoginForm;

public interface LoginDao {
	public List<MyLoginForm> login(MyLoginForm myLoginForm);
}
