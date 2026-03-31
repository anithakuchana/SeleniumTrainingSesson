package browserwindowhandle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BrowserMultipleWindowHandlingAssnmt2 {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales"); // parent Window
		Thread.sleep(3000);
		
		driver.findElement(By.className("CybotCookiebotBannerCloseButton")).click();

		Thread.sleep(3000);

		scrollToEndPage();
		
		
		
		WebElement contactUs = driver.findElement(By.cssSelector("li a[href='https://www.orangehrm.com/en/company/contact']"));
		WebElement pressRelease = driver.findElement(By.cssSelector("a[href='https://www.orangehrm.com/en/company/press-releases']"));
		WebElement newsArticle = driver.findElement(By.cssSelector("a[href='https://www.orangehrm.com/en/company/news-articles']"));
		WebElement careers = driver.findElement(By.cssSelector("a[href='https://www.orangehrm.com/en/company/careers']"));
		By links = By.xpath("//div[@class = 'footer-main'][1]/ul/li/a");

		pressRelease.click();
		Thread.sleep(2000);
		
		String parentWindowId = getParentWindowId();
		System.out.println("Orange HRM " + parentWindowId);
		System.out.println("Parent Window Title :"+ driver.getTitle());
		System.out.println("Parent Window URL:"+ driver.getCurrentUrl());
		
		switchToChildWindow();  
	//	System.out.println("Press Release "+ );
		System.out.println("Press Release Child Window Title :"+ driver.getTitle());
		Thread.sleep(2000);
		scrollToEndPage();
		Thread.sleep(3000);
		getElementsTextListandClick(links, "Contact Us");
		Thread.sleep(2000);
		
		
		
		switchToChildWindow(); 
		System.out.println("Contact Us Child Window Title :"+ driver.getTitle());
		Thread.sleep(2000);
		scrollToEndPage();
		
		
		
		

	}
	
	  public static String getParentWindowId() {
	        return driver.getWindowHandle();
	    }
	  
	
	  public static void switchToChildWindow() {
		  Set<String> handles = driver.getWindowHandles();

			Iterator<String> it = handles.iterator();

			String parentWindowID = it.next();
			System.out.println("Parent Window ID :" + parentWindowID);

			String childWindowID = it.next();
			System.out.println("child Window ID :" + childWindowID);
			
			driver.switchTo().window(childWindowID);
		  
	  }

		public void switchToParentWindow(String parentWindowId) {
			driver.switchTo().window(parentWindowId);
		}

		public static List<WebElement> getElements(By locator) {
			return driver.findElements(locator);

		}
		
		public static void scrollToEndPage() {
			Actions act = new Actions(driver);
			act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
		}

		public static void getElementsTextListandClick(By locator, String value) {

			List<WebElement> eleList = getElements(locator);
			List<String> eleTextList = new ArrayList<String>();

			for (WebElement e : eleList) {
				String text = e.getText();
				if (text.equals(value)) {
					e.click();
				}

			}

		}

}
