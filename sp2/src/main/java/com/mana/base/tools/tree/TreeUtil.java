package com.mana.base.tools.tree;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;
import com.mana.autoBuild.tableVO.AutoOperateSetpVO;
import com.mana.base.tools.tree.vo.TreeVO;

public class TreeUtil {

	/** 日志对象 */
	static Log logger = LogFactory.getLog(TreeUtil.class);
	
	
	/**
	 * 根据 list数组，拼装成tree，返回 
	 * @param list 参数必须是 BaseAutoBuildVO ，并且必须有parentId属性，
	 *         程序会根据 parentId对应主键然后生成树
	 * @return
	 */
	public static TreeVO buildTreeFromList(List<BaseAutoBuildVO> list){
		TreeVO root = new TreeVO(null);//根节点
		Map<String,TreeVO> map = new LinkedHashMap<String,TreeVO>();
		//先封装成treeVO 对象的数组 
		for(BaseAutoBuildVO buildVo :list){
			AutoOperateSetpVO aosvo = (AutoOperateSetpVO)buildVo; 
			aosvo.getName();
			System.out.println(" autoGet=====" + (aosvo.getName()));
			map.put("" +aosvo.getName(),new TreeVO(buildVo));
		}
		Iterator<TreeVO> it = map.values().iterator();
		buildTreeList(root, map, it);
		return root;
	}


	public static void buildTreeList(TreeVO root, Map<String, TreeVO> map,
			Iterator<TreeVO> it) {
		while(it.hasNext()){
			TreeVO leftTreeVO = (TreeVO) it.next();
			BaseAutoBuildVO buildVo = leftTreeVO.getData();
			//查找这个叶节点的父节点是谁 
			String parentId =  (String)buildVo.autoGet("parentId");
			if(parentId==null  || "".equals(parentId) ){//代表根节点 直接加入root然后继续循环 
				root.leafs.add(leftTreeVO);
				continue;
			}
			//是叶子节点，需要处理
			TreeVO treeVO = map.get(parentId);
			if(treeVO!=null){
				//把该节点加入父节点的叶子群中				
				treeVO.leafs.add(leftTreeVO);
			}
		}
	}
	
}


