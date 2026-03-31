package shadowdom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOMMultiLevelConcept {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://books-pwakit.appspot.com/");
		
		// document.querySelector("body > book-app").shadowRoot.querySelector("#input")
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement searchElement = 
				(WebElement)js.executeScript("return document.querySelector(\"body > book-app\").shadowRoot.querySelector(\"#input\")");
		
		searchElement.sendKeys("Test books");
		
	}

}
