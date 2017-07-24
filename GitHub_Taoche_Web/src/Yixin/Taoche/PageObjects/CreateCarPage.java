package Yixin.Taoche.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Yixin.Taoche.Util.ObjectMap;

/**
 * @author fuxiaobai 定位创建页面元素
 */
public class CreateCarPage {

	private WebElement element = null;
	// 指定页面元素定位表达式配置文件的绝对文件路劲
	private ObjectMap objectMap = new ObjectMap("config/objectMap.properties");
	private WebDriver driver;

	public CreateCarPage(WebDriver driver) {
		this.driver = driver;
	}

	// 返回到个人卖车tab下
	public WebElement tab() throws Exception {
		element = driver.findElement(objectMap
				.getLocator("taoche.CreateCarPage.tab"));
		return element;
	}

	// 返回到选择车型
	public WebElement ChexingBtn() throws Exception {
		element = driver.findElement(objectMap
				.getLocator("taoche.CreateCarPage.ChexingBtn"));
		return element;
	}

	// 定位选择品牌按钮
	public WebElement PinpaiBtn() throws Exception {
		element = driver.findElement(objectMap
				.getLocator("taoche.CreateCarPage.PinpaiBtn"));
		return element;
	}

	// 定位选择车系按钮
	public WebElement ChexiBtn() throws Exception {
		element = driver.findElement(objectMap
				.getLocator("taoche.CreateCarPage.ChexiBtn"));
		return element;
	}

	// 定位选择车型按钮
	public WebElement Chexing2Btn() throws Exception {
		element = driver.findElement(objectMap
				.getLocator("taoche.CreateCarPage.Chexing2Btn"));
		return element;
	}

	// 定位上牌地点按钮
	public WebElement ShangpaidiBtn() throws Exception {
		element = driver.findElement(objectMap
				.getLocator("taoche.CreateCarPage.ShangpaidiBtn"));
		return element;
	}

	// 定位里程输入框
	public WebElement LichengInput() throws Exception {
		element = driver.findElement(objectMap
				.getLocator("taoche.CreateCarPage.LichengInput"));
		return element;
	}

	// 定位价格输入框
	public WebElement PriceInput() throws Exception {
		element = driver.findElement(objectMap
				.getLocator("taoche.CreateCarPage.PriceInput"));
		return element;
	}

	// 定位手机输入框
	public WebElement PhoneInput() throws Exception {
		element = driver.findElement(objectMap
				.getLocator("taoche.CreateCarPage.PhoneInput"));
		return element;
	}

	// 定位获取验证码按钮
	public WebElement GetCodeBtn() throws Exception {
		element = driver.findElement(objectMap
				.getLocator("taoche.CreateCarPage.GetCodeBtn"));
		return element;
	}

	// 定位验证码输入框
	public WebElement CodeInput() throws Exception {
		element = driver.findElement(objectMap
				.getLocator("taoche.CreateCarPage.CodeInput"));
		return element;
	}

	// 定位经销商按钮
	public WebElement JingxiaoshangBtn() throws Exception {
		element = driver.findElement(objectMap
				.getLocator("taoche.CreateCarPage.JingxiaoshangBtn"));
		return element;
	}

	// 定位天天拍按钮
	public WebElement TiantianpaiBtn() throws Exception {
		element = driver.findElement(objectMap
				.getLocator("taoche.CreateCarPage.TiantianpaiBtn"));
		return element;
	}

	// 定位上传封面按钮
	public WebElement FengmianBtn() throws Exception {
		element = driver.findElement(objectMap
				.getLocator("taoche.CreateCarPage.FengmianBtn"));
		return element;
	}

	// 定位提交按钮
	public WebElement TijiaoBtn() throws Exception {
		element = driver.findElement(objectMap
				.getLocator("taoche.CreateCarPage.TijiaoBtn"));
		return element;
	}

}
