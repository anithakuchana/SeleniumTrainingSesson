package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;



public class OpenCartTest extends BaseTest{
	
		
	@Test (priority = 1)
	public void titleTest() {
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "Account Login");
	}
	
	@Test(priority = 2)
	public void urlTest() {
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("account/login"), "Passed");
	}
	
	@Test(priority = 3)
	public void isLogoExistsTest() {
		Assert.assertTrue(driver.findElement(By.cssSelector("img[alt='naveenopencart']")).isDisplayed());
	}
	
	
	
	
}
