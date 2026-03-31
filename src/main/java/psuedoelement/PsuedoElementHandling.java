package psuedoelement;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PsuedoElementHandling {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		Thread.sleep(5000);
		
		String jsScript = "return window.getComputedStyle(document.querySelector('label[for = \"input-firstname\"]'), '::before').getPropertyValue('content')";
		String jsColorScript = "return window.getComputedStyle(document.querySelector('label[for = \"input-firstname\"]'), '::before').getPropertyValue('color')";

		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		String mandatoryText = js.executeScript(jsScript).toString();
		
		System.out.println(mandatoryText);
		
		if(mandatoryText.contains("*")) {
			System.out.println("FN is mandatory field");
		}
		
		String colorValue = js.executeScript(jsColorScript).toString();
		System.out.println(colorValue);
		if(colorValue.contains("rgb(255, 0, 0)")) {
			System.out.println("color red is present");
		}
		
		String bgColorContinueBtn = driver.findElement(By.xpath("//input[@type = 'submit']")).getCssValue("backgroundColor");
		System.out.println(bgColorContinueBtn);
		
	}

}
