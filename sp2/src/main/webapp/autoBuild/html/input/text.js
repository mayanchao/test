		
globalFunction.autoBuild_html_input_text = {
	 build:function(htmlsrc){//构建html元素	 
		 var myHtml = "<input type='text'   />";
		 globalFunctionHtmlCommonBuild(myHtml,globalFunction.autoBuild_html_input_text);	 					
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
		},buildHtml:[
		             {attrName:"id",showtext:"id",defaultValue:20},
		             {attrName:"width",showtext:"宽度",defaultValue:20},
		             {attrName:"height",showtext:"高度",defaultValue:10},		             
		             {attrName:"css",showtext:"css",defaultValue:'',extendWidget:"css"},		             
		             {attrName:"value",showtext:"内容",defaultValue:"",extendWidget:"param1"},
		             {attrName:"maxlength",showtext:"最大长度",defaultValue:10,extendWidget:"param2"},
		             {attrName:"name",showtext:"名称",defaultValue:"",extendWidget:"param3"},
		             {attrName:"validate",showtext:"校验",defaultValue:"",extendWidget:"validate",openDiv:"openValidateDiv"  }
					],
		  currentName:"globalFunction.autoBuild_html_input_text"
};