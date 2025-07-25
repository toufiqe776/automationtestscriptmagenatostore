package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	 WebDriver driver;
       //constructer
	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    
	    //Web Element 
	    @FindBy(xpath="//input[@id='email']")
	    WebElement emailElement;
	    
	    @FindBy(xpath="//fieldset[@class='fieldset login']//input[@id='pass']")
	    WebElement passwordElement;
	    
	    @FindBy(xpath="//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]")
	    WebElement signInBtn;
	    
	    @FindBy(xpath="//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	    WebElement errorMessage;
	    
	    @FindBy(xpath="//div[@id='email-error']")
	    WebElement errorMessageValidPassword;
	    
	    @FindBy(xpath="//div[@id='email-error']")
	    WebElement errorMessageBothBlank;
	    
	    @FindBy(xpath="//span[@class='base']")
	    WebElement loginPageHeading;
	    //action 
	    //enter email 
	    public void enterEmail(String email) {
	    	emailElement.clear();
	    	emailElement.sendKeys(email);
	    }
	    //enter password 
	    public void enterPassword(String password) {
	    	passwordElement.clear();
	    	passwordElement.sendKeys(password);
	    }
	    
	    //click on sign in btn 
	    public void clickOnSignIn() {
	    	signInBtn.click();
	    }
	    //get error message when enter invalid password 
	    public String getErrorMessage() {
	    	return errorMessage.getText().trim();
	    }
	    //get error message enter valid password 
	    public String getErrorMessageValidPassword() {
	    	return errorMessageValidPassword.getText().trim();
	    }
	    
	    //get error message when errorMessageBothBlank
	    public String getErrorMessageBothBlanks() {
	    	return errorMessageBothBlank.getText().trim();
	    }
	    
	    //get login page  heading 
	    public String  getLoginPageHeading() {
	    	return loginPageHeading.getText().trim();
	    }
	    

}
