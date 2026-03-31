package staleelement;

import static java.lang.Thread.sleep;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SVGElementsConcept {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://petdiseasealerts.org/forecast-map#/");
		
		sleep(5000);
		
		WebElement frame = driver.findElement(By.xpath("//iframe[contains(@id, 'map-instance')]"));
		
		driver.switchTo().frame(frame);
		
		//xpath with Local or name
		//By.xpath("//*[local-name() = 'svg' and @id ='map-svg' ]//*[local-name() = 'g' and @class= 'region']//*[local-name() ='path' ] ") 
		///
		//By.xpath("//*[name() = 'svg' and @id ='map-svg' ]//*[name() = 'g' and @class= 'region']//*[name() ='path' ] ") 
		///
		//css -Selector
		//svg#map-svg g.region path
		
		List<WebElement> regionsList = driver.findElements(By.xpath("//*[local-name() = 'svg' and @id ='map-svg' ]//*[local-name() = 'g' and @class= 'region']//*[local-name() ='path' ]"));
		
		System.out.println(regionsList.size());
		
		Actions act = new Actions(driver);
		
		for(WebElement e: regionsList) {
			act.moveToElement(e).perform();
			String name = e.getAttribute("name");
			System.out.println(name);
			sleep(500);
		}
		
		
	}

}
