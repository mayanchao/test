package com.mana.autoBuild.autoWidget.html.validate.vo;

import java.util.ArrayList;
import java.util.List;



//经过计算后，生成 自动控件的返回validate的html内容
public class ValidateShowHtmlVO{
	//校验控件类型 
	private String type;
	//生成的字符串头 
	private String headStr;
	//最终返回结果的 html 内容，放在自动控件的里面的内容
	private StringBuffer outHtml ; 
	//输出的校验内容
	private List<String> list  = new ArrayList<String>();
	//最后生成的js方法
	private StringBuffer validateJsCode;
	
	

	public StringBuffer getValidateJsCode() {
		return validateJsCode;
	}

	public void setValidateJsCode(StringBuffer validateJsCode) {
		this.validateJsCode = validateJsCode;
	}

	public StringBuffer getOutHtml() {
		return outHtml;
	}

	public void setOutHtml(StringBuffer outHtml) {
		this.outHtml = outHtml;
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHeadStr() {
		return headStr;
	}

	public void setHeadStr(String headStr) {
		this.headStr = headStr;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}
	
}