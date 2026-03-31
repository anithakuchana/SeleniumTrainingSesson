package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPageTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		BrowserUtil brUtil = new BrowserUtil();
		
		WebDriver driver = brUtil.initDriver("chrome");
		
		brUtil.enterUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		By firstNameId = By.id("input-firstname");
		By lastNameId = By.name("lastname");
		By emailId = By.xpath("//*[@id=\"input-email\"]");
		By phoneNumId = By.cssSelector("#input-telephone");
		By passwordId = By.id("input-password");
		By confirmPwdId = By.id("input-confirm");
		By continueButton = By.xpath("//input[@type='submit']");
		By privacyPolicyCheckBox = By.name("agree");
		By registerAccountHeader = By.tagName("h1");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		
		String registerHeader = eleUtil.doElementGetText(registerAccountHeader);
		System.out.println(registerHeader);
		
		eleUtil.doSendKeys(firstNameId, "Anitha");
		eleUtil.doSendKeys(lastNameId, "Test");
		eleUtil.doSendKeys(emailId, "anitha1235@gmail.com");
		eleUtil.doSendKeys(phoneNumId, "123-563-8965");
		eleUtil.doSendKeys(passwordId, "Test@123");
		eleUtil.doSendKeys(confirmPwdId, "Test@123");
		
		
		eleUtil.doClick(privacyPolicyCheckBox);
		//eleUtil.doClick(continueButton);
		
		
		
		
		Thread.sleep(5000);
		
		brUtil.quitBrowser();
		
		
		
		

	}

}
