package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementIsDisplayed {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		/*
		 * boolean flag = driver.findElement(By.id("input-firstname11")).isDisplayed();
		 * System.out.println(flag);
		 */
		By firstName = By.id("input-firstname11");

		if (isElementDisplayed(firstName)) {
			System.out.println("Fn is displayed --- Pass");
		} else {
			System.out.println("Fn is not displayed --- Fail");
		}
	}

	public static boolean isElementDisplayed(By locator) {
		try {
			return getElement(locator).isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("Element is not found using this locator :" + locator);
			e.printStackTrace();
			return false;
		}
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);

	}

}
