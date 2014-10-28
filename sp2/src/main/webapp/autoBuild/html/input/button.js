		
globalFunction.autoBuild_html_input_button = {
	 build:function(htmlsrc){//构建html元素
		 var myhtml = " <input type='button' value='按钮'  /> ";
		 globalFunctionHtmlCommonBuild(myhtml,globalFunction.autoBuild_html_input_button);
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
      {attrName:"height",showtext:"高度",defaultValue:20},
      {attrName:"value",showtext:"按钮文字",defaultValue:"按钮",extendWidget:"param1"},
      {attrName:"myMethodName",showtext:"方法名称",defaultValue:"null"    ,extendWidget:"param2"},
      {attrName:"myMethodParam1",showtext:"方法属性1",defaultValue:"null" ,extendWidget:"param3"},
      {attrName:"myMethodParam2",showtext:"方法属性2",defaultValue:"null" ,extendWidget:"param4"},
      {attrName:"myMethodParam3",showtext:"方法属性3",defaultValue:"null" ,extendWidget:"param5"},
      {attrName:"myMethodParam4",showtext:"方法属性4",defaultValue:"null" ,extendWidget:"param6"}
	],
	  currentName:"globalFunction.autoBuild_html_input_button"
};