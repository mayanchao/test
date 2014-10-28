package com.mana.base.springView;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.view.AbstractView;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
//直接返回静态页面
public class MyHtmlParse extends AbstractView {
//	   protected Object filterModel(Map<String, Object> model) {	       
//		   Iterator it = model.keySet().iterator();
//		   //取出第一个值 并返回
//		   if(it.hasNext()){
//			   String key = "" + it.next();
//			   return model.get(key);
//		   }
//		   return null;
//	   }

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,HttpServletRequest request, HttpServletResponse response)throws Exception {
		Set set = model.keySet();
		Iterator it = set.iterator();
		while(it.hasNext()){
			String ccc = "" + it.next();
			System.out.println("ccc=" + ccc);
		}
		OutputStream stream = response.getOutputStream();
		String htmlContext = "" + model.get("string");
		stream.write(htmlContext.getBytes());
		
		
	}
	   
}





























