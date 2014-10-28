globalFunction.autoBuild_html_input_select = {
	 build:function(htmlObj){//构建html元素
	    tableHtml = "<select></select>";
		globalFunctionHtmlCommonBuild(tableHtml,globalFunction.autoBuild_html_input_select);

		
		
		if(htmlObj!=null){//是从数据库读入的数据		
			currentSelectObj.param1=htmlObj.param1;
			currentSelectObj.name=htmlObj.param2;
			currentSelectObj.id=htmlObj.id;
		}
	},
	reload:function(mySelectObj){
		$("#tools_operateConsole").empty();
		$("#tools_operateConsole").load("/autoBuild/html/input/html/tempSelect.html",{async:false},function(data){
			console.dir(mySelectObj);
			if(mySelectObj.param1!=null){
				var myjsons = $.parseJSON(mySelectObj.param1);
				for(var i=0;i<myjsons.length;i++){//把所有选项添加上
					var myobj = myjsons[i];
					$("#globalFunction_autoBuild_html_input_sampleSelect_list").append("<option value='"  + myobj.value  + "' >" + myobj.name + "</option>");
				}
			}
			//把当前ID和name属性显示出来
			$("#globalFunction_autoBuild_html_input_sampleSelect_id").val(mySelectObj.id);
			$("#globalFunction_autoBuild_html_input_sampleSelect_name").val(mySelectObj.name);
		});
		$("#tabs").tabs( "option","active", 0 );
	},	
	active:function(obj){
		 this.reload(obj);
	  },
	refresh:function(){
		globalConsoleRefresh(this.buildHtml,this.currentName,currentSelectObj);
		var mydates = [];
		//读取当前select中的值，然后写入当前对象
		$("#globalFunction_autoBuild_html_input_sampleSelect_list option").each(function(index,data){
			mydates.push({"name":data.text,
						  "value":data.value
				});
		});
		
		var jsonStr = $.toJSON(mydates);
		currentSelectObj.param1=jsonStr;
		//把当前name刷新进去
		var myName = $("#globalFunction_autoBuild_html_input_sampleSelect_name").val();
		currentSelectObj.name=myName;
	},
	buildMyHtml:function(myObj){
		console.dir(myObj);
		 //获取相对位置 
		 
//		debugger;
		var  saveObj = {};		
		saveObj["id"] =myObj.attr("id"); 
		saveObj["widgetId"] = myObj.widgetId;
		saveObj["positionLeft"] = myObj.parent().offset().left;
		saveObj["positionTop"] = myObj.parent().offset().top;	 
			
		saveObj["htmlId"] = myObj.htmlId;
		saveObj["height"] = myObj.height;
		saveObj["width"]  = myObj.width;;
		saveObj["type"]  = myObj.currentName;;
		saveObj["param1"] =  myObj.param1;
		saveObj["param2"] =  myObj.name;
		 return saveObj; 
	},
	buildHtml:[
	             {attrName:"id",showtext:"id"},
	             {attrName:"width",showtext:"宽度",defaultValue:"100"},
	             {attrName:"height",showtext:"高度",defaultValue:"100"}
	],
	currentName:'globalFunction.autoBuild_html_input_select',
	addOptions:function(){//添加选项
		var name = $("#globalFunction_autoBuild_html_input_sampleSelect_add_name").val();
		var value = $("#globalFunction_autoBuild_html_input_sampleSelect_add_value").val();
		$("#globalFunction_autoBuild_html_input_sampleSelect_list").append(
					"<option value='"  + value  + "' >" + name + "</option>");
		
		//清空一下，显得好看
		$("#globalFunction_autoBuild_html_input_sampleSelect_add_name").val("");
		$("#globalFunction_autoBuild_html_input_sampleSelect_add_value").val("");
		
		
	},
	modifyShowOption:function(){//展现到修改
		
		
		var myObj = $('#globalFunction_autoBuild_html_input_sampleSelect_list option:selected');
		var name = myObj.text();
		var value = myObj.attr("value");
		$("#globalFunction_autoBuild_html_input_sampleSelect_modify_name").val(name);
		$("#globalFunction_autoBuild_html_input_sampleSelect_modify_value").val(value);
		
		
	},
	modifyOptions:function(){//修改选项
		var myObj = $('#globalFunction_autoBuild_html_input_sampleSelect_list option:selected');
		var name = $("#globalFunction_autoBuild_html_input_sampleSelect_modify_name").val();
		var value = $("#globalFunction_autoBuild_html_input_sampleSelect_modify_value").val();
		myObj.text(name);
		myObj.attr("value",value);
		
		//清空一下，显得好看
		$("#globalFunction_autoBuild_html_input_sampleSelect_add_name").val("");
		$("#globalFunction_autoBuild_html_input_sampleSelect_add_value").val("");
	},
	deleteOptions:function(){//删除选项
		$('#globalFunction_autoBuild_html_input_sampleSelect_list option:selected').remove();
	}
};



