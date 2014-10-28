package com.mana.base.tools.freemarket;  
  
import java.io.BufferedWriter;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import testSpring.User;

import com.mana.base.tools.io.ToolsFile;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
  
public class FreeMarkerUtil {
	
	
	/**
	 * 根据模版文件，还有参数，生成结果值
	 * @param marketFile
	 * @param root
	 * @return
	 */
//	public static String buildFreeMarketByFile(String rootDirectory,String filename,Map root){
//		return buildFreeMarketByFile(rootDirectory  + "/" + filename,root);
//	}
	
	/**
	 * 根据模版文件，还有参数，生成结果值
	 * @param marketFile
	 * @param root
	 * @return
	 */
	public static String buildFreeMarketByFile(String rootDirectory,String filename,Map root){
		try{
			Configuration config = new Configuration();
			String po = ToolsFile.localClasspath + "freemarker.properties";
			
			Properties p = new Properties();
			p.load(new FileInputStream(po));
	        config.setSettings(p);
	        
			
			//分解路径
//			String[] paths = marketFile.split("/");
//			String fileName = paths[paths.length];
//			marketFile = marketFile.replaceAll(fileName, "");			
			//模版根目录
	     	config.setDirectoryForTemplateLoading(new File( rootDirectory ));            
	     	config.setObjectWrapper(new DefaultObjectWrapper());	     	
	        //拿到test.ftl的模板(相当于html模板)  
	        Template template = config.getTemplate(filename, "UTF-8");  
	         
	        CharArrayWriter out = new CharArrayWriter();  
	         template.process(root, out);  
	         out.flush();
	         char[] myRe = out.toCharArray();
	         String cc = new String(myRe);
	         return cc;
	         
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 模版渲染
	 * @param templeteName
	 * @param projectId
	 * @param buildHtml
	 * @param root
	 * @return
	 */
	public static boolean buildFreeMarket(String templeteName,String projectId,String buildHtml,Map root){
		Configuration config = new Configuration();
		String projectPath = ToolsFile.localWebpath + "/src/main/webapp/userProject/" + projectId + "/";
		System.out.println();
        try{        	
        	File file2 = new File(projectPath + "templete/");
        	file2.mkdirs();
        	
        	//模版根目录
        	config.setDirectoryForTemplateLoading( file2);            
        	config.setObjectWrapper(new DefaultObjectWrapper());
        	
            //拿到test.ftl的模板(相当于html模板)  
            Template template = config.getTemplate(templeteName, "UTF-8");  
            //新建一个文件。  
            File file = new File(projectPath + "html/" + buildHtml );            
            if (!file.exists()) {//不存在文件则创建该文件。  
//            	file.mkdirs();
                // System.out.println("file exist");  
                file.createNewFile();  
            }
            //创建该文件的输出字符流。  
            Writer out = new BufferedWriter(new FileWriter(file));  
            template.process(root, out);  
            out.flush();  
        } catch (IOException e) {
            e.printStackTrace();  
            return false;
        } catch (TemplateException e) {
			e.printStackTrace();
			return false;
		} 
		return true;
	}
	
    public static void main(String[] args) throws Exception {
    	
    	 Map root = new HashMap();  
         List<User> users = new ArrayList<User>();//方式一：List。用于包装用户信息对象列表  
         User u1 = new User();  
         u1.setId("123");  
         u1.setName("王五");  
         users.add(u1);  
           
         User u2 = new User();  
         u2.setId("2345");  
         u2.setName("张三");  
         User u3 = new User();  
         u3.setId("fgh");  
         u3.setName("李四");  
         users.add(u2);  
         users.add(u3);  
           
         root.put("userList", users); //映射root  
         Map product = new HashMap();  //方式二：单独映射键对。映射product  
         root.put("lastProduct", product);  
         product.put("url", "http://www.google.com");  
         product.put("name", "green hose");  
           
         Map nb=new HashMap();  
         nb.put("name", "标");  
         nb.put("add", "中昱达");  
         root.put("mm",nb);
         
         root.put("id", "vvv");
         
        String re = FreeMarkerUtil.buildFreeMarketByFile(
        		 "E:/workspaces/eclipse-jee-helios-sr1/sp2/src/main/webapp/WEB-INF/classes/com/mana/autoBuild/templet/type/base/baseshow/company/html/"
 				,"config.html"
 				,root
 				);
    	
        
        
    }
}  