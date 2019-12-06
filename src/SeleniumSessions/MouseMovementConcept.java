package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovementConcept {
	WebDriver driver;
	
public void setUp(){
	System.setProperty("webdriver.chrome.driver", "/Users/tanu/Downloads/IMP-Drivers/chromedriver");
	//launch chrome
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
}
public void mouseHoverTest() throws InterruptedException {	

//get URL
	driver.get("http://www.spicejet.com");
	Actions action = new Actions(driver);
	
	action.moveToElement(driver.findElement(By.id("ctl00_HyperLinkLogin"))).build().perform();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Travel Agent Login")).click();
	
	
	
}

public void tearDown() {
	driver.quit();
}

	public static void main(String[] args) throws InterruptedException {
		MouseMovementConcept obj = new MouseMovementConcept();
		obj.setUp();
		obj.mouseHoverTest();
		obj.tearDown();

	}

}
