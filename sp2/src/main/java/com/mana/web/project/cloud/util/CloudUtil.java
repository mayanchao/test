package com.mana.web.project.cloud.util;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;
import com.mana.autoBuild.tableVO.CloudIaasApplicationVO;
import com.mana.autoBuild.tableVO.CloudIaasServerVO;
import com.mana.base.tools.io.ToolsFile;
import com.mana.base.tools.other.OtherUtil;
import com.mana.base.tools.sql.DateBaseOperateUtil;
import com.mana.base.tools.string.StringUtil;
import com.mana.web.project.cloud.service.impl.CloudTopApplication;
import com.mana.web.project.cloud.vo.CgroupConfigVO;

public class CloudUtil {
	
	//应用集合列表
	public static Map<String,CloudTopApplication> applicationInterface= new HashMap<String,CloudTopApplication>();
	//服务集合列表
	public static Map<String,CloudIaasServerVO> issaServers= new HashMap<String,CloudIaasServerVO>();
	
	//获取所有进程命令   COMMAND_PS_EF
	public final static String COMMAND_PS_EF = "ps -ef";
	
	//获取所有进程命令   COMMAND_PS_EF
	public final static String COMMAND_group_config = "cat /etc/cgconfig.conf ";
//	public static Map<String,CloudIaasApplicationVO> applicationTypes= new HashMap<String,CloudIaasApplicationVO>();
	static {
		//读取数据库初始化服务器列表
		CloudIaasServerVO autoBuildVO = new CloudIaasServerVO();
		List list = DateBaseOperateUtil.jdbcSelectMultitermOperate(autoBuildVO);
		for(int i=0;i<list.size();i++){//把所有服务器放入列表中
			CloudIaasServerVO vo = (CloudIaasServerVO)list.get(i);
			issaServers.put(vo.getIp(), vo);
		}
		//初始化map 以后从数据库中读取
		applicationInterface.put("CloudTopApplication", new CloudTopApplication("CloudTopApplication"));
		applicationInterface.put("CloudSarApplication", new CloudTopApplication("CloudSarApplication"));
	}
	
	
	
//	public static CloudIaasApplicationVO findApplicationByType(String applicationType){
//		return applicationTypes.get(applicationType);
//	}
	public static String findApplicationPs(String applicationIp){
		
		
		return "";
	}
	
	
	/**
	 * 根据应用类型，查找应用操作接口
	 */
	public static CloudTopApplication findApplication(String applicationType){
		CloudTopApplication cta = applicationInterface.get(applicationType);
		return cta;
	}
	
	
	public static CloudIaasApplicationVO addApplicationToTask(String applicationType,
															  CloudIaasServerVO  cloudIaasServerVO,
															  String taskName){
		
		String linuxResult = CloudUtil.runCommanByServer(cloudIaasServerVO.getIp(), CloudUtil.COMMAND_PS_EF);
		
		CloudTopApplication cta = findApplication(applicationType);
		String pid = cta.getPid(linuxResult);
		
		cta.addTask(taskName,pid,cloudIaasServerVO);
		
		return null;
	}
	
	//运行服务器命令 
	public static  String runCommanByServer(String applicationIp,String command) {
		//从应用服务器上获取当前进程信息
		CloudIaasServerVO cloudIaasServerVO = new CloudIaasServerVO();
		cloudIaasServerVO.setIp(applicationIp);
		cloudIaasServerVO = (CloudIaasServerVO)DateBaseOperateUtil.jdbcSelectSingleOperate(cloudIaasServerVO);
		//返回所有进程信息
		String linuxResult = OtherUtil.runSshCommand(cloudIaasServerVO.getIp(), cloudIaasServerVO.getUsername(), cloudIaasServerVO.getPassword(), command);
		return linuxResult;
	}
	
	//分析配置文件  参见other/cgroupConfig.conf这个文件
	/**
	 *  读取服务器上的 组信息配置文件 
	 * @param text
	 * @return
	 */
	public static Map<String,CgroupConfigVO> buildCloudInfo(String text){
		 Map<String,CgroupConfigVO> cgroupMap = new HashMap<String,CgroupConfigVO>();
		//先设读取mount配置
		String[] groupInfo = text.split("group ");		
		//group 
		//开始读取分组信息 
		for(int i=1;i<groupInfo.length;i++){
			CgroupConfigVO ccf = new CgroupConfigVO(); 
			 //把组内容分解出来
			String[] groupContext =  groupInfo[i].split("\n");
			//获取组的名字
			groupContext[0] = groupContext[0].replaceAll("\\s", "");
			groupContext[0] = groupContext[0].replaceAll("\\{", "");
			
			String groupName = groupContext[0];//.substring(st1,st2);
	//		ccf.setGroupName(groupName);//设置组名字
			//开始分析组内的属性，然后把属性放入对应的vo中 
			for(int k=0;k<groupContext.length;k++){
				if(  groupContext[k].indexOf("=") > 0  &&  groupContext[k].indexOf("uid") <0  &&  groupContext[k].indexOf("gid") <0 ){
					String[] va =StringUtil.findNameAndValue(  groupContext[k] );
					String value= va[1].replace(";", "");
					
					ccf.getConfigMap().put(va[0], value	);
//					//判断属性的类型，然后加入到对应的map中
//					if(va[0].startsWith("cpu")){ //cpu信息
//						
//					} else if(va[0].startsWith("memory")){ //money信息
//						ccf.getMemoryMap().put(va[0], va[1]);
//					} else if(va[0].startsWith("blkio")){ //money信息
//						ccf.getBlkioMap().put(va[0], va[1]);
//					}
				}
			}
			
			cgroupMap.put(groupName, ccf);
			
		}
		return cgroupMap;
	}
	
	
	public static void main(String[] args) throws Exception {
		byte[] s =FileUtils.readFileToByteArray(new File (ToolsFile.localClasspath + "/other/cgroupConfig.conf"));
		String fin = new String(s);
		CloudUtil.buildCloudInfo(fin);
		
	}
	
	
	
}
















