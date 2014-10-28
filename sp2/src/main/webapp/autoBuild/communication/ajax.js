	

//"{myCallBackFunction:myCallBackSimpleSetValue( [\'id1\',\'id2\'] ) }
//

//ajax的方法名实际就是 id+globalCommonAjax
globalFunction.autoBuild_communication_ajax = {
		 build:function(myDate){//构建html元素	 
			 var myHtml = "<div >" +   
			 				(myDate!=null ?myDate.descript :"") 
			 				+ "的ajax方法</div>";
			 globalFunctionHtmlCommonBuild(myHtml,globalFunction.autoBuild_communication_ajax);	 					
			},
			reload:function(obj){
				 globalConsoleBuild(this.buildHtml,this.currentName,currentSelectObj);
				 //currentSelectObj.html(   currentSelectObj.attr("descript") + " 的ajax方法" + currentSelectObj.attr("id")   );
				 //ajax方法名:globalCommonAjaxbuildId_se111_14032749789661
				 $("#globalFunction_autoBuild_communication_ajax_tempMethod").val("globalCommonAjax" +  currentSelectObj.attr("id") );
			},
			active:function(obj){
				this.reload();
		 	},
		    refresh:function(obj){
			  globalConsoleRefresh(this.buildHtml,this.currentName,currentSelectObj);
			},
			buildMyHtml:function(obj){
				return globalAutoBuildMyHtml(this);
			
			},buildHtml:[
		    {attrName:"id",showtext:"id",defaultValue:20},		    
	        {attrName:"paramId1",showtext:"地址" ,defaultValue:"",extendWidget:"param1",note:"请求的地址"},
	        {attrName:"paramId2",showtext:"同步",defaultValue:"",extendWidget:"param2",note:"同步还是异步",select:[	
		                                                                                             	    {show:'异步',value:'asyn'},
		                                                                                             	    {show:'同步',value:'sync'}		
		                                                                                             		] },
	        //{attrName:"paramId3",showtext:"插入js",defaultValue:"",extendWidget:"param3",note:"请求前植入js操作"},	        
	        //{attrName:"paramId4",showtext:"主键集",defaultValue:"",extendWidget:"param4",note:"例如 ['id1','id2']  作废无用"},
	        //{attrName:"paramId5",showtext:"调用前方法名",defaultValue:"",extendWidget:"param5",    note:"例如myCallBeforeSimpleFindValue,myCallBeforeMyvalueVar"},
	        {attrName:"paramId5",showtext:"调用前方法名",defaultValue:"",extendWidget:"param5",select:[	
	                                                                                             	    {show:'无',value:'none'},
	                                                                                             	    {show:'参数转成BuildTableJson（myCallBeforeBuildTableJson）',value:'myCallBeforeBuildTableJson'},	                                                                                             	   
	                                                                                             		{show:'输入参数转值(myCallBeforeSimpleFindValue)',value:'autoBuild_html_ajax_beforeCall_myCallBeforeSimpleFindValue'},	                                                                                             		
	                                                                                             		],note:'调用前调用的函数名' },
	        {attrName:"paramId6",showtext:"调用前参数",defaultValue:"",extendWidget:"param6",openJsonId:'globalFunction_autoBuild_communication_ajax_paramId5',note:"双击设置调用前参数属性"},
	        {attrName:"paramId7",showtext:"调用后方法名",defaultValue:"",extendWidget:"param7",select:[
	                                                                                             {show:'无',value:'none'},
                                                                                          	     {show:'刷新',value:'autoBuild_html_ajax_afterCall_myCallBackRefreshCurrentPage'},
                                                                                          	     {show:'页面跳转',value:'myCallBackGotoPage'},
                                                                                          	     {show:'加载表格',value:'autoBuild_html_ajax_afterCall_globalToolsTableBuildByDate'}
                                                                                          	     ],note:"调用后方法"},
                                                                                          	     
	        {attrName:"paramId8",showtext:"调用后参数",defaultValue:"",extendWidget:"param8",openJsonId:'globalFunction_autoBuild_communication_ajax_paramId7',note:"双击设置调用后参数属性"},
	        {attrName:"paramId9",showtext:"验证码" ,defaultValue:"",extendWidget:"param9",note:"验证码的主键ID，不填就没有"},
	        {attrName:"descript",showtext:"描述",defaultValue:"",extendWidget:"descript"},
	        {attrName:"tempMethod",showtext:"生成的ajax方法",defaultValue:"",note:"注意不要修改这个值" },
		 ],
	 currentName:"globalFunction.autoBuild_communication_ajax"
};
//globalFunction_autoBuild_communication_ajax_tempMethod
