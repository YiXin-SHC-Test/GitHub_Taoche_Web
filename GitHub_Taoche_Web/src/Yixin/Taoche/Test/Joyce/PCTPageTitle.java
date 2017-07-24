package Yixin.Taoche.Test.Joyce;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class PCTPageTitle
{
	public WebDriver driver;
	//首页
	@Test
	public void CityPageTitle()
	{
	 driver.get("http://www.taoche.com");
	 String title=driver.getTitle();
	 System.out.println(title);
	 Assert.assertEquals("淘车-腾讯京东百度易车共同投资的新车二手车交易平台", title);

	}
	//新车页面
	@Test
	public void XinchePageTitle()
	{
		 
		 driver.get("http://xinche.taoche.com/lease/beijing/");
		 String title=driver.getTitle();
		 System.out.println(title);
		 Assert.assertEquals("【新车】北京长租车_北京租车-淘车", title);
	}
	//二手车页面
	@Test
	public void OldcarTitle()
	{
		 
		 driver.get("http://beijing.taoche.com/all/");
		 String title=driver.getTitle();
		 System.out.println(title);
		 Assert.assertEquals("北京二手车价格_最新北京二手车报价-北京淘车", title);
	}
	//分期页面
	@Test
	public void FenqiPageTitle()
	{
		 
		 driver.get("http://fenqi.taoche.com/budget/beijing/");
		 String title=driver.getTitle();
		 System.out.println(title);
		 Assert.assertEquals("【北京贷款买车】_首付_分期-淘车", title);
	}
	//车险页面
	@Test
	public void ChexianPageTitle()
	{
		 
		 driver.get("http://chexian.taoche.com/?yxms=NPH0006");
		 String title=driver.getTitle();
		 System.out.println(title);
		 Assert.assertEquals("【汽车保险】_交强险_商业险_车险比价-淘车", title);
	}
	//体验店页面
	@Test
	public void TiyanPageTitle()
	{
		 
		 driver.get("http://tiyandian.taoche.com/");
		 String title=driver.getTitle();
		 System.out.println(title);
		 Assert.assertEquals("体验店_一站式用车服务平台-淘车", title);
	}
	//帮买页面
	@Test
	public void BangmaiPageTitle()
	{
		 
		 driver.get("http://bangmai.taoche.com/");
		 String title=driver.getTitle();
		 System.out.println(title);
		 Assert.assertEquals("帮买服务 - 淘车", title);
	}
	//评估页面
	@Test
	public void PingguPageTitle()
	{
		 
		 driver.get("http://www.taoche.com/pinggu/");
		 String title=driver.getTitle();
		 System.out.println(title);
		 Assert.assertEquals("【二手车评估_二手车免费在线估价_二手车估价计算器】_淘车", title);
	}
	//卖车页面
	@Test
	public void MaichePageTitle()
	{
		 
		 driver.get("http://maiche.taoche.com/");
		 String title=driver.getTitle();
		 System.out.println(title);
		 Assert.assertEquals("【发布车源_免费发布卖车信息_我要卖车】_淘车车", title);
	}
	//置换页面
	@Test
	public void ZhihuanPageTitle()
	{
		 
		 driver.get("http://zhihuan.taoche.com/");
		 String title=driver.getTitle();
		 System.out.println(title);
		 Assert.assertEquals("【二手车置换_置换购车_旧车置换新车优惠】_淘车", title);
	}
	//经销商页面
	@Test
	public void JingxiaoshangPageTitle()
	{
		 
		 driver.get("http://www.taoche.com/dealer/");
		 String title=driver.getTitle();
		 System.out.println(title);
		 Assert.assertEquals("【二手车经销商_二手车商家_二手车买卖】_淘车", title);
	}
	//人车生活页面
	@Test
	public void RenchelivePageTitle()
	{
		 
		 driver.get("http://www.taoche.com/huati/");
		 String title=driver.getTitle();
		 System.out.println(title);
		 Assert.assertEquals("【人车生活_车型推荐_二手车行情资讯】_二手车生活话题-淘车", title);
	}
	@BeforeMethod
	public void OpenBrowser()
	{
		driver=new FirefoxDriver();
	}
	@AfterMethod
	public void CloseBrowser()
	{
		driver.quit();
	}
}


