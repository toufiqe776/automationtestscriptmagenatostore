package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


import pages.IndexPage;
import pages.NewAccountPage;

public class TC_SignUpWithExistEmail extends BaseClass {
	@Test
	public void signUpWithExsistEmail() {
		logger.info("*** Test Case: Sign-up with Exist email started ***");

        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickOnCreateAccount();
        logger.info("Clicked on 'Create an Account'");

        NewAccountPage newAccountPage = new NewAccountPage(driver);
        newAccountPage.enterFirstName("Toufique");
        logger.info("Entered first name");

        newAccountPage.enterLastName("Ansari");
        logger.info("Entered last name");

        newAccountPage.enterEmail("toufiq.nt@gmail.com");
        logger.info("Entered email");

        newAccountPage.enterPassword("Admin@123");
        logger.info("Entered password");

        newAccountPage.enterConfirmPassword("Admin@123");
        logger.info("Entered confirm password");

        newAccountPage.clickOnCreateAccountButton();
        logger.info("Clicked on 'Create Account'");
       String actualErrorMessage= newAccountPage.getExistEmailErrorMessage();
       
       String expectedErrorMessage="There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.";
       Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	}

}
