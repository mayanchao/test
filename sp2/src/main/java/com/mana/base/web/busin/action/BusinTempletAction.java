package com.mana.base.web.busin.action;


import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.web.servlet.ModelAndView;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;
import com.mana.autoBuild.tableVO.SelfhelpTempletModuleVO;
import com.mana.autoBuild.tableVO.SelfhelpTempletVO;
import com.mana.autoBuild.templet.TempletBuild;
import com.mana.autoBuild.templet.vo.CommonTempletModuleVO;
import com.mana.base.tools.io.ToolsFile;
import com.mana.base.tools.project.ProjectUtil;
import com.mana.base.tools.sql.DateBaseOperateUtil;
import com.mana.base.tools.string.StringUtil;
import com.mana.base.tools.templet.TempletModuleUtil;
import com.mana.base.web.BaseActionClass;
import com.mana.base.web.singleTable.page.PageInfo;

/**
 * 模版业务类
 * @author hc360
 *
 */
public class BusinTempletAction  extends BaseActionClass{
	
	//http://localhost:8080/web/busin/action/BusinTempletAction_remove.do1?moduleType=CompanyInfoTempletModule&selfTempletId=201408261641406132b41fd023cc24a19829c4d160daa039d
	public ModelAndView remove(HttpServletRequest request,HttpServletResponse response){
		String moduleType = request.getParameter("moduleType");
		String id = request.getParameter("id");//控件对应的模板
		//工程名字
		String projectId = ProjectUtil.findCurrentProjectId();
		
		CommonTempletModuleVO commonModule  = new CommonTempletModuleVO();		
		commonModule.setProjectId(projectId);//当前工程id
		commonModule.setId(id);//控件主键
		
		TempletBuild templetBuild = TempletModuleUtil.templetFactoryByType(moduleType);
		boolean re =  templetBuild.delete(commonModule);
		commonModule.setRe(re);				
		//重新构建用户模板 
		buildSelfTemplet( request, response);
		
		return buildJsonModelAndView(commonModule);
	}
	
	//http://localhost:8080/web/busin/action/BusinTempletAction_init.do1?moduleType=CompanyInfoTempletModule&selfhelpTempletId=ttt111222333
	public ModelAndView init(HttpServletRequest request,HttpServletResponse response){
		String moduleType = request.getParameter("moduleType");
		String selfTempletId = request.getParameter("selfhelpTempletId");//控件对应的模板
		
		String moduleContainId = request.getParameter("moduleContainId");//模版所在的容器
		String moduleContainLocation = request.getParameter("moduleContainLocation");//模版所在的容器位置
		
		//工程名字
		String projectId = ProjectUtil.findCurrentProjectId();
		CommonTempletModuleVO commonModule  = new CommonTempletModuleVO();		
		commonModule.setProjectId(projectId);//当前工程id
		commonModule.setModuleType(moduleType); //当前要创建的模板类型
		commonModule.setSelfhelpTempletId(selfTempletId);  //当前控件对应的模板		
		commonModule.setModuleContainId(moduleContainId);   
		commonModule.setModuleContainLocation(moduleContainLocation);
		TempletBuild templetBuild = TempletModuleUtil.templetFactoryByType(moduleType);
		CommonTempletModuleVO vo = templetBuild.init(commonModule);
		
		//保存插件到插件表		
		return buildJsonModelAndView(vo);
	}
	
	//http://localhost:8080/web/busin/action/BusinTempletAction_config.do1?moduleType=CompanyInfoTempletModule&id=201408231923541256dd226ae7f2b44a2bc00d8f1d71ff361&templetId=11
	public ModelAndView config(HttpServletRequest request,HttpServletResponse response){
		
		String moduleType = request.getParameter("moduleType");
		String id = request.getParameter("id");//控件对应的模板
		String selfhelpTempletId = request.getParameter("selfhelpTempletId");//控件对应的模板
		String projectId = ProjectUtil.findCurrentProjectId();
		
		CommonTempletModuleVO commonModule  = new CommonTempletModuleVO();		
		commonModule.setId(id);
		commonModule.setProjectId(projectId);//当前工程id
		commonModule.setModuleType(moduleType); //当前要创建的模板类型
		commonModule.setSelfhelpTempletId(selfhelpTempletId);  //当前控件对应的模板 
		
		//读取插件到插件表		
		TempletBuild templetBuild = TempletModuleUtil.templetFactoryByType(moduleType);
		
		CommonTempletModuleVO vo = templetBuild.config(commonModule);
		return buildJsonModelAndView(vo);
	}
	/**
	 * 获取接收文件 
	 * @param request
	 * @param response
	 * @return
	 */
	//http://localhost:8080/web/busin/action/BusinTempletAction_commonjs.do1?moduleType=CompanyInfoTempletModule
	public ModelAndView commonjs(HttpServletRequest request,HttpServletResponse response){
		String moduleType = request.getParameter("moduleType");
		TempletBuild templetBuild = TempletModuleUtil.templetFactoryByType(moduleType);
		String jspath = templetBuild.findStaticConfigureJS();
		try {
			String jsContext = FileUtils.readFileToString(new File(jspath));
			return buildHtmlModelAndView(jsContext);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 保证控件
	 * @param request
	 * @param response
	 * @return
	 */
	//http://localhost:8080/web/busin/action/BusinTempletAction_save.do1?moduleType=CompanyInfoTempletModule
	public ModelAndView save(HttpServletRequest request,HttpServletResponse response){
		String moduleType = request.getParameter("moduleType");
		String id = request.getParameter("id");		
		//String selfhelpTempletId = request.getParameter("selfhelpTempletId");
		
		//当前参数值
		CommonTempletModuleVO commonModule  = new CommonTempletModuleVO();		
		commonModule.setId(id);
		commonModule.setProjectId(ProjectUtil.findCurrentProjectId());//当前工程id
		commonModule.setModuleType(moduleType); //当前要创建的模板类型
		//commonModule.setSelfhelpTempletId(selfhelpTempletId);  //当前控件对应的模板
		commonModule.setRequest(request);
		commonModule.setResponse(response);
		
		//获取控件信息，然后调用保存方法
		TempletBuild templetBuild = TempletModuleUtil.templetFactoryByType(moduleType);
		boolean re = templetBuild.saveme(commonModule);
		commonModule.setRequest(null);
		commonModule.setResponse(null);
		
		//重新构建用户模板 
		buildSelfTemplet( request, response);
		
		return buildJsonModelAndView(commonModule);
	}
	
	//http://localhost:8080/web/busin/action/BusinTempletAction_load.do1?moduleType=CompanyInfoTempletModule&id=201408231923541256dd226ae7f2b44a2bc00d8f1d71ff361&selfhelpTempletId=11
	public ModelAndView load(HttpServletRequest request,HttpServletResponse response){
		String moduleType = request.getParameter("moduleType");
		String id = request.getParameter("id");		
		String selfhelpTempletId = request.getParameter("selfhelpTempletId");
		
		CommonTempletModuleVO commonModule  = new CommonTempletModuleVO();		
		commonModule.setId(id);
		commonModule.setProjectId(ProjectUtil.findCurrentProjectId());//当前工程id
		commonModule.setModuleType(moduleType); //当前要创建的模板类型
		commonModule.setSelfhelpTempletId(selfhelpTempletId);
		TempletBuild templetBuild = TempletModuleUtil.templetFactoryByType(moduleType);
		templetBuild.load(commonModule);
		
		return buildJsonModelAndView(commonModule);
	}
	
	/**
	 * 加载整个模板界面
	 * @param request
	 * @param response
	 * @return
	 */
	//http://localhost:8080/web/busin/action/BusinTempletAction_loadTemplet.do1?selfhelpTempletId=ttt111222333
	public ModelAndView loadTemplet(HttpServletRequest request,HttpServletResponse response){
		
		CommonTempletModuleVO commonModule  = new CommonTempletModuleVO();	
		String selfhelpTempletId = request.getParameter("selfhelpTempletId");
		commonModule.setProjectId(ProjectUtil.findCurrentProjectId());//当前工程id
		commonModule.setSelfhelpTempletId(selfhelpTempletId);
		
		SelfhelpTempletVO stvo = new  SelfhelpTempletVO();
		stvo.setId(selfhelpTempletId);
		stvo.setProjectId(ProjectUtil.findCurrentProjectId());
		
		//当前工程中模板所在的路径，格式是 userProject + 工程名 + templet + 模板名 
		String projectWebpath = ToolsFile.localWebpath + "userProject/" + ProjectUtil.findCurrentProjectId() + "/templet/" + selfhelpTempletId + ".html" ; 
		try {
			String jsContext = FileUtils.readFileToString(new File(projectWebpath));
			return buildHtmlModelAndView(jsContext);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//=============================== 模板区域
	
	//http://localhost:8080/web/busin/action/BusinTempletAction_moveLocation.do1?selfhelpTempletId=ttt111222333
	public ModelAndView moveLocation(HttpServletRequest request,HttpServletResponse response){
		String selfhelpTempletId = request.getParameter("selfhelpTempletId");
		String id = request.getParameter("selfhelpTempletModuleId");
		String moduleContainLocation = request.getParameter("moduleContainLocation");
		//开始更新
		SelfhelpTempletModuleVO moduleQuery = new SelfhelpTempletModuleVO();
		moduleQuery.setProjectId(ProjectUtil.findCurrentProjectId());
		moduleQuery.setSelfhelpTempletId(selfhelpTempletId);
		moduleQuery.setModuleContainLocation(moduleContainLocation);
		moduleQuery.setId(id);
		boolean re = DateBaseOperateUtil.updateByAutoBuildVO(moduleQuery);
		
		//重新构建用户模板 
		buildSelfTemplet( request, response);
		
		return null;
	}
	
	//http://localhost:8080/web/busin/action/BusinTempletAction_showSetConfig.do1?selfhelpTempletId=ttt111222333
	public ModelAndView showSetConfig(HttpServletRequest request,HttpServletResponse response){
		String selfhelpTempletId = request.getParameter("selfhelpTempletId");
		
		String path = ProjectUtil.findPathUserProjectTempletPath(ProjectUtil.findCurrentProjectId());
		path = path + selfhelpTempletId + ".html";//模板的路径		
		try {
			String re = FileUtils.readFileToString(new File(path));
			return buildHtmlModelAndView(re);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	//http://localhost:8080/web/busin/action/BusinTempletAction_buildSelfTemplet.do1?selfhelpTempletId=ttt111222333
	public ModelAndView buildSelfTemplet(HttpServletRequest request,HttpServletResponse response){
		String selfhelpTempletId = request.getParameter("selfhelpTempletId");
		//获得当前
		SelfhelpTempletVO selfhelpTempletVO = new SelfhelpTempletVO();
		selfhelpTempletVO.setId(selfhelpTempletId);
		selfhelpTempletVO.setProjectId(ProjectUtil.findCurrentProjectId());
		
		selfhelpTempletVO = (SelfhelpTempletVO) DateBaseOperateUtil.jdbcSelectSingleOperate(selfhelpTempletVO);
		String templetName = selfhelpTempletVO.getType();
		
		
		
		
		List<String> list = TempletModuleUtil.FindSelftTempletOriginal(templetName);		
		for(int i=0;i<list.size();i++){
			String moduleHtml = list.get(i);
			//判断是否包含 moduleframe= 来说明当前块是自动模板
			if(moduleHtml.contains("moduleframe=")){
				//找出主键   //当前模板中的自定义模板区域  
				String selfTempletId =StringUtil.plexHtmlAttr("id=",moduleHtml );
				 //从数据库，获取当前模板下的控件
				SelfhelpTempletModuleVO moduleQuery = new SelfhelpTempletModuleVO();
				moduleQuery.setProjectId(ProjectUtil.findCurrentProjectId());
				moduleQuery.setModuleContainId(selfTempletId);
				
				moduleQuery.setOrderBy191233("module_contain_location");//排序				
				List<BaseAutoBuildVO> modules = DateBaseOperateUtil.jdbcSelectMultitermOperate(moduleQuery);
				
				StringBuffer sb = new StringBuffer();
				for(int k=0;( modules!=null && k< modules.size()  ) ;k++ ){//开始生成每个控件，然后保存最终界面
					SelfhelpTempletModuleVO  mymodule = (SelfhelpTempletModuleVO)modules.get(k);
					String modultType = mymodule.getType();					
					CommonTempletModuleVO commonModule  = new CommonTempletModuleVO();		
					commonModule.setId(mymodule.getId());
					commonModule.setProjectId(ProjectUtil.findCurrentProjectId());//当前工程id
					commonModule.setModuleType(mymodule.getType()); //当前要创建的模板类型
					commonModule.setSelfhelpTempletId(selfhelpTempletId);
					
					
					TempletBuild templetBuild = TempletModuleUtil.templetFactoryByType(mymodule.getType());
					templetBuild.load(commonModule);
					String finalShowHtml = commonModule.getShowHtml();
					//给finalShowHtml 增加上 li 和 a 标签包围
					finalShowHtml = ProjectUtil.decorateModuleLi(finalShowHtml);
					sb.append(finalShowHtml);
				}
				//替换最终结果
				moduleHtml = moduleHtml + sb.toString();
				list.set(i, moduleHtml);//把结果重新放回页面区域 
			}
		}
		//生成最终界面
		StringBuffer finalsb = new StringBuffer();
		for(int i=0;i<list.size();i++){
			finalsb.append(list.get(i) + "\n");
		}
		//生成到用户目录 
		String path = ProjectUtil.findPathUserProjectTempletPath(ProjectUtil.findCurrentProjectId());
		path = path + selfhelpTempletId + ".html";//模板的路径
		try {
			FileUtils.writeByteArrayToFile(new File(path), finalsb.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return buildHtmlModelAndView(finalsb.toString());
	}
	
	
	
//<button type="button" class="btn btn-primary btn-lg">Large button</button>	
}




















