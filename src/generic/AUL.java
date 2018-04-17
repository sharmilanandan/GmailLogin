package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AUL {

	// developing generic method to get the propertyfile values
	public static String getProperty(String settingsPath, String key) {
		String v = "";
		Properties p = new Properties();
		try {
			p.load(new FileInputStream(settingsPath));
			v = p.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return v;
	}

	// developing generic method to take screenshots
	public static String getPhoto(WebDriver driver, String sheetName, String photoPath) {
		String path = "";
		TakesScreenshot t = (TakesScreenshot) driver;
		File srcfile = t.getScreenshotAs(OutputType.FILE);
		path = photoPath + sheetName + (new Date()).toString().replaceAll(":", "-") + ".png";
		File destfile = new File(path);
		try {
			FileUtils.copyFile(srcfile, destfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;

	}

	public static void sleep(int ms) {
		try {
			Thread.sleep(1000 * ms);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public static void visibilityofelement(WebDriver driver, WebElement element, long ito) {
		WebDriverWait wait = new WebDriverWait(driver, ito);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static String getCurrentdateAndTimeFormat() {
		Date d = new Date();
		System.out.println(d.toString());
		SimpleDateFormat s = new SimpleDateFormat("E,MMM dd,YYYY");
		String n = s.format(d);
		n = n.concat(" at ");
		n = n.concat(new SimpleDateFormat("HH:mm a").format(d));
		return n;
	}

}
