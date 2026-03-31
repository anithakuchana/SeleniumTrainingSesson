package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BigBasketMoveToElement {

	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		Thread.sleep(2000);
		
		////button[@id='headlessui-menu-button-:Ramkj6:']//span[@class='Label-sc-15v1nk5-0 sc-dhKdcB jnBJRV ffLIFe'][normalize-space()='Shop by']
		
		
		By shopByCategory = By.id("headlessui-menu-button-:Ramkj6:");
		By foodCourt = By.linkText("Food Court");
		By coldBeverages = By.linkText("Cold Beverages");
		By icedTea = By.linkText("Iced Tea");
		
//		Actions act = new Actions(driver);
//		driver.findElement(shopByCategory).click();
//		Thread.sleep(2000);
//		act.moveToElement(driver.findElement(foodCourt)).perform();
//		Thread.sleep(2000);
//		act.moveToElement(driver.findElement(coldBeverages)).perform();
//		Thread.sleep(2000);
//		driver.findElement(icedTea).click();
//		
		
		handleMenuItemsLevel4(shopByCategory,foodCourt,coldBeverages, icedTea);
		
		
	}
	
	public static void handleMenuItemsLevel4(By menu1, By menu2, By menu3, By menu4 ) throws InterruptedException {
		
		Actions act = new Actions(driver);
		driver.findElement(menu1).click();
		Thread.sleep(2000);
		act.moveToElement(driver.findElement(menu2)).perform();
		Thread.sleep(2000);
		act.moveToElement(driver.findElement(menu3)).perform();
		Thread.sleep(2000);
		driver.findElement(menu4).click();
	}
	

}
