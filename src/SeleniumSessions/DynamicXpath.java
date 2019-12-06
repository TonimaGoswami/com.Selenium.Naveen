package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicXpath {
	WebDriver driver;

	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/tanu/Downloads/IMP-Drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://classic.crmpro.com/index.html");
	}

	public void logIn() throws InterruptedException {

		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("naveenk");
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("test123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value = 'Login']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text() = 'Contacts']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value= '52660436']")).click();
		

	}

	public void tearDown() {
		driver.quit();

	}

	public static void main(String[] args) throws InterruptedException {
		DynamicXpath obj = new DynamicXpath();
		obj.setUp();
		obj.logIn();
		obj.tearDown();

	}

}
