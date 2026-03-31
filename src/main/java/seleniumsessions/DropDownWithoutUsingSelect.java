package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownWithoutUsingSelect {

	
	static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales");
		
		List<WebElement> countryList = driver.findElements(By.cssSelector("Select#Form_getForm_Country > option"));
		
		System.out.println("Total Counties count:"+ countryList);
		
		for(WebElement e: countryList) {
			
			String text = e.getText();
			if(text.trim().equals("India")) {
				e.click();
				break;
			}
		}


	}

}
