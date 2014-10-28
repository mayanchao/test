		
globalFunction.autoBuild_html_image_randomImg = {
	build:function(){//构建html元素	
		 var imgHtml = "<img   src='/web/busin/action/RandomImgAction_buildRandomImgCode.do1'  height='50'  />";
		
		// var imgHtml = "<label id='autoBuild_html_image_randomImg_showId' >验证码		 </label>  <input type='text' ///><img   src='/web/busin/action/RandomImgAction_buildRandomImgCode.do1'  height='50'  />";
		 
		 globalFunctionHtmlCommonBuild(imgHtml,globalFunction.autoBuild_html_image_randomImg);
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
        {attrName:"param1",showtext:"标题",extendWidget:"param1"}
        //{attrName:"id",showtext:"文本名字",extendWidget:"name"}
	 ],
	 currentName:"globalFunction.autoBuild_html_image_randomImg"
};