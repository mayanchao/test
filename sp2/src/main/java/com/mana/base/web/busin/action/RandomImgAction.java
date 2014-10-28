package com.mana.base.web.busin.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.mana.base.tools.other.RandomImgCode;
import com.mana.base.web.BaseActionClass;

/**
 * 业务类
 * @author hc360
 *
 */
public class RandomImgAction  extends BaseActionClass{
	
	/**
	 * 查找用户页面配置了那些角色
	 * @param request
	 * @param response
	 * @return
	 */
	//http://localhost:8080/web/busin/action/RandomImgAction_buildRandomImgCode.do1?projectId=ccc
	public ModelAndView buildRandomImgCode(HttpServletRequest request,HttpServletResponse response){
		   response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
	        response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
	        response.setHeader("Cache-Control", "no-cache");
	        response.setDateHeader("Expire", 0);
	        RandomImgCode randomValidateCode = new RandomImgCode();	        
	        try {
	        	String code = randomValidateCode.getRandcode(request, response);//输出图片方法
	        	request.getSession().setAttribute(code, 0);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		return null;
	}
	
	
}

