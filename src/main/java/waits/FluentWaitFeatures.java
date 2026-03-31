package waits;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FluentWaitFeatures {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		By emailId = By.name("email");
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait
//			.pollingEvery(Duration.ofSeconds(1))
//				.ignoring(NoSuchElementException.class)
//					.withMessage("---- ELEMENT IS NOT FOUND ----------");
//		
//		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(emailId));
//		WebElement userNameEle = driver.findElement(emailId);
//		userNameEle.sendKeys("ak@test.com");
		
		//WebDRiverWait with FluentWait class features: pollingTime, ignoring, withMessage
		
		//wait(I) ; until(); <-- FluentWait(c): until() {} + Other methods <-- WebDriverWait(C) :No methods _ inherited methods
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
									.withTimeout(Duration.ofSeconds(10))
										.pollingEvery(Duration.ofSeconds(1))
											.ignoring(NoSuchElementException.class)
												.withMessage("------ Element is not Found --------");
		
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailId));
		WebElement userNameEle = driver.findElement(emailId);
		userNameEle.sendKeys("ak@test.com");
		
	}

}
