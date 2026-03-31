package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownDeSelection {

	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		driver = new ChromeDriver();
		driver.get("https://html.com/attributes/select-multiple/");
		
		
		Select select = new Select(driver.findElement(By.xpath("//select")));
		
		select.selectByValue("Andean");
		select.selectByValue("Greater");
		select.selectByValue("James's");
		
			
		Thread.sleep(3000);
		
		
		select.deselectByValue("Andean");
		select.deselectByValue("James's");
		
		Thread.sleep(3000);
		
		select.selectByValue("Andean");
		select.selectByValue("Greater");
		
		Thread.sleep(3000);
		
		select.deselectAll();
				
		driver.quit();
	}

}
