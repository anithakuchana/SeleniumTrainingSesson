package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsSendKeysWithPause {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		WebElement firstNameEle = driver.findElement(By.id("input-firstname"));
		Actions act = new Actions(driver);

		String firstName = "Anitha";

		char value[] = firstName.toCharArray();

		for (char e : value) {
			act.sendKeys(firstNameEle, String.valueOf(e)).pause(300).perform();
		}

		driver.quit();

	}
	
	
	
	public static void sendKeysWithPause(By locator, String value, long pauseTime) {
		
		char val[] = value.toCharArray();
		Actions act = new Actions(driver);

		for (char e : val) {
			act.sendKeys(getElement(locator), String.valueOf(e)).pause(pauseTime).perform();
		}
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
