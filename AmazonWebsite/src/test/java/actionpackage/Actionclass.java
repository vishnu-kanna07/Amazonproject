package actionpackage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.BaseAmazonClass;
import homepackage.Homepage;
import testLayer.LoginTest;

public class Actionclass  extends BaseAmazonClass {
	public static String Logintest;
	
	WebElement signIn;
	public Actionclass() {

		PageFactory.initElements(driver,this);
	}
	

	public String actionclick(WebDriver driver, LoginTest loginTest2)
	{
		Actions action = new Actions(driver);
		action.moveToElement(signIn).build().perform();
		
		return Logintest;
	
	}
	

	}
	


