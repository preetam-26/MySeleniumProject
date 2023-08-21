package com.demo.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
		try {
		FileInputStream ip = new FileInputStream(src);
		prop = new Properties();
		prop.load(ip);
		}catch(Exception e) {
			System.out.println("Exception is"+ e.getMessage());	
		}
		
	}
	
	public String getApplicationUrl() {
		String url = prop.getProperty("baseUrl");
		return url;
	}
	
	public String getUsername() {
		String uname = prop.getProperty("username");
		return uname;
	}
	
	public String getPassword() {
		String pwd = prop.getProperty("password");
		return pwd;
	}
	
	
}
