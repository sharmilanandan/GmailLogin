package script;

import generic.AUL;
import generic.BaseTest;
import generic.Excel;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import page.GmailPage;
import page.InboxPage;

public class ComposeMail extends BaseTest {

	@Test(priority = 1)
	public void testcomposeMail() {
		String userEmail = Excel.getcellValue(EXCEL_PATH, "Sheet1", 0, 0);
		Reporter.log("user emailid : " + userEmail, true);
		String userPWd = Excel.getcellValue(EXCEL_PATH, "Sheet1", 0, 1);
		Reporter.log("User pwd :" + userPWd, true);

		GmailPage gp = new GmailPage(driver);
		try {
			// enter userame
			gp.enterEmail(userEmail);
			// click next btn
			gp.clickNextBtn();
			// enter password
			// AUL.sleep(3);
			gp.enterpwd(userPWd);
			// click next
			// AUL.sleep(2);
			gp.clickNextBtn();

		}
		// if username wrong verify error msg
		catch (Exception e) {
			e.printStackTrace();
			throw e;
			// Reporter.log("Enter valid username/pwd",true);
		}

		InboxPage ip = new InboxPage(driver);
		// click hamburger menu
		ip.clickHamburgerMenu();

		// click gmail link
		ip.clickongmailLink();

		// click compose
		ip.clickOnCompose();

		// click to address
		String str = Excel.getcellValue(EXCEL_PATH, "Sheet2", 0, 0);
		ip.clickonToAddress(str);

		// click on cc
		String ccmailid = Excel.getcellValue(EXCEL_PATH, "Sheet2", 0, 1);
		ip.clickonCcAddress();
		ip.enterCcAddress(ccmailid, driver);
		driver.findElement(By.xpath("//span[text()='Cc' and @aria-label='Cc - Select Contacts']")).sendKeys(ccmailid);

		// enter subject
		String subj = Excel.getcellValue(EXCEL_PATH, "Sheet2", 0, 2);
		ip.enterSubject(subj);

		// enter text into mailbody
		String msg = Excel.getcellValue(EXCEL_PATH, "Sheet2", 0, 3);
		ip.entertextintoMsgBody(msg);

		// click send
		ip.clickSendBTN();

		// clicking on sent msg view
		ip.verifysentMsg();

		// click signout
		ip.clickSignOutProfile();
		ip.signout();

	}
}
