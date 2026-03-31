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

public class BrowserMultipleWindowHandleAssignment {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales"); // parent Window
		
    	Thread.sleep(3000);
		// String parentWindowID = driver.getWindowHandle();

		driver.findElement(By.className("CybotCookiebotBannerCloseButton")).click();
		driver.manage().window().maximize();

		Thread.sleep(3000);

		scrollToEndPage();

		WebElement contactUs = driver
				.findElement(By.cssSelector("li a[href='https://www.orangehrm.com/en/company/contact']"));
		WebElement pressRelease = driver
				.findElement(By.cssSelector("a[href='https://www.orangehrm.com/en/company/press-releases']"));
		WebElement newsArticle = driver
				.findElement(By.cssSelector("a[href='https://www.orangehrm.com/en/company/news-articles']"));
		WebElement careers = driver
				.findElement(By.cssSelector("a[href='https://www.orangehrm.com/en/company/careers']"));
		
		By links = By.xpath("//div[@class = 'footer-main'][1]/ul/li/a");

		pressRelease.click();
		Thread.sleep(2000);
		
		String parentWindowId = getParentWindowID();
		System.out.println("Orange HRM " + parentWindowId);
		System.out.println("Parent Window Title :"+ driver.getTitle());
		System.out.println("Parent Window URL:"+ driver.getCurrentUrl());
		
		String pressReleaseChildWindowId = switchToChildWindow();  
		System.out.println("Press Release "+ pressReleaseChildWindowId);
		System.out.println("Press Release Child Window Title :"+ driver.getTitle());
		Thread.sleep(2000);
		scrollToEndPage();
		Thread.sleep(3000);
		getElementsTextListandClick(links, "Contact Us");
		Thread.sleep(2000);
		
		
		String contactusChildWindowId = switchToChildWindow();  
		System.out.println("Contact Us "+ contactusChildWindowId);
		System.out.println("Contact Us Child Window Title :"+ driver.getTitle());
		System.out.println("Parent Window URL:"+ driver.getCurrentUrl());
		
		scrollToEndPage();
		Thread.sleep(2000);
		getElementsTextListandClick(links, "News Articles");
		Thread.sleep(2000);
		
		String newsArticleChildWindowId = switchToChildWindow();  
		System.out.println("News Articles "+ newsArticleChildWindowId);
		System.out.println("News Articles Child Window Title :"+ driver.getTitle());
		
		scrollToEndPage();
		Thread.sleep(2000);
		getElementsTextListandClick(links, "Careers");
		Thread.sleep(2000);	
		
		String careersChildWindowId = switchToChildWindow();  
		System.out.println("Careers "+ careersChildWindowId);
		System.out.println("Careers Child Window Title :"+ driver.getTitle());
		Thread.sleep(2000);	
		

//		Set<String> handles = driver.getWindowHandles();
//		Iterator<String> it = handles.iterator();
//
//		String parentWindowID = it.next();
//		System.out.println("Parent Window ID :" + parentWindowID);
//
//		String childWindowID1 = it.next();
//		System.out.println("child Window ID :" + childWindowID1);
//
//		// Part#2: switch to child window1
//		swithToWindow(childWindowID1);
//		String childWindowTitle1 = driver.getTitle();
//		System.out.println("Child Window Title1 is: " + childWindowTitle1);
//		Thread.sleep(3000);
//
//		act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
//		Thread.sleep(5000);
//
//		getElementsTextListandClick(links, "Contact Us");
//
//		// section 2
//
//		Set<String> handles2 = driver.getWindowHandles();
//		Iterator<String> it2 = handles.iterator();
//
//		String parentWindowID2 = it2.next();
//		System.out.println("Parent Window ID :" + parentWindowID2);
//
//		String childWindowID2 = it2.next();
//		System.out.println("child Window ID :" + childWindowID2);
//
//		swithToWindow(childWindowID2);
//		Thread.sleep(2000);
//		String childWindowTitle2 = driver.getTitle();
//		System.out.println("Child Window Title2 is: " + childWindowTitle2);
//		Thread.sleep(3000);
//
//		act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
//		Thread.sleep(3000);
//
//		getElementsTextListandClick(links, "News Articles");
//		Thread.sleep(3000);
//
//		Set<String> handles3 = driver.getWindowHandles();
//
//		Iterator<String> it3 = handles.iterator();
//
//		String parentWindowID3 = it3.next();
//		System.out.println("Parent Window ID :" + parentWindowID3);
//		String childWindowID3 = it2.next();
//
//		String childWindowID4 = it.next();
//		System.out.println("child Window ID :" + childWindowID3);
//		swithToWindow(childWindowID3);
//		Thread.sleep(2000);
//		String childWindowTitle3 = driver.getTitle();
//		System.out.println("Child Window Title3 is: " + childWindowTitle3);
//		Thread.sleep(3000);

//    	
//    	driver.switchTo().window(childWindowID2);
//    	String childWindowTitle2 = driver.getTitle();
//    	System.out.println("Child Window Title2 is: "+ childWindowTitle2);
//    	Thread.sleep(3000);
//    	
//    	act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
//    	careers.click();
//    	Thread.sleep(2000);
//    	
//    	String childWindowID3 = it.next();
//    	System.out.println("Child Window Id 3 :"+ childWindowID3);
//    	
//    	driver.switchTo().window(childWindowID3);
//    	String childWindowTitle3 = driver.getTitle();
//    	System.out.println("Child Window Title3 is: "+ childWindowTitle3);
//    	
//    	Thread.sleep(3000);
//    	
//    	driver.close(); //closing child window 3 --> news Article
//    	
//    	driver.switchTo().window(childWindowID2);
//    	System.out.println("Child Window URL 2 is: "+ driver.getCurrentUrl());
//    	driver.close(); //closing child window 2 --> press release
//    	
//    	driver.switchTo().window(childWindowID1);
//    	Thread.sleep(3000);
//    	System.out.println("Child Window URL 1 is: "+ driver.getCurrentUrl());
//    	driver.close(); //closing child window 2 --> Contact Us
//    	
//    	driver.switchTo().window(parentWindowID);
//    	Thread.sleep(3000);
//    	System.out.println("Parent Window URL 1 is: "+ driver.getCurrentUrl());
//    	driver.close(); //closing child window 2 --> Parent Window
//    	
	}

	public static String getParentWindowID() {
		return driver.getWindowHandle();
	}

	public static String switchToChildWindow() {

		String parentWindowId = getParentWindowID();

		Set<String> handles = driver.getWindowHandles();

		Iterator<String> it = handles.iterator();

		while (it.hasNext()) {
			String windowId = it.next();
			if (!windowId.equals(parentWindowId)) {
				driver.switchTo().window(windowId);
				return windowId;
			}
		}

		throw new RuntimeException("No child window found");
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
