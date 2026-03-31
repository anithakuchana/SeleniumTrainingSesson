package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPopUp {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.get("https://practice.expandtesting.com/upload");
		
		By chooseFile = By.id("fileInput");
		
		driver.findElement(chooseFile).sendKeys("C:\\Users\\anith\\OneDrive\\Documents\\DevOps_Interview_Questions.pdf");
		
	}

}
