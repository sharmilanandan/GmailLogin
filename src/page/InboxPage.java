package page;

import generic.AUL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class InboxPage {
	@FindBy(xpath="//a[@aria-label='Google apps']")
	private WebElement hamBurgerMenu;
	 
	@FindBy(xpath="//span[text()='Gmail']")
	private WebElement gmailLink;
	
	@FindBy(xpath="//div[text()='COMPOSE']")
	private WebElement composeClick;
	
	@FindBy(xpath="//textarea[@aria-label='To']")
	private WebElement clickToAddres;
	
	@FindBy(xpath="//span[contains(@aria-label,'Add Cc Recipients')]")
	private WebElement clickCcAddres;
	
	@FindBy(xpath="//span[text()='Cc' and @aria-label='Cc - Select Contacts']")
	private WebElement enterCcAddress;
	
	@FindBy(xpath="//input[@name='subjectbox']")
	private WebElement subject;
	
	@FindBy(xpath="//div[@aria-label='Message Body']")
	private WebElement msgBody;
	
	@FindBy(xpath="//div[text()='Send']")
	private WebElement sendBTN;
	
	@FindBy(xpath="//span[text()='View message']")
	private WebElement verifysentMailmsg;
	
	@FindBy(xpath="//img[@data-tooltip='Show details']")
	private WebElement clickSentMailDetails;
	
	@FindBy(xpath="//span[@class='gb_ab gbii']")
	private WebElement clikcSignoutProfile;
	
	@FindBy(xpath="//a[text()='Sign out']")
	private WebElement signOutBTN;
	
	public InboxPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	public void clickHamburgerMenu(){
		hamBurgerMenu.click();
	}
	
	public void clickongmailLink(){
		gmailLink.click();
	}
	
	public void clickOnCompose(){
		composeClick.click();
	}
	
	public void clickonToAddress(String str){
		clickToAddres.sendKeys(str);
	}
	public void clickonCcAddress(){
		clickCcAddres.click();
	   
	}
	public void enterCcAddress(String str,WebDriver driver){
		 //AUL.visibilityofelement(driver,enterCcAddress,20);
		enterCcAddress.sendKeys(str);
	}
	public void enterSubject(String str)
	{
		subject.sendKeys(str);
	}
	
	public void entertextintoMsgBody(String str){
		msgBody.sendKeys(str);
	}
	public void clickSendBTN(){
		sendBTN.click();
	}
	public void verifysentMsg(){
		verifysentMailmsg.click();
	}
	public void clickSentMailDetails(){
		clickSentMailDetails.click();
		
	}
	public void clickSignOutProfile(){
		clikcSignoutProfile.click();
	}
	public void signout(){
		signOutBTN.click();
	}

}
