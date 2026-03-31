package staleelement;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StaleElementRefException {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		driver = new ChromeDriver();

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
//		
//		By emailId = By.name("email");
//		WebElement userName = driver.findElement(emailId);
//		
//		userName.sendKeys("Anithak@gmail.com");
//		Thread.sleep(3000);
//		
//		driver.navigate().refresh(); //Refresh the page --> DOM refreshes
//		userName = driver.findElement(emailId); //Re-Initialize the WebElement when a page refreshes to remove teh stale Element exception
//		Thread.sleep(3000);
		
		By usreName = By.name("email");
		getElement(usreName,10).sendKeys("ak@gmail.com");
		
		driver.navigate().refresh();
		
		getElement(usreName,10).sendKeys("al@gmail.com");
		
	
		
	}

	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static WebElement getElement(By locator, long timeOut) {
		try {
			return driver.findElement(locator);
	
		}
		catch(NoSuchElementException e) {
			System.out.println("Element is not found :"+ locator);
			e.printStackTrace();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}
		
	}
	
}
