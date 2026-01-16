package Cucumber.Options;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/main/java/featureFiles", glue="stepDefinitions",  
tags="@Reg",
plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"json:target/jsonReports/cucumber.json"
})
public class TestRunner extends AbstractTestNGCucumberTests {

	
}
