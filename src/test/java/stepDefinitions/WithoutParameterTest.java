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

public class WithoutParameterTest {

	WebDriver driver;
	baseSetup base;

	

	@Given("^User is on the Homepage$")
	public void user_is_on_the_homepage() throws Throwable {
		System.out.println("Given");
		if (driver == null) {
			driver = baseSetup.customBrowser();
			driver.get("http://djangovinoth.pythonanywhere.com/login/");
		}

	}

	@When("^User enters the Username$")
	public void user_enters_the_username() throws Throwable {

		WebElement username = driver.findElement(By.id("id_username"));
		username.click();
		username.sendKeys("Udhay");
	}

	@And("^User enters the Password$")
	public void user_enters_the_password() throws Throwable {
		WebElement password = driver.findElement(By.id("id_password"));
		password.click();
		password.sendKeys("u&d@904830");
	}

	@Then("^User should logged in Successfully$")
	public void user_should_logged_in_successfully() throws Throwable {
		WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
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
