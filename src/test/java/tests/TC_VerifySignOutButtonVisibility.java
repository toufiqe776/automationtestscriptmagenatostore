package tests;

import org.testng.annotations.Test;
import org.testng.Assert;

import pages.HomePage;
import pages.IndexPage;
import pages.LoginPage;

public class TC_VerifySignOutButtonVisibility extends BaseClass {

    @Test
    public void verifySignOutButtonVisibility() {
        logger.info("Test: Verify Sign Out button visibility started");

        // Step 1: Go to Sign In
        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickOnSignIn();

        // Step 2: Login with valid credentials
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("mdtoufique1096@gmail.com");
        loginPage.enterPassword("Toufique@825");
        loginPage.clickOnSignIn();

        logger.info("Logged in successfully");

        // Step 3: Open user menu
        HomePage homePage = new HomePage(driver);
        homePage.clickOnArrowIcon();  // Make sure this reveals the Sign Out button

        // Step 4: Assert Sign Out button visibility
        boolean isVisible = homePage.isSignOutButtonVisible();
        Assert.assertTrue(isVisible, "Sign Out button should be visible after login");

        logger.info("Verified Sign Out button is visible");
    }
}
