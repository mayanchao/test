package com.mana.autoBuild.tableVO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;


//用户信息vo 
public class UserInfoTableVO extends BaseAutoBuildVO{
	
	private String id;
	private String name;
	private int age;
	private byte sex;
	private String address;
	private String password;
	private String loginName;
	
	
	
	
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		sqlParam.put("login_Name", loginName);
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		sqlParam.put("password", password);
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
	//主键没有set方法，全部UUID生成
//	public void setId(String id) {
//		sqlParam.put("id", id);
//		this.id = id;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		sqlParam.put("name", name);
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		sqlParam.put("age", age);
		this.age = age;
	}
	public byte getSex() {
		return sex;
	}
	public void setSex(byte sex) {
		sqlParam.put("sex", sex);
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		sqlParam.put("address", address);
		this.address = address;
	}
	
	
	@Override
	public String currentTable() {		 
		return "User_Info";
	}
	@Override
	public String currentKeyName() {
		return "id";
	}

	@Override
	public String findKeyValue() {		
		return id;
	}

	@Override
	public void putKeyValue(Object key) {		
		id = key.toString();
	}

	@Override
	public BaseAutoBuildVO buildResultSetVO(ResultSet resultSet) {
//		private String id;
//		private String name;
//		private int age;
//		private byte sex;
//		private String address;
		UserInfoTableVO vo = new UserInfoTableVO();
		 try {
			vo.id = resultSet.getString("id");
			vo.name= resultSet.getString("name");
			vo.age = resultSet.getInt("age");
			vo.sex = resultSet.getByte("sex");
 			vo.address = resultSet.getString("address");
 			vo.password = resultSet.getString("password");
 			vo.loginName = resultSet.getString("login_Name");
 			
 			return vo;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean autoSet(String filedName, Object value) {
		if("loginName".equals(filedName)){
			this.setLoginName("" + value);
		}else if("password".equals(filedName)){
			this.setPassword("" + value);
		}else if("id".equals(filedName)){
			this.setId("" + value);
		}else if("name".equals(filedName)){
			this.setName("" + value);
		}
		return true;
	}

	@Override
	public Object autoGet(String filedName) {
		if("name".equals(filedName)){
			return this.getName();
		}else if("loginName".equals(filedName)){
			return this.getLoginName();
		}else if("password".equals(filedName)){
			return this.getPassword();
		}else if("id".equals(filedName)){
			return this.getId();
		}
		return null;
	}
	
}
