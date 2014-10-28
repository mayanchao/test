
/*
 *  属性框是json类型，而json对应要显示的一些信息 和输入框，这些通过下面json属性配置好  
 *  当双击输入框的时候 弹出json输入框层
 *  ===============属性说明 
 *  
 *  values:[{},{}] 这个属性是以数组方式存放每个要显示的框
 *  
  	 paramName 属性的中文名
	 paramVarName 属性对应json的名字
     paramValue  属性的默认值
     paramType   属性类型，目前只有String类型  
     paramDetail 属性后缀说明，在输入框后面显示的说明信息
     paramHieden 是否显示出属性输入框，true代表不显示
 *   
 *   
 *   
 *   
 *   
 *   ondblclick='openJsonTools(this,jsonShowType_build_sql_order)'
 */
//json显示框类型
//每个json显示模块要以jsonShowType + 模块名 + 业务组成
//数据库查询 表名类型 
var  jsonShowType_build_sql_table = {
  	values:[{
  	 paramName:"表名",
	 paramVarName:"tableName",
     paramValue:"",
     paramType:"String",
     paramDetail:"数据库的表名要大写，生成的别名就是全小写的"
	}]
  };

/*
	public String id;	
	public String compoundSqlId;
	public String whereType;
	public String param1;
	public String param1Type;
	public String param2;
	public String param2Type;
	public String description;
*/
//{"param1":"a.a1","param1Type":"equal","param2":"a","param2Type":"string"}
//数据库查询   条件类型 
var  jsonShowType_build_sql_where = {
  	values:[
	{
  	 paramName:"条件一",
	 paramVarName:"param1",
     paramValue:"",
     paramType:"String",
     paramDetail:"数据库查询左边条件 "
	},{
  	 paramName:"条件一类型",
	 paramVarName:"param1Type",
     paramValue:"",
     paramType:"String",
     paramDetail:"只能填写Stirng(字符类型) filed(数据库字段类型),input(输入数值) "
	},{
  	 paramName:"类型",
	 paramVarName:"whereType",
     paramValue:"",
     paramType:"String",
     paramDetail:"只能填写  like equal(等号) "
	},{
  	 paramName:"条件二",
	 paramVarName:"param2",
     paramValue:"",
     paramType:"String",
     paramDetail:"sql查询右边条件   "
	},{
  	 paramName:"条件二类型",
	 paramVarName:"param2Type",
     paramValue:"",
     paramType:"String",
     paramDetail:"只能填写Stirng(字符类型) filed(数据库字段类型)"
	}
	
	]
}	


//json显示框类型
/**
 * 	
	public String id;	
	public String compoundSqlId;
	public String tableColumn;
	public String tableNameAils;
	public String description;
 */

//数据库查询 显示类型 
var  jsonShowType_build_sql_show = {
  	values:[{
  	 paramName:"列名 ",
	 paramVarName:"tableColumn",
     paramValue:"",
     paramType:"String",
     paramDetail:"表中的列名   最终的select 语句中的别名都是小写表名+ 下划线 + 列名 如 user_name"
	},
	{
  	 paramName:"表的别名",
	 paramVarName:"tableNameAils",
     paramValue:"",
     paramType:"String",
     paramDetail:"数据库表的别名，一般都是表的小写   "
	}]
  };


//===================================ajax 请求用到的类型  
//
/**
 * ajax方法生成
 * myCallBackFunction //回调方法  
 * paramBuildJs  //回调方法 
 * 
 */
var  ajax_build_submit_method = {
  	values:[
	{
  	 paramName:"请求后的回调方法",
	 paramVarName:"myCallBackFunction",
     paramValue:"",
     paramType:"String",
     paramDetail:"只能填写根据ID取值方法 myCallBeforeSimpleFindValue(['id1','id2'],  注意没有最后的右括号,id就是   <br> 或者myCallBeforeMyvalueVar('value')" 
	},{
  	 paramName:"ajax请求前的方法",
	 paramVarName:"paramBuildJs",
     paramValue:"",
     paramType:"String",
     paramDetail:" "
	}
	
	]
  };






//============================后台工作流==========================
/**
	* 工作流 属性节点的属性
	*	private String id;
	*	private String type;
	*	//页面编号 
	*	private String htmlId;
	*	private String name;
	*	//父节点id
	*	private String parentId;
	*	private String width;
	*	private String height;
	*	private String param1;
	*	private String param2;
	*	private String param3;
	*	private String param4;
	*	private String param5;
	*	private String param6;
	*	private String param7;
	*	private String param8;
	*	private String param9;
	*	private String descript ; 
* 
*/
//从值链中获取BaseAutoBuildVO，进行数据库查询，最后然后保存到值队列中
var  back_workflow_operate_FindSingleDateOperate = {
  	values:[
   { 
	 paramVarName:"type",
	 paramType:"hidden" 
	},{ 
	 paramVarName:"autoSetpId",
	 paramType:"hidden" 
	},{
	 paramName:"父节点id",
	 paramVarName:"parentId",
	 paramValue:"",
	 paramType:"String",
	 paramDetail:"父节点的id，没有但表跟目录"
	},
	{
  	 paramName:"步骤名",
	 paramVarName:"name",
     paramValue:"",
     paramType:"String",
     paramDetail:"步骤的名称" 	 
	},{
  	 paramName:"上节点的主键",
	 paramVarName:"param1",
     paramValue:"",
     paramType:"String",
     paramDetail:"上个节点收集来的对象，一般都是从request中获取" 
	}
	,{
  	 paramName:"主键名",
	 paramVarName:"param2",
     paramValue:"",
     paramType:"String",
     paramDetail:"  取值后保存到map 集合的主键名" 
	},	
	{
  	 paramName:"描述",
	 paramVarName:"descript",
     paramValue:"",
     paramType:"String",
     paramDetail:"描述信息" 
	}
	]
  };


//从memcache中获取值，然后保存到值队列中
/*
var  back_workflow_operate_FindSingleDateFromMemcacheOperate = {
  	values:[
   { 
	 paramVarName:"type",
	 paramType:"hidden" 
	},{ 
	 paramVarName:"autoSetpId",
	 paramType:"hidden" 
	},{
	 paramName:"父节点id",
	 paramVarName:"parentId",
	 paramValue:"",
	 paramType:"String",
	 paramDetail:"父节点的id，没有但表跟目录"
	},
	{
  	 paramName:"步骤名",
	 paramVarName:"name",
     paramValue:"",
     paramType:"String",
     paramDetail:"步骤的名称" 	 
	},{
  	 paramName:"结果VO",
	 paramVarName:"param1",
     paramValue:"",
     paramType:"String",
     paramDetail:"必须是单表对象 例如 com.mana.autoBuild.tableVO.UserInfoTableVO" 
	}
	,{
  	 paramName:"主键名",
	 paramVarName:"param2",
     paramValue:"",
     paramType:"String",
     paramDetail:"  取值后保存到map 集合的主键名" 
	},{
  	 paramName:"获取ID",
	 paramVarName:"param3",
     paramValue:"",
     paramType:"String",
     paramDetail:"从request中获取的key" 
	},
	{
  	 paramName:"描述",
	 paramVarName:"descript",
     paramValue:"",
     paramType:"String",
     paramDetail:"描述信息" 
	}
	]
  };
*/

//从request中获取值，然后保存到值队列中
var  back_workflow_operate_FindSingleDateFromRequestOperate = {
	  	values:[
	   { 
		 paramVarName:"type",
		 paramType:"hidden" 
		},{ 
		 paramVarName:"autoSetpId",
		 paramType:"hidden" 
		},{
		 paramName:"父节点id",
		 paramVarName:"parentId",
		 paramValue:"",
		 paramType:"String",
		 paramDetail:"父节点的id，没有但表跟目录"
		},
		{
	  	 paramName:"步骤名",
		 paramVarName:"name",
	     paramValue:"",
	     paramType:"String",
	     paramDetail:"步骤的名称" 	 
		},{
	  	 paramName:"结果VO",
		 paramVarName:"param1",
	     paramValue:"",
	     paramType:"String",
	     paramDetail:"必须是单表对象 例如 com.mana.autoBuild.tableVO.UserInfoTableVO" 
		}
		,{
	  	 paramName:"主键名",
		 paramVarName:"param2",
	     paramValue:"",
	     paramType:"String",
	     paramDetail:"  取值后保存到map 集合的主键名" 
		},{
	  	 paramName:"获取ID数组",
		 paramVarName:"param3",
	     paramValue:"",
	     paramType:"String",
	     paramDetail:"必须写成 数组'id1','id2' 的方式" 
		},
		{
	  	 paramName:"描述",
		 paramVarName:"descript",
	     paramValue:"",
	     paramType:"String",
	     paramDetail:"描述信息" 
		}
		]
	  };
//判断值链中是否有相等的两个值
var  back_workflow_operate_EqualOperate = {
  	values:[
  		   { 
  			 paramVarName:"type",
  			 paramType:"hidden" 
  			},{ 
  			 paramVarName:"autoSetpId",
  			 paramType:"hidden" 
  			},{
  			 paramName:"父节点id",
  			 paramVarName:"parentId",
  			 paramValue:"",
  			 paramType:"String",
  			 paramDetail:"父节点的id，没有但表跟目录"
  			},
  			{
  		  	 paramName:"步骤名",
  			 paramVarName:"name",
  		     paramValue:"",
  		     paramType:"String",
  		     paramDetail:"步骤的名称" 	 
  			}
  			,{
  		  	 paramName:"比较值1",
  			 paramVarName:"param1",
  		     paramValue:"",
  		     paramType:"String",
  		     paramDetail:"要比较的数值1 只能是值链中的名字，加上字段名  例如 userInfoMemcache.password 后台会从map找出对象并找出password字段的值进行比较 " 
  			},{
  		  	 paramName:"比较值2",
  			 paramVarName:"param2",
  		     paramValue:"",
  		     paramType:"String",
  		     paramDetail:"要比较的数值2 只能是值链中的名字，加上字段名  例如 userInfoMemcache.password 后台会从map找出对象并找出password字段的值进行比较 " 
  	  		},{
  		  	 paramName:"比较成功步骤",
  			 paramVarName:"param3",
  		     paramValue:"",
  		     paramType:"String",
  		     paramDetail:"比较结果是true 就执行的步骤 要填写步骤名称" 	 
  	  		},{
  		  	 paramName:"比较失败步骤",
  			 paramVarName:"param4",
  		     paramValue:"",
  		     paramType:"String",
  		     paramDetail:"比较结果是false 就执行的步骤 要填写步骤名称" 	 
  	  		},
  			{
  		  	 paramName:"描述",
  			 paramVarName:"descript",
  		     paramValue:"",
  		     paramType:"String",
  		     paramDetail:"描述信息" 
  			}
  			]
	  };

//页面跳转工作流
var  back_workflow_operate_PageMove = {
  	values:[
  		   { 
  			 paramVarName:"type",
  			 paramType:"hidden" 
  			},{ 
  			 paramVarName:"autoSetpId",
  			 paramType:"hidden" 
  			},{
  			 paramName:"父节点id",
  			 paramVarName:"parentId",
  			 paramValue:"",
  			 paramType:"String",
  			 paramDetail:"父节点的id，没有但表跟目录"
  			},{
  		  	 paramName:"步骤名",
  			 paramVarName:"name",
  		     paramValue:"",
  		     paramType:"String",
  		     paramDetail:"步骤的名称" 	 
  			},{
  		  	 paramName:"跳转的页面",
  			 paramVarName:"param1",
  		     paramValue:"",
  		     paramType:"String",
  		     paramDetail:"要跳转的界面   " 
  			},{
  		  	 paramName:"描述",
  			 paramVarName:"descript",
  		     paramValue:"",
  		     paramType:"String",
  		     paramDetail:"描述信息" 
  			}
  			]
	  };




//对数据进行操作  只能是数量级别的操作 
var  back_workflow_operate_NumberOperate = {
	values:[
		   { 
			 paramVarName:"type",
			 paramType:"hidden" 
			},{ 
			 paramVarName:"autoSetpId",
			 paramType:"hidden" 
			},{
			 paramName:"父节点id",
			 paramVarName:"parentId",
			 paramValue:"",
			 paramType:"String",
			 paramDetail:"父节点的id，没有但表跟目录"
			},{
		  	 paramName:"步骤名",
			 paramVarName:"name",
		     paramValue:"",
		     paramType:"String",
		     paramDetail:"步骤的名称" 	 
			},{
			  	 paramName:"上个节点的值",
				 paramVarName:"param1",
			     paramValue:"",
			     paramType:"String",
			     paramDetail:"上一个节点，处理的值， 值是一个vo" 
			},{
			  	 paramName:"处理的字段",
				 paramVarName:"param2",
			     paramValue:"",
			     paramType:"String",
			     paramDetail:"在上节点vo中，获取字段的名字" 
			},{
			  	 paramName:"操作的值",
				 paramVarName:"param3",
			     paramValue:"",
			     paramType:"String",
			     paramDetail:"要操作的值，必须是数字" 
			},{
			  	 paramName:"操作类型",
				 paramVarName:"param4",
			     paramValue:"",
			     paramType:"String",
			     paramDetail:"add,subtract,multiply,divide" 
			},
			{
		  	 paramName:"描述",
			 paramVarName:"descript",
		     paramValue:"",
		     paramType:"String",
		     paramDetail:"描述信息" 
			}
			]
	  };






//更新单条数据
var  back_workflow_operate_UpdateSingleDateOperate = {
  	values:[
  		   { 
  			 paramVarName:"type",
  			 paramType:"hidden" 
  			},{ 
  			 paramVarName:"autoSetpId",
  			 paramType:"hidden" 
  			},{
  			 paramName:"父节点id",
  			 paramVarName:"parentId",
  			 paramValue:"",
  			 paramType:"String",
  			 paramDetail:"父节点的id，没有但表跟目录"
  			},{
  		  	 paramName:"步骤名",
  			 paramVarName:"name",
  		     paramValue:"",
  		     paramType:"String",
  		     paramDetail:"步骤的名称" 	 
  			},{
  		  	 paramName:"上个节点的值",
  			 paramVarName:"param1",
  		     paramValue:"",
  		     paramType:"String",
  		     paramDetail:"上个节点的值 这个值会更新到数据库中  " 
  			},{
  		  	 paramName:"描述",
  			 paramVarName:"descript",
  		     paramValue:"",
  		     paramType:"String",
  		     paramDetail:"描述信息" 
  			}
  			]
	  };



//插入单条数据
var  back_workflow_operate_InsertSingleDateOperate = {
	values:[
		   { 
			 paramVarName:"type",
			 paramType:"hidden" 
			},{ 
			 paramVarName:"autoSetpId",
			 paramType:"hidden" 
			},{
			 paramName:"父节点id",
			 paramVarName:"parentId",
			 paramValue:"",
			 paramType:"String",
			 paramDetail:"父节点的id，没有但表跟目录"
			},{
		  	 paramName:"步骤名",
			 paramVarName:"name",
		     paramValue:"",
		     paramType:"String",
		     paramDetail:"步骤的名称" 	 
			},{
		  	 paramName:"上个节点的值",
			 paramVarName:"param1",
		     paramValue:"",
		     paramType:"String",
		     paramDetail:"上个节点的值 这个值会保存到数据库中  " 
			},{
		  	 paramName:"描述",
			 paramVarName:"descript",
		     paramValue:"",
		     paramType:"String",
		     paramDetail:"描述信息" 
			}
			]
	  };




//输入存入session 
var  back_workflow_operate_SessionInputOperate = {
  	values:[
  		   { 
  			 paramVarName:"type",
  			 paramType:"hidden" 
  			},{ 
  			 paramVarName:"autoSetpId",
  			 paramType:"hidden" 
  			},{
  			 paramName:"父节点id",
  			 paramVarName:"parentId",
  			 paramValue:"",
  			 paramType:"String",
  			 paramDetail:"父节点的id，没有但表跟目录"
  			},{
  		  	 paramName:"步骤名",
  			 paramVarName:"name",
  		     paramValue:"",
  		     paramType:"String",
  		     paramDetail:"步骤的名称" 	 
  			},{
  		  	 paramName:"session名字",
  			 paramVarName:"param1",
  		     paramValue:"",
  		     paramType:"String",
  		     paramDetail:"要存入 session的名字，会当作key存入session " 
  			},{
  	  		  	 paramName:"获取主键",
  	  			 paramVarName:"param2",
  	  		     paramValue:"",
  	  		     paramType:"String",
  	  		     paramDetail:"要存入session  链值队列中的名字 "  		    	 
  			},{
  		  	 paramName:"描述",
  			 paramVarName:"descript",
  		     paramValue:"",
  		     paramType:"String",
  		     paramDetail:"描述信息" 
  			}
  			]
	  };


//从session获取数据  
var  back_workflow_operate_SessionOutputOperate = {
  	values:[
  		   { 
  			 paramVarName:"type",
  			 paramType:"hidden" 
  			},{ 
  			 paramVarName:"autoSetpId",
  			 paramType:"hidden" 
  			},{
  			 paramName:"父节点id",
  			 paramVarName:"parentId",
  			 paramValue:"",
  			 paramType:"String",
  			 paramDetail:"父节点的id，没有但表跟目录"
  			},{
  		  	 paramName:"步骤名",
  			 paramVarName:"name",
  		     paramValue:"",
  		     paramType:"String",
  		     paramDetail:"步骤的名称" 	 
  			},{
  		  	 paramName:"session名字",
  			 paramVarName:"param1",
  		     paramValue:"",
  		     paramType:"String",
  		     paramDetail:"取出session ，链值队列的名字"  		    	 
  			},{
  		  	 paramName:"存入主键",
  			 paramVarName:"param2",
  		     paramValue:"",
  		     paramType:"String",
  		     paramDetail:"要存入主键的名字 "  		    	 
  			}
  			
  			,{
  		  	 paramName:"描述",
  			 paramVarName:"descript",
  		     paramValue:"",
  		     paramType:"String",
  		     paramDetail:"描述信息" 
  			}
  			]
	  };



//复杂工作流
var  back_workflow_operate_ExamComplexSqlOperate = {
	values:[
		   { 
			 paramVarName:"type",
			 paramType:"hidden" 
			},{ 
			 paramVarName:"autoSetpId",
			 paramType:"hidden" 
			},{
			 paramName:"父节点id",
			 paramVarName:"parentId",
			 paramValue:"",
			 paramType:"String",
			 paramDetail:"父节点的id，没有但表跟目录"
			},{
		  	 paramName:"步骤名",
			 paramVarName:"name",
		     paramValue:"",
		     paramType:"String",
		     paramDetail:"步骤的名称" 	 
			},{
		  	 paramName:"复合SQL主键",
			 paramVarName:"param1",
		     paramValue:"",
		     paramType:"String",
		     paramDetail:" 复杂sql所对应的ID值 对应的是 compound_Sql 表的 compound_sql_id字段 " 
			},{
		  	 paramName:"描述",
			 paramVarName:"descript",
		     paramValue:"",
		     paramType:"String",
		     paramDetail:"描述信息" 
			}
			]
	  };


//从工作流节点中获取值，并赋值
var  back_workflow_operate_EvaluateDataFromMapOperate={
	values:[
		    {
			 paramVarName:"type",
			 paramType:"hidden" 
			},{ 
			 paramVarName:"autoSetpId",
			 paramType:"hidden" 
			},{
			 paramName:"父节点id",
			 paramVarName:"parentId",
			 paramValue:"",
			 paramType:"String",
			 paramDetail:"父节点的id，没有但表跟目录"
			},{
		  	 paramName:"步骤名",
			 paramVarName:"name",
		     paramValue:"",
		     paramType:"String",
		     paramDetail:"步骤的名称" 	 
			},
			{
		  	 paramName:"数据源的字段",
			 paramVarName:"param1",
		     paramValue:"",
		     paramType:"String",
		     paramDetail:" 数据的来源，例如 结果集名.字段  。" 
			},
			{
		  	 paramName:"目标源字段",
			 paramVarName:"param2",
		     paramValue:"",
		     paramType:"String",
		     paramDetail:" 要存入的的目标  例如 结果集名.字段  注意在值队列里的主键，就是这个复合对象的key " 
			},{
		  	 paramName:"是否为空判断",
			 paramVarName:"param3",
		     paramValue:"",
		     paramType:"String",
		     paramDetail:" 如果每值的话就 新建一个这样的vo的类型对象 注意在值队列里的主键，就是这个复合对象的key" 
			},{
		  	 paramName:"描述",
			 paramVarName:"descript",
		     paramValue:"",
		     paramType:"String",
		     paramDetail:"描述信息" 
			}
			]
	  };

//保存值到cookie中
var  back_workflow_operate_InsertCookieOperate={
		values:[
			    {
				 paramVarName:"type",
				 paramType:"hidden" 
				},{
				 paramVarName:"autoSetpId",
				 paramType:"hidden" 
				},{
				 paramName:"父节点id",
				 paramVarName:"parentId",
				 paramValue:"",
				 paramType:"String",
				 paramDetail:"父节点的id，没有但表跟目录"
				},{
			  	 paramName:"步骤名",
				 paramVarName:"name",
			     paramValue:"",
			     paramType:"String",
			     paramDetail:"步骤的名称" 	 
				},
				{
			  	 paramName:"数据源的字段",
				 paramVarName:"param1",
			     paramValue:"",
			     paramType:"String",
			     paramDetail:" 数据的来源，例如 结果集名.字段  。" 
				},
				{
			  	 paramName:"cookIe名字",
				 paramVarName:"param2",
			     paramValue:"",
			     paramType:"String",
			     paramDetail:" 要存入的cookie名字 " 
				}
				]
		  };
//获取当前IP 并保存
var  back_workflow_operate_FindIpOperate={
		values:[
			    {
				 paramVarName:"type",
				 paramType:"hidden" 
				},{
				 paramVarName:"autoSetpId",
				 paramType:"hidden" 
				},{
				 paramName:"父节点id",
				 paramVarName:"parentId",
				 paramValue:"",
				 paramType:"String",
				 paramDetail:"父节点的id，没有但表跟目录"
				},{
			  	 paramName:"步骤名",
				 paramVarName:"name",
			     paramValue:"",
			     paramType:"String",
			     paramDetail:"步骤的名称" 	 
				},
				{
			  	 paramName:"要保存数据源的字段",
				 paramVarName:"param1",
			     paramValue:"",
			     paramType:"String",
			     paramDetail:" 要保存的，例如 结果集名.字段  。" 
				}
				]
		  };

//===================================菜单栏===================
var  autoBuild_html_table_column_globalToolsSimpleMenuColumn_url = {		
  	values:[
  		   {
  			 paramName:"菜单编号",
  			 paramVarName:"menuNumber",
  			 paramValue:"",
  			 paramType:"String",
  			 paramDetail:"当前菜单的唯一编号"
  			},
  			{
  			 paramName:"菜单名称",
  			 paramVarName:"menuName",
  			 paramValue:"",
  			 paramType:"String",
  			 paramDetail:"当前菜单的名称"
  	  		},{
  			 paramName:"父节点名称",
  			 paramVarName:"menuFather",
  			 paramValue:"",
  			 paramType:"String",
  			 paramDetail:"如果是空，代表是跟目录"
  	  	  	},{
  			 paramName:"连接的地址",
  			 paramVarName:"menuUrl",
  			 paramValue:"",
  			 paramType:"String",
  			 paramDetail:"要跳转的地址"
  	  	  	},
			{
			 paramVarName:"methodName",
			 paramType:"hidden" 
			}
  		]
	  };


var  autoBuild_html_table_column_globalToolsTopMenuColumn_url = {
	  	values:[
	  		   {
	  			 paramName:"显示名称",
	  			 paramVarName:"menushow",
	  			 paramValue:"",
	  			 paramType:"String",
	  			 paramDetail:"菜单显示出的中文名称"
	  			},
	  			{
	  			 paramName:"菜单连接",
	  			 paramVarName:"menulink",
	  			 paramValue:"",
	  			 paramType:"String",
	  			 paramDetail:"当前菜单会跳转的页面"
	  	  		},{
	  			 paramName:"是否刷页面",
	  			 paramVarName:"menuFlush",
	  			 paramValue:"",
	  			 selectValue:"movepage,moveDiv",
	  			 paramType:"select",
	  			 paramDetail:"是否刷新整个页面"
	  	  	  	}
	  		]
		  };

var  autoBuild_html_table_column_globalToolsTopMenuColumn_image = {
	  	values:[
	  	        {
				 paramName:"图片名称",
				 paramVarName:"menushow",
				 paramValue:"",
				 paramType:"String",
				 paramDetail:"要显示图片的url地址"
				},
	  		   {
	  			 paramName:"图片地址",
	  			 paramVarName:"menupicth",
	  			 paramValue:"",
	  			 paramType:"String",
	  			 paramDetail:"要显示图片的url地址"
	  			},
	  			{
	  			 paramName:"连接",
	  			 paramVarName:"menuLink",
	  			 paramValue:"",
	  			 paramType:"String",
	  			 paramDetail:"点当前图片的连接"
	  	  		}
	  		]
		  };

//========================================表格分页属性==============================

//========================================表格列==============================
//autoBuild_html_table_column_globalToolsTableColumnTextDraw 
var  autoBuild_html_table_column_globalToolsTableColumnTextDraw = {
  	values:[
  		   {
  			 paramName:"渲染列名",
  			 paramVarName:"columnName",
  			 paramValue:"",
  			 paramType:"String",
  			 paramDetail:"查询条件返回数据列表页面"
  			},
			{ 
			 paramVarName:"methodName",
			 paramType:"hidden" 
			}
  		]
	  };

//有按钮列表，的列渲染
var  autoBuild_html_table_column_globalToolsTableColumnButtonDrawById= {
	  	values:[
	  		   {
	  			 paramName:"按钮名",
	  			 paramVarName:"columnName",
	  			 paramValue:"",
	  			 paramType:"String",
	  			 paramDetail:"按钮所显示的名字"
	  			},
	  			{
	  			 paramName:"点击事件",
	  			 paramVarName:"click",
	  			 paramValue:"",
	  			 paramType:"String",
	  			 paramDetail:"按钮被点击的时候的事件 如globalToolsTableColumnButtonDrawById"
	  			},
	  			{
	  			 paramName:"主键集",
	  			 paramVarName:"myIds",
	  			 paramValue:"",
	  			 paramType:"String",
	  			 paramDetail:"页面上要展现的主键  写成'id1','id2'"
	  			},
	  			{ 
  				 paramVarName:"methodName",
  				 paramType:"hidden" 
  				}
	  		]
		  };



//有按钮列表，的列渲染
var  autoBuild_html_table_column_globalToolsTableColumnEnumeration= {
	  	values:[
	  	        {
				 paramName:"列名",
				 paramVarName:"columnName",
				 paramValue:"",
				 paramType:"String",
				 paramDetail:"对应查询结果的列名"
				},
	  			{
	  			 paramName:"枚举对象",
	  			 paramVarName:"maps",
	  			 paramValue:"",
	  			 paramType:"String",
	  			 paramDetail:"写成一个对象的形式就可以 例如 1=启动,2=停止"
	  			},
	  			{
	  			 paramName:"默认值",
	  			 paramVarName:"defaultValue",
	  			 paramValue:"",
	  			 paramType:"String",
	  			 paramDetail:"如果没有对应的值，就默认给一个值"
		  		},
	  			{ 
  				 paramVarName:"methodName",
  				 paramType:"hidden" 
  				}
	  		]
		  };



//有单选按钮列表，的列渲染
var  autoBuild_html_table_column_globalToolsTableColumnRadioDrawById= {
	  	values:[
	  		   {
	  			 paramName:"取值列",
	  			 paramVarName:"columnName",
	  			 paramValue:"",
	  			 paramType:"String",
	  			 paramDetail:"数据集合里，列的名字，会当做单选框的value按钮"
	  			},	  			
	  			{
	  			 paramName:"列的值",
	  			 paramVarName:"name",
	  			 paramValue:"",
	  			 paramType:"String",
	  			 paramDetail:"当前单选框的name属性，在最后收集属性时候可以用到"
	  			},
	  			{ 
				 paramVarName:"methodName",
				 paramType:"hidden" 
				}
	  		]
		  };
//=================================ajax方法===================================
//===================ajax调用前方法========================
var  autoBuild_html_ajax_beforeCall_myCallBeforeSimpleFindValue= {
		values:[
		  		   {
		  			 paramName:"主键集合",
		  			 paramVarName:"ids",
		  			 paramValue:"",
		  			 paramType:"String",
		  			 paramDetail:" 要收集值的主键 例如 id1,id2 "
		  			},
		  			{
		  			 paramName:"点击事件",
		  			 paramVarName:"click",
		  			 paramValue:"",
		  			 paramType:"String",
		  			 paramDetail:"按钮被点击的时候的事件 如globalToolsTableColumnButtonDrawById"
		  			},
		  			{
		  			 paramName:"结果处理",
		  			 paramVarName:"resultHandler",
		  			 paramValue:"",
		  			 selectValue:"tableJson,myValue",
		  			 paramType:"select",
		  			 paramDetail:" 结果集合处理  tableJson(url属性)和myValue(处理当前生成的值)"
		  			},
		  			{ 
	  				 paramVarName:"methodName",
	  				 paramType:"hidden" 
	  				}
		  		]
}
//===================ajax调用后方法========================
//页面成功后把取到的值设置到控件上
var  autoBuild_html_ajax_afterCall_myCallBackSimpleSetValue= {
	values:[
  		   {
  			 paramName:"主键集合",
  			 paramVarName:"ids",
  			 paramValue:"",
  			 paramType:"String",
  			 paramDetail:" 要付值的主键 例如 id1,id2 ，会根据控件上自带的name属性，来匹配结果值"
  			}
  		]
}
//调用后+刷新当前页面方法 
var  autoBuild_html_ajax_afterCall_myCallBackRefreshCurrentPage= {
		values:[
	  	]
}

//调用后 根据数据 加载表格方法
var  autoBuild_html_ajax_afterCall_globalToolsTableBuildByDate= {
		values:[
		        {
				 paramName:"表格ID",
				 paramVarName:"id",
				 paramValue:"",
				 paramType:"String",
				 paramDetail:" 根据数据要，重新刷新的表格编号ID"
				}
	  	]
}



//=================================validate 方法===================================
// 文字长度判断
var  autoBuild_html_validate_textLength= {
		values:[
		        {
		  			 paramName:"名称",
		  			 paramVarName:"name",
		  			 paramValue:"",
		  			 paramType:"String",
		  			 paramDetail:"校验规则的名字 "
		  			},
		  			{ 
	  				 paramVarName:"type",
	  				 paramType:"hidden" 
	  				},
	  				{
			  		 paramName:"触发方式",
			  		 paramVarName:"handleType",
			  		 paramValue:"",
			  		 paramType:"String",
			  		 paramDetail:"只能是onFouce,onchance,onblur, 触发校验的方式 "
			  		},
		  		    {
		  			 paramName:"最大长度",
		  			 paramVarName:"maxLength",
		  			 paramValue:"",
		  			 paramType:"String",
		  			 paramDetail:"输入最大长度 "
		  			},
		  			{
		  			 paramName:"最小长度",
		  			 paramVarName:"minLength",
		  			 paramValue:"",
		  			 paramType:"String",
		  			 paramDetail:"输入最小长度，如果填0代表非必填项"
		  			},
		  			{
		  			 paramName:"出错提示",
		  			 paramVarName:"errorText",
		  			 paramValue:"",
		  			 paramType:"String",
		  			 paramDetail:"出现错误时候的提示语言"
		  			},{
		  			 paramName:"提示方式",
		  			 paramVarName:"errorType",
		  			 paramValue:"",
		  			 paramType:"String",
		  			 paramDetail:"只能是alert,text，div 目前只有aler管用"
		  			}		  			
		  		]
}
//必须是数字类型 
var  autoBuild_html_validate_isNumber= {
		values:[
		        {
		  			 paramName:"名称",
		  			 paramVarName:"name",
		  			 paramValue:"",
		  			 paramType:"String",
		  			 paramDetail:"校验规则的名字 "
		  			},
		  			{ 
	  				 paramVarName:"type",
	  				 paramType:"hidden" 
	  				},
		  		    {
		  			 paramName:"数字类型",
		  			 paramVarName:"numberType",
		  			 paramValue:"",
		  			 paramType:"String",
		  			 paramDetail:"必须是int,float "
		  			}		  			
		  		]
}


//========================

//buildId_pageModify_13991017216874,buildId_pageModify_13991017289515,buildId_pageModify_13991017329046