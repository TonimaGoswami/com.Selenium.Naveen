package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocatorConcept {
	WebDriver driver;

	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "/Users/tanu/Downloads/IMP-Drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F");

		// By XPATH:
		// absolute xpath shouldn't be used
		// relative xpath should be used
		
		// driver.findElement(By.xpath("//*[@id = 'firstname']")).sendKeys("Tanu");
		// driver.findElement(By.xpath("//*[@id = 'lastname']")).sendKeys("Joseph");
		// driver.findElement(By.xpath("//*[@id =
		// 'email']")).sendKeys("tonimagoswami@gmail.com");
		// driver.findElement(By.xpath("//*[@id =
		// 'PASSWORD']")).sendKeys("secret@missioN");

		// By ID:

		// driver.findElement(By.id("firstname")).sendKeys("Tanu");
		// driver.findElement(By.id("lastname")).sendKeys("Joseph");
		// driver.findElement(By.id("email")).sendKeys("tonimagoswami@gmail.com");
		// driver.findElement(By.id("PASSWORD")).sendKeys("secret@missioN");

		// By NAME:

		// driver.findElement(By.name("firstname")).sendKeys("Tanu");
		// driver.findElement(By.name("lastname")).sendKeys("Joseph");
		// driver.findElement(By.name("email")).sendKeys("tonimagoswami@gmail.com");
		// driver.findElement(By.name("PASSWORD")).sendKeys("secret@missioN");

		// By linktext: (Use only for links)

		// driver.findElement(By.linkText("Sign in")).click();

		// By partiallinktext: (Use only for links)

		// driver.findElement(By.partialLinkText("Create a")).click();

		// By CSS selector:
		// if id is there ----("#id")
		// if class is there ----(".classname")
		// driver.findElement(By.cssSelector("#firstname")).sendKeys("Tanu");
		// driver.findElement(By.cssSelector("#lastname")).sendKeys("Joseph");
		// driver.findElement(By.cssSelector("#email")).sendKeys("tonimagoswami@gmail.com");
		// driver.findElement(By.cssSelector("#PASSWORD")).sendKeys("secret@missioN");
		
		
		// By classname:
		 driver.findElement(By.cssSelector("#firstname")).sendKeys("Tanu");
		 driver.findElement(By.cssSelector("#lastname")).sendKeys("Joseph");
		 driver.findElement(By.cssSelector("#email")).sendKeys("tonimagoswami@gmail.com");
		 driver.findElement(By.cssSelector("#PASSWORD")).sendKeys("secret@missioN");
		 driver.findElement(By.className("checkbox__control")).click();

	}

	public void tearDown() {

		driver.quit();
	}

	public static void main(String[] args) {

		LocatorConcept obj = new LocatorConcept();

		obj.setUp();
		// obj.tearDown();

	}

}
