package delete;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class OperaToTest {
	static {
		System.setProperty("webdriver.opera.driver", "./driver/operadriver.exe");
		System.setProperty("webdriver.ie.driver", "./driver/IEDriverServer.exe");
	}

	public static void main(String[] args) {
		WebDriver driver = new OperaDriver();
		// WebDriver driver=new InternetExplorerDriver();
		driver.get("https://www.google.com");

	}
}
