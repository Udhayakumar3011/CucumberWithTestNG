package stepDefinitions;



import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import initiliazer.baseSetup;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class TC_ScenarioOutlineTest {
	WebDriver driver;

	@Given("^User navigate the Homepage$")
	public void user_navigate_the_homepage() throws IOException, InterruptedException {
		System.out.println("-------");
		
		if (driver == null) {
			driver = baseSetup.customBrowser();
			driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		}
	}

	@When("^User enter the username as (.+) and password as (.+)$")
	public void user_enter_the_username_as_and_password_as(String user, String pass) throws Throwable {

		WebElement username = driver.findElement(By.id("Email"));
		username.click();
		username.clear();
		username.sendKeys(user);

		WebElement password = driver.findElement(By.id("Password"));
		password.click();
		password.clear();
		password.sendKeys(pass);
	}

	@And("^User Logged In Successfully$")
	public void user_logged_in_successfully() throws Throwable {
		WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
		loginButton.click();
	}

}
