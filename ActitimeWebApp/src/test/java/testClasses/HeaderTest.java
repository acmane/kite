package testClasses;
	import java.io.File;
import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
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
	public class HeaderTest extends Browser
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
			driver.manage().window().maximize();
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
		
		@Test
		public void VerifyTimeTrackPage()
		{
			System.out.println("TimeTrackPage");
			header.openTimetrak();	
			String txt2 =header.timeTracktext();
			Assert.assertEquals(txt2,"Time-Track");
			//	if(txt2.equals("Time-Track"))/stmnt/else/stmt
		}
		@Test
		public void TitleTaskPage()
		{
			System.out.println("TitletaskPage");
			header.opentaskpage();
			String title= driver.getTitle();
			Assert.assertEquals(title, "actiTIME - Open Tasks");
			//if(title.equals("actiTIME - Open Task"))/else///
		}
		@Test (invocationCount =1)
		public void verifyUrlUsagerPage()
		{
			System.out.println("URLUsagePage");
			header.userpage();
			String url =driver.getCurrentUrl();
			Assert.assertEquals(url,"http://localhost/administration/userlist.do");	
			//if(url.equals("http://localhost/administration/userlist.do"))/else
		}	
		@Test
		public void URLTaskButten()
		{
			System.out.println("URL Task butten");
			header.opentaskpage();
			String url = driver.getCurrentUrl();
	
			SoftAssert softAssert =new SoftAssert();
			softAssert.assertEquals(url,"http://localhost/login.do");
			//if(url.equals("http://localhost/login.do"))
		}
		@Test(timeOut = 2000, priority= 1)
		public void Timeout() throws InterruptedException
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
