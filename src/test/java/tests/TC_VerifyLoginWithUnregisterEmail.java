package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.IndexPage;
import pages.LoginPage;

public class TC_VerifyLoginWithUnregisterEmail extends BaseClass{
@Test 
public void VerifyWithUnregisterEmail() throws IOException {
	logger.info("Verify login with Unregister Email");
	IndexPage indexpage=new IndexPage(driver);
	indexpage.clickOnSignIn();
	logger.info("Clicked on signin ");
	LoginPage loginpage=new LoginPage(driver);
	
	loginpage.enterEmail("abc@gmail.com");
	logger.info("Entered Email  ");
	loginpage.enterPassword("Toufique@825");
	logger.info("Entered Password   ");
	loginpage.clickOnSignIn();
	
	logger.info("Clicked on SignIn");
	
	String actualErrorMessage=loginpage.getErrorMessage();
	String expectedErrorMessage="The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
	
	  if (actualErrorMessage.equals(expectedErrorMessage)) {
          logger.info("VerifyWithUnregisterEmail - Passed");
          Assert.assertTrue(true, "Error message matched as expected.");
      } else {
          logger.error("VerifyWithUnregisterEmail - Failed");
          logger.error("Expected: " + expectedErrorMessage);
          logger.error("Actual: " + actualErrorMessage);
          captureScreenShot(driver, "VerifyWithUnregisterEmail");
          Assert.fail("VerifyWithUnregisterEmail   failed.");
      }
}
}
