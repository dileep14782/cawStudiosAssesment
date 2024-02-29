package selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class Wait {
    public static final Long TimeOutInSeconds= (long) (30000/1000);
    public static void untilPageLoadComplete(WebDriver driver){untilPageLoadComplete(driver,TimeOutInSeconds);}
    public static void untilPageLoadComplete(WebDriver driver, Long timeoutInSeconds){
        until(driver,(d)->
        {
            Boolean isPageLoaded=((JavascriptExecutor)driver).executeScript("return document.readyState").
                    equals("complete");
            if(!isPageLoaded)
                System.out.println("Page is loading .....");
            else
                System.out.println("Page is loaded completely.");
            return isPageLoaded;
        }, timeoutInSeconds);
    }

    public static void until(WebDriver driver, Function<WebDriver,Boolean> waitCondition,Long timeOutInSeconds){
        WebDriverWait webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        webDriverWait.withTimeout(Duration.ofSeconds(timeOutInSeconds));
        try{
            webDriverWait.until(waitCondition);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void untilElementVisibleOrClickable(WebDriver driver, WebElement wb, long timeOutInSeconds,
                                                      String type, String ElementName){
        String status="Element not visible";
        try{
            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeOutInSeconds));
            switch(type){
                case "visible":
                    wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(wb));
                    status="Element visible";
                    break;
                case "clickable":
                    wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.
                            elementToBeClickable(wb));
                    status="Element clickable";
                    break;
                default:
                    break;
            }
        }catch(Exception e){
            System.out.println(ElementName+" on page: "+e);
        }
    }
}
