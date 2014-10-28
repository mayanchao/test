package com.mana.web.project.cloud.service.impl;

import com.mana.autoBuild.tableVO.CloudIaasServerVO;
import com.mana.web.project.cloud.service.ApplicationBuildAbstract;
import com.mana.web.project.cloud.util.CloudUtil;


//运行 top命令 
public class CloudTopApplication extends ApplicationBuildAbstract {

	
	public CloudTopApplication(String typeKey) {
		super(typeKey);
	}

	@Override
	public boolean stop() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean run() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean init() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean destory() {
		// TODO Auto-generated method stub
		return false;
	}
	

	@Override
	public String getPid(String psText) {
		//root      2566  1907  2 00:39 pts/0    00:00:00 top
		//检查有没有top进程 
		String[] texts = psText.split("\n");
		for(int i=0;i<texts.length;i++){
			if(texts[i].endsWith(" top") ){//有top命令
				//获取pid 
				String[] values = texts[i].split(" ");
				return values[6];
			}
		}
		return null;
	}
	
	@Override
	public boolean exam(String psText) {
		//root      2566  1907  2 00:39 pts/0    00:00:00 top
		//检查有没有top进程 
		if( getPid(psText)!=null ){
			return true;
		}
		return false;
	}

	@Override
	public boolean addTask(String taskName,String pid,CloudIaasServerVO  cloudIaasServerVO) {
		String myCommand = "echo " + pid + "  > " + taskName + "/tasks";
		//先获取pid 
		String linuxResult = CloudUtil.runCommanByServer(cloudIaasServerVO.getIp(), myCommand);
		System.out.println("linuxResult=" + linuxResult);
		
		return false;
	}


	
	
	
}
