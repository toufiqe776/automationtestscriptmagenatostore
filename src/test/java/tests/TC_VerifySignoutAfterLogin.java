package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.IndexPage;
import pages.LoginPage;
import pages.SignoutPage;

public class TC_VerifySignoutAfterLogin extends BaseClass {
	@Test 
	public void VerifySignoutAfterLogin() throws IOException {
		logger.info("Verify Sign out  After login ");
		IndexPage indexpage=new IndexPage(driver);
		indexpage.clickOnSignIn();
		logger.info("Clicked on signin ");
		LoginPage loginpage=new LoginPage(driver);
		
		loginpage.enterEmail("mdtoufique1096@gmail.com");
		logger.info("Entered Email  ");
		loginpage.enterPassword("Toufique@825");
		logger.info("Entered Password   ");
		loginpage.clickOnSignIn();
		
		logger.info("Clicked on SignIn");
		HomePage homepage=new HomePage(driver);
		homepage.clickOnArrowIcon();
		logger.info("Clicked on Arrow icon ");
		homepage.clickOnLogoutBtn();
		logger.info("Clicked on Sign out");
		SignoutPage signoutpage=new SignoutPage(driver);
		String actualHeading=signoutpage.getHeadingMessage();
		String expectedHeading="You are signed out";
		
			
	  if (actualHeading.equals(expectedHeading)) {
          logger.info("Signout - Passed");
	          Assert.assertTrue(true, "Heading matched as expected.");
	      } else {
          logger.error("Signout - Failed");
          logger.error("Expected: " + expectedHeading);
	          logger.error("Actual: " + actualHeading);
	          captureScreenShot(driver, "Signout");
	          Assert.fail("Signout   failed.");
	      }
	}

}
