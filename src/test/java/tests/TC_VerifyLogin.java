package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.IndexPage;
import pages.LoginPage;

public class TC_VerifyLogin extends BaseClass
{
@Test 
public void LoginWithValidCredentials() throws IOException {
	logger.info("Verify login with valid credentials ");
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
	String actualHeading=homepage.getHomePageHeading();
	String expectedHeading="Home Page";
	
	  if (actualHeading.equals(expectedHeading)) {
          logger.info("LogIn - Passed");
          Assert.assertTrue(true, "Heading matched as expected.");
      } else {
          logger.error("Login - Failed");
          logger.error("Expected: " + expectedHeading);
          logger.error("Actual: " + actualHeading);
          captureScreenShot(driver, "LoginWithValidCredentials");
          Assert.fail("LogIn   failed.");
      }
	
	
	
	
}
}
