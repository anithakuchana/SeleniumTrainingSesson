package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.get("https://www.londonfreelance.org/courses/frames/index.html");
		Thread.sleep(3000);
		//switch to frame
		
		//driver.switchTo().frame(2);
		
	//	driver.switchTo().frame("main"); 
		
	
		WebElement mainFrame = driver.findElement(By.xpath("//frame[@name='main']"));//frame webElement
		
		driver.switchTo().frame(mainFrame);
		
    	String header = driver.findElement(By.tagName("h2")).getText();
		
		System.out.println(header);
		
		Thread.sleep(3000);
		
		driver.quit();

	}

}
