package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Browser {

	public static WebDriver launchChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Testing Apk\\Selenium\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		return driver;
	}
	public static WebDriver launchEdgeBrowser()
	{
		System.setProperty("webdriver.edge.driver","D:\\Testing Apk\\Selenium\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver= new EdgeDriver();
		return driver;
	}
	public static WebDriver launchFirefoxBrowser()
	{
		System.setProperty("webdriver.gecko.driver","gecko driver.exe");
		WebDriver driver= new FirefoxDriver();
		return driver;
	}
	public static WebDriver launchOperaBrowser()
	{
		System.setProperty("webdriver.opera.driver","operadriver.exe");
		WebDriver driver= new OperaDriver();
		return driver;
	}
	
	
}
