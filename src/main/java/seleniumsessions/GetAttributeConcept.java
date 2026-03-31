package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeConcept {

	
	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
	//	driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		driver.get("https://www.orangehrm.com/en/contact-sales");
		
	/*	String placeholderValueFName = driver.findElement(By.id("Form_getForm_FullName")).getAttribute("placeholder");
	//	String placeholderValueLName = driver.findElement(By.id("input-lastname")).getAttribute("placeholder");
		String placeholderValueEmail = driver.findElement(By.id("Form_getForm_Email")).getAttribute("placeholder");
		
		System.out.println(placeholderValueFName);
	//	System.out.println(placeholderValueLName);
		System.out.println(placeholderValueEmail);
		
		driver.findElement(By.id("Form_getForm_FullName")).sendKeys("Anitha Kuchana");
		String enteredValue = driver.findElement(By.id("Form_getForm_FullName")).getAttribute("value");
		System.out.println(enteredValue);
		
		
		driver.findElement(By.id("Form_getForm_Email")).sendKeys("Anitha@test.com");
		String entredValueEmail = driver.findElement(By.id("Form_getForm_Email")).getAttribute("value");
		System.out.println(entredValueEmail);*/
		
		
		
		By fullName = By.id("Form_getForm_FullName");
		
		ElementUtil eleUtill = new ElementUtil(driver);
		eleUtill.doSendKeys(fullName, "Anitha K");
		
		String placeholder_fullName = eleUtill.getElementAttribute(fullName, "placeholder");
		String enteredValue = eleUtill.getElementAttribute(fullName, "value");
		
		System.out.println(placeholder_fullName);
		System.out.println(enteredValue);

	}

}
