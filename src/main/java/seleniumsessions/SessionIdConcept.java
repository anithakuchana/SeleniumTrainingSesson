package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SessionIdConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Quit vs Close
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/");

		String title = driver.getTitle();
		System.out.println("Title is :" + title);

		String url = driver.getCurrentUrl();
		System.out.println("Url :" + url);

	}

}
