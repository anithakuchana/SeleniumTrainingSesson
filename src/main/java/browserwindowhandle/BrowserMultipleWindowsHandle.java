package browserwindowhandle;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BrowserMultipleWindowsHandle {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales"); //parent Window
		Thread.sleep(3000);
		String parentWindowId = driver.getWindowHandle();
		
		driver.findElement(By.className("CybotCookiebotBannerCloseButton")).click();
		
		Thread.sleep(3000);
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
		
    	WebElement fbEle = driver.findElement(By.xpath("//a[contains(@href,'facebook')]"));
    	WebElement linkEle = driver.findElement(By.xpath("//a[contains(@href,'linkedin')]"));
    	WebElement yuTubeEle = driver.findElement(By.xpath("//a[contains(@href,'youtube')]"));
    	WebElement xEle = driver.findElement(By.xpath("//a[contains(@href,'x.com')]"));
    	WebElement instaEle = driver.findElement(By.xpath("//a[contains(@href, 'instagram')]"));
    	
    	fbEle.click();
    	linkEle.click();
    	xEle.click();
    	yuTubeEle.click();
    	instaEle.click();
    	
    	
    	Set<String> handles = driver.getWindowHandles();
    	Iterator<String> it = handles.iterator();
    	
    	while(it.hasNext()) {
    		
    		String windowId = it.next();
    		driver.switchTo().window(windowId);
    		System.out.println(driver.getCurrentUrl());
    		Thread.sleep(3000);
    		if(!windowId.equals(parentWindowId)) {
    			driver.close();
    		}
    		
    		
    		
    	}
    	
    	driver.switchTo().window(parentWindowId);
    	
    	String parentTitle = driver.getTitle();
    	System.out.println(parentTitle);
    	

	}

}
