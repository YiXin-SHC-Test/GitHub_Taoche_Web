package Yixin.Taoche.TestScripts;

import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Yixin.Taoche.PageObjects.SearchPage;
import Yixin.Taoche.Util.*;

public class TestSearchPage {
	public static WebDriver driver;
	JavascriptExecutor js;
	// 调用常量地址
	private String baseurl = Constant.TaoChe_Url;

	@Test
	public void SearchPage() throws Exception {
		// 打印报告
		Log.info("访问网址 http://www.taoche.com");

		driver.get(baseurl);
		driver.manage().window().maximize();
		SearchPage searchPage = new SearchPage(driver);
		WaitUtil.sleep(2000);
		Log.info("检查搜索联想词");
		String inputString = "现代";
		WebElement input = searchPage.SearchInput();
		input.clear(); // 清除默认文字
		// 输入关键词
		input.sendKeys(inputString);
		WaitUtil.sleep(2000);
		// 操作搜索联想词弹层
		List<WebElement> suggetionOptions = searchPage.SearchTancengList();
		for (WebElement element : suggetionOptions) {
			if (element.getText().contains("现代 酷派")) {
				System.out.println(element.getText());
				element.click();
				break;
			}
		}
		WaitUtil.sleep(2000);
		// 调用公共方法SwitchWindow.校验结果页面
		SwitchWindow.getwindow(driver, "北京二手酷派", "北京二手酷派(进口)");
		WaitUtil.sleep(2000);
		// 回到首页，清除搜索输入框文字
		Log.info("清除搜索输入框文字");
		searchPage.SearchInput().clear();
		WaitUtil.sleep(2000);
		// 输入框输入关键词
		Log.info("检查搜索按钮功能");
		searchPage.SearchInput().sendKeys("奥迪");
		WaitUtil.sleep(2000);
		// 点击搜索按钮操作
		searchPage.SearchBtn().click();
		WaitUtil.sleep(2000);
		// 调用公共方法SwitchWindow.校验结果页面
		SwitchWindow.getwindow(driver, "北京二手奥迪", "北京二手奥迪");
		WaitUtil.sleep(2000);
	}

	// 打开浏览器
	@BeforeMethod
	public void openBrowser() {
		driver = new FirefoxDriver();
	}

	// 关闭浏览器
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	@BeforeTest
	//Test中任一测试用例之前执行
	public void BeforeTest() throws Exception {
		DOMConfigurator.configure("Log4j.xml");
	}

}
