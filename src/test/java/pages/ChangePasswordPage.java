package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage {
	 WebDriver driver;

	    public ChangePasswordPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        
	    }
	    // Web Element 
	    @FindBy(xpath="//input[@id='current-password']")
	    WebElement currentPassword;
	    
	    @FindBy(xpath="//input[@id='password']")
	    WebElement newPassword;
	    
	    @FindBy(xpath="//input[@id='password-confirmation']")
	    WebElement confimNewPassword;
	    
	    @FindBy(xpath="//span[normalize-space()='Save']")
	    WebElement saveButtonElement; 
	    
	    //Action 
	    //enetr   current password 
	    public void enterCurrentPassword(String currentpassword) {
	    	currentPassword.clear();
	    	currentPassword.sendKeys(currentpassword);
	    }
	    //enter new password 
	    public void enterOnNewPassword(String newpassword) {
	    	newPassword.clear();
	    	newPassword.sendKeys(newpassword);
	    }
	    
	    //enter confimnew password 
	    public void enterConfirmNewPassword(String confirmnewpassword) {
	    	confimNewPassword.clear();
	    	confimNewPassword.sendKeys(confirmnewpassword);
	    }
	    //click on save button 
	    public void clickOnSaveBtn() {
	    	saveButtonElement.click();
	    }

}
