package browserwindowhandle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowTabHandle {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales"); //parent Window
		
		String parentWindowHandleID = driver.getWindowHandle();
		
	//	driver.switchTo().newWindow(WindowType.TAB); //Open new tab in a window
		
		driver.switchTo().newWindow(WindowType.WINDOW);//open new window
		
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		
		Thread.sleep(3000);
		
		driver.close();
		
		driver.switchTo().window(parentWindowHandleID);
		System.out.println(driver.getTitle());
		
		Thread.sleep(3000);
		
		driver.quit();
		

	}

}
