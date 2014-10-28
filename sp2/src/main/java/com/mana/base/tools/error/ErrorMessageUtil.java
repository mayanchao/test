package com.mana.base.tools.error;

//错误信息处理类
public class ErrorMessageUtil {

	/**
	 * 错误信息处理类
	 * @param errorNumber  错误号
	 * @param errorText    错误提示内容 
	 * @return
	 */
	public static String errorMessageHandler(String errorNumber,String errorText){
		//"{\"error\":\"-111\",\"errorMsg\":\"验证码错误\"}"
		String errorJson = "{\"error\":\"" + errorNumber + "\",\"errorMsg\":\"" + errorText + "\"}";
		System.out.println(errorJson);
		
		return errorJson;
	}
	
	public static void main(String[] args) {
		ErrorMessageUtil.errorMessageHandler("33", "errrr");
	}
}
