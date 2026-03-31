
package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JqueryDropDownHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id = 'justAnInputBox']")).click();

		Thread.sleep(5000);

//		List<WebElement> choiceList = driver.findElements(
//				By.xpath("(//div[@class = 'comboTreeDropDownContainer'])[1]//li/span[@class = 'comboTreeItemTitle']"));
//
//		System.out.println("Total Coices :" + choiceList.size());
//
//		for (WebElement e : choiceList) {
//			String choiceText = e.getText();
//			System.out.println(choiceText);
//
//			if (choiceText.trim().equals("choice 6 2 1")) {
//				e.click();
//				break;
//
//			}

		By choices = By
				.xpath("(//div[@class = 'comboTreeDropDownContainer'])[1]//li/span[@class = 'comboTreeItemTitle']");

		
		//selectChoice(choices, "choice 1");
		// selectChoice(choices, "choice 1", "choice 4", "choice 2", "choice 6 2 1","choice 2 3");
		selectChoice(choices, "all");

		Thread.sleep(5000);

		driver.quit();

	}

	// tc: Single selection
	// tc2: Multiple selection
	// tc3: select All choices
	
	/**
	 * this method is able to handle three use cases:
	 * 1. single selection: choice 2
	 * 2. multiple choices : choice 1", "choice 4", "choice 2"
	 * 3. all choices: please pass "all" as a value: ex: selectChoice(choices, "all");
	 * @param locator
	 * @param choiceValue
	 */

	public static void selectChoice(By locator, String... choiceValue) {
		List<WebElement> choiceList = driver.findElements(locator);

		System.out.println("Total Coices :" + choiceList.size());

		if (choiceValue[0].trim().toLowerCase().contains("all")) {
			for (WebElement e : choiceList) {
				e.click();
			}
		}

		else {

			for (WebElement e : choiceList) {
				String choiceText = e.getText();
				System.out.println(choiceText);

				for (String value : choiceValue) {

					if (choiceText.trim().equals(value)) {
						e.click();
						break;
					}

				}
			}
		}

	}
}
