package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // initialize WebDriverWait
    }

    // Web Elements
    @FindBy(xpath = "//span[@class='base']")
    WebElement homePageHeadingElement;

    @FindBy(xpath = "//div[@class='panel header']//button[@type='button']")
    WebElement arrowIconElement;

    @FindBy(xpath = "//div[@aria-hidden='false']//a[normalize-space()='Sign Out']")
    WebElement logoutElement;

    // Actions

    // Get home page heading
    public String getHomePageHeading() {
        return homePageHeadingElement.getText().trim();
    }

    // Click on arrow icon
    public void clickOnArrowIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(arrowIconElement)).click();
    }

    // Click on Logout
    public void clickOnLogoutBtn() {
        logoutElement.click();
    }

    // Check if sign out button is visible
    public boolean isSignOutButtonVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOf(logoutElement));
            return logoutElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
