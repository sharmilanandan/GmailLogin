package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SentMailSubPage {
	WebDriver driver;
	@FindBy(xpath = "//div[@data-tooltip='Delete']/div")
	private WebElement deleteBTN;

	@FindBy(xpath = "//span[text()='date:']/../..//td[2]")
	private WebElement sendmailDate;

	@FindBy(xpath = "//span[text()='to:']/../..//td[2]")
	private WebElement toAddress;

	@FindBy(xpath = "//span[text()='subject:']/../..//td[2]")
	private WebElement mailSub;

	WebDriverWait wait;

	public SentMailSubPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}

	public void clickDeleteBTN() {
       driver.switchTo().defaultContent();
		new Actions(driver).click(driver.findElement(By.cssSelector("div[aria-label='Delete']>div>div"))).perform();
		//wait.until(ExpectedConditions.elementToBeClickable(deleteBTN));
		deleteBTN.click();
	}

	public String getsentmaildate() {
		String text = sendmailDate.getText();
		return text;
	}

	public String getToMailAddress() {
		String to = toAddress.getText();
		return to;
	}

	public String getMailSub() {
		String sub = mailSub.getText();
		return sub;
	}

}
