package Yixin.Taoche.Test.Joyce;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import Yixin.Taoche.Util.SwitchWindow;
import Yixin.Taoche.Util.WaitUtil;

public class PCSearch {
	JavascriptExecutor js;
	public static WebDriver driver;

	@Test
	public void Search(){
		driver.get("http://www.taoche.com");
		WaitUtil.sleep(2000);
		String inputString = "现代";
		WebElement input = driver.findElement(By.id("txtSearchEr"));
		input.clear(); // 清除默认文字
		// 输入关键词
		input.sendKeys(inputString);
		WaitUtil.sleep(2000);
		// 搜索联想词
		List<WebElement> suggetionOptions = driver.findElements(By
				.xpath("//*[@id='divList']/ul/li"));
		for (WebElement element : suggetionOptions) {
			if (element.getText().contains("现代 酷派")) {
				System.out.println(element.getText());
				element.click();
				break;
			}
		}
		WaitUtil.sleep(2000);
		SwitchWindow.getwindow(driver, "北京二手酷派","北京二手酷派(进口)");
		WaitUtil.sleep(2000);
		driver.findElement(By.id("txtSearchEr")).clear();
		WaitUtil.sleep(2000);
		driver.findElement(By.id("txtSearchEr")).sendKeys("奥迪");
		WaitUtil.sleep(2000);
		driver.findElement(By.id("btnSearchEr")).click();
		WaitUtil.sleep(2000);
		SwitchWindow.getwindow(driver, "北京二手奥迪","北京二手奥迪");
		WaitUtil.sleep(2000);
	}

	@BeforeMethod
	public void openBrowser() {
		driver = new FirefoxDriver();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
