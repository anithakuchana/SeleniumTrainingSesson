package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchDropDownAssignment {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		BrowserUtil br = new BrowserUtil();
		
		driver = br.initDriver("Chrome");
		driver.manage().window().maximize();

		br.enterUrl("https://www.amazon.com/");
		Thread.sleep(3000);

		By amazonSearchBox = By.id("twotabsearchtextbox");
		By amazonSearchList = By.xpath("//div[@class = 'left-pane-results-container']/div");

		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(amazonSearchBox, "macbook air");
		Thread.sleep(3000);

		searchDropDown(amazonSearchList, "m3");
		Thread.sleep(3000);
		
	
		System.out.println("*****************************************");
		
	
		br.enterUrl("https://www.flipkart.com/");
		Thread.sleep(5000);

		By flipKartSearch = By.name("q");
		Thread.sleep(2000);

		By flipKartSearchList = By.xpath("//li[@class = 'Swx5kP']/div/a/div[@class = 'VDtK0l _1psv1ze2u _1psv1ze53 _1psv1ze9x _1psv1ze7o']");
		Thread.sleep(3000);

		eleUtil.doSendKeys(flipKartSearch, "macbook air");
		Thread.sleep(3000);

		searchDropDown(flipKartSearchList, "13 inch");
		Thread.sleep(2000);

		br.quitBrowser();

	}

	public static void searchDropDown(By locator, String value) throws InterruptedException {

		List<WebElement> suggList = driver.findElements(locator);

		System.out.println("Total suggesions list :" + suggList.size());
		Thread.sleep(4000);
		for (WebElement e : suggList) {
			String text = e.getText();
			if (text.length() != 0) {
				System.out.println("Suggesions  :" + text);
				if (text.contains(value)) {
					e.click();
					break;
				}

			}

		}
	}

}
