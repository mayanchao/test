package com.mana.autoBuild.tableVO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;


//组件vo 
public class UserVoteVO extends BaseAutoBuildVO{
	
	public String id;	
	public String featureName;
	public String count;
	public String status;
	
	public String getStatus() {
		return status;
	}

	public String getId() {
		return id;
	}

	
	public String getFeatureName() {
		return featureName;
	}
	
	public String getCount() {
		return count;
	}
	
	public void setStatus(String status) {
		sqlParam.put("status", status);
		this.status = status;
	}
	
	public void setFeatureName(String featureName) {
		sqlParam.put("feature_name", featureName);
		this.featureName = featureName;
	}
	public void setId(String id) {
		sqlParam.put("id", id);
		this.id = id;
	}

	public void setCount(String count) {
		sqlParam.put("count", count);
		this.count = count;
	}

	@Override
	public BaseAutoBuildVO buildResultSetVO(ResultSet resultSet) {
		UserVoteVO vo = new UserVoteVO();
		try {
			vo.id = resultSet.getString("id");
			vo.featureName =  resultSet.getString("feature_name");
			vo.count = resultSet.getString("count");
			vo.status =  resultSet.getString("status");
			return vo;
		} catch (SQLException e) {
			e.printStackTrace();
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
		return "User_VOTE";
	}

	@Override
	public boolean autoSet(String filedName, Object value) {
		if("featureName".equals(filedName)){
			this.setFeatureName("" + value);
			
		}else if("count".equals(filedName)){
			this.setCount("" + value);
			
		}else if("status".equals(filedName)){
			this.setStatus("" + value);
			
		}
		return false;
	}

	@Override
	public Object autoGet(String filedName) {
		if("featureName".equals(filedName)){
			return getFeatureName();
		}else if("count".equals(filedName)){
			return getCount();
		}else if("status".equals(filedName)){
			return getStatus();
		}
		return null;
	}

		
	
	
}
