package com.mana.autoBuild.autoWidget.html.validate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.mana.autoBuild.autoWidget.html.validate.vo.ValidateShowHtmlVO;




/**
 * 构建校验语句的html 
 * @author hc360
 */
public class BuildValidateHtml {
	
	/**
	 *
	 * @return
	 */
	public static  Map<String,ValidateShowHtmlVO> validateBuildTextLength(String htmlId,String validateJson ){
		System.out.println("start .....................");		
		List<Map> array = JSON.parseArray(validateJson,Map.class);
		Map<String,ValidateShowHtmlVO> handleTypeMap = new HashMap<String,ValidateShowHtmlVO>();//处理事件分类集合
		for(int i=0;i<array.size();i++){
			//获取属性类型
			Map<String,String> map = array.get(i);
			if(map.get("type")!=null){//检查当前校验类型
				String handleType = "" + map.get("handleType");
				//判断触发方式
				//String handleType = map.get("handleType");
				ValidateShowHtmlVO validateShowHtmlVO  = handleTypeMap.get(handleType);				
				if(validateShowHtmlVO==null){//最终这种类型的展现字符串
					validateShowHtmlVO = new  ValidateShowHtmlVO(  ); //生成事件的头
					validateShowHtmlVO.setType(map.get("handleType")); //设置校验类型
					handleTypeMap.put(map.get("handleType"), validateShowHtmlVO);
				}
				
				if("autoBuild_html_validate_textLength".equals(map.get("type")) ){//文字长度判断 
//					String  maxLen = map.get("maxLength");
//					String  minLen = map.get("minLength");
//					String  errorText = map.get("errorText");
//					String  errorType = map.get("errorType");
//					String  handleType = map.get("handleType");
//					map.put("htmlId", htmlId);							
					validateShowHtmlVO.getList().add("\n autoBuild_html_validate_textLength_js(" +  JSON.toJSONString(map) + ",mythis);");
				}else if("autoBuild_html_validate_isNumber".equals(map.get("type")) ){  //数字类型判断
					
					
				}
			}
		}
		//生成返回结果 
		Iterator<String> it = handleTypeMap.keySet().iterator();		
		
		
		//生成校验的js
		 
		while(it.hasNext()){		
			String key = it.next();
			ValidateShowHtmlVO buildVO = handleTypeMap.get(key);
			StringBuffer sb = new StringBuffer();			
			sb.append("<script>\n");
			//生成的函数名称是  validate_主键_事件名称
			sb.append("  function " +  buildValidateFunctionName(htmlId,key,false) + "{\n" );
			for(int i=0;i<buildVO.getList().size();i++){
					sb.append(buildVO.getList().get(i)); //把当前类型的脚本放入
				
			}
			sb.append("\n}\n");
			sb.append("</script>\n");
			buildVO.setValidateJsCode(sb);
			//生成自动控件的校验方法
			buildVO.setHeadStr( parseHandlerType(buildVO.getType() ) +  buildValidateFunctionName(htmlId,key,true)  );
			//validate_buildId_validate1_14009019848171_autoBuild_html_validate_textLength(mythis)
		}
		
		
		//生成最终结果 
		//System.out.println(sb.toString());
		return handleTypeMap;
	}
	//http://localhost:8080/autoBuild/public/autoWidget/validate.html
	//<input type="text" onblur="
	 //onblur=autoBuild_html_validate_textLength_js({"errorText":"max4 min=1","errorType":"alert","handleType":"onblur","htmlId":"buildId_validate1_14009019848171","maxLength":"4","minLength":"1","name":"newRule1","type":"autoBuild_html_validate_textLength"},this);autoBuild_html_validate_textLength_js({"errorText":"eee11","errorType":"alert","handleType":"onblur","htmlId":"buildId_validate1_14009019848171","maxLength":"2","minLength":"1","name":"newRule2","type":"autoBuild_html_validate_textLength"},this);   style='position:absolute;top:785px;left:22px;' id=buildId_validate1_14009019848171 width=20 height=10 maxlength=10 name=  value=''
	/**
	 * 根据类型，返回对应的响应事件
	   下午08:57:48
	 * @param handleType
	 * @return
	 */
	private static String parseHandlerType(String handleType){
		if("onFouce".equals(handleType)){
			return "onfocus=";
		}else if("onchance".equals(handleType)){
			return "onchance=";
		}else if ("onblur".equals(handleType)){
			return "onblur=";
		}
		return "";
	}
	
	
	public static void main(String[] args) {
		
		String validate1 = "[{\"name\":\"111\",\"type\":\"autoBuild_html_validate_textLength\",\"maxLength\":\"1\",\"minLength\":\"2\",\"errorText\":\"3\",\"errorType\":\"\"},{\"name\":\"222\",\"type\":\"autoBuild_html_validate_isNumber\",\"numberType\":\"int\"}]";
		validateBuildTextLength("id1",validate1);
//		System.out.println("re=" + re );
//		String jsonText = "[{a:1,b:2},{a:3,b:4}]";
//		List<Map> array = JSON.parseArray(jsonText,Map.class);
//		System.out.println("array=" + array.size());
//		System.out.println(array.get(0).get("a"));
		
	}
	
	/**
	 * 根据校验类型和主键，生成这个自动控件的校验js
	 * @param htmlId  控件主键
	 * @param handlerType  处理事件类型
	 * @param showThis 显示的参数项 是 this 还是mythis
	 * @return
	 */
	public static String buildValidateFunctionName(String htmlId,String handlerType,boolean showThis){
		String myThis = "mythis";
		if(showThis){
			myThis = "this";
		}
		return  "validate_" + htmlId + "_" + handlerType  + "(" + myThis + ")";
	}
	
	/**
	 * 生成最后 html头 
	 * @param handleTypeMap
	 * @return
	 */
	public static String htmlHead(Map<String,ValidateShowHtmlVO> handleTypeMap){
		StringBuffer sb  = new StringBuffer();
		//生成返回结果 
		Iterator<String> it = handleTypeMap.keySet().iterator();		
		//生成校验的js
		while(it.hasNext()){
			String key = it.next();
			ValidateShowHtmlVO vo =handleTypeMap.get(key);
			sb.append( vo.getHeadStr() + "  " );
		}
		return sb.toString();
	}
	
	/**
	 * 生成最后 html头 
	 * @param handleTypeMap
	 * @return
	 */
	public static String htmlScript(Map<String,ValidateShowHtmlVO> handleTypeMap){
		StringBuffer sb  = new StringBuffer();
		//生成返回结果 
		Iterator<String> it = handleTypeMap.keySet().iterator();		
		//生成校验的js
		while(it.hasNext()){
			String key = it.next();
			ValidateShowHtmlVO vo =handleTypeMap.get(key);
			sb.append( vo.getValidateJsCode() + "  " );
		}
		return sb.toString();
	}
	
}





