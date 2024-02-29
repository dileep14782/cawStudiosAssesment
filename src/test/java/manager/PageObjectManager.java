package manager;

import cucumber.TestContext;
import org.openqa.selenium.WebDriver;
import pageObjects.Dynamic_Table_PageObjects;

public class PageObjectManager {
    private WebDriver driver;
    private Dynamic_Table_PageObjects dynamicTablePageObjects;

    public PageObjectManager(WebDriver driver){
        this.driver=driver;
    }

    public Dynamic_Table_PageObjects getDynamicTablePage(TestContext testContext){
        return (dynamicTablePageObjects==null)?new Dynamic_Table_PageObjects(driver,testContext):dynamicTablePageObjects;
    }
}
