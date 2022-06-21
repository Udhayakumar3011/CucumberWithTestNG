package initiliazer;


import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class baseSetup {
	public static WebDriver driver = null;

	public static WebDriver customBrowser() throws IOException {
		String browser = getPropertyData("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./src\\test\\resources\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./src\\test\\resources\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}
		return driver;

	}

	public static String getPropertyData(String key) throws IOException {

		String value;
		FileReader fr = new FileReader("./src\\test\\resources\\PropertyFileReader\\testData.Properties");

		Properties p = new Properties();
		p.load(fr);
		value = p.getProperty(key);

		return value;

	}

	public static String timeStamp() {
		return new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new Date());
	}

	@AfterStep
	public void attachScreenshot(Scenario scenario) {

		if (scenario.isFailed()) {
			byte[] src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(src, "image/png", " " + timeStamp());

		}
	}
}
