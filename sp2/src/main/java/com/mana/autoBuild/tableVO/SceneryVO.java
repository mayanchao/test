package com.mana.autoBuild.tableVO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;

public class SceneryVO extends BaseAutoBuildVO {
	public String id;
	public String name;
	public String state;
	public String theCount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
		sqlParam.put("id", id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		sqlParam.put("name", name);
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
		sqlParam.put("state", state);
	}

	public String getTheCount() {
		return theCount;
	}

	public void setTheCount(String theCount) {
		this.theCount = theCount;
		sqlParam.put("the_count", theCount);
	}

	@Override
	public BaseAutoBuildVO buildResultSetVO(ResultSet resultSet) {
		SceneryVO vo = new SceneryVO();
		try {
			vo.id = resultSet.getString("id");
			vo.name = resultSet.getString("name");
			vo.state = resultSet.getString("state");
			vo.theCount = resultSet.getString("the_count");
			return vo;
		} catch (SQLException e) {
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
		return "scenery";
	}

	@Override
	public boolean autoSet(String filedName, Object value) {
		if ("id".equals(filedName)) {
			this.setId("" + value);
		}
		if ("name".equals(filedName)) {
			this.setName("" + value);
		}
		if ("state".equals(filedName)) {
			this.setState("" + value);
		}
		if ("theCount".equals(filedName)) {
			this.setTheCount("" + value);
		}
		return false;
	}

	@Override
	public Object autoGet(String filedName) {
		if ("id".equals(filedName)) {
			return this.getId();
		}
		if ("name".equals(filedName)) {
			return this.getName();
		}
		if ("state".equals(filedName)) {
			return this.getState();
		}
		if ("theCount".equals(filedName)) {
			return this.getTheCount();
		}
		return null;
	}
}
