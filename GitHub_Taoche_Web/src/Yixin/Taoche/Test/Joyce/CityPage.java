package Yixin.Taoche.Test.Joyce;

import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import Yixin.Taoche.Util.WaitUtil;


public class CityPage
{
	WebDriver driver;
	@BeforeMethod
	public void openBrowser()
	{
		driver=new FirefoxDriver();
		driver.get("http://beijing.taoche.com");
	}
	@Test  //筛选区新车模块
	public void ChooseNewCar() //筛选区
	{
		//新车模块
		WebElement chooseXincheeElement=driver.findElement(By.id("html/body/div[4]/div[1]/ul/li[1]/a"));
		Assert.assertTrue(chooseXincheeElement.isDisplayed());//断言新车是否展示
		chooseXincheeElement.click();
    	WebElement dazhongElement=driver.findElement(By.xpath("html/body/div[4]/div[1]/div[1]/div[1]/div/a[text()='大众POLO']"));
    	Assert.assertTrue(dazhongElement.isDisplayed());//断言大众是否展示
    	dazhongElement.click();
    	WebElement qiyaElement=driver.findElement(By.xpath("html/body/div[4]/div[1]/div[1]/div[1]/div/a[text()='起亚k3']"));
    	Assert.assertTrue(qiyaElement.isDisplayed());//断言起亚是否展示
    	qiyaElement.click();
    	//切换到新打开窗口页面，判断链接
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
	@Test //筛选区二手车模块
	public void oldCar()
	{
		driver.findElement(By.xpath("//*[@id='divScreen']/div[1]/div[1]/strong")).click();	
		//断言品牌标题和展示
		WebElement pinPaiElement=driver.findElement(By.xpath("//*[@id='divScreen']/div[1]/div[1]/div/a[2]"));
		String pinPaiText=pinPaiElement.getText();
		Assert.assertEquals("丰田", pinPaiText);
		Assert.assertTrue(pinPaiElement.isDisplayed());
		//断言浮层中品牌标题和展示
		WebElement fuCengElement=driver.findElement(By.xpath("//*[@id='divScreen']/div[1]/div[2]/div[1]/dl[1]/dd/a[1]"));
		String fuCengText=fuCengElement.getText();
		Assert.assertEquals("奥迪", fuCengText);
		Assert.assertTrue(fuCengElement.isDisplayed());
		//断言车价
		WebElement carMoneyElement=driver.findElement(By.xpath("//*[@id='divScreen']/div[2]/div[1]/div/a[1]"));
		String carMoneyText=carMoneyElement.getText();
		Assert.assertEquals("3万以下", carMoneyText);
		Assert.assertTrue(carMoneyElement.isDisplayed());
		//断言级别
		WebElement carJibieElement=driver.findElement(By.xpath("//*[@id='divScreen']/div[2]/div[2]/div/a[2]"));
		String carJibieText=carJibieElement.getText();
		Assert.assertEquals("微型车", carJibieText);
		Assert.assertTrue(carJibieElement.isDisplayed());
		//断言车龄
		WebElement carChelingElement=driver.findElement(By.xpath("//*[@id='divScreen']/div[2]/div[3]/div/a[2]"));
		String carChelingText=carChelingElement.getText();
		Assert.assertEquals("2年以内", carChelingText);
		Assert.assertTrue(carChelingElement.isDisplayed());
		//打开链接
		pinPaiElement.click();
		fuCengElement.click();
		carChelingElement.click();				
		carMoneyElement.click();
		carJibieElement.click();		
		//切换到新打开窗口页面断言链接是否正确
    	String currentWindow=driver.getWindowHandle();//获取当前窗口句柄
    	Set<String>handles=driver.getWindowHandles();//获取所有窗口句柄
    	if (!handles.isEmpty()) 
    	{
    		for(String windowHandle:handles)
    		{
    			
    			try 
    			{
    			  WebDriver window=driver.switchTo().window(windowHandle);
    			  if(driver.switchTo().window(windowHandle).getTitle().contains("北京二手丰田"))
    			  {
    				    
                        String url=driver.getCurrentUrl();
   			        	System.out.println(url);
     			    	Assert.assertEquals("http://beijing.taoche.com/toyota/", url);
    			    	WaitUtil.sleep(2000);
     					window.close();	
    			  }
    			  else {
    				  if(driver.switchTo().window(windowHandle).getTitle().contains("北京二手奥迪"))
        			  {
        				    
                            String url1=driver.getCurrentUrl();
       			        	System.out.println(url1);
         			    	Assert.assertEquals("http://beijing.taoche.com/audi/", url1);
        			    	WaitUtil.sleep(2000);
         					window.close();	
    				  
				       }
    				  else {
			
    				        if(driver.switchTo().window(windowHandle).getTitle().contains("北京二手3万内"))
        			        {
        				    
                            String url2=driver.getCurrentUrl();
       			        	System.out.println(url2);
         			    	Assert.assertEquals("http://beijing.taoche.com/buycar/p1gesbxcdza/", url2);
        			    	WaitUtil.sleep(2000);
         					window.close();	
    				  
				            }
    				        else
    				        {
    				        	if(driver.switchTo().window(windowHandle).getTitle().contains("北京二手微型车"))
            			        {
            				    
                                String url3=driver.getCurrentUrl();
           			        	System.out.println(url3);
             			    	Assert.assertEquals("http://beijing.taoche.com/buycar/pg2esbxcdza/", url3);
            			    	WaitUtil.sleep(2000);
             					window.close();	      				  
    				            }
    				        	else
    				        	{
    				        		if(driver.switchTo().window(windowHandle).getTitle().contains("北京二手2年内"))
                			        {
                				    
                                    String url4=driver.getCurrentUrl();
               			        	System.out.println(url4);
                 			    	Assert.assertEquals("http://beijing.taoche.com/buycar/pgesbxcdza2/", url4);
                			    	WaitUtil.sleep(2000);
                 					window.close();	      				  
        				            }
    				        	}
							}
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
	@Test //筛选区分期
	public void fenQi()
	{
		driver.findElement(By.xpath("html/body/div[4]/div[1]/ul/li[3]/a")).click();
		
		
	}
	@AfterMethod
	public void closeBroswer()
	{
		driver.quit();
	}
	

}
