package selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumJSUtils {
    public static void scrollPageToElementAlignToBottom(WebDriver driver, WebElement webElement,String ElementName){
        Wait.untilPageLoadComplete(driver);
        String scrollToElementJS="arguments[0].scrollOntoView(false);";
        ((JavascriptExecutor)driver).executeScript(scrollToElementJS,webElement);
        Wait.untilPageLoadComplete(driver);
    }
}
