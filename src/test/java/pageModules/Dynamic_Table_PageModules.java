package pageModules;

import cucumber.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import manager.webDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.Dynamic_Table_PageObjects;
import selenium.SeleniumActionWrapper;
import selenium.Wait;

import java.util.List;

public class Dynamic_Table_PageModules {
    WebDriver driver;

    Dynamic_Table_PageObjects dynamicTablePageObjects;
    public static final long MEDIUM_WAIT = 30L;

    public Dynamic_Table_PageModules(TestContext testContext) {
        driver = testContext.getWebDriverManager().getWebDriver();
        dynamicTablePageObjects = testContext.getPageObjectManager().getDynamicTablePage(testContext);
    }

    @Given("^User navigates to Dynamic Table page$")
    public void userNavigatesToDynamicTablePage (DataTable dataTable){
        List<List<String>> url = dataTable.transpose().asLists();
        driver.get(url.get(0).get(0));
    }

    @When("^User click on Table Data button$")
    public void userClicksOnTableDataButton () {
        dynamicTablePageObjects.clickTableData();
    }

}
