package generic;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseTest implements IAutoConst {
	public static WebDriver driver;
	
	//setting system properties 
	 @BeforeSuite(alwaysRun=true)
	 public static void setProperty(){
		 //Excel.writeDataToExcel(EXCEL_PATH,"Sheet1");
		 System.setProperty(CHROME_KEY, CHROME_VALUE);
		 System.setProperty(GECKO_KEY, GECKO_VALUE);
		 System.setProperty(OPERA_KEY, OPERA_VALUE);
	 }
	
	 //code for opening browser
	// @Parameters({"browser"})
	  @BeforeMethod(alwaysRun=true)
	 public void openApplication(){
		 //getting browser value from testng.xml file
//	      if(browser.equalsIgnoreCase("chrome"))
//     		 driver=new ChromeDriver();
//		 else if(browser.equalsIgnoreCase("firefox"))
//			 driver=new FirefoxDriver();
//		 else
//			 driver=new OperaDriver();
		 //getting browser value from property file
		 String browser=AUL.getProperty(PROPERTY_PATH,"BROWSER");
		 Reporter.log(browser,true);
		 if(browser.equalsIgnoreCase("Firefox")){
				 driver=new FirefoxDriver();}
		 else
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
