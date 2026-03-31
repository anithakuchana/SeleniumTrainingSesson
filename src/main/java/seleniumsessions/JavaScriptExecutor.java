package seleniumsessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//Java Script Executor - interface : ExecuteScipt();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		String title = js.executeScript("return document.title").toString();
		System.out.println(title);
		
		String url = js.executeScript("return document.URL").toString();
		System.out.println(url);
		
		js.executeScript("alert ('I am on the login page')");

	}

}
