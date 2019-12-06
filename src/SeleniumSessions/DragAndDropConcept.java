package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropConcept {

	WebDriver driver;

	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/tanu/Downloads/IMP-Drivers/chromedriver");
		// launch chrome
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://jqueryui.com/droppable/");

	}

	public void dragAndDropTest(){
		// switch to frame 
		driver.switchTo().frame(0);
		
		// create object of Actions class
		Actions action = new Actions(driver);
		
		// Using "action" object drag and drop
		action.clickAndHold(driver.findElement(By.id("draggable")))
		.moveToElement(driver.findElement(By.id("droppable")))
		.release()
		.build()
		.perform();
	}

	public void teardown(){
		driver.quit();
	}

	public static void main(String[] args){
		DragAndDropConcept obj = new DragAndDropConcept();
		obj.setUp();
		obj.dragAndDropTest();
		//obj.teardown();

	}

}
