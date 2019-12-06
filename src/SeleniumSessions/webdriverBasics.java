package SeleniumSessions;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class webdriverBasics {

	WebDriver driver;

	public void setUp() {
		//Launch CHROME browser:-
		// For Windows C:\\downloads\\geckodriver.exe
		// System.setProperty("webdriver.chrome.driver", "/Users/tanu/Downloads/IMP-Drivers/chromedriver");
		// driver = new ChromeDriver();
		
		//Launch FIREFOX browser:-
		System.setProperty("webdriver.gecko.driver", "/Users/tanu/Downloads/IMP-Drivers/geckodriver");
		driver = new FirefoxDriver(); 						// Launch Firefox browser
		driver.get("http://www.google.com"); 				// get URL
		String title = driver.getTitle(); 					// get title
		System.out.println(title);

		// validation point
		if (title.equals("Google")) {
			System.out.println("Correct title");

		} else {
			System.out.println("in-correct title");
		}

		System.out.println(driver.getCurrentUrl()); 			// get current URL
		
		//System.out.println(driver.getPageSource());          // get page source
	}

	
	public void tearDown() {
		driver.quit();							           // quit the browser
	}
	public static void main(String[] args) {
		webdriverBasics obj = new webdriverBasics();
		obj.setUp();
		obj.tearDown();

	}

}
