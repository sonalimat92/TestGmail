 @tag1
Feature: Test the Subject and Body from a mail by logging in to an gmail account
 

  Scenario Outline: Test subject and body of a mail
    Given Open Chrome and Launch the GMAIL
    When I enter a valid <username1> and a valid <password1>
    When I Open the "<sent From>" mail then verify the "<subject>" and "<body>"
    Then Close the Browser
    
 Examples:   
      | username1       | password1  |sent From|subject|body|
      |sonali@recko.io|Pratiksh11@|sonali@recko.io|Test|Test for Automation|
      



      