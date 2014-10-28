
//离开焦点时候校验判断


//aaaa:<input  type="text" onfocusout=" validateLength(this, { type:'validateLength',showType:'alert',errortext:'长度必须在(_maxLength_)到(_minLength_)字符之间',maxLength:10,minLength:2 })"   >
//validateType是校验类型配置对象 并且以数组类型存放，errorType是错误信息显示类型，
//{validateType:[{errortext:'长度不能超过_len_',inputLenth:100},{errortext:'输入的必须是数字',type:'validateNumber'}],errorShow:'div', }

//输入时候出发校验判断  
//错误提示在哪里 
//最后提交按钮 的时候判断是否有非法输入的值 ，判断所有input框有 manaValidate=true这个属性就可以
function validateConfig(){
	
}
//errortext是错误提示信息,inputLenth这个是输入条件判断自己的参数，showType显示错误信息类型， 返回结果目前只有真和假
//注意公用属性要放到最前面，方法里用到的自定义的属性放到最后面
//{ type:'validateLength',showType:'alert',errortext:'长度必须在_maxLength_到_minLength_字符之间',maxLength:100,minLength:10 }
//判断字符串长度
function validateLength(obj,myConfig){
	var inputValue = $(obj).val();
	alert(inputValue);
	if(inputValue!=null){
		if(inputValue.length>myConfig.maxLength  ||  inputValue.length<myConfig.minLength ){			
			//显示错误信息 
			validate_js_showType(myConfig);
		}	
	}
}
//判断是否是数字
//{errortext:'输入的必须是数字',type:'validateNumber'  }
function validateNumber(myConfig){
	
}



//==============效验方法 公用区域===============
//校验区域的前端js校验，显示类型
function validate_js_showType(myConfig){
	if(myConfig.showType=="alert"){
		//替换提示字符串信息
		var message =globalToolsTableValueReplace(myConfig.errortext,null,myConfig);
		
		alert(message);
	}
}







