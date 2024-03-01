package pageModules;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import manager.webDriverManager;
import org.openqa.selenium.WebDriver;
import pageObjects.Dynamic_Table_PageObjects;
import java.io.IOException;
import java.util.List;

public class Dynamic_Table_PageModules {
    WebDriver driver;
    Dynamic_Table_PageObjects dynamicTablePageObjects;

    public Dynamic_Table_PageModules() {
        this.driver = webDriverManager.getWebDriver();
        dynamicTablePageObjects=new Dynamic_Table_PageObjects(driver);
    }

    @Given("^User navigates to Dynamic Table page$")
    public void userNavigatesToDynamicTablePage (DataTable dataTable) {
        List<List<String>> url = dataTable.transpose().asLists();
        driver.get(url.get(0).get(0));
    }

    @When("^User click on Table Data button$")
    public void userClicksOnTableDataButton () {
        dynamicTablePageObjects.clickTableData();
    }

    @Then("^User insert data in Table Data Input field$")
    public void userInsertDataInTableDataInputField() {
        dynamicTablePageObjects.insertDataInDataTable();
    }

    @And("^User validates table data and json data$")
    public void userValidatesTableDataAndJsonData() throws IOException {
        dynamicTablePageObjects.validateTableAndJsonData();
    }
}
