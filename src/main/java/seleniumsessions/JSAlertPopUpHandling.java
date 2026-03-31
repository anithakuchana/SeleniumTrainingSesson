package seleniumsessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSAlertPopUpHandling {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//alert  --> OK button
		//prompt --> text field with ok and Cancel button
		//confirmation --> "Are you sure?" with OK and Cancel button
		
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		Thread.sleep(3000);
//		
//		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
//		
//		Thread.sleep(4000);
		
//		Alert alert;
//		
//		alert = driver.switchTo().alert(); //works only for js alert
//		String alertMsg = alert.getText();
//		System.out.println(alertMsg);
//		
//		alert.accept(); //accept the alert
//		
//		//alert.dismiss();//cancel the alert
//		
//			
//		
//	//	driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
//		Thread.sleep(3000);
//	
//		alert = driver.switchTo().alert();
//		
//		String text2 = alert.getText();
//		System.out.println(text2);
//		alert.accept();
//		
//		
//        Thread.sleep(4000);
//		
//		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
//		Thread.sleep(4000);
//	
//		alert = driver.switchTo().alert();
//		
//		String text3 = alert.getText();
//		System.out.println(text3);
//		alert.sendKeys("Anitha automation Test");
//		Thread.sleep(2000);
//		alert.accept();
//		
		
		
		
		By jsAlert = By.xpath("//button[text()='Click for JS Alert']");
		By jsConfirm = By.xpath("//button[text()='Click for JS Confirm']");
		By jsPrompt = By.xpath("//button[text()='Click for JS Prompt']");
		
//		alertAccept(jsAlert);
//		Thread.sleep(2000);
//		alertDismiss(jsConfirm);
//		Thread.sleep(2000);
//		alertSendKeysAndAccept(jsPrompt, "Anitha Automation");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.alertclickElementAndSwithTo(jsPrompt);
		Thread.sleep(3000);
		eleUtil.alertSendKeysAndAccept("Anitha Automation");
//		eleUtil.alertSendKeysAndAccept(jsPrompt, "Anitha Automation");
		
		
		Thread.sleep(4000);
		driver.quit();
		
	}

	public static void alertAccept(By locator) {

		driver.findElement(locator).click();

		Alert alert;
		alert = driver.switchTo().alert();
		alert.accept();

	}

	public static void alertDismiss(By locator) {

		driver.findElement(locator).click();
		
		Alert alert;
		alert = driver.switchTo().alert();
		alert.dismiss();

	}

	public static void alertSendKeysAndAccept(By locator, String value) throws InterruptedException {

		driver.findElement(locator).click();
		Alert alert;
		alert = driver.switchTo().alert();
		alert.sendKeys(value);
		Thread.sleep(3000);
		alert.accept();

	}

}
