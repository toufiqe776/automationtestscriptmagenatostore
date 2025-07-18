package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AccountPage;
import pages.ChangePasswordPage;
import pages.HomePage;
import pages.IndexPage;
import pages.LoginPage;

public class TC_ChangePasswordWithValidData extends BaseClass{
	 @Test
	    public void changePasswordWithValidCurrentAndNewPasswords() throws IOException {
	        logger.info("Starting test: Change password with valid current and new passwords");

	        // Step 1: Sign in
	        IndexPage indexPage = new IndexPage(driver);
	        indexPage.clickOnSignIn();

	        LoginPage loginPage = new LoginPage(driver);
	        loginPage.enterEmail("mdtoufique1096@gmail.com");
	        loginPage.enterPassword("Admin@1234");
	        loginPage.clickOnSignIn();

	        logger.info("Logged in successfully");

	        // Step 2: Navigate to Change Password Page
	        HomePage homePage = new HomePage(driver);
	        homePage.clickOnArrowIcon();
	        logger.info("clcik on  arrow icon button ");
	        homePage.clickOnMyAccount();
	        logger.info("clcik on  my account ");
	        AccountPage accountpage=new AccountPage(driver);
	        accountpage.clickOnChangePassword();
	        logger.info("clcik on change password ");
	        ChangePasswordPage changepasswordpage=new ChangePasswordPage(driver);
	        changepasswordpage.enterCurrentPassword("Admin@1234");
	        logger.info("enter current password ");
	        changepasswordpage.enterOnNewPassword("Admin@12345");
	        logger.info("enter new password ");
	        changepasswordpage.enterConfirmNewPassword("Admin@12345");
	        logger.info("enter confirm new  password ");
	        changepasswordpage.clickOnSaveBtn();
	        logger.info("click on save button");
	       //validation 
	        
	        String actualHeading= loginPage.getLoginPageHeading();
			String expectedHeading="Customer Login";
			
			  if (actualHeading.equals(expectedHeading)) {
		          logger.info("Password changed successfully");
		          Assert.assertTrue(true, "Error message matched as expected.");
		      } else {
		          logger.error("VerifyLogEmailFiledInvalidFormat - Failed");
		          logger.error("Expected: " + expectedHeading);
		          logger.error("Actual: " + actualHeading);
		          captureScreenShot(driver, "changePasswordWithValidCurrentAndNewPasswords");
		          Assert.fail("changePasswordWithValidCurrentAndNewPasswords   failed.");
		      }
			  
	       
	    }

}
