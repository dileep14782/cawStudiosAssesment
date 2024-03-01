package com.qa.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber.html"}
        ,dryRun=false
        ,features={"src/test/resources/features"}
        ,glue={"pageModules"}
)
public class TestRunner {

}
