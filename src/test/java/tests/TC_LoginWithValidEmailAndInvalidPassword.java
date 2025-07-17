package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.IndexPage;
import pages.LoginPage;

public class TC_LoginWithValidEmailAndInvalidPassword  extends BaseClass{
	@Test
	public void loginWithValidEmailAndInvalidPassword() throws IOException {
		logger.info("Verify login with valid Email and Invalid password ");
		IndexPage indexpage=new IndexPage(driver);
		indexpage.clickOnSignIn();
		logger.info("Clicked on signin ");
		LoginPage loginpage=new LoginPage(driver);
		
		loginpage.enterEmail("mdtoufique1096@gmail.com");
		logger.info("Entered Email  ");
		loginpage.enterPassword("Toufique825");
		logger.info("Entered Password   ");
		loginpage.clickOnSignIn();
		
		logger.info("Clicked on SignIn");
		
		String actualErrorMessage=loginpage.getErrorMessage();
		String expectedErrorMessage="The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
		
		  if (actualErrorMessage.equals(expectedErrorMessage)) {
	          logger.info("loginWithValidEmailAndInvalidPassword - Passed");
	          Assert.assertTrue(true, "Error message matched as expected.");
	      } else {
	          logger.error("loginWithValidEmailAndInvalidPassword - Failed");
	          logger.error("Expected: " + expectedErrorMessage);
	          logger.error("Actual: " + actualErrorMessage);
	          captureScreenShot(driver, "loginWithValidEmailAndInvalidPassword");
	          Assert.fail("loginWithValidEmailAndInvalidPassword   failed.");
	      }
	}

}
