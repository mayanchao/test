package com.mana.base.tools.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

import com.mana.autoBuild.daoVO.BaseAutoBuildVO;

public class OtherUtil {


	/**
	 * 从 map中找到要获取的值 ，根据主键名称 ，如果复合主键，就要把结果集转成baseTableVo对象后，在获取主键
	 * 例如 keyName=password 从就直接从map中获取value
	 * 例如 keyName=user.password 类似操作对象User.getPassword()获取数值
	 * @param keyName   
	 * @param map
	 * @return
	 */
	public static Object findValueFromMap(String keyName,Map<String,Object> map ){
		//从map中获取值
		if(keyName.indexOf(".")>0 ){//是复合主键
			String keys[] =  keyName.split("\\.");
			String key = keys[0];
			//BaseAutoBuildVO
			BaseAutoBuildVO vo = (BaseAutoBuildVO)map.get(key)  ;
			return  vo.autoGet(keys[1]);
		}else{//只有单主键的值
			return  map.get(keyName);
		}
	}
	
	
	/**
	 * 远程运行linux命令 
	 * @param hostname  数据库地址 
	 * @param username   用户名
	 * @param password   密码
	 * @param command   命令
	 * @return
	 */
	public  static String runSshCommand(String hostname,String username,String password,String command){
		
//		String hostname = "192.168.45.145";
//		String username = "root";
//		String password = "jd07gm09";
		Connection conn = null;
		Session sess = null;
		StringBuffer re = new StringBuffer();
        try{     
            conn = new Connection(hostname);     
            conn.connect();
            boolean isAuthenticated = conn.authenticateWithPassword(username, password);
            System.out.println("===============");
            sess = conn.openSession();     
    		sess.execCommand(command);     
    		InputStream stdout = new StreamGobbler(sess.getStdout());     
    		BufferedReader br = new BufferedReader(new InputStreamReader(stdout));    		
    		while (true){
    		    String line = br.readLine();     
    		    re.append(line + "\n");
    		    if (line == null)     
    		        break;     
    		}     

        }catch (IOException e){     
            e.printStackTrace(System.err);     
            System.exit(2);     
        }finally{
    		sess.close();
    		conn.close();
        }
		
		return re.toString();
	}  
	
	
	
	
	public static void main(String[] args) {
		
		
	}
}


