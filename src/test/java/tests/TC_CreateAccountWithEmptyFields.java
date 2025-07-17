package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;


import pages.IndexPage;
import pages.NewAccountPage;

public class TC_CreateAccountWithEmptyFields  extends BaseClass{
	@Test
	public void createAccountWithEmptyFileds() {
		 logger.info("*** Test Case: Sign-up started ***");

	        IndexPage indexPage = new IndexPage(driver);
	        indexPage.clickOnCreateAccount();
	        logger.info("Clicked on 'Create an Account'");
	        
	        NewAccountPage newAccountPage = new NewAccountPage(driver);
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0, 500);");

	        newAccountPage.clickOnCreateAccountButton();
	        
	       String actualErrorMessage= newAccountPage.getErrorMessage();
	        logger.info("Retrieved error message:" + actualErrorMessage);
	        String expectedErrorMessage="This is a required field.";
	        Assert.assertEquals(actualErrorMessage, expectedErrorMessage,"\"FAIL: Error message does not match!\"");
	        logger.info("*** Test Case: Sign-up with empty fields  completed successfully ***");
	        
	        
	        
	}

}
