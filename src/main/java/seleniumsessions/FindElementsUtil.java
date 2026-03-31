package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsUtil {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales");

		// List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		// List<WebElement>totalImages= driver.findElements(By.tagName("img"));
		// List<WebElement>countryDropDownOptions =
		// driver.findElements(By.xpath("//select[@id =
		// 'Form_getForm_Country']/option"));

		By links = By.tagName("a");
		By images = By.tagName("img");
		By countryOptions = By.xpath("//select[@id = 'Form_getForm_Country']/option");

		int totalLinks = getElementsCount(links);
		int totalImges = getElementsCount(images);
		int totalOption = getElementsCount(countryOptions);

		System.out.println("Total number of Links :" + totalLinks);
		System.out.println("Total Number of Images :" + totalImges);
		System.out.println("Total Number of Country drop down options :" + totalOption);
		
		System.out.println("----------------------------");
		
		List<String> linksText = getElementsTextList(links);
		System.out.println(linksText);
		
		System.out.println("----------------------");
		
		List<String> countryOptionsList = getElementsTextList(countryOptions);
		System.out.println(countryOptionsList);

	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);

	}

	public static int getElementsCount(By locator) {
		return getElements(locator).size();
	}

	public static List<String> getElementsTextList(By locator) {

		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();

		for (WebElement e : eleList) {
			String text = e.getText();
			if(text.length()!=0) {
				eleTextList.add(text);
			}

		}
		return eleTextList;

	}

}
