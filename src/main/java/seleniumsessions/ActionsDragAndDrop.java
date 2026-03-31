package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDragAndDrop {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		Thread.sleep(2000);
		
		By sourceFile = By.id("draggable");
		By targetFile = By.id("droppable");
		
		Actions act = new Actions(driver);
		
	//	act.dragAndDrop(driver.findElement(sourceFile), driver.findElement(targetFile)).perform();
		
		act.clickAndHold(driver.findElement(sourceFile))
			.moveToElement(driver.findElement(targetFile))
			.release()
			.perform();
		
		
	}
	
	
	

}
