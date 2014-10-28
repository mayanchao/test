package com.mana.autoBuild.templet;

import com.mana.autoBuild.tableVO.SelfhelpTempletModuleVO;
import com.mana.autoBuild.templet.vo.CommonTempletModuleVO;

public interface TempletBuild {
	
	
	
//	 1   初始化接口
//     2   渲染设置界面接口
//     3  上移接口
//     4  下移接口    
//     5  生成html界面
//     6  删除控件接口
//     7 检查接口
//     8 获取控件类型
//     9 保存当前控件信 息
	
	//获取当前设置页面js的方法
	public String findStaticConfigureJS( );
	
	//获取当前设置页面静态内容方法 
	public String findStaticConfigureHtml( );
	

	//获取当前最终页面静态内容方法
	public String findStaticFinalHtml();
	
	
	//获得最初始页面方法
	public CommonTempletModuleVO init(CommonTempletModuleVO commonModule);
	/**
	 * 渲染设置界面接口
	 * @param moduleVO  当前模版界面设置 
	 * @return
	 */
	public CommonTempletModuleVO config(CommonTempletModuleVO  moduleVO);
	
	/**
	 * 加载当前控件信息 ，从数据库中 
	 * @param moduleVO  当前模版界面设置 
	 * @return
	 */
	public CommonTempletModuleVO load(CommonTempletModuleVO  moduleVO);

	/**
	 * 生成html界面
	 * @param moduleVO
	 * @return
	 */
	public String build(SelfhelpTempletModuleVO  moduleVO);
	
	/**
	 * 删除控件接口
	 * @param moduleVO
	 * @return
	 */
	public boolean delete(CommonTempletModuleVO commonModule);
	/**
	 * 保存当前控件信息
	 * @param moduleVO
	 * @return
	 */
	public boolean saveme(CommonTempletModuleVO  moduleVO);
	
	/**
	 * 重新更新当前控件中用到的展现数据
	 * @param moduleVO
	 * @return
	 */
	public boolean reUpdateData(SelfhelpTempletModuleVO  moduleVO);
	
	
}
