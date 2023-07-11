package com.oasissys.main;

import org.openqa.selenium.WebDriver;

import io.cucumber.core.cli.Main;

public class BasePage {

	public static WebDriver driver;
	public static void main(String args[]) throws Throwable {
	    try {
	        Main.main(new String[] { 
	    

	        "-g","com.oasissys.main",
	        "-g","com.oasissys.stepDefs",
	        "-g","com.oasissys.testng.runner",
	                    
	        "classpath:features", 
	        
	        "-t","@SmokeTest",
	        
	                
	        "-p", "pretty", 
	        "-p", "json:target/cucumber-reports/cucumber.json", 
	        "-p", "html:target/cucumber-reports/cucumberreport.html",
	        
	        "-m"
	    }
	    );
	} catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Main method exception : " + e);
	}
	}

}