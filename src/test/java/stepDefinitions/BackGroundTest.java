package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import initiliazer.baseSetup;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BackGroundTest {

	WebDriver driver;

	@Before(order = 0)
	public void before1() {
		System.out.println("Before1");
	}
	@Before(order = 1)
	public void before2() {
		System.out.println("Before2");
	}

	@BeforeStep
	public void beforeStep() {
		System.out.println("Before Step");
	}

	@Given("^User is on Login Page$")
	public void user_is_on_login_page() throws IOException, InterruptedException {
		if (driver == null) {
			driver = baseSetup.customBrowser();
			Thread.sleep(3000);
			driver.get("http://djangovinoth.pythonanywhere.com/login/");
		}
	}

	@When("^User entering the Username$")
	public void user_entering_the_username() throws Throwable {
		WebElement username = driver.findElement(By.id("id_username"));
		username.click();
		username.sendKeys("Udhay");
	}

	@Then("^User LoggedIn Successfully$")
	public void user_loggedin_successfully() throws Throwable {
		WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
		loginButton.click();
	}

	@And("^User entering the Password$")
	public void user_entering_the_password() throws Throwable {
		WebElement password = driver.findElement(By.id("id_password"));
		password.click();
		password.sendKeys("u&d@904830");
	}

	@And("^User the Clicks the Home Tab$")
	public void user_the_clicks_the_home_tab() throws Throwable {

		WebElement home = driver
				.findElement(By.xpath("//div[@class='navbar-nav mr-auto']//following::a[contains(text(),'Home')]"));

		home.click();
	}

	@And("^User the Clicks the About Us Tab$")
	public void user_the_clicks_the_about_us_tab() throws Throwable {

		WebElement about = driver
				.findElement(By.xpath("//div[@class='navbar-nav mr-auto']//following::a[contains(text(),'About')]"));
		about.click();
	}

	@After(order = 0)
	public void after1() {
		System.out.println("After1");
	}
	@After(order = 1)
	public void after2() {
		System.out.println("After2");
	}

	@AfterStep
	public void afterStep() {
		System.out.println("After Step");
	}
}
