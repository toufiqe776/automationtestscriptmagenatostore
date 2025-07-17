package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
	
	 WebDriver driver;

	    public IndexPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    // Web Elements
	    @FindBy(xpath="//div[@class='panel header']//a[normalize-space()='Create an Account']")
	    WebElement createAccountElement;
	    
	    @FindBy(xpath="//div[@class='panel header']//a[contains(text(),'Sign In')]")
	    WebElement signIn;
	    //action 
	    //click on create account for new account 
	    public void clickOnCreateAccount() {
	    	createAccountElement.click();
	    }
	    
	    //click on sign in 
	    public void clickOnSignIn()
	    {
	    	signIn.click();
	    }
	    
	    
}
