package testngsessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotations {
	
	//global conditions
	//pre-conditions
	//test cases : test steps + Assertions (Exp vs Actual Results)
	//tear down : logout, close the browser
	
	//@keyword 
	
	
	//BeforeMethod run for each and every @Test method
	//AfterMethod run for each and every after @Test method
	
	@BeforeSuite
	public void startAppServer() {
		System.out.println("Before Suite :  --- Start the app server");
	}
	
	//2
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test : --- Create a test User");
	}
	
	//3
	@BeforeClass
	public void createUser() {
		System.out.println("Before Class : --- Launch Browser");
	}
	
	//4  //7 //10
	@BeforeMethod
	public void loginToApp() {
		System.out.println("Before method : --- Login to App");
	}
	//9  //11
	@Test
	public void searchTest() {
		System.out.println("Test -- Search Test");
	}
	
	//5
	@Test
	public void addToCartTest() {
		System.out.println("Test -- Add to Cart Test");
	}
	
	//7 //8
	@Test
	public void orderTest() {
		System.out.println("Test -- Order Test");
	}
	
	//6   //9  //12
	@AfterMethod
	public void logout() {
		System.out.println("After Method -- Logout to the application");
	}
	
	//13
	@AfterClass
	public void closeBrowser() {
		System.out.println("After Class -- Close the browser");
	}
	
	//14
	@AfterTest
	public void deleteUser() {
		System.out.println("After Test --- Delete the user");
	}
	
	//15
	@AfterSuite
	public void stopAppServer() {
		System.out.println("After Suite --Stop the server");
	}

}
