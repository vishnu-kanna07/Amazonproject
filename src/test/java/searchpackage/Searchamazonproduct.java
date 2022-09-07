package searchpackage;

import java.awt.Desktop.Action;
import java.util.List;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.BaseAmazonClass;

public class Searchamazonproduct extends BaseAmazonClass{
	
	 Actions action=new Actions(driver);

		@FindBy(id="twotabsearchtextbox")
		WebElement searchbox;
		@FindBy(id="nav-search-submit-button")WebElement clicksearch;
		//String image="2";

@FindBy(xpath="//*[@id=\"anonCarousel3\"]/ol/li[2]/div/div/div[2]/div/div[1]/div/span/a/div/img")WebElement Productimage;
		public Searchamazonproduct()
		{

			PageFactory.initElements(driver,this);
		}
		
		public void productsearchbox(String sb) throws InterruptedException
		{
			searchbox.sendKeys(sb);
			clicksearch.click();
			//JavascriptExecutor executor =(JavascriptExecutor) driver;
			//executor.executeScript("window.scrollBy(0,1500)");
			/*String image ="2";
		//	WebElement searchingimage = driver.findElement(By.xpath("//*[@id=\"anonCarousel3\"]/ol/li["+image+"]/div/div/div[2]/div/div[1]/div/span/a/div/img"));
			Productimage.click();
			Thread.sleep(2000);*/
					
		}
		public void productsearchbox2(String keywords) throws InterruptedException
		{
			searchbox.sendKeys(keywords);
			clicksearch.click();
			//JavascriptExecutor executor =(JavascriptExecutor) driver;
			//executor.executeScript("window.scrollBy(0,1500)");
			/*String image ="2";
		//	WebElement searchingimage = driver.findElement(By.xpath("//*[@id=\"anonCarousel3\"]/ol/li["+image+"]/div/div/div[2]/div/div[1]/div/span/a/div/img"));
			Productimage.click();
			Thread.sleep(2000);*/
					
		}
	
		
		public void getNthproductnumber(int productnumber) throws InterruptedException {
			String xpath=String.format("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]",productnumber);
			//Thread.sleep(2000);
			String Nthproductnumber=driver.findElement(By.xpath(xpath)).getText();
			System.out.print(Nthproductnumber);
		
		}
		public void scrollby(int x,int y)
		
		{
			JavascriptExecutor jsEngine =  (JavascriptExecutor) driver;
			String jscommand = String.format("window.scrollBy(%d,%d)",x,y);
			jsEngine.executeScript(jscommand);
			
		}
		
		
		
	public void getAllProducts()
	{
		List<WebElement> allproducts =  driver.findElements(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]"));
	
	
	Iterator<WebElement> iteratorAllproducts =allproducts.iterator();
int productlocationx,productLocationY;
	
	while(iteratorAllproducts.hasNext())
	{
		WebElement product = iteratorAllproducts.next();
		productlocationx = product.getLocation().x;
		productLocationY = product.getLocation().y;
		scrollby(productlocationx,productLocationY);
		
		//action.moveToElement(product).build().perform();
		System.out.println(product.getText());
		
	}

	
	
	}
	        
		}

	
	
		

		
		


