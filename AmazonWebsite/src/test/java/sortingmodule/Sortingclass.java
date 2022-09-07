package sortingmodule;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import basepackage.BaseAmazonClass;

public class Sortingclass extends BaseAmazonClass {
	//@FindBy(xpath="//*[@id=\"n/10287299011\"]/span/a/span")WebElement menstshirt;

	@FindBy(xpath="//i[@class='a-icon a-icon-star-medium a-star-medium-4'][contains(.,'4 Stars & Up')]")WebElement CustomerReview;
	@FindBy(xpath = "//*[@id=\"p_89/Honeywell\"]/span/a/div/label/i")WebElement HoneyWell;
	

	//@FindBy(xpath="//*[@id=\"p_89/Gildan\"]/span/a/span")WebElement gilden;
	//@FindBy(xpath ="//div[@class='s-result-list-placeholder aok-hidden sg-row']\")") WebElement productpage;
	public Sortingclass() {

		PageFactory.initElements(driver,this);
	}
	
	public void sorting() throws InterruptedException 
	{
		List<WebElement> Beforefilterprice = driver.findElements(By.className("a-price-whole"));
		List<Double> beforeSortPriceList = new ArrayList<>();
		for(WebElement p : Beforefilterprice)
		{
			beforeSortPriceList.add(Double.valueOf(p.getText().replace( "$", " ")));
		}
	
	
	Select dropdown = new Select(driver.findElement(By.id("s-result-sort-select")));
	dropdown.selectByVisibleText("Price: Low to High");
List<WebElement> afterFilterPrice = driver.findElements(By.className("a-price-whole"));
List<Double> afterFilterPriceList =new ArrayList<>();
for(WebElement p : afterFilterPrice) 
{
	afterFilterPriceList.add(Double.valueOf(p.getText().replace( "$", " ")));
}
	Collections.sort(beforeSortPriceList);
	Assert.assertNotEquals(beforeSortPriceList, afterFilterPriceList);
	System.out.print( afterFilterPrice);
		Thread.sleep(2000);
		//driver.quit();
}
	
	
	
public void filterion() throws InterruptedException
{
	CustomerReview.click();

List<WebElement> elementslist = driver.findElements(By.xpath("/html/body/div[1]/div[2]/span/div/h1/div/div[1]/div/div/span[1]"));
	
	List<String> originalList = elementslist.stream().map(s->s.getText().split(" ")[2]).collect(Collectors.toList());
	
	
	int size = originalList.size();

		  
	    for(int i=0;i<size;i++)
	    {
	    	System.out.println("Total before filtered ProductCount is "+ originalList.get(i));
	
	    	
	    }
	    
	
}
	
  
public void pagination() throws InterruptedException
  {
	WebElement nextButton = driver.findElement(By.xpath("//a[contains(@aria-label,'Go to next page, page 2')] "));
	JavascriptExecutor js =(JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,10000)");
	
	List<WebElement> products = driver.findElements(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]"));
	
	List<String> productNames = new ArrayList();
	for(WebElement names: products)
	{
		 productNames.add(names.getText());
		 System.out.println(names.getText()); 
	}  
	
	System.out.println("**** ");
	while(true)
	{
		nextButton.click();
		//js.executeScript("window.scrollby(0,10000)");
		 products = driver.findElements(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]"));
		 
		//div[@data-index='1'div[5]//div[4]//div[3]//div[2]//div[1]//h2//a[@class="a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal"//span[@class="a-size-medium a-color-base a-text-normal]"
	
		 for(WebElement names: products)
			{
				 productNames.add(names.getText());
				 System.out.println(names.getText()); 
			}
			
		 System.out.println("**** ");
	
	
	try {
	
		 nextButton = driver.findElement(By.className("s-pagination-item s-pagination-next s-pagination-disabled "));
	
	}
	catch(Exception e) {
		System.out.println("No more duplicate  Products are available");
		break;
		}
	}
	System.out.println("My Number of products are:"+productNames.size());
  }
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

  
	

	



	 
	
		
	
	
	
	
	
	
	



