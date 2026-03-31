package waits;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitforURLTitle {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		
		driver.get("https://classic.crmpro.com/");
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.titleContains("customer relationship management"));
//		String title = driver.getTitle();
//		System.out.println(title);
		
		String title = waitForTitleContains("customer relationship management123", 5);
		System.out.println(title);
		

	}
	
	public static String waitForTitleContains(String titleValue, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			wait.until(ExpectedConditions.titleContains(titleValue));
			return driver.getTitle();
		}
		catch(TimeoutException e) {
			System.out.println(titleValue + " is not found");
			e.printStackTrace();
		}	return null;
	}
	
	public static String waitForTitleIs(String titleValue, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			wait.until(ExpectedConditions.titleIs(titleValue));
			return driver.getTitle();
		}
		catch(TimeoutException e) {
			System.out.println(titleValue + " is not found");
			e.printStackTrace();
		}	return null;
	}
	
	public static String waitForURLContains(String urlValue, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			wait.until(ExpectedConditions.urlContains(urlValue));
			return driver.getCurrentUrl();
		}
		catch(TimeoutException e) {
			System.out.println(urlValue + " is not found");
			e.printStackTrace();
		}	return null;
	}
	
	public static String waitForURLToBe(String urlValue, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			wait.until(ExpectedConditions.urlToBe(urlValue));
			return driver.getCurrentUrl();
		}
		catch(TimeoutException e) {
			System.out.println(urlValue + " is not found");
			e.printStackTrace();
		}	return null;
	}

}
