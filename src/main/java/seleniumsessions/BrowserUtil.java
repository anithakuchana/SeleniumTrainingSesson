package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserUtil {

	private WebDriver driver;

	/**
	 * This method is used to initialize the driver on the basis of browsername.
	 * 
	 * @param browserName
	 * @return it return the driver
	 */
	public WebDriver initDriver(String browserName) {
		System.out.println("browser name :" + browserName);

		switch (browserName.toLowerCase().trim()) {
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
			System.out.println("Please pass the correct browser.... " + browserName);
			throw new BrowserException("INVALID BROWSER");
		}

		return driver;
	}
	
	/**
	 * This method is used to enter the url in the browser
	 * @param url
	 */
	
	public void enterUrl(String url) {

		if (url == null) {
			throw new BrowserException("INVALID URL -- URL cannot be null");
		}
		
		if (url.indexOf("http") != 0) {
			throw new BrowserException("INVALID URL -- http or https is missing in the url");
		}
		
		driver.get(url);

	}
	
	/**
	 * This method is used to get the page title
	 * @return title
	 */
	
	
	public String getPageTitle() {
		String title = driver.getTitle();
		System.out.println("Page Title is :"+title);
		return title;
	}
	
	/**
	 * this method is used to get the current Page URL
	 * @return
	 */
	
	public String getPageUrl() {
		String url = driver.getCurrentUrl();
		System.out.println("Current Page URL is :"+url);
		return url;
	}
	
	public void quitBrowser() {
		driver.quit();
	}
	
	public void closeBrowser() {
		driver.close();
	}
	

}
