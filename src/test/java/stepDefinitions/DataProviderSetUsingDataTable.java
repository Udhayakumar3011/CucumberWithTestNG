package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import initiliazer.baseSetup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class DataProviderSetUsingDataTable {

	WebDriver driver;

	@Given("^User goes to the Homepage$")
	public void user_goes_to_the_homepage() throws Throwable {

		if (driver == null) {
			driver = baseSetup.customBrowser();
			driver.get("http://djangovinoth.pythonanywhere.com/login/");
		}
	}

	// Without Header Type
	/*
	 * @When("^User enter the username and password$") public void
	 * user_enter_the_username_and_password(DataTable dataTable) throws Throwable {
	 * 
	 * List<List<String>> li = dataTable.asLists(String.class);
	 * 
	 * for (List<String> list : li) {
	 * 
	 * String user = list.get(0); String pass = list.get(1); WebElement username =
	 * driver.findElement(By.id("id_username")); username.click();
	 * username.sendKeys(user); WebElement password =
	 * driver.findElement(By.id("id_password")); password.click();
	 * password.sendKeys(pass);
	 * 
	 * }
	 * 
	 * }
	 */

	// With Header Type

	@When("^User enter the username and password$")
	public void user_enter_the_username_and_password(DataTable dataTable) throws Throwable {

		List<Map<String, String>> li = dataTable.asMaps(String.class, String.class);

		for (Map<String, String> list : li) {
			String user = list.get("username");
			String pass = list.get("password");
			WebElement username = driver.findElement(By.id("id_username"));
			username.click();
			username.sendKeys(user);
			WebElement password = driver.findElement(By.id("id_password"));
			password.click();
			password.sendKeys(pass);
		}

	}

	@And("^User the Logged In Successfully$")
	public void user_the_logged_in_successfully() throws Throwable {
		WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
		loginButton.click();
	}

}
