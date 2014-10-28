package com.mana.web.project.cloud.service;

import com.mana.autoBuild.tableVO.CloudIaasServerVO;

public interface ApplicationBuild {
	//返回类型的关键字
	public String findTypKey();
	
	public boolean stop();
	
	public boolean run();
	
	public boolean init();
	
	public boolean destory();
	
	//获取当前应用的pid
	public String getPid(String psText);
	
	//检测是否包括了当前应用
	public boolean exam(String psText);
	
	//添加到限制组
	public boolean addTask(String taskName,String pid,CloudIaasServerVO  cloudIaasServerVO);
	
}
