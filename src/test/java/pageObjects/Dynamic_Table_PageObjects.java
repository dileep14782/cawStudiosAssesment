package pageObjects;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonParser;
import customJsonObject.CustomJsonObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.SeleniumActionWrapper;
import selenium.Wait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Dynamic_Table_PageObjects {
    public static final long MEDIUM_WAIT = 30L;
    private final String jsonPath="src/test/resources/testInput/jsonData.json";
    WebDriver driver;

    public Dynamic_Table_PageObjects(WebDriver driver) {
        this.driver = driver;
    }

    By tableDataBtn = By.xpath("//details/summary[text()='Table Data']");
    By dataTableInput = By.id("jsondata");
    By dataTableRefreshBtn=By.id("refreshtable");
    By dataTable=By.id("dynamictable");


    public void clickTableData() {
        Wait.untilPageLoadComplete(driver);
        WebElement getTableDataBtn = driver.findElement(tableDataBtn);
        Wait.untilElementVisibleOrClickable(driver, getTableDataBtn, MEDIUM_WAIT,
                "clickable", "TableDataBtn");
        SeleniumActionWrapper.clickElement(driver, getTableDataBtn, "TableDataBtn");
        Wait.untilPageLoadComplete(driver);
    }

    public void insertDataInDataTable() {
        WebElement getDataTableInput = driver.findElement(dataTableInput);
        WebElement getDataTableRefreshBtn=driver.findElement(dataTableRefreshBtn);
        Wait.untilElementVisibleOrClickable(driver, getDataTableInput, MEDIUM_WAIT, "clickable",
                "DataTableInput");
        getDataTableInput.clear();
        getDataTableInput.sendKeys(readJson(jsonPath).toString());
        getDataTableRefreshBtn.click();
    }

    public void validateTableAndJsonData() throws IOException{
        ObjectMapper mapper=new ObjectMapper();
        Assert.assertEquals("Json Input and the data in HTML Data are not matching.",
                mapper.readTree(readJson(jsonPath).toString()),
                        mapper.readTree(htmlToJson().toString()));
    }

//    To get the json as object from the json file
    public Object readJson(String jsonPath) {
        JsonParser jsonParser = new JsonParser();
        try {
            FileReader reader = new FileReader(jsonPath);
            Object jsonData = jsonParser.parse(reader);

            return jsonData;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public JSONArray htmlToJson(){
        WebElement dataTableElement=driver.findElement(dataTable);
//      Storing the outer HTML of the data table to retrieve the data
        final String HTML=dataTableElement.getAttribute("outerHTML");
        System.out.println(HTML);
        Document document= Jsoup.parse(HTML);
        Element table = document.select("table").first();
        JSONArray jsonArr = new JSONArray();
        Elements rows = table.getElementsByTag("tr");
        Elements titles=rows.get(0).getElementsByTag("th");
        for (int i = 1;i< rows.size();i++) {
            //Custom JSONObject to maintain the order of key-value pairs
            JSONObject jo= CustomJsonObject.printJSONObject();
            Elements columns=rows.get(i).getElementsByTag("td");
            for(int j=0;j<columns.size();j++) {
                jo.put(titles.get(j).text(), columns.get(j).text());
            }
            jsonArr.put(jo);
        }
        System.out.println(jsonArr);
        return jsonArr;
    }
}
