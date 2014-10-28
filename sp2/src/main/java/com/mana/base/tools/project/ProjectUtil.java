package com.mana.base.tools.project;

import com.mana.base.tools.io.ToolsFile;

/**
 * 当前工程工具类
 * @author Administrator
 *
 */
public class ProjectUtil {
	
	
	/**
	 * 查找当前用户工程的id 从session中获取id
	 * @return
	 */
	public static  String findCurrentProjectId(){
		return "123";
		
	} 
	
	/**
	 * 获得工程下模板的路径 
	 * @param projectId
	 * @return
	 */
	public static  String findPathUserProjectTempletPath(String projectId){ 
		String re = ToolsFile.localWebpath + "/userProject/" + projectId + "/templet/";
		return re;
	}

	/**
	 * 把控件最外层包裹一层li 标签
	 * @param div
	 * @return
	 */
	public static  String decorateModuleLi(String div){
		
//		var myHtml = "<li >" + 
//			"<a  class='list-group-item'>" +
//			data.showHtml	
//          + "</a>" +
//    	"</li>"
//          
		String re= "<li >\n";
			re +="<a  class='list-group-item'>\n";
			re += div + "\n";
			re +="</a>\n";
			re +="</li>\n";
			
		return re;	
		
	}
	
}
