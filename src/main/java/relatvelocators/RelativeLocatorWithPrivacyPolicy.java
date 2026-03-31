package relatvelocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;


public class RelativeLocatorWithPrivacyPolicy {

static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		Thread.sleep(5000);

		WebElement privacyPolicy = driver.findElement(By.cssSelector(".agree"));
		WebElement continuebtn = driver.findElement(By.xpath("//input[@type='submit']"));
		WebElement email = driver.findElement(By.id("input-email"));
		
		By lastname = By.id("input-lastname");
		By firstName = By.id("input-firstname");
		By telephone= By.id("input-telephone");
		By password = By.id("input-password");
		By confirmPassword = By.id("input-confirm");
		
		By yesLable = By.xpath("//label[normalize-space()='Yes']");
		By NoLable = By.xpath("//label[normalize-space()='No']");
		By subscribe = By.xpath("//label[contains(normalize-space(),'Subscribe')]");
		
		
		
		
		driver.findElement(with(By.name("agree")).toRightOf(privacyPolicy).toLeftOf(continuebtn)).click();
		
		String text = driver.findElement(with(By.cssSelector("form.form-horizontal > div.buttons > div.pull-right")).near(privacyPolicy)).getText();
		System.out.println(text);
		
		email.sendKeys("ak@test.com");
		driver.findElement(with(By.id("input-lastname")).above(email)).sendKeys("Kuchana");
		driver.findElement(with(By.id("input-firstname")).above(email)).sendKeys("Anitha");
		driver.findElement(with(telephone).below(email)).sendKeys("1235638563");
		driver.findElement(with(password).below(email)).sendKeys("tes123");
		
		driver.findElement(with(yesLable).near(subscribe)).click();
		
		
				
		
		
		
	}

}
