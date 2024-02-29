package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumActionWrapper {

    public static WebElement clickElement(WebDriver driver,WebElement element, String elementName){
        Wait.untilPageLoadComplete(driver);
        element.click();
        return element;
    }
}
