package com.mana.base.tools.string;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;

public class StringUtil {

	
	/**
	 * 解析字符串 变成jsong形式的数组 
	 *  例如 aaa,bbb,ccc 会被解析成 ['aaa','bbb','ccc']
	 * @param str
	 */
	public static String analyzeStringJsonJsArray(String str){
		String[] values = str.split(",");
		StringBuffer re = new StringBuffer("[");
		for(int i=0;i<values.length;i++){
			re.append("'" + values[i]  + "',");
		}
		re.delete(re.length()-1,re.length() );//去掉最后的分号
		re.append("]");
		if(re.length()==0){
			return null;
		}
		return re.toString();
	}
	
	/**
	 *  把字符串中的双引号，换成单引号
	 *  双引号 " 改成单引号 ‘  例如 "aaaa"  'aaaa'
	 * @param str
	 */
	public static String fromDoubleTosingle(String str){
		if(str!=null){
			str = str.replaceAll("\"", "'");
		}
		return str;
	}
	
	/**
	 *  分析 字符串，找出字符串中要替代的固定括号替代属性的结果集
	 *  例如  select (_cc_) from table1 where ac=(_ac_)  and bc=(_bc_) 就会找出
	 *  结果就是  cc,ac,bc 
	 * 	 * @param str
	 */
	public static List<String> plexStringParam(String str){
		
		List<String> list = new ArrayList<String>();
		String[] values = str.split("\\(\\_");
		//i从1开始，代表第一个值是可以不要。
		for(int i=1;i<values.length;i++){
			String temp1 = values[i];			
			String value = temp1.split("\\_\\)")[0];
			list.add(value);
		}
		return list;
	}
	
	/**
	 * 
	     把 括号替代属性，全部换成参数 replaceString里的内容 
	 * @param str
	 * @return
	 */
	public static String plexStringQuestionMark(String str,String replaceString){
		StringBuffer sb = new StringBuffer(str);
		List<String> list = plexStringParam(str);
		for(int i=0;list.size()>i;i++){
			str = str.replace("(_" + list.get(i) + "_)", replaceString);
		}
		return  str;
	}
	
	
	
	/**
	 * 
	     把auto_build_widget 字符串，生成JAVA代码的类名  AutoBuildWidget
	     把下划线，替换成大写字母  
	 * @param str
	 * @return
	 */
	public static String plexStrToClassName(String str){
		//先全转小写 
		str = str.toLowerCase();
		
		
		String[] values = str.split("_");
		String re ="";
		for(int i=0;i<values.length;i++){
			String newStr=values[i].substring(0, 1).toUpperCase()+values[i].replaceFirst("\\w","");
			re += newStr;
		}		
		return re;
	}
	
	
	
	
	public static String plexStrToFieldName(String str){
		return plexStrToFieldName(str,false);
	}
	
	
	/**
	 * 
	     把auto_build_widget 字符串，生成JAVA代码的类名  AutoBuildWidget
	     把下划线，替换成大写字母 第一个字母小写  
	 * @param str
	 * @param upperChar   是否首字母要大些 
	 * @return
	 */
	public static String plexStrToFieldName(String str,boolean upperChar){
		str = str.toLowerCase();
		
		String[] values = str.split("_");
		String re ="";
		if(values.length>1){
			for(int i=0;i<values.length;i++){
				String newStr=values[i].substring(0, 1).toUpperCase()+values[i].replaceFirst("\\w","");
				re += newStr;
			}			
		}else{
			re =  str;
		}
		if(upperChar){//需要首字母转大些
			String startChar = re.substring(0,1).toUpperCase();			
			re =   startChar + re.replaceFirst("\\w","");
		}else{
			String startChar = re.substring(0,1).toLowerCase();
			re =   startChar + re.replaceFirst("\\w","");
		}
		return re;
	}
	
	
	
	
	
	
	//=============================工作流部分=======================
	/**
	 * 根据参数是否为复合属性 或者普通属性，从map中获取结果 
	 * @param map
	 * @param param1
	 */
	public static String complexParamGetValue(Map map, String param1) {		
 		if(param1.indexOf(".")>0 ){//说明复合属性 
			String[] params = param1.split("\\.");
			BaseAutoBuildVO resultVo = (BaseAutoBuildVO) map.get(params[0]);//取出结果集中的vo
//			Iterator it = map.keySet().iterator();
//			while(it.hasNext()){
//				System.out.println(it.next());
//			}
//			
			
			if(resultVo==null){
				return null;
//				return "false";
			}
			return  (String) resultVo.autoGet(params[1]);
		}else{//直接取出 
			return  (String) map.get(param1);
		}
	}
	
	/**
	 * 往复合对象中赋值，并返回当前复合对象
	 * @param map    值对象链
	 * @param param1  要保存的列
	 * @param value  要保存的值
	 * @return
	 */
	public static BaseAutoBuildVO complexParamPutValue(Map map, String param1,String value) {		
		String[] params = param1.split("\\.");
		BaseAutoBuildVO resultVo = (BaseAutoBuildVO) map.get(params[0]);//取出结果集中的vo
		resultVo.autoSet(params[1], value);
		return resultVo;
		
	}
	
	/**
	 * 根据链值队列，从中取出对象
	 * @param map
	 * @param param1
	 * @return
	 */
	public static BaseAutoBuildVO complexParamGetObject(Map map, String param1) {
		String[] params = param1.split("\\.");
		Object obj =map.get(params[0]);//取出结果集中的vo
		if(obj!=null){
			return (BaseAutoBuildVO)obj;
		}
		return null;
	}
	
	/**
	 * 从当前复合属性中，获取复合属性的主键名	
	 * @param param1  复合属性
	 * @return  主键名
	 */
	public static String complexParamGetKeyName(String param1) {
		String[] params = param1.split("\\.");
		return params[0];
	}

	/**
	 * 生成html的空格符号，根据长短 
	 * @param length
	 * @return
	 */
	public static  String buildHtmlSpacebar(int length){
		String spacebar = "";
		for(int i=0;i<length;i++){
			spacebar +="&nbsp;";
		}
		return spacebar;
	}
	//===============================html=============================
	

	/**
	 *  解析html 内容中的属性值  例如   <ul  id="left-list-id" class="list-unstyled"  moduleframe="u11"   > 会返回 moduleframe属性的 u11值 
	 * @param attrName 属性名称
	 * @param htmlContext  HTML文本 
	 * @return
	 */
	public static String plexHtmlAttr(String attrName,String htmlContext){
		int startIndex = htmlContext.indexOf(attrName);		
		int endIndex = htmlContext.indexOf(" ", startIndex  );
		String re =  htmlContext.substring(startIndex + attrName.length() ,endIndex) ;
		//如果返回类型有 "" 就去掉 
		re = re.replaceAll("\"", "");
		return re;
	} 

	
	//返回属性值表达式  例如 a=b  c = ss
	public static String[] findNameAndValue(String line){
		//先去除掉空格
		line = line.replaceAll("\\s", "");
		String re[] = line.split("=");
		return re;
	} 

	
	
	
	public static void main(String[] args) {	
//		String html = "<ul  id=\"left-list-id\" class=\"list-unstyled\"  moduleframe=\"u112\"   >";		
//		System.out.println(plexHtmlAttr("moduleframe=",html));
		
		String[] ccc = findNameAndValue(" a = c 2");
		System.out.println("ccc[0]" + ccc[0]);
		System.out.println("ccc[1]" + ccc[1]);
		
	}
	
	
	
}




















