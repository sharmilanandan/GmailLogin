package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest1 implements IAutoConst{
public static WebDriver driver;
	
	//setting system properties 
	 @BeforeSuite(alwaysRun=true)
	 public static void setProperty(){
		 System.setProperty(CHROME_KEY, CHROME_VALUE);
		 System.setProperty(GECKO_KEY, GECKO_VALUE);
	 }
	 
	 //code for opening browser
	 @BeforeMethod(alwaysRun=true)
	 public void openApplication(){
		 
		 driver=new ChromeDriver();
		 long ITO=Long.parseLong(AUL.getProperty(PROPERTY_PATH, "ITO"));
		 driver.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS);
		 String URL=AUL.getProperty(PROPERTY_PATH, "URL");
		 driver.get(URL);
	 }
	 
	 //code for closing the browser
	 @AfterMethod(alwaysRun=true)
	 public void closeAppication(ITestResult res){
		String name= res.getName();
		int status=res.getStatus();
		Reporter.log("close test  :"+name+"  status  :"+status,true);
		if(status==2){
		String imgPath=AUL.getPhoto(driver, name, PHOTO_PATH);
		Reporter.log("imgpath  :"+imgPath,true);
		}
		driver.quit();
	 }

}
