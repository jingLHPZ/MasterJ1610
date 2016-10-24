package com.sxt.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
public  class PropertiesRead {
	
	/**获取的是class的根路径下的文件 
     * 优点是：可以在非Web应用中读取配置资源信息，可以读取任意的资源文件信息 
     * 缺点：只能加载类classes下面的资源文件。 
     * 如果要加上路径的话：com/test/servlet/jdbc_connection.properties 
     */  
    public static Properties use_classLoador(){  
        //文件在class的根路径  
        InputStream is=PropertiesRead.class.getClassLoader().getResourceAsStream("config/upload.properties");  
        //获取文件的位置  
        //获取的是TestJava类所在的相对路径下 ,com/test/servlet/jdbc_connection.properties"  
      // InputStream is=PropertiesRead.class.getResourceAsStream("/upload.properties");  
          
        BufferedReader br= new BufferedReader(new InputStreamReader(is));  
        Properties props = new Properties();  
          
        try {  
            props.load(br);  
           
        } catch (IOException e) {   e.printStackTrace();}  
        return props;
    }
    public static Properties use_classLoador(String properties){  
        //文件在class的根路径  
        InputStream is=PropertiesRead.class.getClassLoader().getResourceAsStream("config/"+properties+".properties");  
        //获取文件的位置  
        //获取的是TestJava类所在的相对路径下 ,com/test/servlet/jdbc_connection.properties"  
      // InputStream is=PropertiesRead.class.getResourceAsStream("/upload.properties");  
          
        BufferedReader br= new BufferedReader(new InputStreamReader(is));  
        Properties props = new Properties();  
          
        try {  
            props.load(br);  
           
        } catch (IOException e) {   e.printStackTrace();}  
        return props;
    }
    public static void main(String[] args) {
    	System.out.println(use_classLoador().getProperty("image.url"));
	}
}
