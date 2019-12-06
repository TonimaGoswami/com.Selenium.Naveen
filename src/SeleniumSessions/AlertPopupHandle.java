package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AlertPopupHandle {
	WebDriver driver;

	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/tanu/Downloads/IMP-Drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	}

	public void Confirm_popUp() throws InterruptedException {
		driver.findElement(By.name("proceed")).click(); // clicking on Go button
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText()); // get the text on the popup
		
		String text = alert.getText();      // Validation of alert 
		if(text.equals("Please enter a valid user name")) {
			System.out.println("Correct alert message");
		}
		else {
			System.out.println("Incorrect alert message");
		}
		
		alert.accept(); // click on OK btn on popup
	}
	
	public void tearDown() {
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		AlertPopupHandle obj = new AlertPopupHandle();
		obj.setUp();
		obj.Confirm_popUp();
		obj.tearDown();

	}

}
