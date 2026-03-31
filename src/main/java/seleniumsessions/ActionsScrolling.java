package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsScrolling {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		Thread.sleep(5000);
		
		Actions act = new Actions(driver);
		
		//partial scrolling
		
//		act.sendKeys(Keys.PAGE_DOWN).perform();
//		Thread.sleep(10000);
//		act.sendKeys(Keys.PAGE_UP).perform();
		
		
		//go to bottom of the page or footer page
//		
//		act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
//		Thread.sleep(5000);
//		
//		//go to Top of the page
//		
//		act.sendKeys(Keys.CONTROL).sendKeys(Keys.HOME).perform();
//		Thread.sleep(5000);
//		
//		//Amazon
//		
//		act.scrollToElement(driver.findElement(By.linkText("Careers")))
//			.pause(2000)
//			.click(driver.findElement(By.linkText("Help")))
//			.perform();
//		
//		Thread.sleep(5000);
		
		
		act.scrollToElement(driver.findElement(By.linkText("Terms & Conditions")))
		.pause(2000)
		.click(driver.findElement(By.linkText("Specials")))
		.perform();
		
		Thread.sleep(5000);
		
		driver.quit();
		
		

	}

}
