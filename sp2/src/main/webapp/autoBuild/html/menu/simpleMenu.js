globalFunction.autoBuild_html_menu_simpleMenu = {
	 build:function(htmlObj){//构建html元素	
		 var myhtml = "<label >menu</label>";		 
		 globalFunctionHtmlCommonBuild(myhtml,globalFunction.autoBuild_html_menu_simpleMenu);
		 if(htmlObj!=null){//是从数据库读入的数据
			 currentSelectObj.attr("id", htmlObj.id);
			 //设置当前对象的宽和高 
			 currentSelectObj.attr("width", htmlObj.width); 
			 currentSelectObj.attr("height",htmlObj.height);
			 //设置当前对象的列属性
			 currentSelectObj.widgetId = htmlObj.widgetId;
			 eval("var myColumnJson=" + htmlObj.param1);
			 console.dir(myColumnJson);
			 currentSelectObj.columnData = myColumnJson;
			 //设置位置 
			//把param的所有属性加入
			currentSelectObj.param1 = htmlObj.param1; 
//			currentSelectObj.param2 = htmlObj.param2;//url
//			currentSelectObj.param3 = htmlObj.param3;
//			currentSelectObj.param4 = htmlObj.param4;
//			currentSelectObj.param5 = htmlObj.param5;
//			currentSelectObj.param6 = htmlObj.param6;
//			currentSelectObj.param7 = htmlObj.param7;
//			currentSelectObj.param8 = htmlObj.param8;
//			currentSelectObj.param9 = htmlObj.param9;
			//设置当前对象的宽和高
			currentSelectObj.width=htmlObj.width;
			currentSelectObj.height=htmlObj.height;
		}
		 
    },
	reload:function(mySelectObj){
		$("#tools_operateConsole").empty();		
		//alert("ss" + mySelectObj.param1);
		$("#tools_operateConsole").load("/autoBuild/html/menu/html/menuTable.html",{async:false},function(data){			
			var myColumnData =$.parseJSON( mySelectObj.param1 );
			for(var i=0 ;i<myColumnData.length;i++){
				var buildFormat = buildLevelFormat($.parseJSON( myColumnData[i]).menuLevel);
				$("#globalFunction_autoBuild_html_menu_sampleMenu_columnSelect")
				.append("<option value='" + myColumnData[i]   + "' >" + buildFormat + $.parseJSON( myColumnData[i]).menuName + "</option>");
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
		$('#globalFunction_autoBuild_html_menu_sampleMenu_columnSelect option').each(function(index,mydata){
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
	            
	],add:function(obj){ //添加一个叶节点
		$("#globalFunction_autoBuild_html_menu_sampleMenu_columnSelect").append("<option value='' >新节点</option>");
		$("#globalFunction_autoBuild_html_menu_simpleMenu_menuName").val("");
		$("#globalFunction_autoBuild_html_menu_simpleMenu_menuLevel").val("");
		
	},modify:function(obj){ //修改一个叶节点
		var myOptionIndex = $('#globalFunction_autoBuild_html_menu_sampleMenu_columnSelect option:selected');
		$("#globalFunction_autoBuild_html_menu_simpleMenu_menuName").val(myOptionIndex.text());		
		$("#globalFunction_autoBuild_html_table_sampleTable_columnLoad").val(myOptionIndex.val());		
		$("#globalFunction_autoBuild_html_menu_simpleMenu_menuLevel").val($.parseJSON( myOptionIndex.val() ).menuLevel);
		
	},remove:function(obj){ //一个叶节点
		var myOptionIndex = $('#globalFunction_autoBuild_html_menu_sampleMenu_columnSelect option:selected').remove();
	},
	currentName:"globalFunction.autoBuild_html_menu_simpleMenu"
		
};

function show_menu_param_input(myObj,backFunction){ 
	var myOptionIndex = $('#globalFunction_autoBuild_html_menu_sampleMenu_columnSelect option:selected');
	if(myOptionIndex.length!=1){
		alert("必须选一个菜单节点");
		return ;
	}
	var myVal = $("#globalFunction_autoBuild_html_menu_simplemenu_url_type").val();	
	var finalType = eval("autoBuild_html_table_column_" + myVal);
	openJsonTools(myObj,finalType,backFunction); 
}
function show_menu_param_input_callback(){ 
	alert("callback............");
	var	myJson =$.parseJSON(  currentSelectInput.val() );
	myJson.methodName = $("#globalFunction_autoBuild_html_menu_simplemenu_url_type").val();
	
	//把当前控件的方法加上
//	console.dir(myJson);
	//移除当前选择节点
	 $('#globalFunction_autoBuild_html_menu_sampleMenu_columnSelect option:selected').remove();
	
	if(myJson.menuFather==""){//当前节点是根节点，直接在最后追加就可以
		alert("root");
		myJson.menuLevel=0;
		var myVal = $.toJSON( myJson );
		$("#globalFunction_autoBuild_html_menu_sampleMenu_columnSelect").append("<option value='" + myVal + "' >" + myJson.menuName + "</option>");
	}else{
		alert("child");
		$('#globalFunction_autoBuild_html_menu_sampleMenu_columnSelect option').each(function(index,mydata){
			if(mydata.value!=""){				
				var optionData = $.parseJSON(mydata.value);			
				if(optionData.menuNumber==myJson.menuFather){//跟父节点名称一样，把当前节点加入到这个父节点下面
					myJson.menuLevel = optionData.menuLevel +1;//菜单层级加一
					//根据层级生成空格 ，空格是每两个空格为一个单位
					var myLevelFormat = buildLevelFormat(myJson.menuLevel)
						
					var myVal = $.toJSON( myJson );
					alert("menuName same");
					$(mydata).after("<option value='" + myVal + "' >" + myLevelFormat + myJson.menuName + "</option>");					
				}
			}
		});
	}
	
	
//	
//	
//	
//	$("#globalFunction_autoBuild_html_menu_simpleMenu_menuName").val(myJson.menuName);
//	$("#globalFunction_autoBuild_html_menu_simpleMenu_menuLevel").val(myJson.menuFather);
//	//回写当前的菜单设置到 选中的下拉选项中
//	$("#globalFunction_autoBuild_html_menu_sampleMenu_columnSelect option:selected").val(myVal);
//	$("#globalFunction_autoBuild_html_menu_sampleMenu_columnSelect option:selected").text(myJson.menuName);
}
//根据层级数，展现树型的规格
function  buildLevelFormat(level){
	var re="|";
	for(var i=0;i<level;i++){
		re +="--";
	}
	return re;
}

////对当前菜单的下来列表，进行排序，子节点前面加上空格来区分
//function show_menu_param_tree_sore(){
//	var myTreeDate={};
//	//把当前下来菜单的值都变成对象
//	$("#globalFunction_autoBuild_html_menu_sampleMenu_columnSelect option").each(function(index,mydata){
//		var myjsons = $.parseJSON(mydata.value);
//		myTreeDate[myjsons.menuNumber]=myjsons;
//	});
//	for(var myObj in myTreeDate){		
//		if(myObj.menuFather!=null){//代表是父节点
//			//找到他的子节点
//			myTreeDate[myObj.menuFather].mychild = myObj;
//		}
//	}
//	//提取根节点 把当前根节点内容，提取出来放到一个数组中
//	var rootNode = [];	
//	for(var myObj in myTreeDate){		
//		if(myObj.menuFather==null){//代表是父节点
//			rootNode.push(myObj);
//		}
//	}
//	//便利rootNode节点，把当前所有节点顺序加上
//	for(var i=0;i<rootNode.length;i++){
//		searchChildNode(rootNode[i]);
//	}	
//	console.dir(rootNode);
//	return myTreeDate;
//}
//var myTempTree=[];
////搜索当前节点是否有子节点
//function searchChildNode(mynode,level){
//	var childnodes = [];
//	childnodes.push(mynode);//先把当前node节点放入list中
//	if( mynode.mychild!=null ){//有子节点 遍历所有子节点，看子节点中是否还有下一集菜单		
//		for(var i=0;i<mynode.mychild.length;i++){
//			searchChildNode(mynode.mychild[i]);
//		}		
//	}
//}










