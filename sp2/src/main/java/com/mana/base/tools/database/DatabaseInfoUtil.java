package com.mana.base.tools.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mana.base.tools.database.vo.TableInfoFieldVO;
import com.mana.base.tools.database.vo.TableInfoVO;
import com.mana.base.tools.string.StringUtil;


/*
 * 数据库信息工具类
 * 主要获取数据库的信息 
 */
public class DatabaseInfoUtil {
	
	static Log logger = LogFactory.getLog(DatabaseInfoUtil.class);

	/**
	 * 根据表名 从数据库  获取到表结构的信息
	   下午05:00:23
	 * @param tableName
	 * @return
	 */
	public static TableInfoVO findTableInfoFromDatabase(String tableName){
		TableInfoVO tableInfoVO = new TableInfoVO();
		try {
			ApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
			BasicDataSource datasource =  (BasicDataSource) xmlApplicationContext.getBean("dataSource");
			Connection con = datasource.getConnection();
			DatabaseMetaData  metaDate = con.getMetaData();
			
			//测试 TEXT类型的字段
			/*
			PreparedStatement pp = con.prepareStatement("INSERT INTO auto_build_widget (widget_id,param_big1,id) VALUES(\"a13\",\"b33\",\"cc\");");
			int re = pp.executeUpdate();
			System.out.println("re");
			*/
			
			//获取表名
			//ResultSet tableRet = metaDate.getTables(null, "%",tableName,new String[]{"TABLE"});
			//最终的VO
			tableInfoVO.setTableName(tableName);
			//设置主键
			ResultSet pkRSet = metaDate.getPrimaryKeys(null, null, tableName); 
			while( pkRSet.next() ) { 
				System.err.println("****** Comment ******"); 
				System.err.println("TABLE_CAT : "+pkRSet.getObject(1)); 
				System.err.println("TABLE_SCHEM: "+pkRSet.getObject(2)); 
				System.err.println("TABLE_NAME : "+pkRSet.getObject(3)); 
				System.err.println("COLUMN_NAME: "+pkRSet.getObject(4)); 
				System.err.println("KEY_SEQ : "+pkRSet.getObject(5)); 
				System.err.println("PK_NAME : "+pkRSet.getObject(6)); 
				System.err.println("****** ******* ******");
				//设置主键
				tableInfoVO.setKeyField("" + pkRSet.getObject(4));
			}
			List<TableInfoFieldVO> fields = new ArrayList<TableInfoFieldVO>();
		  ResultSet colRet = metaDate.getColumns(null,"%", tableName,"%");//获得类名
		  while(colRet.next()) {
			   String fieldName = colRet.getString("COLUMN_NAME");
			   String fieldType = colRet.getString("TYPE_NAME");
			   int datasize = colRet.getInt("COLUMN_SIZE");
			   int digits = colRet.getInt("DECIMAL_DIGITS");
			   int nullable = colRet.getInt("NULLABLE");  
			   System.out.println(fieldName+" " + fieldType + " " + datasize + " " + digits + " " +  nullable);
//				   if(tableInfoVO.getKeyField().equals(fieldName) == false){ //不是主键
				   TableInfoFieldVO vo = new TableInfoFieldVO();
				   vo.setFieldName(fieldName);
				   vo.setFieldType(fieldType);
				   fields.add(vo);   
//				   }
		  }
		  //设置字段信息
		  tableInfoVO.setFields(fields);			  
		  System.out.println("datasource" + datasource);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tableInfoVO;
	}

	
	
	
	/**
	 * 把表信息，生成java
	 * @param tableName
	 * @return
	 */
	public static StringBuffer buildTableInfo(TableInfoVO tableInfoVO){
		StringBuffer sb  = new StringBuffer();
		sb.append("package com.mana.autoBuild.tableVO;\n");
		sb.append("\n");
		sb.append("import java.sql.ResultSet;\n");
		sb.append("import java.sql.SQLException;\n");
		sb.append("\n");
		sb.append("import com.mana.autoBuild.daoVO.BaseAutoBuildVO;\n");

		//生成类名0
		//生成字段名
		sb.append(" public class " + StringUtil.plexStrToClassName(tableInfoVO.getTableName()) + "VO" + " extends BaseAutoBuildVO{ \n");
		for(int i=0;i<tableInfoVO.getFields().size();i++){
			TableInfoFieldVO field = tableInfoVO.getFields().get(i);
			sb.append("    public " + declarColumnTypeToJavaType(field.getFieldType()) + " " +	StringUtil.plexStrToFieldName(field.getFieldName())  + ";\n" );
//			public String widgetId;
		}
		
		//生成get与Set方法
//		public String getWidgetId() {
//			return widgetId;
//		}
//
//		public void setWidgetId(String widgetId) {
//			this.widgetId = widgetId;
//			sqlParam.put("widget_Id", widgetId);
//		}
//		
		for(int i=0;i<tableInfoVO.getFields().size();i++){
			TableInfoFieldVO field = tableInfoVO.getFields().get(i);
			String filedType = declarColumnTypeToJavaType(field.getFieldType());
			String filedName = StringUtil.plexStrToFieldName(field.getFieldName()) ;
			String filedNameUpper = StringUtil.plexStrToClassName(field.getFieldName()) ;
			//get 方法
			sb.append("public " + declarColumnTypeToJavaType(field.getFieldType()) + " get" + filedNameUpper +"(){\n"  );
			sb.append("  return "  +  StringUtil.plexStrToFieldName(field.getFieldName())  + " ;\n");
			//"public String getWidgetId() "
			sb.append("}\n");
			
			sb.append("public void set" + filedNameUpper 
					+ "( " + filedType + " "  + filedName   + "){\n"  );
			sb.append("  this." + filedName + "=" + filedName + ";\n");
			sb.append("  sqlParam.put( \"" + field.getFieldName() + "\"," +filedName+  ");\n");
			sb.append("}\n");
		}
		
		//从数据库Result结果获取vo方法开头
//		@Override
//		public BaseAutoBuildVO buildResultSetVO(ResultSet resultSet) {		
//			AutoBuildWidgetVO vo = new AutoBuildWidgetVO();
//			 try {
//				vo.id = resultSet.getString("id");
//				vo.type= resultSet.getString("type");
//				vo.widgetId= resultSet.getString("widget_Id");
//				vo.param9 = resultSet.getString("param9");
//				return vo;
//			} catch (SQLException e) {
//				e.printStackTrace();
//				return null;
//			}
//		}

		
		
		sb.append(" @Override \n" );
		sb.append(" public BaseAutoBuildVO buildResultSetVO(ResultSet resultSet) { \n" );
		//类名的VO		
		sb.append(" " + StringUtil.plexStrToClassName(tableInfoVO.getTableName()) + "VO" + " vo = new " + StringUtil.plexStrToClassName(tableInfoVO.getTableName()) + "VO(); \n" );
		//例子 AutoBuildWidgetVO vo = new AutoBuildWidgetVO();
		sb.append(" try{\n" );
		
		for(int i=0;i<tableInfoVO.getFields().size();i++){
			TableInfoFieldVO field = tableInfoVO.getFields().get(i);
			String filedType = declarColumnTypeToJavaType(field.getFieldType());
			String filedName = StringUtil.plexStrToFieldName(field.getFieldName()) ;
			//例子 vo.id = resultSet.getString("id");
			sb.append(" vo." + filedName + " = " + "resultSet.get" + filedType +"(\"" + field.getFieldName() + "\"); \n"  );
		}	
		
		sb.append("		 return vo;\n");
		sb.append(" } catch (SQLException e) { \n");
		sb.append(" 	return null; \n");
		sb.append(" }\n"); 
		sb.append("}\n");		//从数据库Result结果获取vo方法结尾的大括号
		
		
		
		
		//写入主键值方法开始
//		@Override
//		public void putKeyValue(Object key) {
//			widgetId = key.toString();
//		}
		sb.append("  @Override \n");
		sb.append("  public void putKeyValue(Object key) {\n");
		sb.append( "  " +StringUtil.plexStrToFieldName(tableInfoVO.getKeyField()) + "=key.toString();\n"  + "\n");
		sb.append("  }\n");		//写入主键值方法结尾的大括号结尾
		
		
		//查找主键值方法开始
//		@Override
//		public String findKeyValue() {
//			return widgetId;
//		}
		
		sb.append("  @Override \n");
		sb.append("  public String findKeyValue() {\n");
		sb.append( "  return " +StringUtil.plexStrToFieldName(tableInfoVO.getKeyField()) + "; \n");
		sb.append("  }\n");		//查找主键值方法开始的大括号结尾
	
		//获取当前主键的数据库名字开始
//		@Override
//		public String currentKeyName() {
//			return "widget_Id";
//		}
		sb.append("  @Override \n");
		sb.append("  public String currentKeyName() {\n");
		sb.append( "  return \"" + tableInfoVO.getKeyField() + "\"; \n");
		sb.append("  }\n");		//获取当前主键的数据库名字大括号结尾
		
		
		//获取当前表名开始
//		@Override
//		public String currentTable() {
//			return "AUTO_BUILD_WIDGET";
//		}
		sb.append("  @Override \n");
		sb.append("  public String currentTable() {\n");
		sb.append( "  return \"" + tableInfoVO.getTableName() + "\"; \n");
		sb.append("  }\n");		//获取当前表名开始大括号结尾
		
		
		//自动设置vo的值方法开始 
//		@Override
//		public boolean autoSet(String filedName, Object value) {
//			if("featureName".equals(filedName)){
//				this.setFeatureName("" + value);
//			}else if("count".equals(filedName)){
//				this.setCount("" + value);
//			}else if("status".equals(filedName)){
//				this.setStatus("" + value);
//			}
//			return false;
//		}
		
		sb.append("  @Override \n");
		sb.append("  public boolean autoSet(String filedName, Object value) {\n");		
		for(int i=0;i<tableInfoVO.getFields().size();i++){
			TableInfoFieldVO field = tableInfoVO.getFields().get(i);			
			String filedName = StringUtil.plexStrToFieldName(field.getFieldName(),false) ;
			String headfiledName = StringUtil.plexStrToFieldName(field.getFieldName(),true) ;//大写字母开头的字段 
			sb.append("	if(\"" + filedName + "\".equals(filedName)){\n");
			sb.append(" 	this.set" + headfiledName + "(\"\" + value);\n");	
			sb.append(" 	return true; \n");
			sb.append("     }\n");
			
//			if/("featureName".equals(filedName)){
//				this.setFeatureName("" + value);
		}
		sb.append("  return false; \n");
		sb.append("  }\n");//自动设置vo的值方法大括号结尾
		
		
		
		//自动获取vo的值方法开始 
//		@Override
//		public Object autoGet(String filedName) {
//			if("featureName".equals(filedName)){
//				return getFeatureName();
//			}else if("count".equals(filedName)){
//				return getCount();
//			}else if("status".equals(filedName)){
//				return getStatus();
//			}
//			return null;
//		}
		sb.append("  @Override \n");
		sb.append("  public Object autoGet(String filedName) {\n");		
		for(int i=0;i<tableInfoVO.getFields().size();i++){
			TableInfoFieldVO field = tableInfoVO.getFields().get(i);
			String filedName = StringUtil.plexStrToFieldName(field.getFieldName(),false) ;
			String headfiledName = StringUtil.plexStrToFieldName(field.getFieldName(),true) ;//大写字母开头的字段
			sb.append("	if(\"" + filedName + "\".equals(filedName)){ \n");
			sb.append(" 		return  this.get" + headfiledName + "(); \n");			
			sb.append(" 	}\n");
		}
		sb.append(" return null;  \n");
		sb.append("  }\n");//自动获取vo的值方法大括号结尾
		//最后类的大括号
		sb.append("}\n");
		
		
		//把内容写入
		System.out.println("==================input=================");
		System.out.println("==================input=================");
		System.out.println("==================input=================");
		System.out.println("==================input=================");
		System.out.println(sb.toString());
		return sb;
	}
	
	
	
	
	
	
	/**
	 * 根据 数据库的列类型，返回java中对应的字段
	   下午06:46:10
	 * @param contype
	 * @return
	 */
	public static String declarColumnTypeToJavaType(String contype){
		//System.out.println("contype=" + contype);
		logger.debug("contype=" + contype);
		
		if("VARCHAR".equals(contype)){
			return "String";
		}else if("TEXT".equals(contype) ){
			return "String";
		}
//		else if("INT".equals(contype)){
//			return "int";
//		}
		return "";
		
	}
	
	public static void main(String[] args) {
		System.out.println("====q=====222=========");
		TableInfoVO tableInfoVO = DatabaseInfoUtil.findTableInfoFromDatabase("cloud_iaas_application");
		DatabaseInfoUtil.buildTableInfo(tableInfoVO);
		
	}
}


