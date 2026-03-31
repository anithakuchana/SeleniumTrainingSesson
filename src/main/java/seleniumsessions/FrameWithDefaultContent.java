package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FrameWithDefaultContent {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		Thread.sleep(3000);
		
		
//		driver.findElement(By.xpath("//img[@title = 'Vehicle-Registration-Forms-and-Examples']")).click();
//		Thread.sleep(3000);
//		
//		WebElement frame = driver.findElement(By.xpath("//iframe[contains(@id, 'frame-one')]"));
//	
//		
//		driver.switchTo().frame(frame);
//		
//		driver.findElement(By.id("RESULT_TextField-1")).sendKeys("Anitha");
//		
//		driver.switchTo().defaultContent();
//		
//		String header = driver.findElement(By.cssSelector(".details__form-preview-title")).getText();
//		System.out.println(header);
//		
//		
		By registrationForm = By.xpath("//img[@title = 'Vehicle-Registration-Forms-and-Examples']");
		By frame = By.xpath("//iframe[contains(@id, 'frame-one')]");
		By proposeTitle = By.id("RESULT_TextField-1");
		By location = By.id("RESULT_TextField-3");
		By description = By.id("RESULT_TextArea-5");
		By firstName = By.id("RESULT_TextField-8");
		By lastName = By.id("RESULT_TextField-9");
		By streetAddress = By.id("RESULT_TextField-10");
		By city = By.id("RESULT_TextField-12");
		By stateSelect = By.id("RESULT_RadioButton-13"); // <select>
		By stateOptions = By.cssSelector("#RESULT_RadioButton-13 option");
		By zipcode = By.id("RESULT_TextField-14");
		By phoneNumber = By.id("RESULT_TextField-15");
		By email = By.id("RESULT_TextField-16");
		By submitButton = By.id("FSsubmit");
		
		
		ElementUtil eleUtil = new ElementUtil(driver);
		
		eleUtil.doClick(registrationForm);
		
		eleUtil.switchToFrameByElement(frame);
		
		eleUtil.doSendKeys(proposeTitle, "MRS");
		eleUtil.doSendKeys(location, "Ashburn");
		eleUtil.doSendKeys(description, "This text will be added to the description");
		eleUtil.doSendKeys(firstName, "Anitha");
		eleUtil.doSendKeys(lastName, "K");
		eleUtil.doSendKeys(streetAddress, "123 street address");
		eleUtil.doSendKeys(city, "Ashburn");
		
		eleUtil.doDropDownSelectByVisisbleText(stateSelect, "Virginia");
		eleUtil.doSendKeys(zipcode, "20147");
		eleUtil.doSendKeys(phoneNumber, "4015236325");
		eleUtil.doSendKeys(email, "test@a.com");
		eleUtil.doClick(submitButton);
		Thread.sleep(3000);
		
		
//		Select select = new Select(driver.findElement(stateSelect));
//		select.selectByVisibleText("Virginia");
//		
//		Thread.sleep(3000);
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	 // Switch by frame index
    public static void switchToFrameByIndex(int index) {
        driver.switchTo().frame(index);
    }

    // Switch by frame name or ID
    public static void switchToFrameByNameOrId(String nameOrId) {
        driver.switchTo().frame(nameOrId);
    }

    // Switch by WebElement
    public static void switchToFrameByElement(By frameLocator) {
        WebElement frameElement = driver.findElement(frameLocator);
        driver.switchTo().frame(frameElement);
    }

    // Switch back to main page
    public static void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
   
    // Switch to parent frame (if nested frame)
    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

}
