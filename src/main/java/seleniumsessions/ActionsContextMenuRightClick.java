package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsContextMenuRightClick {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		driver = new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		Thread.sleep(2000);
		
		
		By rightClick = By.cssSelector("span.context-menu-one");
		By copy = By.xpath("//span[text() = 'Copy']");
		
		Actions act = new Actions(driver);
		act.contextClick(driver.findElement(rightClick))
		.perform();
		
		driver.findElement(copy).click();
		
		
	}

}
