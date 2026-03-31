package browserwindowhandle;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BrowserWindowHandle {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales");
		Thread.sleep(3000);
		
		driver.findElement(By.className("CybotCookiebotBannerCloseButton")).click();
		
		Thread.sleep(3000);
		
		Actions act = new Actions(driver);
    	act.click(driver.findElement(By.linkText("Contact Us"))).perform();
		
		//part 1: collect window ID's
    	
    	Set<String> handles = driver.getWindowHandles();
    	
    	Iterator<String> it = handles.iterator();
    	
    	String parentWindowID = it.next();
    	System.out.println("Parent Window ID :"+ parentWindowID);
    	
    	String childWindowID = it.next();
    	System.out.println("child Window ID :"+ childWindowID);
    	
    	//Part#2: switch to child window
    	
    	driver.switchTo().window(childWindowID);
    	String childWindowTitle = driver.getTitle();
    	System.out.println("Child Window Title is: "+ childWindowTitle);
    	
    	//close the child window
    	driver.close();
    	
    	//switch to parent window
    	
    	driver.switchTo().window(parentWindowID);
    	String parentWinodwTitle = driver.getTitle();
    	System.out.println("Parent Window Title is :"+ parentWinodwTitle);
    
    	driver.quit();
    	
    	
    	
    	
    	
    	
    	
	}

}
