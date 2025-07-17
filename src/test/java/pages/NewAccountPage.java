package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object for the "Create New Account" page
 */
public class NewAccountPage {
    WebDriver driver;

    // Constructor
    public NewAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Web Elements

    @FindBy(id = "firstname")
    private WebElement firstName;

    @FindBy(id = "lastname")
    private WebElement lastName;

    @FindBy(id = "email_address")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "password-confirmation")
    private WebElement confirmPassword;

    @FindBy(xpath = "//button[@title='Create an Account']//span[contains(text(),'Create an Account')]")
    private WebElement createAccountButton;
    
    @FindBy(xpath="//div[@id='firstname-error']")
    private WebElement  errorMessage;
    
    @FindBy(xpath="//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    WebElement existEmailErrorMessage;
    
    @FindBy(xpath="//div[@id='email_address-error']")
    WebElement emailFromatErrorMessage;
    
    @FindBy(xpath="//div[@id='password-confirmation-error']")
    WebElement errorMessagePasswordMismatched;
    // Actions

    // Enter first name 
    public void enterFirstName(String fname) {
        firstName.clear();
        firstName.sendKeys(fname);
    }

    // Enter last name 
    public void enterLastName(String lname) {
        lastName.clear();
        lastName.sendKeys(lname);
    }

    /** Enter email address */
    public void enterEmail(String emailAddress) {
        email.clear();
        email.sendKeys(emailAddress);
    }

    /** Enter password */
    public void enterPassword(String pwd) {
        password.clear();
        password.sendKeys(pwd);
    }

    /** Enter confirm password */
    public void enterConfirmPassword(String confirmPwd) {
        confirmPassword.clear();
        confirmPassword.sendKeys(confirmPwd);
    }

    /** Click on "Create an Account" button */
    public void clickOnCreateAccountButton() {
        createAccountButton.click();
    }
    
    //get error message 
    public String getErrorMessage() {
    	return errorMessage.getText();
    }
    //get exist Email Error message 
    public String getExistEmailErrorMessage() {
    	return existEmailErrorMessage.getText();
    }
    //get invalid email format error message
    public String getInvalidEmailFormatErrorMessage() {
    	return emailFromatErrorMessage.getText().trim();
    }
    
    //get error message when password mismatched 
    public String getErrorMessagePasswordMismatched() {
    	return errorMessagePasswordMismatched.getText().trim();
    }
    
    
}
