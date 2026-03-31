package seleniumsessions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectRandomOptionJquery {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

		Thread.sleep(3000);

//		driver.findElement(By.xpath("//input[@id = 'justAnInputBox']")).click();

		By dropdownEle = By.xpath("//input[@id = 'justAnInputBox']");

		Thread.sleep(3000);

		By choices = By.xpath("(//div[@class = 'comboTreeDropDownContainer'])[1]//li/span[@class = 'comboTreeItemTitle']");

		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.selectRandomOptionsFromJQueryDropdown(dropdownEle, choices, 5);

	}

	public static void selectRandomOptionsFromJQueryDropdown(By dropdownLocator, By optionsLocator,
			int numberOfOptions) {

		// Open dropdown
		driver.findElement(dropdownLocator).click();

		List<WebElement> options = driver.findElements(optionsLocator);

		if (numberOfOptions > options.size()) {
			throw new IllegalArgumentException(
					"Requested " + numberOfOptions + " options, but only " + options.size() + " available");
		}

		// Shuffle options for randomness
		List<WebElement> shuffledOptions = new ArrayList<>(options);
		Collections.shuffle(shuffledOptions);

		// Select first N options
		for (int i = 0; i < numberOfOptions; i++) {
			WebElement option = shuffledOptions.get(i);
			if (!option.isSelected()) {
				option.click();
			}
		}
	}

}
