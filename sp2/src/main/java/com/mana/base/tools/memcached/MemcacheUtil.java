package com.mana.base.tools.memcached;

import java.util.HashMap;
import java.util.Map;

import com.mana.autoBuild.tableVO.UserInfoTableVO;

public class MemcacheUtil {

	static Map<String,Object> map = new HashMap<String,Object>();
	static{
		UserInfoTableVO  userInfoVO = new UserInfoTableVO();
		userInfoVO.setName("abc");
		userInfoVO.setPassword("123456");
		//临时加载数据
		map.put("abc", userInfoVO);
		
	}
	
	
	public static  Object  findVO(String key){
		return map.get(key);
	}
	
	
	
}
