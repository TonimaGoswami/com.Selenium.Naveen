package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {
	WebDriver driver;
public void setUp() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "/Users/tanu/Downloads/IMP-Drivers/chromedriver");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	driver.get("https://classic.crmpro.com/index.html");
	driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("naveenk");
	driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("test123");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@type = 'submit']")).click();
	
}

public void SwitchToFrame() throws InterruptedException {
	//driver.switchTo().frame("mainpanel");
	driver.switchTo().frame(1);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();

}


public void tearDown() {
	driver.quit();
}
	
	
	
	public static void main(String[] args) throws InterruptedException {
		FrameHandling obj = new FrameHandling();
		obj.setUp();
		obj.SwitchToFrame();
		obj.tearDown();

	}

}
