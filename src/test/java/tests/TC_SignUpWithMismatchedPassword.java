package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.IndexPage;
import pages.NewAccountPage;

public class TC_SignUpWithMismatchedPassword extends BaseClass {
	@Test
	public void signUpWithMismatchedPassword() throws IOException {
		logger.info("*** Test Case: Sign Up With mismatched password  ***");

        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickOnCreateAccount();
        logger.info("Clicked on 'Create an Account'");

        NewAccountPage newAccountPage = new NewAccountPage(driver);
        newAccountPage.enterFirstName("Toufique");
        logger.info("Entered First Name");

        newAccountPage.enterLastName("Ansari");
        logger.info("Entered Last Name");

        newAccountPage.enterEmail("toufiq.nt@gmail.com"); 
        logger.info("Entered Invalid Email");

        newAccountPage.enterPassword("Admin@123");
        logger.info("Entered Password");

        newAccountPage.enterConfirmPassword("Admin123");//mismatched password
        logger.info("Entered Confirm Password");

        newAccountPage.clickOnCreateAccountButton();
        logger.info("Clicked on 'Create Account'");

        String actualErrorMsg = newAccountPage.getErrorMessagePasswordMismatched();
        String expectedErrorMsg = "Please enter the same value again.";

        if (actualErrorMsg.equals(expectedErrorMsg)) {
            logger.info("signUpWithMismatchedPassword - Passed");
            Assert.assertTrue(true, "Error message matched as expected.");
        } else {
            logger.error("signUpWithMismatchedPassword - Failed");
            logger.error("Expected: " + expectedErrorMsg);
            logger.error("Actual: " + actualErrorMsg);
            captureScreenShot(driver, "signUpWithInvalidEmailFormat");
            Assert.fail("Email format validation failed.");
        }
		
	}

}
