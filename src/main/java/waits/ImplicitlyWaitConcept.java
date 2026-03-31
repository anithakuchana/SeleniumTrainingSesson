package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitlyWaitConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Implicitly wait applied for all WebElements
		//Implicity wait : global wait : by default it will be applied for all the web Elements
		//It wont applied for a specific web Element
		

		
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement logo = driver.findElement(By.xpath("//img[@alt='naveenopencart']"));
		WebElement userName = driver.findElement(By.cssSelector("#input-email"));
		
		//homepage: timeout: 20
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

}
