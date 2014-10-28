
//添加步骤
function background_addSetp(mySetpType){
	var  autoOperateSetpId = $("#background_setp_AutoSetpId").val(); //当前步骤的ID	
	//生成一个步骤对象
	var newObj = {
			"type": $("#background_type").val(), //当前select的属性 
			"autoSetpId":autoOperateSetpId,//当前步骤的ID
			"name":"newSetp"
	};
	$("#background_stepList").append("<option selected  >" + newObj.name + "</option>"); //添加一个select选项框 
	$("#background_param_json").val( $.toJSON( newObj) );//初始化属性输入框
	
		
}

//选择当前工作流类型时候，清空属性选项
function show_workflow_type_select_chance(myObj,backFunction){
	$("#background_param_json").val("");
	$("#background_parentId").val("");
	
}

//显示工作流属性界面
function show_workflow_param_Input(myObj,backFunction){	
	var myVal = $("#background_type").val();
	console.log("back_workflow_operate_" + myVal);
	var finalType = eval("back_workflow_operate_" + myVal);
	openJsonTools(myObj,finalType,show_workflow_param_callback);
}


//显示工作流回调方法 
function show_workflow_param_callback(){
	alert(333);
	var	myJson =$.parseJSON(  currentSelectInput.val() );
	//获得当前select 下拉框中的 类型值
	myJson.type = $("#background_type").val();
	console.dir(myJson);
	myJson.autoSetpId = $("#background_setp_AutoSetpId").val();
	
	//回写父节点属性
	$("#background_parentId").val(myJson.parentId);
	//回写类型字段
	//$("#background_type").val(myJson.type);
	//回写list属性节点
	// var x=document.getElementById("background_stepList").options[0].selected=true;
	var mySetpList = $("#background_stepList").get(0);
	mySetpList.options[mySetpList.selectedIndex].innerHTML=myJson.name;
	mySetpList.options[mySetpList.selectedIndex].value= $.toJSON( myJson );
	
	
}


//最后保存步骤
function background_saveAllSetp(){
	//步骤ID
	var mySetpID = $("#background_setp_AutoSetpId").val();
	//获取步骤列表的值
	var myOptions = $("#background_stepList").get(0).options;
	
	//先删除所有旧节点	
	$.ajax({
		type:"post",
		async:false,//同步删除数据
		url:"/web/singleTable/action/SingleTableAction_deleteTableByWhere.do1?singleTableName=AutoOperateSetpVO",
		data:{"tableJson": "{autoSetpId:'" + mySetpID + "'}"  }
	});
	for(var i=0;i<myOptions.length;i++){
//		var jsonStr = $.toJSON( mydate );		
		$.post("/web/singleTable/action/SingleTableAction_save.do1", 
				{"tableJson": myOptions[i].value,
				"singleTableName":"AutoOperateSetpVO"
				},
			   function(data){
				//	alert("生成所有的步骤完成 ");
					//background_initSetp(mySetpID);
			   }
		);
	}
}

//sql = select * from Auto_Operate_Setp where 1=1  and  auto_setp_id=?    order by parent_id
//初始化步骤界面 
function background_initSetp(mySetpId){
//	alert("加載步驟ID=" + mySetpId);
	//把该属性显示到右侧 
	//$("#background_stepList").bind("click",findOperateList);
	$.ajax({
		type:"post",
		async:false,//同步删除数据
		url:"/web/singleTable/action/SingleTableAction_findTable.do1",
		data:{"tableJson":"{autoSetpId:'" +  mySetpId  + "' ,orderBy191233:'parent_id'}","singleTableName":"AutoOperateSetpVO"},
		success:function(data){
			//select * from Auto_Operate_Setp where 1=1  and  auto_setp_id='setp444'
			$("#background_stepList").empty();						
			//初始化list表
			for(var i=0;(data!=null && i<data.length);i++){
				var varItem = new Option(data[i].name , $.toJSON(  data[i])  );				
				document.getElementById("background_stepList").options.add(varItem);     
				$("#background_param_json").val(  $.toJSON(  data[i] )  );				
				$("#background_name").val(data[i].name);
				$("#background_parentId").val(data[i].parentId);
			}
			if(data!=null){
				//把第一步加上
				$("#background_param_json").val(  $.toJSON(  data[0] )  );				
				$("#background_name").val(data[0].name);
				$("#background_parentId").val(data[0].parentId);
				//设置属性下拉框中当前的值
				$("#background_type").val(data[0].type);
			}	
	   }
	});
}


//删除当前步骤  直接从select列表里闪出掉
function  background_deleteCurrentSetp(){
	var selectIndex = $("#background_stepList").get(0).selectedIndex;	
	$("#background_stepList").get(0).options.remove(selectIndex); 
	
}


//[{"type":"FindSingleDateOperate","autoSetpId":"setp444","name":"newSetp"},{"type":"FindSingleDateOperate","autoSetpId":"setp444","name":"newSetp"}]
//选择列表框步骤
function background_change_sept(){
	
	var myJsonStr =  $("#background_stepList option:selected").val();	
	if(myJsonStr!=null){
		var	myJson =$.parseJSON( myJsonStr );
		console.dir(myJson);
			
		
		$("#background_param_json").val( myJsonStr );
		$("#background_parentId").val(  myJson.parentId );
		$("#background_type").val( myJson.type);
	}
	
}

//加载步骤
function background_loadSetp(){
	var  autoOperateSetpId = $("#background_setp_AutoSetpId").val();	
	background_initSetp(autoOperateSetpId);
	if(document.getElementById("background_stepList").options.length>0){
		//加载页面后选择第一个选项
		 var x=document.getElementById("background_stepList").options[0].selected=true;
	}
	
	
	
}
background_loadSetp();