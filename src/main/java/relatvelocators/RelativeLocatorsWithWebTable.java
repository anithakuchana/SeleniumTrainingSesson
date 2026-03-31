package relatvelocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocatorsWithWebTable {

static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/ui/webtable.html");
		Thread.sleep(2000);
		
		WebElement userNameEle = driver.findElement(By.xpath("//td[text() = 'Joe.Root']"));
		
		driver.findElement(with(By.name("chkSelectRow[]")).toLeftOf(userNameEle)).click();
		
		String userRole = driver.findElement(with(By.className("role-ess")).toRightOf(userNameEle)).getText();
		
		System.out.println(userRole);
		
		String userStatus = driver.findElement(with(By.className("status-enabled")).toRightOf(userNameEle)).getText();
		
		System.out.println(userStatus);
		
		String userEmployeeName = driver.findElement(with(By.xpath("//td[text() = 'Joe Root']")).toRightOf(userNameEle)).getText();
		
		System.out.println(userEmployeeName);
		
		
		
		
		
	}

}
