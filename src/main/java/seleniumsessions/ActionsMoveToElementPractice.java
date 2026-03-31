package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsMoveToElementPractice {

	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		
		WebElement addOns = driver.findElement(By.xpath("//div[text() = 'Add-ons']"));
		
		//css-1dbjc4n r-18u37iz r-1w6e6rj r-d23pfw r-1t2hasf
		
//		(//div[@class = 'css-1dbjc4n r-150rngu r-eqz5dr r-16y2uox r-1wbh5a2 r-11yh6sk r-1rnoaur r-1sncvnh'])[1]/div/div/div/a/div/div[@class = 'css-76zvg2 r-homxoj r-ubezar']
		
		By listOptions = By.xpath("(//div[@class = 'css-1dbjc4n r-150rngu r-eqz5dr r-16y2uox r-1wbh5a2 r-11yh6sk r-1rnoaur r-1sncvnh'])[1]/div/div/div/a/div/div");
		
		Actions act = new Actions(driver);
		
		act.moveToElement(addOns).perform();
		
		Thread.sleep(3000);
		
		List<WebElement> options = driver.findElements(listOptions);
		
		System.out.println(options.size());
		
		for(WebElement e: options) {
			String text = e.getText();
			
			if(text.equals("Senior Citizen Discount")) {
				e.click();
				break;
			}
			System.out.println(text);
		}
		
	}
	
	
	
	public static void handleMenu(By parentLocator, By childLocator) {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentLocator)).perform();
		getElement(childLocator).click();
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
