base_baseshow_company_js_com = {
		init:function(addTemlpeteUl){			
			var  selfhelpTempletId = getUrlParam("selfhelpTempletId");//当前模板id主键			
			//获得当前模版的的位置
			var moduleContain = $("#" + addTemlpeteUl + " li");
			//默认类型  company 
		 	var myurl = "/web/busin/action/BusinTempletAction_init.do1?moduleType=CompanyInfoTempletModule&selfhelpTempletId=" + selfhelpTempletId;
		 	myurl +="&moduleContainId=" + addTemlpeteUl;
		 	myurl +="&moduleContainLocation=" + moduleContain.length;
		 	
			$.ajax({
				  type: "POST",
				  url: myurl,
				  async: true,//如果是同步，就为true，否则为false 不同步
				  success: function(data){
					  
//					  var myJsonData =$.parseJSON(data);
					  var myHtml = "<li >" + 
		      			"<a  class='list-group-item'>" +
							data.showHtml	
				          + "</a>" +
				    	"</li>"
					  var newObj = $(myHtml);
				  	  $("#" + addTemlpeteUl).append(newObj);
				  	  //调用加载设置项事件
				  	  //http://localhost:8080/web/busin/action/BusinTempletAction_config.do1?moduleType=CompanyInfoTempletModule&id=201408231923541256dd226ae7f2b44a2bc00d8f1d71ff361&templetId=11
				  	  base_baseshow_company_js_com.config(addTemlpeteUl,data);
					  //出发控件的双击事件				  	  
					  //$("#" + addTemlpeteUl + " li:last div").trigger("ondblclick");
				   }
			});
			
		},
		load:function(id){//加载事件
			var  selfhelpTempletId = getUrlParam("selfhelpTempletId");//当前模板id主键		
			var myurl ="/web/busin/action/BusinTempletAction_load.do1?moduleType=CompanyInfoTempletModule&id=" + id + "&selfhelpTempletId=" + selfhelpTempletId;
				$.ajax({
					  type: "POST",
					  url: myurl,
					  async: true,//如果是同步，就为true，否则为false 不同步
					  success: function(data){
						  //把配置界面放入公用设置区域
						  var html = data.showHtml;
						  var id = data.id;
						  $("#" + id).parent().html(html);//把最新页面加载进去
					  }
				});
		},
		config:function(addTemlpeteUl,moduleInfo){
			if(moduleInfo==null){ //找到不到传入的数据，直接从当前div标签中获取
				var myid = $(addTemlpeteUl).attr("id"); //取第一个参数 一般是this
				console.dir( $(addTemlpeteUl));
				var moduleData =  $(addTemlpeteUl).attr("module-data");	
				moduleInfo = $.parseJSON(moduleData);
			}
			
			var myurl = "/web/busin/action/BusinTempletAction_config.do1?" + 
						 "moduleType=" +  moduleInfo.moduleType + 
						 "&id=" + moduleInfo.id + 
						 "&selfhelpTempletId=" + moduleInfo.selfhelpTempletId;
			//http://localhost:8080/web/busin/action/BusinTempletAction_config.do1?moduleType=CompanyInfoTempletModule&id=201408231923541256dd226ae7f2b44a2bc00d8f1d71ff361&templetId=11
			$.ajax({
				  type: "POST",
				  url: myurl,
				  async: true,//如果是同步，就为true，否则为false 不同步
				  success: function(data){
					  //把配置界面放入公用设置区域
					  var html = data.configHtml;
					  $("#console").html(html);
					  //然后dialog出来，保存成功，取消，删除按钮都加上当前控件的方法  
					  //$("#console").dialog();
					  	$( "#console" ).dialog({
					        resizable: false,
					        modal: true,
					        buttons: {
					          save: function() {
					        	base_baseshow_company_js_com.save();
					          },cancel: function() {
					            $( this ).dialog( "close" );
					          },delte: function() {
					        	  base_baseshow_company_js_com.remove();
					          }
					          
					        }
					       });
					  
				  }
			});
		},
		save:function(){
			var id = $("#base_baseshow_html_config_id").val();
			var param1 =$("#base_baseshow_html_config_param1").val(); //公司名称
			var param2 =$("#base_baseshow_html_config_param2").val(); //公司内容
			var param3 =$("#base_baseshow_html_config_param3").val(); //公司电话
			
			var  selfhelpTempletId = getUrlParam("selfhelpTempletId");//当前模板id主键	
			
			var myurl = "http://localhost:8080/web/busin/action/BusinTempletAction_save.do1?moduleType=CompanyInfoTempletModule";
			myurl +="&id=" + id;
			myurl +="&param1=" + param1;
			myurl +="&param2=" + param2;
			myurl +="&param3=" + param3;
			myurl +="&selfhelpTempletId=" + selfhelpTempletId;
			
			$.ajax({
			  type: "POST",
			  url: myurl,
			  async: true,//如果是同步，就为true，否则为false 不同步
			  success: function(data){
				  
			  	  
			  	  if(data.re==true){//操作成功了 
			  		  $("#console").dialog("close");
			  	  }
			  	  //重新加载这个控件 
			  	base_baseshow_company_js_com.load(id);
			  	  
			  	  
			  	  
			   }
			});
			
			
		},remove:function(){
			var  selfhelpTempletId = getUrlParam("selfhelpTempletId");//当前模板id主键
			
			var id = $("#base_baseshow_html_config_id").val();
			var moduleData =  $("#" + id).attr("module-data");
			moduleInfo = $.parseJSON(moduleData);
			
			var myurl = "/web/busin/action/BusinTempletAction_remove.do1?" + 
			 "moduleType=" +  moduleInfo.moduleType +
			 "&selfhelpTempletId=" + selfhelpTempletId + 
			 "&id=" + moduleInfo.id
			 
			 $.ajax({
				  type: "POST",
				  url: myurl,
				  async: true,//如果是同步，就为true，否则为false 不同步
				  success: function(data){
				  	  
				  	  if(data.re==true){//操作成功了 
				  		  //删除界面元素
				  		$("#" + id).parent().remove();
				  		$("#console").dialog("close");
				  	  }
				   }
				});
			
			 
			
		}
		
}

