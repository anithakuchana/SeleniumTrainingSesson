package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("Selenium automation");
		
		Thread.sleep(3000);
		
		List<WebElement> suggList =  driver.findElements(By.xpath("//div[@class = 'wM6W7d']/span"));
		
		System.out.println("Total Suggesion: "+suggList.size());
		
	
		for(WebElement e: suggList) {
			
			String text = e.getText();
			if(text.length()!=0) {
				System.out.println("Suggesions  :"+text);
				if(text.contains("practice websites")) {
					e.click();
					break;
			}
			}
		}
		
		Thread.sleep(3000);
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
	}

}
