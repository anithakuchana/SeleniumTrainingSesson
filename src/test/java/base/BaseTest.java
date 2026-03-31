package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;



public class BaseTest {

	protected WebDriver driver;
	private String browser = "chrome";
	
	
	@Parameters({"browser","url"})
	@BeforeTest
	public void setUp(String browserName, String appUrl) {
		
		switch (browserName.trim().toLowerCase()) {
		
		case "chrome":
			driver = new ChromeDriver();
			break;
		
		case "edge":
			driver = new EdgeDriver();
			break;
			
		case "firefox":
			driver = new FirefoxDriver();
			break;
			
		case "safari":
			driver = new SafariDriver();
			break;
		
		default:
			System.out.println("Please pass teh correct browser... :"+ browserName);
			break;
		
		}
		
		driver.get(appUrl);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
	}
	
	
	@AfterTest
	public void teatDown()
	{
		driver.quit();
	}
	
}
