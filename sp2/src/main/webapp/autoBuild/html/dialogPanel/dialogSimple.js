		
globalFunction.autoBuild_html_dialogPanel_dialogSimple = {
	build:function(){//构建html元素
		 var imgHtml = " <div    >展现浮层</div>";
		 globalFunctionHtmlCommonBuild(imgHtml,globalFunction.autoBuild_html_dialogPanel_dialogSimple);
	},
	reload:function(){
		 globalConsoleBuild(this.buildHtml,this.currentName,currentSelectObj);
		 currentSelectObj.html("浮层方法名:globalDialog" +  currentSelectObj.attr("id")   );
	},
	active:function(){
		this.reload();
	},
	refresh:function(obj){
	  globalConsoleRefresh(this.buildHtml,this.currentName,currentSelectObj);
	  var myUrl = $('#globalFunction_autoBuild_html_dialogPanel_dialogSimple_srcHtml').val();
	  var mywidth = $('#globalFunction_autoBuild_html_dialogPanel_dialogSimple_width').val();
	  var myheight = $('#globalFunction_autoBuild_html_dialogPanel_dialogSimple_height').val();
	  var mytitle = $('#globalFunction_autoBuild_html_dialogPanel_dialogSimple_title').val();
	  var tmpDiv = $("<div> </div>");
	  $(document.body).append(tmpDiv);
	  		  tmpDiv.load(myUrl,{async:false},function(data){		  
			  tmpDiv.dialog({ modal: true,width:mywidth,height:myheight,title:mytitle} );
	  }
   	  );
	  
    },
	 buildMyHtml:function(){
		return globalAutoBuildMyHtml(this);
	 },buildHtml:[
        {attrName:"id",showtext:"id",note:"最终会生成globalDialog+id的执行方法"},
        {attrName:"srcHtml",showtext:"内容界面",defaultValue:"",extendWidget:"param1"},
        {attrName:"title",showtext:"标题",defaultValue:"",extendWidget:"param2"},
        {attrName:"paramId3",showtext:"加载页面前",defaultValue:"",extendWidget:"param3"},
        {attrName:"paramId4",showtext:"加载页面前",defaultValue:"",extendWidget:"param4"},
        {attrName:"paramId5",showtext:"加载页面后",defaultValue:"",extendWidget:"param5",select:[	
                                                                                     	    {show:'无',value:'none'},                                                                                     	    	                                                                                             	   
                                                                                     		{show:'赋值给控件(myCallBackSimpleSetValue)',value:'autoBuild_html_ajax_afterCall_myCallBackSimpleSetValue'},	                                                                                             		
                                                                                     		],note:'页面加载后调用函数名' },
	    {attrName:"paramId6",showtext:"调用前参数",defaultValue:"",extendWidget:"param6",openJsonId:'globalFunction_autoBuild_html_dialogPanel_dialogSimple_paramId5',note:"双击设置属性"},	
        {attrName:"width",showtext:"宽度",defaultValue:500},
        {attrName:"height",showtext:"高度",defaultValue:400},	
	 ],
	 currentName:"globalFunction.autoBuild_html_dialogPanel_dialogSimple"
};