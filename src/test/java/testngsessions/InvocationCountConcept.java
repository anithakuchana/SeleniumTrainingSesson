package testngsessions;

import org.testng.annotations.Test;

public class InvocationCountConcept {
	
	@Test(invocationCount = 10)
	public void searchTest() {
		System.out.println("Search Test");
	}

}
