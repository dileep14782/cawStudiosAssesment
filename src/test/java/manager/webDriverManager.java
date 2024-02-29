package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class webDriverManager {
    private static WebDriver webDriver;

    public webDriverManager(){

    }

    public  static WebDriver getWebDriver(){
        if(webDriver!=null){
            return webDriver;
        }else{
            return createWebDriver();
        }
    }

    public static WebDriver createWebDriver(){
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        webDriver = io.github.bonigarcia.wdm.WebDriverManager.chromedriver().capabilities(co).create();
        return webDriver;
    }
}
