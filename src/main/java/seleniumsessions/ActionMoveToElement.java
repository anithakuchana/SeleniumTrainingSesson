package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionMoveToElement {

	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		Thread.sleep(3000);
		
		WebElement addOns = driver.findElement(By.xpath("//div[text() = 'Add-ons']"));
		
		Actions act = new Actions(driver);
		
	//	act.moveToElement(addOns).perform();
		
		act.moveToElement(addOns).build().perform();
		
		

	}
	
	
	public static void handleMenu(By parentLocator, By childLocator) {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentLocator)).perform();
		getElement(childLocator).click();
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	

}
