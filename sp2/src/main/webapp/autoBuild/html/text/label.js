globalFunction.autoBuild_html_text_label = {
	 build:function(myObj){//构建html元素	
		 var myText = "文本1";
		 //如果是从数据库中直接获取到的值，就直接取出内容，加载到这个控件上
		 if(myObj!=null && myObj.param1!=null){
			 myText = myObj.param1;
		 }
		//初始化	属性面板
		 var myhtml = "<label >" + myText + "</label>";		 
		 globalFunctionHtmlCommonBuild(myhtml,globalFunction.autoBuild_html_text_label);
		 
    },
	reload:function(){
		 globalConsoleBuild(this.buildHtml,this.currentName,currentSelectObj);
		 //buildId_mod2_14036658789342
		 var myVa = $("#globalFunction_autoBuild_html_text_label_html").val();
		 var myId =  currentSelectObj.attr("id");
		 currentSelectObj.html(myVa);
    },
    active:function(obj){
  		this.reload();
    },
	refresh:function(obj){
		globalConsoleRefresh(this.buildHtml,this.currentName,currentSelectObj);
		//设置文字内容，实际就是修改innerHTML的内容 
		var myVa = $("#globalFunction_autoBuild_html_text_label_html").val();
		currentSelectObj.html(myVa);
    },
    buildMyHtml:function(obj){
    	return globalAutoBuildMyHtml(this);
	},buildHtml:[
	             {attrName:"id",showtext:"id"},
	             {attrName:"myhtml",showtext:"文本内容",defaultValue:"文本1",extendWidget:"param1"},
	             {attrName:"width",showtext:"宽度",defaultValue:"100"},
	             {attrName:"height",showtext:"高度",defaultValue:"100"}
	],
	  currentName:"globalFunction.autoBuild_html_text_label"
};