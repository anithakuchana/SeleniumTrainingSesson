package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalDropDownOptions {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales");
		
		List<WebElement>countryDropDownOptions = driver.findElements(By.xpath("//select[@id = 'Form_getForm_Country']/option"));
		System.out.println(countryDropDownOptions.size());
		for(WebElement e: countryDropDownOptions) {
			System.out.println(e.getText());
		}
		
		System.out.println("-----------------");
		
		List<WebElement> numOfEmpList = driver.findElements(By.cssSelector("select[name = 'NoOfEmployees'] option"));
		System.out.println(numOfEmpList.size());
		
		for(WebElement e: numOfEmpList) {
			System.out.println(e.getText());
		}
		System.out.println("-----------------");
		
		By numberOfEmpList = By.cssSelector("select[name = 'NoOfEmployees'] option");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		
		eleUtil.getElements(numberOfEmpList);
		
		int numberlist = eleUtil.getElementsCount(numberOfEmpList);
		System.out.println(numberlist);
		
		List<String> numOfEmpListText = eleUtil.getElementsTextList(numberOfEmpList);
		System.out.println(numOfEmpListText);
		
		System.out.println("\n");
		
		By pplMgmtDescription = By.xpath("//h3[text() = 'People Management']/parent::div/following-sibling::div[@class = 'product-description']/p");
		String description = eleUtil.doElementGetText(pplMgmtDescription);
		System.out.println(description);
		System.out.println("\n");
		
		
		By pplMgmgList = By.xpath("//h3[text() = 'People Management']/parent::div/following-sibling::div[@class = 'product-list']/ul/li");
		eleUtil.getElements(pplMgmgList);
		
		int pplNumber = eleUtil.getElementsCount(pplMgmgList);
		System.out.println("People Management :"+pplNumber);
		
		List<String> pplMgmgListText = eleUtil.getElementsTextList(pplMgmgList);
		System.out.println(pplMgmgListText);
		
		
		
		
		

	}

}
