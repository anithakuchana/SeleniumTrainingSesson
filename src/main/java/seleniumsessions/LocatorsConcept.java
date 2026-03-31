package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		//1. ID: it is a  Unique attribute:Cannot be duplicate
		
		driver.findElement(By.id("input-firstname")).sendKeys("Anitha");
		
		//2. Name: it can be a unique attribute: can be duplicated
		
		driver.findElement(By.name("lastname")).sendKeys("Automation");
		
		//3.className: It is not a unique attribute: it is duplicate
		
		boolean isLogoExists = driver.findElement(By.className("img-responsive")).isDisplayed();
		System.out.println(isLogoExists);
		
		//4.X-Path: it is not an attribute. Its the address of the element in the html dom
		
		driver.findElement(By.xpath("//*[@id=\"input-telephone\"]")).sendKeys("1234567891");
		
		//5. Css Selector: it is not an attribute.
		
		driver.findElement(By.cssSelector("#input-password")).sendKeys("test123");
		
		
		//6. Link Text: text of the link and it will work only for the links; it is not an attribute
		
		driver.findElement(By.linkText("Wish List")).click();
		
		//7.Partial Link Text : partial link for the <a>
		
		driver.findElement(By.partialLinkText("Recurring ")).click();
		
		
		//8. tagname: 
		
		String headervValue = driver.findElement(By.tagName("h1")).getText();
		System.out.println(headervValue);
		
		if(headervValue.equals("Register Account")) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
		
		
		driver.quit();
		
		
	}

}
