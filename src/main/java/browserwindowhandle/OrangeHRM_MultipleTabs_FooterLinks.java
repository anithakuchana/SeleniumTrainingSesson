package browserwindowhandle;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRM_MultipleTabs_FooterLinks {

    static WebDriver driver;
    static WebDriverWait wait;
    static Actions actions;

    public static void main(String[] args) {

        driver = new ChromeDriver();
       // driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        actions = new Actions(driver);

        driver.get("https://www.orangehrm.com/en/contact-sales");

        // Close cookie banner if present (safe)
        clickCookieCloseIfPresent();

        // -------------------- 1) Contact Sales -> Press Releases --------------------
        String contactSalesWindow = driver.getWindowHandle();

        String pressReleaseWindow = openFooterLinkInNewTabAndGetChildHandle("Press Releases");
        System.out.println("\n[Contact Sales -> Press Releases]");
        System.out.println("Parent (Contact Sales) Window ID : " + contactSalesWindow);
        System.out.println("Child  (Press Releases) Window ID : " + pressReleaseWindow);

        switchToWindow(pressReleaseWindow);
        printTitleAndUrl("Press Releases");

        // -------------------- 2) Press Releases -> Contact Us --------------------
        String contactUsWindow = openFooterLinkInNewTabAndGetChildHandle("Contact Us");
        System.out.println("\n[Press Releases -> Contact Us]");
        System.out.println("Parent (Press Releases) Window ID : " + pressReleaseWindow);
        System.out.println("Child  (Contact Us) Window ID     : " + contactUsWindow);

        switchToWindow(contactUsWindow);
        printTitleAndUrl("Contact Us");

        // -------------------- 3) Contact Us -> Careers --------------------
        String careersWindow = openFooterLinkInNewTabAndGetChildHandle("Careers");
        System.out.println("\n[Contact Us -> Careers]");
        System.out.println("Parent (Contact Us) Window ID : " + contactUsWindow);
        System.out.println("Child  (Careers) Window ID    : " + careersWindow);

        switchToWindow(careersWindow);
        printTitleAndUrl("Careers");

        // -------------------- 4) Careers -> About Us --------------------
        String aboutUsWindow = openFooterLinkInNewTabAndGetChildHandle("About Us");
        System.out.println("\n[Careers -> About Us]");
        System.out.println("Parent (Careers) Window ID : " + careersWindow);
        System.out.println("Child  (About Us) Window ID: " + aboutUsWindow);

        switchToWindow(aboutUsWindow);
        // Your text said "Print ... from the Press Release Page" here, but you meant About Us.
        printTitleAndUrl("About Us");

        // -------------------- Close in required order --------------------
        closeCurrentTabAndSwitchBack(aboutUsWindow, careersWindow);     // close About Us -> back to Careers
        closeCurrentTabAndSwitchBack(careersWindow, contactUsWindow);   // close Careers -> back to Contact Us
        closeCurrentTabAndSwitchBack(contactUsWindow, pressReleaseWindow); // close Contact Us -> back to Press Releases
        closeCurrentTabAndSwitchBack(pressReleaseWindow, contactSalesWindow); // close Press Releases -> back to Contact Sales

        // Quit (closes remaining)
        driver.quit();
    }

    // ===================== Utilities =====================

    private static void clickCookieCloseIfPresent() {
        try {
            By cookieCloseBtn = By.className("CybotCookiebotBannerCloseButton");
            wait.withTimeout(Duration.ofSeconds(5))
                .until(d -> d.findElements(cookieCloseBtn).size() > 0);

            driver.findElement(cookieCloseBtn).click();
        } catch (Exception ignored) {
            // If not present, do nothing
        } finally {
            // restore default wait timeout
            wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        }
    }

    private static void scrollToFooter() {
        // Scroll near bottom to ensure footer links are visible/clickable
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        waitUntilPageStable();
    }

    private static void waitUntilPageStable() {
        try {
            wait.until(d -> ((JavascriptExecutor) d)
                    .executeScript("return document.readyState").equals("complete"));
        } catch (Exception ignored) {}
    }

    private static String openFooterLinkInNewTabAndGetChildHandle(String linkText) {
        scrollToFooter();

        By footerLink = By.linkText(linkText);

        wait.until(d -> d.findElement(footerLink).isDisplayed());
        WebElement link = driver.findElement(footerLink);

        Set<String> beforeHandles = driver.getWindowHandles();

        // CTRL + Click to open in new tab
        actions.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).build().perform();

        // Wait until a new window handle appears
        String childHandle = wait.until(newWindowHandleAppears(beforeHandles));
        return childHandle;
    }

    private static ExpectedCondition<String> newWindowHandleAppears(Set<String> oldHandles) {
        return d -> {
            Set<String> newHandles = d.getWindowHandles();
            newHandles.removeAll(oldHandles);
            return newHandles.size() == 1 ? newHandles.iterator().next() : null;
        };
    }

    private static void switchToWindow(String windowHandle) {
        driver.switchTo().window(windowHandle);
        waitUntilPageStable();
    }

    private static void printTitleAndUrl(String pageName) {
        System.out.println("\n--- " + pageName + " Page ---");
        System.out.println("Title : " + driver.getTitle());
        System.out.println("URL   : " + driver.getCurrentUrl());
    }

    private static void closeCurrentTabAndSwitchBack(String currentHandleToClose, String handleToSwitchBack) {
        // assumes you are already on currentHandleToClose
        driver.close();
        driver.switchTo().window(handleToSwitchBack);
        waitUntilPageStable();
    }
}
