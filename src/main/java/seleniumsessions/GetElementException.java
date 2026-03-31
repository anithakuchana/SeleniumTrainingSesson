package seleniumsessions;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class GetElementException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		
		try {
			driver.findElement(By.id("input-firstname11")).sendKeys("Anitha");
		}
		catch(NoSuchElementException e) {
			System.out.println("Element is not found for the locator");
			e.printStackTrace();
		}
		
		
	}

}
