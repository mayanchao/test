package com.mana.base.tools.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;
import com.mana.autoBuild.daoVO.SqlVO;
import com.mana.autoBuild.tableVO.CompoundSqlShowVO;
import com.mana.autoBuild.tableVO.CompoundSqlVO;
import com.mana.base.filter.ApplicationServletInitFilter;
import com.mana.base.tools.other.OtherUtil;
import com.mana.base.tools.string.StringUtil;
import com.mana.base.web.singleTable.page.PageInfo;


/**
 * 数据库基本操作 工具类
 * @author hc360
 *
 */
public class DateBaseOperateUtil {
	
	public static final SimpleDateFormat SDF_YYYY_MM_DD_HH_MM_SS_SS = new SimpleDateFormat("yyyyMMddHHmmssSS");   
	
	
	
	
	/**
	 * 自动生成vo 的插入数据库操作
	 * @param autoBuildVO  插入数据库的vo
	 * @return
	 */
	public static String  inserByAutoBuildVO(BaseAutoBuildVO autoBuildVO ){		
		SqlVO sqlVO = autoBuildVO.buildInsertSql();
		int re = jdbcUpdateOperate(sqlVO);
		System.out.println(" insert into database re=" + re );
		 return autoBuildVO.findKeyValue();		 
	}
	
	
	/**
	 * 自动生成vo 的插入数据库操作
	 * @param autoBuildVO  插入数据库的vo
	 * @return
	 */
	public static boolean updateByAutoBuildVO(BaseAutoBuildVO autoBuildVO ){
		SqlVO sqlVO = autoBuildVO.buildUpdateSqlByKey();
		int re = jdbcUpdateOperate(sqlVO);
		return   re ==1;
	}
	
	/**
	 * 删除数据库
	 * @param sqlVO
	 * @return  返回操作次数
	 */
	public static boolean  deleteByAutoBuildVO(BaseAutoBuildVO autoBuildVO ){
		SqlVO sqlVO = autoBuildVO.buildDeleteSqlByKey();
		int re = jdbcUpdateOperate(sqlVO);
		return   re ==1;
	}
	
	
	/**
	 * 传入存有主键ID的vo 然后根据ID查找到结果，并返回
	 * @param autoBuildVO 有主键的ID ，也同样是返回值
	 * @return 是否找到
	 */
	public static BaseAutoBuildVO  getByKeyID(BaseAutoBuildVO autoBuildVO ){
		SqlVO sqlVO = autoBuildVO.buildGeyVOByKey();		
		return  jdbcSelectSingleOperate(sqlVO,autoBuildVO);
	}
	
	
	public static  BaseAutoBuildVO jdbcSelectSingleOperate(BaseAutoBuildVO autoBuildVO){
		SqlSession session = null;
		try {
			SqlVO sqlVO = autoBuildVO.buildGeyVOByParam(null);//生成select 语句 			
			session = sqlsessioniBuild();
			PreparedStatement prepare =paraseBuild(sqlVO,session);			
			ResultSet resultSet =  prepare.executeQuery();		
			boolean  hashNext = resultSet.next();
			if(hashNext == true){//有返回的结果
				BaseAutoBuildVO vo = autoBuildVO.buildResultSetVO(resultSet);				
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();			
		}finally{
			session.close();
		}
		return null;
	}
	
	/**
	 * 删除单调记录	通过主键方式  
	 * @param autoBuildVO  
	 * @return
	 */
	public static  int jdbcDeleteSingleOperate(BaseAutoBuildVO autoBuildVO){
		SqlSession session = null;
		try {
			SqlVO sqlVO = autoBuildVO.buildDeleteSqlByKey();//生成select 语句 			
			session = sqlsessioniBuild();
			PreparedStatement prepare =paraseBuild(sqlVO,session);			
			int re =  prepare.executeUpdate();
			return re;
//			return 0;
			
		} catch (SQLException e) {
			e.printStackTrace();			
		}finally{
			session.close();
		}
		return 0;
	}
	
	
	
	/**
	 * 删除多条记录	通过条件  
	 * @param autoBuildVO  
	 * @return
	 */
	public static  int jdbcDeleteMultiple(BaseAutoBuildVO autoBuildVO){
		SqlSession session = null;
		try {
			SqlVO sqlVO = autoBuildVO.buildDeleteSqlByWhere();//生成select 语句 			
			session = sqlsessioniBuild();
			PreparedStatement prepare =paraseBuild(sqlVO,session);			
			int re =  prepare.executeUpdate();
			return re;
		} catch (SQLException e) {
			e.printStackTrace();			
		}finally{
			session.close();
		}
		return 0;
	}
	
	
//	
//	/**
//	 * 底层JDBC 选择多条记录
//	 * @param sqlVO
//	 * @return  返回操作次数
//	 */
//	public static  BaseAutoBuildVO[] jdbcSelectSingleOperate(SqlVO sqlVO,BaseAutoBuildVO autoBuildVO){
//	
//	}
	
	/**
	 * 底层JDBC 选择单挑记录
	 * @param sqlVO
	 * @return  返回操作次数
	 */
	public static  BaseAutoBuildVO jdbcSelectSingleOperate(SqlVO sqlVO,BaseAutoBuildVO autoBuildVO){
		SqlSession session = null;
		try {
			session = sqlsessioniBuild();			
			PreparedStatement prepare =paraseBuild(sqlVO,session);			
			ResultSet resultSet =  prepare.executeQuery();
			resultSet.next();
			return autoBuildVO.buildResultSetVO(resultSet);			
		} catch (SQLException e) {
			e.printStackTrace();			
		}finally{
			session.close();
		}
		return null;
	}
	
	
	
//	
//	public static <T> List<T> jdbcSelectMultitermOperate(BaseAutoBuildVO autoBuildVO, T obj) {
//		
//		
//		return null;
//	}
//	
	
	public static  List<BaseAutoBuildVO> jdbcSelectMultitermOperate(BaseAutoBuildVO autoBuildVO){
		return jdbcSelectMultitermOperate(autoBuildVO,null);
	}
	//http://localhost:8080/web/singleTable/action/SingleTableAction_findTable.do1?singleTableName=UserVoteVO&tableJson={%22status%22:%221%22}
	/**
	 * 底层JDBC 选择多条记录
	 * @param sqlVO
	 * @return  返回操作次数
	 */
	public static  List<BaseAutoBuildVO> jdbcSelectMultitermOperate(BaseAutoBuildVO autoBuildVO,PageInfo pageInfo){
		SqlSession session = null;
		try {
			SqlVO sqlVO = autoBuildVO.buildGeyVOByParam(pageInfo);
			sqlVO.setPageInfo(pageInfo);
			session = sqlsessioniBuild();
			PreparedStatement prepare =paraseBuild(sqlVO,session);			
			ResultSet resultSet =  prepare.executeQuery();
			List<BaseAutoBuildVO> list = new ArrayList<BaseAutoBuildVO>();
			while(resultSet.next()){
				BaseAutoBuildVO vo = autoBuildVO.buildResultSetVO(resultSet);
				list.add(vo);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();			
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return null;
	}
	
	/**
	 * 底层JDBC 选择多条记录 直接手工拼装Sql 
	 * @param sqlVO
	 * @return  返回操作次数
	 */
	public static  List<Map<String,String>> jdbcSelectMultitermOperateBySqlVO( SqlVO sqlVO,String[] showParam ){
		SqlSession session = null;
		try {
			session = sqlsessioniBuild();
			PreparedStatement prepare =paraseBuild(sqlVO,session);			
			ResultSet resultSet =  prepare.executeQuery();
			List list = new ArrayList<Map<String,String>>();
			while(resultSet.next()){
				Map map  = new HashMap<String,String>();
				//获取当前属性
				for(int i=0;i<showParam.length;i++){
					String columnName =  "" + showParam[i];
					String value = resultSet.getString("" + showParam[i]);
					map.put(columnName,value );
				}
				list.add(map);
			}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();			
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return null;
	}
	
	
	/**
	 * 底层JDBC 的更新，删除与添加操作
	 * @param sqlVO
	 * @return  返回操作次数
	 */
	public static int  jdbcUpdateOperate(SqlVO sqlVO){
		int re = -1;
		SqlSession session = null;
		try {
			session = sqlsessioniBuild();			
			PreparedStatement prepare =paraseBuild(sqlVO,session);
			re = prepare.executeUpdate();
			session.commit();
		} catch (SQLException e) {
			e.printStackTrace();			
		}finally{
			session.close();
		}
		return re;
	}
	
	
	
/**	
 * 解析类型构建 
 * @param sqlVO
 * @param session
 * @return
 * @throws SQLException
 */
	private static  PreparedStatement paraseBuild(SqlVO sqlVO,SqlSession session) throws SQLException{
		Object[] params = sqlVO.getParams();		
		Connection conn = session.getConnection();
		String sql = sqlVO.getSql();
//		//判断是否有分页 
//		if(sqlVO.getPageInfo()!=null){
		//select * from compound_sql_where where 1=1  and  compound_Sql_Id=? 
//			String limit = sqlVO.getPageInfo().getPageLimit1316();
//			String offset = sqlVO.getPageInfo().getPageOffset1316() ;
//			sql =
//		}
		PreparedStatement prepare = conn.prepareStatement(sql);
		for (int i = 0; i < params.length; i++) {
			valutShinePrepare(params[i], prepare,i);
		}
		return prepare;
	}

	/**
	 * 把输入参数，判断类型 ，然后加入到 preparedSatatement对象中 
	 * @param params
	 * @param prepare
	 * @param i
	 * @throws SQLException
	 */
	private static void valutShinePrepare(Object param,PreparedStatement prepare,int i) throws SQLException {
		if(param instanceof Integer){
			prepare.setInt(i+1, (Integer)param);
		}else if(param instanceof String){
			//判断是否有双引号 然后转译 
			String value =  param.toString();
			//<!-- mysql 版本 5.6.11  -->
	//				if(value.contains("\"")){
	//					value =  value.replaceAll("\"", "");  
	//					value =    value.replaceAll(":", " ");
	//					value =    value.replaceAll("{", " ");
	//					value =    value.replaceAll("}", " ");
	//					
	//					System.out.println("value =" +value);
	////					value = "";
	//				}	
			prepare.setString(i+1 , value);
		}else if(param instanceof Byte){
			prepare.setByte(i+1, (Byte)param);
		}
	}
		
	
	private static  SqlSession sqlsessioniBuild(){
		SqlSessionFactory sqlSessionFactory = ApplicationServletInitFilter.genericWebApplicationContext.getBean("sqlSessionFactory",SqlSessionFactory.class) ;
		SqlSession session = sqlSessionFactory.openSession();
		return session;
	} 
	
	
	/**
	 * 生成UUID，
	 * @return
	 */
	public static String buildUUID(){		  
		  String uuid = UUID.randomUUID().toString();
		  uuid = uuid.replace("-", "");
		  String dateID = SDF_YYYY_MM_DD_HH_MM_SS_SS.format(new Date());		  
		  return dateID + uuid  ;
	}
	
	public static void main(String[] args) {  
	       System.out.println( buildUUID());
	}  
	
	/**
	 * 底层JDBC 选择多条记录
	 * @param sqlVO
	 * @return  返回操作次数
	 */
	public static  List<Map> jdbcSelectByComplexSqlOperate(String compoundSqlId,Map map){
		
		SqlSession session = null;
		try {
			session = sqlsessioniBuild();
			CompoundSqlVO compoundSql = new CompoundSqlVO();
			compoundSql.setCompoundSqlId(compoundSqlId);
			compoundSql =(CompoundSqlVO)DateBaseOperateUtil.jdbcSelectSingleOperate(compoundSql);
			Connection conn = session.getConnection();
			//取出当前复杂sql的完整sql语句
			String sql = compoundSql.getBuildSql();
			List<String> params = StringUtil.plexStringParam(sql); 
			//替换成标准的sql语句
			sql = StringUtil.plexStringQuestionMark(sql,"?");
			//从数据库设置sql格式
			PreparedStatement prepare = conn.prepareStatement(sql);
			for( int i=0;i<params.size();i++){				
				Object value= OtherUtil.findValueFromMap(params.get(i),map);
				valutShinePrepare(value, prepare,i);
			}
			//执行查询语句
			ResultSet resultSet = prepare.executeQuery();
			CompoundSqlShowVO sqlShowVO = new CompoundSqlShowVO();
			sqlShowVO.setCompoundSqlId(compoundSqlId);
			//获取这个复合Sql的列名
			List<BaseAutoBuildVO> sqlShowList  = DateBaseOperateUtil.jdbcSelectMultitermOperate( sqlShowVO );
			List<Map> re = new ArrayList<Map>();
			//根据返回结果，和要显示的结果集，生成结果map 
			while(resultSet.next()){
				//对应单条记录的值
				Map<String,String> valueMap  = new HashMap<String,String>();
				re.add(valueMap);
				for(int i=0;i<sqlShowList.size();i++){
					CompoundSqlShowVO vo = (CompoundSqlShowVO)sqlShowList.get(i);
					String columnName = vo.getTableNameAils() + "_" + vo.getTableColumn();
					String value=resultSet.getString( columnName );//取出查询结果
					valueMap.put(columnName, value);//查询结果放入单条map队列中 
				}
			}
			
			return re;
			
		} catch (SQLException e) {
			e.printStackTrace();			
		}finally{
			session.close();
		}
		return null;
		
	}
}
