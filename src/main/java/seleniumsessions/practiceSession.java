package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class practiceSession {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		BrowserUtil br = new BrowserUtil();
		
		driver =br.initDriver("chrome");
		br.enterUrl("https://www.facebook.com/r.php?entry_point=login");
		
		br.getPageTitle();
	
		By month = By.id("month");
		By day = By.xpath("//select[@id = 'day']");
		By year = By.cssSelector("#year");
		
		ElementUtil eleUtill = new ElementUtil(driver);
		
		int monthCount = eleUtill.getDropDownOptionsCount(month);
		System.out.println("Number of Months Count:"+ monthCount);
		
		int yearCount = eleUtill.getDropDownOptionsCount(year);
		System.out.println("Number of years Count:"+yearCount);
		
		List<String> monthList = eleUtill.getDropDownOptionsTextList(month);
		System.out.println(monthList);
		
		eleUtill.doDropDownSelectByVisisbleText(day, "16");
		eleUtill.doDropDownSelectByValue(month, "7");
		eleUtill.doDropDownSelectByVisisbleText(year, "1982");
		
		Thread.sleep(5000);
		
		br.quitBrowser();
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
