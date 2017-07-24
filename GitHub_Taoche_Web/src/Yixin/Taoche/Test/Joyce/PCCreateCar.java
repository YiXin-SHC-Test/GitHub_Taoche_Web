package Yixin.Taoche.Test.Joyce;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Yixin.Taoche.Util.WaitUtil;

public class PCCreateCar {
	static WebDriver driver;

	@Test
	public void pcCreateCar() throws Exception{
		//切换到个人卖车tab
		driver.findElement(By.id("li2")).click();
		WaitUtil.sleep(2000);
		//选择品牌
		driver.findElement(By.id("carSelect2")).click();
		WaitUtil.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='carSelect2_letters_A']/p[1]/a")).click();
		WaitUtil.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='carSelect2_serial_list']/div/p/a[text()='奥迪100']")).click();
		WaitUtil.sleep(2000);
		driver.findElement(By.xpath("//*[@id='carSelect2_cartype_list']/div/p/a[text()='1.8L']")).click();
		WaitUtil.sleep(2000);
		//选择未上牌
		driver.findElement(By.id("ckbReg2")).click();
		WaitUtil.sleep(2000);
		//输入表显里程
		driver.findElement(By.id("txtDrive2")).sendKeys("1");
		WaitUtil.sleep(2000);
		//输入期望价格
		driver.findElement(By.id("txtPrice2")).sendKeys("1");
		WaitUtil.sleep(2000);
		//输入手机号
		driver.findElement(By.id("txtPhone2")).sendKeys("15321921018");
		WaitUtil.sleep(2000);
		//获取验证码
		driver.findElement(By.id("smsCode2")).click();
		//等待点击获取验证码
		WaitUtil.waitWebelement(driver,
				".//*[@id='smsCode2']/span/a[contains(text(),'后获取')]");	
		//调取接口
		String code = getCode();
		WaitUtil.sleep(1000);
		System.out.println(code);
		//输入验证码
		driver.findElement(By.id("txtCode2")).sendKeys(code);
		WaitUtil.sleep(1000);
		//载入封面
		driver.findElement(By.id("aUploadImg")).click();
		Runtime.getRuntime().exec("E:\\test.exe");
		WaitUtil.sleep(1000);
		//去掉勾选经销商
		driver.findElement(By.id("ckbToDealer2")).click();
		WaitUtil.sleep(1000);
		//去掉勾选天天拍
		driver.findElement(By.id("ckbToTtpc2")).click();
		WaitUtil.sleep(1000);
		//发布车源
		driver.findElement(By.id("sub2")).click();
		//断言发布成功
		Assert.assertTrue(driver.getPageSource().contains("发布成功"));				
	}
    //获取验证码接口
	public static String getCode() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://ajax.taoche.cn/smscode/getautotestcode.ashx?m=15321921018&t=1");
		WebElement element = driver.findElement(By.xpath("html/body"));
		String text = element.getText();
		driver.quit();
		return text;
	}

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"d:\\test\\chromedriver.exe");
	     driver = new ChromeDriver();
		driver.get("http://maiche.taoche.com/");

	}

	@AfterMethod
	public void closeBrowser() {
		//driver.quit();
	}
}
