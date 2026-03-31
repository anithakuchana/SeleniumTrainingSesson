package seleniumsessions;

public class OpenCartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BrowserUtil brUtil = new BrowserUtil();

		brUtil.initDriver("chrome");
		brUtil.enterUrl("https://naveenautomationlabs.com/opencart/");

		String actTitle = brUtil.getPageTitle();
		if (actTitle.equals("Your Store")) {
			System.out.println("Page title is correct --- Pass");
		} else {
			System.out.println("Page title is not correct --- Fail");
		}

		String actUrl = brUtil.getPageUrl();
		if (actUrl.contains("opencart")) {
			System.out.println("Home Page Url is correct --- Pass");
		} else {
			System.out.println("Home Page Url is not correct --- Fail");
		}

		brUtil.quitBrowser();

	}

}
