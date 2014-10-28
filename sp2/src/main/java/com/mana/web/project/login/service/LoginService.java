package com.mana.web.project.login.service;

import java.util.List;

import com.mana.web.project.login.vo.MyLoginForm;

public interface LoginService {
	
	public List<MyLoginForm> login(MyLoginForm myLoginForm);
	
}
