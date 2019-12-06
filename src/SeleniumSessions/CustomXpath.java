package SeleniumSessions;

import java.util.concurrent.TimeUnit;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXpath {
	WebDriver driver;
	
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/tanu/Downloads/IMP-Drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.half.ebay.com");
	    driver.findElement(By.xpath("//input[@class = 'gh-tb ui-autocomplete-input' and @id='gh-ac']")).sendKeys("Java");
		
	}

	public static void main(String[] args) {
		CustomXpath obj = new CustomXpath();
		obj.setUp();

	}

}
