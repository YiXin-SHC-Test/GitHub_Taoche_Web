package Yixin.Taoche.Modules;

import org.openqa.selenium.WebDriver;

import Yixin.Taoche.PageObjects.LoginPage;
import Yixin.Taoche.Util.WaitUtil;

public class Login_Action_ByUsername {
	public static void execute(WebDriver driver, String userName,
			String passWord, String ImageCode) throws Exception {
		driver.get("http://home.taoche.com/login/");
		WaitUtil.sleep(3000);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Login_UserName().click(); // 通过帐号密码登录
		loginPage.userName().sendKeys(""); // 输入用户名
		WaitUtil.sleep(3000);
		loginPage.passWord().sendKeys(""); // 输入密码
		WaitUtil.sleep(3000);
		loginPage.ImgCode().sendKeys(""); // 输入验证码
		WaitUtil.sleep(3000);
		loginPage.Loginbtn_ByUserName().click(); // 点击登录按钮
	}
}
