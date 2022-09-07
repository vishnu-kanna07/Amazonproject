package removeitempackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import basepackage.BaseAmazonClass;

public class Removeitemfromcart extends BaseAmazonClass {
	
	
	@FindBy(xpath=("//*[@id=\"nav-cart\"]")) WebElement Cartsymbol;
	@FindBy(xpath=("//*[@id=\"sc-subtotal-amount-activecart\"]")) WebElement TotalPrice;
	//@FindBy(className=("a-declarative")) WebElement deletebutton;
	@FindBy(xpath = "//input[contains(@name,'submit.delete.Cb60b37b8-082f-46ff-b9ca-8c48320f88f7')]")WebElement deletebutton;
	@FindBy(id = "nav-cart-count-container")WebElement cartitem;
	@FindBy(className="a-row sc-cart-header sc-compact-bottom")WebElement yourcarrtempty;
	//@FindBy(xpath = "//h1[@class='a-spacing-mini a-spacing-top-base'][contains(.,'Your Amazon Cart is empty.')]")
	@FindBy(xpath="//*[@id=\"sc-item-Cb0ac8f6f-a8d4-4aa1-8672-a9a8c5dca161\"]/div[4]/div/div[1]/div/div/div[2]/div[1]/span[2]/span/input")WebElement deletebutton2;
	@FindBy(xpath="//*[@id=\"sc-item-Cb98857e8-0f22-488a-a2b1-0445829441ff\"]/div[4]/div/div[1]/div/div/div[2]/ul/li[1]/span/a")WebElement clickoniteminthecart;
	@FindBy(css="#cart-item-recs > div > div > div > div > div > ul > li:nth-child(1) > span > div > div > div.a-fixed-left-grid-col.a-col-right > a")WebElement addtotheotherelement;
	public  Removeitemfromcart()
	{
	
	
		PageFactory.initElements(driver,this);
	}
	
	
	public void removeitemfromcart() throws InterruptedException
	{
		Cartsymbol.click();
		TotalPrice.click();
		System.out.println("Beforedeleting the item total price in the cart is :" +TotalPrice.getText());
		deletebutton.click();
		System.out.println("Item is removed froim the cart");
		System.out.println("After deleting the item total price in the cart is :" +TotalPrice.getText());
		
		
	}
	
	
	public void RemoveAllItemFromcart() {

		int cartitem = 0;
		int i=0;
		Cartsymbol.click();
		System.out.println("Before deleting the item total price in the cart is :" +TotalPrice.getText());
		deletebutton2.click();
	
		do
			{
	
		String actual =  yourcarrtempty.getText();
		
		System.out.println("After deleting all item car is empty" + actual);
		
				Assert.assertEquals(actual, "Your Amazon cart is empty");
		        i--;
			} while(i<=cartitem);			    
}	

public void clickonitemcart()
{	
	Cartsymbol.click();
	
	clickoniteminthecart.click();
	String tittle=
			clickoniteminthecart.getText();

if(tittle!=null)
{
	System.out.println("the item in the cart is :" +tittle);
}
else
	
{
	System.out.println("The cart is empty");
	}
}

	
public void ReopenTheSamesite() throws InterruptedException
{
	
	driver.get("https://www.amazon.ca/");
	String tittle = driver.getTitle();
	System.out.println(tittle);
	WebElement tabbedWindow = driver.findElement(By.id("nav-cart-count-container"));
	tabbedWindow.click();
	Thread.sleep(5000);
	tittle=driver.getTitle();
	System.out.println("tittle of te window is: " + tittle);
	
	
	/*Cartsymbol.click();
	Thread.sleep(5000);
	addtotheotherelement.click();
	Thread.sleep(5000);
	driver.navigate().refresh();

	Cartsymbol.click();*/
	
}
		
}
	
	


