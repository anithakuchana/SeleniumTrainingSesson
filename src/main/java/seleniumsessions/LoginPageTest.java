package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BrowserUtil brUtil = new BrowserUtil();
		
		WebDriver driver = brUtil.initDriver("chrome");
		
		brUtil.enterUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		By emailID = By.id("input-email"); 
		By password = By.id("input-password");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		
		eleUtil.doSendKeys(emailID, "anitha.kuchana@gmail.com");
		eleUtil.doSendKeys(password, "Amrutha1405");
		
		brUtil.quitBrowser();
		
	
		
		
		

	}

}
