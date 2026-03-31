package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsTabSequence {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		Actions act = new Actions(driver);
		
		WebElement firstNameEle = driver.findElement(By.id("input-firstname"));
		
		act.sendKeys(firstNameEle, "Anitha")
			.sendKeys(Keys.TAB)
			.pause(500)
			.sendKeys("Kuchana")
			.sendKeys(Keys.TAB)
			.pause(500)
			.sendKeys("anitha1@test.com")
			.sendKeys(Keys.TAB)
			.pause(500)
			.sendKeys("4526359658")
			.sendKeys(Keys.TAB)
			.pause(500)
			.sendKeys("anitha")
			.sendKeys(Keys.TAB)
			.pause(500)
			.sendKeys("anitha")
			.sendKeys(Keys.TAB)
			.pause(500)
			.sendKeys(Keys.TAB)
			.pause(500)
			.sendKeys(Keys.TAB)
			.pause(500)
			.sendKeys(Keys.SPACE)
			.sendKeys(Keys.TAB)
			.pause(500)
			.sendKeys(Keys.ENTER)
			.build().perform();
		
		
	}

}
