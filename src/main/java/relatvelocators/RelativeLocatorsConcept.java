package relatvelocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocatorsConcept {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		driver = new ChromeDriver();
		driver.get("https://www.aqi.in/dashboard/canada");
		Thread.sleep(5000);
		
		WebElement ele = driver.findElement(By.xpath("//section[contains(@class, 'polluted-cities-list ')]//p[contains(text(), 'Peterborough')]"));
		
		String leftRank = driver.findElement(with(By.tagName("p")).toLeftOf(ele)).getText();
		
		System.out.println(leftRank);
		
		
		String rightAQILevel = driver.findElement(with(By.cssSelector("div.aqi-level")).toRightOf(ele)).getText();
		System.out.println(rightAQILevel);
		
		String rightAQIStatus = driver.findElement(with(By.cssSelector("div.aqi-status")).toRightOf(ele)).getText();
		System.out.println(rightAQIStatus);
		
		
		String aboveCity = driver.findElement(with(By.tagName("p")).above(ele)).getText();
		System.out.println("Abpve City : "+aboveCity);
		
		String belowCity = driver.findElement(with(By.tagName("p")).below(ele)).getText();
		System.out.println("Below City :"+ belowCity);
		
		
		
	}

}
