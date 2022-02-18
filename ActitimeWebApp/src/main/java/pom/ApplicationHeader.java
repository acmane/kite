package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplicationHeader {
	private WebDriver driver;
	private WebDriverWait wait;
	@FindBy (xpath ="//div[text()='Time-Track']")
	private WebElement timetrack;
	
	@FindBy (xpath ="//div[text()='Tasks']")
	private WebElement task;
	
	@FindBy (xpath ="//div[text()='Reports']")
	private WebElement report;
	
	@FindBy (xpath ="//div[text()='Users']")
	private WebElement user;
	
	@FindBy (xpath ="//a[@id='logoutLink']")
	private WebElement logout;
	
	public ApplicationHeader(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(driver,20);			
	}
	public void openTimetrak()
	{
		timetrack.click();
	}
	public void opentaskpage()
	{
		task.click();	
	}
	public void userpage()
	{
		user.click();
	}
	public void logoutpage()
	{
		logout.click();
	}
	public String timeTracktext()
	{
		String txt =timetrack.getText();
		return txt;
	}
}
