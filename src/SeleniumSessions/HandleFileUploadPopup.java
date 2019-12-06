package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFileUploadPopup {
	WebDriver driver;

	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/tanu/Downloads/IMP-Drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		

		driver.get("http://html.com/input-type-file/");
	}
	
	public void ConfirmFileUpload() {
		driver.findElement(By.xpath("//input[@id ='fileupload']")).sendKeys("‎⁨/Users/tanu/Downloads/file1");
	}
	
	public void tearDown() {
		driver.quit();
	}

	public static void main(String[] args) {
		HandleFileUploadPopup obj = new HandleFileUploadPopup();
		obj.setUp();
		obj.ConfirmFileUpload();
		obj.tearDown();
	}

}
