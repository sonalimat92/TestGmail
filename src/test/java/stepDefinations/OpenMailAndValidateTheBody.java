package stepDefinitions;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.base.LoggerHelper;
import com.base.TestBase;
import com.config.ConfigFileReader;
import com.pageObjects.SignIn;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OpenMailAndValidateTheBody  {
	
	WebDriver driver ;
//	String MainWindow;
	SignIn signin;
    Set<String> allWindowHandles;

	//ConfigFileReader cfg=new ConfigFileReader();
	//private final Logger log = LoggerHelper.getLogger(CompanyInfo.class);

    @Given("^Open Chrome and Launch the GMAIL$")
    public void open_Chrome_and_Launch_the_GMAIL() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	 driver = TestBase.getWebDriver();
		 TestBase.loadUrl("https://www.gmail.com");
    }

    @Then("^Close the Browser$")
    public void close_the_Browser() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	TestBase.closeDriver();
    }


	

				
		
		  @When("^I enter a valid (.*) and a valid (.*)$") public void
		  i_enter_a_valid_and_a_valid(String username,String password) throws Throwable
		  {
			   signin=new SignIn(driver);
			  signin.enter_Email(username);
			  signin.clickNextForPassword(); 
			  signin.enter_Password(password);
			  signin.clickNextForLogin();
			 boolean check_mail =signin.is_EmailPresent();
			  if(check_mail==true) {
				  System.out.println("mail is present");
			  }
			  else {
				  System.out.println("empty mail box");
			  }}
			  
					  

		  @When("^I Open the \"([^\"]*)\" mail then verify the \"([^\"]*)\" and \"([^\"]*)\"$")
		  public void i_Open_the_mail_then_verify_the_and(String sentFrom, String subject, String body) throws Throwable {
		      // Write code here that turns the phrase above into concrete actions
			  signin.click_FirstMail(driver,sentFrom);
			     signin.check_Subject(subject);
			     signin.check_Body(body);		  }
	
		 
		
}
	

