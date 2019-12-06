package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropbox {

	WebDriver driver;

	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "/Users/tanu/Downloads/IMP-Drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.get("https://www.ebay.com");
		
		Select select = new Select(driver.findElement(By.id("gh-cat")));
		select.selectByVisibleText("Antiques");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id = 'gh-btn']")).click();
		
	}

	public void tearDown() {

		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		HandleDropbox obj = new HandleDropbox();

		obj.setUp();
		obj.tearDown();

	}

}
