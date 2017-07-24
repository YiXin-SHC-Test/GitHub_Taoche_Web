package Yixin.Taoche.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Yixin.Taoche.Util.ObjectMap;

/**
 * @author fuxiaobai 定位搜索页元素
 */

public class SearchPage {
	private WebElement element = null;
	private List<WebElement> elements = null;
	private ObjectMap objectMap = new ObjectMap("config/objectMap.properties");
	private WebDriver driver;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}

	// 定位搜索输入框
	public WebElement SearchInput() throws Exception {
		element = driver.findElement(objectMap
				.getLocator("taoche.SearchPage.SearchInput"));
		return element;
	}

	// 定位联想词下拉列表
	public List<WebElement> SearchTancengList() throws Exception {
		elements = driver.findElements(objectMap
				.getLocator("taoche.SearchPage.SearchTancengList"));
		return elements;
	}

	// 定位搜索按钮
	public WebElement SearchBtn() throws Exception {
		element = driver.findElement(objectMap
				.getLocator("taoche.SearchPage.SearchBtn"));
		return element;
	}

}
