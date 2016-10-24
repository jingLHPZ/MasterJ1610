package com.sxt.base.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {
	
	/**
	 * @param fileName : properties's file name
	 * @param key : Properties's key
	 * @return
	 */
	public static String getPropertyValue(String fileName, String key){
        InputStream  is = PropertyLoader.class.getClassLoader().getResourceAsStream("config/"+ fileName +".properties");
        Properties properties = new Properties();
        try {
        	properties.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return properties.getProperty(key);
	}
}
