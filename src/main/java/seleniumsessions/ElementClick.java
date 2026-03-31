package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementClick {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		driver.findElement(By.name("agree")).click();

		By agreeCheckBox = By.name("agree");
		By forgotPasswordLink = By.linkText("Forgotten Password");

		doClick(agreeCheckBox);
		doClick(forgotPasswordLink);

		Thread.sleep(5000);

		driver.quit();

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);

	}

	public static void doClick(By locator) {

		getElement(locator).click();

	}

}
