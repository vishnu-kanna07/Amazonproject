package orderpackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import addresspage.Addresspage;
import basepackage.BaseAmazonClass;

public class Orderpage  extends BaseAmazonClass {
	
	//@FindBy(css="#a-page > div.a-container > div > div:nth-child(3) > div:nth-child(1) > a > div > div > div > div.a-column.a-span9.a-span-last > h2")WebElement Address;
		Actions actions = new Actions(driver); 
		@FindBy(css="#nav-link-accountList")
		WebElement Account;
	   
		@FindBy(css="#a-page > div.a-container > div > div:nth-child(2) > div:nth-child(1) > a > div > div > div > div.a-column.a-span9.a-span-last > h2")WebElement Yourorder;
	
	@FindBy(css="#a-page > section > div > div.a-section.a-spacing-medium.page-tabs > ul > li:nth-child(2) > a")
	WebElement BuyAgain;
	@FindBy(css="#a-page > section > div > div.a-section.a-spacing-medium.page-tabs > ul > li:nth-child(3) > a")
	WebElement NotYetShipped;
	@FindBy(css="#a-page > section > div > div.a-section.a-spacing-medium.page-tabs > ul > li:nth-child(4) > a")
	WebElement CancelledOrders;
	public void act() throws InterruptedException {
		
		 actions.moveToElement(Account).build().perform();
		   Thread.sleep(2000);
		   
		 actions.moveToElement(Yourorder).click().build().perform();
		  Thread.sleep(2000);
		   
	}
	
	
	
	public Orderpage()
	
	
	{
		
		
		PageFactory.initElements(driver,this);
	}
	public void ClickonYourorders() throws InterruptedException
	{
		Yourorder.click();
		
	}
		
	public void ClickonBuyAgain() 
	{
		BuyAgain.click();
	
		
	}
	
	
	public void ClickonCancelledOrders()
	{
		CancelledOrders.click();
		
	}
	public void ClickonNotYetShipped()
	{
		NotYetShipped.click();
	

	}
    		


}
