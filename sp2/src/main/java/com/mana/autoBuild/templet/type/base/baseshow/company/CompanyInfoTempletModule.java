package com.mana.autoBuild.templet.type.base.baseshow.company;

import java.util.HashMap;
import java.util.Map;

import com.mana.autoBuild.tableVO.SelfhelpTempletModuleVO;
import com.mana.autoBuild.templet.TempletBuildBaseAbstract;
import com.mana.autoBuild.templet.vo.CommonTempletModuleVO;
import com.mana.base.tools.freemarket.FreeMarkerUtil;
import com.mana.base.tools.sql.DateBaseOperateUtil;
import com.mana.base.tools.templet.TempletModuleUtil;

public class CompanyInfoTempletModule extends TempletBuildBaseAbstract {
	
	public String templetModuleName = "CompanyInfoTempletModule";
	
	public String html;
	
	
	@Override
	public CommonTempletModuleVO init(CommonTempletModuleVO commonModule) {
			String templetPath =    findStaticFinalHtml();
			CommonTempletModuleVO vo = TempletModuleUtil.initTemplateContext(templetPath,commonModule);
			return vo;
	}

	@Override
	/**
	 * 渲染设置界面接口
	 * @param moduleVO  当前模版界面设置 
	 * @return
	 */
	public CommonTempletModuleVO load(CommonTempletModuleVO  commonModule){
		//读取数据库，拼装界面 
		SelfhelpTempletModuleVO selfhelpTempletModuleVO = new SelfhelpTempletModuleVO(); 
		selfhelpTempletModuleVO.setId( commonModule.getId() );
		selfhelpTempletModuleVO.setProjectId(commonModule.getProjectId());
		
		selfhelpTempletModuleVO.setSelfhelpTempletId(commonModule.getSelfhelpTempletId());
		
		selfhelpTempletModuleVO = (SelfhelpTempletModuleVO)DateBaseOperateUtil.jdbcSelectSingleOperate(selfhelpTempletModuleVO);
		
		Map root = new HashMap();
		root.put("SelfhelpTempletModuleVO", selfhelpTempletModuleVO);
		
		//然后根据配置界面，用framemarket设置界面
		String configBastPath =    findStaticFinalHtml();
		
		//读取配置文件
		String configureHtml = FreeMarkerUtil.buildFreeMarketByFile(
				configBastPath
 				,"finalHtml.html"
 				,root
 		);
		commonModule.setShowHtml(configureHtml);
		
		return commonModule;
	}

	
	
	@Override
	public String build(SelfhelpTempletModuleVO moduleVO) {		
		return "<div> finish </div>";
	}

	@Override
	public boolean delete(CommonTempletModuleVO commonModule) {
		SelfhelpTempletModuleVO selfhelpTempletModuleVO = new SelfhelpTempletModuleVO(); 
		selfhelpTempletModuleVO.setId( commonModule.getId() );
		selfhelpTempletModuleVO.setProjectId(commonModule.getProjectId());
		//删除操作
		return DateBaseOperateUtil.deleteByAutoBuildVO(selfhelpTempletModuleVO);
	}


	@Override
	public boolean reUpdateData(SelfhelpTempletModuleVO moduleVO) {
		
		return false;
	}

	@Override
	public boolean saveme(CommonTempletModuleVO moduleVO) {
		SelfhelpTempletModuleVO selfhelpTempletModuleVO = new SelfhelpTempletModuleVO(); 
		selfhelpTempletModuleVO.setId( moduleVO.getId() );
		String param1 = moduleVO.getRequest().getParameter("param1");
		String param2 = moduleVO.getRequest().getParameter("param2");
		String param3 = moduleVO.getRequest().getParameter("param3");
		
		selfhelpTempletModuleVO.setId(moduleVO.getId());
		selfhelpTempletModuleVO.setParam1(param1);
		selfhelpTempletModuleVO.setParam2(param2);
		selfhelpTempletModuleVO.setParam3(param3);
		
		boolean re = DateBaseOperateUtil.updateByAutoBuildVO(selfhelpTempletModuleVO);
		moduleVO.setRe(re);
		return re;
	}

	@Override
	public CommonTempletModuleVO config(CommonTempletModuleVO commonModule) {
		//先读数据库
		SelfhelpTempletModuleVO stm = new SelfhelpTempletModuleVO();
		stm.setProjectId(  commonModule.getProjectId()  );
		stm.setType(commonModule.getModuleType());
		//stm.setSelfhelpTempletId(commonModule.getSelfhelpTempletId());
		stm.setId(commonModule.getId());//主键
		
		//还应该有位置 暂时不记录 
		SelfhelpTempletModuleVO selfhelpTempletModuleVO = (SelfhelpTempletModuleVO) DateBaseOperateUtil.jdbcSelectSingleOperate(stm);
		Map root = new HashMap();
		root.put("SelfhelpTempletModuleVO", selfhelpTempletModuleVO);
		
		//然后根据配置界面，用framemarket设置界面
		String configBastPath =    findStaticFinalHtml();
		
		//读取配置文件
		String configureHtml = FreeMarkerUtil.buildFreeMarketByFile(
				configBastPath
 				,"config.html"
 				,root
 		);
		//把界面放到传递变量里，然后返回给界面，显示出来 
		commonModule.setConfigHtml(configureHtml);
		
		return commonModule;
	}

	


}
