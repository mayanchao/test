package com.mana.base.filter;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;

import com.mana.base.GlobalContants;
import com.mana.base.scan.ScanClassPackage;
import com.mana.base.tools.io.ToolsFile;
import com.mana.web.project.cloud.action.MyAction;
import com.mana.web.project.login.vo.MyLoginForm;

@WebListener
public class ApplicationServletInitFilter extends ContextLoaderListener {
	
	/**
	 * 用于加载xml配置文件的application，主要方便通过配置文件生成bean的方式
	 */
	public static ApplicationContext xmlApplicationContext;
	private static String configLocation = "classpath:applicationContext.xml"; //spring配置文件
	
	/**
	 * 可以自定义的application,用于自定义的bean，同时也是web 容器中的application，与上边的xmlApplicationContext 是父子关系 
	 */
	public static GenericWebApplicationContext genericWebApplicationContext ;
	
	/**
	 * 覆盖原来spring 加载方法，把自定义和xml都加载，并放入WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE 全局变量中 
	 */
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
 		 
//		super.initWebApplicationContext(servletContextEvent.getServletContext());
		//加载xml配置文件容器 
		xmlApplicationContext = new ClassPathXmlApplicationContext(configLocation);
		genericWebApplicationContext  = new GenericWebApplicationContext(servletContextEvent.getServletContext());
		//加载自定意配 bean 容器 
		genericWebApplicationContext.setParent(xmlApplicationContext);
		
		//生成全局变量
		ServletContext scontext = servletContextEvent.getServletContext();
		scontext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, genericWebApplicationContext);		
		try {
		//	PropertyConfigurator.configure("log4j.properties");
			
//			Properties p  = new Properties();
//			InputStream in = getClass().getResourceAsStream("classpath:log4j.properties");
//			p.load(in);
//			
//			File ff = new File("log4j.properties");
//	    	System.out.println(ff.getAbsolutePath());
	    	
			System.out.println("servlet 3.0 自动过滤类 ApplicationServletInitFilter 初始化 ");
			//开始扫描类成bean
			ScanClassPackage scp = new ScanClassPackage(GlobalContants.BASE_SCAN_BEAN_CLASS_PATTEN);
			Resource[] resources = scp.getResources(ToolsFile.localClasspath);
			//把扫描到的资源类，注册成spring容器的bean
			for(Resource resource:resources){
				registerBean(resource,genericWebApplicationContext);
			}
			//临时注册几个类 
			registerBeanUrl(null,genericWebApplicationContext);
			
//			test1();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//重新初始化容器
		genericWebApplicationContext.refresh(); 
	}



	private void test1() {
		MyAction myaction = (MyAction)genericWebApplicationContext.getBean("myAction1");
		System.out.println("ddddd=" + myaction);
		
		MyLoginForm ggg = genericWebApplicationContext.getBean("ggg",MyLoginForm.class);
		System.out.println("ddddd111=" + ggg);
	}

	
	private void registerBeanUrl(Resource resource,GenericWebApplicationContext beanFactory) throws IOException{
		
		try {
			Class myClass = Class.forName("com.mana.base.web.urlMapping.UrlMapping");
			AbstractBeanDefinition newProvider=new RootBeanDefinition(myClass);
			newProvider.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
			newProvider.setAutowireCandidate(true);
			
//			if(fileName.endsWith("LoginServiceImpl")){
//				newProvider.setBeanClass(LoginService.class);
//			}
			//MyAction
//			fileName = fileName.substring( fileName.lastIndexOf(".") +1 );//取出全类名
//			byte[] className =  fileName.getBytes();
//			className[0] = (byte) (className[0] +32);//转成小写
//			//myAction 把类名转成小写，然后作为bean的ID保存
//			String beanId = new String(className);
//			if(beanId.endsWith("Impl")){
//				beanId = beanId.substring(0, beanId.length()-4);
//				
//			}
			beanFactory.registerBeanDefinition("urlMapping123", newProvider);
			
		} catch (Exception e) {			
			RuntimeException re = new RuntimeException("加载bean出错" ,e);
			throw re;
		}
		//加载注释标签
//		org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor
		
	}
	
	
	
	/**
	 * 注册bean到容器中
	 * @param resource 要注册的类路径
	 * @param beanFactory 注册的容器
	 * @throws IOException
	 */
	private void registerBean(Resource resource,GenericWebApplicationContext beanFactory) throws IOException{
		String fileName = resource.getFile().getAbsolutePath() ;
		//D:\我的文档\桌面\项目备份\studysp\target\classes\com\mana\web\project\login\action\MyAction.class
		fileName = fileName.substring(fileName.indexOf("com\\mana") );//找到类的路径
		//com.mana.web.project.login.action.MyAction.class
		fileName = fileName.replace("\\", ".");//变成类路径
		//com.mana.web.project.login.action.MyAction
		fileName = fileName.replace(".class", "");//去除最后的class后缀
		//扫描到的只是接口，需要把路径转成实例化类
		//com.mana.web.project.login.action.MyAction
		try {
			Class myClass = Class.forName(fileName);
			AbstractBeanDefinition newProvider=new RootBeanDefinition(myClass);
//			newProvider.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);//自动注入类型 
//			newProvider.setAutowireCandidate(true);
			
			
			
			
//			if(fileName.endsWith("LoginServiceImpl")){
//				newProvider.setBeanClass(LoginService.class);
//			}
			//MyAction
			fileName = fileName.substring( fileName.lastIndexOf(".") +1 );//取出全类名
			byte[] className =  fileName.getBytes();
			className[0] = (byte) (className[0] +32);//转成小写
			//myAction 把类名转成小写，然后作为bean的ID保存
			String beanId = new String(className);
			if(beanId.endsWith("Impl")){
				beanId = beanId.substring(0, beanId.length()-4);
				
			}
			beanFactory.registerBeanDefinition(beanId, newProvider);
		} catch (Exception e) {			
			RuntimeException re = new RuntimeException("加载bean出错" ,e);
			throw re;
		}
		//加载注释标签
//		org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor
		
		
		
	}
	
	  
    
	public static void main(String[] args) {
		
//		MyAction my1 = (MyAction) ctx.getBean("maaction");
//		System.out.println("service1="  + my1.getLoginService());
//		ApplicationServletInitFilter.beanFactory  =new DefaultListableBeanFactory(ctx) ;		
//		ApplicationServletInitFilter a = new ApplicationServletInitFilter();
//		AbstractBeanDefinition newProvider=new RootBeanDefinition(AutowiredAnnotationBeanPostProcessor.class);
//		beanFactory.registerBeanDefinition("ids", newProvider);
//		a.contextInitialized(null);
//		System.out.println(a.getBeanFactory().getBean(LoginServiceImpl.class)); 
		
		ApplicationServletInitFilter a = new ApplicationServletInitFilter();
		a.contextInitialized(null);
		MyAction my = (MyAction) genericWebApplicationContext.getBean("myAction");
		
		System.out.println(genericWebApplicationContext.getBean("sqlSessionFactory"));
		//20130517092006218e2c9ffdc3b9f41c39ffb677efef215ce
				
//		System.out.println("service1="  + my.getLoginService());
//		my.login(null, null, null);
//		my.testAddUpdateDelete(null, null, null);
		
//		System.out.println(a.getBeanFactory().getBean("myAction"));
//		a.getBeanFactory().getBean("loginDao");
//		a.getBeanFactory().getBean("loginService");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("停止tomcat 销毁容器");
	}
	
}
