package Yixin.Taoche.Util;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * @author maguanglu
 * 截图方法
 */
public class Screenshot {
	public static void takeTakesScreenshot(WebDriver driver) {
		try {
			// 生成日期对象
			Date date = new Date();
			// 调用DateUtil类中的方法，生成截图所在文件夹日期名称
			String picDir = "e:\\" + String.valueOf(DateUtil.getYear(date))
					+ "-" + String.valueOf(DateUtil.getMonth(date))
					+ String.valueOf(DateUtil.getDay(date));
			if (!new File(picDir).exists()) {
				FileUtil.createDir(picDir);
			}
			// 调用DateUtil类中的方法，生成截图文件的时间名称
			String filePath = picDir + "\\"
					+ String.valueOf(DateUtil.getHour(new Date())) + "-"
					+ String.valueOf(DateUtil.getMinute(new Date())) + "-"
					+ String.valueOf(DateUtil.getSecond(new Date())) + ".png";
			// 进行截图，并将文件内容保存在srcFile对象中
			File srcFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			// 将截图文件内容写入到磁盘中，生成截图文件
			FileUtils.copyFile(srcFile, new File(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
