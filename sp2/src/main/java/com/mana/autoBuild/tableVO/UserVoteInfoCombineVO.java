package com.mana.autoBuild.tableVO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;


//组件vo 
public class UserVoteInfoCombineVO extends BaseAutoBuildVO{
	
	public String id;	
	public String userInfoId;
	public String userVoteId;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		sqlParam.put("id", id);
		this.id = id;
	}

	
	
	public String getUserInfoId() {
		return userInfoId;
	}

	public void setUserInfoId(String userInfoId) {
		sqlParam.put("user_info_id", userInfoId);
		this.userInfoId = userInfoId;
	}

	public String getUserVoteId() {
		return userVoteId;
	}

	public void setUserVoteId(String userVoteId) {
		sqlParam.put("user_vote_id", userVoteId);
		this.userVoteId = userVoteId;
	}

	@Override
	public BaseAutoBuildVO buildResultSetVO(ResultSet resultSet) {
		UserVoteInfoCombineVO vo = new UserVoteInfoCombineVO();
		try {
			vo.id = resultSet.getString("id");
			vo.userVoteId = resultSet.getString("user_vote_id");
			vo.userInfoId = resultSet.getString("user_info_id");
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
		return "User_VOTE_INFO_COMBINE";
	}

//	public String userInfoId;
//	public String userVoteId;
	
	@Override
	public boolean autoSet(String filedName, Object value) {
		if("id".equals(filedName)){
			this.setId("" + value);
		}else if("userInfoId".equals(filedName)){
			this.setUserInfoId("" + filedName);
		}else if("userVoteId".equals(filedName)){
			this.setUserVoteId("" + filedName);		
		}
		return true;
	}

	@Override
	public Object autoGet(String filedName) {
		if("id".equals(filedName)){
			return getId();
		}else if("userInfoId".equals(filedName)){
			return getUserInfoId();
		}else if("userVoteId".equals(filedName)){
			return getUserVoteId();
		}
		return null;
	}

		
	
	
}
