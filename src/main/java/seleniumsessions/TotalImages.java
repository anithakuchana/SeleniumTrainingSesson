package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalImages {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
	//	driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		driver.get("https://www.flipkart.com/");
		Thread.sleep(5000);
		List<WebElement>totalImages= driver.findElements(By.tagName("img"));
		System.out.println("Total Images :"+ totalImages.size());

	}

}
