package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import initiliazer.baseSetup;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ParameterViaFeatureFile {

	WebDriver driver;


	@Given("^User is Navigate to the Homepage$")
	public void user_is_navigate_to_the_homepage() throws Throwable {
		System.out.println("Given Data");
		if (driver == null) {
			driver = baseSetup.customBrowser();
			driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		}
	}

	@When("^User enter the Username as \"([^\"]*)\"$")
	public void user_enter_the_username_as_something(String str) throws Throwable {
		WebElement username = driver.findElement(By.id("Email"));
		username.click();
		username.clear();
		username.sendKeys(str);
	}

	@And("^User enter the Password as \"([^\"]*)\"$")
	public void user_enter_the_password_as_something(String str) throws Throwable {
		WebElement password = driver.findElement(By.id("Passwor"));
		password.click();
		password.clear();
		password.sendKeys(str);
	}

	@Then("^User loggedin Successfully$")
	public void user_loggedin_successfully() throws Throwable {
		WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
		loginButton.click();

	}

	@AfterStep
	public void attachScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(src, "image/png", "");
		}

	}

}
