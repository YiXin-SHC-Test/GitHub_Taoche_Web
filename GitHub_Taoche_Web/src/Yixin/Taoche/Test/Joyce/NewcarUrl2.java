package Yixin.Taoche.Test.Joyce;

import java.util.Set;
import java.util.Iterator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Yixin.Taoche.Util.WaitUtil;
public class NewcarUrl2
{
	public class NewcarUrl 
	{
	    WebDriver driver;
	    @Test
	    public void newcarUrl() throws Exception
	    {
	    	driver.get("http://www.taoche.com");
	    	driver.findElement(By.xpath("html/body/div[4]/div[1]/ul/li[1]/a")).click();
	    	driver.findElement(By.xpath("html/body/div[4]/div[1]/div[1]/div[1]/div/a[text()='大众POLO']")).click();
	    	//切换到新打开窗口页面
	    	String currentWindow=driver.getWindowHandle();//获取当前窗口句柄
	    	Set<String>handles=driver.getWindowHandles();//获取所有窗口句柄
	    	Iterator<String>it=handles.iterator();
	    	while (it.hasNext()) {
				if(currentWindow==it.next()){
					continue;
				}
	        WebDriver window=driver.switchTo().window(it.next());
	    	//获取新窗口链接
	    	String url=driver.getCurrentUrl();
	    	System.out.println(url);
	    	//断言新窗口链接是否正确
	    	Assert.assertEquals("http://xinche.taoche.com/lease/beijing/m118428/p139736/", url);
	    	WaitUtil.sleep(2000);
			window.close();	
			}
	    	WaitUtil.sleep(2000);
	    	driver.switchTo().window(currentWindow);
	     	
	    }
	    @BeforeMethod
	    public void openBrowser()
	    {
	    	driver=new FirefoxDriver();
	    }
	    @AfterMethod
	    public void closeBrowser()
	    {
	    	driver.quit();
	    }
	  
	}
}
