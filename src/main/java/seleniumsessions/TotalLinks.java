package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class TotalLinks {

	static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//findElements: --> multiple elements --> return List<WebElement>
		

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		System.out.println("Total number of links: "+ allLinks.size());
		
		//iterate the list: using foreach loop
		
		for(WebElement e : allLinks ) {
			
			String text = e.getText();
			if(text.length() !=0) {
				System.out.println(text);
				
			}
			
		}
		
		System.out.println("--------------------------");
		
		for(int i=0; i< allLinks.size();i++) {
			String allLinksText = allLinks.get(i).getText();
			if(allLinksText.length() !=0) {
				System.out.println(allLinksText);
			}
		}
		
		
		
		System.out.println("---- using lambda expression");
		//empList.forEach(e -> System.out.println(e));
		
		allLinks.forEach(e -> System.out.println(e.getText()));
		
	}

}
