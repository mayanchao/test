
DROP TABLE IF EXISTS people_scenery_interface ;
create table people_scenery_interface(
  id  varchar(50),  
  vote_people_id  varchar(100),
  scenery_id      varchar(100),  
  primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS scenery ;
create table scenery(
  id  varchar(50),  
  name  varchar(500),
  state varchar(10), 
  the_count varchar(100),
  primary key(id)
);


DROP TABLE IF EXISTS User_Info ;
create table User_Info(
  id  varchar(15),
  login_name varchar(40),
  name  varchar(45),
  age varchar(10),
  sex varchar(1),
  address varchar(20),
  password varchar(40),
  primary key(id)
);


drop table  if exists  User_VOTE ;
create table User_VOTE(
  id  char(15),
  feature_Name   char(100),  
  status   char(20),  
  count  char(20),
  primary key(id)
);


insert into User_VOTE(id,feature_name,count,status) value('a1','泰山', '0','1');
insert into User_VOTE(id,feature_name,count,status) value('a2','长城', '0','1');
insert into User_VOTE(id,feature_name,count,status) value('a3','故宫', '1','1');
insert into User_VOTE(id,feature_name,count,status) value('a4','天安门','1','1');
insert into User_VOTE(id,feature_name,count,status) value('a5','颐和园','1','1');
insert into User_VOTE(id,feature_name,count,status) value('a6','北海 ','1','1');
insert into User_VOTE(id,feature_name,count,status) value('a7','八达岭 ','1','1');
insert into User_VOTE(id,feature_name,count,status) value('a8','十三陵 ','1','1');
insert into User_VOTE(id,feature_name,count,status) value('a9','动物园  ','1','1');
insert into User_VOTE(id,feature_name,count,status) value('aa1','新世界  ','1','1');
insert into User_VOTE(id,feature_name,count,status) value('aa2','大栅栏  ','1','1');
insert into User_Info(id,name,login_name,password) values('id111','凌志林','abc','123456');

//用户投票的景区和用户名接口
drop table  if exists  User_VOTE_INFO_COMBINE;
create table User_VOTE_INFO_COMBINE(
  id  char(15),
  User_Info_id   char(100) comment  '用户信息表',
  User_VOTE_id   char(100) comment  '景点信息表',
  primary key(id)
);


drop table  if exists  AUTO_BUILD_WIDGET;
create table AUTO_BUILD_WIDGET(
  widget_Id varchar(100),
  id  varchar(100),
  type  varchar(100) comment  '控件的类型',
  html_ID  varchar(100) comment  'html的主键',
  descript  varchar(200) comment  '描述',
  width varchar(10),
  height varchar(10),
  validate varchar(1000) comment  '校验',  
  css varchar(1000) comment  'css属性',
  position_Left varchar(1000),
  position_Top varchar(1000),
  selfJson  varchar(500) comment  '空间自己的json相关属性',
  param1 varchar(1000) comment  '扩展属性1',
  param2 varchar(1000) comment  '扩展属性2',
  param3 varchar(1000) comment  '扩展属性3',
  param4 varchar(1000) comment  '扩展属性4',
  param5 varchar(1000) comment  '扩展属性5',
  param6 varchar(1000) comment  '扩展属性6',
  param7 varchar(1000) comment  '扩展属性7',
  param8 varchar(1000) comment  '扩展属性8',
  param9 varchar(1000) comment  '扩展属性9',
  param_big1 TEXT NULL ,
  primary key(widget_Id)
)ENGINE=InnoDB   DEFAULT CHARSET=utf8;  



----操作步骤

drop table  if exists  Auto_Operate_Setp;

create table Auto_Operate_Setp(
  id  varchar(50),
  auto_setp_id varchar(40) comment  '当前步骤编号',
  type  varchar(100) comment  '步骤类型', 
  name  varchar(200) comment  '步骤名称',
  parent_id  varchar(40) comment  '父节点Id',
  descript  varchar(200) comment  '描述',  
  param1 varchar(100) comment  '扩展属性1',	
  param2 varchar(100) comment  '扩展属性2',
  param3 varchar(100) comment  '扩展属性3',
  param4 varchar(100) comment  '扩展属性4',
  param5 varchar(100) comment  '扩展属性5',
  param6 varchar(100) comment  '扩展属性6',
  param7 varchar(100) comment  '扩展属性7',
  param8 varchar(100) comment  '扩展属性8',
  param9 varchar(100) comment  '扩展属性9',
  html_id varchar(40) comment  '生成页面外键',
  primary key(id)          
);




//登录后台工作流 
//insert into Auto_Operate_Setp(id,html_id,type,name,param1,param2,param3) values('bbb1','page222','FindSingleDateOperate','获取用户vo','com.mana.autoBuild.tableVO.UserInfoTableVO','UserInfoTableVOResult','loginName');
//insert into Auto_Operate_Setp(id,html_id,type,name,param1,param2,param3,param4,param5) values('bbb2','page222','EqualOperate','判断密码是否相等','EqualOperateResult','UserInfoTableVOResult.password','password','登录成功页面','登录失败页面');
//insert into Auto_Operate_Setp(id,html_id,type,name,param1) values('bbb3','page222','PageMove','登录成功页面','loginSuccess.html');
//insert into Auto_Operate_Setp(id,html_id,type,name,param1) values('bbb4','page222','PageMove','登录失败页面','loginError.html');

//投票后台工作流

//页面信息表
CREATE TABLE `auto_build_html` (
	`id` VARCHAR(50) NOT NULL DEFAULT '',
	`name` VARCHAR(200) NULL DEFAULT '',
	`top_menu_id` VARCHAR(50) NULL DEFAULT '',
	`leftMenu_id` VARCHAR(50) NULL DEFAULT '',
	`html_ID` VARCHAR(100) NULL DEFAULT NULL,
	`onload1` VARCHAR(200) NULL DEFAULT NULL,
	`onload2` VARCHAR(200) NULL DEFAULT NULL,
	`only_Div` VARCHAR(1) NULL DEFAULT NULL,
	`description` VARCHAR(200) NULL DEFAULT NULL,	
	`project_Id` TEXT(200) NULL,
	PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;



//sql 生成所用到的表  

//sql复合语句 主表
drop table   if exists  COMPOUND_SQL; 
create table COMPOUND_SQL (
  id  char(50),  
  compound_sql_id char(200)  comment  '复合sql的主建',
  description char(200) comment  '描述',
  build_sql VARCHAR (2000) comment  '最后生成的sql',
  primary key(id)
);

//sql复合语句 中的表名集合
drop table   if exists  COMPOUND_SQL_TABLE; 
create table COMPOUND_SQL_TABLE(
  id  varchar(50),  
  compound_sql_id varchar(200) comment  '复合sql的主建',
  table_name  varchar(100)  comment  '表名',
  table_name_ails  varchar(100)  comment  '表名的别名',
  description varchar(200) comment  '描述',
  primary key(id)
); 


--sql复合语句 中的 条件类型集合
drop table   if exists  COMPOUND_SQL_WHERE; 
create table COMPOUND_SQL_WHERE(
  id  varchar(50),
  compound_sql_id varchar(200) comment  '复合sql的主建',
  WHERE_TYPE varchar(50)    comment  '条件类型 是like and or ...',
  Param1_Type    varchar(50)   comment  '属性1的类型',
  Param2_Type    varchar(50)   comment  '属性2的类型',
  PARAM1   varchar(100)     comment  '扩展属性1',
  PARAM2   varchar(100)     comment  '扩展属性2',
  PARAM3   varchar(100)     comment  '扩展属性3',
  description varchar(200) comment  '描述',
  primary key(id)
);



--sql复合语句 中的 显示集合 
drop table   if exists  COMPOUND_SQL_SHOW; 
create table  COMPOUND_SQL_SHOW(
  id  varchar(50),
  compound_sql_id varchar(200) comment  '复合sql的主建',
  table_name_ails  varchar(100)  comment  '对应查询条件中，表的别名 ',
  table_column     varchar(100)  comment  '对应查询条件中，表的列 ',
  description varchar(100) comment  '描述',
  primary key(id)
);

--sql复合语句 中的 排序集合 
drop table   if exists  COMPOUND_SQL_ORDER; 
create table COMPOUND_SQL_ORDER(
  id  varchar(50),
  compound_sql_id varchar(200) comment  '复合sql的主建',
  table_name_ails  varchar(100)  comment  '对应查询条件中，表的别名 ',
  table_column     varchar(100)  comment  '对应查询条件中，表的列 ',
  order_type varchar(100)  comment  '升序还是降序 ',
  description varchar(100) comment  '描述',
  primary key(id)
);
---累加SQL区域
ALTER TABLE `test`.`auto_build_widget` ADD COLUMN `validate` VARCHAR(1000) NULL  AFTER `param9` ;




---------------------权限-------------------------------
drop table   if exists  auto_security_intercept; 
CREATE TABLE `auto_security_intercept` (
	`id` VARCHAR(50) NOT NULL DEFAULT '',
	`name` VARCHAR(200) NULL DEFAULT NULL,
	`project_id` VARCHAR(100) NULL DEFAULT NULL,	
	`html_id` VARCHAR(200) NULL DEFAULT NULL,
	`ajax_id` VARCHAR(200) NULL DEFAULT NULL,
	`role_id` VARCHAR(200) NULL DEFAULT NULL,
	`url` VARCHAR(200) NULL DEFAULT NULL,
	`description` VARCHAR(200) NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
)

drop table   if exists  auto_security_role; 
CREATE TABLE `auto_security_role` (
	`id` VARCHAR(50) NOT NULL DEFAULT '',
	`name` VARCHAR(200) NULL DEFAULT NULL,
	`operate_setp_id` VARCHAR(100) NULL DEFAULT NULL,
	`description` VARCHAR(200) NULL DEFAULT NULL,
	`project_id` VARCHAR(200) NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
)



--------------------------------自助模版--------------------------------------
--模版原型表
CREATE TABLE `selfhelp_templet_prototype` (
	`id` VARCHAR(100) NULL DEFAULT NULL,
	`type` VARCHAR(100) NULL DEFAULT NULL COMMENT '模版种类',
   `descript` VARCHAR(200) NULL DEFAULT NULL COMMENT '描述',
	`location_Json` VARCHAR(200) NULL DEFAULT NULL COMMENT '位置说明',	
	PRIMARY KEY (`id`)
)


--模版表
drop table  if exists  selfhelp_templet ;
CREATE TABLE `selfhelp_templet` (
	`id` VARCHAR(100) NULL DEFAULT NULL,
	`project_id` VARCHAR(200) NULL DEFAULT NULL COMMENT '归属工程',
	`type` VARCHAR(100) NULL DEFAULT NULL COMMENT '模版种类',
    `descript` VARCHAR(200) NULL DEFAULT NULL COMMENT '描述',
	`location_Json` VARCHAR(200) NULL DEFAULT NULL COMMENT '位置说明',	
	PRIMARY KEY (`id`)
)



--自定义模版模块原型表
drop table  if exists  selfhelp_templet_module_prototype ;
CREATE TABLE `selfhelp_templet_module_prototype` (
	`id` VARCHAR(100) NULL DEFAULT NULL,
	`type` VARCHAR(100) NULL DEFAULT NULL COMMENT '模版种类',
	`myclass` VARCHAR(100) NULL DEFAULT NULL COMMENT '实现类',
	`descript` VARCHAR(200) NULL DEFAULT NULL COMMENT '描述',
	`module_area_id` VARCHAR(200) NULL DEFAULT NULL COMMENT '模版区域',
	`module_area_location` VARCHAR(200) NULL DEFAULT NULL COMMENT '模版位置',	
	`width` TEXT NULL DEFAULT NULL COMMENT '宽',
	`height` TEXT NULL DEFAULT NULL COMMENT '高',
	`param1` TEXT NULL DEFAULT NULL COMMENT '配置参数1',   
	`param2` TEXT NULL DEFAULT NULL COMMENT '配置参数1',   
	`param3` TEXT  NULL DEFAULT NULL COMMENT '配置参数1',   
	`param4` TEXT NULL DEFAULT NULL COMMENT '配置参数1',   
	`param5` TEXT NULL DEFAULT NULL COMMENT '配置参数1',   
	`param6` TEXT NULL DEFAULT NULL COMMENT '配置参数1',   
	`param7` TEXT NULL DEFAULT NULL COMMENT '配置参数1',   
	`param8` TEXT NULL DEFAULT NULL COMMENT '配置参数1',   
	`param9` TEXT NULL DEFAULT NULL COMMENT '配置参数1',   
	`param10` TEXT NULL DEFAULT NULL COMMENT '配置参数1',
	`extparam1` TEXT NULL DEFAULT NULL COMMENT '配置参数1',
	`extparam2` TEXT NULL DEFAULT NULL COMMENT '配置参数1',
	`extparam3` TEXT NULL DEFAULT NULL COMMENT '配置参数1',
	`extparam4` TEXT NULL DEFAULT NULL COMMENT '配置参数1',
	`extparam5` TEXT NULL DEFAULT NULL COMMENT '配置参数1',
	`extparam6` TEXT NULL DEFAULT NULL COMMENT '配置参数1',
	`extparam7` TEXT NULL DEFAULT NULL COMMENT '配置参数1',
	`extparam8` TEXT NULL DEFAULT NULL COMMENT '配置参数1',
	`extparam9` TEXT NULL DEFAULT NULL COMMENT '配置参数1',
	`extparam10` TEXT NULL DEFAULT NULL COMMENT '配置参数1',	
	`selfhelp_templet_id` VARCHAR(200) NULL DEFAULT NULL COMMENT '归属模版',   
	`module_contain_id` VARCHAR(200) NULL DEFAULT NULL COMMENT '归属模版',   			
	`module_contain_location` VARCHAR(200) NULL DEFAULT NULL COMMENT '在模版中位置',   	
	PRIMARY KEY (`id`)
)


--模块的中间表
drop table  if exists  selfhelp_templet_module ;
CREATE TABLE `selfhelp_templet_module` (
	`id` VARCHAR(100) NULL DEFAULT NULL,
	`type` VARCHAR(100) NULL DEFAULT NULL COMMENT '模版种类',
	`descript` VARCHAR(200) NULL DEFAULT NULL COMMENT '描述',
	`width` VARCHAR(200) NULL DEFAULT NULL COMMENT '宽',
	`height` VARCHAR(200) NULL DEFAULT NULL COMMENT '高',   
	`param1` TEXT NULL DEFAULT NULL COMMENT '配置参数1',   
	`param2` TEXT NULL DEFAULT NULL COMMENT '配置参数1',   
	`param3` TEXT NULL DEFAULT NULL COMMENT '配置参数1',   
	`param4` TEXT NULL DEFAULT NULL COMMENT '配置参数1',   
	`param5` TEXT NULL DEFAULT NULL COMMENT '配置参数1',   
	`param6` TEXT NULL DEFAULT NULL COMMENT '配置参数1',   
	`param7` TEXT NULL DEFAULT NULL COMMENT '配置参数1',   
	`param8` TEXT NULL DEFAULT NULL COMMENT '配置参数1',   
	`param9` TEXT NULL DEFAULT NULL COMMENT '配置参数1',   
	`param10` TEXT NULL DEFAULT NULL COMMENT '配置参数1',
	`extparam1` TEXT NULL DEFAULT NULL COMMENT '扩展配置参数1',
	`extparam2` TEXT NULL DEFAULT NULL COMMENT '扩展配置参数1',
	`extparam3` TEXT NULL DEFAULT NULL COMMENT '扩展配置参数1',
	`extparam4` TEXT NULL DEFAULT NULL COMMENT '扩展配置参数1',
	`extparam5` TEXT NULL DEFAULT NULL COMMENT '扩展配置参数1',
	`extparam6` TEXT NULL DEFAULT NULL COMMENT '扩展配置参数1',
	`extparam7` TEXT NULL DEFAULT NULL COMMENT '扩展配置参数1',
	`extparam8` TEXT NULL DEFAULT NULL COMMENT '扩展配置参数1',
	`extparam9` TEXT NULL DEFAULT NULL COMMENT '扩展配置参数1',
	`extparam10` TEXT NULL DEFAULT NULL COMMENT '配置参数1',
	`project_Id` VARCHAR(200) NULL DEFAULT NULL COMMENT '归属工程',
	`selfhelp_templet_id` VARCHAR(200) NULL DEFAULT NULL COMMENT '归属模版',
	`module_contain_id` VARCHAR(200) NULL DEFAULT NULL COMMENT '归属模版',   			
	`module_contain_location` VARCHAR(200) NULL DEFAULT NULL COMMENT '在模版中位置',   			
	PRIMARY KEY (`id`)
)




---------------------------------投票业务--------------------------------------
DROP TABLE IF EXISTS vote_people;  
	create table vote_people(
	  id  varchar(100),
	  number   varchar(100) comment  '编号',
	  name  varchar(100) comment  '名字',
	  password  varchar(100) comment  '密码',
	  primary key(id)
	) ENGINE=InnoDB   DEFAULT CHARSET=utf8;  

-----------------------------------服务器业务-----------------------
	
DROP TABLE IF EXISTS cloud_iaas_server ;
CREATE TABLE `cloud_iaas_server` (
	`id` VARCHAR(50) NOT NULL DEFAULT '',
	`name` VARCHAR(500) NULL DEFAULT NULL,
	`ip` VARCHAR(10) NULL DEFAULT NULL,
	`password` VARCHAR(50) NULL DEFAULT NULL,
	`username` VARCHAR(50) NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
)

	
	
DROP TABLE IF EXISTS cloud_iaas_application ;
create table cloud_iaas_application (
  id  varchar(50),  
  name  varchar(500),
  operate_type  varchar(500),
	param1 varchar(500),
	param2 varchar(500),
	param3 varchar(500),
	param4 varchar(500),
	param5 varchar(500),
	param6 varchar(500),
	param7 varchar(500),
	param8 varchar(500),
	param9 varchar(500),
  primary key(id)
);


insert into cloud_iaas_server  values("1","name1","192.168.45.147","root","jd07gm09");
insert into cloud_iaas_server  values('2','name1','192.168.45.214','root','jd07gm09');
insert into cloud_iaas_server  values('3','name1','192.168.45.215','root','jd07gm09');
/*
insert into cloud_iaas_server(id,name,ip,password,username)
values('1','testServer','192.168.136.139','root','1q2w3e');
*/