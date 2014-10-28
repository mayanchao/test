		
globalFunction.autoBuild_html_data_dataSimple = {
	build:function(){//构建html元素
		
		 var html = " <input  type='text'  onclick='$(this).datetimepicker()' > ";		 
		 globalFunctionHtmlCommonBuild(html,globalFunction.autoBuild_html_data_dataSimple);
		 
	},
	reload:function(){
		 globalConsoleBuild(this.buildHtml,this.currentName,currentSelectObj);
	},
	active:function(){
		this.reload();
	},
	refresh:function(obj){
	  globalConsoleRefresh(this.buildHtml,this.currentName,currentSelectObj);
    },
	 buildMyHtml:function(){		
		return globalAutoBuildMyHtml(this);
	 },buildHtml:[
        {attrName:"id",showtext:"id",note:"最终会生成globalDialog+id的执行方法"},
        {attrName:"param1",showtext:"param1",note:"名字属性"},
        {attrName:"css",showtext:"css",note:"css属性"}
	 ],
	 currentName:"globalFunction.autoBuild_html_data_dataSimple"
};