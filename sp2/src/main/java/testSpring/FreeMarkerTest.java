package testSpring;  
  
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
  
public class FreeMarkerTest {  
    public static void main(String[] args) throws Exception {  
        Configuration config = new Configuration();  
        try {
        	
            config.setDirectoryForTemplateLoading(new File("E:/workspaces/eclipse-jee-helios-sr2/sp2/src/main/java/testSpring"));  
            config.setObjectWrapper(new DefaultObjectWrapper());
            
            //拿到test.ftl的模板(相当于html模板)  
            Template template = config.getTemplate("/ccc/temp.ftl", "UTF-8");  
            // 创建数据模型  
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
              
            //新建一个文件。  
            File file = new File("E:/workspaces/eclipse-jee-helios-sr2/sp2/src/main/java/testSpring/test.html");  
            if (!file.exists()) {//不存在文件则创建该文件。  
                // System.out.println("file exist");  
                file.createNewFile();  
            }  
            //创建该文件的输出字符流。  
            Writer out = new BufferedWriter(new FileWriter(file));  
            template.process(root, out);  
            out.flush();  
        } catch (IOException e) {
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }  
}  