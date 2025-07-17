package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.IndexPage;
import pages.NewAccountPage;

public class TC_SignUpWithMismatchedPassword extends BaseClass {
	@Test
	public void signUpWithMismatchedPassword() {
		 logger.info("*** Test Case: Sign Up With Invalid Email Format ***");

	        IndexPage indexPage = new IndexPage(driver);
	        indexPage.clickOnCreateAccount();
	        logger.info("Clicked on 'Create an Account'");

	        NewAccountPage newAccountPage = new NewAccountPage(driver);
	        newAccountPage.enterFirstName("Toufique");
	        logger.info("Entered First Name");

	        newAccountPage.enterLastName("Ansari");
	        logger.info("Entered Last Name");

	        newAccountPage.enterEmail("toufiq.com"); // Invalid email format
	        logger.info("Entered Invalid Email");

	        newAccountPage.enterPassword("Admin@123");
	        logger.info("Entered Password");

	        newAccountPage.enterConfirmPassword("Admin@123");
	        logger.info("Entered Confirm Password");

	        newAccountPage.clickOnCreateAccountButton();
	        logger.info("Clicked on 'Create Account'");

	        String actualErrorMsg = newAccountPage.getInvalidEmailFormatErrorMessage();
	        String expectedErrorMsg = "Please enter a valid email address (Ex: johndoe@domain.com).";

	        if (actualErrorMsg.equals(expectedErrorMsg)) {
	            logger.info("signUpWithInvalidEmailFormat - Passed");
	            Assert.assertTrue(true, "Error message matched as expected.");
	        } else {
	            logger.error("signUpWithInvalidEmailFormat - Failed");
	            logger.error("Expected: " + expectedErrorMsg);
	            logger.error("Actual: " + actualErrorMsg);
	            captureScreenShot(driver, "signUpWithInvalidEmailFormat");
	            Assert.fail("Email format validation failed.");
	        }
	    }
	}

}
