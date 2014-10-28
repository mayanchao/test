package com.mana.base.servlet;

import java.io.File;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Servlet implementation class FirstServlet
 */

public class SpringMVCDispatcherServlet extends DispatcherServlet {
    
//    final static Logger LOG = LoggerFactory.getLogger(FirstServlet.class);
    
    private static final long serialVersionUID = 6833688147345340845L;

    @Override
    public String getContextAttribute() {
    	
    	File ff = new File("ccc.txt");
    	System.out.println(ff.getAbsolutePath());
    	
    	System.out.println(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
    	System.out.println(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
    	System.out.println(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
    	System.out.println(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
    	System.out.println(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
    	System.out.println(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
    	
    	return WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
	}
    
//    protected WebApplicationContext initWebApplicationContext() {
//    	this.setContextAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//		return (WebApplicationContext) ApplicationServletInitFilter.genericWebApplicationContext ;
//    }
    
//    public void init() throws ServletException {
//    	System.out.println("init servlet start 222222222222222222222222");
//    }
//    
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        LOG.info("hello");
//        PrintWriter out = response.getWriter();
//        out.print("first servlet");
//        out.flush();
//        out.close();
//        
//    }


}