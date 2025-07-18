package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.IndexPage;
import pages.LoginPage;

public class TC_VerifyLoginWithBlankEmailAndPassword extends BaseClass {
	@Test
	public void VerifyLoginWithBlankEmailAndPassword() throws IOException {
		logger.info("Verify login with blank Email and password");
		IndexPage indexpage=new IndexPage(driver);
		indexpage.clickOnSignIn();
		logger.info("Clicked on signin ");
		LoginPage loginpage=new LoginPage(driver);
		
		loginpage.enterEmail("");
		logger.info("Entered Email  ");
		loginpage.enterPassword("");
		logger.info("Entered Password   ");
		loginpage.clickOnSignIn();
		
		logger.info("Clicked on SignIn");
		
		String actualErrorMessage=loginpage.getErrorMessageBothBlanks();
		String expectedErrorMessage="This is a required field.";
		
		  if (actualErrorMessage.equals(expectedErrorMessage)) {
	          logger.info("VerifyLoginWithBlankEmailAndPassword - Passed");
	          Assert.assertTrue(true, "Error message matched as expected.");
	      } else {
	          logger.error("VerifyLoginWithBlankEmailAndPassword - Failed");
	          logger.error("Expected: " + expectedErrorMessage);
	          logger.error("Actual: " + actualErrorMessage);
	          captureScreenShot(driver, "VerifyLoginWithBlankEmailAndPassword");
	          Assert.fail("VerifyLoginWithBlankEmailAndPassword   failed.");
	      }
	}

}
