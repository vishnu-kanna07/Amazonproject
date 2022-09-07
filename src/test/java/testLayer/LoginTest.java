package testLayer;

import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import addresspage.Addresspage;
import basepackage.BaseAmazonClass;
import homepackage.Homepage;
import lastamazonwebsite.AddToCartPage;
import orderpackage.Orderpage;
import paymentpackage.Paymentpage;
import pompackage.PomLogin;
import removeitempackage.Removeitemfromcart;
import searchpackage.Searchamazonproduct;
import sortingmodule.Sortingclass;


public class LoginTest extends BaseAmazonClass {
	
PomLogin log;
Homepage Home;
Orderpage Order;
Addresspage address;
Paymentpage payment; 
Searchamazonproduct search;
Sortingclass sort;
Sortingclass filter;
AddToCartPage cartmodule;
Removeitemfromcart removeitem;


	public LoginTest() 
	{
		super();
	}
	
	@BeforeMethod
	
	public void initsetup() throws InterruptedException  {
		initiate();
		log = new PomLogin();	
        Thread.sleep(2000);
		Home = log.login(prop.getProperty("Username"),prop.getProperty("Mobilenumberoremail"),prop.getProperty("Password"),prop.getProperty("Passwordagain"));
		Home.act();
	    Thread.sleep(2000);
	}
	
	
	
	@Test(priority=1)
	
	public  void title()
	{
		String actual = log.verify();
		System.out.println(actual);
		AssertJUnit.assertEquals(actual,"Your Account");
	}
	
	
	@Test(priority=2)
	public void  ValidateIMG()
	{
		boolean flag=log.ValidateIMG(); 
		AssertJUnit.assertTrue(flag);
	}
	
	
	
	@Test(priority=3)
	public void testclickonyouroders() throws InterruptedException
	{
		Order=new Orderpage();
	
 Order.ClickonYourorders();
  

	}
	
	
	
	@Test(priority=4)
	
	public void testBuyagain() throws InterruptedException 
	{
		Order=new Orderpage();
		Order.ClickonYourorders();	
	    Order.ClickonBuyAgain();
	   // Thread.sleep(2000);
	}
  
	
	@Test(priority=5)
public void testNotYetShipped() throws InterruptedException 
{

	Order=new Orderpage();
	Order.ClickonYourorders();
	Order.ClickonNotYetShipped();
   // Thread.sleep(2000);
}
  
@Test(priority=6)
   public void testcancelledorders() throws InterruptedException 
{

	Order=new Orderpage();
	Order.ClickonYourorders();
	Order.ClickonCancelledOrders();
   // Thread.sleep(2000);
}
	
@Test(priority=7)
   public void testClickonaddress() throws InterruptedException
    {
    address = new Addresspage();
	address.Clickonaddress();

    }
@Test(priority=8)
	public void testClickonpayment() throws InterruptedException
	{
	//address=new Addresspage();

	payment = new Paymentpage();
    payment.Clickonpayment();

	}
@Test(priority=9)
	public void testsearch() throws InterruptedException 
	{
	
	search = new Searchamazonproduct();
	Thread.sleep(2000);
	
	search.productsearchbox(prop.getProperty("product"));
	search.getNthproductnumber(4);
	search.scrollby(0, 1500);
	search.getAllProducts();
	
}
@Test(priority=10)
public void testsorting() throws InterruptedException

{

search = new Searchamazonproduct();
search.productsearchbox(prop.getProperty("product"));
search.getNthproductnumber(4);
search.scrollby(0, 1500);
search.getAllProducts();

sort = new  Sortingclass();

search = new Searchamazonproduct();
search.productsearchbox(prop.getProperty("product"));
sort.sorting();
}

@Test(priority =11)

public void testfiltering() throws InterruptedException
{
	search = new Searchamazonproduct();
	search.productsearchbox(prop.getProperty("product"));
	filter=new Sortingclass();
	filter.filterion();
	//filter.pagination();
			
}
@Test(priority =12)
public void testpagination() throws InterruptedException
{
	search = new Searchamazonproduct();
	search.productsearchbox(prop.getProperty("product"));
	filter=new Sortingclass();
	filter.pagination();
}
@Test(priority=13)
public void testcatmodule() throws InterruptedException
{
	search = new Searchamazonproduct();
	search.productsearchbox(prop.getProperty("product"));
	cartmodule = new AddToCartPage();
	cartmodule. Addoneitemtothecart();
	
}
@DataProvider(name="getdata")
public Object[][] multipleelements(){
	 return new Object[][] {{"Tylenol"},{"advil"}};
	
}
@Test(dataProvider="getdata")
public void display(String Keywords) throws InterruptedException
{

	search = new Searchamazonproduct();
	search.productsearchbox2(Keywords);
	cartmodule = new AddToCartPage();
	cartmodule.Addmultipleitemtothecart();
Thread.sleep(5000);
}
@Test(priority=14)
public void testremoveitem() throws InterruptedException
{
	removeitem = new Removeitemfromcart(); 
	removeitem.removeitemfromcart();
}
@Test(priority=15)
public void testremoveallitemfromcart() throws InterruptedException
{
	removeitem = new Removeitemfromcart(); 
	removeitem.RemoveAllItemFromcart();
}
@Test(priority=16)
public void testclickonadditem() throws InterruptedException
{
	removeitem = new Removeitemfromcart(); 
	removeitem.clickonitemcart();
}
@Test(priority=17)
public void testReopenTheSamesite() throws InterruptedException
{
	removeitem = new Removeitemfromcart(); 
	removeitem.ReopenTheSamesite();
}

	@AfterMethod
	 
	public void close()
	{
		driver.close();
	}
		
		
	}


