package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class SignoutPage {
	WebDriver driver;
	//constructos 
	public SignoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	//Web Element 
	@FindBy(xpath="//span[@class='base']")
	WebElement signoutHeading;
	
	//action 
	//get varification message 
	public String getHeadingMessage() {
//		wait.until(ExpectedConditions.visibilityOf(signoutHeading));
		return signoutHeading.getText().trim();
	}

}
