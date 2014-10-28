//富文本框控件
globalFunction.autoBuild_html_text_richText = {
	build:function(data){//构建html元素
		console.dir(data);
		var myWidth = '500'; 
		if(data!=null){//有默认值
			myWidth = data.width ;
		}
		alert(myWidth);
		 var html = "<div style='width:" + myWidth + "px'  >这里我可以写一些输入提示</p></div>";		 
		 globalFunctionHtmlCommonBuild(html,globalFunction.autoBuild_html_text_richText);
		 var ue = UE.getEditor(currentSelectObj.attr("id")
		 );
		 
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
        {attrName:"id",showtext:"id",note:""},
        {attrName:"param1",showtext:"param1",note:"名字属性"},
        {attrName:"width",showtext:"宽度",defaultValue:"500",note:"需要先保存后才会生效"},
        {attrName:"height",showtext:"高度",defaultValue:"500"}
	 ],
	 currentName:"globalFunction.autoBuild_html_text_richText"
};