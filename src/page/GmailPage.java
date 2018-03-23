package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailPage {
	//implementing page object model concept
	//Encapsulating the webelements 1.declaring webelements
	  //@FindBy(id="identifierId")
		@FindBy(xpath="//input[@type='email']")
		private WebElement emailTXFD;
		
		@FindBy(xpath="//div[contains(.,'your Google Account')and@aria-live='assertive']")
		private WebElement invdEmailErrmsg;
		
		@FindBy(xpath="//span[text()='Next']")
		private WebElement nextBTN;
		
		@FindBy(xpath="//input[@name='password']")
		private WebElement pwdTXFD;
		
		@FindBy(xpath="//div[contains(text(),'Wrong password.')]")
		private WebElement pwdErrMsg;
		

				
 //2.Initializing elements
		
		public GmailPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		
//Utilizing elements by developing methods
		public void enterEmail(String str){
		
			emailTXFD.sendKeys(str);
			
		}
		public void clickNextBtn(){
			nextBTN.click();
		}
		public void enterpwd(String str){
			
			pwdTXFD.sendKeys(str);
			
		}
		

}
