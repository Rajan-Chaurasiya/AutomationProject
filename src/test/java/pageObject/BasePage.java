package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * BasePage class that serves as a base for all page objects.
 * It initializes the WebDriver and PageFactory elements.
 */
public class BasePage {
    // WebDriver instance
    WebDriver driver;

    /**
     * Constructor to initialize the WebDriver and PageFactory elements.
     * 
     * 
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
