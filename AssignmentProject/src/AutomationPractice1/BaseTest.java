package AutomationPractice1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest 
{
	public static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir");
	public static FileInputStream fis;
	public static Properties p;
	public static Properties mainProp;
	public static Properties childProp;
	public static Properties orProp;
	public static ExtentReports report;
	public static ExtentTest test;
	
	public static void init() throws Exception
	{
		FileInputStream fis = new FileInputStream(projectPath +"//data.properties");
		p = new Properties();
		p.load(fis);
		
		fis = new FileInputStream(projectPath+ "//environment.properties");
		mainProp = new Properties();
		mainProp.load(fis);
		String e = mainProp.getProperty("env");
		
		fis = new FileInputStream(projectPath+"//"+e+".properties");
		childProp = new Properties();
		childProp.load(fis);
		String value = childProp.getProperty("automationpracticeurl");
		
		
		fis = new FileInputStream(projectPath + "//or.properties");
		orProp = new Properties();
		orProp.load(fis);
		
		fis = new FileInputStream(projectPath+ "//log4jconfig.properties");
		PropertyConfigurator.configure(fis);
		
	}
	
	public static void launch(String browser)
	{
	
		if(p.getProperty(browser).equals("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver" , "C:\\Users\\User\\Desktop\\Drivers\\chromedriver_win32\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver" , projectPath+"//drivers//chromedriver.exe");
			
			
			  ChromeOptions option = new ChromeOptions(); option.
			  addArguments("user-data-dir=C:\\Users\\User\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1"
			  ); option.addArguments("--disable-notifications"); driver = new
			  ChromeDriver(option);
			 
		}
		
	}
	
	public static void navigateUrl(String url)
	{
		//driver.get(childProp.getProperty(url));
		driver.navigate().to(childProp.getProperty(url));
	}

}

