package Yixin.Taoche.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Yixin.Taoche.Util.*;

/**
 * @author fuxiaobai 卖车-天天拍页面定位元素
 */
public class TiantianpaiPage {
	private WebElement element = null;
	private ObjectMap objectMap = new ObjectMap("config/objectMap.properties");
	private WebDriver driver;

	public TiantianpaiPage(WebDriver driver) {
		this.driver = driver;
	}

	// 定位城市选择按钮元素
	public WebElement CityBtn() throws Exception {
		element = driver.findElement(objectMap
				.getLocator("taoche.TiantianPaiPage.CityBtn"));
		return element;
	}

	// 定位城市下拉选择框元素
	public WebElement CityList() throws Exception {
		element = driver.findElement(objectMap
				.getLocator("taoche.TiantianPaiPage.CityList"));
		return element;
	}

	// 定位手机号元素
	public WebElement PhoneInput() throws Exception {
		element = driver.findElement(objectMap
				.getLocator("taoche.TiantianPaiPage.PhoneInput"));
		return element;
	}

	// 定位提交按钮元素
	public WebElement TijiaoBtn() throws Exception {
		element = driver.findElement(objectMap
				.getLocator("taoche.TiantianPaiPage.TijiaoBtn"));
		return element;
	}

}
