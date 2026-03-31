package seleniumsessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	private WebDriver driver;
	private Actions act;
	private Alert alert;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		act = new Actions(driver);

	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	
	public WebElement getElement(By locator, long timeOut) {
		try {
			return driver.findElement(locator);
	
		}
		catch(NoSuchElementException e) {
			System.out.println("Element is not found :"+ locator);
			e.printStackTrace();
			return waitForElementVisibile(locator, timeOut);
		}
		
	}

	public void doSendKeys(By Locator, String value) {
		getElement(Locator).clear();
		getElement(Locator).sendKeys(value);
	}
	
	public void doSendKeys(By Locator, String value, long timeOut) {
		getElement(Locator).clear();
		getElement(Locator, timeOut).sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public void doClick(By locator, long timeOut) {
		getElement(locator, timeOut).click();
		
		
	}

	public String doElementGetText(By locator) {
		return getElement(locator).getText();
	}
	
	public String doElementGetText(By locator, long timeOut) {
		return getElement(locator, timeOut).getText();
	}

	public boolean isElementDisplayed(By locator) {
		try {
			return getElement(locator).isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("Element is not found using this locator :" + locator);
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean isElementDisplayed(By locator, long timeOut) {
		try {
			return getElement(locator, timeOut).isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("Element is not found using this locator :" + locator);
			e.printStackTrace();
			return false;
		}
	}
	
	

	public String getElementAttribute(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}
	
	public String getElementAttribute(By locator, String attrName, long timeOut) {
		return getElement(locator, timeOut).getAttribute(attrName);
	}

	// Multiple Elements

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);

	}
	
	public List<WebElement> getElements(By locator, long timeOut) {
		//return driver.findElements(locator);
		try {
			return driver.findElements(locator);
	
		}
		catch(NoSuchElementException e) {
			System.out.println("Element is not found :"+ locator);
			e.printStackTrace();
			return waitForAllElementsVisible(locator, timeOut);
		}
	}
	

	public int getElementsCount(By locator) {
		return getElements(locator).size();
	}
	
	public int getElementsCount(By locator, long timeOut) {
		return getElements(locator, timeOut).size();
	}

	

	public List<String> getElementsTextList(By locator) {

		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();

		for (WebElement e : eleList) {
			String text = e.getText();
			if (text.length() != 0) {
				eleTextList.add(text);
			}

		}
		return eleTextList;

	}
	
	
	public List<String> getElementsTextList(By locator, long timeOut) {

		List<WebElement> eleList = getElements(locator, timeOut);
		List<String> eleTextList = new ArrayList<String>();

		for (WebElement e : eleList) {
			String text = e.getText();
			if (text.length() != 0) {
				eleTextList.add(text);
			}

		}
		return eleTextList;

	}
	

	// ***************** Drop Down Utils *****************//

	private Select getSelect(By locator) {
		return new Select(getElement(locator));
	}
	
	
	public void doDropDownSelectByIndex(By locator, int index) {
		getSelect(locator).selectByIndex(index);
	}

	public void doDropDownSelectByVisisbleText(By locator, String visibleText) {
		getSelect(locator).selectByVisibleText(visibleText);
	}

	public void doDropDownSelectByValue(By locator, String optionValue) {
		getSelect(locator).selectByValue(optionValue);
	}

	public int getDropDownOptionsCount(By locator) {
		return getSelect(locator).getOptions().size();
	}

	public List<String> getDropDownOptionsTextList(By locator) {

		List<WebElement> optionList = getSelect(locator).getOptions();
		List<String> optionsTextList = new ArrayList<String>();

		for (WebElement e : optionList) {
			String text = e.getText();
			optionsTextList.add(text);
		}
		return optionsTextList;
	}

	public void selectRandomOptionFromDropDown(By locator, int min, int max) {
		Select select = new Select(getElement(locator));

		Random random = new Random();
		int randomIndex = random.nextInt(select.getOptions().size());
		System.out.println("Random Index Number is :" + randomIndex);
		select.selectByIndex(randomIndex);

		// int min = 100;
		// int max = 200;

		int rangeNum = random.nextInt((max - min) + 1) + min;
		select.selectByIndex(rangeNum);

	}

	/**
	 * this is to select the given option from the search ex: google search, enter
	 * text in the search and select the option from the suggested dropdown list
	 * 
	 * @param locator
	 * @param value
	 * @throws InterruptedException
	 */
	public void selectSuggestedValueFromSearchDropDown(By locator, String value) throws InterruptedException {

		List<WebElement> suggList = driver.findElements(locator);

		System.out.println("Total suggesions list :" + suggList.size());
		Thread.sleep(4000);
		for (WebElement e : suggList) {
			String text = e.getText();
			if (text.length() != 0) {
				System.out.println("Suggesions  :" + text);
				if (text.contains(value)) {
					e.click();
					break;
				}

			}

		}
	}

	/**
	 * this method is able to handle three use cases: 1. single selection: choice 2
	 * 2. multiple choices : choice 1", "choice 4", "choice 2" 3. all choices:
	 * please pass "all" as a value: ex: selectChoice(choices, "all");
	 * 
	 * @param locator
	 * @param choiceValue
	 */

	public void selectChoiceFromJQueryDropDown(By locator, String... choiceValue) {
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

	/**
	 * Select N random options from a jQuery multi-select dropdown
	 *
	 * @param dropdownLocator locator for dropdown click element
	 * @param optionsLocator  locator for all selectable options
	 * @param numberOfOptions how many random options to select
	 */

	public void selectRandomOptionsFromJQueryDropdown(By dropdownLocator, By optionsLocator, int numberOfOptions) {

		// Open dropdown
		// driver.findElement(dropdownLocator).click();

		doClick(dropdownLocator);

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

	// *********************Action Class Util *********************

	public void doActionsClick(By locator) {
		// Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}
	
	public void doActionsClick(By locator, long timeOut) {
		// Actions act = new Actions(driver);
		act.click(getElement(locator, timeOut)).perform();
	}

	public void doActionsSendKeys(By locator) {
		// Actions act = new Actions(driver);
		act.sendKeys(getElement(locator)).perform();
	}
	
	public void doActionsSendKeys(By locator, long timeOut) {
		// Actions act = new Actions(driver);
		act.sendKeys(getElement(locator, timeOut)).perform();
	}

	public void handleMenuItemLevel2(By parentLocator, By childLocator) {
		// Actions act = new Actions(driver);
		act.moveToElement(getElement(parentLocator)).perform();
		doClick(childLocator);
	}

	public void handleMenuItemsLevel3(By menu1, By menu2, By menu3) throws InterruptedException {

		// Actions act = new Actions(driver);
		doClick(menu1);
		Thread.sleep(2000);
		act.moveToElement(getElement(menu2)).perform();
		Thread.sleep(2000);
		doClick(menu3);
	}

	public void handleMenuItemsLevel4(By menu1, By menu2, By menu3, By menu4) throws InterruptedException {

		// Actions act = new Actions(driver);
		doClick(menu1);
		Thread.sleep(2000);
		act.moveToElement(getElement(menu2)).perform();
		Thread.sleep(2000);
		act.moveToElement(getElement(menu3)).perform();
		Thread.sleep(2000);
		doClick(menu4);
	}

	public void sendKeysWithPause(By locator, String value, long pauseTime) {

		char val[] = value.toCharArray();
		// Actions act = new Actions(driver);

		for (char e : val) {
			act.sendKeys(getElement(locator), String.valueOf(e)).pause(pauseTime).perform();
		}

	}

// *************************** JS Alert *****************************	

	public void alertclickElementAndSwithTo(By locator) {
		doClick(locator);
		alert = driver.switchTo().alert();
	}

	public void alertSendKeysAndAccept(String value) {

//		alert = driver.switchTo().alert();
		alert.sendKeys(value);
		alert.accept();

	}

	public void alertAccept() {
		alert.accept();
	}

	public void alertDismiss() {
		alert.dismiss();
	}

	// ****************************** Switch to Frames *************************

	// Switch by frame index
	public void switchToFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	// Switch by frame name or ID
	public void switchToFrameByNameOrId(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	// Switch by WebElement
	public void switchToFrameByElement(By frameLocator) {
		WebElement frameElement = driver.findElement(frameLocator);
		driver.switchTo().frame(frameElement);
	}

	// Switch back to main page
	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	// Switch to parent frame (if nested frame)
	public void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}

	// *********************************Wait Utils *****************************
	
	
	/**
	 * An expectation for checking that there is at least one element present on a web page.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	
	public List<WebElement> waitForAllElementsPresence(By locator, Long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	/**
	 * An expectation for checking that all elements present on the web page that match the locator are visible. 
	 * Visibility means that the elements are not only displayed but also have a height and width that is greater than 0.
	 * @param locator used to find the element
	 * @param timeOut
	 * @return the list of WebElements once they are located
	 */
	
	public List<WebElement> waitForAllElementsVisible(By locator, Long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	
	
	
	/**
	 * An expectation for checking an element is visible and enabled such that you can click it
	 * @param locator
	 * @param timeOut
	 */
	
	public void waitForElementReadyAndClick(By locator, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
		
	}
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page. 
	 * This does not necessarily mean that the element is visible.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */

	public WebElement waitForElementPresence(By locator, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}
	/**
	 * An expectation for checking that an element is present on the DOM of a page and visible. 
	 * Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
	 * @param locator
	 * @param timeOut
	 * @return the WebElement once it is located and visible
	 */

	public WebElement waitForElementVisibile(By locator, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}
	
	public WebElement waitForElementVisibile(By locator, long timeOut, long pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		
		wait
			.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(NoSuchElementException.class)
					.withMessage("------ Element is not found --------"+ locator);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}
	
	
	public WebElement waitForElementVisisbilityWithFluentWait(By locator, long timeOut, long pollingTime) {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
					.pollingEvery(Duration.ofSeconds(pollingTime))
						.ignoring(NoSuchElementException.class)
							.withMessage("------ Element is not found --------"+ locator);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	

	public String waitForTitleContains(String titleValue, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			wait.until(ExpectedConditions.titleContains(titleValue));
			return driver.getTitle();
		} catch (TimeoutException e) {
			System.out.println(titleValue + " is not found");
			e.printStackTrace();
		}
		return null;
	}

	public String waitForTitleIs(String titleValue, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			wait.until(ExpectedConditions.titleIs(titleValue));
			return driver.getTitle();
		} catch (TimeoutException e) {
			System.out.println(titleValue + " is not found");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * wait and check partial URL
	 * 
	 * @param urlValue
	 * @param timeOut
	 * @return
	 */
	public String waitForURLContains(String urlValue, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			wait.until(ExpectedConditions.urlContains(urlValue));
			return driver.getCurrentUrl();
		} catch (TimeoutException e) {
			System.out.println(urlValue + " is not found");
			e.printStackTrace();
		}
		return null;
	}

	public String waitForURLToBe(String urlValue, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			wait.until(ExpectedConditions.urlToBe(urlValue));
			return driver.getCurrentUrl();
		} catch (TimeoutException e) {
			System.out.println(urlValue + " is not found");
			e.printStackTrace();
		}
		return null;
	}

	//*********** wait for Alert *****************
	
	private Alert waitForAlert(long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public String waitForJSAlertAndAccept(long timeOut) {
		Alert alert = waitForAlert(timeOut);
		String text = alert.getText();
		alert.accept();
		return text;
	}

	public String waitForJSAlertAndDismiss(long timeOut) {
		Alert alert = waitForAlert(timeOut);
		String text = alert.getText();
		alert.dismiss();
		return text;
	}

	public String waitForJSPromptAlertAndEnterValue(String value, long timeOut) {
		Alert alert = waitForAlert(timeOut);
		String text = alert.getText();
		alert.sendKeys(value);
		alert.accept();
		return text;
	}
	
	//********************* Wait for Frames ******************
	
	public void waitForFrameAndSwitchToIt(By frameLocator, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}
	
	public void waitForFrameAndSwitchToItIndex(int frameIndex, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}
	
	public void waitForFrameAndSwitchToItIDOrName(String frameIDOrName, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIDOrName));
	}
	
	public void waitForFrameAndSwitchToItWebElement(WebElement frameElement, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}
	
	

}
