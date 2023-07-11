package com.oasissys.testng.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

		tags = "@SmokeTest",

		features = "classpath:features", glue = { "com.oasissys.main", "com.oasissys.stepDefs",
				"com.oasissys.testng.runner" },

		plugin = { "pretty", "json:target/cucumber-reports/cucumber.json",
				"html:target/cucumber-reports/cucumberreport.html" },

		monochrome = true)
public class RunCucumberTest extends AbstractTestNGCucumberTests {

}