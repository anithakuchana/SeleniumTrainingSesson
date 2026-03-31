package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class OrangeHRMTest extends BaseTest{

	
		
	@Test(priority = 1)
	public void titleTest() {
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "Contact Sales | Get in Touch | HR Software | HRMS | OrangeHRM");
	}
	
	@Test(priority = 2)
	public void urlTest() {
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("contact-sales"), "Passed");
	}
	
	
	
	
}
