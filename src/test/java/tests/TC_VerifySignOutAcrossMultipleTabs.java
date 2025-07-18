package tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;


import pages.HomePage;
import pages.IndexPage;
import pages.LoginPage;
import pages.SignoutPage;

public class TC_VerifySignOutAcrossMultipleTabs extends BaseClass {

    @SuppressWarnings("deprecation")
    @Test
    public void verifySignOutAcrossMultipleTabs() {
        logger.info("Starting test: Sign out from multiple tabs");

        // Step 1: Log in
        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickOnSignIn();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("mdtoufique1096@gmail.com");
        loginPage.enterPassword("Toufique@825");
        loginPage.clickOnSignIn();

        logger.info("Logged in successfully");

        // Step 2: Open a new tab and go to account page
        ((JavascriptExecutor) driver).executeScript("window.open();");
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://magento.softwaretestingboard.com/customer/account/");
        logger.info("Opened account page in new tab");

        // Step 3: Switch to first tab and log out
        driver.switchTo().window(tabs.get(0));
        HomePage homePage = new HomePage(driver);
        homePage.clickOnArrowIcon();  
        homePage.clickOnLogoutBtn();
        logger.info("Signed out in first tab");

        // Step 4: Refresh second tab
        driver.switchTo().window(tabs.get(1));
        driver.navigate().refresh();
        logger.info("Refreshed second tab");

        // Step 5: Verify sign-out message
        SignoutPage signoutPage = new SignoutPage(driver);
        String heading = signoutPage.getHeadingMessage();
        Assert.assertEquals("You are signed out", heading);
        logger.info("Verified sign out in both tabs");
    }
}
