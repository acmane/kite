package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy (xpath ="//input[@id='username']")
	private WebElement username;
	
	@FindBy (xpath ="//input[@class='textField pwdfield']")
	private WebElement password;
	
	@FindBy (xpath="//a[@id='loginButton']")
	private WebElement login;
	
	@FindBy (xpath ="//input[@type='checkbox']")
	private WebElement keepMeCheckbox;
	
	public LoginPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	
	public void sendUsername(String userid)
	{
	username.sendKeys(userid);	
	}
	public void sendPassword(String pswd)
	{
		password.sendKeys(pswd);
	}
	public String loginButtenText()
	{
		
		String textsave =login.getText();
		return textsave;
	}
	public void clickOnLogin()
	{
		login.click();		
	}
//	public void selectKeepmelogin()
	{
//		keepMeCheckbox.click();
	}
//	public void loginapp()
//	{
//		username.sendKeys("admin");
//		password.sendKeys("maager");
//		login.click();
//	}
}
