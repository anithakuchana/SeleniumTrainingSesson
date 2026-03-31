package shadowdom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import org.openqa.selenium.JavascriptExecutor;



public class ShadowDOMElement {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://testing.qaautomationlabs.com/shadow-dom.php");
		
		//Browser ---> page --> shaow Host Element(DOM) --> element is available
		
		//JSPath : will provide one javascript ; run this JS using JSExecutor
		
		//document.querySelector("#shadow-host").shadowRoot.querySelector("div")
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement divElement = 
				(WebElement)js.executeScript("return document.querySelector(\"#shadow-host\").shadowRoot.querySelector(\"div\")");
		
		//HTML Element ---> WebElement
		
		String text = divElement.getText();
		System.out.println(text);
		
		
		
		
		
		
		
	}

}
