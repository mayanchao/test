		
globalFunction.autoBuild_html_input_radio = {
	 build:function(htmlsrc){//构建html元素
		 var myhtml = " <input type='radio' value=''    /> ";
		 globalFunctionHtmlCommonBuild(myhtml,globalFunction.autoBuild_html_input_radio);
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
      {attrName:"value",showtext:"保存值",defaultValue:"",extendWidget:"param1"},
      {attrName:"name",showtext:"名字",defaultValue:"",extendWidget:"param2"},
      {attrName:"param3",showtext:"是否选中",defaultValue:"",extendWidget:"param3" ,
    	  select:[
               {show:'选中',value:'check'},
        	     {show:'不选',value:'uncheck'}
        	     ] ,note:"当前单选框默认被选中" }
	],
	 currentName:"globalFunction.autoBuild_html_input_radio"
};