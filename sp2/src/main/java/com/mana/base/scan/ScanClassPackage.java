package com.mana.base.scan;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.mana.base.GlobalContants;

public class ScanClassPackage implements ResourcePatternResolver{

//	static Log logger = LogFactory.getLog(ScanClassPackage.class);
//	 Logger logger = Logger.getLogger(ScanClassPackage.class.getName());
//	static Logger logger = LogManager.getLogger(ScanClassPackage.class.getName());
	
	//扫描本地路径时候用到的正则，在类初始化的时候，注入该属性
	private Pattern pathPatten;
	
	
	
	public ScanClassPackage(Pattern pathPatten){
		this.pathPatten = pathPatten;
	}
	
	
	@Override
	public Resource getResource(String location) {
		return null;
	}

	@Override
	public ClassLoader getClassLoader() {		
		return null;
	}

	@Override
	public Resource[] getResources(String locationPattern) throws IOException {		
		List<Resource> list = new ArrayList<Resource>();
		Iterator<File> it = FileUtils.iterateFiles(new File(locationPattern), new ScanClassFileFilter(pathPatten), new ScanClassFileFilter(pathPatten));		
		while(it.hasNext()){
			File ff = it.next();
			FileSystemResource fs = new FileSystemResource(ff);
			list.add(fs);
		}
		return (Resource[]) list.toArray(new Resource[list.size()]);
	}
	
	public static void main(String[] args) throws IOException{
		ScanClassPackage scp = new ScanClassPackage(GlobalContants.BASE_SCAN_BEAN_CLASS_PATTEN);
//		scp.getResources("E:\\workspaces\\eclipse-jee-helios-sr1\\studysp\\src\\main\\webapp\\WEB-INF\\classes" );
		scp.getResources("D:\\我的文档\\桌面\\项目备份\\studysp\\target\\classes" );
		
	}
}

class  ScanClassFileFilter implements IOFileFilter{
	
	//扫描本地路径时候用到的正则，在类初始化的时候，注入该属性
	private Pattern pathPatten;
	
	public ScanClassFileFilter(Pattern pathPatten){
		this.pathPatten = pathPatten;
	}

	@Override
	public boolean accept(File file) {
		if(file.isFile()){//是文件，开始检查
			String fileName = file.getName();			
			Matcher matcher = pathPatten.matcher(fileName);
			return matcher.matches();
		}
		return true;
	}

	
	@Override
	public boolean accept(File dir, String name) {
		return true;
	}
}
