package com.mana.base.tools.templet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.mana.autoBuild.tableVO.SelfhelpTempletModuleVO;
import com.mana.autoBuild.templet.TempletBuild;
import com.mana.autoBuild.templet.type.base.baseshow.company.CompanyInfoTempletModule;
import com.mana.autoBuild.templet.vo.CommonTempletModuleVO;
import com.mana.base.tools.freemarket.FreeMarkerUtil;
import com.mana.base.tools.io.ToolsFile;
import com.mana.base.tools.sql.DateBaseOperateUtil;

/**
 * 模版工具类
 * @author Administrator
 *
 */
public class TempletModuleUtil {
	
	public static Map<String,TempletBuild>  templetMap = new HashMap<String,TempletBuild>();
	
	static{
		templetMap.put("CompanyInfoTempletModule", new CompanyInfoTempletModule());
	}
	
	
	/**
	 * 清空模版内容，并给予一个ID 保存到数据库 
	 * @param 模板根路径
	 * @param 模板名称
	 * @param 是否保存到数据库
	 * @return 返回清空后的模版
	 */
	public static CommonTempletModuleVO initTemplateContext(String templetPath,CommonTempletModuleVO commonModule	){
		
		
		//保存到数据库 
		SelfhelpTempletModuleVO stm = new SelfhelpTempletModuleVO();	
		stm.setProjectId(commonModule.getProjectId());
		stm.setType(commonModule.getModuleType());
		stm.setSelfhelpTempletId(commonModule.getSelfhelpTempletId());
		stm.setModuleContainId(commonModule.getModuleContainId());
		stm.setModuleContainLocation(commonModule.getModuleContainLocation());
		
		//selfhelp_templet_module_prototype
		//还应该有位置 暂时不记录 
		String key = DateBaseOperateUtil.inserByAutoBuildVO(stm);
		stm.setId(key);
		stm.setParam1("");
		stm.setParam1("");
		stm.setParam1("");
		
//		Random random = new Random();
//        String randId = "" + random.nextInt(9999);
//        String id = "templetModule" + commonModule.getModuleType() + "_" + new Date().getTime()  + "_" + randId;
        
        Map root = new HashMap();
        
        root.put("SelfhelpTempletModuleVO", stm);
        
//		root.put("id", key);
//		root.put("param1", "");
//		root.put("param2", "");
//		root.put("param3", "");
//		root.put("param4", "");
//		root.put("param5", "");
//		root.put("param6", "");
//		root.put("param7", "");
//		root.put("param8", "");
//		root.put("param9", "");
		
		String showHtml = FreeMarkerUtil.buildFreeMarketByFile(
				templetPath
 				,"finalHtml.html"
 				,root
 		);
		
		commonModule.setShowHtml(showHtml);
		commonModule.setId(key);
		return commonModule;
		
	}
	
	
	/**
	 * 根据模版名称，返回模版构建
	 * @param templetName
	 * @return 要构建的模版 
	 */
	public static TempletBuild templetFactoryByType(String templetName){
		TempletBuild re = templetMap.get(templetName);
		return re;
	}
	
	public static void main(String[] args) {
		TempletBuild td = TempletModuleUtil.templetFactoryByType("CompanyInfoTempletModule");
	//td.findStaticConfigureHtml();
	}
	
	/**
	 * 读取模板文件 
	 * @param selfttempletName
	 * @return
	 */
	public static List<String> FindSelftTempletOriginal(String selfttempletName){
		try {
			String path = ToolsFile.localWebpath + "/userProject/" + "0/" + selfttempletName + ".html";
			List<String> list = FileUtils.readLines(new File(path));
			return list;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
























