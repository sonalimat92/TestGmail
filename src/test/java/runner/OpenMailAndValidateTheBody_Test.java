package runner;


	import java.io.File;
	import java.io.IOException;
	import java.util.concurrent.TimeUnit;

	import javax.swing.JFileChooser;
    import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

	
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.io.FileHandler;

import com.base.*;
import com.config.ConfigFileReader;
import com.cucumber.listener.Reporter;
	import com.google.common.io.Files;
	import cucumber.api.testng.*; 
import cucumber.api.CucumberOptions;
	import cucumber.api.Scenario;
	import cucumber.api.java.After;
	import stepDefinitions.*;

 
	@CucumberOptions(
			features = "src/test/resources/functionalTests/" ,
			glue = "stepDefinitions" ,
			tags = {"@tag1"},
			monochrome = true ,//makes console o/p readable
			dryRun=false,
			plugin =  { "com.cucumber.listener.ExtentCucumberFormatter:Reports/LoginAnRegister.html"} )
@Test
public class OpenMailAndValidateTheBody_Test extends AbstractTestNGCucumberTests{
		
	
		@AfterClass  
		  public static void writeExtentReport() { 
			
		  	  Reporter.loadXMLConfig("./configs/extentConfig.xml");
		  Reporter.setSystemInfo("User name", System.getProperty("user.name"));
		  Reporter.setSystemInfo("TimeZone", System.getProperty("user.timeZone"));
		  Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
		  Reporter.setSystemInfo("Selenium", "3.7.0"); Reporter.setSystemInfo("Maven",
		  "3.5.3"); Reporter.setSystemInfo("Java Version", "1.8.0_151"); }
		 
	}

