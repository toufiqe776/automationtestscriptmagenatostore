package tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AccountPage;
import pages.NewAccountPage;
import pages.IndexPage;

public class CreateNewCustomerAccount extends BaseClass {

    @Test
    public void createNewCustomerAccountWithAllRequiredFields() throws IOException {
        logger.info("*** Test Case: Sign-up started ***");

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

        newAccountPage.clickOnCreateAccount();
        logger.info("Clicked on 'Create Account'");

        AccountPage accountPage = new AccountPage(driver);
        String actualText = accountPage.getMyAccountText();
        logger.info("Retrieved text from account page: " + actualText);

        String expectedText = "My Account";
        Assert.assertEquals(actualText, expectedText, "FAIL: 'My Account' heading does not match!");
        logger.info("*** Test Case: Sign-up completed successfully ***");
    }
}
