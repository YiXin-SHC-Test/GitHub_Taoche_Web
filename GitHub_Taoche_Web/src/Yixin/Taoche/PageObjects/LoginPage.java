package Yixin.Taoche.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Yixin.Taoche.Util.ObjectMap;

/**
 * @author maguanglu 定位登录页元素
 */
public class LoginPage {
	private WebElement element = null;
	// 指定页面元素定位表达式配置文件的绝对文件路径
	private ObjectMap objectMap = new ObjectMap("config/objectMap.properties");
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 返回帐号密码登录项
	public WebElement Login_UserName() throws Exception {
		// 使用objectMap类中的getLocator方法获取配置文件中关于Login_UserName的定位方式和定位表达式
		element = driver.findElement(objectMap
				.getLocator("taoche.LoginPage.Login_UserName"));
		return element;
	}

	// 返回登录页面中的用户名输入框页面元素对象
	public WebElement userName() throws Exception {
		// 使用objectMap类中的getLocator方法获取配置文件中关于userName的定位方式和定位表达式
		element = driver.findElement(objectMap
				.getLocator("taoche.LoginPage.username"));
		return element;
	}

	// 返回登录页面中的密码输入框页面元素对象
	public WebElement passWord() throws Exception {
		// 使用objectMap类中的getLocator方法获取配置文件中关于passWord的定位方式和定位表达式
		element = driver.findElement(objectMap
				.getLocator("taoche.LoginPage.password"));
		return element;
	}

	// 返回登录页面中的验证码输入框页面元素对象
	public WebElement ImgCode() throws Exception {
		// 使用objectMap类中的getLocator方法获取配置文件中关于ImgCode的定位方式和定位表达式
		element = driver.findElement(objectMap
				.getLocator("taoche.LoginPage.ImgCode"));
		return element;
	}

	// 返回登录页面中的登录按钮页面元素对象
	public WebElement Loginbtn_ByUserName() throws Exception {
		// 使用objectMap类中的getLocator方法获取配置文件中关于Loginbtn_ByUserName的定位方式和定位表达式
		element = driver.findElement(objectMap
				.getLocator("taoche.LoginPage.Loginbtn_ByUserName"));
		return element;
	}
}
