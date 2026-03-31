package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonDropDownSelection {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		Thread.sleep(3000);

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("macbook air");
		Thread.sleep(3000);
		
		
		By amazonSearchList = By.xpath("//div[@class = 'left-pane-results-container']/div");
		searchDropDown(amazonSearchList, "m3");
		
		System.out.println("\n -----------------\n ");
		

//		System.out.println("Total suggesions list :" + suggList.size());
//		Thread.sleep(3000);
//		for (WebElement e : suggList) {
//			String text = e.getText();
//			if (text.length() != 0) {
//				System.out.println("Suggesions  :" + text);
//				if (text.contains("m3")) {
//					e.click();
//					break;
//				}
//
//			}
//
//		}
	}
	
	
		
	
	
	public static void searchDropDown(By locator, String value) throws InterruptedException {
		
		
		List<WebElement> suggList = driver.findElements(locator);

		System.out.println("Total suggesions list :" + suggList.size());
		Thread.sleep(3000);
		for (WebElement e : suggList) {
			String text = e.getText();
			if (text.length() != 0) {
				System.out.println("Suggesions  :" + text);
				if (text.contains(value)) {
					e.click();
					break;
				}

			}

		}
	}
	
	
	
	
	
	
}
