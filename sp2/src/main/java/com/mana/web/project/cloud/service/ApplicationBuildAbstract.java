package com.mana.web.project.cloud.service;


public abstract class ApplicationBuildAbstract implements ApplicationBuild {
	
	private String typeKey;
	
	public ApplicationBuildAbstract(String typeKey){
		this.typeKey = typeKey;
	}
	
	
	
	//返回类型的关键字
	public String findTypKey(){
		return this.typeKey;
	}



	public String getTypeKey() {
		return typeKey;
	}



	public void setTypeKey(String typeKey) {
		this.typeKey = typeKey;
	}
	
	
	
}







