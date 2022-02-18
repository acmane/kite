package testClasses;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import Base.Browser;
import pom.ApplicationHeader;
import pom.LoginPage;

public class test extends Browser
{
	WebDriver driver;
	ApplicationHeader header; 
	LoginPage L;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser)
	{
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		
		System.out.println("browser");
		
		if(browser.equalsIgnoreCase("chrome"))
			{
			driver= launchChromeBrowser();
			}
		if(browser.equalsIgnoreCase("edge"))
		{
			driver=launchEdgeBrowser();
		}
		if(browser.equalsIgnoreCase("firefox"))
			{
			driver=launchFirefoxBrowser();
			}
	//	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@BeforeClass
	public void CreatePOMobject()
	{
		header =new ApplicationHeader(driver);
		L= new LoginPage(driver);
	}
	@BeforeMethod()
	public void LoginToApplication()
		{
		driver.get("http://localhost/login.do");
		L = new LoginPage(driver);
		L.sendUsername("admin");
		L.sendPassword("manager");
		L.clickOnLogin();
		//L.loginapp();
		System.out.println("before method exe:OK");
		}
	@Test (enabled=false)
	public void VerifyLoginButtenText()
	{
		L = new LoginPage(driver);
		String txt1=L.loginButtenText();
		System.out.println(txt1);
	//	Assert.assertEquals(txt1, "unknown");
	}	
	@Test
	public void LoginTitleVerify()
	{
		String title =driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title,"actiTIME - Enter Time-Track");
		//	if(title.equals("actiTIME - Login"))/true /else{ false statement}
	}
	@Test
	public void VerifyTimeTrackPage()
	{
		System.out.println("txt2 Time Track Page");
		header.openTimetrak();	
		String txt2 =header.timeTracktext();
		Assert.assertEquals(txt2,"Time-Track");
		//	if(txt2.equals("Time-Track"))/stmnt/else/stmt
	}
	@Test
	public void VerifytitleTaskPage()
	{
		System.out.println("title0 Task Page");
		header.opentaskpage();
		String title= driver.getTitle();
		Assert.assertEquals(title, "actiTIME - Open Tasks");
		//if(title.equals("actiTIME - Open Task"))/else///
	}
	@Test(timeOut = 3000, priority=1)
	public void Timeout0() throws InterruptedException
	{
		System.out.println("Start delay");
		Thread.sleep(1000);
		System.out.println("end delay");
	}
	@AfterMethod
	
	public void LogoutApplication()
	{
		header= new ApplicationHeader(driver);
		header.logoutpage();
		System.out.println("After method exe:OK");
	}	
	@AfterClass
	public void ClearPOMobjects()
	{
		L = null;
		header =null;
	}
	@AfterTest
	public void QuiteApp()
	{
		System.out.println("Quite App");
		driver.quit();
		driver=null;
		System.gc(); //del all objects memory free
	}
	
}