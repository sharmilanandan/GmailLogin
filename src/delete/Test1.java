package delete;

import generic.BaseTest;
import generic.Excel;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Test1 extends BaseTest {
	@Test
	public void openApp(){
		String s=driver.getCurrentUrl();
		Reporter.log(s,true);
		Excel.writeDataToExcel("./data/input.xlsx", "Sheet1");
	}
	

}
