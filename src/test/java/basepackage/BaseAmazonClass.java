package basepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.TimeUtils;

public class BaseAmazonClass {
	
	
	public static Properties prop = new Properties();
	public static WebDriver  driver;
	
	//STEP 1 .Creating Constructor
	
	public BaseAmazonClass() {
	
	try
	{
		FileInputStream file = new FileInputStream("C:\\Users\\Rajesh\\eclipse-workspace\\HRManagement2\\AmazonWebsite\\src\\test\\java\\environmentvariables\\Config.Properties");
		prop.load(file);
		
		
	}
	catch(FileNotFoundException e)
	{
		
		e.printStackTrace();
		
	}
	
	catch(IOException a)
	{
		a.printStackTrace();
	}}
	
public static void initiate()
{


	
	String browsername = prop.getProperty("browser");
	if(browsername.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver","C:\\chrome\\chromedriver.exe");
		driver = new ChromeDriver();}
	else if(browsername.equals("Firefox")) {
		System.setProperty("Webdriver.gecko.driver","C:\\geckodriver.exe");
	}
	
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	

	

	

}}
