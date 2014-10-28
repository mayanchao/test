package com.mana.base.springView;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;

public class MyJsonParse extends FastJsonJsonView{
	   protected Object filterModel(Map<String, Object> model) {	       
		   Iterator it = model.keySet().iterator();
		   //取出第一个值 并返回
		   if(it.hasNext()){
			   String key = "" + it.next();
			   return model.get(key);
		   }
		   return null;
	   }
	   
}





























