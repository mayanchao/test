package com.mana.autoBuild.templet;

import com.mana.autoBuild.templet.type.base.baseshow.company.CompanyInfoTempletModule;
import com.mana.autoBuild.templet.vo.CommonTempletModuleVO;
import com.mana.base.tools.io.ToolsFile;

public abstract class TempletBuildBaseAbstract implements  TempletBuild {
	
	
	//获取当前设置页面js的方法
	public String findStaticConfigureJS( ){
		String classPath = ToolsFile.findModulePath(this.getClass());
		classPath = classPath + "/js/com.js";
		return classPath;
	}
	
	
	@Override
	public String findStaticFinalHtml() {
		//找到当前控件路径，然后拼装出模版路径
		String classPath = ToolsFile.findModulePath(this.getClass());
		classPath = classPath + "html";
		///E:/workspaces/eclipse-jee-helios-sr1/sp2/target/classes/com/mana/autoBuild/templet/type/company/
		//读取模版内容 ，返回结果 
		return classPath;
	}
	
	
	
	@Override
	public String findStaticConfigureHtml( ) {
		//找到当前控件路径，然后拼装出模版路径
		String classPath = ToolsFile.findModulePath(this.getClass());
		classPath = classPath + "/html";
		//读取模版内容 ，返回结果 
		return classPath;
	}

	
	
	
	public static void main(String[] args) {
		CompanyInfoTempletModule ct = new CompanyInfoTempletModule();
//		ct.findStaticConfigureHtml();
	}
	
}
