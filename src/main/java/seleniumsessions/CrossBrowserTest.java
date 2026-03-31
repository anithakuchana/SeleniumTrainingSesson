package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class CrossBrowserTest {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String browser = "anitha";

		switch (browser.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		default:
			System.out.println("Please pass the correct browser.... " + browser);
			throw new BrowserException("INVALID BROWSER");
		}
		
		
		driver.get("https://naveenautomationlabs.com/opencart/");

		String title = driver.getTitle();
		System.out.println("Title is :" + title);

		if (title.equals("Your Store")) {
			System.out.println("Title is correct ---- Pass");
		} else {
			System.out.println("Title is incorrect --- Fail");
		}

		String url = driver.getCurrentUrl();
		System.out.println("Url :" + url);

		if (url.contains("opencart")) {
			System.out.println("URL is correct");
		} else {
			System.out.println("Url is not correct");
		}
		
		driver.quit();

	}

}
