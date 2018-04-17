package script;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import page.GmailPage;
import page.InboxPage;
import page.SentMailSubPage;
import generic.AUL;
import generic.BaseTest;
import generic.Excel;

public class SendMailAndVerifySentData extends BaseTest {
	@Test
	public void testSendMailSDataByGetting() {
		String userEmail = Excel.getcellValue(EXCEL_PATH, "Sheet1", 0, 0);
		Reporter.log("user emailid : " + userEmail, true);
		String userPWd = Excel.getcellValue(EXCEL_PATH, "Sheet1", 0, 1);
		Reporter.log("User pwd :" + userPWd, true);

		GmailPage gp = new GmailPage(driver);
		try {
			// enter userame1
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
		String expectedMailSentTime = AUL.getCurrentdateAndTimeFormat();
		Reporter.log("Expected mail date and time  " + expectedMailSentTime, true);
		// click send
		ip.clickSendBTN(); 

		// clicking on sent msg view
		ip.verifysentMsg();

		// getting the date and time from sent mail and comparing with expected
		SentMailSubPage sm = new SentMailSubPage(driver);
		String actualdate = sm.getsentmaildate();
		Reporter.log("Actual mail Date and Time  " + actualdate, true);
		// if (actualdate.equalsIgnoreCase(expectedMailSentTime))
		// Reporter.log("Passed:Actual and expected time and date values equal");
		// else
		// Reporter.log("Failed:Actual and expected time and date values equal");

		// getting the to textfield address and verifying with exp value
		String actualToAddress = sm.getToMailAddress();
		Reporter.log("Entered to address value " + str, true);
		Reporter.log("Actual to textField mail address  " + actualToAddress, true);
		if (actualToAddress.equalsIgnoreCase(str))
			Reporter.log("Passed:composed and sent to address value is same");
		else
			Reporter.log("Failed:composed and sent to address values are not same");

		// getting subject and verifying
		String actualMailSub = sm.getMailSub();
		Reporter.log("Entered sub value is  " + subj, true);
		Reporter.log("Actual sub value is " + actualMailSub, true);
		if (actualMailSub.equalsIgnoreCase(subj))
			Reporter.log("passed:Actual and Expected sub is same");
		else
			Reporter.log("failed:Both actual and expected subject values are not same ");

		// getting mail body message

		// click signout
		ip.clickSignOutProfile();
		ip.signout();

	}
}
