package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OrangeHRMMouseHover {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/");
		Thread.sleep(3000);
		
//		WebElement solutions = driver.findElement(By.linkText("Solutions"));
//		WebElement roster = driver.findElement(By.xpath("//div[@class = 'col-md-3 sub-module-list']/a[text() = 'Roster ']"));
//		
//		By leftMenu = By.xpath("//div[@class = 'left-sub-menu']/a");
//		
//		
//		
//		Actions act = new Actions(driver);
//		
//		act.moveToElement(solutions).build().perform();
//		Thread.sleep(2000);
		
//		WebElement versions = driver.findElement(By.xpath("//div[@class = 'nav-section-title']/p[1]"));
//	
//		WebElement solutionsOverview = driver.findElement(By.xpath("//div[@class = 'row right-menu']/div/div"));
//		List<WebElement> solutionOverViewOptions = driver.findElements(By.xpath("//div[@class = 'row right-menu']/div/a"));
//	
//		WebElement subModules = driver.findElement(By.xpath("//div[@class = 'sub-module'][1]"));
//		List<WebElement> subModuleOptions = driver.findElements(By.xpath("//div[@class = 'row sub-module-menu']/div/a"));
//		
//		System.out.println(versions.getText());
//		List<WebElement> listMenuEle = driver.findElements(leftMenu);
//		//System.out.println(listMenuEle.size());
//		
//		for(WebElement e: listMenuEle) {
//			String text = e.getText();
//			if(text.length() !=0) {
//				System.out.println(text);
//			}
//			
//		}
//		
//		System.out.println("------------------");
//		
//		System.out.println(solutionsOverview.getText());
//		for(WebElement e: solutionOverViewOptions) {
//			String text = e.getText();
//			if(text.length() !=0) {
//				System.out.println(text);
//			}
//			
//		}
//		
//		
//		
//		System.out.println("------------------");
//		
//		System.out.println(subModules.getText());
//		for(WebElement e: subModuleOptions) {
//			String text = e.getText();
//			if(text.length() !=0) {
//				System.out.println(text);
//			}
//			
//		}
//		
		
		By solutionsText = By.linkText("Solutions");
		
		By versionText = By.xpath("//div[@class = 'nav-section-title']/p[1]");
		By versionOptions= By.xpath("//div[@class = 'left-sub-menu']/a");
		
		By solutionsOverviewText = By.xpath("//div[@class = 'row right-menu']/div/div");
		By solutionOverViewOptions = By.xpath("//div[@class = 'row right-menu']/div/a");
		
		By subModuleText = By.xpath("//div[@class = 'sub-module'][1]");
		By subModuleoptions = By.xpath("//div[@class = 'row sub-module-menu']/div/a");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		
		eleUtil.doActionsClick(solutionsText);  //Action : click on Solution
		
		String version = eleUtil.doElementGetText(versionText);
		System.out.println(version);
		
		eleUtil.getElements(versionOptions);
		int versionCount = eleUtil.getElementsCount(versionOptions);
		System.out.println(versionCount);

		List<String> versionOptionsText =  eleUtil.getElementsTextList(versionOptions);
		System.out.println(versionOptionsText);
		
		System.out.println("--------------------------\n");
		
		
		String solutionsOverview = eleUtil.doElementGetText(solutionsOverviewText);
		System.out.println(solutionsOverview);
		
		eleUtil.getElements(solutionOverViewOptions);
		int solutionOverViewOptionsCount = eleUtil.getElementsCount(solutionOverViewOptions);
		System.out.println(solutionOverViewOptionsCount);

		List<String> solutionOverViewOptionsText =  eleUtil.getElementsTextList(solutionOverViewOptions);
		System.out.println(solutionOverViewOptionsText);
		
		System.out.println("--------------------------\n");
		
		String subModule = eleUtil.doElementGetText(subModuleText);
		System.out.println(subModule);
		
		eleUtil.getElements(subModuleoptions);
		int subModuleoptionsCount = eleUtil.getElementsCount(subModuleoptions);
		System.out.println(subModuleoptionsCount);

		List<String> subModuleoptionsText =  eleUtil.getElementsTextList(subModuleoptions);
		System.out.println(subModuleoptionsText);
		
		

		Thread.sleep(5000);
		//roster.click();
		driver.quit();
		
		

	}

}
