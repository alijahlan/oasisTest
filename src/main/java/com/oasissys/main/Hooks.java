package com.oasissys.main;


import io.cucumber.java.After;
		import io.cucumber.java.Before;
		import io.github.bonigarcia.wdm.WebDriverManager;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Hooks {
	public static WebDriver driver;
	static ChromeOptions options = new ChromeOptions();
	@Before
	@SuppressWarnings("unchecked")
	public static void OpenBrowser()
	{
		// 1- Bridge
		WebDriverManager.chromedriver().setup();


		// 2- create object from Chrome browser
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		//3- Configurations
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// 4- navigate to url
		driver.get("https://testplus.oasisapp.services/dhbhp/faces/Home");
	}


	@After
	public static void quitDriver() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}

