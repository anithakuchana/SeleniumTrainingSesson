package seleniumsessions;

import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationConcepts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		System.out.println(driver.getTitle());
		
		Thread.sleep(3000);
		
		driver.navigate().to("https://www.google.com/");
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		
		driver.navigate().back();
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		
		driver.navigate().back();
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		
	}

}
