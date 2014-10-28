package com.mana.base.tools.tree.vo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;

public class TreeVO {
	
	
    public TreeVO(BaseAutoBuildVO data){
    	this.data = data;
    }

	/** 日志对象 */
	static Log logger = LogFactory.getLog(TreeVO.class);
	
	//数据内容
	public BaseAutoBuildVO data;
	
	//叶节点 
	public List<TreeVO> leafs = new ArrayList();

	public BaseAutoBuildVO getData() {
		return data;
	}

	public void setData(BaseAutoBuildVO data) {
		this.data = data;
	}

	public List<TreeVO> getLeafs() {
		return leafs;
	}

	public void setLeafs(List<TreeVO> leafs) {
		this.leafs = leafs;
	}

	
}


