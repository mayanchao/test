globalFunction.autoBuild_html_table_sampleTable = {
	 build:function(htmlObj){//构建html元素
	    tableHtml = "<table border=1 ><tr><td></td></tr></table>";
		globalFunctionHtmlCommonBuild(tableHtml,globalFunction.autoBuild_html_table_sampleTable);
		currentSelectObj.columnData = [];//当前列对象的属性
		console.dir(htmlObj);
		//在初始化	属性面板	
		//globalFunction.autoBuild_html_table_sampleTable.reload(currentSelectObj);
		if(htmlObj!=null){//是从数据库读入的数据
			 currentSelectObj.attr("id", htmlObj.id);
			 //设置当前对象的宽和高 
			 currentSelectObj.attr("width", htmlObj.width); 
			 currentSelectObj.attr("height",htmlObj.height);
			 //设置当前对象的列属性
			 currentSelectObj.widgetId = htmlObj.widgetId;
			 
			 eval("var myColumnJson=" + htmlObj.param1);
			 currentSelectObj.columnData = myColumnJson;
			 //设置位置 
//			currentSelectObj.offset({left:htmlObj.positionLeft});
//			currentSelectObj.offset({top:htmlObj.positionTop});
			//把param的所有属性加入
			currentSelectObj.param1 = htmlObj.param1; 
			currentSelectObj.param2 = htmlObj.param2;//url
			currentSelectObj.param3 = htmlObj.param3;
			currentSelectObj.param4 = htmlObj.param4;
			currentSelectObj.param5 = htmlObj.param5;
			currentSelectObj.param6 = htmlObj.param6;
			currentSelectObj.param7 = htmlObj.param7;
			currentSelectObj.param8 = htmlObj.param8;
			currentSelectObj.param9 = htmlObj.param9;
			//设置当前对象的宽和高
			currentSelectObj.width=htmlObj.width;
			currentSelectObj.height=htmlObj.height;
		}
		
		//globalFunction.autoBuild_html_table_sampleTable.refresh(currentSelectObj);
	},
	reload:function(mySelectObj){
		$("#tools_operateConsole").empty();
		
		$("#tools_operateConsole").load("/autoBuild/html/table/html/tempTable.html",{async:false},function(data){			
			//添加列
			//htmlObj.param1 获得当前的所有列信息 
			var myjsons = $.parseJSON(mySelectObj.param1);
			$.each(myjsons,function(index,data){
				globalFunction.autoBuild_html_table_sampleTable.operateColumnAdd( data );
			})
			
			//让第一个列选中
			$("#globalFunction_autoBuild_html_table_sampleTable_columnSelect option")[0].selected=true; 
			globalFunction.autoBuild_html_table_sampleTable.columnSelectChange();
			
			
			//设置url 和宽高
			$("#globalFunction_autoBuild_html_table_sampleTable_loadUrl").val(mySelectObj.param2);
			$("#globalFunction_autoBuild_html_table_sampleTable_width").val(mySelectObj.width);
			$("#globalFunction_autoBuild_html_table_sampleTable_height").val(mySelectObj.height);
			$("#globalFunction_autoBuild_html_table_sampleTable_page").val(mySelectObj.param3);
		    show_table_innerHTML_from_console("" + mySelectObj.attr("id"));
			
			
		});
		$("#tabs").tabs( "option","active", 0 );
	},	
	active:function(obj){
		 this.reload(obj);
	  },
	refresh:function(){
	  //生成当前列的信息值	  
		  var myColumnData = {
				 columnName:$("#globalFunction_autoBuild_html_table_sampleTable_columnName").val(),
				 columnWidth:$("#globalFunction_autoBuild_html_table_sampleTable_columnWidth").val(),
				 columnLoad:$("#globalFunction_autoBuild_html_table_sampleTable_columnLoad").val(),
				 methodName:$("#globalFunction_autoBuild_html_table_sampleTable_methodName option:selected").val()
		  };//当前列对象		  
		  var optionValue =$.toJSON( myColumnData );
		  $("#globalFunction_autoBuild_html_table_sampleTable_columnSelect option:selected").val(optionValue);
		  var columnSelectOptions = $("#globalFunction_autoBuild_html_table_sampleTable_columnSelect option");
		  show_table_innerHTML_from_console(currentSelectObj.attr("id"));
		
		  
		
		
	},
	buildMyHtml:function(myObj){
		var  saveObj = {};		
		saveObj["id"] =myObj.attr("id"); 
		saveObj["widgetId"] = myObj.widgetId;
		saveObj["positionLeft"] =myObj.parent().offset().left;
		saveObj["positionTop"]  =myObj.parent().offset().top;	  
			
		saveObj["htmlId"] = myObj.htmlId;
		saveObj["height"] = myObj.height;
		saveObj["width"]  = myObj.width;;
		saveObj["type"]  = myObj.currentName;;
		  var columnJsonS =[];
		   //获取列select中所有的值
		   $("#globalFunction_autoBuild_html_table_sampleTable_columnSelect option").each(function(index,data){
				  columnJsonS.push(data.value);
		   });
			 //生成列表数组
		//	 console.dir(this.columnData);
			// saveObj["param1"] =$("#globalFunction_autoBuild_html_table_sampleTable_columnSelect").val();
		   saveObj["param1"] =  myObj.param1;
		   saveObj["param2"] =  myObj.param2;
		   saveObj["param3"] =  myObj.param3;
		
		
		 return saveObj; 
	},
	
	operateColumnAdd:function(addObj){ //添加一个新的列方法
		
		//初始化当前列的默认值
		var myColumnData = {
				 columnName:"列名",
				 columnWidth:"140",
				 methodName:"globalToolsTableColumnTextDraw",//默认是展现数据列
				 columnLoad:""
		  };
		if(addObj!=null){//说明当前有值，要显示在添加里
			myColumnData = $.parseJSON(addObj);  
		}
		//清空字段 
		$("#globalFunction_autoBuild_html_table_sampleTable_columnName").val(myColumnData.columnName   );
		$("#globalFunction_autoBuild_html_table_sampleTable_columnWidth").val(myColumnData.columnWidth );
		$("#globalFunction_autoBuild_html_table_sampleTable_columnLoad").val(myColumnData.columnLoad);
		$("#globalFunction_autoBuild_html_table_sampleTable_methodName").val(myColumnData.methodName);
		
		//转换成字符串 
		var optionValue =$.toJSON( myColumnData );
		//添加列操作
		var myOptionIndex = $('#globalFunction_autoBuild_html_table_sampleTable_columnSelect option').length + 1 ;
		$("#globalFunction_autoBuild_html_table_sampleTable_columnSelect").append("<option value='" + optionValue + "' >" 
				+ "列" + myOptionIndex + "</option>");
		//刷新
	//	globalFunction.autoBuild_html_table_sampleTable.refresh();
		
	},operateColumnRemove:function(){//删除列操作 把所有列全删除 然后在重新生成并少一个
		var myOptionIndex = $('#globalFunction_autoBuild_html_table_sampleTable_columnSelect option:selected').remove();
		globalFunction.autoBuild_html_table_sampleTable.refresh();
	},
	columnSelectChange:function(myzz){ //选择当前列下拉框该变触发方法		
		//获取当前在select中选择的列
		var obj = $("#globalFunction_autoBuild_html_table_sampleTable_columnSelect option:selected");
		if( obj.length>0){			
			var myColumnData =$.parseJSON(obj.val());
			$("#globalFunction_autoBuild_html_table_sampleTable_columnName").val(myColumnData.columnName);
			$("#globalFunction_autoBuild_html_table_sampleTable_columnWidth").val(myColumnData.columnWidth);
			$("#globalFunction_autoBuild_html_table_sampleTable_columnLoad").val(myColumnData.columnLoad);
			$("#globalFunction_autoBuild_html_table_sampleTable_methodName").val(myColumnData.methodName);
		
		}
	},
	buildHtml:[],
	currentName:'globalFunction.autoBuild_html_table_sampleTable'
};

//重新渲染展现页面的table内容 
function show_table_innerHTML_from_console(theId){
	  var columnSelectOptions = $("#globalFunction_autoBuild_html_table_sampleTable_columnSelect option");
		  
		var  innerTable = "<tr>";
		//开始根据当前table的columnData属性 生成事例table
		for(var i=0;i<columnSelectOptions.length;i++){
			//把option标签里的值，转成json格式				
			var myJson = $.parseJSON(columnSelectOptions[i].value);
			innerTable += "<td width=" + myJson.columnWidth  +"  >" + myJson.columnName  + "</td>";
		}
		innerTable += "</tr>";
		$("#" + theId ).get(0).innerHTML = innerTable;
		//console.dir("refresh width=" + $("#globalFunction_autoBuild_html_table_sampleTable_width").val());
		//设置 宽和高 
		var width = $("#globalFunction_autoBuild_html_table_sampleTable_width").val();
		var height = $("#globalFunction_autoBuild_html_table_sampleTable_height").val();
		
		$("#" + theId ).attr("width",width);
		$("#" + theId ).attr("height",height);
		
		 //获取相对位置 
		  currentSelectObj["positionLeft"] = $("#" + theId ).parent().offset().left;
		  currentSelectObj["positionTop"] = $("#" + theId ).parent().offset().top;		  
		  currentSelectObj["height"] = height;
		  currentSelectObj["width"] = width;
		  var columnJsonS =[];
		   //获取列select中所有的值
		   $("#globalFunction_autoBuild_html_table_sampleTable_columnSelect option").each(function(index,data){
				  columnJsonS.push(data.value);
		   });
		   
			 //生成列表数组
		//	 console.dir(this.columnData);
		// saveObj["param1"] =$("#globalFunction_autoBuild_html_table_sampleTable_columnSelect").val();
		   currentSelectObj["param1"] = $.toJSON( columnJsonS );
		   currentSelectObj["param2"] =$("#globalFunction_autoBuild_html_table_sampleTable_loadUrl").val();
		   currentSelectObj["param3"] =$("#globalFunction_autoBuild_html_table_sampleTable_page").val();

}



//显示表格列扩展框的输入选项  
function show_table_param_Input(myObj,backFunction){
	var myVal = $("#globalFunction_autoBuild_html_table_sampleTable_methodName").val();
	//autoBuild_html_table_column_globalToolsTableColumnTextDraw
	var finalType = eval("autoBuild_html_table_column_" + myVal);
	openJsonTools(myObj,finalType,backFunction); 
	
}

//输入框的回调，工作流回调方法 
function show_table_param_Input_callback(){
	
		var	myJson =$.parseJSON(  currentSelectInput.val() );		
		//获得当前select 下拉框中的 类型值
		myJson.methodName = $("#globalFunction_autoBuild_html_table_sampleTable_methodName").val();
		//回写到输入框中
		currentSelectInput.val( $.toJSON( myJson ) )
		//刷新表格 
		globalFunction.autoBuild_html_table_sampleTable.refresh()
}


// 第一次加载table 控件信息  
//["{\"columnName\":\"列名\",\"columnWidth\":\"140\",\"columnLoad\":\"{\\\"columnName\\\":\\\"number\\\",\\\"methodName\\\":\\\"globalToolsTableColumnTextDraw\\\"}\",\"methodName\":\"globalToolsTableColumnTextDraw\"}","{\"columnName\":\"列名\",\"columnWidth\":\"140\",\"columnLoad\":\"{\\\"columnName\\\":\\\"delete\\\",\\\"click\\\":\\\"globalCommonAjaxbuildId_abc444_14025452972492\\\",\\\"myIds\\\":\\\"\\\",\\\"methodName\\\":\\\"globalToolsTableColumnButtonDrawById\\\"}\",\"methodName\":\"globalToolsTableColumnButtonDrawById\"}","{\"columnName\":\"列名\",\"columnWidth\":\"140\",\"columnLoad\":\"{\\\"columnName\\\":\\\"modify\\\",\\\"click\\\":\\\"globalDialogbuildId_abc444_14026533743944\\\",\\\"myIds\\\":\\\"\\\",\\\"methodName\\\":\\\"globalToolsTableColumnButtonDrawById\\\"}\",\"methodName\":\"globalToolsTableColumnButtonDrawById\"}","{\"columnName\":\"列名\",\"columnWidth\":\"140\",\"columnLoad\":\"{\\\"columnName\\\":\\\"name\\\",\\\"methodName\\\":\\\"globalToolsTableColumnTextDraw\\\"}\""
// param2: "/web/singleTable/action/SingleTableAction_findTable.do1?singleTableName=VotePeopleVO&tableJson={}"

