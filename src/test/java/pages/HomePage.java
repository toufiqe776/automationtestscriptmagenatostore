package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	 WebDriver driver;

	    public HomePage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    //Web Element 
	    
	    @FindBy(xpath="//span[@class='base']")
	    WebElement homePageHeadingElement;
	    
	    @FindBy(xpath="//div[@class='panel header']//button[@type='button']")
	    WebElement arrowIconElement;
	    
	    @FindBy(xpath="//div[@aria-hidden='false']//a[normalize-space()='Sign Out']")
	    WebElement logoutElement;
	    
	    //Action 
	    // get home page heading 
	    public String getHomePageHeading() {
	    	return homePageHeadingElement.getText().trim();
	    }
	    
	    //clcik on arrow icon 
	    public void clikOnArrowIcon() {
	    	arrowIconElement.click();
	    }
	    public void ClickOnLogoutBtn() {
	    	logoutElement.click();
	    }

}
