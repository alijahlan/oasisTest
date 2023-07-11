package com.oasissys.stepDefs;

import java.security.Key;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import com.oasissys.main.Hooks;
import com.oasissys.utils.DashboardElements;
import com.oasissys.utils.LoginPageElements;
import com.oasissys.utils.SplashHomeElements;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.oasissys.main.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then; 
public class F1LoginStepDef extends BasePage {

	
	@Given("User login to Oasissys app with UserName and Password")
	public void loginToOasissysApp(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

		List<List<String>> cells = dataTable.cells();
		Hooks.driver.findElement(By.xpath(LoginPageElements.usernameInputField)).sendKeys(cells.get(0).get(0));
		Hooks.driver.findElement(By.xpath(LoginPageElements.passwordInputField)).sendKeys(cells.get(0).get(1));
		Hooks.driver.findElement(By.xpath(LoginPageElements.loginButton)).click();
		Thread.sleep(1000);


		if (Hooks.driver.findElements(By.xpath(LoginPageElements.sessionCancelButton)).size() > 0){
			Hooks.driver.findElement(By.xpath(LoginPageElements.sessionCancelButton)).click();
			//System.out.println(Hooks.driver.findElement(By.xpath(LoginPageElements.sessionCancelButton)).getTagName());
		}

		Thread.sleep(3000);
	}

	@Then("Click on the left side menu")
	public void clickOnTheMenu() throws InterruptedException {
		Hooks.driver.findElement(By.className(SplashHomeElements.menuIcon)).click();
		Thread.sleep(2000);
	}

	@Then("User select Manage Approvals from the menu")
	public void selectManageApprovals() throws InterruptedException {
		Hooks.driver.findElement(By.xpath(SplashHomeElements.manageApprovalsLink)).click();
		Thread.sleep(5000);
	}

	@Then("Click on the data and select 01 jan 2022")
	public void changeTheDate() throws InterruptedException {
		Hooks.driver.findElement(By.xpath(DashboardElements.datePickerIcon)).click();
		Thread.sleep(2000);
		//Hooks.driver.findElement(By.xpath(DashboardElements.decrementIcon)).click();

		//Select month = new Select(Hooks.driver.findElement(By.xpath(DashboardElements.selectMonthDropDown)));
		//month.selectByVisibleText("January");
		//Hooks.driver.findElement(By.xpath(DashboardElements.dayNumber)).click();
		Hooks.driver.findElement(By.xpath(DashboardElements.dateInputField)).sendKeys("01-01/2022");
		Hooks.driver.findElement(By.xpath(DashboardElements.dateInputField)).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	@Then("Validate Posted label contains 94")
	public void validatePostedNumber() throws InterruptedException {
		String actualPosted = Hooks.driver.findElement(By.xpath(DashboardElements.posted)).getText();
		String expectedPosted = "94";

		Assert.assertEquals(actualPosted,expectedPosted,"The expected value doesn't equal to the actual value");
		Thread.sleep(5000);
	}

	@Then("User logout from the system")
	public void logoutFromTheSystem(){
		Hooks.driver.findElement(By.xpath(SplashHomeElements.logoutButton)).click();
	}


}