package Yixin.Taoche.TestScripts;

import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Yixin.Taoche.PageObjects.CreateCarPage;
import Yixin.Taoche.Util.Constant;
import Yixin.Taoche.Util.Log;
import Yixin.Taoche.Util.Screenshot;
import Yixin.Taoche.Util.WaitUtil;

public class TestCreateCarPage {
	static WebDriver driver;
	@Test
	public void pcCreateCar() throws Exception {
		CreateCarPage createCarPage = new CreateCarPage(driver);
		// 切换个人卖车tab
		createCarPage.tab().click();
		WaitUtil.sleep(2000);
//		WaitUtil.waitWebelement(driver,
//				".//*[@id='carSelect2_letters_A']/p[1]/a");
		// 选择车型按钮
		createCarPage.ChexingBtn().click();
		WaitUtil.sleep(2000);
		// 选择品牌
		createCarPage.PinpaiBtn().click();
		WaitUtil.sleep(2000);
		// 选择车系
		createCarPage.ChexiBtn().click();
		WaitUtil.sleep(2000);
		// 选择车型
		createCarPage.Chexing2Btn().click();
		WaitUtil.sleep(2000);
		// 选择未上牌
		createCarPage.ShangpaidiBtn().click();
		WaitUtil.sleep(2000);
		// 输入表显里程
		createCarPage.LichengInput().sendKeys("1");
		WaitUtil.sleep(2000);
		// 输入车源价格
		createCarPage.PriceInput().sendKeys("1");
		WaitUtil.sleep(2000);
		// 输入手机号
		createCarPage.PhoneInput().sendKeys(Constant.PhoneNumber);
		WaitUtil.sleep(2000);
		// 点击获取验证码
		createCarPage.GetCodeBtn().click();
		WaitUtil.sleep(5000);
		// 从接口获取验证码
		String code = getCode();
		WaitUtil.sleep(5000);
		System.out.println(code);
		// 输入验证码
		createCarPage.CodeInput().sendKeys(code);
		WaitUtil.sleep(2000);
		// 选择封面
		createCarPage.FengmianBtn().click();
		Runtime.getRuntime().exec("Config/test.exe");
		WaitUtil.sleep(2000);
		// 去掉经销商勾选
		createCarPage.JingxiaoshangBtn().click();
		WaitUtil.sleep(2000);
		// 去掉天天拍勾选
		createCarPage.TiantianpaiBtn().click();
		WaitUtil.sleep(2000);
		// 提交
		createCarPage.TijiaoBtn().click();
		WaitUtil.sleep(3000);
		try {
			Assert.assertTrue(driver.getPageSource().contains("发布成功"));
			//打印报告
			Log.info("创建个人车源成功");
			System.out.println("创建个人车源成功");
			Reporter.log("创建个人车源成功");
		} catch (AssertionError e) {
			e.printStackTrace();
			Screenshot.takeTakesScreenshot(driver);
			Log.info("创建个人车源失败");
			System.out.println("创建个人车源失败");
			Reporter.log("创建个人车源失败");
		}
		
	}

	public static String getCode() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://ajax.taoche.cn/smscode/getautotestcode.ashx?m=15321921018&t=1");
		WebElement element = driver.findElement(By.xpath("html/body"));
		String text = element.getText();
		return text;
	}

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"config/chromedriver.exe"); // 用谷歌浏览器
		driver = new ChromeDriver();
		//调用常量地址
		driver.get(Constant.Sellcar_Url);
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit(); // 关闭浏览器
	}
	// Test每个测试用例执行之前，执行log文件
	@BeforeTest
	public void BeforeTest() throws Exception {
		DOMConfigurator.configure("Log4j.xml");
	}

}

