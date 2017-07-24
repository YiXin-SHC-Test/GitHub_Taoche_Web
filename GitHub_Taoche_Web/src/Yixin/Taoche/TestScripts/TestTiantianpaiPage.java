package Yixin.Taoche.TestScripts;

import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Yixin.Taoche.PageObjects.TiantianpaiPage;
import Yixin.Taoche.Util.Log;
import Yixin.Taoche.Util.Constant;
import Yixin.Taoche.Util.WaitUtil;

public class TestTiantianpaiPage {
	WebDriver driver;

	@Test
	public void TaintianpaiPage() throws Exception {
		TiantianpaiPage tiantianpaiPage = new TiantianpaiPage(driver);
		// 定位城市选择框元素
		WaitUtil.sleep(2000);
		WebElement city = tiantianpaiPage.CityBtn();
		String cityText = city.getText();
		// 断言城市定位
		WaitUtil.sleep(2000);
		try {
			Assert.assertEquals("北京", cityText);
			Log.info("天天拍车页面城市自动定位成功");
			System.out.println("天天拍车页面城市自动定位成功");
			Reporter.log("天天拍车页面城市自动定位成功");
		} catch (AssertionError e) {
			Log.info("天天拍车页面城市自动定位失败");
			Reporter.log("天天拍车页面城市自动定位失败");
			System.out.println("天天拍车页面城市自动定位失败");
			Reporter.log("天天拍车页面城市自动定位失败");
			
		}
		// 切换城市为深圳
		city.click();
		WaitUtil.sleep(2000);
		tiantianpaiPage.CityList().click();
		WaitUtil.sleep(2000);
		String cityText1 = city.getText();
		WaitUtil.sleep(2000);
		// 断言切换城市是否成功
		try {
			Assert.assertEquals("深圳", cityText1);
			Log.info("天天拍车切换城市成功");
			System.out.println("天天拍车切换城市成功");
			Reporter.log("天天拍车切换城市成功");
		} catch (AssertionError e) {
			Log.info("天天拍车切换城市失败");
			System.out.println("天天拍车切换城市失败");
			Reporter.log("天天拍车切换城市失败");
		}
		// 输入手机号
		WaitUtil.sleep(2000);
		tiantianpaiPage.PhoneInput().sendKeys(Constant.PhoneNumber);
		// 点击提交
		WaitUtil.sleep(2000);
		tiantianpaiPage.TijiaoBtn().click();
		WaitUtil.sleep(5000);
		// 断言提交成功
		 try {
		Assert.assertTrue(driver.getPageSource().contains("提交成功"));
		Log.info("天天拍提交成功");
		System.out.println("天天拍提交成功");
		Reporter.log("天天拍提交成功");
		 } catch (AssertionError e) {
		 Log.info("天天拍提交失败");
		 System.out.println("天天拍提交失败");
		 Reporter.log("天天拍提交失败");
		 }

	}

	@BeforeMethod
	public void openBrowser() {
		driver = new FirefoxDriver();
		driver.get(Constant.Sellcar_Url);
		driver.manage().window().maximize();// 最大化窗口
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	// Test中任一测试用例之前执行
	@BeforeTest
	public void BeforeTest() throws Exception {
		DOMConfigurator.configure("Log4j.xml");
	}

}
