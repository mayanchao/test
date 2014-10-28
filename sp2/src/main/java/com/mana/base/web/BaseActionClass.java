package com.mana.base.web;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.alibaba.fastjson.JSON;
import com.mana.autoBuild.daoVO.ReturnJsonVO;
import com.mana.autoBuild.tableVO.AutoBuildWidgetVO;
import com.mana.base.filter.ApplicationServletInitFilter;
import com.mana.base.tools.error.ErrorMessageUtil;
import com.mana.base.tools.sql.DateBaseOperateUtil;
import com.mana.web.project.cloud.action.MyAction;

public abstract class BaseActionClass implements Controller {
	
	private Map<String,MethodInfo> methodMap ;
	
	
	public BaseActionClass(){
		//第一次调用action 类，
		methodMap = new HashMap<String,MethodInfo>();
		initAction();
	}
	
	/**
	 * 初始化action方法 
	 */
	protected void initAction(){
		Method[] methods = this.getClass().getMethods();
		for(int i=0;i<methods.length;i++){//判断action中的方法是否符合 request,response ,object对象 
			Class[] params = methods[i].getParameterTypes();
			if(params.length>1 &&  params[0] ==  HttpServletRequest.class	&& params[1] ==  HttpServletResponse.class){
				MethodInfo methodInfo = new MethodInfo(methods[i]);
				if(params.length>2 ){
//					String className = params[2].;
//					try {
						//去掉数组 
//						className = className.replace("[]", "");
						//com.mana.autoBuild.tableVO.AutoBuildWidgetVO[]
						//判断是否是数组参数
//						Class voClass = Class.forName(className);
						methodInfo.setVoClass(AutoBuildWidgetVO.class); 
//					} catch (ClassNotFoundException e) {
//						e.printStackTrace();
//					}
				}
				methodMap.put(methods[i].getName(), methodInfo);
			}
		}
//		tempInitParam();
	}
	//所有请求都先到这里，分级一下 
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView view = null;
		try{
			//权限判断 拦截器判断
			String projectId = "" + request.getAttribute("projectId");
			if(projectId!=null){ //当前是工程请求，需要权限判断
				request.setAttribute("projectId", projectId);
				//临时注释掉 
				//InterceptUtil.examUrl(lookupPath, projectId, request, null);
			}
			//有验证码 
			//判断是否有验证码
			if(  request.getParameter("imgRandomCode99813") != null){
				String code = request.getParameter("imgRandomCode99813");
				if(  request.getSession().getAttribute(code) == null){ //验证码没有判断成功
					     
					String errorJson = ErrorMessageUtil.errorMessageHandler("randomCodeError-1", "验证码错误");
				//	response.setStatus(400);
					response.getOutputStream().write(  errorJson.getBytes() );
					//response.getOutputStream().write("{\"a\":1}".getBytes() );
					response.flushBuffer();
					return null;
				}
			}
			
			String methodName = (String) request.getAttribute("currentMethodSpringMVC");
			MethodInfo methodInfo = methodMap.get(methodName);
			
			//是否有自动把url参数注入到vo。
			if(methodInfo.getClass()!=null   && methodInfo.getVoClass()!=null){
				String json = request.getParameter("jsonClass" + methodInfo.getVoClass().getSimpleName());
				if(json.startsWith("[")){
					List<AutoBuildWidgetVO> param1s = JSON.parseArray(json, AutoBuildWidgetVO.class);
					view =  (ModelAndView)methodInfo.getMethod().invoke(this, request,response,param1s);
				}else{
					//取出json对象转成vo 
					Object param1 = JSON.parseObject(json, methodInfo.getVoClass());
					 view =  (ModelAndView)methodInfo.getMethod().invoke(this, request,response,param1);
				}
			}else{
				 view =  (ModelAndView)methodInfo.getMethod().invoke(this, request,response);
			}
		}catch(Exception e){//拦截所有的异常
			//跳转错误界面 
			e.printStackTrace();
			return null;
//			response.sendRedirect("/project/errorPage/exception.html");
		}
		return view;
	}
	/**
	 * 获取service类信息 
	 * @param <T>
	 * @param requiredType
	 * @return
	 */
	public  <T> T findService(Class<T> requiredType){
		return ApplicationServletInitFilter.genericWebApplicationContext.getBean(requiredType);
	}
	
	/**
	 * 单表存储，从界面json直接拿下来
	 * @param request
	 * @param response
	 * @param vo
	 */
	//http://localhost:8080/project/login/action/MyAction_a1InsertSingleSaveTable.do1?id=100&aa.bs=aa&jsonClassAutoBuildWidgetVO={"height":10,"htmlID":"id1","positionLeft":0,"positionTop":0,"selfJson":"{text:'abc'}","sqlParam":{},"type":"label","width":1000} 
	public ModelAndView a1InsertSingleSaveTable(HttpServletRequest request,HttpServletResponse response,AutoBuildWidgetVO vo ){
		System.out.println("insert start ");
		String id =  DateBaseOperateUtil.inserByAutoBuildVO(vo);
		 ModelAndView mv = new ModelAndView("jsonView");
		 ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		 returnJsonVO.setId(id);
		 mv.addObject(returnJsonVO);  
		return mv;
	}
	/**
	 * 单表删除，从界面json直接拿下来
	 * @param request
	 * @param response
	 * @param vo
	 */
	public ModelAndView a1DeleteSingleSaveTable(HttpServletRequest request,HttpServletResponse response,AutoBuildWidgetVO vo ){
		DateBaseOperateUtil.deleteByAutoBuildVO(vo);
		return null;
	}
	/**
	 * 单表更新，从界面json直接拿下来
	 * @param request
	 * @param response
	 * @param vo
	 */
	public ModelAndView a1UpdateSingleSaveTable(HttpServletRequest request,HttpServletResponse response,AutoBuildWidgetVO vo ){
		DateBaseOperateUtil.updateByAutoBuildVO(vo);
		return null;
	}
	
	//临时方法 
	private void tempInitParam(){
		try {
			MethodInfo methodInfo1 = new MethodInfo();
			Method method1 = MyAction.class.getMethod("autoWidgetAdd", HttpServletRequest.class,HttpServletResponse.class,AutoBuildWidgetVO.class );
			methodInfo1.setMethod(method1);
			methodInfo1.setVoClass(AutoBuildWidgetVO.class  );
			methodMap.put("autoWidgetAdd", methodInfo1);
			
			
			MethodInfo methodInfo2 = new MethodInfo();
			Method method2 = MyAction.class.getMethod("a1InsertSingleSaveTable", HttpServletRequest.class,HttpServletResponse.class,AutoBuildWidgetVO.class );
			methodInfo2.setMethod(method2);
			methodInfo2.setVoClass(AutoBuildWidgetVO.class  );
			methodMap.put("a1InsertSingleSaveTable", methodInfo2);
			
			
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		
		
		
//		methodMap 
	}
	
	/**
	 * 构建json 视图
	 * @param obj
	 * @return
	 */
	public ModelAndView buildJsonModelAndView(Object obj){
		ModelAndView view = new ModelAndView("jsonView");
		if(obj!=null){
			view.addObject(obj);
		}	
		return view;
	}	
	
	/**
	 * 构建json 视图
	 * @param obj
	 * @return
	 */
	public ModelAndView buildHtmlModelAndView(Object obj){		
		ModelAndView view = new ModelAndView("htmlView");
		if(obj!=null){
			view.addObject(obj);
		}	
		return view;		
	}
	
}
/**
 * 方法 信息 ，记录该方法的 检验对象 ，该方法如何生成对象 等 
 * @author hc360
 *
 */
class MethodInfo{
	
	public MethodInfo(){}
	
	
	private Method method;
	private MethodValidate MethodValidate;
	private Class voClass;
	
	public Class getVoClass() {
		return voClass;
	}

	public void setVoClass(Class voClass) {
		this.voClass = voClass;
	}

	public MethodInfo(Method method){
		this.method = method;
	}
	
	public Method getMethod() {
		return method;
	}
	public void setMethod(Method method) {
		this.method = method;
	}
	public MethodValidate getMethodValidate() {
		return MethodValidate;
	}
	public void setMethodValidate(MethodValidate methodValidate) {
		MethodValidate = methodValidate;
	}
	
	
}

/**
 * 检查方法参数机制 
 * @author hc360
 *
 */
class MethodValidate{
	
}
