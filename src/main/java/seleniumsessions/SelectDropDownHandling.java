package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownHandling {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//dropdown -- html tag : <select>
		//use select in selenium
		
		
		
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales");
		
	//	By country = By.id("Form_getForm_Country");
		/*
		 * WebElement countryEle = driver.findElement(country);
		 * 
		 * Select countrySelect = new Select(countryEle);
		 * countrySelect.selectByIndex(10); countrySelect.selectByVisibleText("India");
		 * countrySelect.selectByValue("Brazil");
		 */
		
	//	By noOfEmployees = By.id("Form_getForm_NoOfEmployees");
		/*
		 * WebElement noOfEmployeesEle = driver.findElement(noOfEmployees);
		 * 
		 * Select noEmplyeeSelect = new Select(noOfEmployeesEle);
		 * noEmplyeeSelect.selectByValue("51 - 200");
		 */
				
		
		By country = By.id("Form_getForm_Country");
		By noOfEmployees = By.id("Form_getForm_NoOfEmployees");
		/*
		 * doDropDownSelectByIndex(country, 150); doDropDownSelectByIndex(noOfEmployees,
		 * 2);
		 */
		
		
		ElementUtil eleUtil = new ElementUtil(driver);
		
		eleUtil.doDropDownSelectByVisisbleText(country, "India");
		eleUtil.doDropDownSelectByIndex(noOfEmployees, 4);
		
		
		
		
		
		Thread.sleep(5000);
		driver.quit();
		
		
		
		
		

	}
	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doDropDownSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public static void doDRopDownSelectByVisisbleText(By locator, String visibleText) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(visibleText);
	}
	
	public static void doDRopDownSelectBy(By locator, String optionValue) {
		Select select = new Select(getElement(locator));
		select.selectByValue(optionValue);
	}
	
	

}
