package org.shirdrn.spring.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ShirdrnController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		   System.out.println("ddddddddddddddddd3333dddddddddddddd");
		   return new ModelAndView("/index.jsp");
	}	
}