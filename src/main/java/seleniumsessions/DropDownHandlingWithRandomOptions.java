package seleniumsessions;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownHandlingWithRandomOptions {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales");
		Thread.sleep(2000);
		
		
		//select the middle index value
//		Select select = new Select(driver.findElement(By.id("Form_getForm_Country")));
		
		
//		int midIndex = select.getOptions().size()/2;
//		select.selectByIndex(midIndex);
//		
		//select random option
		
//		Random random = new Random();
//		int randomIndex = random.nextInt(select.getOptions().size());
//		System.out.println(randomIndex);
//		select.selectByIndex(randomIndex);
//		
//		int min = 100;
//		int max = 200;
//		
//		int rangeNum = random.nextInt((max-min)+1) + min;
//		select.selectByIndex(rangeNum);
//		
//		
//		
		
		
		
		
		
		By country = By.id("Form_getForm_Country");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.selectRandomOptionFromDropDown(country, 5, 200);
		
		
		//selectRandomOptionFromDropDown(country, 50, 120);
		
		
		
	}
	
	
	public static void selectRandomOptionFromDropDown(By locator, int min, int max) {
		Select select = new Select(getElement(locator));
		
		Random random = new Random();
		int randomIndex = random.nextInt(select.getOptions().size());
		System.out.println(randomIndex);
		select.selectByIndex(randomIndex);
		
	//	int min = 100;
	//	int max = 200;
		
		int rangeNum = random.nextInt((max-min)+1) + min;
		select.selectByIndex(rangeNum);
	
		
		
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
		
	
	
}
