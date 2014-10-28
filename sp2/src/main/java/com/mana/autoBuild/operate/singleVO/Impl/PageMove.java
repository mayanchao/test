package com.mana.autoBuild.operate.singleVO.Impl;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;
import com.mana.autoBuild.operate.singleVO.DecorationSingleVO;
import com.mana.autoBuild.tableVO.AutoOperateSetpVO;
import com.mana.base.tools.workflow.WorkFlowUtil;

/**
 * 负责跳转url 的vo
 * @author Administrator
 * 
 */
public class PageMove implements  DecorationSingleVO {

	/** 日志对象 */
	static Log logger = LogFactory.getLog(PageMove.class);

	@Override
	public Object decorateVO(BaseAutoBuildVO vo,Map map) {
		AutoOperateSetpVO autoOperateSetp = (AutoOperateSetpVO)vo;
		String page1 = autoOperateSetp.getParam1();
		HttpServletResponse response = (HttpServletResponse) map.get("response");
		try {
		//	response.sendRedirect(page1);
			ServletOutputStream out =response.getOutputStream();
			out.write(   ("{\"page\":\"" + page1 + "\"}").getBytes());
			out.flush();
			//输出到了界面，开始结束工作流
			map.put(WorkFlowUtil.WORK_FLOW_GOTO, "end");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}


