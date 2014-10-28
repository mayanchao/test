package com.mana.base.web.urlMapping;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.web.servlet.handler.AbstractUrlHandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import com.mana.base.filter.ApplicationServletInitFilter;
import com.mana.base.web.BaseActionClass;
import com.mana.base.web.urlMapping.intercept.InterceptUtil;

public class UrlMapping extends AbstractUrlHandlerMapping{
	
	
//	
//	@Override	
//	protected String[] determineUrlsForHandler(String beanName) {
//		System.out.println("sssssssssssssssssssssssssssssss====" + beanName);
//		List<String> urls = new ArrayList<String>();
//		if("shirdrnController123".equals(beanName)){
//			urls.add("/shirdrn.do1");
//		}
//		return StringUtils.toStringArray(urls);
//	}
	
	
	/**
	 * Return the registered handlers as an unmodifiable Map, with the registered path
	 * as key and the handler object (or handler bean name in case of a lazy-init handler)
	 * as value.
	 * @see #getDefaultHandler()
	 */
	public static Map<String,List> projectIntercept;

	
	@Override
	public void initApplicationContext() throws BeansException {
		
//		String[] imgs = ApplicationServletInitFilter.genericWebApplicationContext.getAliases("alias");
		//获取出所有自定义Action类 ， 并映射到map中的url 
//		String[] beanNames1 = ApplicationServletInitFilter.genericWebApplicationContext.getBeanNamesForType(BaseActionClass.class);
		Map<String,BaseActionClass> actionBeans = ApplicationServletInitFilter.genericWebApplicationContext.getBeansOfType(BaseActionClass.class);
		Iterator it  = actionBeans.values().iterator();		
		while(it.hasNext()){
			Object obj = it.next();			
			String className =  "" + obj.getClass();
			//把class类名，转成url地址 
			String[] urlNames = className.split("\\.");			
//			String url = "/" + urlNames[3]   + "/" + urlNames[4] + "/" + urlNames[5] + "/" + urlNames[6] + "_*" ;
			String url = "/" + urlNames[3]   + "/" + urlNames[4] + "/" + urlNames[5] + "/" + urlNames[6] + "_*" ;
			System.out.println("url=" + url);
 			super.registerHandler(url ,obj);
		}
		//初始化用户权限 
		
		
//		super.initApplicationContext();
	}

	
	//根据url获取处理类 
	@Override	
	protected Object getHandlerInternal(HttpServletRequest request) throws Exception{
		//根据url地址，取出
//		com.mana.web.project.login.action.MyAction
//		/project/login/action/MyAction_login.asp
		String projectId = null;
		String  lookupPath = request.getRequestURI();
		//最开始的是工程名称，需要剔除掉  
		if(lookupPath.split("/").length==6){
			projectId = lookupPath.split("/")[1];//获得当前工程名字  
			lookupPath= lookupPath.substring(lookupPath.indexOf("/",1));
			request.setAttribute("lookupPath", lookupPath);
		}
		
		if(projectId!=null){ //当前是工程请求，需要权限判断
			request.setAttribute("projectId", projectId);
			//临时注释掉 
			//InterceptUtil.examUrl(lookupPath, projectId, request, null);
		}
		
//		String  lookupPath = "/project/login/action/MyAction_login.asp";
		String[] urlSplit = lookupPath.split("/");//根据URL的/分成数组
		//拼装出bean的名字
		String[] classAndMethod = urlSplit[4].split("_"); 
		String  className = classAndMethod[0];//类名
		String  methodName = classAndMethod[1].substring(0,classAndMethod[1].indexOf(46));//方法名称 
	//	String beanId = urlSplit[0] + "." + urlSplit[1] + "." + urlSplit[2] + "." + className;		
		//从map中通过beanId获取处理类
		request.setAttribute("currentMethodSpringMVC", methodName);
		
//		org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter@7e33de,
//		org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter@17f4790,
//		org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter@1335332
		
		Object handler = lookupHandler(lookupPath, request);
		return handler;
	}
	
	
	
	
	
	
	public static void main(String[] args) throws Exception{
		 UrlMapping um = new  UrlMapping();
		 um.getHandlerInternal(null);
	}
}
