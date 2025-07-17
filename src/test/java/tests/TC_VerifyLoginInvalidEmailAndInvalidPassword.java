package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.IndexPage;
import pages.LoginPage;

public class TC_VerifyLoginInvalidEmailAndInvalidPassword extends BaseClass{
	@Test
	public void VerifyLoginInvalidEmailAndInvalidPassword() throws IOException {
		logger.info("Verify login with Invalid Email and Invalid password ");
		IndexPage indexpage=new IndexPage(driver);
		indexpage.clickOnSignIn();
		logger.info("Clicked on signin ");
		LoginPage loginpage=new LoginPage(driver);
		
		loginpage.enterEmail("asd@gmail.com");
		logger.info("Entered Email  ");
		loginpage.enterPassword("asd@123");
		logger.info("Entered Password   ");
		loginpage.clickOnSignIn();
		
		logger.info("Clicked on SignIn");
		
		String actualErrorMessage=loginpage.getErrorMessage();
		String expectedErrorMessage="The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
		
		  if (actualErrorMessage.equals(expectedErrorMessage)) {
	          logger.info("VerifyLoginInvalidEmailAndInvalidPassword - Passed");
	          Assert.assertTrue(true, "Error message matched as expected.");
	      } else {
	          logger.error("VerifyLoginInvalidEmailAndInvalidPassword - Failed");
	          logger.error("Expected: " + expectedErrorMessage);
	          logger.error("Actual: " + actualErrorMessage);
	          captureScreenShot(driver, "VerifyLoginInvalidEmailAndInvalidPassword");
	          Assert.fail("VerifyLoginInvalidEmailAndInvalidPassword   failed.");
	      }
	}

}
