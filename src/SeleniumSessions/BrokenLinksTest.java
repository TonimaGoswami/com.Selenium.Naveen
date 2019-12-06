package SeleniumSessions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksTest {
	WebDriver driver;

	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/tanu/Downloads/IMP-Drivers/chromedriver");
		driver = new ChromeDriver(); // launch Chrome
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://classic.crmpro.com/index.html"); // get URL
	}

	public void logIn() throws InterruptedException {

		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("naveenk");
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("test123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value = 'Login']")).click();

	}

	public void Links() throws MalformedURLException, IOException {
		driver.switchTo().frame("mainpanel"); // switch to frame
		// get the list of all the links and images
		List<WebElement> Linkslist = driver.findElements(By.tagName("a"));
		Linkslist.addAll(driver.findElements(By.tagName("img")));
		// get the size of  Linkslist
		System.out.println("Size of all links and images -- " + Linkslist.size());

		List<WebElement> activeLinks = new ArrayList<WebElement>();

		// Iterate Linklist -- exclude all links and images that doesn't have href
		// attribute
		for (int i = 0; i < Linkslist.size(); i++) {
		System.out.println(Linkslist.get(i).getAttribute("href"));	
			if (Linkslist.get(i).getAttribute("href") != null && (!Linkslist.get(i).getAttribute("href").contains("javascript") )) {
				activeLinks.add(Linkslist.get(i));
			}

		}
		// get the size of activeLinks list
		System.out.println("Size of active links and images -- " + activeLinks.size());

		// Check the href URL with httpconnection api
		//200 - OK
		//404 - Not found
		// 500- Server error
		//400- Bad request
		
		for(int j=0; j<activeLinks.size(); j++) {
			HttpURLConnection connection = (HttpURLConnection)new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			connection.connect();
			String response = connection.getResponseMessage(); //OK
			connection.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href") + "----->" + response);
		
		
		}
		
		
		
		
	}

	public void tearDown() {
		driver.quit();

	}

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {

		BrokenLinksTest obj = new BrokenLinksTest();
		obj.setUp();
		obj.logIn();
		obj.Links();
		obj.tearDown();

	}

}
