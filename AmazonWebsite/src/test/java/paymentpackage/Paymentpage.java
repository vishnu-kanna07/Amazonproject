package paymentpackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.BaseAmazonClass;

public class Paymentpage extends BaseAmazonClass {
	//@FindBy(css="#a-page > div.a-container > div > div:nth-child(3) > div:nth-child(1) > a > div > div > div > div.a-column.a-span9.a-span-last > h2")WebElement Address;
	Actions actions = new Actions(driver); 
	@FindBy(css="#nav-link-accountList")
	WebElement Account;
@FindBy(css ="#nav-al-your-account > a:nth-child(2) > span") WebElement YourAccount;
@FindBy(css="#a-page > div.a-container > div > div:nth-child(3) > div:nth-child(2) > a > div > div > div > div.a-column.a-span9.a-span-last > h2")WebElement Payment;

	public Paymentpage ()
	{

		PageFactory.initElements(driver,this);
	}
	public void act() throws InterruptedException {
		
		 actions.moveToElement(Account).build().perform();
		   Thread.sleep(2000);
		   actions.moveToElement(YourAccount).click().build().perform();
		   Thread.sleep(2000);	
		 actions.moveToElement(Payment).click().build().perform();
		  Thread.sleep(2000);
		   
	}
	
	public void Clickonpayment() throws InterruptedException 
	{
		Payment.click();
		Thread.sleep(2000);
	
		
	}
	


}
