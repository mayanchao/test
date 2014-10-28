//获取cookie的值，有的话就显示，否则就显示默认内容
globalFunction.autoBuild_html_other_cookieShow = {
	build:function(){//构建html元素
		 var html = " <label   >show</label> ";		 
		 globalFunctionHtmlCommonBuild(html,globalFunction.autoBuild_html_other_cookieShow);
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
        {attrName:"param1",showtext:"cookie名字",note:"存在cookie中的名字"},        
        {attrName:"param2",showtext:"没值显示",note:"取不到时候显示内容"}
	 ],
	 currentName:"globalFunction.autoBuild_html_other_cookieShow"
};