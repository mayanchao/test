package com.mana.autoBuild.daoVO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import com.mana.autoBuild.tableVO.AutoSecurityRoleVO;
import com.mana.base.tools.sql.DateBaseOperateUtil;
import com.mana.base.tools.sql.SqlUtil;
import com.mana.base.web.singleTable.page.PageInfo;


/**
 *  底层自动构建vo类，用来构建 增删查改的sql语句生成  
 * @author mayc
 *
 */
public abstract class BaseAutoBuildVO {
	
	public Map<String,Object> sqlParam = new LinkedHashMap<String,Object>();
	
	public static  final String autoBuildBasePath = "com.mana.autoBuild.tableVO.";
	
	public 	 String  orderBy191233;
	
	//分页属性
	public void setOrderBy191233(String orders){
		orderBy191233 = orders;
	}
	
	
	/**
	 * 生成插入语句
	 * @return
	 */
	public SqlVO buildInsertSql(){
		
		StringBuilder frontsb = new StringBuilder(   "insert into " + currentTable() + "(");		
		Iterator<String> its= sqlParam.keySet().iterator();
		//先加入主键名称
		while(its.hasNext()){
			String key = its.next();
			frontsb.append(  key  + "," );
		}
//		frontsb.delete(frontsb.length()-1,frontsb.length());
		
		frontsb.append(currentKeyName());
		frontsb.append(")  ");
		
		//加入主键的值
		putKeyValue(buildKeyValue());
		sqlParam.put(currentKeyName(), findKeyValue());//把主键值放入param中，
		//在insert 语句最后加入value(?,?,?)
		frontsb.append( SqlUtil.buildInsertPiex(sqlParam.size() -1  ));
		
		String sql =  frontsb.toString();//根据参数生成inserl语句
		SqlVO sqlVO = new SqlVO(sql,sqlParam.values().toArray()); //插入语句，把主键放入value
		return sqlVO;
	}
	
	/**
	 * 构建更新的sql
	 * @return
	 */
	public SqlVO buildUpdateSqlByKey(){
		//更新操作先清除主键值
		sqlParam.remove(currentKeyName());
		StringBuffer frontsb = new StringBuffer("update " + currentTable() + " set ");
		Iterator<String> its= sqlParam.keySet().iterator();		
		while(its.hasNext()){
			String key = its.next();
			frontsb.append(key + "=? ," );
		}
		frontsb = new StringBuffer(frontsb.substring(0,frontsb.length()-1));//去掉尾部的逗号
		frontsb.append( " where ");
		frontsb.append( currentKeyName() + "=?" ); //根据主键更新
		sqlParam.put(currentKeyName(), findKeyValue());//把主键值放入param中，
		SqlVO sqlVO = new SqlVO(frontsb.toString(),sqlParam.values().toArray()); //插入语句，把主键放入value
		return sqlVO;
	}
	/**
	 * 删除数据库主键
	 * @return
	 */
	public SqlVO buildDeleteSqlByKey(){
		//更新操作先清除主键值
		sqlParam.remove(currentKeyName());
		StringBuffer frontsb = new StringBuffer("delete from  " + currentTable() + " where ");
		frontsb.append( currentKeyName() + "=?" ); //根据主键更新
		System.out.println(frontsb.toString());
		Object[] para= {this.findKeyValue()};
		SqlVO sqlVO = new SqlVO(frontsb.toString(),para);
		return sqlVO;
	}
	
	/**
	 * 删除数据库主键
	 * @return
	 */
	public SqlVO buildDeleteSqlByWhere(){
		//更新操作先清除主键值
		sqlParam.remove(currentKeyName());
		StringBuffer frontsb = new StringBuffer("delete from  " + currentTable() + " where ");
		Iterator<String> its= sqlParam.keySet().iterator();
		while(its.hasNext()){
			String key = its.next();
			frontsb.append(key + "=? and " );
		}
		frontsb = new StringBuffer(frontsb.substring(0,frontsb.length() - 4));//去掉尾部的逗号
		
		SqlVO sqlVO = new SqlVO(frontsb.toString(),sqlParam.values().toArray());
		return sqlVO;
	}
	
	/**
	 * 根据主键获取 拼写 单条语句  查询语句 
	 * @return
	 */
	public SqlVO buildGeyVOByKey(){
		StringBuilder sqlsb = new StringBuilder("select * from ");
		sqlsb.append(this.currentTable());
		sqlsb.append(" where ");
		sqlsb.append(this.currentKeyName() + "=?");
		if(orderBy191233!=null){//有排序字段				
			sqlsb.append( "  order by " + orderBy191233);			
		}
		Object[] para= {this.findKeyValue()};
		SqlVO sqlVO = new SqlVO(sqlsb.toString(),para);
		return sqlVO;
	}
	
	/**
	 * 根据 当前vo中的参数，生成查询语句 查处多条记录   
	 * @return
	 */
	public SqlVO buildGeyVOByParam(PageInfo pageInfo){
		StringBuilder sqlsb = new StringBuilder("select * from ");
		sqlsb.append(this.currentTable());
		sqlsb.append(" where 1=1 ");
		
		Iterator<String> its= sqlParam.keySet().iterator();		
		while(its.hasNext()){
			String key = its.next();
			sqlsb.append( " and  " + key + "=?  " );
		}
		Object[] para=  sqlParam.values().toArray() ;
		//判断是否有分页
		if(pageInfo!=null){
			int mylimit = Integer.parseInt(pageInfo.getPageLimit1316() ) *Integer.parseInt( pageInfo.getPageOffset1316() );
			sqlsb.append(" limit " +  mylimit   + "," + pageInfo.getPageLimit1316() );
		}
		
		if(orderBy191233!=null){//有排序字段				
			sqlsb.append( "  order by " + orderBy191233);			
		}
		System.out.println("sql = " + sqlsb.toString());
		SqlVO sqlVO = new SqlVO(sqlsb.toString(),para);
		return sqlVO;
	}
	
	
	
	/*
	 * 根据结果resultSet，转成当前vo值
	 */
	 public abstract BaseAutoBuildVO buildResultSetVO(ResultSet resultSet); 
	
	
	/**
	 * 构建主键ID，类似oracle的sequence 采用UUID方式，生成唯一ID
	 * @return
	 */
	public String buildKeyValue(){
		return DateBaseOperateUtil.buildUUID();
	}
	
	/**
	 * 获取主键ID的值 
	 * @return
	 */
	public  abstract  void putKeyValue(Object key);
	
	/**
	 * 获取主键ID的值 
	 * @return
	 */
	public  abstract  String findKeyValue();
	
	
	/**
	 * 构建表的主键名称
	 * @return
	 */
	public abstract String currentKeyName();
	
	/**
	 * 构建表名称
	 * @return 表名称 
	 */
	public abstract String currentTable();
	
	/**
	 * 出入字段名称，然后给字段自动赋值
	 * @param filedName  字段名 
	 * @param value      要赋值的名字 
	 * @return
	 */
	public abstract boolean autoSet(String filedName,Object value);
	
	
	/**
	 * 根据字段名，返回值的名称  
	 * @param filedName
	 * @return
	 */
	public abstract Object autoGet(String filedName);


	public void setSqlParam(Map<String, Object> sqlParam) {
		System.out.println("set sql param ........................");
		//this.sqlParam = sqlParam;
	}
	
	/**
	 *  
	 * @param resultSet
	 * @param columnName
	 * @return
	 */
	 public  BaseAutoBuildVO buildResultSetVOByColumnName(ResultSet resultSet,String[] columnName){
		 AutoSecurityRoleVO vo = new AutoSecurityRoleVO();
		 for(int i=0;i<columnName.length;i++){
			 try {
				 String value = resultSet.getString(columnName[i]);
				 vo.autoSet(columnName[i], value);					
				} catch (SQLException e) {
					e.printStackTrace();
				}
		 }
		 return vo;
	 }
	 
	
}
