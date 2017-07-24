package Yixin.Taoche.Test.Joyce;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


import Yixin.Taoche.Util.WaitUtil;

public class TestTianTianPai
{
	public WebDriver driver;
	@Test(dependsOnMethods={"openBrowser"})
	public void tianTianPai()
	{
		driver.get("http://maiche.taoche.com");
		driver.manage().window().maximize();
		WebElement city=driver.findElement(By.id("spTTcity"));
		String cityText = city.getText();
		Assert.assertEquals("北京", cityText);
		city.click();
		WebElement cityshenzhen=driver.findElement(By.xpath(".//*[@id='ttCitys']/p/a[text()='深圳']"));//切换深圳城市
		String cityshenzhenText=cityshenzhen.getText();
		Assert.assertEquals("深圳",cityshenzhenText);
		cityshenzhen.click();
		WebElement phone=driver.findElement(By.id("txtPhone1"));
		WebElement click=driver.findElement(By.id("sub1"));
		phone.sendKeys("15712808014");
		click.click();
		WaitUtil.sleep(5000);		
		Assert.assertTrue(driver.getPageSource().contains("发布成功"));
	}
	@Test
	public void openBrowser()
	{
		driver=new FirefoxDriver();
	}
	@Test(dependsOnMethods={"tianTianPai"})
	public void closeBrowser()
	{
		driver.quit();
	}

}

