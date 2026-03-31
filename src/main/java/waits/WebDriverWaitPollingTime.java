package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitPollingTime {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		By emailId = By.name("email");
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));//TT = 10; PT =500ms= 0.5sec
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10),Duration.ofSeconds(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailId));
		WebElement userNameEle = driver.findElement(emailId);
		userNameEle.sendKeys("ak@test.com");

	}

}
