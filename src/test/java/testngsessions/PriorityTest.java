package testngsessions;

import org.testng.annotations.Test;

//non-Priortity(default Priority) will run first in alphabetical order
//then run priority test cases


public class PriorityTest {
	
	@Test 
	public void loginTest() {
		System.out.println("Login Test");
	}
	
	@Test
	public void searchTest() {
		System.out.println("Search Test");
	}

	@Test(priority = 1)
	public void addToCartTest() {
		System.out.println("Add To Cart Test");
	}

	@Test(priority = 3)
	public void orderTest() {
		System.out.println("Order Test");
	}

	@Test(priority = 4)
	public void productTest() {
		System.out.println("Product Test");
	}
	
	@Test(priority = 2)
	public void forgotPwdTest() {
		System.out.println("forgot Password Test");
	}


}
