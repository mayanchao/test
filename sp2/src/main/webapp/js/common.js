
//$(document).ajaxSend(onsend).ajaxStart(onStart).ajaxComplete(onComplete).ajaxSuccess(onSuccess).ajaxError(onError);
//	$(document).ajaxSuccess(onSuccess).ajaxSend(onsend).ajaxComplete(onComplete).ajaxSend(onsend)	
//	
//	function success1(event, xhr, settings) {
//		alert("star Success 查看错误号 1");
//		return false;
//	}
//	
//	function onSuccess(event, xhr, settings) {
//		alert("star Success 查看错误号 2");
//		console.dir(event);
//		console.dir(xhr.responseText);
//		console.dir(settings);
//		return false;
//	}
//	
//		function onsend(event) {			
//			alert("send");
//			return false;
//		}
//	
//		function onStart(event) {			
//			alert("start11");
//		}
//		function onComplete(event, xhr, settings) {
//			alert("onComplete");
////			console.dir(event);
////			console.dir(xhr.responseText);
////			console.dir(settings);
//			
//		}
//		
//		function onError(event) {
//			console.dir(event);
//			alert("error" );
//		}

/**
 *  myConfig  配置对象说明 
 *  myConfig.paramBuildJs //这个是构建请求参数对象的属性，如果有值得话就直接用eval执行 例如 
 *  空配置 {paramBuildJs:'',myCallBackFunction:'myCallBackRefreshCurrentPage(null'}
 */
	// '/web/back/action/BackSAutoetpOperateAction_executeWorkflow.do1?htmlId=page333'
	/**
	 * @param myUrl 请求的url 
	 * @param columnConfig 列的配置信息 
	 * @param myValue 传入的属性，一般是table中，每个列的属性 
	 */
function globalToolsAjaxSubmit(myUrl,columnConfig,myValue,syncType){	
	var myProjectName = findProject();
	$.ajax({
		  type: "POST",
		  url: "/" + myProjectName + myUrl,
		  data:myValue,
		  async: syncType=="sync",//如果是同步，就为true，否则为false 不同步
		  success: function(data){
			  var myJsonData =$.parseJSON(data);
			  if(myJsonData.error!=null){ //有公用的错误信息，打印出错误信息，不在执行业务逻辑
				  alert("出错了 错误信息是" + myJsonData.errorMsg);
				  return false;
			  }else{//执行业务逻辑
			  			  
		     //alert( "Data Saved: " + data );
		     //if(columnConfig.myCallBackFunction !="none(null"){
		    	 //执行调用后方法  临时注释
				eval(columnConfig.myCallBackFunction);
			 //}
			  }
		   }
	});
		
}
	
	/**
	 *  表格加载 
	 * @param myUrl       请求地址
	 * @param tableConfig 表格配置信息 
	 * @param tableId     表格主键  
	 * @param pageMove    表格偏移量 
	 */
	function globalToolsTableBuild(myUrl,tableId,pageMove){
			
		 //当前表的分页信息 从table对象中获取 这个值在加载页面的时候就被设置到table对象中 在<table  pageLimit1316=0 pageOffset1316=1 > 中 增加了属性
		 var pageLimit = $("#" + tableId ).attr("pageLimit1316");
		 var pageOffset = $("#" + tableId ).attr("pageOffset1316");
		 if(pageLimit && pageOffset){//判断当前table是否有分页信息 有的话加到url后面 
			 myUrl +=  "&pageLimit1316=" + pageLimit;
			//上一页不能是负数
			 pageOffset =  (pageOffset + pageMove)<0 ? 0: (pageOffset *1 + pageMove *1);
			 myUrl +=  "&pageOffset1316=" + pageOffset;
			 //修改table当前分页的值 
			 var pageLimit = $("#" + tableId ).attr("pageLimit1316",pageLimit);
			 var pageOffset = $("#" + tableId ).attr("pageOffset1316",pageOffset);
		 }
		 
		 //发送请求获取数据 
		$.post(myUrl,
		  { cache:false},
		   function(data){	
				 //根据结果，拼装table数据
				 globalToolsTableBuildByDate(data,{"id":tableId});
		   }
		); 
	}
	
	
	
	/**
	 *  表格重新加载 根据传入的data数据，重新加载表格 
	 * @param myUrl       请求地址
	 * @param tableConfig 表格配置信息 
	 * @param tableId     表格主键  
	 * @param pageMove    表格偏移量 
	 */
	function globalToolsTableBuildByDate(data,tableInfo){
		console.dir(data);
			  
		 //先删除表中数据，除了第一行
		  $("#" + tableInfo.id + " tr").each(function(i,item){
				if(i!=0){
					$(item).remove();
				}
			});
			
			 //通过table的主键，算出table的配置对象名称 
			eval("var tableConfig="   + "tableConfig" + tableInfo.id   );
			for(var i=0;i<data.length;i++){//数据结果集 
			  var currentTr = data[i];
			  var newRow = "<tr>"; 
			  for(var k=0;k<tableConfig.length;k++){
				  var myColumnLoad =$.parseJSON(tableConfig[k]);
				  var columnLoadJson = myColumnLoad.columnLoad ;//列生成方法
			//  alert("newRow +=" + myColumnLoad.methodName + "(" + myColumnLoad.columnLoad  + ",myColumnLoad,currentTr)");
			  //执行列修饰方法
			  eval("newRow +=" + myColumnLoad.methodName + "(" + myColumnLoad.columnLoad  + ",myColumnLoad,currentTr)" );
			  }
			  newRow += "</tr>";
			  $("#" + tableInfo.id + " tr:last").after(newRow);
			}
			  
	}
	
	
/*********************************************************************
      ajax方法分成了3个部分
      1 ajax调用前方法集合
      2 ajax调用后方法集合
      3 ajax调用后，table列表渲染方法集合
      4 插入执行js脚本区域
      5 其他工具方法
********************************************************************/
	//空配置 {paramBuildJs:"",myCallBackFunction:'myCallBackRefreshCurrentPage(null'}++
	
	
	//{paramBuildJs:"myCallBeforeSimpleFindValue(['buildId_autoSpotAdd_13823259824223','buildId_autoSpotAdd_13823259973655','buildId_autoSpotAdd_13823260040856'])",myCallBackFunction:'myCallBackRefreshCurrentPage(null'}
//========================1 ajax调用前方法集合==========================
	var myCallBeforeSimpleFindValue = function(columnConfig,ajaxConfig,myvalue){
		//console.dir(columnConfig);
		//console.dir(ajaxConfig);
		var myids = columnConfig.ids.split(",");
		
		var outObj = {};
		for(var i=0;i<myids.length;i++){
			//获取显示框的name;			
			var myName= $("#" + myids[i]).attr("name");
			//判断是否是radio或者checkbox类型的输入框，然后根据name取出值
			var value= $("#" + myids[i]).val();//取出当前输入侧值			
			if("radio" == $("#" + myids[i]).attr("type")  ){//如果是单选框类型，就必须用name取出页面所有的值，然后选择出checked按钮				
				value = $('input[name="' + myName + '"]:checked').val()  ;				
			}
			outObj[myName] =value;
		}		
		var re = $.toJSON(outObj);
		if(columnConfig.resultHandler == "tableJson"){//说明当前返回值需要拼写到url后面，并且参数名是tableJson
			ajaxConfig.myUrl = ajaxConfig.myUrl  + "&tableJson=" + re  
		}else if(columnConfig.resultHandler == "myValue"){//把当前值，拼装成 &name=key 的形式，加到url后面
			
		  var tmps = [];  
		  for (var key in outObj) {  
                tmps.push(key + '=' + outObj[key]);  
          }  	     
		  ajaxConfig.myUrl = ajaxConfig.myUrl +  '&' + tmps.join('&'); 
          
			
		}		
		console.dir( ajaxConfig.myUrl);
		return re;
	}
	//'buildId_pageModify_139913615813710','buildId_pageModify_13991017216874','buildId_pageModify_13991017289515','buildId_pageModify_13991017329046'
	/**
	 * {paramBuildJs:"myCallBeforeMyvalueVar('varSpotModify')",myCallBackFunction:'myCallBackSimpleSetValue(null'}
	 * 把myvalue变量，赋予全局对象  globalVar 定义
	 * @param globalVar  全局对象名称 
	 * @returns 要执行的脚本 
	 */
	var myCallBeforeMyvalueVar = function(columnConfig,ajaxConfig,myvalue){
		return "myValue=" + columnConfig + "";
	}
	
	
	var myCallBeforeBuildTableJson = function(columnConfig,ajaxConfig,myValue){
		myValue = {tableJson:$.toJSON( myValue )};
		return myValue;
	}
//	var myValue = {a:1};
//	myCallBeforeBuildTableJson("a","b",myValue)
//	alert(myValue.b);
	

//========================2 ajax调用后方法集合==========================
	//ajax回调方法 根据给出的ids值，从data属性中找出对值，然后调用val方法赋值 这个用户修改用户信息的时候，把数据库取出的值显示到页面上
	//
	var myCallBackSimpleSetValue = function(ids,myValue){
		for(var i=0;i<ids.length;i++){
			console.dir($("#" + ids[i]));
			//获取显示框的name;
			var myName= $("#" + ids[i]).attr("name");
			
			$("#" + ids[i]).val(myValue[myName]);
		}
	}

	
	//ajax回调方法 刷新当前界面 
	var myCallBackRefreshCurrentPage = function(ids,resultId,data){
		window.location.reload();
	}
	
	//ajax回调方法 跳转当前页面 
	var myCallBackGotoPage = function(temp,data){
		alert(data);
		//反解出入结果 然后解析出要跳转的页面
		var obj = jQuery.parseJSON(data);
		window.location.href = "/" + obj.page;
	}
	
	
//====================== 对外公用方法      {"myConfig":"myParam = '&tableJson=' + $.toJSON( mydata )","myCallBackFunction":"myCallBackSimpleSetValue(['id1','id2']"}
   //ajax 方法参数生成时候自己的类 方法 
//	function globalToolsTableAjaxSubmit(myUrl,param1){
//		var paramBuildJs = "myParam = '&tableJson=' + $.toJSON( mydata )";
//		var myConfig = {"paramBuildJs":paramBuildJs};
//		globalToolsAjaxSubmit( myUrl,param1,myConfig);
//	}	
  

	function runId(mydata){
	   return "&" + $.param(mydata);
	}

	
//=================================3 ajax调用后，table列表渲染方法集合==============================	
	/**
	 * 渲染表单列方法 根据列名，超找结果集中的属性 文本直接显示出来  例子  globalToolsTableColumnTextDraw('count',
	 * @param myname  字段配置
	 * @param columnConfig  列配置
	 * @param myValue      列的值 
	 */
	function globalToolsTableColumnTextDraw(buttonInfo,columnConfig,myValue1){
		//console.dir(myValue)
		var columnHtml = "<td>" ;
		 columnHtml += myValue1[buttonInfo.columnName];
		 columnHtml += "</td>";
		 return  columnHtml;
	}
	
	/**
	 * 渲染表单列方法 根据参数，展现按钮    例子  globalToolsTableColumnButtonDraw({value:'delete',onclick:'alert(123)'}
	 * 例子  globalToolsTableColumnButtonDraw({value:'delete',onclick:'globalCommonAjaxbuildId_autoSpotList_13823506210422'}
	 * @param buttonInfo   按钮信息 
	 * @param columnConfig  列配置
	 * @param myValue      列的值 
	 */
	function  globalToolsTableColumnButtonDrawById(buttonInfo,columnConfig,myValue){		
		var columnHtml = "<td>" ;
		//把当前列里的信息对象转成json字符串，直接传入到onclick对象中
		var myJson = $.toJSON( myValue );
		var myObjectClient = globalToolsTableValueReplace(buttonInfo.click,columnConfig,myValue);
		 columnHtml += "<input type=button value=" + buttonInfo.columnName +  "  onclick=" + buttonInfo.click + "(" + myJson +  ")  >";
		 columnHtml += "</td>";		 
		 return  columnHtml;
	}
	
	
	/**
	 * 渲染表单列方法 根据参数，展现映射列，例如 1=启动 ，2=停止
	 * 例子  globalToolsTableColumnButtonDraw({value:'delete',onclick:'globalCommonAjaxbuildId_autoSpotList_13823506210422'}
	 * @param buttonInfo   按钮信息 
	 * @param columnConfig  列配置
	 * @param myValue      列的值 
	 */
	function  globalToolsTableColumnEnumeration(buttonInfo,columnConfig,myValue){
		 var columnHtml = "<td>" ;
		 var myObjs = buttonInfo.maps.split(",");
		 var myMap={};
		 //生成主键和值
		 for(var i=0;i<myObjs.length;i++){
			 var theMap = myObjs[i].split("=");			 
			 myMap[theMap[0]] = theMap[1];
		 }
		 var theValue = myValue[buttonInfo.columnName];
		 if(myMap[theValue]!=null){//是在状态值内
			 columnHtml += myMap[theValue];
		 }else{
			 //没有找到值，默认显示 
			 if(buttonInfo.defaultValue!=null){
				 columnHtml += buttonInfo.defaultValue;
			 }
			 columnHtml += "</td>";
		 }
		 return  columnHtml;
	}
	
	/**
	 * 渲染表单列方法 根据参数，单选按钮
	 * @param buttonInfo   单选按钮信息 
	 * @param columnConfig  列配置
	 * @param myValue      列的值 
	 */
	function  globalToolsTableColumnRadioDrawById(buttonInfo,columnConfig,myValue){		
		var columnHtml = "<td>" ;
		//把当前列里的信息对象转成json字符串，直接传入到onclick对象中
		var myJson = $.toJSON( myValue );
		console.dir(buttonInfo);
		 columnHtml += "<input type=radio  value=" + myValue[buttonInfo.columnName] + "  id='" + buttonInfo.name + "'  name='" + buttonInfo.name + "'   />";
		 columnHtml += "</td>";		 
		 return  columnHtml;
	}
	
	
//=================================4 插入js代码块 ==============================
	/**
	 * 把myValue属性导入全局属性  
	 * @param globalVar 是全局属性名称。
	 */
	function globalJsInertVarMyValue(globalVar){
		return "" + globalVar + "=myValue;"
	}
	
	
	
//=============================5 其他工具方法==============	
	
	/**
	 * 替换表达式 把table中的值 值替换成对应的数据 并返回 
	 * 要替换的值用(_  和 _) 包起来 例如  (_id_)
	 * 实例 globalToolsTableValueReplace("/web/singleTable/action/SingleTableAction_deleteTable.do1?singleTableName=UserVoteVO&tableJson={'id':(_id_),'count':(_count_)}",null,{id:100,count:'ccc'});
	 * @param buttonInfo
	 * @param columnConfig
	 * @param myValue
	 */
	function globalToolsTableValueReplace(mySrc,columnConfig,myValue){		
		if(mySrc!=null){
			while(mySrc.indexOf("(_")>0){//判断是否 有需要替换的字符串
				var start1=mySrc.indexOf("(_") + 2; //替换字符串开始位置 
				var end1 = mySrc.indexOf("_)") - start1;  //计算出要提出按字符串中主键的长度  
				var myReplaceId =  mySrc.substr(start1,end1 );  //姐去除主键值
				var myReplaceValue = myValue[myReplaceId];   //根据主键值获取真正值
				mySrc = mySrc.replace("(_" + myReplaceId + "_)",myReplaceValue);
			}
			return mySrc;
		}	
	}
	
	
	//globalToolsTableValueReplace("/web/singleTable/action/SingleTableAction_deleteTable.do1?singleTableName=UserVoteVO&tableJson={'id':(_id_),'count':(_count_)}",null,{id:100,count:'ccc'});
	//js获取url参数值
	function getQueryString(name) {
	    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	    var r = window.location.search.substr(1).match(reg);
	    if (r != null) return unescape(r[2]); return null;
	}
	
	/**
	 * 改变变量 里的数值   
	 * @param name
	 * @param myValue
	 */
	function changeVar(name,myValue){
		eval("" + name + "=" + myValue);
	}
	
	/**
	 * 停止冒泡时间
	 * @param {Object} e
	 */
//  	function  globalToolsStopBubble(e){ 
//		if (e && e.stopPropagation) {
//			e.stopPropagation();
//		}else {
//			window.event.cancelBubble = true;
//		}	 
//	} 
	
  	
  	/**
  	 * 通用菜单集合 
  	 * @param myobj 当前对象 
  	 * @param event 出发事件对象 
  	 */
  	function globalTools_menu_collacp(myobj,event){
		
		$(myobj).parent().children("li").each(function(index,data){			
	    	if(index!=0){
	    		$(data).toggle(1000);
    		}
	    });
		//停止冒泡
		//globalToolsStopBubble(event);
	}
  	
//=============校验方法区域====================================validate====================================
	/**
	 *  根据输入值，判断长度是否符合要求
		String  maxLen = map.get("maxLength");
		String  minLen = map.get("minLength");
		String  errorText = map.get("errorText");
		String  errorType = map.get("errorType");
		String  handleType = map.get("handleType");
	 */
	function autoBuild_html_validate_textLength_js(conf,myThis){
		//获取当前属性的值
		var myVal = $(myThis).val();
		var maxlen = conf.maxLength;
		var minlen = conf.minLength;
		console.dir("maxlen=" + maxlen + "   minlen=" +  minlen  + " valuelength=" + myVal.length);
		if(myVal.length>maxlen ||  myVal.length<minlen ){
			//提示错误信息			
			if(conf.errorType=="alert"){
				alert(conf.errorText);
				return false;
			}
		}
		return true;
	}
	
	
	
	
//===============================页面跳转
	/**
	  * @param divName  要重新加载div块的名字 
	  * @param pageUrl  要重新加载页面的地址 
	 */
	function autoBuild_html_page_reload_div(divName,pageUrl){
		$("#" + divName).load(pageUrl);//重新加载页面
	}
	/**
	 * 查找当前工程名称
	 * @returns 
	 */
	function findProject(){
		var myUrl = window.location.href;
		return myUrl.split("/")[4];//当前项目名称 
	}
	//ajax 全局变量 
	$.ajax({
        type: "get",
        url: "",
                data : {},
        beforeSend : function(){

        },
        success : function(data){

        },
        complete : function(){

        }
     });
	
//================获取cookie =============
	
	function getcookie(name){
		var strcookie=document.cookie;
		var arrcookie=strcookie.split("; ");
		for(var i=0;i<arrcookie.length;i++){
		var arr=arrcookie[i].split("=");
		if(arr[0]==name)return arr[1];
		}
		return "";
	}
	
	
	function addcookie(name,value,expireHours){
		var cookieString=name+"="+escape(value);
		//判断是否设置过期时间
		if(expireHours>0){
		var date=new Date();
		date.setTime(date.getTime+expireHours*3600*1000);
		cookieString=cookieString+"; expire="+date.toGMTString();
		}
		document.cookie=cookieString;
		}
	
//================获取cookie =============
	/**
	 * 从url中获取参数 
	 * @param {Object} name
	 */
	function getUrlParam(name){
		var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
		var r = window.location.search.substr(1).match(reg);  //匹配目标参数
		if (r!=null) return unescape(r[2]); return null; //返回参数值
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	