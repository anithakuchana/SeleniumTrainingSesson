package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumsessions.ElementUtil;

public class WaitForFrame {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		By image = By.xpath("//img[@title = 'Vehicle-Registration-Forms-and-Examples']");
		
		By frameLocator = By.xpath("//iframe[contains(@id, 'frame-one')]");
		By title = By.id("RESULT_TextField-1");
	
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.waitForElementVisibile(image, 10).click();
		
		
		waitForFrameAndSwitchToIt(frameLocator, 5);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
		
		eleUtil.waitForElementVisibile(title, 5).sendKeys("Anitha");
		
		driver.switchTo().defaultContent();
		
		String title1 = driver.findElement(By.className("details__form-preview-title")).getText();
		
		System.out.println(title1);
		
		
		
	}
	
	
	public static void waitForFrameAndSwitchToIt(By frameLocator, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}
	
	public static void waitForFrameAndSwitchToItIndex(int frameIndex, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}
	
	public static void waitForFrameAndSwitchToItIDOrName(String frameIDOrName, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIDOrName));
	}
	
	public static void waitForFrameAndSwitchToItWebElement(WebElement frameElement, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}
	

}
