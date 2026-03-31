package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitlyWaitConcept {

	
	static WebDriver driver;
//	static WebDriverWait wait;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Explicitly wait: for a specific element with a specific condition
		     //1. WebDriver Wait
			//2. Fluent Wait
		    
		//Wait(I): untill(); <---- imp -- FluentWait(c) : until(){} + individual methods <- extends -- WebDriverWait(c): no method available
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		By emaiId = By.id("input-email");
		By password = By.id("input-password");
		By loginBtn = By.xpath("//input[@type='submit']");
		By logo = By.tagName("img");
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement emailIdEle = wait.until(ExpectedConditions.presenceOfElementLocated(emaiId));
//			
//		emailIdEle.sendKeys("text@gmail.com");
//		
//		WebElement passwordEle = driver.findElement(password);
//		passwordEle.sendKeys("Tets@123");
//		
//		WebElement loginBtnEle = driver.findElement(loginBtn);
//		loginBtnEle.click();
		
		
//		waitForElementPresence(emaiId, 10).sendKeys("Test@gmail.com");
//		getElement(password).sendKeys("Test@123");
//		getElement(loginBtn).click();
//		
//		boolean flag = waitForElementPresence(logo, 5).isDisplayed();
//		System.out.println(flag);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement emailIdEle = wait.until(ExpectedConditions.visibilityOfElementLocated(emaiId));
		
		

	}
	
	public static WebElement waitForElementPresence(By locator, long timeOut) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	
   public static WebElement waitForElementVisible(By locator, long timeOut) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}

}
