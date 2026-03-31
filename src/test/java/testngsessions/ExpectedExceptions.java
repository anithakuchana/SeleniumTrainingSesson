package testngsessions;

import org.testng.annotations.Test;

public class ExpectedExceptions {
	
	@Test (expectedExceptions = {ArithmeticException.class, NullPointerException.class})
	public void loginTest() {
		System.out.println("Login Test");
		int i = 9/0; //AE
	}
	
	@Test (expectedExceptions = Exception.class)
	public void searchTest() {
		System.out.println("Search Test");
		int i = 9/0;
	}

	@Test(expectedExceptions = Exception.class)
	public void addToCartTest() {
		System.out.println("Add To Cart Test");
	}
}
