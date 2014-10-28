globalFunction.autoBuild_html_menu_topMenu = {		
	 build:function(htmlObj){//构建html元素	
		 
		 var myhtml = "<label >Topmenu</label>";		 
		 globalFunctionHtmlCommonBuild(myhtml,globalFunction.autoBuild_html_menu_topMenu);
		 if(htmlObj!=null){//是从数据库读入的数据
			 currentSelectObj.attr("id", htmlObj.id);
			 //设置当前对象的宽和高 
//			 currentSelectObj.attr("width", htmlObj.width); 
//			 currentSelectObj.attr("height",htmlObj.height);
			 //设置当前对象的列属性
			 currentSelectObj.widgetId = htmlObj.widgetId;
			 eval("var myColumnJson=" + htmlObj.param1);
			 console.dir(myColumnJson);
			 currentSelectObj.columnData = myColumnJson;
			 //设置位置 
			//把param的所有属性加入
			currentSelectObj.param1 = htmlObj.param1;
			//设置当前对象的宽和高
//			currentSelectObj.width=htmlObj.width;
//			currentSelectObj.height=htmlObj.height;	
		}
		 
    },
	reload:function(mySelectObj){
		$("#tools_operateConsole").empty();		
		//alert("ss" + mySelectObj.param1);
		$("#tools_operateConsole").load("/autoBuild/html/menu/html/menuTopTable.html",{async:false},function(data){			
			var myColumnData =$.parseJSON( mySelectObj.param1 );
			
			for(var i=0;i<myColumnData.length;i++){
				var mydata =$.parseJSON( myColumnData[i] );
				console.dir(mydata);
				$("#globalFunction_autoBuild_html_menu_topMenu_columnSelect").append("<option value=" + myColumnData[i] + " >" + mydata.menushow + "</option>");
			}
			
			
		});
		$("#tabs").tabs( "option","active", 0 );
    },
    active:function(obj){
  		this.reload(obj);
    },
	refresh:function(obj){
		alert("refresh............");
//		globalConsoleRefresh(this.buildHtml,this.currentName,currentSelectObj);
		var myObj = [];
		$('#globalFunction_autoBuild_html_menu_topMenu_columnSelect option').each(function(index,mydata){
			myObj.push( $(mydata).val());
		})
		currentSelectObj.param1=  $.toJSON( myObj ); 
    },
    buildMyHtml:function(obj){
    	var myObj = globalAutoBuildMyHtml(obj);    	
    	myObj.param1 = obj.param1;
    	console.dir(myObj);
    	return myObj;
	},buildHtml:[
	            
	],add:function(obj){ //添加一个节点
		$("#globalFunction_autoBuild_html_menu_topMenu_columnSelect").append("<option value='' >新菜单</option>");
		$("#globalFunction_autoBuild_html_menu_topMenu_menuLocation").val("");
		$("#globalFunction_autoBuild_html_menu_topmenu_url_type").val("");
	},modify:function(obj){ //修改一个节点
		var myOptionIndex = $('#globalFunction_autoBuild_html_menu_topMenu_columnSelect option:selected');				
		$("#globalFunction_autoBuild_html_table_topTable_columnLoad").val(myOptionIndex.val());		
		$("#globalFunction_autoBuild_html_menu_topmenu_location").val($.parseJSON( myOptionIndex.val() ).location);
		$("#globalFunction_autoBuild_html_menu_topmenu_type").val($.parseJSON( myOptionIndex.val() ).methodName);
	},remove:function(obj){ //删除一个节点
		var myOptionIndex = $('#globalFunction_autoBuild_html_menu_topMenu_columnSelect option:selected').remove();
	},
	currentName:"globalFunction.autoBuild_html_menu_topMenu"
		
};

function show_topmenu_param_input(myObj,backFunction){ 
	var myOptionIndex = $('#globalFunction_autoBuild_html_menu_topMenu_columnSelect option:selected');
	if(myOptionIndex.length!=1){
		alert("必须选一个菜单节点11");
		return ;
	}
	var myVal = $("#globalFunction_autoBuild_html_menu_topmenu_type").val();	
	var finalType = eval("autoBuild_html_table_column_" + myVal);
	openJsonTools(myObj,finalType,backFunction); 
}
function show_topmenu_param_input_callback(){ 
	alert("callback...........222.");
	var	myJson =$.parseJSON(  currentSelectInput.val() );
	myJson.methodName = $("#globalFunction_autoBuild_html_menu_topmenu_type").val();
	myJson.location = $("#globalFunction_autoBuild_html_menu_topmenu_location").val();
	//把当前控件的方法加上
	var jsonStr = $.toJSON( myJson );
	
	//移除当前选择节点
	 $('#globalFunction_autoBuild_html_menu_topMenu_columnSelect option:selected').remove();	
	 $("#globalFunction_autoBuild_html_menu_topMenu_columnSelect").append("<option value='" + jsonStr + "' >" + myJson.menushow + "</option>");
	 
	//重新排序select的位置
	 
	
}	
	








