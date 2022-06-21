package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/resources/features/", glue = "stepDefinitions", monochrome = true, dryRun = false, plugin = {

		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"html:target/cucumber-reports/report.html", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
		"pretty" }, publish = true)

//Rerun-@target/failed_scenarios.txt
//Rerun Plugin-"rerun:target/failed_scenarios.txt"

//Install nodeJS in your Machine
//Allure Reports:
//npm install -g allure-commandline
//allure serve

/*
 * plugin = { "html:report/WebReports", "json:report/jsonreport.json",
 * "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
 * "html:target/cucumber-reports/report.html",
 * "json:target/cucumber-report.json",
 * "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm", "pretty" },
 */


public class Runner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {

		return super.scenarios();
	}

}