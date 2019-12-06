package SeleniumSessions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TakeScreenshot {
	WebDriver driver;

	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/tanu/Downloads/IMP-Drivers/chromedriver");
		// launch chrome
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public void takeScreenshotTest() throws IOException {
		// pass the URL
		driver.get("http://www.google.com");

		// Take screenshot and store as a file format
		//File MyFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// now copy the screenshot to desired location using copyFile method
		//FileUtils.copyFile(MyFile, new File("Users/tanu/eclipse-workspace/com.Selenium.Naveen/Google.png"));

	}

	public void tearDown() {
		driver.quit();
	}

	public static void main(String[] args) throws IOException {
		TakeScreenshot obj = new TakeScreenshot();
		obj.setUp();
		obj.takeScreenshotTest();
		obj.tearDown();

	}

}
