package Yixin.Taoche.Util;

import java.util.Set;

import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class SwitchWindow
{
    static WebDriver driver;
	public static void getwindow(WebDriver driver,String title,String title1) {
		String currentWindow = driver.getWindowHandle();// 获取当前窗口句柄
		Set<String> handles = driver.getWindowHandles();// 获取所有窗口句柄
		if (!handles.isEmpty()) {
			for (String windowHandle : handles) {
				try {
					WebDriver window = driver.switchTo().window(windowHandle);
					WaitUtil.sleep(2000);
					if (driver.switchTo().window(windowHandle).getTitle()
							.contains(title)) {
						String titleElement = driver.getTitle();
						System.out.println(titleElement);

						try {
							Assert.assertTrue(driver.getPageSource().contains(
									title1));
							Log.info("页面加载success");
							Reporter.log("页面加载success");
						} catch (AssertionError e) {
							Screenshot.takeTakesScreenshot(driver);
							Log.info("页面加载error");
							System.out.println("页面加载error");
						}
						WaitUtil.sleep(2000);
						window.close();
					}
				} catch (NoSuchWindowException e) {
					e.printStackTrace();
				}
			}
		}
		WaitUtil.sleep(2000);
		driver.switchTo().window(currentWindow);
	}
}
