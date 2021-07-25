package com.pageObjects;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.function.Function;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.LoggerHelper;
import com.base.TestBase;

import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
public class SignIn {
	WebDriver driver;
	WebDriverWait wait;
	private final Logger log = LoggerHelper.getLogger(SignIn.class);
			public SignIn(WebDriver driver) {
				 wait = new WebDriverWait(driver, 90);
				PageFactory.initElements(driver, this);
				
			}
		  
	          	         
	           
			@FindBy(how = How.XPATH, using = "//input[@type='email']") 
			private WebElement email;
			
								
			@FindBy(how = How.XPATH, using = "//div[@id='identifierNext']") 
			private WebElement nextForPassword;
			
			@FindBy(how = How.XPATH, using = "//div[@id='passwordNext']//button") 
			private WebElement nextForAuthentication;
	        			
			@FindBy(how = How.XPATH, using = "//input[@type='password']") 
			private WebElement password;
			
			@FindBy(how = How.XPATH, using ="(//table/tbody/tr)[5]")
			private WebElement chekMailIsPresent;
			
			@FindBy(how = How.XPATH, using ="((//*[@email=\"sonali@recko.io\"])[2]")
			private WebElement clickOnMail;
			
			@FindBy(how = How.XPATH, using ="(//*[@class='ha']/h2)")
			private WebElement subject;
			
			@FindBy(how = How.XPATH, using ="((//*[@class='a3s aiL '])[1])")
			private WebElement body;

				
	 		public void enter_Email(String user_email){
	 					
				try { Thread.sleep(5000);
				email.sendKeys(user_email);
				log.info("entered email "+ user_email);}
				
				catch (InterruptedException e) {}
			}
	 		
			public void enter_Password(String user_password) throws InterruptedException{
				Thread.sleep(20000);
				password.sendKeys(user_password);
				log.info("entered password");
				try { Thread.sleep(5000);}
				catch (InterruptedException e) {}
			}
			
			
			
            public void clickNextForPassword(){
                nextForPassword.click();
                log.info("clicked on next for password");
            
            }
            
            public void clickNextForLogin(){
                nextForAuthentication.click();
                log.info("clicked on next for password");
            
            }
            
        	public boolean is_EmailPresent() {
        		Assert.assertTrue(chekMailIsPresent.isDisplayed());
        		return true;
        	}
        	
        	public void  click_FirstMail(WebDriver driver,String sentFrom) {
        		String path="(//*[@email=\""+sentFrom+"\"])[2]";
        		WebElement clickMail=driver.findElement(By.xpath(path));
        		clickMail.click();
                log.info("clicked on Mail");

        	}
        	
        	
        	public boolean check_Subject(String subjectF) {
        		log.info(subject.getText());
        		Assert.assertEquals(subjectF,subject.getText());
        		return true;
        	}
        	
        	public boolean check_Body(String bodyF) {
        		log.info(body.getText());
        		Assert.assertEquals(bodyF,body.getText());
        		return true;
        	}
						
			}
				


