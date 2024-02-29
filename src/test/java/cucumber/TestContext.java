package cucumber;

import io.github.bonigarcia.wdm.WebDriverManager;
import manager.PageObjectManager;
import manager.webDriverManager;

public class TestContext {
    private webDriverManager webDriverManager;
    private PageObjectManager pageObjectManager;
    public TestContext(){
        if(webDriverManager==null){
            webDriverManager=new webDriverManager();
        }
        pageObjectManager=new PageObjectManager(webDriverManager.getWebDriver());
    }

    public PageObjectManager getPageObjectManager(){
        return pageObjectManager;
    }
    public webDriverManager getWebDriverManager(){
        return webDriverManager;
    }
}
