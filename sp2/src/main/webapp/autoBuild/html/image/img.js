		
globalFunction.autoBuild_html_image_img = {
	build:function(){//构建html元素
		 var imgHtml = " <img   src='http://localhost:8080/image/gril/gril2.jpg'  />";
		 globalFunctionHtmlCommonBuild(imgHtml,globalFunction.autoBuild_html_image_img);
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
        {attrName:"id",showtext:"id",extendWidget:"id"},
        {attrName:"src",showtext:"图片路径",defaultValue:"",extendWidget:"param1"},
        {attrName:"width",showtext:"宽度",defaultValue:"100"},
        {attrName:"height",showtext:"高度",defaultValue:"100"},
	 ],
	 currentName:"globalFunction.autoBuild_html_image_img"
};