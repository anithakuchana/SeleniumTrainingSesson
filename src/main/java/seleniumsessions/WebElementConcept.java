package seleniumsessions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementConcept {

	static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		
		//find element + perform Actions (Send Keys, get Text, click, isDisplayed...)
		//1. 
		/*
		 * driver.findElement(By.id("input-email")).sendKeys("anitha.kuchana@gmail.com")
		 * ; driver.findElement(By.id("input-password")).sendKeys("Amrutha1405");
		 * 
		 * //2. storing in WebElement variable
		 * 
		 * WebElement emailIdEle= driver.findElement(By.id("input-email")); WebElement
		 * passwordEle = driver.findElement(By.id("input-password"));
		 * 
		 * emailIdEle.sendKeys("anitha.kuchana@gmail.com");
		 * passwordEle.sendKeys("Amrutha1405");
		 * 
		 * 
		 * //3. using By-Locator - object repository
		 * 
		 * By emailID = By.id("input-email"); By password = By.id("input-password");
		 * 
		 * WebElement emailIdEle1 = driver.findElement(emailID); WebElement passwordEle1
		 * = driver.findElement(password);
		 * 
		 * emailIdEle1.sendKeys("anitha.kuchana@gmail.com");
		 * passwordEle1.sendKeys("Amrutha1405");
		 * 
		 * 
		 * //4. using by locator + utility - reusable function
		 * 
		 * 
		 * By emailID1 = By.id("input-email"); By password1 = By.id("input-password");
		 * 
		 * getElement(emailID1).sendKeys("anitha.kuchana@gmail.com");
		 * getElement(password1).sendKeys("Amrutha1405");
		 * 
		 * //5.using by locator + util function : get element, send keys
		 * 
		 * By emailID2 = By.id("input-email"); By password2 = By.id("input-password");
		 * 
		 * doSendKeys(emailID2, "anitha.kuchana@gmail.com"); doSendKeys(password2,
		 * "Amrutha1405");
		 */
		
		//6. using by locator _ ElementUtill class : get Element, send Keys method
		
		By emailID1 = By.id("input-email"); 
		By password1 = By.id("input-password");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		
		eleUtil.doSendKeys(emailID1, "anitha.kuchana@gmail.com");
		eleUtil.doSendKeys(password1, "Amrutha1405");
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
