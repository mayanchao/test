package com.mana.autoBuild.tableVO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;

public class AutoSecurityRoleVO extends BaseAutoBuildVO {
	public String id;
	public String name;
	public String projectId;
	public String operateSetpId;
	public String description;

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		sqlParam.put("project_Id", projectId);
		this.projectId = projectId;
	}

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

	public String getOperateSetpId() {
		return operateSetpId;
	}

	public void setOperateSetpId(String operateSetpId) {
		this.operateSetpId = operateSetpId;
		sqlParam.put("operate_setp_id", operateSetpId);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
		sqlParam.put("description", description);
	}

	@Override
	public BaseAutoBuildVO buildResultSetVO(ResultSet resultSet) {
		AutoSecurityRoleVO vo = new AutoSecurityRoleVO();
		try {
			vo.id = resultSet.getString("id");
			vo.name = resultSet.getString("name");
			vo.operateSetpId = resultSet.getString("operate_setp_id");
			vo.description = resultSet.getString("description");
			vo.projectId = resultSet.getString("project_id");
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
		return "auto_security_role";
	}

	@Override
	public boolean autoSet(String filedName, Object value) {
		if ("id".equals(filedName)) {
			this.setId("" + value);
			return true;
		}
		if ("name".equals(filedName)) {
			this.setName("" + value);
			return true;
		}
		if ("operateSetpId".equals(filedName)) {
			this.setOperateSetpId("" + value);
			return true;
		}
		if ("description".equals(filedName)) {
			this.setDescription("" + value);
			return true;
		}
		if ("projectid".equals(filedName)) {
			this.setProjectId("" + value);
			return true;
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
		if ("operateSetpId".equals(filedName)) {
			return this.getOperateSetpId();
		}
		if ("description".equals(filedName)) {
			return this.getDescription();
		}
		if ("projectId".equals(filedName)) {
			return this.getProjectId();
		}

		return null;
	}
}
