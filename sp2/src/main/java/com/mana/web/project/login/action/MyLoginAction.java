package com.mana.web.project.login.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

import com.mana.autoBuild.tableVO.AutoBuildWidgetVO;
import com.mana.autoBuild.tableVO.UserInfoTableVO;
import com.mana.base.tools.sql.DateBaseOperateUtil;
import com.mana.base.web.BaseActionClass;
import com.mana.web.project.login.service.LoginService;


public class MyLoginAction extends BaseActionClass{

	static Log logger = LogFactory.getLog(MyLoginAction.class);
	
//	@Autowired
	public LoginService loginService = findService(LoginService.class);
//	public LoginService loginService = null;

	public ModelAndView login(HttpServletRequest request,HttpServletResponse response ){		
		ModelAndView n1 = new ModelAndView();
		System.out.println("loginService" + loginService);
//		loginService.login(null);
		return n1;
	}
	
	//http://localhost:8080/project/login/action/MyAction_method2.do?id=100&aa.bs=aa
	public ModelAndView method2(HttpServletRequest request,HttpServletResponse response){		
		ModelAndView n1 = new ModelAndView();
//		System.out.println("action " + loginService);
		UserInfoTableVO vo = new UserInfoTableVO();	
		vo.putKeyValue("20130517092006218e2c9ffdc3b9f41c39ffb677efef215ce");
		vo.setAddress("new address");
		vo.setAge(100);
		vo.setName("name name");
		boolean re = DateBaseOperateUtil.updateByAutoBuildVO(vo); 
//		System.out.println("数据插入结果 " + re );
		return n1;
	}
	
	public ModelAndView testAddUpdateDelete(HttpServletRequest request,HttpServletResponse response ){
		ModelAndView n1 = new ModelAndView();
		UserInfoTableVO vo = new UserInfoTableVO();
		vo.setAddress("address");
		vo.setAge(10);
		vo.setName("name1");
//		vo.setSex(v);
		//插入操作
		String ids = DateBaseOperateUtil.inserByAutoBuildVO(vo);
		
		UserInfoTableVO vo1 = new UserInfoTableVO();
		vo1.putKeyValue("20130517092006218e2c9ffdc3b9f41c39ffb677efef215ce");
		UserInfoTableVO vvo = (UserInfoTableVO) DateBaseOperateUtil.getByKeyID(vo1);
		System.out.println("get key re=" + vvo.getName());
		System.out.println(" insert re=" + ids + "  id=" + vo.findKeyValue());
		
		//更新操作
		boolean re = DateBaseOperateUtil.updateByAutoBuildVO(vo);
		vo.setAddress("new address");
		vo.setAge(10);
		vo.setName("new name");		
		System.out.println(" update re=" + re);
		//删除操作
		re = DateBaseOperateUtil.deleteByAutoBuildVO(vo);
		System.out.println(" delete re=" + re);
		
		
		return n1;
	}
//	//http://localhost:8080/project/login/action/MyAction_autoWidgetAdd.do1?id=100&aa.bs=aa&jsonClassAutoBuildWidgetVO={%22height%22:10,%22htmlID%22:%22id1%22,%22positionLeft%22:0,%22positionTop%22:0,%22selfJson%22:%22{text:'abc'}%22,%22sqlParam%22:{},%22type%22:%22label%22,%22width%22:1000} 
//	public ModelAndView autoWidgetAdd(HttpServletRequest request,HttpServletResponse response,AutoBuildWidgetVO autoBuildWidgetVO ){
//		System.out.println("ok in " + autoBuildWidgetVO);	
//		return buildJsonModelAndView(autoBuildWidgetVO);		
//	}
//	
//	http://localhost:8080/project/login/action/MyAction_autoWidgetAddArrays.do1?id=100&aa.bs=aa&jsonClassList=[{%22height%22:10,%22htmlID%22:%22id1%22,%22positionLeft%22:0,%22positionTop%22:0,%22selfJson%22:%22{text:'abc'}%22,%22sqlParam%22:{},%22type%22:%22label%22,%22width%22:1000},{%22height%22:10,%22htmlID%22:%22id1%22,%22positionLeft%22:0,%22positionTop%22:0,%22selfJson%22:%22{text:'abc'}%22,%22sqlParam%22:{},%22type%22:%22label%22,%22width%22:1000}]
//		              /web/singleTable/action/SingleTableAction_*
	public ModelAndView autoWidgetAddArrays(HttpServletRequest request,HttpServletResponse response,List<AutoBuildWidgetVO> listVO ){
		System.out.println("ok array in " + listVO.size() );	
		//拿到数据了，开始保存 
		
		return buildJsonModelAndView(listVO);
	}
	
}


