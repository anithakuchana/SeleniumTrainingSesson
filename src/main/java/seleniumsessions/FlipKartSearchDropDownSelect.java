package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipKartSearchDropDownSelect {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);

		driver.findElement(By.name("q")).sendKeys("macbook air");

		Thread.sleep(4000);

		
//		By flipKartList = By.xpath("//ul[@class ='VCplLH lTpUwR bRjjIF _1psv1ze5l _1psv1ze9l _1psv1ze7c _1cisqlf2']/li/div/a/div[2]/span");
		//VDtK0l _1psv1ze2u _1psv1ze53 _1psv1ze9x _1psv1ze7o
	//	VDtK0l _1psv1ze2u _1psv1ze53 _1psv1ze9x _1psv1ze7o
		
//		By flipKartList1 = By.xpath("//li[@class = 'Swx5kP']/div/a/div[2]");
		
//		By flipKartList2 = By.xpath("//li[@class = 'Swx5kP']/div/a/div[@class = 'VDtK0l _1psv1ze2u _1psv1ze53 _1psv1ze9x _1psv1ze7o']/span");
		
		By flipKartList3 = By.xpath("//li[@class = 'Swx5kP']/div/a/div[@class = 'VDtK0l _1psv1ze2u _1psv1ze53 _1psv1ze9x _1psv1ze7o']");
		
		List<WebElement> suggList = driver.findElements(flipKartList3);
		

		System.out.println("Total suggesions list :" + suggList.size());
		Thread.sleep(4000);
		for (WebElement e : suggList) {
			String text = e.getText();
			if (text.length() != 0) {
				System.out.println("Suggesions  :" + text);
				if (text.contains("13 inch")) {
					e.click();
					break;
				}

			}

		}
	}

}
