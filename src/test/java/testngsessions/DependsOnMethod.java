package testngsessions;

import org.testng.annotations.Test;

public class DependsOnMethod {
	@Test 
	public void loginTest() {
		System.out.println("Login Test");
		int i = 9/3;
	}
	
	@Test (dependsOnMethods = "loginTest")
	public void searchTest() {
		System.out.println("Search Test");
		//int i = 9/0;
	}

	@Test(dependsOnMethods = {"loginTest","searchTest"})
	public void addToCartTest() {
		System.out.println("Add To Cart Test");
	}
}
