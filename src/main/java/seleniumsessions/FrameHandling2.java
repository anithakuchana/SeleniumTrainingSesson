package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameHandling2 {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/");
		Thread.sleep(3000);
		
		By userName = By.name("username");
		By password = By.name("password");
		By submitButton = By.xpath("//input[@type='submit']");
		By frame1 = By.name("mainpanel");
		By company = By.xpath("//a[text() = 'Companies']");
		By newCompany = By.xpath("//a[text() = 'New Company']");
		By companyName = By.id("company_name");
		By industry = By.name("industry");
		By annualRevenue = By.id("annual_revenue");
		By eleNumOfEmployees = By.id("num_of_employees");
	    By drpStatus = By.xpath("//select[@name = 'status']");
	    By drpCategory = By.xpath("//select[@name = 'category']");
	    By drpPriority =By.xpath("//select[@name = 'priority']");
	    By drpSource = By.xpath("//select[@name = 'source']");
	    By eleIdentifier = By.name("identifier");
	    By eleVatNumber = By.id("vat_number");
	    By eleAddressTitle = By.name("address_title");
	    By drpType = By.xpath("//select[@name = 'type']");
	    By txtAddress = By.name("address");
	    By eleCity = By.name("city");
	    By eleState = By.name("state");
	    By elePostcode = By.name("postcode");
	    By eleCountry = By.name("country");

		
				
		
		ElementUtil eleUtil = new ElementUtil(driver);
		
		eleUtil.doSendKeys(userName, "apiautomation");
		eleUtil.doSendKeys(password, "Selenium@12345");
		eleUtil.doClick(submitButton);
		
		eleUtil.switchToFrameByElement(frame1);
		Thread.sleep(2000);
		
		eleUtil.handleMenuItemLevel2(company, newCompany);
		Thread.sleep(3000);

		eleUtil.doSendKeys(companyName, "Test Automation");
		eleUtil.doSendKeys(industry, "Test Industry");
		eleUtil.doSendKeys(annualRevenue, "Test Annual Revenue");
		eleUtil.doSendKeys(eleNumOfEmployees, "253");
		eleUtil.doDropDownSelectByVisisbleText(drpStatus, "New");
		eleUtil.doDropDownSelectByVisisbleText(drpCategory, "Partner");
		eleUtil.doDropDownSelectByVisisbleText(drpPriority, "Low");
		eleUtil.doDropDownSelectByVisisbleText(drpSource, "Email");
		eleUtil.doSendKeys(eleIdentifier, "Test Identifier");
		eleUtil.doSendKeys(eleVatNumber, "125368");
		
			

	}

}
