package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClickSendKeys {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		Thread.sleep(2000);
		
		By firstName = By.id("input-firstname");
		WebElement firstNameEle = driver.findElement(firstName);
		
		Actions act = new Actions(driver);
		act.sendKeys(firstNameEle, "Anitha Automation").perform();
		
		
		
		
		
	}
	

}
