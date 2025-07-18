package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.IndexPage;
import pages.LoginPage;

public class TC_VerifyLoginEmailFiledInvalidFormat extends BaseClass{
	@Test
	public void VerifyLogEmailFiledInvalidFormat() throws IOException {
		logger.info("Verify login with  Email field invalid format");
		IndexPage indexpage=new IndexPage(driver);
		indexpage.clickOnSignIn();
		logger.info("Clicked on signin ");
		LoginPage loginpage=new LoginPage(driver);
		
		loginpage.enterEmail("acb.com");
		logger.info("Entered Email  ");
		loginpage.enterPassword("Admin@123");
		logger.info("Entered Password   ");
		loginpage.clickOnSignIn();
		
		logger.info("Clicked on SignIn");
		
		String actualErrorMessage=loginpage.getErrorMessageValidPassword();
		String expectedErrorMessage="Please enter a valid email address (Ex: johndoe@domain.com).";
		
		  if (actualErrorMessage.equals(expectedErrorMessage)) {
	          logger.info("VerifyLogEmailFiledInvalidFormat - Passed");
	          Assert.assertTrue(true, "Error message matched as expected.");
	      } else {
	          logger.error("VerifyLogEmailFiledInvalidFormat - Failed");
	          logger.error("Expected: " + expectedErrorMessage);
	          logger.error("Actual: " + actualErrorMessage);
	          captureScreenShot(driver, "VerifyLogEmailFiledInvalidFormat");
	          Assert.fail("VerifyLogEmailFiledInvalidFormat   failed.");
	      }
	}

}
