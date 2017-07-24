package Yixin.Taoche.Test.Joyce;


import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Yixin.Taoche.Util.WaitUtil;

public class NewcarUrl 
{
    WebDriver driver;
    @Test
    public void newcarUrl1() 
    {
    	driver.get("http://www.taoche.com");
    	driver.findElement(By.xpath("html/body/div[4]/div[1]/ul/li[1]/a")).click();
    	driver.findElement(By.xpath("html/body/div[4]/div[1]/div[1]/div[1]/div/a[text()='大众POLO']")).click();
    	driver.findElement(By.xpath("html/body/div[4]/div[1]/div[1]/div[1]/div/a[text()='起亚k3']")).click();
    	//切换到新打开窗口页面
    	String currentWindow=driver.getWindowHandle();//获取当前窗口句柄
    	Set<String>handles=driver.getWindowHandles();//获取所有窗口句柄
    	if (!handles.isEmpty()) 
    	{
    		for(String windowHandle:handles)
    		{
    			
    			try 
    			{
    			  WebDriver window=driver.switchTo().window(windowHandle);
    			  if(driver.switchTo().window(windowHandle).getTitle().contains("北京POLO"))
    			  {
    				    
                        String url=driver.getCurrentUrl();
   			        	System.out.println(url);
     			    	Assert.assertEquals("http://xinche.taoche.com/lease/beijing/m118428/p139736/", url);
    			    	WaitUtil.sleep(2000);
     					window.close();	
    			  }
    			  else {
    				  if(driver.switchTo().window(windowHandle).getTitle().contains("北京起亚"))
        			  {
        				    
                            String url1=driver.getCurrentUrl();
       			        	System.out.println(url1);
         			    	Assert.assertEquals("http://xinche.taoche.com/lease/beijing/m120140/p139924/", url1);
        			    	WaitUtil.sleep(2000);
         					window.close();	
    				  
				       }
    			  }
    			}
    			catch (NoSuchWindowException e)
    			{
					e.printStackTrace();
				}
    		}
			
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
