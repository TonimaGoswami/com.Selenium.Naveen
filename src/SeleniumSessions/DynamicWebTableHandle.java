package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTableHandle {
	WebDriver driver;
	
public void setUp() {
	System.setProperty("webdriver.chrome.driver", "/Users/tanu/Downloads/IMP-Drivers/chromedriver");
	driver = new ChromeDriver();  	// launch Chrome
	
	//driver.manage().window().fullscreen();
	driver.manage().deleteAllCookies();
	// dynamic waits
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.get("http://www.freecrm.com");   // enter URL
	
	driver.findElement(By.linkText("Log In")).click();
	//Thread.sleep(3000);
	
}

public void tearDown() {
	driver.quit();
}

public static void main(String[] args) {
		DynamicWebTableHandle obj = new DynamicWebTableHandle();
		obj.setUp();
		obj.tearDown();

	}

}
