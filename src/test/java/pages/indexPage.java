package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {
	
	 WebDriver driver;

	    public indexPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
        //find create account web element 
	    @FindBy(xpath="")
	    WebElement createAccountElement;
	    
	    //click on create account for new account 
	    public void ClickOnCreateAcoount() {
	    	createAccountElement.click();
	    }
}
