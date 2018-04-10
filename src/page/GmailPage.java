package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailPage {
	WebDriver driver;
	//implementing page object model concept
	//Encapsulating the webelements 1.declaring webelements
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
		
		WebDriverWait wait;
				
 //2.Initializing elements
		
		public GmailPage(WebDriver driver)
		{   this.driver=driver;
		   wait = new WebDriverWait(driver,15);
			PageFactory.initElements(driver,this);
		}
		
//Utilizing elements by developing methods
		public void enterEmail(String str){
		    wait.until(ExpectedConditions.elementToBeClickable(emailTXFD));
			emailTXFD.sendKeys(str);
			
		}
		public void clickNextBtn(){
			wait.until(ExpectedConditions.elementToBeClickable(nextBTN));
			nextBTN.click();
		}
		public void enterpwd(String str){
			wait.until(ExpectedConditions.elementToBeClickable(pwdTXFD));
			pwdTXFD.sendKeys(str);
			
		}
		

}
