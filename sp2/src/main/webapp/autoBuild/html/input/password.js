		
globalFunction.autoBuild_html_input_password = {
	 build:function(htmlsrc){//构建html元素
		 var myHtml = "<input type='password'   />";
		 globalFunctionHtmlCommonBuild(myHtml,globalFunction.autoBuild_html_input_password);
	},
	reload:function(){
		globalConsoleBuild(this.buildHtml,this.currentName,currentSelectObj);
	  },
	  active:function(obj){
		  this.reload();
	  },
	  refresh:function(obj){
		  globalConsoleRefresh(this.buildHtml,this.currentName,currentSelectObj);
	  },
	  buildMyHtml:function(obj){
		  return globalAutoBuildMyHtml(this);
	  },
	  buildHtml:[
				{attrName:"id",showtext:"id",defaultValue:20},
				{attrName:"width",showtext:"宽度",defaultValue:20},
				{attrName:"height",showtext:"高度",defaultValue:10},
				{attrName:"value",showtext:"内容",defaultValue:"",extendWidget:"param1"},
				{attrName:"maxlength",showtext:"最大长度",defaultValue:10,extendWidget:"param2"},
				{attrName:"name",showtext:"名称",defaultValue:"",extendWidget:"param3"}
				],
	  currentName:"globalFunction.autoBuild_html_input_password"
};


































