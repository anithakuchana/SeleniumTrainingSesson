package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		// WebDriver driver = new FirefoxDriver();
		// WebDriver driver = new EdgeDriver();

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

		System.out.println("\n ----------------\n");
		
		driver.get("https://www.orangehrm.com/en/contact-sales");

		String title1 = driver.getTitle();
		System.out.println("Title is:" + title1);

		if (title1.contains("Contact Sales")) {
			System.out.println("Title is correct --- Pass");
		} else {
			System.out.println("Title is not correct ---- Fail");
		}

		String url1 = driver.getCurrentUrl();
		System.out.println("Url is:" + url1);
		if (url1.contains("contact-sales")) {
			System.out.println("Url is correct ---- Pass");
		} else {
			System.out.println("Url is not correct ---- Fail");
		}

		driver.quit();// close the browser
	}

}
