package Yixin.Taoche.Test.Joyce;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Yixin.Taoche.Util.WaitUtil;

public class MCreateCar
{
	WebDriver driver;
	//打开浏览器
	@BeforeMethod
	public void  openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "d:\\test\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://m.taoche.com/sellcar/sellcar.aspx?source=1");
		
	}
	@Test
	public void CreateCar() throws Exception
	{
		//封面上传
		driver.findElement(By.id("fileUploadImg1")).click();
		Runtime.getRuntime().exec("E:\\test.exe");
		//选择品牌
		WaitUtil.sleep(2000); 
		driver.findElement(By.id("aCar")).click();
		WaitUtil.sleep(2000);
		driver.findElement(By.xpath("//span[text()='标致']")).click();
		//选择车系
		WaitUtil.sleep(2000);
		driver.findElement(By.xpath("//*[@id='popSerial']/div/div[3]/div[2]/div/ul/li[4]/a")).click();
		//选择车型
		WaitUtil.sleep(2000);
        driver.findElement(By.xpath("//*[@id='chooseCarPopup']/div[3]/div/ul/li[1]/a")).click();
        //选择上牌时间
		WaitUtil.sleep(2000);
        driver.findElement(By.id("aBuyCarDate")).click();
        //选择上牌年
		WaitUtil.sleep(2000);
        driver.findElement(By.xpath("//*[@id='popDateYear']/div/ul/li[2]/a")).click();
        //选择上牌月
		WaitUtil.sleep(2000);	
	    driver.findElement(By.xpath("//*[@id='popDateMonth']/div/ul/li[13]/a")).click();
		WaitUtil.sleep(2000);
		//选择上牌地
		driver.findElement(By.id("aArea")).click();
		//选择上牌地省份
	    WaitUtil.sleep(2000);
		driver.findElement(By.xpath("//*[@id='ulProvince']/li[3]/a")).click();
		//选择上牌地城市
		WaitUtil.sleep(2000);
		driver.findElement(By.xpath("//*[@id='divCityContent']/ul/li[2]/a[text()='北京']")).click();
		//选择表显里程
		WaitUtil.sleep(2000);
		driver.findElement(By.id("txtMileage")).sendKeys("1");
		//选择车辆颜色
		WaitUtil.sleep(2000);
		driver.findElement(By.id("aColor")).click();
		WaitUtil.sleep(2000);
		driver.findElement(By.xpath("//a[text()='黑色']")).click();
		WaitUtil.sleep(2000);
		//选择预售价格
		driver.findElement(By.id("txtPrice")).sendKeys("1");		
		WaitUtil.sleep(2000);
		//输入姓名
		driver.findElement(By.id("txtName")).sendKeys("测试");
		WaitUtil.sleep(2000);
		//输入手机号码
		driver.findElement(By.id("txtMobile")).sendKeys("15321921018");	
	    WaitUtil.sleep(2000);
	    //选择所在城市
		driver.findElement(By.id("aCarArea")).click();
	    WaitUtil.sleep(2000);
     	driver.findElement(By.xpath("//a[text()='北京']")).click();
		WaitUtil.sleep(2000);
		driver.findElement(By.xpath("//*[@id='divCityContent']/ul/li[2]/a[text()='北京']")).click();				
		WaitUtil.sleep(2000);
		//去掉天天拍车勾选
		driver.findElement(By.xpath(".//*[@id='Form1']/div[13]/div/em")).click();
		WaitUtil.sleep(2000);
		//提交
		driver.findElement(By.id("lnkSubmit")).click();	
		WaitUtil.sleep(2000);
		//断言提交是否成功
		Assert.assertTrue(driver.getPageSource().contains("发布成功"));
	}
	//关闭浏览器
	@AfterMethod
	public void closebrowser()
	{
		driver.quit();
	}
}
