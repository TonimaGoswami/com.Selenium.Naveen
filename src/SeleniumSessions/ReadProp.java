package SeleniumSessions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadProp {
	

	public static void main(String[] args) throws IOException, InterruptedException {
		 WebDriver driver = null;
		//how to read properties file
		// 1. create object of properties class available in java.util
		Properties prop = new Properties();
		
		// 2. create object of FileInputStream class available in java.io
		FileInputStream ip = new FileInputStream("/Users/tanu/eclipse-workspace/com.Selenium.Naveen/src/SeleniumSessions/Config.properties");
		
		// 3. with prop object load the properties file streaming it through ip object
		prop.load(ip);
		
		System.out.println(prop.getProperty("browser"));
		
		String browserName =prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/tanu/Downloads/IMP-Drivers/chromedriver");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "/Users/tanu/Downloads/IMP-Drivers/geckodriver");
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("No browser value is given");
		}
		driver.get(prop.getProperty("url"));
		driver.findElement(By.className(prop.getProperty("freecrm_logoimage_classname"))).isDisplayed();
		driver.findElement(By.name(prop.getProperty("username_name"))).sendKeys(prop.getProperty("username"));
		driver.findElement(By.name(prop.getProperty("password_name"))).sendKeys(prop.getProperty("password"));
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("loginBtn_Xpath"))).click();
}
}