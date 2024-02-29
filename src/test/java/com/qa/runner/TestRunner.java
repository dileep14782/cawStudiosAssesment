package com.qa.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import manager.webDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber.html"}
        ,snippets = CAMELCASE
        ,dryRun=true
        ,features={"src/test/resources/features"}
        ,glue={"pageModules"}
        ,monochrome=true
        ,tags = "@Test"
)
public class TestRunner {
    static WebDriver driver;
    @Before
    public static void initializeDriver(){
        driver=webDriverManager.getWebDriver();
    }

    @After
    public static void closeDriver(){
        driver.close();
        driver.quit();
    }
}
