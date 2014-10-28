-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.1.32-community - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win32
-- HeidiSQL 版本:                  8.0.0.4396
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出  表 test.auto_build_html 结构
DROP TABLE IF EXISTS `auto_build_html`;
CREATE TABLE IF NOT EXISTS `auto_build_html` (
  `id` char(50) NOT NULL DEFAULT '',
  `html_ID` varchar(100) DEFAULT NULL,
  `onload1` varchar(200) DEFAULT NULL,
  `onload2` varchar(200) DEFAULT NULL,
  `only_Div` varchar(1) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  test.auto_build_html 的数据：~13 rows (大约)
DELETE FROM `auto_build_html`;
/*!40000 ALTER TABLE `auto_build_html` DISABLE KEYS */;
INSERT INTO `auto_build_html` (`id`, `html_ID`, `onload1`, `onload2`, `only_Div`, `description`) VALUES
	('', '中文', NULL, NULL, NULL, NULL),
	('2014061110241244d6e70a8822e04b3ca7dd37f49acd655a', 'null', NULL, NULL, NULL, NULL),
	('20140611102428798ddf42d82f18f42a0b52ee4530ffdb139', 'null', NULL, NULL, NULL, NULL),
	('20140611102533844658916e8a53e4fd692c34f426904ac48', 'null', NULL, NULL, NULL, NULL),
	('20140611102554683076ea218987540c0aaa5ba3d9e34144c', 'null', NULL, NULL, NULL, NULL),
	('20140611171808318f580ad22e020439188f36d334396cede', '', '', '', '0', '								\n								'),
	('2014061117183622093d192423a3a407489d0a6ca45f540a9', 'abc123', '', '', '0', '								\n								'),
	('201406120856182483cbf973eaacd4e6a9565b7fd9576b3ea', 'abc456', NULL, NULL, NULL, NULL),
	('2014061211114788762819e00959845a28ba7b2c3d19a70ab', 'abc444', NULL, NULL, NULL, NULL),
	('2014061221385114a3fca13420cf4b0b99cefa1bb5ec2318', 'mod1', '', '', '1', ''),
	('201406132034059733d400f48a9064771a78593d88562fa4a', 'add1', '', '', '1', ''),
	('2014061722294200f7cc0207c2f74b64bb09d1cfbdc7b9d2', 'sencerManager', NULL, NULL, NULL, NULL),
	('20140617230329812c51d2aadeaa5440c8d03dcd1fffb0cf8', 'sencerAdd', NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `auto_build_html` ENABLE KEYS */;


-- 导出  表 test.auto_build_widget 结构
DROP TABLE IF EXISTS `auto_build_widget`;
CREATE TABLE IF NOT EXISTS `auto_build_widget` (
  `widget_Id` varchar(50) NOT NULL DEFAULT '',
  `id` varchar(100) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL COMMENT '控件的类型',
  `html_ID` varchar(100) DEFAULT NULL COMMENT 'html的主键',
  `descript` varchar(200) DEFAULT NULL COMMENT '描述',
  `width` varchar(1000) DEFAULT NULL,
  `height` varchar(1000) DEFAULT NULL,
  `validate` varchar(1000) DEFAULT NULL COMMENT '校验',
  `position_Left` varchar(1000) DEFAULT NULL,
  `position_Top` varchar(1000) DEFAULT NULL,
  `selfJson` varchar(500) DEFAULT NULL COMMENT '空间自己的json相关属性',
  `param1` varchar(2000) DEFAULT NULL,
  `param2` varchar(1000) DEFAULT NULL COMMENT '扩展属性2',
  `param3` varchar(1000) DEFAULT NULL COMMENT '扩展属性3',
  `param4` varchar(1000) DEFAULT NULL COMMENT '扩展属性4',
  `param5` varchar(1000) DEFAULT NULL COMMENT '扩展属性5',
  `param6` varchar(1000) DEFAULT NULL COMMENT '扩展属性6',
  `param7` varchar(1000) DEFAULT NULL COMMENT '扩展属性7',
  `param8` varchar(1000) DEFAULT NULL COMMENT '扩展属性8',
  `param9` varchar(1000) DEFAULT NULL COMMENT '扩展属性9',
  PRIMARY KEY (`widget_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  test.auto_build_widget 的数据：~40 rows (大约)
DELETE FROM `auto_build_widget`;
/*!40000 ALTER TABLE `auto_build_widget` DISABLE KEYS */;
INSERT INTO `auto_build_widget` (`widget_Id`, `id`, `type`, `html_ID`, `descript`, `width`, `height`, `validate`, `position_Left`, `position_Top`, `selfJson`, `param1`, `param2`, `param3`, `param4`, `param5`, `param6`, `param7`, `param8`, `param9`) VALUES
	('20140611172222599a9b0b3679f8f45e98187b509613dac62', 'buildId_abc123_14024785396631', 'globalFunction.autoBuild_html_text_label', 'abc123', NULL, '100', '100', NULL, '58', '422', NULL, '文本1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	('201406111723388182b209dcb206d4ebb8b77c0680ccd0ad5', NULL, 'globalFunction.autoBuild_html_table_sampleTable', 'abc123', NULL, '400', '200', NULL, '61', '449', NULL, '["{\\"columnName\\":\\"列名\\",\\"columnWidth\\":\\"140\\",\\"columnLoad\\":\\"{\\\\\\"columnName\\\\\\":\\\\\\"ddd\\\\\\",\\\\\\"methodName\\\\\\":\\\\\\"globalToolsTableColumnTextDraw\\\\\\"}\\",\\"methodName\\":\\"globalToolsTableColumnTextDraw\\"}","{\\"columnName\\":\\"列名\\",\\"columnWidth\\":\\"140\\",\\"columnLoad\\":\\"{\\\\\\"columnName\\\\\\":\\\\\\"333\\\\\\",\\\\\\"methodName\\\\\\":\\\\\\"globalToolsTableColumnTextDraw\\\\\\"}\\",\\"methodName\\":\\"globalToolsTableColumnTextDraw\\"}"]', 'eee', '', NULL, NULL, NULL, NULL, NULL, NULL),
	('201406111724322816907be9a9bb242bf8f1db51773e01298', 'buildId_abc123_14024786683013', 'globalFunction.autoBuild_html_text_label', 'abc123', NULL, '100', '100', NULL, '77', '383', NULL, '文本1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	('20140612085618196800bd2169712496b8dd9eb5319a750f9', NULL, 'globalFunction.autoBuild_html_table_sampleTable', 'abc456', NULL, '400', '200', NULL, '108', '175', NULL, '["{\\"columnName\\":\\"编号\\",\\"columnWidth\\":\\"140\\",\\"columnLoad\\":\\"{\\\\\\"columnName\\\\\\":\\\\\\"number\\\\\\",\\\\\\"methodName\\\\\\":\\\\\\"globalToolsTableColumnTextDraw\\\\\\"}\\",\\"methodName\\":\\"globalToolsTableColumnTextDraw\\"}","{\\"columnName\\":\\"名字\\",\\"columnWidth\\":\\"140\\",\\"columnLoad\\":\\"{\\\\\\"columnName\\\\\\":\\\\\\"name\\\\\\",\\\\\\"methodName\\\\\\":\\\\\\"globalToolsTableColumnTextDraw\\\\\\"}\\",\\"methodName\\":\\"globalToolsTableColumnTextDraw\\"}"]', '/web/singleTable/action/SingleTableAction_findTable.do1?singleTableName=VotePeopleVO&tableJson={}', '', NULL, NULL, NULL, NULL, NULL, NULL),
	('201406120901164891dddf9b790149c9a66808dfd988fac8', 'buildId_abc456_14025348687822', 'globalFunction.autoBuild_html_input_button', 'abc456', NULL, '20', '20', NULL, '569', '442.97918701171875', NULL, '按钮', 'null', 'null', 'null', 'null', 'null', NULL, NULL, NULL),
	('2014061209251864335f4d508bfb74432818bee3a5cc20ada', 'buildId_abc456_14025351105253', 'globalFunction.autoBuild_communication_ajax', 'abc456', '', NULL, NULL, NULL, '125', '468.97918701171875', NULL, '/web/singleTable/action/SingleTableAction_deleteTable.do1?singleTableName=VotePeopleVO', NULL, NULL, NULL, 'autoBuild_html_ajax_beforeCall_myCallBeforeSimpleFindValue', '', '', '', NULL),
	('201406121111478557c8813a014a744329b8efa1d3cfc4ada', NULL, 'globalFunction.autoBuild_html_table_sampleTable', 'abc444', NULL, '400', '200', NULL, '37', '108', NULL, '["{\\"columnName\\":\\"列名\\",\\"columnWidth\\":\\"140\\",\\"columnLoad\\":\\"{\\\\\\"columnName\\\\\\":\\\\\\"number\\\\\\",\\\\\\"methodName\\\\\\":\\\\\\"globalToolsTableColumnTextDraw\\\\\\"}\\",\\"methodName\\":\\"globalToolsTableColumnTextDraw\\"}","{\\"columnName\\":\\"列名\\",\\"columnWidth\\":\\"140\\",\\"columnLoad\\":\\"{\\\\\\"columnName\\\\\\":\\\\\\"delete\\\\\\",\\\\\\"click\\\\\\":\\\\\\"globalCommonAjaxbuildId_abc444_14025452972492\\\\\\",\\\\\\"myIds\\\\\\":\\\\\\"\\\\\\",\\\\\\"methodName\\\\\\":\\\\\\"globalToolsTableColumnButtonDrawById\\\\\\"}\\",\\"methodName\\":\\"globalToolsTableColumnButtonDrawById\\"}","{\\"columnName\\":\\"列名\\",\\"columnWidth\\":\\"140\\",\\"columnLoad\\":\\"{\\\\\\"columnName\\\\\\":\\\\\\"modify\\\\\\",\\\\\\"click\\\\\\":\\\\\\"globalDialogbuildId_abc444_14026533743944\\\\\\",\\\\\\"myIds\\\\\\":\\\\\\"\\\\\\",\\\\\\"methodName\\\\\\":\\\\\\"globalToolsTableColumnButtonDrawById\\\\\\"}\\",\\"methodName\\":\\"globalToolsTableColumnButtonDrawById\\"}","{\\"columnName\\":\\"列名\\",\\"columnWidth\\":\\"140\\",\\"columnLoad\\":\\"{\\\\\\"columnName\\\\\\":\\\\\\"name\\\\\\",\\\\\\"methodName\\\\\\":\\\\\\"globalToolsTableColumnTextDraw\\\\\\"}\\",\\"methodName\\":\\"globalToolsTableColumnTextDraw\\"}"]', '/web/singleTable/action/SingleTableAction_findTable.do1?singleTableName=VotePeopleVO&tableJson={}', '', NULL, NULL, NULL, NULL, NULL, NULL),
	('20140612115524515cd3a704b23a54ebebeb85bf139c69395', 'buildId_abc444_14025452972492', 'globalFunction.autoBuild_communication_ajax', 'abc444', '', NULL, NULL, NULL, '24', '364.66668701171875', NULL, '/web/singleTable/action/SingleTableAction_deleteTable.do1?singleTableName=VotePeopleVO', NULL, NULL, NULL, 'myCallBeforeBuildTableJson', '', 'myCallBackRefreshCurrentPage', 'myCallBackRefreshCurrentPage', NULL),
	('20140612213850952ef51fb4baf8d4ec1a194abaed426b243', 'buildId_mod1_14025802947501', 'globalFunction.autoBuild_html_input_text', 'mod1', NULL, '20', '10', '', '112', '76', NULL, '', '10', 'number', NULL, NULL, NULL, NULL, NULL, NULL),
	('20140612213850971d3ed4b00262746679e872233827e78d0', 'buildId_mod1_14025803003902', 'globalFunction.autoBuild_html_input_text', 'mod1', NULL, '20', '10', '', '108', '113', NULL, '', '10', 'name', NULL, NULL, NULL, NULL, NULL, NULL),
	('201406122138509836d631ca6b3f1442f98130f021705551b', 'buildId_mod1_14025803072143', 'globalFunction.autoBuild_html_input_text', 'mod1', NULL, '20', '10', '', '110', '39', NULL, '', '10', 'id', NULL, NULL, NULL, NULL, NULL, NULL),
	('201406122138509953fdd1a1ae2324fff8c961f0c4ebd4acb', 'buildId_mod1_14025803216074', 'globalFunction.autoBuild_html_input_button', 'mod1', NULL, '20', '20', NULL, '66', '147', NULL, '保存', 'globalCommonAjaxbuildId_mod1_14025813146388', 'null', 'null', 'null', 'null', NULL, NULL, NULL),
	('20140612214001140fac61aa9e1cd4297a5ec8e400831e8ad', 'buildId_mod1_14025803620555', 'globalFunction.autoBuild_html_text_label', 'mod1', NULL, '100', '100', NULL, '29', '83', NULL, '编号', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	('20140612214001152da90bf8863d44085baec1b93f6d8852d', 'buildId_mod1_14025803766796', 'globalFunction.autoBuild_html_text_label', 'mod1', NULL, '100', '100', NULL, '29', '117.66667175292969', NULL, '姓名', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	('20140612214001165c9c02c51b9a7468b821f81f49a1192b5', 'buildId_mod1_14025803899507', 'globalFunction.autoBuild_html_text_label', 'mod1', NULL, '100', '100', NULL, '26', '43.333335876464844', NULL, '主键', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	('201406122155262144accf4a115074bfea314fdc5f394b695', 'buildId_mod1_14025813146388', 'globalFunction.autoBuild_communication_ajax', 'mod1', '', NULL, NULL, NULL, '25', '219', NULL, '/web/singleTable/action/SingleTableAction_update.do1?singleTableName=VotePeopleVO', NULL, NULL, NULL, 'autoBuild_html_ajax_beforeCall_myCallBeforeSimpleFindValue', '{"ids":"buildId_mod1_14025802947501,buildId_mod1_14025803003902,buildId_mod1_14025803072143","click":"","resultHandler":"tableJson","methodName":""}', 'myCallBackRefreshCurrentPage', 'myCallBackRefreshCurrentPage', NULL),
	('20140613175624186840e356dc6cf41eeaa36a7c7516cf1e8', 'buildId_abc444_14026533743944', 'globalFunction.autoBuild_html_dialogPanel_dialogSimple', 'abc444', NULL, '300', '250', NULL, '24', '431', NULL, '/autoBuild/public/autoWidget/mod1.html', '修改', '', 'none', 'autoBuild_html_ajax_afterCall_myCallBackSimpleSetValue', '{"ids":"buildId_mod1_14025802947501,buildId_mod1_14025803003902,buildId_mod1_14025803072143"}', NULL, NULL, NULL),
	('20140613203200104e4978b124d2b4f4081d3c0b6943ea020', 'buildId_abc444_14026627100875', 'globalFunction.autoBuild_html_image_img', 'abc444', NULL, '100', '100', NULL, '183', '1.3333333730697632', NULL, 'http://localhost:8080/image/gril/gril2.jpg', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	('201406132034058667b4e5b35d6fd42d4b0fcc2413b68748f', 'buildId_add1_14026628091901', 'globalFunction.autoBuild_html_input_text', 'add1', NULL, '20', '10', '', '101', '35', NULL, '', '10', 'number', NULL, NULL, NULL, NULL, NULL, NULL),
	('20140613203405905b0ffebe150544b929fd6d7d0c5273155', 'buildId_add1_14026628209342', 'globalFunction.autoBuild_html_input_text', 'add1', NULL, '20', '10', '', '95', '72', NULL, '', '10', 'name', NULL, NULL, NULL, NULL, NULL, NULL),
	('20140613203405935369af5b275224e7490370f33d724fd1b', 'buildId_add1_14026628263983', 'globalFunction.autoBuild_html_text_label', 'add1', NULL, '100', '100', NULL, '11', '30', NULL, '编号', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	('2014061320340595574dca6471249491da5262faaf93ab4cc', 'buildId_add1_14026628377174', 'globalFunction.autoBuild_html_text_label', 'add1', NULL, '100', '100', NULL, '12', '96.66667175292969', NULL, '姓名', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	('201406132035146026e96f518ef084d2692db1bab6c9548a2', 'buildId_add1_14026628973835', 'globalFunction.autoBuild_html_input_button', 'add1', NULL, '20', '20', NULL, '102', '131.33334350585938', NULL, '保存', 'globalCommonAjaxbuildId_add1_14026629097836', 'null', 'null', 'null', 'null', NULL, NULL, NULL),
	('20140613203514614e34e24366dc24771981300e768aaa779', 'buildId_add1_14026629097836', 'globalFunction.autoBuild_communication_ajax', 'add1', '', NULL, NULL, NULL, '11', '192.33334350585938', NULL, '/web/singleTable/action/SingleTableAction_save.do1?singleTableName=VotePeopleVO', NULL, NULL, NULL, 'autoBuild_html_ajax_beforeCall_myCallBeforeSimpleFindValue', '{"ids":"buildId_add1_14026628091901,buildId_add1_14026628209342","click":"","resultHandler":"tableJson","methodName":""}', 'myCallBackRefreshCurrentPage', 'myCallBackRefreshCurrentPage', NULL),
	('201406132039053946077f9cec70f4abbb3aacd0460059616', 'buildId_abc444_14026630695835', 'globalFunction.autoBuild_html_dialogPanel_dialogSimple', 'abc444', NULL, '250', '200', NULL, '24', '509', NULL, '/autoBuild/public/autoWidget/add1.html', '添加', '', '', 'none', '', NULL, NULL, NULL),
	('201406132039423847c5dd3c7e8a24521acf60664d26e4495', 'buildId_abc444_14026631576486', 'globalFunction.autoBuild_html_input_button', 'abc444', NULL, '20', '20', NULL, '74', '76.33333587646484', NULL, '添加', 'globalDialogbuildId_abc444_14026630695835', 'null', 'null', 'null', 'null', NULL, NULL, NULL),
	('201406172303294530359f7fa8540475bb904a4898d272145', 'buildId_sencerAdd_14030169834901', 'globalFunction.autoBuild_html_text_label', 'sencerAdd', NULL, '100', '100', NULL, '18', '47', NULL, '名字', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	('2014061723032964036985f25ff754ceba4d50fa9159added', 'buildId_sencerAdd_14030169851212', 'globalFunction.autoBuild_html_text_label', 'sencerAdd', NULL, '100', '100', NULL, '14', '136', NULL, '状态', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	('201406172303296716b536b241109448594ba1c0f9cb450ed', 'buildId_sencerAdd_14030170054743', 'globalFunction.autoBuild_html_input_text', 'sencerAdd', NULL, '20', '10', '', '105', '44', NULL, '', '10', 'name', NULL, NULL, NULL, NULL, NULL, NULL),
	('201406172303296872ff0c8aeb8c54394b31276cf0747951f', 'buildId_sencerAdd_14030173755024', 'globalFunction.autoBuild_html_input_text', 'sencerAdd', NULL, '20', '10', '', '104', '121', NULL, '', '10', 'state', NULL, NULL, NULL, NULL, NULL, NULL),
	('201406172313107188f97991d38614a0f8e20b521eb435505', 'buildId_sencerAdd_14030174144055', 'globalFunction.autoBuild_html_input_button', 'sencerAdd', NULL, '20', '20', NULL, '90', '267', NULL, '保存', 'globalCommonAjaxbuildId_sencerAdd_14030179002096', 'null', 'null', 'null', 'null', NULL, NULL, NULL),
	('20140617231310765081709a8f5df494fb678c046b4f60edc', 'buildId_sencerAdd_14030179002096', 'globalFunction.autoBuild_communication_ajax', 'sencerAdd', '', NULL, NULL, NULL, '19', '331', NULL, '/web/singleTable/action/SingleTableAction_save.do1?singleTableName=SceneryVO', NULL, NULL, NULL, 'autoBuild_html_ajax_beforeCall_myCallBeforeSimpleFindValue', '{"ids":"buildId_sencerAdd_14030170054743,buildId_sencerAdd_14030173755024,buildId_sencerAdd_14031009915818","click":"","resultHandler":"tableJson","methodName":""}', 'none', 'none', NULL),
	('201406172344058907502f9acfbdb42e789dbf2716d6fd505', NULL, 'globalFunction.autoBuild_html_table_sampleTable', 'sencerManager', NULL, '400', '200', NULL, '7', '70', NULL, '["{\\"columnName\\":\\"景点名称\\",\\"columnWidth\\":\\"140\\",\\"columnLoad\\":\\"{\\\\\\"columnName\\\\\\":\\\\\\"name\\\\\\",\\\\\\"methodName\\\\\\":\\\\\\"globalToolsTableColumnTextDraw\\\\\\"}\\",\\"methodName\\":\\"globalToolsTableColumnTextDraw\\"}","{\\"columnName\\":\\"状态\\",\\"columnWidth\\":\\"140\\",\\"columnLoad\\":\\"{\\\\\\"columnName\\\\\\":\\\\\\"state\\\\\\",\\\\\\"methodName\\\\\\":\\\\\\"globalToolsTableColumnTextDraw\\\\\\"}\\",\\"methodName\\":\\"globalToolsTableColumnTextDraw\\"}","{\\"columnName\\":\\"列名\\",\\"columnWidth\\":\\"140\\",\\"columnLoad\\":\\"{\\\\\\"columnName\\\\\\":\\\\\\"delete\\\\\\",\\\\\\"click\\\\\\":\\\\\\"globalCommonAjaxbuildId_sencerManager_14030205876714\\\\\\",\\\\\\"myIds\\\\\\":\\\\\\"\\\\\\",\\\\\\"methodName\\\\\\":\\\\\\"globalToolsTableColumnButtonDrawById\\\\\\"}\\",\\"methodName\\":\\"globalToolsTableColumnButtonDrawById\\"}","{\\"columnName\\":\\"次数\\",\\"columnWidth\\":\\"140\\",\\"columnLoad\\":\\"{\\\\\\"columnName\\\\\\":\\\\\\"theCount\\\\\\",\\\\\\"methodName\\\\\\":\\\\\\"globalToolsTableColumnTextDraw\\\\\\"}\\",\\"methodName\\":\\"globalToolsTableColumnTextDraw\\"}","{\\"columnName\\":\\"列名\\",\\"columnWidth\\":\\"140\\",\\"columnLoad\\":\\"{\\\\\\"columnName\\\\\\":\\\\\\"投票\\\\\\",\\\\\\"click\\\\\\":\\\\\\"globalCommonAjaxbuildId_sencerManager_14031078513916\\\\\\",\\\\\\"myIds\\\\\\":\\\\\\"\\\\\\",\\\\\\"methodName\\\\\\":\\\\\\"globalToolsTableColumnButtonDrawById\\\\\\"}\\",\\"methodName\\":\\"globalToolsTableColumnButtonDrawById\\"}"]', '/web/singleTable/action/SingleTableAction_findTable.do1?singleTableName=SceneryVO&tableJson={}', '', NULL, NULL, NULL, NULL, NULL, NULL),
	('20140617234531578d2871afc41f741188a6438659286d12f', 'buildId_sencerManager_14030198661722', 'globalFunction.autoBuild_html_input_button', 'sencerManager', NULL, '20', '20', NULL, '26', '304', NULL, '添加', 'globalDialogbuildId_sencerManager_14030199021423', 'null', 'null', 'null', 'null', NULL, NULL, NULL),
	('201406172345315938a62dbec895f4eeea6680b3615bf5aa8', 'buildId_sencerManager_14030199021423', 'globalFunction.autoBuild_html_dialogPanel_dialogSimple', 'sencerManager', NULL, '500', '400', NULL, '22', '340', NULL, '/autoBuild/public/autoWidget/sencerAdd.html', '', '', '', 'none', '', NULL, NULL, NULL),
	('201406172359345462e463b4db5f74f239ace2e424e0883e2', 'buildId_sencerManager_14030205876714', 'globalFunction.autoBuild_communication_ajax', 'sencerManager', '删除Ajax', NULL, NULL, NULL, '23', '403', NULL, '/web/singleTable/action/SingleTableAction_deleteTable.do1?singleTableName=SceneryVO', NULL, NULL, NULL, 'myCallBeforeBuildTableJson', '', 'none', 'none', NULL),
	('20140618222700203118a2491b77b4cf99e5fd5635630ad90', 'buildId_sencerAdd_14031009788777', 'globalFunction.autoBuild_html_text_label', 'sencerAdd', NULL, '100', '100', NULL, '16', '199', NULL, '次数', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	('20140618222700218a4f98f460a704491bed43fe447046c27', 'buildId_sencerAdd_14031009915818', 'globalFunction.autoBuild_html_input_text', 'sencerAdd', NULL, '20', '10', '[{"name":"newRule","type":"autoBuild_html_validate_isNumber","numberType":"int"}]', '101', '189', NULL, '', '10', 'theCount', NULL, NULL, NULL, NULL, NULL, NULL),
	('201406182240305931a7e0c9e18604a14814a1883f023c4f6', 'buildId_sencerManager_14031024142395', 'globalFunction.autoBuild_html_input_button', 'sencerManager', NULL, '20', '20', NULL, '28', '467', NULL, '投票', 'null', 'null', 'null', 'null', 'null', NULL, NULL, NULL),
	('2014061900115168775e0fba727544e939266bbbe02410ce5', 'buildId_sencerManager_14031078513916', 'globalFunction.autoBuild_communication_ajax', 'sencerManager', '', NULL, NULL, NULL, '24', '507', NULL, '/web/back/action/BackSAutoetpOperateAction_executeWorkflow.do1?autoSetpId=voteScenery&id=(_id_)', NULL, NULL, NULL, 'none', '', 'myCallBackRefreshCurrentPage', 'myCallBackRefreshCurrentPage', NULL);
/*!40000 ALTER TABLE `auto_build_widget` ENABLE KEYS */;


-- 导出  表 test.auto_operate_setp 结构
DROP TABLE IF EXISTS `auto_operate_setp`;
CREATE TABLE IF NOT EXISTS `auto_operate_setp` (
  `id` varchar(50) NOT NULL DEFAULT '',
  `auto_setp_id` varchar(40) DEFAULT NULL COMMENT '当前步骤编号',
  `type` varchar(100) DEFAULT NULL COMMENT '步骤类型',
  `name` varchar(200) DEFAULT NULL COMMENT '步骤名称',
  `parent_id` varchar(40) DEFAULT NULL COMMENT '父节点Id',
  `descript` varchar(200) DEFAULT NULL COMMENT '描述',
  `param1` varchar(100) DEFAULT NULL COMMENT '扩展属性1',
  `param2` varchar(100) DEFAULT NULL COMMENT '扩展属性2',
  `param3` varchar(100) DEFAULT NULL COMMENT '扩展属性3',
  `param4` varchar(100) DEFAULT NULL COMMENT '扩展属性4',
  `param5` varchar(100) DEFAULT NULL COMMENT '扩展属性5',
  `param6` varchar(100) DEFAULT NULL COMMENT '扩展属性6',
  `param7` varchar(100) DEFAULT NULL COMMENT '扩展属性7',
  `param8` varchar(100) DEFAULT NULL COMMENT '扩展属性8',
  `param9` varchar(100) DEFAULT NULL COMMENT '扩展属性9',
  `html_id` varchar(40) DEFAULT NULL COMMENT '生成页面外键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  test.auto_operate_setp 的数据：~10 rows (大约)
DELETE FROM `auto_operate_setp`;
/*!40000 ALTER TABLE `auto_operate_setp` DISABLE KEYS */;
INSERT INTO `auto_operate_setp` (`id`, `auto_setp_id`, `type`, `name`, `parent_id`, `descript`, `param1`, `param2`, `param3`, `param4`, `param5`, `param6`, `param7`, `param8`, `param9`, `html_id`) VALUES
	('2014061617342770785f83b99ad744e6f8158114a59081f56', 'setpVote', 'FindSingleDateFromRequestOperate', 'setp1', '', NULL, 'com.mana.autoBuild.tableVO.VotePeopleVO', 'myVotePeopleFromRequest', 'name,password', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	('20140616173427710f4f6f20e93ed41df8ef274d0683c8aa5', 'setpVote', 'FindSingleDateOperate', 'setp2', 'setp1', NULL, 'myVotePeopleFromRequest', 'myVotePeopleFromDB', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	('20140616173427711fcd1d84f257142c6a880d5c5de5c6e3d', 'setpVote', 'SessionInputOperate', 'setp4', 'setp3', '', 'myVotePeopleFromDB', 'mySession', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	('201406161734277135b399668ac86463fbc357f810aba63ba', 'setpVote', 'PageMove', 'loginError', 'setp3', NULL, 'www.sina.com', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	('20140616173427714500c6f54511d4b8ea962fec060550d2c', 'setpVote', 'EqualOperate', 'setp3', 'setp2', NULL, 'myVotePeopleFromRequest.password', 'myVotePeopleFromDB.password', 'setp4', 'loginError', NULL, NULL, NULL, NULL, NULL, NULL),
	('2014061617342776097eab48c3d3946a9b1fe0f5bb4166c38', 'setpVote', 'PageMove', 'loginSuccess', 'setp4', NULL, 'www.baidu.com', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	('2014061900050029659848eae10bf49498e62217cbe9ba2c2', 'voteScenery', 'NumberOperate', 'countAdd', 'findSceneryFromDB', NULL, 'SceneryFromDB', 'theCount', '1', 'add', NULL, NULL, NULL, NULL, NULL, NULL),
	('20140619000500296640231e503c94044b560d61af349219f', 'voteScenery', 'UpdateSingleDateOperate', 'saveScenery', 'countAdd', '', 'SceneryFromDB', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	('20140619000500296d6f9c748e5a04b489f233f6c2b3dbc17', 'voteScenery', 'FindSingleDateOperate', 'findSceneryFromDB', 'findSceneryFromRequest', NULL, 'SceneryRequest', 'SceneryFromDB', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	('20140619000500296f8ba825a4f884efb955cce2e83bf3b5e', 'voteScenery', 'FindSingleDateFromRequestOperate', 'findSceneryFromRequest', '', NULL, 'com.mana.autoBuild.tableVO.SceneryVO', 'SceneryRequest', 'id', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `auto_operate_setp` ENABLE KEYS */;


-- 导出  表 test.compound_sql 结构
DROP TABLE IF EXISTS `compound_sql`;
CREATE TABLE IF NOT EXISTS `compound_sql` (
  `id` char(50) NOT NULL DEFAULT '',
  `compound_sql_id` char(200) DEFAULT NULL COMMENT '复合sql的主建',
  `description` char(200) DEFAULT NULL COMMENT '描述',
  `build_sql` varchar(2000) DEFAULT NULL COMMENT '最后生成的sql',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  test.compound_sql 的数据：~1 rows (大约)
DELETE FROM `compound_sql`;
/*!40000 ALTER TABLE `compound_sql` DISABLE KEYS */;
INSERT INTO `compound_sql` (`id`, `compound_sql_id`, `description`, `build_sql`) VALUES
	('2014061800325734365d280c882544f9786276c4ead3b27d3', 'sql6', NULL, NULL);
/*!40000 ALTER TABLE `compound_sql` ENABLE KEYS */;


-- 导出  表 test.compound_sql_order 结构
DROP TABLE IF EXISTS `compound_sql_order`;
CREATE TABLE IF NOT EXISTS `compound_sql_order` (
  `id` char(50) NOT NULL DEFAULT '',
  `compound_sql_id` char(200) DEFAULT NULL COMMENT '复合sql的主建',
  `table_name_ails` char(100) DEFAULT NULL COMMENT '对应查询条件中，表的别名 ',
  `table_column` char(100) DEFAULT NULL COMMENT '对应查询条件中，表的列 ',
  `order_type` char(100) DEFAULT NULL COMMENT '升序还是降序 ',
  `description` char(100) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  test.compound_sql_order 的数据：~0 rows (大约)
DELETE FROM `compound_sql_order`;
/*!40000 ALTER TABLE `compound_sql_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `compound_sql_order` ENABLE KEYS */;


-- 导出  表 test.compound_sql_show 结构
DROP TABLE IF EXISTS `compound_sql_show`;
CREATE TABLE IF NOT EXISTS `compound_sql_show` (
  `id` char(50) NOT NULL DEFAULT '',
  `compound_sql_id` char(200) DEFAULT NULL COMMENT '复合sql的主建',
  `table_name_ails` char(100) DEFAULT NULL COMMENT '对应查询条件中，表的别名 ',
  `table_column` char(100) DEFAULT NULL COMMENT '对应查询条件中，表的列 ',
  `description` char(100) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  test.compound_sql_show 的数据：~0 rows (大约)
DELETE FROM `compound_sql_show`;
/*!40000 ALTER TABLE `compound_sql_show` DISABLE KEYS */;
/*!40000 ALTER TABLE `compound_sql_show` ENABLE KEYS */;


-- 导出  表 test.compound_sql_table 结构
DROP TABLE IF EXISTS `compound_sql_table`;
CREATE TABLE IF NOT EXISTS `compound_sql_table` (
  `id` varchar(50) NOT NULL DEFAULT '',
  `compound_sql_id` varchar(200) DEFAULT NULL COMMENT '复合sql的主建',
  `table_name` varchar(100) DEFAULT NULL COMMENT '表名',
  `table_name_ails` varchar(100) DEFAULT NULL COMMENT '表名的别名',
  `description` varchar(200) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  test.compound_sql_table 的数据：~0 rows (大约)
DELETE FROM `compound_sql_table`;
/*!40000 ALTER TABLE `compound_sql_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `compound_sql_table` ENABLE KEYS */;


-- 导出  表 test.compound_sql_where 结构
DROP TABLE IF EXISTS `compound_sql_where`;
CREATE TABLE IF NOT EXISTS `compound_sql_where` (
  `id` char(15) NOT NULL DEFAULT '',
  `compound_sql_id` char(200) DEFAULT NULL COMMENT '复合sql的主建',
  `WHERE_TYPE` char(50) DEFAULT NULL COMMENT '条件类型 是like and or ...',
  `Param1_Type` char(50) DEFAULT NULL COMMENT '属性1的类型',
  `Param2_Type` char(50) DEFAULT NULL COMMENT '属性2的类型',
  `PARAM1` char(100) DEFAULT NULL COMMENT '扩展属性1',
  `PARAM2` char(100) DEFAULT NULL COMMENT '扩展属性2',
  `PARAM3` char(100) DEFAULT NULL COMMENT '扩展属性3',
  `description` char(200) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  test.compound_sql_where 的数据：~0 rows (大约)
DELETE FROM `compound_sql_where`;
/*!40000 ALTER TABLE `compound_sql_where` DISABLE KEYS */;
/*!40000 ALTER TABLE `compound_sql_where` ENABLE KEYS */;


-- 导出  表 test.people_scenery_interface 结构
DROP TABLE IF EXISTS `people_scenery_interface`;
CREATE TABLE IF NOT EXISTS `people_scenery_interface` (
  `id` varchar(50) NOT NULL DEFAULT '',
  `vote_people_id` varchar(100) DEFAULT NULL,
  `scenery_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  test.people_scenery_interface 的数据：~0 rows (大约)
DELETE FROM `people_scenery_interface`;
/*!40000 ALTER TABLE `people_scenery_interface` DISABLE KEYS */;
/*!40000 ALTER TABLE `people_scenery_interface` ENABLE KEYS */;


-- 导出  表 test.scenery 结构
DROP TABLE IF EXISTS `scenery`;
CREATE TABLE IF NOT EXISTS `scenery` (
  `id` varchar(50) NOT NULL DEFAULT '',
  `name` varchar(500) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  `the_count` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  test.scenery 的数据：~3 rows (大约)
DELETE FROM `scenery`;
/*!40000 ALTER TABLE `scenery` DISABLE KEYS */;
INSERT INTO `scenery` (`id`, `name`, `state`, `the_count`) VALUES
	('20140618222818875cc94748cde2f4721a32eecaad251bf1b', 'e', 'e', '4'),
	('20140618223227781713edd1c195e4873b2aee98ca84d42e0', 'ff', 'd', '1'),
	('201406182236597186b1b75a991d84052a41aac519602c985', 'ac', 'aa', '0');
/*!40000 ALTER TABLE `scenery` ENABLE KEYS */;


-- 导出  表 test.user_info 结构
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE IF NOT EXISTS `user_info` (
  `id` char(15) NOT NULL DEFAULT '',
  `login_name` char(40) DEFAULT NULL,
  `name` char(45) DEFAULT NULL,
  `age` char(10) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `address` char(20) DEFAULT NULL,
  `password` char(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  test.user_info 的数据：~1 rows (大约)
DELETE FROM `user_info`;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` (`id`, `login_name`, `name`, `age`, `sex`, `address`, `password`) VALUES
	('id111', 'abc', '凌志林', NULL, NULL, NULL, '123456');
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;


-- 导出  表 test.user_vote 结构
DROP TABLE IF EXISTS `user_vote`;
CREATE TABLE IF NOT EXISTS `user_vote` (
  `id` char(15) NOT NULL DEFAULT '',
  `feature_Name` char(100) DEFAULT NULL,
  `status` char(20) DEFAULT NULL,
  `count` char(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  test.user_vote 的数据：~11 rows (大约)
DELETE FROM `user_vote`;
/*!40000 ALTER TABLE `user_vote` DISABLE KEYS */;
INSERT INTO `user_vote` (`id`, `feature_Name`, `status`, `count`) VALUES
	('a1', '泰山', '1', '0'),
	('a2', '长城', '1', '0'),
	('a3', '故宫', '1', '1'),
	('a4', '天安门', '1', '1'),
	('a5', '颐和园', '1', '1'),
	('a6', '北海', '1', '1'),
	('a7', '八达岭', '1', '1'),
	('a8', '十三陵', '1', '1'),
	('a9', '动物园', '1', '1'),
	('aa1', '新世界', '1', '1'),
	('aa2', '大栅栏', '1', '1');
/*!40000 ALTER TABLE `user_vote` ENABLE KEYS */;


-- 导出  表 test.user_vote_info_combine 结构
DROP TABLE IF EXISTS `user_vote_info_combine`;
CREATE TABLE IF NOT EXISTS `user_vote_info_combine` (
  `id` char(15) NOT NULL DEFAULT '',
  `User_Info_id` char(100) DEFAULT NULL COMMENT '用户信息表',
  `User_VOTE_id` char(100) DEFAULT NULL COMMENT '景点信息表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  test.user_vote_info_combine 的数据：~0 rows (大约)
DELETE FROM `user_vote_info_combine`;
/*!40000 ALTER TABLE `user_vote_info_combine` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_vote_info_combine` ENABLE KEYS */;


-- 导出  表 test.vote_people 结构
DROP TABLE IF EXISTS `vote_people`;
CREATE TABLE IF NOT EXISTS `vote_people` (
  `id` varchar(100) NOT NULL DEFAULT '',
  `number` varchar(100) DEFAULT NULL COMMENT '编号',
  `name` varchar(100) DEFAULT NULL COMMENT '名字',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  test.vote_people 的数据：~6 rows (大约)
DELETE FROM `vote_people`;
/*!40000 ALTER TABLE `vote_people` DISABLE KEYS */;
INSERT INTO `vote_people` (`id`, `number`, `name`, `password`) VALUES
	('1', '888', 'name1', '123456'),
	('2', '456', 'name2', '123456'),
	('20140613210333464749429d10f22452b99434bc317627f07', 'a', '4', '123456'),
	('201406132103596605d76b1ff0ca849a69378c4b1cdd540f8', 'vv', '11', '123456'),
	('201406132112006659ac858ff41724608b2bf4e141a1b821e', '1', 'ä¸­', '123456'),
	('20140613211844317c47acb9564c84bd7b65e7b157bb22733', '33', '2', '123456');
/*!40000 ALTER TABLE `vote_people` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
