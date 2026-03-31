package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorConcept {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		//driver.get("https://classic.crmpro.com/");
						
		//JavascriptExecutor -- interface : executeScript()
		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		String title = js.executeScript("return document.title").toString();
//		System.out.println(title);	
//		
//		String url = js.executeScript("return document.URL").toString();
//		System.out.println(url);	
//
//		js.executeScript("alert('Im on the Login Page');");
		
		
		
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
//		String title = jsUtil.getTitleByJS();
//		System.out.println(title);
//		
//		String url = jsUtil.getURLByJS();
//		System.out.println(url);
//
//		jsUtil.generateJSAlert("Hello Testing");
		
		
		//back, forward, refresh : history.go(n); n =0: refresh, n=-1: back, n=1: forward
		
//		jsUtil.refreshBrowserByJS();
//		
//		String pageText = jsUtil.getPageInnerText();
//		System.out.println(pageText);
//		if(pageText.contains("Privacy Policy")) {
//			System.out.println("PASSED");
//		}
		
//		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
//		jsUtil.flash(loginBtn);
//		
//		WebElement username = driver.findElement(By.name("username"));
//		jsUtil.flash(username);
//		username.sendKeys("apiautomation");
//		
//		WebElement password = driver.findElement(By.name("password"));
//		jsUtil.flash(password);
//		password.sendKeys("apiautomation");
		
		
//		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
//		WebElement username = driver.findElement(By.name("username"));
//		
//		jsUtil.drawBorder(loginBtn);
//		jsUtil.drawBorder(username);

		
		//click ---> Actions Click ---> JS Click(100% click + better Performance)
		
		WebElement registerLink = driver.findElement(By.linkText("Register"));
		jsUtil.clickElementByJS(registerLink);
		
		
		
	}

}
