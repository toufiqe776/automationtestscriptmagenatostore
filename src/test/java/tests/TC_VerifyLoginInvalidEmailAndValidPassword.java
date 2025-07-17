package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.IndexPage;
import pages.LoginPage;

public class TC_VerifyLoginInvalidEmailAndValidPassword extends BaseClass {
	@Test  
	public void verifyLoginWithInvalidEmailAndValidPassword() throws IOException {
		logger.info("Verify login with Invalid Email and valid password ");
		IndexPage indexpage=new IndexPage(driver);
		indexpage.clickOnSignIn();
		logger.info("Clicked on signin ");
		LoginPage loginpage=new LoginPage(driver);
		
		loginpage.enterEmail("mdtoufique1096gmail.com");
		logger.info("Entered Email  ");
		loginpage.enterPassword("Toufique@825");
		logger.info("Entered Password   ");
		loginpage.clickOnSignIn();
		
		logger.info("Clicked on SignIn");
		
		String actualErrorMessage=loginpage.getErrorMessageValidPassword();
		String expectedErrorMessage="Please enter a valid email address (Ex: johndoe@domain.com).";
		
		  if (actualErrorMessage.equals(expectedErrorMessage)) {
	          logger.info("verifyLoginWithInvalidEmailAndValidPassword - Passed");
	          Assert.assertTrue(true, "Error message matched as expected.");
	      } else {
	          logger.error("verifyLoginWithInvalidEmailAndValidPassword - Failed");
	          logger.error("Expected: " + expectedErrorMessage);
	          logger.error("Actual: " + actualErrorMessage);
	          captureScreenShot(driver, "verifyLoginWithInvalidEmailAndValidPassword");
	          Assert.fail("verifyLoginWithInvalidEmailAndValidPassword   failed.");
	      }
	}

}
