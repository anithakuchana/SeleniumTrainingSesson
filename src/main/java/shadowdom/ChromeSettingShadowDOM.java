package shadowdom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeSettingShadowDOM {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("chrome://settings/");
		
	//	document.querySelector("body > settings-ui").shadowRoot.querySelector("#toolbar").shadowRoot.querySelector("#search").shadowRoot.querySelector("#searchInput")

		String jsPath = "return document.querySelector(\"body > settings-ui\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#search\").shadowRoot.querySelector(\"#searchInput\")";
		
	JavascriptExecutor js = (JavascriptExecutor)driver;
	WebElement searchElement = 
			(WebElement)js.executeScript(jsPath);
	
	searchElement.sendKeys("Notification");
	
	
	}
	
	
	

}
