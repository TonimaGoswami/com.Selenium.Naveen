package SeleniumSessions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindowPopUp {
	WebDriver driver;

	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/tanu/Downloads/IMP-Drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.popuptest.com");

	}

	public void windowPopUptest() {
		// click the link "Come & Go Test"
		driver.findElement(By.linkText("Come & Go Test")).click();

		// Create a Handler object
		Set<String> handler = driver.getWindowHandles();

		// Create an iterator to iterate through set as we can't use index to itearte in
		// case of set
		Iterator<String> it = handler.iterator();

		// get Parent window id using iterator by using iterator.next() method
		String ParentWindowId = it.next();
		System.out.println("Parent window Id: " + ParentWindowId);

		// get Child window id using iterator by using iterator.next() method
		String ChildWindowId = it.next();
		System.out.println("Child window Id: " + ChildWindowId);

		// Switch to child window popup using ChildWindowId and get title
		driver.switchTo().window(ChildWindowId);
		System.out.println("Child window popup title: " + driver.getTitle());

		// Close the child window
		driver.close();

		// switch back to parent window and get title
		driver.switchTo().window(ParentWindowId);
		System.out.println("Parent window popup title: " + driver.getTitle());
	}

	public void tearDown() {
		// close all the windows
		driver.quit();
	}

	public static void main(String[] args) {
		HandleWindowPopUp obj = new HandleWindowPopUp();
		obj.setUp();
		obj.windowPopUptest();
		obj.tearDown();

	}

}
