package Yixin.Taoche.Util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Magl 
 * 添加JS公共方法调用
 */
public class JScript {
	// 增加页面元素属性和修改页面元素属性的封装方法
	public void setAttribute(WebDriver driver, WebElement element,
			String attributeName, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		/* 调用JavaScript代码修改页面元素的属性值，argument[0]-[2]，分别代表后面的参数 */
		js.executeScript(
				"arguments[0].setAttribute(arguments[1],arguments[2])",
				element, attributeName, value);
	}

	// 删除页面元素属性的封装方法
	public void removeAttribute(WebDriver driver, WebElement element,
			String attributeName) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		/* 调用JavaScript代码删除页面元素的属性值，argument[0]-[1]，分别代表后面的参数 */
		js.executeScript("arguments[0].removeAttribute(arguments[1])", element,
				attributeName);
	}

	// 跳转至界面某个位置
	public void Moveto_tag(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// 移动到元素element对象的“顶端”与当前窗口的“顶部”对齐 false底部
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
