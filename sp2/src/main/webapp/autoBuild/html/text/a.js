globalFunction.autoBuild_html_text_a = {
		
	 build:function(htmlsrc){//构建html元素	
		//初始化	属性面板
		 var myhtml = "<a >链接文字</a>";
		 globalFunctionHtmlCommonBuild(myhtml,globalFunction.autoBuild_html_text_a);
    },
	reload:function(){
		 globalConsoleBuild(this.buildHtml,this.currentName,currentSelectObj);
		 var myVa = $("#autoBuild_html_text_a_html").val();
		 currentSelectObj.html(myVa);
    },
    active:function(obj){
  		this.reload();
    },
	refresh:function(obj){
		globalConsoleRefresh(this.buildHtml,this.currentName,currentSelectObj);
		//设置文字内容，实际就是修改innerHTML的内容 
		var myVa = $("#autoBuild_html_text_a_html").val();
		currentSelectObj.html(myVa);
    },
    buildMyHtml:function(obj){
    	return globalAutoBuildMyHtml(this);
	},buildHtml:[
	             {attrName:"id",showtext:"id"},
	             {attrName:"html",showtext:"文本内容",defaultValue:"链接文字",extendWidget:"param1"},
	             {attrName:"href",showtext:"连接地址",defaultValue:"www.baidu.com",extendWidget:"param2"},
	             {attrName:"width",showtext:"宽度",defaultValue:"100"},
	             {attrName:"height",showtext:"高度",defaultValue:"100"}
	],
	  currentName:"globalFunction.autoBuild_html_text_a"
};