package com.base;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.config.ConfigFileReader;
public class TestBase {

		private static WebDriver driver;
		private final static String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
		
		public static WebDriver getWebDriver() {
			
			if(driver==null) {
				driver = createLocalDriver();
			}
			return driver;
		}
	@SuppressWarnings("deprecation")
	  private static WebDriver createLocalDriver() {
			System.setProperty(CHROME_DRIVER_PROPERTY, ConfigFileReader.getConfigFileReader().getDriverPath());
			ChromeOptions option = new ChromeOptions();
			DesiredCapabilities cap =new DesiredCapabilities();
			cap.setCapability(ChromeOptions.CAPABILITY, option);
			WebDriver driver = new ChromeDriver(cap);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(ConfigFileReader.getConfigFileReader().getImplicitlyWait(), TimeUnit.SECONDS);
			return driver;
		}
			
				
		public static void loadUrl( String url) {
			driver.get(url);  
			}
		
		
		
		public static void closeDriver() {
			driver.quit();
			driver =null;
		}
	

}
