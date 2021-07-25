package com.config;
	import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.OutputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


	public class ConfigFileReader	{
		private static ConfigFileReader configFileReader = new ConfigFileReader();
		private Properties properties;
		private final String propertyFilePath = "./src/main/java/com/config/Configuration.properties";
		public ConfigFileReader() {
			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader(propertyFilePath));
				properties = new Properties();
				properties.load(reader);
				reader.close();
			}
			catch(IOException e) {
				e.printStackTrace();
				throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
			}
		}
		
		public static ConfigFileReader getConfigFileReader() {
			return(configFileReader == null) ?  new ConfigFileReader() : configFileReader;
		}
		
		
		
			
		public String getDriverPath() {
			String driverPath = properties.getProperty("driverPath");
			if(driverPath !=null) {
				return driverPath;
			}
			else{
				throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
			}
		}
		public long getImplicitlyWait() {
			String implicitlyWait = properties.getProperty("implicitlyWait");
			if(implicitlyWait != null) {
				return Long.parseLong(implicitlyWait);
			}else {
				throw new RuntimeException("wait is not specified in the Configuration.properties file.");
			}
		}
		
		
			public Boolean getBrowserWindowSize() {
			String windowSize = properties.getProperty("windowMaximize");
			if(windowSize != null) return Boolean.valueOf(windowSize);
			return true;
		}
		
		}



