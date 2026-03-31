package seleniumsessions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownOptions {

	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales");
		
		By country = By.id("Form_getForm_Country");
//		WebElement countryEle = driver.findElement(country);
//		Select countrySelect = new Select(countryEle);
//		
//		List<WebElement>countryOptionsList = countrySelect.getOptions();
//		System.out.println("Total OPtions: "+ countryOptionsList.size());
//		
//		
//		for(WebElement e:countryOptionsList) {
//			String text = e.getText();
//			System.out.println(text);
//		}
//		
		
		
		List<String> countryList = getDropDownOptionsTextLIst(country);
		System.out.println(countryList);
		
//		List<String> expecetedCountryList = new ArrayList<String>();
//		expecetedCountryList.add("India");
//		expecetedCountryList.add("Brazil");
//		
		List<String> expectedCountrytList = Arrays.asList("India", "Brazil", "Anguilla");
		
		
		if(countryList.containsAll(expectedCountrytList)) {
			System.out.println("3 expected countries are present");
		}
		else {
			System.out.println("3 expected countries are not listed");
		}
		
		Thread.sleep(5000);
		
	
		
		
		
		
	}
	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static int getDropDownOptionsCount(By locator) {
		Select select = new Select(getElement(locator));
		return select.getOptions().size();
	}
	
	
	
	public static List<String> getDropDownOptionsTextLIst(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionList = select.getOptions();
		List<String> optionsTextList = new ArrayList<String>();
		
		for(WebElement e: optionList) {
			String text = e.getText();
			optionsTextList.add(text);
		}
		return optionsTextList;
	}

}
