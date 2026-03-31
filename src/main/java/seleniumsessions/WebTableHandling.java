package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandling {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();

		driver.get("https://naveenautomationlabs.com/opencart/ui/webtable.html");

		// driver.findElement(By.xpath("//td[text() =
		// 'Joe.Root']/preceding-sibling::td/input[@type = 'checkbox']")).click();

		// String userRole = driver.findElement(By.xpath("//td[text() =
		// 'Joe.Root']/ancestor::tr/td/span")).getText();

		;

		// System.out.println("User name of the Employee is :"+" User Role is: "
		// +getUserRole("Joe.Root") + "and Employee Status is: "+
		// getUserStatus("Joe.Root"));

		// driver.findElement(By.xpath("span[text()='Vedant Trivedi'
		// ]/ancestor::td/following-sibling::td/span/span"))

		// span[text()='Vedant Trivedi' ]/ancestor::td/following-sibling::td/span/span

		String[] users = { "Joe.Root", "Robert.Taylor", "Daniel.Thompson", "Emily.Davis", "Amanda.Clark",
				"Ashley.Rodriguez" };

		for (String user : users) {
			selectUserName(user);
			String role = getUserRole(user);
			String empName = getEmployeeName(user);
			String status = getEmpStatus(user);

			System.out.println(
					"Employee: " + empName + " | UserName : " + user + " | Role: " + role + " | Status: " + status);

		}

	}

	public static void selectUserName(String userName) {
		driver.findElement(
				By.xpath("//td[text() = '" + userName + "']/preceding-sibling::td/input[@type  = 'checkbox']")).click();
	}

	public static String getUserRole(String userName) {
		return driver
				.findElement(
						By.xpath("//td[text() = '" + userName + "']/ancestor::tr/td/span[contains(@class, 'role') ]"))
				.getText();

	}

	public static String getEmpStatus(String userName) {
		return driver
				.findElement(
						By.xpath("//td[text() = '" + userName + "']/ancestor::tr/td/span[contains(@class, 'status') ]"))
				.getText();

	}

	public static String getEmployeeName(String userName) {
		return driver.findElement(By.xpath("//td[text() = '" + userName + "']/ancestor::tr/td[4]")).getText();
	}

}
