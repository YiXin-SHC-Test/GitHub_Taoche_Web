package Yixin.Taoche.TestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import Yixin.Taoche.PageObjects.HomePage;
import Yixin.Taoche.Util.WaitUtil;

public class TestTaocheHome {
	public WebDriver driver;
	String baseUrl = "http://www.taoche.com/";

	@Test
	public void HomePage_Search() throws Exception {
		driver.get(baseUrl + "/");
		HomePage homePage = new HomePage(driver);
		homePage.SearchInput().clear(); // 先清空搜索框中的内容
		homePage.SearchInput().sendKeys("奥迪"); // 搜索框中输入要查询的内容
		WaitUtil.sleep(5000);
		homePage.SearchBtn().click(); // 执行查询操作
		WaitUtil.sleep(5000);
		Assert.assertTrue(driver.getPageSource().contains("奥迪"));
	}

	@BeforeMethod
	public void beforeMethod() {
		// 设定Firefox浏览器启动文件的绝对路径
		/*
		 * System.setProperty("webdriver.firefox.bin",
		 * "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		 */
		driver = new FirefoxDriver(); // 打开火狐浏览器
		driver.manage().window().maximize(); // 浏览器最大化
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
		driver.quit();
	}

}
