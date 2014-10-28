
package com.mana.base.web.back.action;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.mana.autoBuild.autoWidget.html.validate.BuildValidateHtml;
import com.mana.autoBuild.autoWidget.html.validate.vo.ValidateShowHtmlVO;
import com.mana.autoBuild.daoVO.BaseAutoBuildVO;
import com.mana.autoBuild.tableVO.AutoBuildHtmlVO;
import com.mana.autoBuild.tableVO.AutoBuildWidgetVO;
import com.mana.autoBuild.tableVO.AutoOperateSetpVO;
import com.mana.autoBuild.tableVO.CompoundSqlShowVO;
import com.mana.autoBuild.tableVO.CompoundSqlTableVO;
import com.mana.autoBuild.tableVO.CompoundSqlVO;
import com.mana.autoBuild.tableVO.CompoundSqlWhereVO;
import com.mana.base.tools.io.ToolsFile;
import com.mana.base.tools.sql.DateBaseOperateUtil;
import com.mana.base.tools.string.StringUtil;
import com.mana.base.tools.tree.TreeUtil;
import com.mana.base.tools.tree.vo.TreeVO;
import com.mana.base.tools.workflow.WorkFlowUtil;
import com.mana.base.web.BaseActionClass;

/**-
 * 单表操作 
 * @author hc360
 *
 */
public class BackSAutoetpOperateAction  extends BaseActionClass{
	
	

	
	//根据工作流 处理
   //http://localhost:8080/web/back/action/BackSAutoetpOperateAction_executeWorkflow.do1?autoSetpId=setpVote&tableJson={"name":"abc","password":"123456"}
	//例子2 复合sql http://localhost:8080/web/back/action/BackSAutoetpOperateAction_executeWorkflow.do1?autoSetpId=setpVote&id=id111
	
	public ModelAndView executeWorkflow(HttpServletRequest request,HttpServletResponse response){
		//获取工作流 
		String autoSetpId = request.getParameter("autoSetpId");
		Map map =  WorkFlowUtil.executeWorkflowById(request, response,autoSetpId);
//		System.out.println(root);
		return null;
	}
	
	
	/**
	 * 根据htmlID 查找控件数据库，生成界面 
	 * @param request
	 * @param response
	 * @return
	 */
	//http://localhost:8080/web/back/action/BackSAutoetpOperateAction_buildAutoWidgetPage.do1?htmlId=page333
	public ModelAndView buildAutoWidgetPage(HttpServletRequest request,HttpServletResponse response){
		
		//获取页面信息从页面信息表 auto_build_widget
		AutoBuildHtmlVO autoBuildHtmlVO = new AutoBuildHtmlVO();
		autoBuildHtmlVO.setHtmlId(request.getParameter("htmlId"));	
		
		AutoBuildHtmlVO reHtmlVO = (AutoBuildHtmlVO) DateBaseOperateUtil.jdbcSelectSingleOperate(autoBuildHtmlVO);
		if(reHtmlVO==null){//自动生成有htmlid的属性
			reHtmlVO = new AutoBuildHtmlVO();
			reHtmlVO.setHtmlId(request.getParameter("htmlId"));
			DateBaseOperateUtil.inserByAutoBuildVO(reHtmlVO);
		}
		
		
		AutoBuildWidgetVO autoBuildWidget = new AutoBuildWidgetVO();
		autoBuildWidget.setHtmlId(request.getParameter("htmlId"));
		StringBuilder headHtml = new StringBuilder("" );//头部内容
		StringBuilder buildHtml = new StringBuilder("" );//页面内容
		StringBuilder endHtml = new StringBuilder("" );//尾部内容
		
		//这个页面是否是普通的div页面 
		System.out.println("di11v=======1====" + reHtmlVO.getOnlyDiv());
		if(  reHtmlVO.getOnlyDiv()== null || "0".equals(reHtmlVO.getOnlyDiv())   ){
			headHtml.append("<html><head>\n" +
					
//				"<script src=/js/common.js  >  </script>" +
//				"<script src=/js/jquery-1.10.1.js  >  </script> " +
//				"<script src=/js/jquery-ui-1.10.2.custom.js  >  </script> " +
//				"<script src=/js/jquery.json-2.4.js >  </script> " +								
//				"<link rel='stylesheet' href='/css/ui-lightness/jquery-ui-1.10.2.custom.css' />" +
//				"<link href='/css/style.css' rel='stylesheet' type='text/css' />" +
//				"<link href='/css/css.css' rel='stylesheet' type='text/css' />" +
				"<link rel='stylesheet' href='http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.css'>\n" +		
				"<link rel='stylesheet' href='http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap-theme.css'>\n" +
				"<link rel='stylesheet' href='http://v3.bootcss.com/examples/dashboard/dashboard.css'>\n" +
				"<script src='http://cdn.bootcss.com/jquery/1.11.1/jquery.js'></script>\n" +
				"<script src='http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.js'></script>\n" +
				"<script src=/js/common.js  >  </script>\n" 
				); 
		}
		headHtml.append("<meta http-equiv=Content-Type content=text/html; charset=UTF-8 />");//强行设置页面编码方式
		headHtml.append("</head>\n");//强行设置页面编码方式
		buildHtml.append("<body>\n");//强行设置页面编码方式
		
		List<BaseAutoBuildVO>  list = DateBaseOperateUtil.jdbcSelectMultitermOperate(autoBuildWidget);
		for(BaseAutoBuildVO vo:list){
			AutoBuildWidgetVO autobuildWidget = (AutoBuildWidgetVO)vo;
			String type = autobuildWidget.getType();
			if("globalFunction.autoBuild_html_image_img".equals(type)){
				buildHtml.append("<img   " +
						 " style='position:absolute;top:"
						 + autobuildWidget.getPositionTop()  
						 + "px;left:"
						 + autobuildWidget.getPositionLeft() 
						 + "px;'"	
						 + " id=" +  autobuildWidget.getId());
				buildHtml.append(  " src=" + autobuildWidget.getParam1());
				buildHtml.append( " width=" + autobuildWidget.getWidth());
				buildHtml.append( " height=" + autobuildWidget.getHeight());
				buildHtml.append( "  />\n");
			}else if("globalFunction.autoBuild_html_text_label".equals(type)){
				buildHtml.append("<label   " +
						 " style='position:absolute;top:"
						 + autobuildWidget.getPositionTop()  
						 + "px;left:"
						 + autobuildWidget.getPositionLeft() 
						 + "px;'"	
						 + " id=" +  autobuildWidget.getId());
						buildHtml.append( " width=" + autobuildWidget.getWidth());
						buildHtml.append( " height=" + autobuildWidget.getHeight());
						buildHtml.append( "  >\n");
						buildHtml.append( autobuildWidget.getParam1() );
						
						buildHtml.append( " </label>\n");
						
			}else if("globalFunction.autoBuild_html_text_a".equals(type)){
			
						buildHtml.append("<a   " +
						 " style='position:absolute;top:"
						 + autobuildWidget.getPositionTop()  
						 + "px;left:"
						 + autobuildWidget.getPositionLeft() 
						 + "px;'"	
						 + " id=" +  autobuildWidget.getId());
						buildHtml.append( " width=" + autobuildWidget.getWidth());
						buildHtml.append( " height=" + autobuildWidget.getHeight());
						buildHtml.append( " href=" + autobuildWidget.getParam2()   );	//超链接的地址					
						buildHtml.append( "     >  ");
						buildHtml.append(  autobuildWidget.getParam1()   );  //超链接的文字
						buildHtml.append( "   </a>  ");
						
			
			}else if("globalFunction.autoBuild_html_input_text".equals(type)){
				
				String validateHeadStr ="";  //校验区域
				String validateScript ="";  //校验区域
				//校验区域
				if(autobuildWidget.getValidate() !=null && autobuildWidget.getValidate().length()>0){					
					//JSON.parseObject(jsonText,Map.class);					
					//String jsonText = "[{a:1,b:2},{a:3,b:4}]";					
					String jsonText = autobuildWidget.getValidate();
				//	jsonText = "[{\"name\":\"v1\",\"type\":\"autoBuild_html_validate_textLength\",\"handleType\":\"onFouce\",\"maxLength\":\"4\",\"minLength\":\"1\",\"errorText\":\"errerrInfo\",\"errorType\":\"alert\"}]";
					Map<String,ValidateShowHtmlVO> map = BuildValidateHtml.validateBuildTextLength( autobuildWidget.getId() ,jsonText);
					validateHeadStr =  BuildValidateHtml.htmlHead(map);
					validateScript =  BuildValidateHtml.htmlScript(map);
				}
				
				buildHtml.append("<input type='text'   " +
						validateHeadStr + //校验区域
						 " css='"+ autobuildWidget.getCss() + "'" + 
						 " style='position:absolute;top:"
						 + autobuildWidget.getPositionTop()  
						 + "px;left:"
						 + autobuildWidget.getPositionLeft() 
						 + "px;'"	
						 + " id=" +  autobuildWidget.getId());
						buildHtml.append( " width=" + autobuildWidget.getWidth());
						buildHtml.append( " height=" + autobuildWidget.getHeight());
						buildHtml.append( " maxlength=" + autobuildWidget.getParam2());
						buildHtml.append( " name=" + autobuildWidget.getParam3());
						buildHtml.append( "  value='"+ autobuildWidget.getParam1() + "' />\n");
						
						buildHtml.append(validateScript);//校验脚本的js
							
						
			}else if("globalFunction.autoBuild_html_input_password".equals(type)){
				buildHtml.append("<input type='password'   " +
						 " style='position:absolute;top:"
						 + autobuildWidget.getPositionTop()  
						 + "px;left:"
						 + autobuildWidget.getPositionLeft() 
						 + "px;'"	
						 + " id=" +  autobuildWidget.getId());
						buildHtml.append( " width=" + autobuildWidget.getWidth());
						buildHtml.append( " height=" + autobuildWidget.getHeight());
						buildHtml.append( " maxlength=" + autobuildWidget.getParam2());
						buildHtml.append( " name=" + autobuildWidget.getParam3());
						buildHtml.append( "  value='"+ autobuildWidget.getParam1() + "' />\n");
						
			}else if("globalFunction.autoBuild_html_input_button".equals(type)){
				buildHtml.append("<input type='button'   " +
						 " style='position:absolute;top:"
						 + autobuildWidget.getPositionTop()  
						 + "px;left:"
						 + autobuildWidget.getPositionLeft() 
						 + "px;'"	
						 + " id=" +  autobuildWidget.getId());
						buildHtml.append( " width=" + autobuildWidget.getWidth());
						buildHtml.append( " height=" + autobuildWidget.getHeight() +" ");
						buildHtml.append( " onclick=" + autobuildWidget.getParam2() + "('"  
													   +  autobuildWidget.getParam3()  + "','"
													   +  autobuildWidget.getParam4() +  "','"
													   +  autobuildWidget.getParam5() +  "','"
													   +  autobuildWidget.getParam6() +  "')"
						);
						
						buildHtml.append( "  value='"+ autobuildWidget.getParam1() + "' />\n");
			}else if("globalFunction.autoBuild_html_input_radio".equals(type)){
				buildHtml.append("<input type='radio'   " +
						 " style='position:absolute;top:"
						 + autobuildWidget.getPositionTop()  
						 + "px;left:"
						 + autobuildWidget.getPositionLeft() 
						 + "px;'"	
						 + " id=" +  autobuildWidget.getId());
						buildHtml.append( " width=" + autobuildWidget.getWidth());
						buildHtml.append( " height=" + autobuildWidget.getHeight() +" ");
						buildHtml.append( " name=" + autobuildWidget.getParam2() +" ");
						if("check".equals(autobuildWidget.getParam3() )){
							buildHtml.append( " checked ");
						}
						
						
						buildHtml.append( "  value='"+ autobuildWidget.getParam1() + "' />\n");
			}else if("globalFunction.autoBuild_html_input_select".equals(type)){
				buildHtml.append("<select    " +
						 " style='position:absolute;top:"
						 + autobuildWidget.getPositionTop()  
						 + "px;left:"
						 + autobuildWidget.getPositionLeft() 
						 + "px;'"	
						 + " id=" +  autobuildWidget.getId());
						buildHtml.append( " width=" + autobuildWidget.getWidth());
						buildHtml.append( " height=" + autobuildWidget.getHeight() +" ");
						buildHtml.append( " name=" + autobuildWidget.getParam2() + " >\n");
							//循环生成option							
							JSONArray array = JSON.parseArray(autobuildWidget.getParam1());
							for(int i=0;i<array.size();i++){							
								String columnStr = ""+ array.get(i);
								Map map = JSON.parseObject(columnStr, Map.class);								
								buildHtml.append( "<option  value='" + map.get("value") + "'> \n");
								buildHtml.append( map.get("name"));
								buildHtml.append( "</option> \n");
							}

						buildHtml.append("</select>\n");
						 
			}else if("globalFunction.autoBuild_communication_ajax".equals(type)){
				//判断属性 生成参数 
				buildHtml.append( "<div><script >\n");
				//根据参数生成ajax脚本     globalCommonAjaxbuildId_autoSpotModify_13823707113147
				String methodName="function  globalCommonAjax" + autobuildWidget.getId() ;//这个ajax方法的名字
				buildHtml.append( methodName + "(myValue){\n"); 
//						+ "var ids=" );
//				
//				sb.append("[ "); //第一个参数是要获取值的id集合				
//				if(autobuildWidget.getParam4()!=null && autobuildWidget.getParam4().length()>0  ){					
//					sb.append("'"  + autobuildWidget.getParam4()  + "'"); //数值是['id1','id2','id3']					
//				}				
//				//去掉最尾部的逗号
//				sb.append("];\n");
				
				buildHtml.append( "var ajaxConfig = {myUrl:\"" + autobuildWidget.getParam1()  + "\",inputValue:myValue  }\n"); //生成当前ajax的配置对象信息	
				//判断是否有	验证码方法 
				//ajaxConfig.myUrl +="&imgRandomCode99813=" + $("#buildId_abc2_14073385489393").val() ;
				buildHtml.append( "  ajaxConfig.myUrl +=\"&imgRandomCode99813=\" + $('#" + autobuildWidget.getParam9() + "').val()  \n"); //生成当前ajax的配置对象信息
				buildHtml.append("ajaxConfig.myUrl=globalToolsTableValueReplace(ajaxConfig.myUrl,ajaxConfig,ajaxConfig.inputValue); \n");//拼装调用参数是url地址
				//有ajax调用前方法
				if(autobuildWidget.getParam5() !=null &&  !"none".equals(autobuildWidget.getParam5()) ){
					String[] myMethodName = autobuildWidget.getParam5().split("_");
					String methodParam = "{}";
					if(autobuildWidget.getParam6() !=null  && autobuildWidget.getParam6().length()>0 ){
						methodParam =autobuildWidget.getParam6(); 
					}
					//第一个参数是用户界面配置的参数
					//第二个参数是当前ajax的设置参数
					// 第三个参数是当前处理的数据列
					buildHtml.append("myValue=" + myMethodName[myMethodName.length-1]  + "(" + methodParam   + ",ajaxConfig,myValue)\n"); //插入语句
				}
				
				//拼装调用ajax方法
				buildHtml.append( "globalToolsAjaxSubmit(ajaxConfig.myUrl,");
				
				
				//执行ajax方法 
				String ajaxBeforeMethod = "" + autobuildWidget.getParam5()  ;				
				String beforeParam  ="";
				beforeParam =  StringUtil.fromDoubleTosingle( autobuildWidget.getParam6());
				//是否是同步方法
				String sync = autobuildWidget.getParam2(); 
//				if( "myCallBeforeSimpleFindValue".equals(ajaxBeforeMethod)){
//					//转换数值位置JSON数组类型 
//					beforeParam = "("  + StringUtil.analyzeStringJsonJsArray( autobuildWidget.getParam6()) + ")" ;
//				}else {
//					beforeParam = autobuildWidget.getParam6();
//				}
				
				/**
				 * 往initUserList插入,不再重复插入  
				 */ 
				buildHtml.append("{paramBuildJs:\""   );							
				buildHtml.append(ajaxBeforeMethod + beforeParam);
				buildHtml.append("\",");
				//执行方法后的方法
				String[] myMethodName = autobuildWidget.getParam7().split("_");				
				String ajaxAfterMethod =  myMethodName[myMethodName.length-1] ;				
				String afterParam =autobuildWidget.getParam8();
				
				if("myCallBackSimpleSetValue".equals(ajaxAfterMethod) && !"none".equals(autobuildWidget.getParam8()) ){//有ajax调用前方法
					String methodParam = "{}";
					if(autobuildWidget.getParam8() !=null  && autobuildWidget.getParam8().length()>0 ){
						methodParam =autobuildWidget.getParam8(); 
					}
					afterParam 	=  StringUtil.analyzeStringJsonJsArray(  methodParam)  ;
				}
				else if("globalToolsTableBuildByDate".equals(ajaxAfterMethod) ){//是表格加载方法
					afterParam=StringUtil.fromDoubleTosingle(  afterParam) ;//表格ID当参数时候，必须是字符串
				}
				buildHtml.append("myCallBackFunction:\""   );
				buildHtml.append(  ajaxAfterMethod+ "(data," + afterParam  +  ")\"");
				//执行方法后的方法
				buildHtml.append("},myValue");
				buildHtml.append(",'" + sync + "'");
				//是否是同步方法
				buildHtml.append(");\n");
				
				buildHtml.append("}\n");
				buildHtml.append( "</script ></div>\n");
				
			}else if("globalFunction.autoBuild_html_dialogPanel_dialogSimple".equals(type)){
				String myWidth=autobuildWidget.getWidth();
				String myHeight=autobuildWidget.getHeight();
				String myTitle = autobuildWidget.getParam2();
				String myUrl = autobuildWidget.getParam1();
				
				//生成dialog脚本 
				String methodName="function globalDialog" + autobuildWidget.getId() ;//这个ajax方法的名字
				StringBuffer sb  = new StringBuffer(methodName);		
				sb.append("(myValue){\n");
				if(autobuildWidget.getParam3()!=null  &&  autobuildWidget.getParam3().length()>0 ){
					sb.append("\n eval(''+ " + autobuildWidget.getParam3() + ")\n"); //插入前语句
				}	
				sb.append("  var tmpDiv = $('<div> </div>');\n");
				//把相关值，填充到url中 
				sb.append("  var urlPath = globalToolsTableValueReplace(\"" + myUrl + "\",{},myValue); \n");
				sb.append("  tmpDiv.load(urlPath,{async:false},function(data){\n");	
				sb.append("   tmpDiv.dialog({ modal: true,width:" + myWidth + ",height:" + myHeight+ ",title:'" + myTitle + "'  " +
						",close: function( event, ui ) {alert('close');     tmpDiv.remove()    }" +
						
						"" +
						"} );\n");
				
				//判断是否有载入后处理方法  一定要在dialog显示出来设置，否则会找不到控件
				if(autobuildWidget.getParam5()!=null &&  autobuildWidget.getParam5().length()>0 ){
					String[] myMethodName = autobuildWidget.getParam5().split("_");					
					//是往回赋值的方法
					if("autoBuild_html_ajax_afterCall_myCallBackSimpleSetValue".equals(autobuildWidget.getParam5())){
						StringBuffer methodParam = new StringBuffer("");
						Map  mapValues = JSON.parseObject(autobuildWidget.getParam6(),Map.class);
						String idValue =""+ mapValues.get("ids");
						String[] ids = idValue.split(",");
						methodParam.append("[");//id数组的开始1
						for(int i=0;i<ids.length;i++){
							methodParam.append("'" + ids[i] + "'," );							
						}
						methodParam.delete(methodParam.length()-1, methodParam.length());
						methodParam.append("]");//id数组的结束
						sb.append( "\n  " + myMethodName[myMethodName.length-1]  + "(" + methodParam.toString()   + ",myValue)\n"); //插入语句
					}
				}
				
				
				sb.append("})\n");
				sb.append("}\n");
				
				buildHtml.append( "<script >\n");
				buildHtml.append(sb.toString());				
				buildHtml.append( "</script ></div>\n");
			}else if("globalFunction.autoBuild_html_data_dataSimple".equals(type)){//日期控件
	
				headHtml.append("<link rel='stylesheet' href='/css/jquery.datetimepicker.css'>");
				headHtml.append("<script src='/js/jquery.datetimepicker.js'></script>");
//				<link rel='stylesheet' href='/css/jquery.datetimepicker.css'>
//				<script src='/js/jquery.datetimepicker.js'></script>
				
				buildHtml.append("<input   " +
						 " style='position:absolute;top:"
						 + autobuildWidget.getPositionTop()  
						 + "px;left:"
						 + autobuildWidget.getPositionLeft() 
						 + "px;'"	
						 + "type='text'"
						 + " onclick='$(this).datetimepicker()' "
						 + " name='" + autobuildWidget.getParam1() + "' "
						 + " id=" +  autobuildWidget.getId());
					
						buildHtml.append( " width=" + autobuildWidget.getWidth());
						buildHtml.append( " height=" + autobuildWidget.getHeight());
						buildHtml.append( "  />\n");
						
			}else if("globalFunction.autoBuild_html_menu_simpleMenu".equals(type)){//菜单
				String re = buildLeftTree(autobuildWidget);
				buildHtml.append(re);
			}else if("globalFunction.autoBuild_html_table_sampleTable".equals(type)){
				//web/singleTable/action/SingleTableAction_findTable.do1?singleTableName=UserVoteVO&tableJson={'status':'1'}
				//select * from Auto_Build_WidgetVO;
				Random rd = new Random();
				String myRandmId =""+ rd.nextInt(1000);
				buildHtml.append("<div" +
						" style='position:absolute;top:"
						 + autobuildWidget.getPositionTop()  
						 + "px;left:"
						 + autobuildWidget.getPositionLeft() 
						 + "px;'" +	
						">" +
						"\n<table  border=1 " 	
						 + " id=" +  autobuildWidget.getId());				
						buildHtml.append( " width=" + autobuildWidget.getWidth());
						buildHtml.append( " height=" + autobuildWidget.getHeight() +" ");
						System.out.println("sql" + autobuildWidget.getParam3());
						//判断是否有分页信息 
						if(autobuildWidget.getParam3()!=null   &&  autobuildWidget.getParam3().length()>0){
							int limit1316 = Integer.parseInt( autobuildWidget.getParam3() );
							buildHtml.append( " pageLimit1316=" + limit1316 ); //每页多少条
							buildHtml.append( " pageOffset1316=0" );//当前第一页
						}
						buildHtml.append( " >\n");
						buildHtml.append( "<tr> \n");
						//开始解析td 标题 的内容 
						JSONArray array = JSON.parseArray(autobuildWidget.getParam1());
						for(int i=0;i<array.size();i++){							
							String columnStr = ""+ array.get(i);
							Map map = JSON.parseObject(columnStr, Map.class);
							buildHtml.append( "<td width=  "  + map.get("columnWidth") + "> \n");
							buildHtml.append( map.get("columnName"));
							buildHtml.append( "</td> \n");
						}
						buildHtml.append( "</tr> \n");						
						buildHtml.append( "</table>\n");
						String loadUrl = autobuildWidget.getParam2();
						//判断是否有分页信息 
						if(autobuildWidget.getParam3()!=null){
							buildHtml.append( "<table><tr>" +
							"<td><a href=javascript:" +  tablePageBuild("myUrl" + myRandmId,autobuildWidget,-1) +  " > 上一页</a></td>" +
							"<td><a href=javascript:" +  tablePageBuild("myUrl" + myRandmId,autobuildWidget,1) +   " > 下 一页</a></td>" +  
							"</tr>\n");
							buildHtml.append( "</table>\n");
						}
						//增加js脚本 
						buildHtml.append( "<script >\n");
						//生成地址信息 地址信息是个变量，方便后面操作改变这个url参数
						buildHtml.append( " var myUrl" +myRandmId + "=\"" +loadUrl + "\";\n" );
						buildHtml.append(tablePageBuild("myUrl" + myRandmId,autobuildWidget,0));
						//把表格的配置信息，生成公用变量
						String myInfo = "var tableConfig" + autobuildWidget.getId() + "=" + autobuildWidget.getParam1() +"\n" ; 
						buildHtml.append(myInfo);
						
						buildHtml.append( "\n</script ></div>\n");
			
						
						
			}else if("globalFunction.autoBuild_html_text_richText".equals(type)){//富文本
				String str = "<script " +
							 " id='" + autobuildWidget.getId() + "'"							 
							 + " style='position:absolute;top:"	 + autobuildWidget.getPositionTop() + "px;"
							 + "width:"	 + autobuildWidget.getWidth() + "px;'" 
							 + "height:"	 + autobuildWidget.getHeight() + "px;'" 
							 + "left:"	 + autobuildWidget.getPositionLeft()	 + "px;'" +							 
							 "  ><p>这里我可以写一些输入提示</p></script>";
				
				buildHtml.append(str);
				buildHtml.append("<script>   UE.getEditor('" + autobuildWidget.getId()  + "'); </script>");
				//加入需要的js
				headHtml.append("<script type='text/javascript' charset='utf-8' src='/ueditor1_4_3-src/ueditor.config.js'></script>");
				headHtml.append("<script type='text/javascript' charset='utf-8' src='/ueditor1_4_3-src/_examples/editor_api.js'></script>");
				
			}else if("globalFunction.autoBuild_html_text_a".equals(type)){
				
				
			}else if("globalFunction.autoBuild_html_other_cookieShow".equals(type)){//cookie的显示
				
				buildHtml.append("<label   " +
						 " style='position:absolute;top:"
						 + autobuildWidget.getPositionTop()  
						 + "px;left:"
						 + autobuildWidget.getPositionLeft() 
						 + "px;'"	
						 + " id=" +  autobuildWidget.getId());
						buildHtml.append( " width=" + autobuildWidget.getWidth());
						buildHtml.append( " height=" + autobuildWidget.getHeight());
						buildHtml.append( "  >\n");
						buildHtml.append( " </label>\n");
						
				buildHtml.append("<script>");				
				buildHtml.append("  var mycookie = getcookie('" + autobuildWidget.getParam1() + "'); ");
				buildHtml.append("  if(mycookie == \"\" ){	mycookie = '" + autobuildWidget.getParam2() + "';} ");
				buildHtml.append(" $('#" + autobuildWidget.getId() + "').text(mycookie )");
				
				buildHtml.append("</script>");
				
				
			}else if("globalBuild.static_html_context".equals(type)){//静态页面构造
				//读取页面地址   
				String text = autobuildWidget.getParamBig1();
//				String path = autobuildWidget.getParam1();
				buildHtml = new StringBuilder(text);
			}else if("globalFunction.autoBuild_html_menu_topMenu".equals(type)){//顶部菜单
				String str = this.buildTopMenu(autobuildWidget);
				buildHtml.append(str);
			}else if("globalFunction.autoBuild_html_image_randomImg".equals(type)){//验证码
				
					
	//				   <label>输入验证码</label>
//			        <input type="text" name="randomCode"/>
//					<img    title="点击更换" onclick="javascript:refresh(this);" src="/web/busin/action/RandomImgAction_buildRandomImgCode.do1?projectId=ccc">
//					<br/>
				
				buildHtml.append("<label type='button'   " +
						 " style='position:absolute;top:"
						 + autobuildWidget.getPositionTop()  
						 + "px;left:"
						 + autobuildWidget.getPositionLeft() 
						 + "px;' >" + autobuildWidget.getParam1() + "</label>"
						 + "<input type='text' name=imageRandomId442911  id='" + autobuildWidget.getId() + "' />"  	
						 + "<img    title='点击更换' " +
						 		" src='/web/busin/action/RandomImgAction_buildRandomImgCode.do1' " +
						 		" onclick=\"javascript:this.src='/web/busin/action/RandomImgAction_buildRandomImgCode.do1'\"  	>" 
						);
//src='/web/busin/action/RandomImgAction_buildRandomImgCode.do1' onclick="javascript:this.src='/web/busin/action/RandomImgAction_buildRandomImgCode.do1'" 
						
					//	buildHtml.append( "  value='"+ autobuildWidget.getParam1() + "' />\n");
				
			}
		}
		
		
		//顶部菜单判断
		if(reHtmlVO.getTopMenuId()!=null && reHtmlVO.getTopMenuId().length()>0){
			AutoBuildWidgetVO abwidget = new AutoBuildWidgetVO(); 
			abwidget.setWidgetId(reHtmlVO.getTopMenuId());//从数据库中读取当前顶部菜单的值
			abwidget = (AutoBuildWidgetVO) DateBaseOperateUtil.jdbcSelectSingleOperate(abwidget);
			String c1 = this.buildTopMenu(abwidget);
			//头部追加标签
			headHtml.append("<div id='globalallPageDiv' >");
			buildHtml.append(c1);
			endHtml.append("</div>");
			
			
		}
		//左侧菜单判断
		if(reHtmlVO.getLeftMenuId()!=null && reHtmlVO.getLeftMenuId().length()>0){
			AutoBuildWidgetVO abwidget = new AutoBuildWidgetVO(); 
			abwidget.setWidgetId(reHtmlVO.getLeftMenuId());//从数据库中读取当前顶部菜单的值
			abwidget = (AutoBuildWidgetVO) DateBaseOperateUtil.jdbcSelectSingleOperate(abwidget);
			String re = buildLeftTree(abwidget);
			buildHtml.append(re);
			//this.buildTopMenu(reHtmlVO.getTopMenuId(), buildHtml, headHtml, endHtml);
		}
				
		if( reHtmlVO.getOnlyDiv()== null || "1".equals(reHtmlVO.getOnlyDiv())   ){
			buildHtml.append("</body>\n</html>\n");
		}
		
		//有要加载的方法 
		if(reHtmlVO!=null && reHtmlVO.getOnload1()!=null ){ 
			buildHtml.append( "<script >\n");
			buildHtml.append(reHtmlVO.getOnload1());
			buildHtml.append( "\n</script></div>\n");
		}
		
		//总页面合成
		buildHtml.insert(0, headHtml.toString() + "<body>");//追加头部
		buildHtml.append("<body>" + endHtml);//追加后部

		//获取当前工程名,平判断文件目录是否存在 如果不存在就全部创建
		String  lookupPath = request.getRequestURI();
		String myProject =  reHtmlVO.getProjectId();
		String projectPath =ToolsFile.localWebpath + "userProject\\" + myProject ;
		File projectfile = new File(projectPath);
		if(projectfile.exists()==false){
			new File(projectPath + "\\html").mkdirs();
			new File(projectPath + "\\js").mkdirs();
			new File(projectPath + "\\pic").mkdirs();
			new File(projectPath + "\\c").mkdirs();
		}
		
		//生成自动控件的页面 
		String outPublicPath = projectPath + "\\html\\" +  autoBuildWidget.getHtmlId() + ".html";
		try {
			byte[] htmlS = buildHtml.toString().getBytes("UTF-8");
			ToolsFile.createFile(htmlS, outPublicPath );
			Boolean bo = true;
			buildJsonModelAndView(bo);
		} catch (UnsupportedEncodingException e) {
		 	e.printStackTrace();
		}
		return null;
	}
	
	//生成表格方法 
	private String tablePageBuild(String loadUrl,AutoBuildWidgetVO autobuildWidget,int pageMove){
		StringBuffer result = new StringBuffer(); 
		result.append( "globalToolsTableBuild(");
		result.append(   loadUrl + ",");
//		result.append( autobuildWidget.getParam1() + ",");
		result.append( "'" + autobuildWidget.getId() + "'," );
		result.append( pageMove + ");");	
		return result.toString();
	}
	
	
	//http://localhost:8080/web/back/action/BackSAutoetpOperateAction_buildCompoundSql.do1?compoundSqlId=sql5
	public ModelAndView buildCompoundSql(HttpServletRequest request,HttpServletResponse response){
		
		StringBuffer finalSql = new  StringBuffer(" select ");  
		String compoundSqlId = request.getParameter("compoundSqlId");
		CompoundSqlVO compoundSqlvo = new CompoundSqlVO();
		compoundSqlvo.setCompoundSqlId(compoundSqlId);
		//查找SQL语句定于主表信息
		compoundSqlvo = (CompoundSqlVO) DateBaseOperateUtil.jdbcSelectSingleOperate(compoundSqlvo);
		System.out.println("=========" + compoundSqlvo);
		
		
		//==========================================生成显示字段区域================================
		//获取select 列的條件  		
		CompoundSqlShowVO compoundSqlShowVO = new CompoundSqlShowVO();
		compoundSqlShowVO.setCompoundSqlId(compoundSqlId);
		List<BaseAutoBuildVO> filedslist = DateBaseOperateUtil.jdbcSelectMultitermOperate(compoundSqlShowVO);
		if(filedslist==null || filedslist.size()== 0){//直接顯示所有列名
			finalSql.append(" * ");
		}		
		for(BaseAutoBuildVO fileVO :filedslist){
			//转成显示条件的vo1
			CompoundSqlShowVO vo = (CompoundSqlShowVO)fileVO;
			//往sql 添加显示选项
			finalSql.append(vo.getTableNameAils()  + "." + vo.getTableColumn()  
								+ " as  " + vo.getTableNameAils()  + "_" + vo.getTableColumn()   
								+ "," );
		}
		finalSql.delete(finalSql.length()-1, finalSql.length());
		finalSql.append( "  from " );
		//==========================================生成表名区域================================
		CompoundSqlTableVO compoundSqlTableVO = new CompoundSqlTableVO();
		compoundSqlTableVO.setCompoundSqlId(compoundSqlId);
		List<BaseAutoBuildVO> tableslist = DateBaseOperateUtil.jdbcSelectMultitermOperate(compoundSqlTableVO);
		for(int i=0;i<tableslist.size();i++){
			CompoundSqlTableVO vo = (CompoundSqlTableVO)tableslist.get(i);
			finalSql.append("  " + vo.getTableName() +" as "  + StringUtil.plexStrToClassName(vo.getTableName()) + ","   );
		}
		//去掉最尾部的逗号  
		finalSql.delete(finalSql.length()-1,finalSql.length());
		
		//==========================================生成条件区域================================
		CompoundSqlWhereVO compoundSqlWhereVO = new CompoundSqlWhereVO();
		compoundSqlWhereVO.setCompoundSqlId(compoundSqlId);		
		List<BaseAutoBuildVO> wherelist = DateBaseOperateUtil.jdbcSelectMultitermOperate(compoundSqlWhereVO);
		finalSql.append(" where 1=1 ");
		for(int i=0;i<wherelist.size();i++){
			CompoundSqlWhereVO vo = (CompoundSqlWhereVO)wherelist.get(i);
			if("equal".equals(vo.getWhereType())){				
				finalSql.append(" and " + plexcompoundParam(vo.getParam1Type(), vo.getParam1()) +"="  + plexcompoundParam(vo.getParam2Type(),vo.getParam2()) + " ");
			}
		}
		System.out.println("生成的SQL = "  + finalSql.toString());		
		compoundSqlvo.setBuildSql(finalSql.toString());
		DateBaseOperateUtil.updateByAutoBuildVO(compoundSqlvo);
		//保存到数据库 
		//compound_sql
		
		
//		List<BaseAutoBuildVO>  list = DateBaseOperateUtil.jdbcSelectMultitermOperate(compoundSqlvo);
//		System.out.println(list.size());
		//一个用户可以看多少个景点信息 
		//select * from User_VOTE_INFO_COMBINE a , user_info b		where  a.user_info_id = b.id
		
				
		Map map = new HashMap();
		map.put("aa", "111");
		map.put("bb", "222");
		map.put("cc", "333");
		
		
		return buildJsonModelAndView(map);
		
		
	}
	/**
	  替换类型值，判断属性类型，然后生成对应的字符串	    
	  目前类型参数有
	 * @param type  类型  只能填写Stirng(字符类型) filed(数据库字段类型),input(输入数值)
	 * @param value 输入的参数 
	 * @return  返回的值
	 */
	private String plexcompoundParam(String type,String value){
		if("field".equals(type)){//如果是字段类型的，直接返回
			return value;
		}else if("input".equals(type) ){
			return "(_" + value + "_)";
		}else if("String".equals(type)){
			return  "'" + value + "'";
		}
		return value;
	}
	
	/**
	 * 构建头部的菜单
	 * @param widgetId 菜单控件的主键
	 * @param buildHtml  当前主页面
	 * @param headHtml   头部页面
	 * @param endHtml    结尾页面
	 */
	private String buildTopMenu(AutoBuildWidgetVO autoBuildWidget){
		
		//在最外层设置div标签
		String c1 = " <div class='navbar navbar-fixed-top' role='navigation'>\n";
		c1+="	\n<div class='container-fluid'>\n";
		JSONArray array = JSON.parseArray(autoBuildWidget.getParam1());
		for(int i=0;i<array.size();i++){
			String columnStr = ""+ array.get(i);
			Map<String,String> map = JSON.parseObject(columnStr, Map.class);
			String menushow = map.get("menushow");
			String location = map.get("location");
			String methodName =  map.get("methodName"); 
			
			c1+= "		<div class='navbar-" + location + "'>\n";
			// <a class="navbar-brand" href="#">Brand1</a>				
			if("globalToolsTopMenuColumn_url".equals(methodName)  ){//普通url方式						
				String menulink =  map.get("menulink");						
				String menuFlush = map.get("menuFlush");
				// selectValue:"movepage,moveDiv",
				if("moveDiv".equals(menuFlush)){
					//javascript:autoBuild_html_page_reload_div("globalallPageDiv","http://www.baidu.com")
					menulink="javascript:autoBuild_html_page_reload_div(\"globalallPageDiv\",\"" + menulink + "\")";
				}
				c1+="			<a class='navbar-brand' href='" + menulink + "'>" + menushow + "</a>\n";
			}else if("globalToolsTopMenuColumn_image".equals(methodName)){
				String menulink =  map.get("menulink");
				String menupicth =  map.get("menupicth");
				c1+="			<a class='navbar-brand' href='" + menulink + "'>\n" + 
				"				<img src='" +  menupicth + "' />\n" 
				+ "				</a>\n";
			}
			c1+= "		</div>\n";					
		}
		c1 +="		</div>\n";
		c1 +="	</div>\n";
		return c1;
	}
	
	
	
	/**
	 * 构建左侧的树
	 * @param autoBuildWidget 树控件

	 */
	private String buildLeftTree(AutoBuildWidgetVO autoBuildWidget){
		
		//解析出菜单的配置
	 	JSONArray array = JSON.parseArray(autoBuildWidget.getParam1());
	 	int currentLevel=0;
	 	List myTreeList = new ArrayList();
		for(int i=0;i<array.size();i++){							
			String columnStr = ""+ array.get(i);
			Map map = JSON.parseObject(columnStr, Map.class);
			//判断是不是根节点
			String menuNumber= "" + map.get("menuNumber");
			String menuFather= "" + map.get("menuFather");
			String menuName =  "" +map.get("menuName");							
		 	String methodName =  "" +map.get("methodName");
		 	String menuUrl =  "" +map.get("menuUrl");
		 	String menuLevel =  "" +map.get("menuLevel");
		 	
			AutoOperateSetpVO aosvo = new AutoOperateSetpVO();
			aosvo.setId(menuNumber);
			aosvo.setName(menuName);
			aosvo.setParentId(menuFather);
			aosvo.setType(methodName);
			aosvo.setParam1(menuUrl);
			aosvo.setParam2(menuLevel);
			
			myTreeList.add(aosvo);							
		}
		
		
		TreeVO treeVo = TreeUtil.buildTreeFromList(myTreeList);
		String myMenu="<div class='container-fluid'   >\n";
		myMenu +=" <div class='row'>\n";
		myMenu +=" 		<div class='col-sm-4 col-md-2 sidebar'>\n";
		//遍历树
//				//"<div id='rightTreeDiv' ></div>"
		List<TreeVO> listtree = treeVo.getLeafs();
		for(TreeVO t:listtree){
			myMenu +=this.mySimpleMenu(t,"rightTreeDiv");
		}
		myMenu +=" </div>\n";	
		//配置右边的内容
		myMenu +=" <div class='col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main' id='rightTreeDiv'></div>\n";
		 //<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		myMenu +="</div>\n";
		myMenu +="</div>\n";
		return  myMenu;
	}
	
	/**
	 *  构造简单菜单 的地鬼循环类
	 * @param vo
	 * @param menuId
	 * @return
	 */
	public String mySimpleMenu(TreeVO vo,String menuId){
		String re = "";
		AutoOperateSetpVO setpVO = (AutoOperateSetpVO) vo.getData();
		List list = vo.getLeafs();
		//前面的空格符号多少		
		String spaceBar = "";
		if(setpVO!=null && setpVO.getParam2()!=null){
			spaceBar = StringUtil.buildHtmlSpacebar(Integer.parseInt(setpVO.getParam2()));
		}
		if(list.size()>0){
			String href= buildHrefUrlPage(menuId, setpVO);//跳转的连接			
			re += " <ul class='nav nav-sidebar'   >\n";
			re += "    <li   onclick='globalTools_menu_collacp(this,event)' ><a href=\"" + href + "\">" + spaceBar + setpVO.getName() + "</a></li>\n ";
			for(int i=0;i<list.size();i++){
				TreeVO tvo = (TreeVO) list.get(i);
				re +=mySimpleMenu(tvo,menuId);
			}
			re += " </ul>\n";
		}else{
			String href= buildHrefUrlPage(menuId, setpVO);//跳转的连接			
			re += "    <li><a href=\"" + href + "\">&nbsp;&nbsp;&nbsp;&nbsp;" + setpVO.getName() + "</a></li>\n ";
		}
		return re;
	}
	/**
	 * 构建当前超链接的界面
	 * @param menuId  如果是当前内跳转的div名称
	 * @param setpVO  当前树型节点的vo
	 * @param href    
	 * @return
	 */
	private String buildHrefUrlPage(String menuId, AutoOperateSetpVO setpVO) {
		String href = "";
		if("globalToolsSimpleMenuColumn_url".equals(  setpVO.getType())){//单页面跳转
			href = "javascript:autoBuild_html_page_reload_div('" + menuId + "','" + setpVO.getParam1() + "')";
		}else if("globalToolsTableColumnButtonDrawById".equals(  setpVO.getType())){//整体跳转
			href = setpVO.getParam1();
		}
		return href;
	}
	//http://localhost:8080/web/back/action/BackSAutoetpOperateAction_tempTest.do1
	public ModelAndView tempTest(HttpServletRequest request,HttpServletResponse response){
		System.out.println("ccccccccccc111");
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("aa", "111");
		map.put("bb", "222");
		map.put("cc", "333");
		
		return buildJsonModelAndView(map);
	}
	
}
//修复控件位置的sql语句
//update auto_build_widget set position_top=200,position_Left=200 where  html_id = 'pageList';
//select  position_Left , position_Top from   auto_build_widget where  html_id = 'pageList';
//					currentSelectObj.parent().offset({left:AutoBuildWidgetVO.positionLeft});
//					currentSelectObj.parent().offset({top:AutoBuildWidgetVO.positionTop});







