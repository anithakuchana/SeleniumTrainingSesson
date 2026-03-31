package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendKeysWithCharSequence {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//charSequence (Interface)
		    //String, StringBuffer, StringBuilder
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		Thread.sleep(2000);
		
		
		driver.findElement(By.id("input-firstname")).sendKeys("Anitha", "Kuchana", "Test");
		
		
		String emailPrefix = "anithaautomation";
		StringBuffer uniqueValue = new StringBuffer("_testing");
		StringBuilder uniqueNumber = new StringBuilder("_123");
		String domain = "test.com";
		
		driver.findElement(By.id("input-email")).sendKeys(emailPrefix, uniqueValue,uniqueNumber,"@", domain);
			
		

	}

}
