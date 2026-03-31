package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class GoogleTest extends BaseTest{
	
	
	
	
	@Test(priority = 1)
	public void titleTest() {
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "Google");
	}
	
	@Test(priority = 2)
	public void urlTest() {
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("google.com"), "Passed");
	}
	
	
	
	
	
}
