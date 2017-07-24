package Yixin.Taoche.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Yixin.Taoche.Util.ObjectMap;

/**
 * @author maguanglu 定位首页元素
 */
public class HomePage {
	private WebElement element = null;
	// 指定页面元素定位表达式配置文件的绝对文件路径
	private ObjectMap objectMap = new ObjectMap("config/objectMap.properties");
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// 返回首页中的搜索输入框
	public WebElement SearchInput() throws Exception {
		// 使用objectMap类中的getLocator方法获取配置文件中关于SearchInput的定位方式和定位表达式
		element = driver.findElement(objectMap
				.getLocator("taoche.HomePage.SearchInput"));
		return element;
	}

	// 返回首页中的搜索按钮
	public WebElement SearchBtn() throws Exception {
		// 使用objectMap类中的getLocator方法获取配置文件中关于SearchBtn的定位方式和定位表达式
		element = driver.findElement(objectMap
				.getLocator("taoche.HomePage.SearchBtn"));
		return element;
	}
}
