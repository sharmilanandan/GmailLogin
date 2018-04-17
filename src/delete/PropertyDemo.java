package delete;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import generic.AUL;

public class PropertyDemo {
	public static WebDriver driver;
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	}

	public static void main(String[] args) {
		String s = AUL.getProperty("./settings.properties", "URL");
		System.out.println(s);
		driver = new ChromeDriver();
		driver.get(s);
		driver = new FirefoxDriver();
		driver.get(s);
		AUL.getPhoto(driver, "test", "./photo");
	}

}
