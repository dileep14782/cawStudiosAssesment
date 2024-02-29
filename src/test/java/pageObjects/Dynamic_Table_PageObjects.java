package pageObjects;

import cucumber.TestContext;
import manager.webDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import selenium.SeleniumActionWrapper;
import selenium.Wait;

public class Dynamic_Table_PageObjects {
    public Dynamic_Table_PageObjects dynamicTablePageObjects;
    public static final long MEDIUM_WAIT=30L;
    WebDriver driver;

    public Dynamic_Table_PageObjects(WebDriver driver, TestContext testContext){
        this.driver=driver;
    }

    @FindBy(how = How.XPATH, using = "//details/summary[text()='Table Data']")
    private WebElement tableDataBtn;
    public WebElement getTableDataBtn(){return tableDataBtn;}

    @FindBy(how = How.ID, using="jsondata")
    private WebElement dataTableInput;
    public WebElement getDataTableInput(){return dataTableInput;}

    public void clickTableData(){
        Wait.untilPageLoadComplete(driver);
        Wait.untilElementVisibleOrClickable(driver,getTableDataBtn(),MEDIUM_WAIT,
                "clickable","TableDataBtn");
        SeleniumActionWrapper.clickElement(driver,getTableDataBtn(),"TableDataBtn");
        Wait.untilPageLoadComplete(driver);
    }
}
