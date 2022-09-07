package homepackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import addresspage.Addresspage;
import basepackage.BaseAmazonClass;
import orderpackage.Orderpage;
import paymentpackage.Paymentpage;

public class Homepage extends BaseAmazonClass {
	Actions actions = new Actions(driver); 
	@FindBy(css="#nav-link-accountList")
	WebElement Account;
	@FindBy(css ="#nav-al-your-account > a:nth-child(2) > span") WebElement YourAccount;

	@FindBy(id="nav-link-accountList-nav-line-1")WebElement usernamelabel;

	@FindBy(css="#a-page > div.a-container > div > div:nth-child(3) > div:nth-child(1) > a > div > div > div > div.a-column.a-span9.a-span-last > h2")WebElement Address;

	@FindBy(css="#a-page > div.a-container > div > div:nth-child(3) > div:nth-child(2) > a > div > div > div > div.a-column.a-span9.a-span-last > h2")WebElement Payment;

	
	/*@FindBy(xpath="//a[text()='Buy Again']")
	WebElement BuyAgain;
	@FindBy(xpath="//a[contains(text(),'Not Yet Shipped')]")
	WebElement NotYetShipped;
	@FindBy(xpath="//a[contains(text(),'Cancelled Orders')]")
	WebElement CancelledOrders;*/


	public Homepage() {

		PageFactory.initElements(driver,this);
	}
	
	//Your account and list;
	
	public void act() throws InterruptedException {
	
		 actions.moveToElement(Account).build().perform();
		   Thread.sleep(2000);
		   actions.moveToElement(YourAccount).click().build().perform();
		   Thread.sleep(2000);	
		
		

		
	}
	public String getuserNameLabel()
	{
		
		return usernamelabel.getText();
	}
	public boolean verifyuserNameLabel()
	{
		return usernamelabel.isEnabled();
	}

	
	public String verify()
	{
		return driver.getTitle();
	
	}
	
	/*public Orderpage ClickonYourorders()
	{
		YourAccount.click();

	
		return new Orderpage();
	
	}*/
	
	}


