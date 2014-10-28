package com.mana.web.project.cloud.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;
import com.mana.autoBuild.tableVO.CloudIaasServerVO;
import com.mana.base.tools.sql.DateBaseOperateUtil;
import com.mana.base.web.BaseActionClass;
import com.mana.web.project.cloud.service.impl.CloudTopApplication;
import com.mana.web.project.cloud.util.CloudUtil;
import com.mana.web.project.cloud.vo.CgroupConfigVO;
import com.mana.web.project.login.service.LoginService;


public class MyAction extends BaseActionClass{

	static Log logger = LogFactory.getLog(MyAction.class);
	
//	@Autowired
	public LoginService loginService = findService(LoginService.class);
//	public LoginService loginService = null;

	
	//http://localhost:8080/web/project/cloud/action/MyAction_examApplicationExist.do1?applicationIp=192.168.136.139&applicationType=CloudTopApplication
	public ModelAndView examApplicationExist(HttpServletRequest request,HttpServletResponse response ){
		String applicationIp = request.getParameter("applicationIp");
		String linuxResult = CloudUtil.runCommanByServer(applicationIp, CloudUtil.COMMAND_PS_EF);
		String applicationType = request.getParameter("applicationType");
		CloudTopApplication cta = CloudUtil.findApplication(applicationType);
		boolean re = cta.exam(linuxResult);
		return null;
		
	}



	
	
	//http://localhost:8080/web/project/cloud/action/MyAction_buildCloudRun.do1?applicationIp=192.168.136.139&applicationType=CloudTopApplication
	public ModelAndView buildCloudRun(HttpServletRequest request,HttpServletResponse response ){
		System.out.println("111111111111111111111111111");
		//获取到应用名称
		String applicationType = request.getParameter("applicationType");
		String groupTaskId = request.getParameter("groupTaskId");
//		CloudIaasApplicationVO cloudIaasApplicationVO = CloudUtil.findApplicationByType(applicationType);
		
		//根据IP获取到机器的信息
		String applicationIp = request.getParameter("applicationIp");
		CloudIaasServerVO cs = new CloudIaasServerVO();
		cs.setIp(applicationIp);
		CloudIaasServerVO  cloudIaasServerVO = (CloudIaasServerVO)DateBaseOperateUtil.jdbcSelectSingleOperate(cs);
		
		//保存应用信息
		CloudUtil.addApplicationToTask(applicationType,cloudIaasServerVO,"/cgroup/cpu/" + groupTaskId );
		//调用应用的构建方法
		
		//返回构建结果
		
		return null;
	}
	
	
	//http://localhost:8080/web/project/cloud/action/MyAction_findCloudGroup.do1?applicationIp=192.168.136.139
	public ModelAndView findCloudGroup(HttpServletRequest request,HttpServletResponse response ){
		//从服务器获取配置信息 
		
		String applicationIp = request.getParameter("applicationIp");
		CloudIaasServerVO cs = new CloudIaasServerVO();
		cs.setIp(applicationIp);
		CloudIaasServerVO  cloudIaasServerVO = (CloudIaasServerVO)DateBaseOperateUtil.jdbcSelectSingleOperate(cs);		
		String linuxResult = CloudUtil.runCommanByServer(cloudIaasServerVO.getIp(), CloudUtil.COMMAND_group_config);
		Map<String,CgroupConfigVO> map =  CloudUtil.buildCloudInfo(linuxResult);//分析服务器的组配置文件
		return buildJsonModelAndView(map);
	}
	
	
	//http://localhost:8080/web/project/cloud/action/MyAction_findCloudApplicationList.do1
	public ModelAndView findCloudApplicationList(HttpServletRequest request,HttpServletResponse response ){
		//从服务器获取配置信息
		
		return buildJsonModelAndView(CloudUtil.applicationInterface);
	}
	
	//http://localhost:8080/web/project/cloud/action/MyAction_buildCgroupSave.do1
	public ModelAndView buildCgroupSave(HttpServletRequest request,HttpServletResponse response ){
		System.out.println("init  .............");
		Map<String,Map> groups = new HashMap<String,Map>();//组信息
		 Set  set=new HashSet();
		
		Enumeration  ea = request.getParameterNames();
		
		
		//最后生成组信息 
		StringBuffer finalConfig = new StringBuffer();
		finalConfig.append("" +
				"mount { \n" +
				"	cpuset	= /cgroup/cpuset;\n"  +
				 "	cpu	= /cgroup/cpu;\n"  +
				 "	cpuacct	= /cgroup/cpuacct;\n" +
				 "	memory	= /cgroup/memory;\n" +
				 "	devices	= /cgroup/devices;\n" +
				 "	freezer	= /cgroup/freezer;\n" +
				 "	net_cls	= /cgroup/net_cls;\n"+ 
				 "	blkio	= /cgroup/blkio;\n" + 
	 		"}\n" );	 
		
		
		
		String endStr = "";//组信息最后的结束大括号 
		StringBuffer cpuStr = new StringBuffer();
		StringBuffer memoryStr = new StringBuffer();
		StringBuffer bilokStr = new StringBuffer();
		
		String userperm = 
		"perm {\n" +
		"	task {\n" +
		"	uid = root;\n" +
		"	gid = root;\n" +
		"}\n" +
		"admin {\n" +
		"	uid = root;\n" +
		"	gid = root;\n" +
		"	}\n" +
		"}\n" ;
		//先把复合条件的组属性挑选出来 
		List paramsList = new ArrayList();
		while(ea.hasMoreElements()){
			String keyName = "" + ea.nextElement();
			if(keyName.indexOf(".") > 0){
				paramsList.add(keyName);
			}
		}
		//排序
		 Collections.sort(paramsList);
		 
		 paramsList.add("end.end");
		 
		 
		for(int i=0;i<paramsList.size();i++){
			System.out.println("value= " + paramsList.get(i));
		}
		
		//第一遍循环先生成组信息
		for(int i=0;i<paramsList.size();i++){	
			String keyName = "" + paramsList.get(i);
			
			if(keyName.indexOf(".") > 0){
				String[] params =  keyName.split("\\.");
				String groupName = params[0];//组名
				//判断是不是组名 
				if( set.contains(groupName)==false){//需要开了新的一个组
						
					if(endStr.length()>0){//证明已经收集了属性信息，开始写数据
						if(cpuStr.length()>0){
							finalConfig.append("cpu { \n");
							finalConfig.append(" " + cpuStr.toString());
							finalConfig.append("} \n");
						}
						if(memoryStr.length()>0){
							finalConfig.append("memory { \n");
							finalConfig.append(" " + memoryStr.toString());
							finalConfig.append("} \n");
						}	
						if(bilokStr.length()>0){
							finalConfig.append("bilok { \n");
							finalConfig.append(" " + bilokStr.toString());
							finalConfig.append("} \n");
						}	
						
						cpuStr = new StringBuffer();
						memoryStr = new StringBuffer();
						bilokStr = new StringBuffer();
					}
					finalConfig.append(endStr + "\n");//添加组名
					
					if(keyName.equals("end.end")==false){
						finalConfig.append("group " + groupName + " {\n");//添加组名
						finalConfig.append( userperm );//添加组名					
						endStr ="}";					}	
					set.add(groupName);
				}
				if("cpu".equals(params[1])){
					cpuStr.append( "  " + params[1] + "." + params[2] +  "=" + request.getParameter(keyName) + ";\n"  );
				}else if("memory".equals(params[1])){
					memoryStr.append( "  " +  params[1] + "." + params[2] +  "=" + request.getParameter(keyName)  + ";\n"  );					
				}else if("bilok".equals(params[1])){
					bilokStr.append( "  " +  params[1] + "." + params[2] +  "=" + request.getParameter(keyName)  + ";\n"  );
				}
			}
		}		
		System.out.println( "echo '" + finalConfig.toString() + "' >/etc/cgconfig.conf"  );
		
		
		String applicationIp = request.getParameter("applicationIp");		
		String linuxResult = CloudUtil.runCommanByServer(applicationIp, "echo '" + finalConfig.toString() + "' >/etc/cgconfig.conf" );
		//重启cgroup服务 
		linuxResult = CloudUtil.runCommanByServer(applicationIp, "/etc/init.d/cgconfig restart" );
		
		
		System.out.println(linuxResult);
		return null;
		
	}
	//cloud_iaas_server
	
	//http://localhost/web/project/cloud/action/MyAction_findCloudIaasServerLists.do1
	public ModelAndView findCloudIaasServerLists(HttpServletRequest request,HttpServletResponse response ){
		
//		CloudIaasServerVO autoBuildVO = new CloudIaasServerVO();
//		List<BaseAutoBuildVO> list = DateBaseOperateUtil.jdbcSelectMultitermOperate(autoBuildVO);
		System.out.println("cccccccccccccc");
		return buildJsonModelAndView(CloudUtil.issaServers);
	}
	
	public void addString(String chuan,int lengt,char c){
		int len = chuan.length();
		 
	}
	
}
