package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchBox {
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

	public void searchBoxtest() {
		// navigate to the application homepage
		driver.get("http://www.google.com");

		// get the search textbox
		WebElement search_field = driver.findElement(By.xpath("//div[@id='fakebox-text']"));
		search_field.clear();

		// Enter search keyword and submit
		//search_field.sendKeys("Selenium interview questions and answers");
		//search_field.submit();

	}
	public void tearDown() {
		driver.quit();
	}

	public static void main(String[] args) {
		GoogleSearchBox obj = new GoogleSearchBox();
		obj.setUp();
		obj.searchBoxtest();
		obj.tearDown();

	}

}
